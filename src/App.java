import javax.swing.JOptionPane;

public class App{
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Ola, Jardim! \n Seja bem-vindo!");

        String name = JOptionPane.showInputDialog("Digite seu nome!");
        String endereco = JOptionPane.showInputDialog("Pode informar o seu endereco?");


        String larguraStr = JOptionPane.showInputDialog("Quanto e a largura do seu jardim?");
        String comprimentoStr = JOptionPane.showInputDialog("Qual o comprimento do seu jardim?");


        double largura = Double.parseDouble(larguraStr.replace(",", "."));
        double comprimento = Double.parseDouble(comprimentoStr.replace(",", "."));
        double area = largura * comprimento;

        String resultado = String.format("A area do jardim e %.2f metros quadrados.", area);
        JOptionPane.showMessageDialog(null, resultado);
    }
}