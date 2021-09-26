package Business;

import java.io.Serializable;

public class CustomerInfo implements Serializable {

    public int id;
    public String name, phone, email, province, postalCode;

    public CustomerInfo(int id, String name, String phone, String email, String province, String postalCode) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.province = province;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
