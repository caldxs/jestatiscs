import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        double areaJardim=0, comprimento, largura;
        double somaArea =0;
        int areas=0;
        int areasGrandes=0, areasPequenas=0;
        double[] areasCalculadas = new double[100];
        String[] tiposDeArea = new String[100]; 
        int indice = 0, soma=0,contServ=0;
        String todasAreas = "";
        String desconto="";
        String nome = JOptionPane.showInputDialog("Prezado Cliente \nInforme seus Dados\nNome:");
        String endereco = JOptionPane.showInputDialog("Endereço:");
        while (true) {
            comprimento = Double.parseDouble(JOptionPane.showInputDialog(null,"Comprimento do Jardim: "));
            largura = Double.parseDouble(JOptionPane.showInputDialog(null,"Largura do Jardim: "));
            areas++;
            String[] tamanho = {"Pequeno","Grande"};
            areaJardim = comprimento*largura;

            areasCalculadas[indice] = areaJardim;
            indice++;
            
            if (areaJardim < 100) {
                JOptionPane.showMessageDialog(null, "Area do Jardim: "+areaJardim+"\nTamanho: "+tamanho[0]);
                areasPequenas++;
                tiposDeArea[indice - 1] = tamanho[0];
            }else {
                JOptionPane.showMessageDialog(null, "Area do Jardim: "+areaJardim+"\nTamanho: "+tamanho[1]);
                areasGrandes++;
                tiposDeArea[indice - 1] = tamanho[1];
            }
            somaArea = somaArea + areaJardim;
            int loop = JOptionPane.showConfirmDialog(null, "Deseja Adicionar mais um Terreno? ");
            if (loop != JOptionPane.YES_OPTION) {     
                break;
            }

        }
        int qtdAdubacao = 0, qtdPoda = 0, qtdManutencao = 0, qtdPlantio = 0;
        while (true) {
            int servico = Integer.parseInt(JOptionPane.showInputDialog("Qual Serviço Deseja Contratar:\n1-Adubação R$300,00\n2-Poda R$150,00\n3-Manutenção R$90,00\n4-Plantio R$400,00\n5-Sair"));
            if (servico!=5) {
             contServ++;
            }else{
             break;
            }
             String escolhido = "";
             switch (servico) {
                 case 1: escolhido = "Adubação"; soma = soma + 300; qtdAdubacao++; break;
                 case 2: escolhido = "Poda"; soma = soma + 150; qtdPoda++; break;
                 case 3: escolhido = "Manutenção"; soma = soma + 90;qtdManutencao++; break;
                 case 4: escolhido = "Plantio"; soma = soma + 400;qtdPlantio++; break;
             }
             JOptionPane.showMessageDialog(null, "Serviço Contratado: "+escolhido);
             int loop = JOptionPane.showConfirmDialog(null, "Deseja contratar mais serviços?");
             if (loop != JOptionPane.YES_OPTION) {
                 break;
             }
        }
        double desc = 0.20 * soma;
        double descsoma = soma - desc;
        double freqAdubacao = (double) qtdAdubacao / contServ;
        double freqPoda = (double) qtdPoda / contServ;
        double freqManutencao = (double) qtdManutencao / contServ;
        double freqPlantio = (double) qtdPlantio / contServ;
        JOptionPane.showMessageDialog(null,
            "Frequência Relativa dos Serviços Contratados:\n" +
            "Adubação: " + String.format("%.2f", freqAdubacao * 100) + "%\n" +
            "Poda: " + String.format("%.2f", freqPoda * 100) + "%\n" +
            "Manutenção: " + String.format("%.2f", freqManutencao * 100) + "%\n" +
            "Plantio: " + String.format("%.2f", freqPlantio * 100) + "%"
        );
        
        Grafico grafico = new Grafico(
            "Gráfico de Serviços Contratados", 
            qtdAdubacao, 
            qtdPoda, 
            qtdManutencao, 
            qtdPlantio
        );
        
        grafico.setSize(800, 600);
        
        grafico.setLocationRelativeTo(null);

        grafico.setVisible(true);
        int fidel = JOptionPane.showConfirmDialog(null, "Possui Cadastro de Fidelidade na Empresa? ");
        String servcontratados = "\nServiço(s) Contratado(s):\nAdubação: "+qtdAdubacao+"\nPoda: "+qtdPoda+"\nManutenção: "+qtdManutencao+"\nPlantio: "+qtdPlantio;
        if (fidel == JOptionPane.YES_OPTION) {
            desconto = "Quantidade de Serviços Contratados: "+contServ+servcontratados+"\nValor Total: R$"+soma+"\nDesconto de: R$-"+desc+"\nValor Total com Desconto: R$"+descsoma;
        }else{
            desconto = "Quantidade de Serviços Contratados: "+contServ+servcontratados+"\nValor Total: R$"+soma;
        }
        JOptionPane.showMessageDialog(null, desconto);
        double mediaArea = somaArea/areas;
        double moda =0;
        int maiorFrequencia =0;
        for (int i = 0; i < indice; i++) {
            todasAreas += "Área " + (i+1) +" Tipo("+tiposDeArea[i]+")"+": "+areasCalculadas[i] +"m²"+"\n";
        }
        JOptionPane.showMessageDialog(null, todasAreas);
        for (int i = 0; i < areas; i++) {
            int frequencia=0;
            for (int j = 0; j < areas; j++) {
                if (Math.round(areasCalculadas[i]) == Math.round(areasCalculadas[j])) {
                    frequencia++;
                }
            }
            if (frequencia > maiorFrequencia) {
                maiorFrequencia =frequencia;
                moda =areasCalculadas[i];
            } 
        }
        double[] vetorOrdenado = Arrays.copyOf(areasCalculadas, areas);
        Arrays.sort(vetorOrdenado);
        double mediana;
        if (areas % 2 ==0) {
            mediana = (vetorOrdenado[areas / 2 - 1] + vetorOrdenado[areas / 2]) / 2;
        }else{
            mediana = vetorOrdenado[areas / 2];
        }
        double maximo = vetorOrdenado[areas-1];
        double minimo = vetorOrdenado[0];
        
        StringBuilder ordenadas = new StringBuilder();
        for (double area : vetorOrdenado) {
            ordenadas.append(String.format("%.2f", area)+"m²").append(" | ");
        }
        JOptionPane.showMessageDialog(null, "Moda das Áreas: " + String.format("%.2f", moda)+"m²");
        JOptionPane.showMessageDialog(null, ordenadas.toString()+"\nMediana: "+mediana+"m²");
        JOptionPane.showMessageDialog(null, "A média das Áreas: "+String.format("%.2f",mediaArea)+"m²"+"\nÁreas Grandes: "+areasGrandes+"\nÁreas Pequenas: "+areasPequenas+"\nValor Mínimo: "+minimo+"m²"+"\nValor Máximo: "+maximo+"m²");
        String relatorioFinal = "-----------------Relatório Final-----------------\nNome do Cliente: "+nome+"\nEndereço: "+endereco+"\n"+todasAreas+"\n"+desconto+
        "\nModa das Áreas: " + String.format("%.2f", moda)+"m²"+
        "\n"+ordenadas.toString()+"\nMediana: "+mediana+"m²"+
        "\nA média das Áreas: "+String.format("%.2f",mediaArea)+"m²"+"\nÁreas Grandes: "+areasGrandes+"\nÁreas Pequenas: "+areasPequenas+"\nValor Mínimo: "+minimo+"m²"+"\nValor Máximo: "+maximo+"m²"
        ;
        JOptionPane.showMessageDialog(null,relatorioFinal, "Relatório Final", JOptionPane.INFORMATION_MESSAGE);
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("RelatorioFinal.txt"), StandardCharsets.UTF_8))){
                    JOptionPane.showMessageDialog(null, "As Estatísticas do Jogo foram salvas no Arquivo RelatorioFinal.txt", "Obrigado por Jogar!", JOptionPane.INFORMATION_MESSAGE);
                    writer.write(relatorioFinal);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar gravar arquivos");
                }
    }
}