import javax.swing.JOptionPane;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        
        String input = JOptionPane.showInputDialog("Quantos servico desejar solicitar?");
        int n = Integer.parseInt(input);

        double[] valores = new double[n];

        for (int i = 0; i < n; i++) {
            String valorStr = JOptionPane.showInputDialog("Digite o valor do servico " + (i + 1) + ":");
            valores[i] = Double.parseDouble(valorStr);
        }


        double moda = calcularModa(valores);

        Arrays.sort(valores);

        StringBuilder resultado = new StringBuilder("Tabela do valor de servico:\n");
        for (int i = 0; i < n; i++) {
            resultado.append("Servico ").append(i + 1).append(": ").append(valores[i]).append("\n");
        }

        resultado.append("\nModa dos valores: ").append(moda);

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static double calcularModa(double[] array) {
        double moda = array[0];
        int maxFreq = 0;

        for (int i = 0; i < array.length; i++) {
            int count = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count > maxFreq) {
                maxFreq = count;
                moda = array[i];
            }
        }

        return moda;
    }
}
