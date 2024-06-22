package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Emp extends JFrame implements ActionListener {
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation, tempid;
    JDateChooser tdob;
    JButton add, back;
    JComboBox<String> Boxeducation;
    JLabel background;

    Add_Emp() {
        setTitle("Add Employee");
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(155, 170, 255));

        // Load the background image
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/loginBack.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        background = new JLabel(i2);
        background.setBounds(0, 0, 900, 700);
        add(background);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SERIF", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        background.add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setFont(new Font("SERIF", Font.BOLD, 20));
        tname.setBackground(new Color(155, 170, 255));
        tname.setForeground(Color.black);
        background.add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SERIF", Font.BOLD, 20));
        fname.setForeground(Color.WHITE);
        background.add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setFont(new Font("SERIF", Font.BOLD, 17));
        tfname.setBackground(new Color(155, 170, 255));
        tfname.setForeground(Color.black);
        background.add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SERIF", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        background.add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("SERIF", Font.BOLD, 17));
        tdob.setBackground(new Color(155, 170, 255));
        tdob.setForeground(Color.black);
        background.add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SERIF", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        background.add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setFont(new Font("SERIF", Font.BOLD, 17));
        tsalary.setBackground(new Color(155, 170, 255));
        tsalary.setForeground(Color.black);
        background.add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SERIF", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        background.add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setFont(new Font("SERIF", Font.BOLD, 17));
        taddress.setBackground(new Color(155, 170, 255));
        taddress.setForeground(Color.black);
        background.add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SERIF", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        background.add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setFont(new Font("SERIF", Font.BOLD, 17));
        tphone.setBackground(new Color(155, 170, 255));
        setForeground(Color.black);
        background.add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SERIF", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        background.add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setFont(new Font("SERIF", Font.BOLD, 17));
        temail.setBackground(new Color(155, 170, 255));
        temail.setForeground(Color.black);
        background.add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SERIF", Font.BOLD, 20));
        education.setForeground(Color.white);
        background.add(education);

        String items[] = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox<>(items);
        Boxeducation.setBackground(new Color(155, 170, 255));
        Boxeducation.setBounds(600, 300, 150, 30);
        background.add(Boxeducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SERIF", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        background.add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(new Color(155, 170, 255));
        taadhar.setFont(new Font("SERIF", Font.BOLD, 17));
        taadhar.setForeground(Color.black);
        background.add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SERIF", Font.BOLD, 20));
        empid.setForeground(Color.WHITE);
        background.add(empid);

        tempid = new JTextField();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SARIF", Font.BOLD, 20));
        tempid.setForeground(Color.BLACK);
        background.add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SERIF", Font.BOLD, 20));
        designation.setForeground(Color.WHITE);
        background.add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(155, 170, 255));
        tdesignation.setForeground(Color.black);
        background.add(tdesignation);

        add = new JButton("ADD");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();

            try {
                conn c = new conn();
                String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "','" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "','" + aadhar + "', '" + empID + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            
        }
    }

    public static void main(String[] args) {
        new Add_Emp();
    }
}
