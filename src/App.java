
import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        //cara ou coroa
        //Vari�vel que receba intere��o do jogo 
        //random
        //switch
        //fir, do whilee while 
        String[] espacoAmostral = {"cara","coroa"};

        Random random = new Random();
        //Contadores para verificar a distribui��o
        int contCara = 0;
        int contCoroa = 0;
        String mensagem= " Espa�o amostral: {Cara,coroa}\n" + "Probabilidade de Cara:50% \n" + "Probabilidade de Coroa: 50% \n" + "Deseja lan�ar a moeda?";

        //loop de lan�amento
        while(true){
            //intera��o com usu�rio
            int opcao = JOptionPane.showConfirmDialog(null,mensagem,"lan�ando moedas",JOptionPane.YES_NO_OPTION);
            if (opcao != JOptionPane.YES_NO_OPTION){

            String estatistica = "jogo finalizado! \n"+"total de lan�amentos:" + (contCara+contCoroa)+"\n"+ "Cara:"+contCara+"\n"+"Coroa:"+contCoroa;
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
