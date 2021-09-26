package Presentation;

import Data.BinaryIO;

import javax.swing.JOptionPane;

public class Validator {

    BinaryIO binaryIO = new BinaryIO();

    public boolean validationDurAdd(int cusId, String name, String phone, String email, String posCode) {
        if (binaryIO.chkCusId(cusId)) {
            if (!name.isEmpty()) {
                if (!phone.isEmpty()) {
                    if (!email.isEmpty()) {
                        if (!posCode.isEmpty()) {
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Postal Code Required");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Email Required");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Phone Required");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Name Reuired");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Customer ID already exist");
        }
        return false;
    }

    public boolean validationDurUpdate(int cusId, String name, String phone, String email, String posCode) {
        if (!binaryIO.chkCusId(cusId)) {
            if (!name.isEmpty()) {
                if (!phone.isEmpty()) {
                    if (!email.isEmpty()) {
                        if (!posCode.isEmpty()) {
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Postal Code Required");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Email Required");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Phone Required");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Name Reuired");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Customer ID not exist");
        }
        return false;
    }
}
