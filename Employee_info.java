package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1090, 490);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Wrap the JTable in a JScrollPane with adjusted height to leave space for the button
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 34, 1070, 380); // Reduced height to make room for the button
        scrollPane.getViewport().setBackground(new Color(109, 164, 170)); // Set scroll pane background color
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Remove column names
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderValue(""); // Set header values to empty
            }
            table.getTableHeader().repaint(); // Refresh table header to reflect changes
            // Set column widths
            table.getColumnModel().getColumn(0).setPreferredWidth(90); // Age column width
            table.getColumnModel().getColumn(2).setPreferredWidth(30); // Age column width
            table.getColumnModel().getColumn(6).setPreferredWidth(150); // Gmail column width
            table.getColumnModel().getColumn(7).setPreferredWidth(100); // Aadhar Number column width
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create and position labels for column names (if needed)
        JLabel label1 = new JLabel("Name");
        label1.setBounds(41, 9, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label9 = new JLabel("Gender");
        label9.setBounds(190, 9, 70, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label9);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(298, 9, 70, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(360, 9, 120, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Work");
        label4.setBounds(510, 9, 70, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label6 = new JLabel("Salary");
        label6.setBounds(630, 9, 70, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);

        JLabel label7 = new JLabel("Gmail");
        label7.setBounds(790, 9, 70, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label7);

        JLabel label8 = new JLabel("Aadhar Number");
        label8.setBounds(935, 9, 150, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label8);

        JButton button = new JButton("BACK");
        button.setBounds(440, 440, 120, 30); // Position the button below the scroll pane
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(1100, 500);
        setLocation(150, 220);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
