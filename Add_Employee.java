package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Add_Employee extends JFrame implements ActionListener{


    JTextField textFieldNumber,textName, textFieldAge, textFieldcontact, textFieldmail, textFieldwork, textFieldsalary;
    JRadioButton r1, r2;
    JButton b1, b2;

    Add_Employee(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(90,156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/emp.png"));
        Image image =  imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label  = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labeName = new JLabel(" ADD NEW EMPLOYEE");
        labeName.setBounds(118,11,260,53);
        labeName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labeName);


        JLabel labelNumber = new JLabel(" Aadhar Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        JLabel labelage = new JLabel("Age :");
        labelage.setBounds(35,231,200,14);
        labelage.setFont(new Font("Tahoma",Font.BOLD,14));
        labelage.setForeground(Color.WHITE);
        panel.add(labelage);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(271,231,150,20);
        panel.add(textFieldAge);

        JLabel labelcontact = new JLabel("Phone Number :");
        labelcontact.setBounds(35,271,200,14);
        labelcontact.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcontact.setForeground(Color.WHITE);
        panel.add(labelcontact);

        textFieldcontact = new JTextField();
        textFieldcontact.setBounds(271,271,150,20);
        panel.add(textFieldcontact);

        JLabel labelwork = new JLabel("Work :");
        labelwork.setBounds(35,311,200,14);
        labelwork.setFont(new Font("Tahoma",Font.BOLD,14));
        labelwork.setForeground(Color.WHITE);
        panel.add(labelwork);

        textFieldwork = new JTextField();
        textFieldwork.setBounds(271,311,150,20);
        panel.add(textFieldwork);


        JLabel labelsalary = new JLabel("Salary :");
        labelsalary.setBounds(35,351,200,17);
        labelsalary.setFont(new Font("Tahoma",Font.BOLD,14));
        labelsalary.setForeground(Color.WHITE);
        panel.add(labelsalary);

        textFieldsalary = new JTextField();
        textFieldsalary.setBounds(271,351,150,20);
        panel.add(textFieldsalary);

        JLabel labelmail = new JLabel("Gmail :");
        labelmail.setBounds(35,391,200,17);
        labelmail.setFont(new Font("Tahoma",Font.BOLD,14));
        labelmail.setForeground(Color.WHITE);
        panel.add(labelmail);

        textFieldmail = new JTextField();
        textFieldmail.setBounds(271,391,150,20);
        panel.add(textFieldmail);

        b1 = new JButton("ADD");
        b1.setBounds(100,445,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260,445,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850,500);
        setLayout(null);
        setLocation(300,220);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()){
                radioBTN = "Male";
            }else if (r2.isSelected()){
                radioBTN = "Female";
            }


            String s1 = textName.getText();
            String s2 = radioBTN;
            String s3 = textFieldAge.getText();
            String s4 = textFieldcontact.getText();
            String s5 = textFieldwork.getText();
            String s6 = textFieldsalary.getText();
            String s7 = textFieldmail.getText();
            String s8 = textFieldNumber.getText();

            try {
                String q = "insert into EMP_INFO values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Added Sucessfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }


        }else {
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new Add_Employee();
    }
}
