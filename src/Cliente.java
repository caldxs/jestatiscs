public class Cliente {
        private String nome;
        private String endereco;
        private String telefone;
    
        public Cliente(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }
    
        public void exibir() {
            System.out.println("Nome: " + nome);
            System.out.println("Endereço: " + endereco);
            System.out.println("Telefone: " + telefone);
        }
    }
    


