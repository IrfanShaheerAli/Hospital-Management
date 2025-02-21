package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {
    update_patient_details(){

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

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Patient Id :");
        label2.setBounds(25,88,150,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,200,25);
        panel.add(choice);

        try {
            conn c =  new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Number"));

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


        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,174,150,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,174,200,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,216,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248,216,200,20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25,261,150,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,261,200,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25,306,170,25);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,306,200,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Number = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while ((resultSet.next())){
                        textFieldName.setText(resultSet.getString("Name"));
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));

                    }
                    c.statement.executeUpdate("update Room set Availability = 'Available' where room_no = '"+textFieldR.getText()+"' ");
                    ResultSet resultSet1 = c.statement.executeQuery("select * from patient_info where Number = '"+id+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Total_fees");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
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
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Name = '"+name+"', Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"'where Number = '"+q+"' ");
                    c.statement.executeUpdate("update Room set Availability = 'Occupied' where room_no = '"+room+"' ");
                    JOptionPane.showMessageDialog(null,"Updated Sucessfully");
                    setVisible(false);


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String name = textFieldName.getText();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Name = '"+name+"', Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amount+"'where Number = '"+q+"' ");
                    c.statement.executeUpdate("update Room set Availability = 'Occupied' where room_no = '"+room+"' ");
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
        new update_patient_details();
    }
}
