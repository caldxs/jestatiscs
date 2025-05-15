import javax.swing.JOptionPane;

public class Duvida2{

  
    public static void main(String agrs []) throws Exception{
      
      double areaJardim1 = 200.00;
      double areaJardim2 = 300.00;
      double areaJardim3 = 500.00;
    

      double[] areasJardins = {200,300,500};

      double soma = 0;
      double media;

      System.out.println(areasJardins[0]);
      System.out.println(areasJardins[1]);
      System.out.println(areasJardins[2]);



      for(int i = 0;i<areasJardins.length;i++){
        JOptionPane.showMessageDialog(null,"Area do jardim" + (i + 1)+ ":" + areasJardins[i]);
        soma =+ areasJardins[i];
      }

      // 20 JARDINS
    
    media = soma / areasJardins.length;

    JOptionPane.showMessageDialog(null, "soma das areas:"+ soma);
    JOptionPane.showMessageDialog(null, "media das areas:" + media);  
    }
}