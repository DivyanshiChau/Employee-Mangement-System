package employee.management.system;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class LeaveChart extends JFrame {

    public LeaveChart() {
        setTitle("Leave Chart");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Use DISPOSE_ON_CLOSE to close just the chart window

        setLocationRelativeTo(null); // Center the frame

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        populateDataset(dataset);

        JFreeChart chart = ChartFactory.createBarChart(
                "Leave Taken by Employees",
                "Employee ID",
                "Number of Leaves",
                dataset
        );

        NumberAxis yAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
        yAxis.setTickUnit(new NumberTickUnit(5)); // Set tick unit to 5

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        setContentPane(chartPanel);
        setVisible(true);
    }

    private void populateDataset(DefaultCategoryDataset dataset) {
        try {
            conn c = new conn();
            String query = "SELECT empid, COUNT(*) AS leave_count FROM employee_leave GROUP BY empid";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                String empId = rs.getString("empid");
                int leaveCount = rs.getInt("leave_count");
                dataset.addValue(leaveCount, "Leaves", empId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving leave data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LeaveChart chart = new LeaveChart();
            chart.setVisible(true);
        });
    }
}
