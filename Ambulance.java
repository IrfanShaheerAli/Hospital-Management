package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Choice choice,choice1;
    private JTable table; // Declare table as a class member

    // Method to refresh the table data
    private void refreshTable() {
        try {
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Remove column names
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderValue(""); // Set header values to empty
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Ambulance() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1090, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Update Ambulance Status");
        label.setBounds(400, 11, 300, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(label);

        JLabel vehicle = new JLabel("Select Vehicle Number :");
        vehicle.setBounds(20, 51, 180, 14);
        vehicle.setFont(new Font("Tahoma", Font.BOLD, 14));
        vehicle.setForeground(Color.WHITE);
        panel.add(vehicle);

        choice = new Choice();
        choice.setBounds(250, 51, 200, 14);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Ambulance");
            while (resultSet.next()) {
                choice.add(resultSet.getString("License_Plate"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JLabel status = new JLabel("Select Status :");
        status.setBounds(20, 81, 180, 14);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        status.setForeground(Color.WHITE);
        panel.add(status);

        choice1 = new Choice();
        choice1.setBounds(250, 81, 200, 14);
        choice1.add("Available");
        choice1.add("Occupied");
        panel.add(choice1);

        JButton update = new JButton("Update");
        update.setBounds(250, 111, 200, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String avl = choice1.getSelectedItem();
                    c.statement.executeUpdate("update Ambulance set Availability = '" + avl + "' where License_Plate = '" + q + "' ");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    refreshTable(); // Refresh table after update
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        // Table setup
        table = new JTable(); // Initialize the table
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Wrap the table in a JScrollPane to allow scrolling
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 200, 1070, 250); // Adjust to fit panel size
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Set viewport background to match table background to avoid white gap
        scrollPane.getViewport().setBackground(new Color(90, 156, 163));

        // Populate the table initially
        refreshTable(); // Call to fill the table with initial data

        JLabel label1 = new JLabel("Name");
        label1.setBounds(51, 170, 100, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Contact Number");
        label2.setBounds(200, 170, 150, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("License Plate");
        label3.setBounds(420, 170, 100, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Type");
        label4.setBounds(580, 170, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel label5 = new JLabel("Availability");
        label5.setBounds(780, 170, 100, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JLabel label6 = new JLabel("Location");
        label6.setBounds(950, 170, 100, 14);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JButton button = new JButton("BACK");
        button.setBounds(450, 460, 120, 30);
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
        new Ambulance();
    }
}
