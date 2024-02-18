import javax.swing.*;
import java.awt.*;

public class BarChart extends JFrame {

    private int[] data;

    public BarChart(int[] data) {
        this.data = data;

        setTitle("Bar Chart");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBarChart(g);
            }
        };

        getContentPane().add(chartPanel);

        setVisible(true);
    }

    private void drawBarChart(Graphics g) {
        int barWidth = 30;
        int barGap = 10;
        int x = 50;
        int maxHeight = 200;

        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) (((double) data[i] / getMaxValue()) * maxHeight);
            g.setColor(Color.BLUE);
            g.fillRect(x, getHeight() - barHeight - 30, barWidth, barHeight);

            g.setColor(Color.BLACK);
            g.drawRect(x, getHeight() - barHeight - 30, barWidth, barHeight);

            x += barWidth + barGap;
        }
    }

    private int getMaxValue() {
        int max = data[0];
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {50, 80, 120, 60, 150}; // Example data

        SwingUtilities.invokeLater(() -> new BarChart(data));
    }
}
