package vn.edu.ntu.nhatduy.model;

public class Contact {
    String name;
    String date;
    String sdt;

    public Contact(String name, String date, String sdt) {
        this.name = name;
        this.date = date;
        this.sdt = sdt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
