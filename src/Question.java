import javax.swing.JOptionPane;

public class Question {
    public static void main (String args[]){
     
        String menssage = "HELLO GARDEN";
        byte numFerramentas = 5;
        short agendamentoMes= 32767;
        int idAgendamneto = 214748364;
        long dataAgendamento = System.currentTimeMillis();
        float precoServico = 99.90f;
        double areaJardim = 170.75;
        char tipoServico = 'C';
        boolean concluido = true;
        String cliente = "Luan";
        String servico = "Poda";

        JOptionPane.showMessageDialog(null, menssage);
        JOptionPane.showMessageDialog(null,"numero de ferramenta "+numFerramentas);
        JOptionPane.showMessageDialog(null,"Quantidade agendamentos "+agendamentoMes);
        JOptionPane.showMessageDialog(null,"Data atual em milisegundos "+dataAgendamento);
        JOptionPane.showMessageDialog(null,"service Price "+precoServico);
        JOptionPane.showMessageDialog(null,"Area do jardim "+areaJardim);
        JOptionPane.showMessageDialog(null,tipoServico == 'P' ? "Poda": 'C' );    
        JOptionPane.showMessageDialog(null, "numero de ferramenta "+ numFerramentas);
         
        if(concluido){
            JOptionPane.showMessageDialog(null,"Faz o pix AGORA:" +cliente+"voce sabia que seu nome tem 4 letras");
        }else{
            JOptionPane.showMessageDialog(null,"servico em andamento aguarde please");
            
        }
        JOptionPane.showMessageDialog(null,servico.charAt(0));
    }

       

}


