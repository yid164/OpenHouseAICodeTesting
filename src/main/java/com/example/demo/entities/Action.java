package com.example.demo.entities;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Action Entity for the MongoDB
 */
@Document
public class Action {

    /**
     * Id
     */
    @Id
    private ObjectId id;



    /**
     * time
     */
    private Date time;


    /**
     * type
     */
    private String type;

    /**
     * properties
     */
    private Properties properties;

    /**
     * Constructors and Getter and Setter
     */
    public Action(){}

    @PersistenceConstructor
    public Action(ObjectId id, Date time, String type){
        this.id = id;
        this.time = time;
        this.type = type;
    }

    public ObjectId getId(){
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
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
//        if (user != null ? !user.equals(action.user) : action.user != null) return false;
        return properties != null ? properties.equals(action.properties) : action.properties == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
//        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Action{" +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
//                ", user=" + user +
                ", properties=" + properties +
                '}';
    }
}
