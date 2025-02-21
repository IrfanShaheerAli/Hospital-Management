package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        // Table setup
        JTable table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));

        // Wrap the tabale in a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 690, 350);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Set viewport background to match table background to avoid white gap
        scrollPane.getViewport().setBackground(new Color(90, 156, 163));

        try {
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Remove column names
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderValue(""); // Set header values to empty
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Column header labels
        JLabel label1 = new JLabel("Department");
        label1.setBounds(145, 11, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(431, 11, 105, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        // Back button
        JButton b1 = new JButton("Back");
        b1.setBounds(400, 410, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(330, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
