package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class leave extends JFrame implements ActionListener {
    JComboBox<String> tempid;
    JTextField treason;
    JTextField startDate, startMonth, startYear;
    JTextField endDate, endMonth, endYear;
    JTextField leaveType; // Changed from JComboBox to JTextField
    JButton add, back, viewStatus;
    JLabel background;

    leave() {
        getContentPane().setBackground(new Color(122, 140, 255));

        // Load the background image
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        background = new JLabel(i2);
        background.setBounds(0, 0, 900, 700);
        add(background);

        JLabel heading = new JLabel("Leave Application");
        heading.setBounds(340, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 150, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        empid.setForeground(Color.WHITE);
        background.add(empid);

        tempid = new JComboBox<>();
        tempid.setBounds(200, 150, 150, 30);
        tempid.setBackground(new Color(177, 252, 197));
        background.add(tempid);

        JLabel startDateLabel = new JLabel("Start Date");
        startDateLabel.setBounds(50, 200, 200, 30);
        startDateLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        startDateLabel.setForeground(Color.WHITE);
        background.add(startDateLabel);

        startDate = new JTextField(2);
        startDate.setBounds(200, 200, 30, 30);
        startDate.setBackground(new Color(177, 252, 197));
        background.add(startDate);

        startMonth = new JTextField(2);
        startMonth.setBounds(240, 200, 30, 30);
        startMonth.setBackground(new Color(177, 252, 197));
        background.add(startMonth);

        startYear = new JTextField(4);
        startYear.setBounds(280, 200, 50, 30);
        startYear.setBackground(new Color(177, 252, 197));
        background.add(startYear);

        JLabel endDateLabel = new JLabel("End Date");
        endDateLabel.setBounds(50, 250, 150, 30);
        endDateLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        endDateLabel.setForeground(Color.WHITE);
        background.add(endDateLabel);

        endDate = new JTextField(2);
        endDate.setBounds(200, 250, 30, 30);
        endDate.setBackground(new Color(177, 252, 197));
        background.add(endDate);

        endMonth = new JTextField(2);
        endMonth.setBounds(240, 250, 30, 30);
        endMonth.setBackground(new Color(177, 252, 197));
        background.add(endMonth);

        endYear = new JTextField(4);
        endYear.setBounds(280, 250, 50, 30);
        endYear.setBackground(new Color(177, 252, 197));
        background.add(endYear);

        JLabel leaveTypeLabel = new JLabel("Leave Type(Sick/Paid/Casual)");
        leaveTypeLabel.setBounds(400, 150, 350, 30);
        leaveTypeLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        leaveTypeLabel.setForeground(Color.WHITE);
        background.add(leaveTypeLabel);

        leaveType = new JTextField();
        leaveType.setBounds(400, 200, 200, 30); // Changed from JComboBox to JTextField
        leaveType.setBackground(new Color(177, 252, 197));
        background.add(leaveType);

        JLabel reason = new JLabel("Reason");
        reason.setBounds(400, 250, 150, 30);
        reason.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        reason.setForeground(Color.WHITE);
        background.add(reason);

        treason = new JTextField();
        treason.setBounds(550, 250, 150, 30);
        treason.setBackground(new Color(177, 252, 197));
        treason.setFont(new Font("SAN_SERIF", Font.BOLD, 17));
        background.add(treason);

        add = new JButton("APPLY");
        add.setBounds(250, 350, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        background.add(add);

        back = new JButton("BACK");
        back.setBounds(450, 350, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        background.add(back);

        viewStatus = new JButton("VIEW EMPLOYEE LEAVE STATUS");
        viewStatus.setBounds(320, 420, 250, 40);
        viewStatus.setBackground(Color.BLACK);
        viewStatus.setForeground(Color.WHITE);
        viewStatus.addActionListener(this);
        background.add(viewStatus);



        // Fetch Employee IDs from the database and populate the JComboBox
        populateEmployeeIDs();

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    private void populateEmployeeIDs() {
        try {
            conn c = new conn();
            String query = "SELECT empId FROM employee";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                tempid.addItem(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String empid = (String) tempid.getSelectedItem();
            String startDateStr = startDate.getText() + "/" + startMonth.getText() + "/" + startYear.getText();
            String endDateStr = endDate.getText() + "/" + endMonth.getText() + "/" + endYear.getText();
            String leaveTypeStr = leaveType.getText(); // Get leave type from text field
            String reason = treason.getText();

            try {
                conn c = new conn();
                String query = "INSERT INTO employee_leave (empid, start_date, end_date, leave_type, reason) VALUES ('" + empid + "', '" + startDateStr + "', '" + endDateStr + "', '" + leaveTypeStr + "', '" + reason + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave applied successfully");
                setVisible(false);
                  // Assuming Main_class is the class to return to the main menu
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
              // Assuming Main_class is the class to return to the main menu
        } else if (e.getSource() == viewStatus) {
            setVisible(false);
            new ViewLeaveStatus();  // Assuming ViewLeaveStatus is the class to view leave status
        }
    }

    public static void main(String[] args) {
        new leave();
    }
}
