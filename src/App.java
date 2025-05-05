
import javax.swing.JOptionPane;
public class App {
     public static void main(String[] args) throws Exception {
        System.out.println("Aula- Switch e loops");
        /*o switch é uma estrutura de seleção multipla 
        um if mais organizado
        Escolha
          case
        Para resolver listas ou constantes:
          menu
            opcao1
            opcao2*/
      /*   int op = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: \n 1- Estatística \n 2- Probabilidade \n 3- Modelos probabilistico \n 4-Encerrando sistema") );
        if (op!= 4) {switch(op) {


          case 1:
          JOptionPane.showInputDialog(null,"Estatística Desertativa");

          break;

          case 2:
          JOptionPane.showInputDialog(null," Probabilidades");

          break;

          case 3:
          JOptionPane.showInputDialog(null,"Estatistica descritiva");

          break;

          case 4: JOptionPane.showMessageDialog(null,"Encerrando sistema");


        }
    
    
    }

     /*int contador = 1;
     while (contador<=5) {
     JOptionPane.showMessageDialog(null,"Viva o senai");
     break;
     */

     for(int cont=1; cont<=10;cont++){
      System.out.println(cont);
     }
      String sair;
      do{
        sair = JOptionPane.showInputDialog("Digite s-sim e n-nao");
       
      }while (sair != "nao");
    }
    }



