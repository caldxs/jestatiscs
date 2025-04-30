import javax.swing.JOptionPane;

//public class App {
//    public static void main(String[] args)throws Exception {
  //    int op = Integer.parseInt(JOptionPane.showInputDialog("Qual o resultado de uma população? "+ " 1-Parâmetro  2-Estatística"));
     // if(op ==1){
   //      JOptionPane.showMessageDialog(null,"certa Resposta");
   //  }else{

   // JOptionPane.showMessageDialog(null,"Resposta Errada!","JStatistics", JOptionPane.ERROR_MESSAGE);
  //   }
    //}
//}

//if else
//exercícios
//*considerando os números 30,50,80,90 Digite o valor da média aritméticas simples? */
//gabarito: 62,5
//considerando os valores 10,40,50,80,10. Digite qual é a moda?*/
//10
//*Qual a media de tendências central que mostra o centro de amostra  */
//mediana  


public class App {
    public static void main(String[] args)throws Exception {
      double op = Double.parseDouble(JOptionPane.showInputDialog("considerando os números 30,50,80,90 Digite o valor da média aritméticas simples?"));
      if(op ==62.5){
         JOptionPane.showMessageDialog(null,"certa Resposta");
     }else{

    JOptionPane.showMessageDialog(null,"Resposta Errada!","JStatistics", JOptionPane.ERROR_MESSAGE);
     }
    }
}