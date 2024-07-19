package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leave_Emp extends JFrame implements ActionListener {
    JTextField tempid, treason;
    JDateChooser tstartDate, tendDate;
    JComboBox<String> BoxLeaveType;
    JButton add, back;

    Leave_Emp() {
        getContentPane().setBackground(new Color(122, 140, 255));

        JLabel heading = new JLabel("Apply for Leave");
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

        JLabel startDate = new JLabel("Start Date");
        startDate.setBounds(50, 200, 150, 30);
        startDate.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(startDate);

        tstartDate = new JDateChooser();
        tstartDate.setBounds(200, 200, 150, 30);
        tstartDate.setBackground(new Color(177, 252, 197));
        add(tstartDate);

        JLabel endDate = new JLabel("End Date");
        endDate.setBounds(50, 250, 150, 30);
        endDate.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(endDate);

        tendDate = new JDateChooser();
        tendDate.setBounds(200, 250, 150, 30);
        tendDate.setBackground(new Color(177, 252, 197));
        add(tendDate);

        JLabel leaveType = new JLabel("Leave Type");
        leaveType.setBounds(400, 200, 150, 30);
        leaveType.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(leaveType);

        String[] leaveTypes = {"Sick Leave", "Casual Leave", "Paid Leave"};
        BoxLeaveType = new JComboBox<>(leaveTypes);
        BoxLeaveType.setBounds(600, 200, 150, 30);
        BoxLeaveType.setBackground(new Color(177, 252, 197));
        add(BoxLeaveType);

        JLabel reason = new JLabel("Reason");
        reason.setBounds(400, 250, 150, 30);
        reason.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(reason);

        treason = new JTextField();
        treason.setBounds(600, 250, 150, 30);
        treason.setBackground(new Color(177, 252, 197));
        add(treason);

        add = new JButton("APPLY");
        add.setBounds(450, 350, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 350, 150, 40);
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
        if (e.getSource() == add) {
            String empID = tempid.getText();
            String startDate = ((JTextField) tstartDate.getDateEditor().getUiComponent()).getText();
            String endDate = ((JTextField) tendDate.getDateEditor().getUiComponent()).getText();
            String leaveType = (String) BoxLeaveType.getSelectedItem();
            String reason = treason.getText();

            try {
                conn c = new conn();
                String query = "insert into employee_leave (emp_id, start_date, end_date, leave_type, reason) values('" + empID + "', '" + startDate + "', '" + endDate + "', '" + leaveType + "', '" + reason + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave applied successfully");
                setVisible(false);
                new Main_class();  // Assuming Main_class is the class to return to main menu
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_class();  // Assuming Main_class is the class to return to main menu
        }
    }

    public static void main(String[] args) {
        new Leave_Emp();
    }
}
