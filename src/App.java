import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Alô, Git");
        //classe é um conjunto de objetos  
        //nosso objetivc nesse codigo é entender a diferença 
        //entre método com o tipo você e método com o tipo string  
        Mamifero m1 = new Mamifero();
        Mamifero m2 = new Mamifero();
        Mamifero m3 = new Mamifero();
    


        m1.setNomeCientifico("Bos Taurus");
        JOptionPane.showMessageDialog(null,"nome Cientifico:"+m1.getNomeCientifico());


        m2.setNomeCientifico("canguru");
        JOptionPane.showMessageDialog(null,"nome Cientifico:"+m2.getNomeCientifico());

        m3.setNomeCientifico("peixe boi ");
        JOptionPane.showMessageDialog(null,"nome Cientifico:"+m3.getNomeCientifico());











    }
}




        //Exercicios
        /*
         * Considerando a utilização de métodos set e get 
         * Considerando a aula de hoje
         * anatomia entre função e procedimento
         * set - void procedimento 
         * get - String , int , boolean
         * 
         * Desafio:
         * crie mais dois objetos 
         * para amazenar e mostra os dados do 
         * canguru 
         * peixe boi 
         */
