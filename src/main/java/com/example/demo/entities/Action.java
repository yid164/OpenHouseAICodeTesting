package com.example.demo.entities;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * Action Entity
 */
public class Action {

    @Id
    private ObjectId id;

    private String time;

    private String type;

    private User user;

    private ArrayList<Property> properties;

    public Action(){}

    public Action(String time, String type){
        this.time = time;
        this.type = type;
    }

    public ObjectId getId(){
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (id != null ? !id.equals(action.id) : action.id != null) return false;
        if (time != null ? !time.equals(action.time) : action.time != null) return false;
        if (type != null ? !type.equals(action.type) : action.type != null) return false;
        if (user != null ? !user.equals(action.user) : action.user != null) return false;
        return properties != null ? properties.equals(action.properties) : action.properties == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Action{" +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", properties=" + properties +
                '}';
    }
}
