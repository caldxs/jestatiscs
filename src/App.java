import javax.swing.JOptionPane;

public class App {

    
    public static double calcularArea(double comprimento, double largura) {
        return comprimento * largura;
    }

    public static void mostrarInformacoes(String nome, String endereco, double area, String categoria) {
        JOptionPane.showMessageDialog(null, String.format("Proprietario: %s\nEndereCo: %s\nArea: %.2f m²\nCategoria: %s", nome, endereco, area, categoria));
    }

    public static double calcularMedia(double soma, int totalJardins) {
        return soma / totalJardins;
    }

    public static void main(String[] args) {
        double somaDasAreas = 0; 
        int totalJardins = 0; 
        int jardinsGrandes = 0; 

        while (true) {

            String nome = JOptionPane.showInputDialog("Qual o nome do proprietario?");
            String endereco = JOptionPane.showInputDialog("Informe o endereco do jardim:");


            double comprimento = 0, largura = 0;
            while (true) {
                try {
                    comprimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do jardim :"));
                    largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura do jardim :"));

                    if (comprimento <= 0 || largura <= 0) {
                        JOptionPane.showMessageDialog(null, "As medidas devem ser numeros positivos. Tente novamente.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores numericos validos.");
                }
            }

            double areaJardim = calcularArea(comprimento, largura);
            totalJardins++;

            String categoriaJardim = (areaJardim < 100) ? "Jardim Pequeno" : "Jardim Grande";
            if (areaJardim >= 100) {
                jardinsGrandes++;
            }

            mostrarInformacoes(nome, endereco, areaJardim, categoriaJardim);

            somaDasAreas += areaJardim;

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro jardim?", "Cadastro de Jardins", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.NO_OPTION) {
                break;
            }
        }

        double mediaDasAreas = calcularMedia(somaDasAreas, totalJardins);
        
        String mensagemFinal = String.format("Resumo Final:\n\nMedia das Areas: %.2f m²\nJardins Grandes: %d", mediaDasAreas, jardinsGrandes);
        JOptionPane.showMessageDialog(null, mensagemFinal);
    }
}
