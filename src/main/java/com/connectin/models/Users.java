package com.connectin.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sanjana on 23/7/17.
 */
@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "userId")})
public class Users implements Serializable {
    @Id
    @Column(name = "userId", unique = true, nullable = false)
    private String userId;
    @Basic
    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName;
    @Basic
    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;
    @Basic
    @Column(name = "Email", length = 50, nullable = false)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != null ? !userId.equals(users.userId) : users.userId != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
        return email != null ? email.equals(users.email) : users.email == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
