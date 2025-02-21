package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_employee_info extends JFrame {
    update_employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Employee Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Aadhar Number :");
        label2.setBounds(25,88,150,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,200,25);
        panel.add(choice);

        try {
            conn c =  new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from EMP_INFO");
            while (resultSet.next()){
                choice.add(resultSet.getString("Aadhar_Number"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label7 = new JLabel("Name :");
        label7.setBounds(25,129,170,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(248,129,200,20);
        panel.add(textFieldName);


        JLabel label3 = new JLabel("Age :");
        label3.setBounds(25,174,150,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldage = new JTextField();
        textFieldage.setBounds(248,174,200,20);
        panel.add(textFieldage);

        JLabel label4 = new JLabel("Phone Number :");
        label4.setBounds(25,216,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINum = new JTextField();
        textFieldINum.setBounds(248,216,200,20);
        panel.add(textFieldINum);

        JLabel label5 = new JLabel("Work :");
        label5.setBounds(25,261,150,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldwork = new JTextField();
        textFieldwork.setBounds(248,261,200,20);
        panel.add(textFieldwork);

        JLabel label6 = new JLabel("Salary :");
        label6.setBounds(25,306,170,25);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldSalary = new JTextField();
        textFieldSalary.setBounds(248,306,200,20);
        panel.add(textFieldSalary);

        JLabel label8 = new JLabel("Gmail :");
        label8.setBounds(25,351,170,25);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        label8.setForeground(Color.WHITE);
        panel.add(label8);

        JTextField textFieldMail = new JTextField();
        textFieldMail.setBounds(248,351,200,20);
        panel.add(textFieldMail);

        JButton check = new JButton("CHECK");
        check.setBounds(281,398,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from EMP_INFO where Aadhar_Number = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while ((resultSet.next())){
                        textFieldName.setText(resultSet.getString("Name"));
                        textFieldage.setText(resultSet.getString("Age"));
                        textFieldINum.setText(resultSet.getString("Phone_Number"));
                        textFieldwork.setText(resultSet.getString("Work"));
                        textFieldSalary.setText(resultSet.getString("salary"));
                        textFieldMail.setText(resultSet.getString("Gmail"));

                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(56,398,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String name = textFieldName.getText();
                    String age = textFieldage.getText();
                    String num = textFieldINum.getText();
                    String work = textFieldwork.getText();
                    String salary = textFieldSalary.getText();
                    String mail = textFieldMail.getText();

                    c.statement.executeUpdate("update EMP_INFO set Name = '"+name+"', Age = '"+age+"', Phone_Number = '"+num+"', Work = '"+work+"', salary = '"+salary+"', Gmail = '"+mail+"'where Aadhar_Number = '"+q+"' ");
                    JOptionPane.showMessageDialog(null,"Updated Sucessfully");
                    setVisible(false);


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168,398,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    setVisible(false);

            }
        });

        JButton Remove = new JButton("Remove");
        Remove.setBounds(381,398,89,23);
        Remove.setBackground(Color.BLACK);
        Remove.setForeground(Color.white);
        panel.add(Remove);
        Remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from EMP_INFO where Aadhar_Number = '"+choice.getSelectedItem()+"' ");

                    // Create a JOptionPane with the message
                    JOptionPane optionPane = new JOptionPane("Employee Info Removed", JOptionPane.INFORMATION_MESSAGE);

                    // Create a JDialog to customize the location
                    JDialog dialog = optionPane.createDialog("Message");
                    dialog.setLocation(620, 400); // Set the location (x, y)
                    dialog.setVisible(true);
                    setVisible(false);

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(210,220);
        setVisible(true);


    }

    public static void main(String[] args) {
        new update_employee_info();
    }

}
