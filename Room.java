package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;

    Room() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Image setup
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 130, 200, 200);
        panel.add(label);

        // Table setup
        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };

        table.setBackground(new Color(90, 156, 163));

        // Adding scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 500, 380);// Matching panel bounds
        panel.add(scrollPane);

        // Load data from the database
        try {
            conn c = new conn();
            String q = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Remove column headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderValue(null); // Set headers to null
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Column labels
        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12, 15, 80, 15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(140, 15, 80, 15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(290, 15, 80, 15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Room Type");
        label4.setBounds(400, 15, 80, 15);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        // Back button
        JButton back = new JButton("Back");
        back.setBounds(680, 430, 120, 30); // Adjusted position
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850, 500);
        setLayout(null);
        setLocation(270, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
