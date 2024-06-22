package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Emp extends JFrame implements ActionListener {
    JTextField teducation, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid, tname, tdob, taadharLabel;
    JButton add, back;
    String number;
    JLabel background;

    Update_Emp(String number) {
        this.number = number;
        getContentPane().setBackground(new Color(155, 170, 255));

        // Load the background image
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/loginBack.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        background = new JLabel(i2);
        background.setBounds(0, 0, 900, 700);
        add(background);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(290, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SERIF", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        background.add(name);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setFont(new Font("SERIF", Font.BOLD, 20));
        tname.setForeground(Color.BLACK);
        tname.setBackground(new Color(177, 252, 197));
        background.add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SERIF", Font.BOLD, 20));
        fname.setForeground(Color.WHITE);
        background.add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setFont(new Font("SERIF", Font.BOLD, 17));
        tfname.setBackground(new Color(177, 252, 197));
        tfname.setForeground(Color.BLACK);
        background.add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SERIF", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        background.add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        tdob.setForeground(Color.BLACK);
        tdob.setBackground(new Color(177, 252, 197));
        background.add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SERIF", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        background.add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setFont(new Font("SERIF", Font.BOLD, 17));
        tsalary.setBackground(new Color(177, 252, 197));
        tsalary.setForeground(Color.BLACK);
        background.add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SERIF", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        background.add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setFont(new Font("SERIF", Font.BOLD, 17));
        taddress.setBackground(new Color(177, 252, 197));
        taddress.setForeground(Color.BLACK);
        background.add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SERIF", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        background.add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setFont(new Font("SERIF", Font.BOLD, 17));
        tphone.setBackground(new Color(177, 252, 197));
        tphone.setForeground(Color.BLACK);
        background.add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SERIF", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        background.add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setFont(new Font("SERIF", Font.BOLD, 17));
        temail.setBackground(new Color(177, 252, 197));
        temail.setForeground(Color.BLACK);
        background.add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 180, 30);
        education.setFont(new Font("SERIF", Font.BOLD, 20));
        education.setForeground(Color.WHITE);
        background.add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setFont(new Font("SERIF", Font.BOLD, 17));
        teducation.setBackground(new Color(177, 252, 197));
        teducation.setForeground(Color.BLACK);
        background.add(teducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SERIF", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        background.add(aadhar);

        taadharLabel = new JLabel();
        taadharLabel.setBounds(600, 350, 150, 30);
        taadharLabel.setFont(new Font("SERIF", Font.BOLD, 17));
        taadharLabel.setBackground(new Color(177, 252, 197));
        taadharLabel.setForeground(Color.BLACK);
        background.add(taadharLabel);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SERIF", Font.BOLD, 20));
        empid.setForeground(Color.WHITE);
        background.add(empid);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        background.add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SERIF", Font.BOLD, 20));
        designation.setForeground(Color.WHITE);
        background.add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setFont(new Font("SERIF", Font.BOLD, 17));
        tdesignation.setBackground(new Color(177, 252, 197));
        tdesignation.setForeground(Color.BLACK);
        background.add(tdesignation);

        try {
            conn c = new conn();
            String query = "select * from employee where empId = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadharLabel.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empId"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        background.add(add);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        background.add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String fname = tfname.getText();
            String dob = tdob.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                conn conn = new conn();
                String query = "update employee set fname='" + fname + "', dob='" + dob + "', salary='" + salary + "', address='" + address + "', phone='" + phone + "', email='" + email + "', education='" + education + "', designation='" + designation + "' where empId='" + tempid.getText() + "'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Update_Emp("");
    }
}
