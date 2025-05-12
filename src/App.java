import javax.swing.JOptionPane;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        double areaJardim, comprimento, largura;
        double somaArea = 0;
        int areas=0;
        int areasGrandes=0;
        while (true) {
            comprimento = Double.parseDouble(JOptionPane.showInputDialog(null,"Comprimento do Jardim: "));
            largura = Double.parseDouble(JOptionPane.showInputDialog(null,"Largura do Jardim: "));
            areas++;
            
            String[] tamanho = {"Pequeno","Grande"};
            areaJardim = comprimento*largura;

            if (areaJardim < 100) {
                JOptionPane.showMessageDialog(null, "Area do Jardim: "+areaJardim+"\nTamanho: "+tamanho[0]);
            }else {
                JOptionPane.showMessageDialog(null, "Area do Jardim: "+areaJardim+"\nTamanho: "+tamanho[1]);
                areasGrandes++;
            }
            somaArea = somaArea + areaJardim;
            int loop = JOptionPane.showConfirmDialog(null, "Deseja Adicionar mais um Terreno? ");
            if (loop != JOptionPane.YES_OPTION) {     
                break;
            }
        }
        double mediaArea = somaArea/areas;
        JOptionPane.showMessageDialog(null, "A media das Areas:"+mediaArea+"\nÁreas Grandes: "+areasGrandes);
    }
}