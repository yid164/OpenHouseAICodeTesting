package com.example.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * User Entity for the MongoDB
 */
@Document
public class User {

    /**
     * user Id
     */
    @Id
    private String userId;

    /**
     * session Id
     */
    private String sessionId;

    /**
     * actions
     */
    private List<Action> actions;


    /**
     * Constructors and Getter and Setter
     */
    public User(){}

    public User(String userId, String sessionId){
        this.userId = userId;
        this.sessionId = sessionId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (sessionId != null ? !sessionId.equals(user.sessionId) : user.sessionId != null) return false;
        return actions != null ? actions.equals(user.actions) : user.actions == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (actions != null ? actions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userId='" + userId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", actions=" + actions +'\''+
                '}';
    }
}
