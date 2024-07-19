package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LoanPage extends JFrame implements ActionListener {
    JTextField tempid, tloanAmount, tsalary, tpreviousLoanHistory, treferences, loanType;
    JLabel lname, ldesignation;

    JButton apply, back;
    String empID;

    LoanPage() {
        getContentPane().setBackground(new Color(122, 140, 255));
        setTitle("Loan Application Form");

        JLabel heading = new JLabel("Loan Application");
        heading.setBounds(320, 25, 500, 50);
        heading.setFont(new Font("Sans-Serif", Font.BOLD, 29));
        add(heading);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 100, 150, 30);
        empid.setFont(new Font("Sans Serif", Font.BOLD, 20));
        add(empid);

        tempid = new JTextField();
        tempid.setBounds(250, 100, 150, 30);
        tempid.setBackground(new Color(177, 252, 197));
        tempid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (tempid.getText().trim().length() == 3) {
                    loadEmployeeDetails(tempid.getText().trim());
                } else {
                    clearFields();
                }
            }
        });
        add(tempid);

        JLabel empNameLabel = new JLabel("Employee Name");
        empNameLabel.setBounds(450, 100, 150, 30);
        empNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        add(empNameLabel);

        lname = new JLabel();
        lname.setBounds(650, 100, 150, 30);
        lname.setFont(new Font("Sans Serif", Font.BOLD, 18));
        add(lname);

        JLabel loanTypeLabel = new JLabel("<html>Loan Type<br>(Personal, Car, Educational Loan, others)</html>");
        loanTypeLabel.setBounds(50, 150, 200, 90); // Adjusted height to accommodate two lines
        loanTypeLabel.setFont(new Font("Sans Serif", Font.BOLD, 18));
        add(loanTypeLabel);

        loanType = new JTextField();
        loanType.setBounds(250, 160, 150, 30); // Adjusted Y position to separate from label
        loanType.setBackground(new Color(177, 252, 197));
        add(loanType);

        JLabel loanAmount = new JLabel("Loan Amount");
        loanAmount.setBounds(50, 250, 150, 30);
        loanAmount.setFont(new Font("Sans Serif", Font.BOLD, 18));
        add(loanAmount);

        tloanAmount = new JTextField();
        tloanAmount.setBounds(250, 250, 150, 30);
        tloanAmount.setBackground(new Color(177, 252, 197));
        add(tloanAmount);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(450, 200, 150, 30);
        salary.setFont(new Font("Sans Serif", Font.BOLD, 18));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(650, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        tsalary.setEditable(false);
        add(tsalary);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(450, 150, 150, 30);
        designation.setFont(new Font("Sans Serif", Font.BOLD, 18));
        add(designation);

        ldesignation = new JLabel();
        ldesignation.setBounds(650, 150, 150, 30);
        ldesignation.setFont(new Font("Sans Serif", Font.BOLD, 20));
        add(ldesignation);

        JLabel previousLoanHistory = new JLabel("Previous Loan History");
        previousLoanHistory.setBounds(50, 300, 250, 30);
        previousLoanHistory.setFont(new Font("Sans Serif", Font.BOLD, 18));
        add(previousLoanHistory);

        tpreviousLoanHistory = new JTextField();
        tpreviousLoanHistory.setBounds(250, 300, 200, 30);
        tpreviousLoanHistory.setBackground(new Color(177, 252, 197));
        add(tpreviousLoanHistory);

        apply = new JButton("APPLY");
        apply.setBounds(450, 350, 150, 40);
        apply.setBackground(Color.BLACK);
        apply.setForeground(Color.WHITE);
        apply.addActionListener(this);
        add(apply);

        back = new JButton("BACK");
        back.setBounds(250, 350, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 500);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    private void loadEmployeeDetails(String empID) {
        try {
            conn c = new conn();
            String query = "SELECT name, designation, salary FROM employee WHERE empid = '" + empID + "'";
            ResultSet rs = c.statement.executeQuery(query);
            if (rs.next()) {
                lname.setText(rs.getString("name"));
                ldesignation.setText(rs.getString("designation"));
                tsalary.setText(rs.getString("salary"));
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found", "Error", JOptionPane.ERROR_MESSAGE);
                clearFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading employee details", "Error", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }

    private void clearFields() {
        lname.setText("");
        ldesignation.setText("");
        tsalary.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == apply) {
            String empID = tempid.getText();
            String selectedLoanType = loanType.getText();
            String loanAmount = tloanAmount.getText();

            String salary = tsalary.getText();
            String designation = ldesignation.getText();
            String previousLoanHistory = tpreviousLoanHistory.getText();

            if (empID.isEmpty() || selectedLoanType.isEmpty() || loanAmount.isEmpty() || salary.isEmpty() || designation.isEmpty() || previousLoanHistory.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                conn c = new conn();
                String query = "INSERT INTO employee_loans (empid, loan_type, loan_amount, salary, designation, previous_loan_history) VALUES('" + empID + "', '" + selectedLoanType + "', '" + loanAmount + "', '" + salary + "', '" + designation + "', '" + previousLoanHistory + "')";
                c.statement.executeUpdate(query);

                String username = JOptionPane.showInputDialog(null, "Send details : \nEnter username:");
                if (username != null && !username.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email has been sent to finance dept\nContact finance dept: 123978786");
                }

                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error submitting loan application", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LoanPage();
    }
}
