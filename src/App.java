import javax.swing.JOptionPane;


public class App {
    public static void main(String[] args) {
       
        String larguraStr = JOptionPane.showInputDialog("Quanto e a largura do seu jardim?");
        String comprimentoStr = JOptionPane.showInputDialog("Qual o comprimento do seu jardim?");

        double largura = Double.parseDouble(larguraStr.replace(",", "."));
        double comprimento = Double.parseDouble(comprimentoStr.replace(",", "."));
        double area = largura * comprimento;

        String classificacao;
        if (area >= 100) {
            classificacao = "Grande";
        } else {
            classificacao = "Pequeno";
        }

        String resultado = String.format(
            "A area do jardim e %.2f metros quadrados.\nO jardim e classificado como: %s.", 
            area, classificacao
        );

        JOptionPane.showMessageDialog(null, resultado);

        String codigoStr = JOptionPane.showInputDialog( "Informe o codigo do servico: \n 1 - Jardinagem, \n 2 -solo, \n 3 - Limpeza:"
        );

        int codigo = Integer.parseInt(codigoStr);
        String descricao;

        switch (codigo) {
            case 1:
                descricao = "Servico de Jardinagem: \n cuidado e manutencao de jardins.";
                break;
            case 2:
                descricao = "Servico de Preparação do solo: \n  adubar e melhorar a qualidade do solo .";
                break;
            case 3:
                descricao = "Servico de Limpeza: \n remover folhas secas, residuos, limpar caminhos e areas pavimentadas. .";
                break;
            default:
                descricao = " Nenhum servico selecionado";
        }

        JOptionPane.showMessageDialog(null, descricao);

        String quantidadeStr = JOptionPane.showInputDialog(
            "Informe quantos servico que esta querendo:"
        );

        int quantidade = Integer.parseInt(quantidadeStr);
        double desconto;

        if (quantidade >= 5) {
            desconto = 10.0; // 
        } else if (quantidade >= 3) {
            desconto = 10.0; // 
        } else {
            desconto = 5.0; 
        }

        String mensagem = String.format(
            "Voce solicitou %d servicos.\nDesconto valido de: %.0f%%.", 
            quantidade, desconto
        );

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
