import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends JFrame {

    public Grafico(String title, int adubacao, int poda, int manutencao, int plantio) {
        super(title);

        // Criar dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(adubacao, "Servi�os", "Aduba��o");
        dataset.addValue(poda, "Servi�os", "Poda");
        dataset.addValue(manutencao, "Servi�os", "Manuten��o");
        dataset.addValue(plantio, "Servi�os", "Plantio");

        // Criar gr�fico
        JFreeChart chart = ChartFactory.createBarChart(
            "Quantidade de Servi�os Contratados",
            "Tipo de Servi�o",
            "Quantidade",
            dataset
        );

        // Mostrar gr�fico
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}