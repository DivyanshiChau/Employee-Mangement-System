package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Salary extends JFrame implements ActionListener {
    JTextField tempid, tsalary;
    JDateChooser tmonth;
    JButton generate, addSalary, back;

    Salary() {
        getContentPane().setBackground(new Color(124, 140, 255));

        JLabel heading = new JLabel("Generate Salary Slip");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 150, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JTextField();
        tempid.setBounds(200, 150, 150, 30);
        tempid.setBackground(new Color(177, 252, 197));
        add(tempid);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(50, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(200, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel month = new JLabel("Month");
        month.setBounds(50, 250, 150, 30);
        month.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(month);

        tmonth = new JDateChooser();
        tmonth.setBounds(200, 250, 150, 30);
        tmonth.setDateFormatString("MM/yyyy");
        tmonth.setBackground(new Color(177, 252, 197));
        add(tmonth);

        addSalary = new JButton("ADD SALARY");
        addSalary.setBounds(150, 350, 150, 40);
        addSalary.setBackground(Color.black);
        addSalary.setForeground(Color.WHITE);
        addSalary.addActionListener(this);
        add(addSalary);

        generate = new JButton("GENERATE SLIP");
        generate.setBounds(350, 350, 150, 40);
        generate.setBackground(Color.black);
        generate.setForeground(Color.WHITE);
        generate.addActionListener(this);
        add(generate);

        back = new JButton("BACK");
        back.setBounds(550, 350, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String empID = tempid.getText();
        String salary = tsalary.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        String month = sdf.format(tmonth.getDate());

        if (e.getSource() == addSalary) {
            try {
                conn c = new conn();
                String query = "insert into employee_salary (emp_id, salary, month) values('" + empID + "', '" + salary + "', '" + month + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Salary added successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == generate) {
            // Code to generate salary slip (for now, just show a message)
            JOptionPane.showMessageDialog(null, "Salary slip generated for " + empID);
        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Salary();
    }
}
