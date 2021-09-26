package Presentation;

import Business.CustomerInfo;
import Data.BinaryIO;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class CustomersGUI {

    private JFrame frmIsmailaCustomerSystem;
    private final JLabel lblNewLabel = new JLabel("Customer id");
    private final JTextField txtCusId = new JTextField();
    private JTextField txtName;
    private JTextField txtPhoneNo;
    private JTextField txtEmail;
    private JTextField txtPostalCode;

    BinaryIO binaryIO = new BinaryIO();
    Validator validator = new Validator();
    CustomerInfo customerInfo;

    public CustomersGUI() {
        initialize();
    }

    private void initialize() {
        txtCusId.setBounds(163, 34, 136, 27);
        txtCusId.setColumns(10);
        frmIsmailaCustomerSystem = new JFrame("CUSTOMER SYSTEM");
        frmIsmailaCustomerSystem.setTitle("ISMAILA CUSTOMER SYSTEM");
        frmIsmailaCustomerSystem.setBackground(Color.BLUE);
        frmIsmailaCustomerSystem.setBounds(100, 100, 511, 497);
        frmIsmailaCustomerSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel AuthorLabel = new JLabel("Author Name");

        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);

        frmIsmailaCustomerSystem.getContentPane().add(panel);
        panel.setLayout(null);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(69, 30, 89, 31);
        panel.add(lblNewLabel);

        panel.add(txtCusId);

        JLabel lblNewLabel_1 = new JLabel("Email");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(69, 134, 46, 14);
        panel.add(lblNewLabel_1);

        txtEmail = new JTextField();
        txtEmail.setBounds(163, 133, 136, 20);
        panel.add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Province");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2.setBounds(69, 167, 86, 14);
        panel.add(lblNewLabel_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(39, 267, 423, 132);
        panel.add(scrollPane);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBounds(39, 230, 89, 23);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Find Customer");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBounds(141, 230, 89, 23);
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Update");
        btnNewButton_2.setBounds(251, 230, 89, 23);
        panel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Display All Customer");
        btnNewButton_3.setBounds(350, 230, 112, 23);
        panel.add(btnNewButton_3);

        JLabel lblNewLabel_3 = new JLabel("Phone");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3.setBounds(69, 92, 98, 31);
        panel.add(lblNewLabel_3);

        txtPhoneNo = new JTextField();
        txtPhoneNo.setColumns(10);
        txtPhoneNo.setBounds(163, 102, 136, 20);
        panel.add(txtPhoneNo);

        JLabel lblNewLabel_3_1 = new JLabel("Name");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_3_1.setBounds(69, 62, 98, 31);
        panel.add(lblNewLabel_3_1);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(163, 72, 136, 24);
        panel.add(txtName);

        //to drop box list the City.
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 9));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"AB", "BC", "MB", "NB", "NL", "NT", "NS", "PEI", "ON", "QC", "SK", "YT"}));
        comboBox.setBounds(163, 161, 71, 31);
        //contentpanel.add(comboBox);
        panel.add(comboBox);

        JLabel lblNewLabel_1_1 = new JLabel("PostalCode");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(69, 199, 98, 20);
        panel.add(lblNewLabel_1_1);

        txtPostalCode = new JTextField();
        txtPostalCode.setColumns(10);
        txtPostalCode.setBounds(163, 199, 136, 20);
        panel.add(txtPostalCode);
        frmIsmailaCustomerSystem.setVisible(true);

        ActionListener btnAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int cusId = Integer.parseInt(txtCusId.getText());
                    String name = txtName.getText().trim();
                    String phone = txtPhoneNo.getText().trim();
                    String email = txtEmail.getText().trim();
                    String province = comboBox.getSelectedItem().toString();
                    String posCode = txtPostalCode.getText().trim();
                    if (validator.validationDurAdd(cusId, name, phone, email, posCode)) {
                        customerInfo = new CustomerInfo(cusId, name, phone, email, province, posCode);
                        binaryIO.writeData(customerInfo);
                        JOptionPane.showMessageDialog(null, "Successfull");
                        txtCusId.setText("");
                        txtName.setText("");
                        txtEmail.setText("");
                        txtPhoneNo.setText("");
                        txtPostalCode.setText("");
                        comboBox.setSelectedIndex(0);
                    }

                } catch (HeadlessException | NumberFormatException NumberFormatException) {
                    JOptionPane.showMessageDialog(null, "Customer ID Required (should be a Number)");
                }

            }

        };

        ActionListener btnFind = (ActionEvent e) -> {
            textArea.setText("");
            Font font = new Font("TimesRoman", Font.BOLD, 15);
            textArea.setFont(font);
            try {
                int cusId = Integer.parseInt(txtCusId.getText());
                String result = binaryIO.findCustomer(cusId);
                if (result != null) {
                    textArea.append(result);
                } else {
                    JOptionPane.showMessageDialog(null, "Not found..");
                }
            } catch (HeadlessException | NumberFormatException NumberFormatException) {
                JOptionPane.showMessageDialog(null, "Customer ID Required (should be a Number)");
            }
        };
        
        ActionListener btnUpdate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int cusId = Integer.parseInt(txtCusId.getText());
                    String name = txtName.getText().trim();
                    String phone = txtPhoneNo.getText().trim();
                    String email = txtEmail.getText().trim();
                    String province = comboBox.getSelectedItem().toString();
                    String posCode = txtPostalCode.getText().trim();
                    if (validator.validationDurUpdate(cusId, name, phone, email, posCode)) {
                        customerInfo = new CustomerInfo(cusId, name, phone, email, province, posCode);
                        binaryIO.updateData(customerInfo);
                        JOptionPane.showMessageDialog(null, "Successfull");
                        txtCusId.setText("");
                        txtName.setText("");
                        txtEmail.setText("");
                        txtPhoneNo.setText("");
                        txtPostalCode.setText("");
                        comboBox.setSelectedIndex(0);
                    }

                } catch (HeadlessException | NumberFormatException NumberFormatException) {
                    JOptionPane.showMessageDialog(null, "Customer ID Required (should be a Number)");
                }

            }

        };
        
        ActionListener btnList = (ActionEvent e) -> {
            textArea.setText("");
            Font font1 = new Font("TimesRoman", Font.PLAIN, 14);
            textArea.setFont(font1);

            String result = binaryIO.listCustomers();
            if (!"".equals(result)) {
                textArea.append(result);
            } else {
                JOptionPane.showMessageDialog(null, "Not a single book in Library");
            }
        };

        btnNewButton.addActionListener(btnAdd);
        btnNewButton_1.addActionListener(btnFind);
        btnNewButton_2.addActionListener(btnUpdate);
        btnNewButton_3.addActionListener(btnList);
    }
}
