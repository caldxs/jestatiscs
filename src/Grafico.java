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
        dataset.addValue(adubacao, "Serviços", "Adubação");
        dataset.addValue(poda, "Serviços", "Poda");
        dataset.addValue(manutencao, "Serviços", "Manutenção");
        dataset.addValue(plantio, "Serviços", "Plantio");

        // Criar gráfico
        JFreeChart chart = ChartFactory.createBarChart(
            "Quantidade de Serviços Contratados",
            "Tipo de Serviço",
            "Quantidade",
            dataset
        );

        // Mostrar gráfico
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}