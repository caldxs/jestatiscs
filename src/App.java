import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Aula3- Switch e Loops");
         String cont;
         do{

        int op = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o: \n1-Estat�stica Descritiva \n2-Probabilidade \n3-Modelos probabil�sticos \n 4-Sair"));
        // !=  diferente
            switch(op){
                case 1:
                JOptionPane.showMessageDialog(null,
                 "Estat�stica Descritiva");break;
                case 2:
                JOptionPane.showMessageDialog(null,
                 "Probabilidade");break;
                case 3:
                 JOptionPane.showMessageDialog(null,
                  "Modelos Probabilisticos");break;

                
   
                default:
                JOptionPane.showMessageDialog(null,
                "Op��o Inv�lida!");break;
  
                
             }
            cont = JOptionPane.showInputDialog("Deseja Continuar? (S-Sim N-N�o)");

            JOptionPane.showMessageDialog(null, "Encerrando sistema...");
          } while (cont.equalsIgnoreCase("S"));

          JOptionPane.showMessageDialog(null, "Encerrando Sistema...");
      
    }


       /* int contador = 1;
        while(contador<1){
           JOptionPane.showMessageDialog(null,"Viva o SENAI!!!");
           contador = contador+1;          
        }
        int i = 1;
        while(i<=2){
            System.out.println(i);
            i++;
        }
        for(int cont=1;cont<=1;cont++){
            System.out.println(cont);
        }
        String sair;
        do{
           //System.out.println("sair:s ou n");
           sair = JOptionPane.showInputDialog("Digite s-sim e n-n�o");

        }while(!sair.equalsIgnoreCase("sim"));
        */

      }
    
  