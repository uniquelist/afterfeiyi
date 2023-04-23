package com.feiyi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.awt.*;
import java.util.Date;
import java.util.List;

@Data
public class Images {
    private String username;
    private int id;
    private String title;
    private String description;
    private String url;
    private int createdby_id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created_date;
    private int status;
    //用户
    private List<User> users;

    public Images() {
    }

    public Images(int id, String title, String description, String url, int createdby_id, Date created_date, int status, List<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.createdby_id = createdby_id;
        this.created_date = created_date;
        this.status = status;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", createdby_id=" + createdby_id +
                ", created_date=" + created_date +
                ", status=" + status +
                ", users=" + users +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCreatedby_id() {
        return createdby_id;
    }

    public void setCreatedby_id(int createdby_id) {
        this.createdby_id = createdby_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
