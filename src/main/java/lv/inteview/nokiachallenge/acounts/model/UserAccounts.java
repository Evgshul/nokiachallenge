package lv.inteview.nokiachallenge.acounts.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_accounts")
public class UserAccounts {

    @Id
    @NotNull(message = "ID is required")
    private Long id;

    @NotNull(message = "name is required")
    @Size(min = 3, max = 150, message = "name should be minimum 3 and maximum 150 characters long")
    private String name;

    @NotNull(message = "phone is required")
    @Size(min = 9, max = 12, message = "phone should be minimum 3 and maximum 12 characters long")
    private String phone;

    @NotNull(message = "email is required")
    @Size(max = 200, message = "email should be maximum 200 characters long")
    private String email;

    @Size(max = 200, message = "should be maximum 200 characters long")
    private String address;

    @NotNull(message = "country is required")
    @Size(max = 56, message = "country should be maximum 56 characters long")
    private String country;

    @NotNull(message = "department is required")
    @Size(max = 50, message = "country should be maximum 56 characters long")
    private String department;

    public UserAccounts() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "UserAccounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
