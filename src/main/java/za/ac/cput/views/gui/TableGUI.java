package za.ac.cput.views.gui;

import za.ac.cput.domain.Tablee;
import za.ac.cput.views.requests.TableRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class TableGUI {
    private JPanel tablePanel;
    private JTextField textFieldTableId;
    private JTextField textFieldTableNo;
    private JTextField textFieldNumberOfSeats;
    private JCheckBox checkIfAvailableCheckBox;
    private JButton saveButton;
    private JButton viewAllButton;
    private JButton findButton;
    private JButton deleteButton;
    private JTable tableeTable;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel id;
    private JLabel tableNo;
    private JLabel noOfSeats;
    private JLabel available;
    private Font f1,f2;



    public JPanel getPanel(){
        tableRequests();
        createTable();
        showTable();
        f1=new Font("Arial",Font.PLAIN,14);
        f2=new Font("Arial",Font.BOLD,14);
        findButton.setFont(f2);
        viewAllButton.setFont(f2);
        findButton.setFont(f2);
        deleteButton.setFont(f2);
        noOfSeats.setFont(f1);
        available.setFont(f1);
        id.setFont(f1);
        saveButton.setFont(f2);
        comboBox1.setFont(f1);
        comboBox2.setFont(f1);
        tableNo.setFont(f1);
        return tablePanel;
    }

    private void tableRequests(){
        //save table details
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRequest.save(textFieldTableId.getText(), (String)comboBox1.getSelectedItem(), (String) comboBox2.getSelectedItem(), checkIfAvailableCheckBox.isSelected());
                textFieldTableId.setText("");
                comboBox1.setSelectedIndex(0);
                comboBox2.setSelectedIndex(0);
                checkIfAvailableCheckBox.setSelected(false);
                showTable();
            }
        });
        //View all
        viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable();
                showTable();

            }
        });
        //Find by Id
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRequest.viewById(textFieldTableId.getText());
                showTableById();
            }
        });
        //Delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRequest.delete(textFieldTableId.getText());
                showTable();
            }
        });
    }
    private void createTable(){
        tableeTable.setModel(new DefaultTableModel(
                null,
                new String[] {"ID", "Table No", "Number of Seats", "Available"}
        ));
    }
    private void showTable(){
        DefaultTableModel model = (DefaultTableModel) tableeTable.getModel();

        List tableCreateList = TableRequest.getAll();
        List<Tablee> tableeList = tableCreateList;
        model.setRowCount(0);
        for (int i = 0; i < tableeList.size(); i++){
            model.addRow(
                    new Object[] {
                            tableeList.get(i).getTableId(),
                            tableeList.get(i).getTableNo(),
                            tableeList.get(i).getNoOfSeats(),
                            tableeList.get(i).isTableAvailable()
                    }
            );
        }
    }
    private void showTableById(){
        DefaultTableModel model = (DefaultTableModel) tableeTable.getModel();

        List tableCreateList = TableRequest.getAll();
        List<Tablee> tableeList = tableCreateList;
        model.setRowCount(0);
        for (Tablee tablee : tableeList){
            if (tablee.getTableId().equals(textFieldTableId.getText())){
                model.addRow(
                        new Object[] {
                                tablee.getTableId(),
                                tablee.getTableNo(),
                                tablee.getNoOfSeats(),
                                tablee.isTableAvailable()
                        }
                );
            }
        }
    }
}
