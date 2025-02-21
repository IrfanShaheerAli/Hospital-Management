package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Patient_Info extends JFrame {
    ALL_Patient_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,1090,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        // Table setup
        JTable table = new JTable();
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Wrap the table in a JScrollPane to allow scrolling
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 1070, 400);  // Adjust to fit panel size
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Set viewport background to match table background to avoid white gap
        scrollPane.getViewport().setBackground(new Color(90, 156, 163));

        try {
            conn c = new conn();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Remove column names
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderValue(""); // Set header values to empty
            }

            table.getColumnModel().getColumn(5).setPreferredWidth(40);
            table.getColumnModel().getColumn(6).setPreferredWidth(170);
            table.getColumnModel().getColumn(7).setPreferredWidth(100);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create and position labels for column names
        JLabel label1 = new JLabel("ID");
        label1.setBounds(51, 11, 100, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("ID Number");
        label2.setBounds(140, 11, 100, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(270, 11, 100, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(365, 11, 100, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(480, 11, 100, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        JLabel label6 = new JLabel("Room");
        label6.setBounds(570, 11, 100, 14);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(720, 11, 100, 14);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(870, 11, 100, 14);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label8);

        JLabel label9 = new JLabel("Total Fees");
        label9.setBounds(990, 11, 100, 14);
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label9);

        JButton button = new JButton("BACK");
        button.setBounds(450, 450, 120, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1100, 500);
        setLayout(null);
        setLocation(150, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ALL_Patient_Info();
    }
}
