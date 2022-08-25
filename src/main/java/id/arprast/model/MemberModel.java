package id.arprast.model;

import java.util.Date;

public class MemberModel {
    private long id;
    private String name;
    private String address;
    private Date birthOfDate;

    public MemberModel(long id, String name, String address, Date birthOfDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthOfDate = birthOfDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }
}
