import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.cadastrarDados();

        Jardim[] jardins = cadastrarJardins();
        double somaArea = calcularAreaTotal(jardins);

        int totalServicos = 0;
        double somaServicos = 0;
        Servico[] servicosContratados = new Servico[100];
        int servicosIndex = 0;

        while (true) {
            Servico servico = escolherServico();
            if (servico != null) {
                servicosContratados[servicosIndex++] = servico;
                somaServicos += servico.getValor();
                totalServicos++;
            }

            int loop = JOptionPane.showConfirmDialog(null, "Deseja contratar mais serviços?");
            if (loop != JOptionPane.YES_OPTION) {
                break;
            }
        }

        mostrarFrequenciaServicos(servicosContratados, totalServicos);

        double desconto = calcularDesconto(somaServicos);
        double totalComDesconto = somaServicos - desconto;

        gerarRelatorioFinal(cliente, jardins, somaArea, totalServicos, somaServicos, desconto, totalComDesconto);
        
        // Estatísticas Descritivas
        estatisticasDescritivas(jardins, somaArea);
    }

    private static Jardim[] cadastrarJardins() {
        Jardim[] jardins = new Jardim[100];
        int indice = 0;
        while (true) {
            double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Comprimento do Jardim: "));
            double largura = Double.parseDouble(JOptionPane.showInputDialog("Largura do Jardim: "));
            Jardim jardim = new Jardim(comprimento, largura);
            jardins[indice++] = jardim;

            int loop = JOptionPane.showConfirmDialog(null, "Deseja Adicionar mais um Jardim?");
            if (loop != JOptionPane.YES_OPTION) {
                break;
            }
        }
        return Arrays.copyOf(jardins, indice);
    }

    private static double calcularAreaTotal(Jardim[] jardins) {
        double somaArea = 0;
        for (Jardim jardim : jardins) {
            somaArea += jardim.getArea();
        }
        return somaArea;
    }

    private static Servico escolherServico() {
        int servicoEscolhido = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha o serviço:\n1-Irrigação R$350\n2-Limpeza de Jardim R$120\n3-Podas Especiais R$200\n4-Paisagismo R$450\n5-Sair"));
        
        switch (servicoEscolhido) {
            case 1: return new Servico("Irrigação", 350);
            case 2: return new Servico("Limpeza de Jardim", 120);
            case 3: return new Servico("Podas Especiais", 200);
            case 4: return new Servico("Paisagismo", 450);
            default: return null;
        }
    }

    private static void mostrarFrequenciaServicos(Servico[] servicosContratados, int totalServicos) {
        int qtdIrrigacao = 0, qtdLimpeza = 0, qtdPodasEspeciais = 0, qtdPaisagismo = 0;
        for (Servico servico : servicosContratados) {
            if (servico == null) break;

            switch (servico.getNome()) {
                case "Irrigação": qtdIrrigacao++; break;
                case "Limpeza de Jardim": qtdLimpeza++; break;
                case "Podas Especiais": qtdPodasEspeciais++; break;
                case "Paisagismo": qtdPaisagismo++; break;
            }
        }

        JOptionPane.showMessageDialog(null, 
            String.format("Frequência de Serviços Contratados:\nIrrigação: %.2f%%\nLimpeza de Jardim: %.2f%%\nPodas Especiais: %.2f%%\nPaisagismo: %.2f%%", 
                          (double) qtdIrrigacao / totalServicos * 100,
                          (double) qtdLimpeza / totalServicos * 100,
                          (double) qtdPodasEspeciais / totalServicos * 100,
                          (double) qtdPaisagismo / totalServicos * 100)
        );
    }

    private static double calcularDesconto(double somaServicos) {
        return somaServicos * 0.20;
    }

    private static void gerarRelatorioFinal(Cliente cliente, Jardim[] jardins, double somaArea, int totalServicos, double somaServicos, double desconto, double totalComDesconto) throws IOException {
        String relatorio = cliente.gerarRelatorio(jardins, somaArea, totalServicos, somaServicos, desconto, totalComDesconto);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("RelatorioFinal.txt"), StandardCharsets.UTF_8))) {
            writer.write(relatorio);
            JOptionPane.showMessageDialog(null, "Relatório Final salvo no arquivo 'RelatorioFinal.txt'.");
        }
    }

    private static void estatisticasDescritivas(Jardim[] jardins, double somaArea) {
        double mediaArea = somaArea / jardins.length;

        // Moda (valor mais frequente)
        double moda = 0;
        int maiorFrequencia = 0;
        for (int i = 0; i < jardins.length; i++) {
            int frequencia = 0;
            for (int j = 0; j < jardins.length; j++) {
                if (Math.round(jardins[i].getArea()) == Math.round(jardins[j].getArea())) {
                    frequencia++;
                }
            }
            if (frequencia > maiorFrequencia) {
                maiorFrequencia = frequencia;
                moda = jardins[i].getArea();
            }
        }

        // Mediana
        double[] areasOrdenadas = new double[jardins.length];
        for (int i = 0; i < jardins.length; i++) {
            areasOrdenadas[i] = jardins[i].getArea();
        }
        Arrays.sort(areasOrdenadas);
        double mediana;
        if (jardins.length % 2 == 0) {
            mediana = (areasOrdenadas[jardins.length / 2 - 1] + areasOrdenadas[jardins.length / 2]) / 2;
        } else {
            mediana = areasOrdenadas[jardins.length / 2];
        }

        // Máximo e Mínimo
        double maximo = areasOrdenadas[areasOrdenadas.length - 1];
        double minimo = areasOrdenadas[0];

        // Mostrar resultados
        JOptionPane.showMessageDialog(null, String.format("Estatísticas Descritivas\nMédia: %.2f m²\nModa: %.2f m²\nMediana: %.2f m²\nMáximo: %.2f m²\nMínimo: %.2f m²", mediaArea, moda, mediana, maximo, minimo));
    }
}

class Jardim {
    private double comprimento;
    private double largura;

    public Jardim(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double getArea() {
        return comprimento * largura;
    }
}

class Servico {
    private String nome;
    private double valor;

    public Servico(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}

class Cliente {
    private String nome;
    private String endereco;

    public void cadastrarDados() {
        this.nome = JOptionPane.showInputDialog("Informe seu nome:");
        this.endereco = JOptionPane.showInputDialog("Informe seu endereço:");
    }

    public String gerarRelatorio(Jardim[] jardins, double somaArea, int totalServicos, double somaServicos, double desconto, double totalComDesconto) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Nome: ").append(nome).append("\n")
                 .append("Endereço: ").append(endereco).append("\n")
                 .append("Total de Jardins: ").append(jardins.length).append("\n")
                 .append("Área Total: ").append(somaArea).append(" m²\n")
                 .append("Serviços Contratados: ").append(totalServicos).append("\n")
                 .append("Valor Total dos Serviços: R$ ").append(somaServicos).append("\n")
                 .append("Desconto: R$ ").append(desconto).append("\n")
                 .append("Total com Desconto: R$ ").append(totalComDesconto).append("\n");

        return relatorio.toString();
    }
}
