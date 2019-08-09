package com.daoxuanson.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends Base{
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;



	@ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
