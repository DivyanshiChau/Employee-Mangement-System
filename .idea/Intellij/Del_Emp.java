package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Del_Emp extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete, back;
    Del_Emp(){
        setTitle("Delete Employee");
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(150,60,150,30);
        label.setFont(new Font("Tahoma", Font.BOLD,17));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(340,64,150,36);
        add(choiceEMPID);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMPID.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(150,100,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD,17));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(340,100,100,30);
        textName.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(150,150,100,30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,17));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(340,150,100,30);
        textPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textPhone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(150,200,100,30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD,17));
        add(labelemail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(340,200,100,30);
        textEmail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(textEmail);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(180,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(340,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login2.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,1120,630);
        add(image);

        setSize(650,400);
        setLocation(460,170);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try {
                conn c = new conn();
                String query = "delete from employee where empId = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Sucessfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Del_Emp();
    }
}