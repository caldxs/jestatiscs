import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String endereco = JOptionPane.showInputDialog("Digite o endereCo do cliente:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");

        Cliente cliente = new Cliente(nome, endereco, telefone);
        JOptionPane.showMessageDialog(null, "Dados do Cliente:\n" + 
                                            "Nome: " + nome + "\n" +
                                            "Endereço: " + endereco + "\n" +
                                            "Telefone: " + telefone);

        double comprimento = Double.parseDouble(JOptionPane.showInputDialog("Digite o comprimento do jardim (em metros):"));
        double largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura do jardim (em metros):"));

        Jardim jardim = new Jardim(comprimento, largura);
        double area = jardim.calcularArea();

        JOptionPane.showMessageDialog(null, "Area do Jardim: " + area + " m²");

        String nomeServico = JOptionPane.showInputDialog("Digite o nome do servico:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do servico:"));

        Servico servico = new Servico(nomeServico, preco);
        double percentualDesconto = Double.parseDouble(JOptionPane.showInputDialog("Digite o percentual de desconto:"));
        double valorComDesconto = servico.aplicarDesconto(percentualDesconto);

        JOptionPane.showMessageDialog(null, "Servico: " + nomeServico + "\n" + 
                                            "Valor com desconto: R$ " + String.format("%.2f", valorComDesconto));        
        cliente.exibir();
        JOptionPane.showMessageDialog(null,  "Nome:" + nome + "\n" + 
        "Endereco:" + endereco + "\n" +
        "Telefone:" + telefone + "\n"+ 
        "Area do Jardim: " + area+"m²"+"\n"+
        "Desconto: "+"-"+percentualDesconto+"R$"+ "\n"+
        "Valor do Servico: R$" + valorComDesconto);                                    
}
                                                       
}
