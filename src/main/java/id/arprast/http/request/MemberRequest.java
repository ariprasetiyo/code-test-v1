package id.arprast.http.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class MemberRequest {

    @Valid
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private Date birthOfDate;

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
