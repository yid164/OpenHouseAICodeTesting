package com.example.demo.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Properties {
    @Id
    private ObjectId id;
    private int locationX;
    private int locationY;
    private String viewedID;
    private String pageFrom;
    private String pageTo;
    private String actionId;

    public Properties(){

    }
    @PersistenceConstructor
    public Properties(int locationX, int locationY, String viewedID, String pageFrom, String pageTo){
        this.locationX = locationX;
        this.locationY = locationY;
        this.viewedID = viewedID;
        this.pageFrom = pageFrom;
        this.pageTo = pageTo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public String getViewedID() {
        return viewedID;
    }

    public void setViewedID(String viewedID) {
        this.viewedID = viewedID;
    }

    public String getPageFrom() {
        return pageFrom;
    }

    public void setPageFrom(String pageFrom) {
        this.pageFrom = pageFrom;
    }

    public String getPageTo() {
        return pageTo;
    }

    public void setPageTo(String pageTo) {
        this.pageTo = pageTo;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Properties properties = (Properties) o;

        if (locationX != properties.locationX) return false;
        if (locationY != properties.locationY) return false;
        if (id != null ? !id.equals(properties.id) : properties.id != null) return false;
        if (viewedID != null ? !viewedID.equals(properties.viewedID) : properties.viewedID != null) return false;
        if (pageFrom != null ? !pageFrom.equals(properties.pageFrom) : properties.pageFrom != null) return false;
        if (pageTo != null ? !pageTo.equals(properties.pageTo) : properties.pageTo != null) return false;
        return actionId != null ? actionId.equals(properties.actionId) : properties.actionId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + locationX;
        result = 31 * result + locationY;
        result = 31 * result + (viewedID != null ? viewedID.hashCode() : 0);
        result = 31 * result + (pageFrom != null ? pageFrom.hashCode() : 0);
        result = 31 * result + (pageTo != null ? pageTo.hashCode() : 0);
        result = 31 * result + (actionId != null ? actionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "locationX=" + locationX +
                ", locationY=" + locationY +
                ", viewedID='" + viewedID + '\'' +
                ", pageFrom='" + pageFrom + '\'' +
                ", pageTo='" + pageTo + '\'' +
                '}';
    }
}
