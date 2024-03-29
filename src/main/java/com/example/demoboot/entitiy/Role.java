package com.example.demoboot.entitiy;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }


    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId(long id) {
        return this.id;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
    public String RoletoString() {
        if (getName().equals("ROLE_ADMIN")) {
            return "ADMIN";
        }
        if (getName().equals("ROLE_USER")) {
            return "USER";
        }
        else return "ADMIN USER ";
    }

}



