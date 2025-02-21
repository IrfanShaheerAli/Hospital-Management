package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490); // Corrected the panel width here for clarity
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel labelFor = new JLabel("Search For Room");
        labelFor.setBounds(250, 11, 186, 31);
        labelFor.setForeground(Color.WHITE);
        labelFor.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelFor);

        JLabel labelStatus = new JLabel("Status :");
        labelStatus.setBounds(70, 70, 80, 20);
        labelStatus.setForeground(Color.WHITE);
        labelStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelStatus);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        // Initialize the JTable and wrap it in a JScrollPane
        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 187, 680, 210); // Adjusted the bounds to fit within the panel
        panel.add(scrollPane); // Add the scrollPane instead of the table directly

        // Set viewport background to match table background to avoid white gap
        scrollPane.getViewport().setBackground(new Color(90, 156, 163));


        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            // Remove column names
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderValue(""); // Set header values to empty
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23,162,150,20);
        Roomno.setForeground(Color.WHITE);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(220,162,150,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(400,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel type = new JLabel("Room Type");
        type.setBounds(540,162,150,20);
        type.setForeground(Color.WHITE);
        type.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(type);

        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,30);
        Search.setBackground(Color.black);
        Search.setForeground(Color.WHITE);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                    // Remove column names after updating the model
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        table.getColumnModel().getColumn(i).setHeaderValue(""); // Set header values to empty
                    }
                    // Refresh the table display to reflect the header change
                    table.getTableHeader().repaint();



                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380,420,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(350, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
