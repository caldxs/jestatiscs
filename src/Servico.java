public class Servico {
    private String nomeServico;
    private double preco;

    public Servico(String nomeServico, double preco) {
        this.nomeServico = nomeServico;
        this.preco = preco;
    }

    public double aplicarDesconto(double percentual) {
        double desconto = preco * (percentual / 100);
        return preco - desconto;
    }
}



