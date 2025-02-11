package com.fowobi.networking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_keep_alive")
public class KeepAliveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String host;
    private String department;

    public KeepAliveEntity(long id, String host, String department) {
        this.id = id;
        this.host = host;
        this.department = department;
    }

    public KeepAliveEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
