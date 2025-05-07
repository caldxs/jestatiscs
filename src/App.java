import java.util.Random;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Jogo de lançamento de dados
        String[] espacoAmostral = {"1", "2", "3", "4", "5", "6"};

        Random random = new Random();
        // Contadores para verificar a distribuição
        int[] contagemDados = new int[6];
        String mensagem = " Vamos lancar um dado de 6 lados!\n"
                + "Cada face tem a mesma chance de sair, ou seja, 16.67% para cada numero.\n"
                + "O dado possui 6 faces numeradas de 1 a 6.\n"
                + "Deseja lancar o dado?";

        
        while (true) {
           
            int opcao = JOptionPane.showConfirmDialog(null, mensagem, "Lancando o dado", JOptionPane.YES_NO_OPTION);
            if (opcao != JOptionPane.YES_OPTION) {
                
                String estatistica = "Jogo finalizado! \n" + "Total de lancamentos: " + getTotalLances(contagemDados) + "\n"
                        + "Distribuicao dos lancamentos:\n"
                        + "1: " + contagemDados[0] + "\n"
                        + "2: " + contagemDados[1] + "\n"
                        + "3: " + contagemDados[2] + "\n"
                        + "4: " + contagemDados[3] + "\n"
                        + "5: " + contagemDados[4] + "\n"
                        + "6: " + contagemDados[5];
                JOptionPane.showMessageDialog(null, estatistica, "Finalizando o jogo", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

        
            int resultado = random.nextInt(6); 
            contagemDados[resultado]++; // 

           
            String saida = "Resultado do lancamento: " + espacoAmostral[resultado] + "\n(Indice gerado: " + resultado + ")";
            JOptionPane.showMessageDialog(null, saida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    private static int getTotalLances(int[] contagemDados) {
      
        int total = 0;
    
       
        for (int i = 0; i < contagemDados.length; i++) {
           
            total = total + contagemDados[i]; 
        }
    
        return total;
    }
}

