package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1920,1080);
        add(img);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(350,70,1000,60);
        heading.setFont(new Font("Serif",Font.BOLD,50));
        heading.setForeground(Color.WHITE);
        img.add(heading);

        JButton add = new JButton("Profile");
        add.setBounds(300,270,150,40);
        add.setFont(new Font("Serif",Font.BOLD,30));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        img.add(add);

        JPopupMenu profileMenu = new JPopupMenu();

        // Create menu items

        JMenuItem addProfile = new JMenuItem("Add Profile");
        addProfile.setFont(new Font("Tahoma", Font.BOLD,15));

        JMenuItem deleteProfile = new JMenuItem("Delete Profile");
        deleteProfile.setFont(new Font("Tahoma", Font.BOLD,15));
        JMenuItem viewProfile = new JMenuItem("View Profile");
        viewProfile.setFont(new Font("Tahoma", Font.BOLD,15));


        // Add menu items to the popup menu

        profileMenu.add(addProfile);

        profileMenu.add(deleteProfile);
        profileMenu.add(viewProfile);


        // Add action listener to the profile button
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileMenu.show(add, add.getWidth() / 2, add.getHeight() / 2);

            }
        });
        // Add action listener to the "Add Profile" menu item
        addProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Add_Emp();
            }
        });
        deleteProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Del_Emp();
            }
        });
        viewProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Emp();
            }
        });



        add(img);


        JButton add1 = new JButton("Attendence");
        add1.setBounds(650,270,200,40);
        add1.setFont(new Font("Serif",Font.BOLD,30));
        add1.setForeground(Color.WHITE);
        add1.setBackground(Color.BLACK);
        img.add(add1);

        JPopupMenu adMenu = new JPopupMenu();

        // Create menu items
        JMenuItem recordAdMenu = new JMenuItem("Record Attendence");
        recordAdMenu.setFont(new Font("Tahoma", Font.BOLD,15));
        JMenuItem viewAdMenu = new JMenuItem("View Attendence Record");
        viewAdMenu.setFont(new Font("Tahoma", Font.BOLD,15));



        // Add menu items to the popup menu
        adMenu.add(recordAdMenu);
        adMenu.add(viewAdMenu);



        // Add action listener to the profile button
        add1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adMenu.show(add1, add.getWidth() / 2, add.getHeight() / 2);

            }
        });

        recordAdMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Attendance();
            }
        });

        viewAdMenu.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAttendance();
            }
        });


        add(img);

        JButton add2 = new JButton("Employee Leave");
        add2.setBounds(1000,270,250,40);
        add2.setFont(new Font("Serif",Font.BOLD,30));
        add2.setForeground(Color.WHITE);
        add2.setBackground(Color.BLACK);
        img.add(add2);

        JButton add3 = new JButton("Employee Loan");
        add3.setBounds(300,520,250,40);
        add3.setFont(new Font("Serif",Font.BOLD,30));
        add3.setForeground(Color.WHITE);
        add3.setBackground(Color.BLACK);
        img.add(add3);


        JButton add4 = new JButton("Salary");
        add4.setBounds(650,520,190,40);
        add4.setFont(new Font("Serif",Font.BOLD,30));
        add4.setForeground(Color.WHITE);
        add4.setBackground(Color.BLACK);
        img.add(add4);

        JPopupMenu sMenu = new JPopupMenu();

        // Create menu items
        JMenuItem addSMenu = new JMenuItem("Add Salary");
        addSMenu.setFont(new Font("Tahoma", Font.BOLD,15));
        JMenuItem generateSMenu = new JMenuItem("Generate PaySlip");
        generateSMenu.setFont(new Font("Tahoma", Font.BOLD,15));



        // Add menu items to the popup menu
        sMenu.add(addSMenu);
        sMenu.add(generateSMenu);



        // Add action listener to the profile button
        add4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sMenu.show(add4, add.getWidth() / 2, add.getHeight() / 2);
                sMenu.setFont(new Font("Serif",Font.BOLD,25));
            }
        });
        add(img);

        JButton add5 = new JButton("Medical History");
        add5.setBounds(1000,520,250,40);
        add5.setFont(new Font("Serif",Font.BOLD,30));
        add5.setForeground(Color.WHITE);
        add5.setBackground(Color.BLACK);
        img.add(add5);

        JPopupMenu MMenu = new JPopupMenu();

        // Create menu items

        JMenuItem addEMP = new JMenuItem("Add Employee Medical Record");
        addEMP.setFont(new Font("Tahoma", Font.BOLD,15));

        JMenuItem viewEMP = new JMenuItem("View Employee Medical Record");
        viewEMP.setFont(new Font("Tahoma", Font.BOLD,15));
        JMenuItem addEFMP= new JMenuItem("Add Employee Family Member Medical Record");
        addEFMP.setFont(new Font("Tahoma", Font.BOLD,15));
        JMenuItem viewEFMP= new JMenuItem("View Employee Family Member Medical Record");
        viewEFMP.setFont(new Font("Tahoma", Font.BOLD,15));


        // Add menu items to the popup menu

        MMenu.add(addEMP);

        MMenu.add(viewEMP);
        MMenu.add(addEFMP);
        MMenu.add(viewEFMP);


        // Add action listener to the profile button
        add5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MMenu.show(add5, add.getWidth() / 2, add.getHeight() / 2);

            }
        });
        // Add action listener to the "Add Profile" menu item
        addEMP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployeeMedicalRecord();
            }
        });
        viewEMP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployeeMedicalRecord();
            }
        });
        addEFMP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFamilyMemberMedicalRecord();
            }
        });
        viewEFMP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new  ViewFamilyMemberMedicalRecord();
            }
        });
        add(img);




        setSize(1920,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);



    }






    public static void main(String[] args){
        new Main_class();
    }

}
