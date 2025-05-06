
import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        //cara ou coroa
        //Variável que receba intereção do jogo 
        //random
        //switch
        //fir, do whilee while 
        String[] espacoAmostral = {"cara","coroa"};

        Random random = new Random();
        //Contadores para verificar a distribuição
        int contCara = 0;
        int contCoroa = 0;
        String mensagem= " Espaço amostral: {Cara,coroa}\n" + "Probabilidade de Cara:50% \n" + "Probabilidade de Coroa: 50% \n" + "Deseja lançar a moeda?";

        //loop de lançamento
        while(true){
            //interação com usuário
            int opcao = JOptionPane.showConfirmDialog(null,mensagem,"lançando moedas",JOptionPane.YES_NO_OPTION);
            if (opcao != JOptionPane.YES_NO_OPTION){

            String estatistica = "jogo finalizado! \n"+"total de lançamentos:" + (contCara+contCoroa)+"\n"+ "Cara:"+contCara+"\n"+"Coroa:"+contCoroa;
            JOptionPane.showMessageDialog(null, estatistica,"Finalizando o jogo",JOptionPane.INFORMATION_MESSAGE);
                

                break;    
            }
            int resultado = random.nextInt(2);

            if(resultado ==0){
                contCara++; 
            }else{
                contCoroa++;
            }
            String saida = "Resultado do lancamento:"+espacoAmostral[resultado]+ "\n(Indice gerado: "+ resultado+")";
            JOptionPane.showMessageDialog(null, "resultado", saida,JOptionPane.INFORMATION_MESSAGE);
 
        }
    }
}
