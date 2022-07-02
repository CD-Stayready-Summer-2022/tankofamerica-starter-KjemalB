package com.codedifferently.tankofamerica.domain.account.Models;

import com.codedifferently.tankofamerica.domain.user.models.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name= "uuid2", strategy = "uuid2")
    @Type(type="uuid-char")
    private UUID id;

    private String name;
    @ManyToOne()
    private User owner;

    public Account() {
    }
    public Account(String name) {
        this.name = name;
    }

    public Account(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("Account for user %s is named %s and the id is %s", owner.getFirstName(), name, id.toString());
    }
}
