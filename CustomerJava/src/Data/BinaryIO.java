package Data;
//import packages
import Business.CustomerInfo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryIO {
//declare variables for binary file
    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    public boolean chkCusId(int cusId) {
//method to check customer ID is already present in files or not.
        try {

            File f = new File("CustomerData.dat");
            if (f.exists()) {

                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
//arraylist because of binary file
                ArrayList<CustomerInfo> infos = (ArrayList<CustomerInfo>) ois.readObject();
                ois.close();

                if (infos != null) {

                    for (CustomerInfo info : infos) {
                        if (info.id == cusId) {
                            return false;
                        }
                    }

                }

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }

        return true;
    }
//method to write data in binary file
    public void writeData(CustomerInfo customerInfo) {

        File f = new File("CustomerData.dat");
        ArrayList<CustomerInfo> infos = new ArrayList<>();
//1st read previous data and save into file
        try {

            if (f.exists()) {

                ois = new ObjectInputStream(new FileInputStream(f));
                infos = (ArrayList<CustomerInfo>) ois.readObject();
                ois.close();

                if (infos == null) {
                    infos = new ArrayList<>();
                }
            }

        } catch (Exception e) {
            infos = new ArrayList<>();
        }
//then add all arrayList data at a time in binary file
        try {

            infos.add(customerInfo);

            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(infos);
            fos.close();
            oos.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
//method to find customer details by given customer id
    public String findCustomer(int cusId) {
        try {

            File f = new File("CustomerData.dat");
            if (f.exists()) {

                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);

                ArrayList<CustomerInfo> infos = (ArrayList<CustomerInfo>) ois.readObject();
                ois.close();

                if (infos != null) {

                    for (CustomerInfo customerInfo : infos) {
                        if (customerInfo.id == cusId) {
                            String str = "Customer ID: " + customerInfo.getId()
                                    + "\nName: " + customerInfo.getName() + "\nPhone: " + customerInfo.getPhone()
                                    + "\nEmail: " + customerInfo.getEmail() + "\nProvince: " + customerInfo.getProvince()
                                    + "\nPostal Code: " + customerInfo.getPostalCode();
                            return str;
                        }
                    }

                }

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }

        return null;
    }

    public String listCustomers() {
        String str = "";
        try {

            File f = new File("CustomerData.dat");
            if (f.exists()) {

                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);

                ArrayList<CustomerInfo> infos = (ArrayList<CustomerInfo>) ois.readObject();
                ois.close();

                if (infos != null) {

                    for (CustomerInfo customerInfo : infos) {
                        str += "Customer ID: " + customerInfo.getId()
                                + "\nName: " + customerInfo.getName() + "\nPhone: " + customerInfo.getPhone()
                                + "\nEmail: " + customerInfo.getEmail() + "\nProvince: " + customerInfo.getProvince()
                                + "\nPostal Code: " + customerInfo.getPostalCode()
                                + "\n\n";

                    }

                }

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return str;
    }
//method that update data given customer ID 9use setter method of customer info class
    public void updateData(CustomerInfo customerInfo) {

        File f = new File("CustomerData.dat");
        ArrayList<CustomerInfo> infos = new ArrayList<>();

        try {

            if (f.exists()) {

                ois = new ObjectInputStream(new FileInputStream(f));
                infos = (ArrayList<CustomerInfo>) ois.readObject();
                ois.close();

                if (infos == null) {
                    infos = new ArrayList<>();
                }
            }

        } catch (Exception e) {
            infos = new ArrayList<>();
        }

        for (CustomerInfo info : infos) {
            if (info.getId() == customerInfo.getId()) {
                info.setName(customerInfo.getName());
                info.setPhone(customerInfo.getPhone());
                info.setEmail(customerInfo.getEmail());
                info.setProvince(customerInfo.getProvince());
                info.setPostalCode(customerInfo.getPostalCode());
            }
        }

        try {

            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(infos);
            fos.close();
            oos.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
