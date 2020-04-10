package com.example.demo.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Property {
    @Id
    private String id;
    private int locationX;
    private int locationY;
    private String viewedID;
    private String pageFrom;
    private String pageTo;
    private String actionId;

    public Property(){

    }

    public Property(int locationX, int locationY, String viewedID, String pageFrom, String pageTo){
        this.locationX = locationX;
        this.locationY = locationY;
        this.viewedID = viewedID;
        this.pageFrom = pageFrom;
        this.pageTo = pageTo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

        Property property = (Property) o;

        if (locationX != property.locationX) return false;
        if (locationY != property.locationY) return false;
        if (id != null ? !id.equals(property.id) : property.id != null) return false;
        if (viewedID != null ? !viewedID.equals(property.viewedID) : property.viewedID != null) return false;
        if (pageFrom != null ? !pageFrom.equals(property.pageFrom) : property.pageFrom != null) return false;
        if (pageTo != null ? !pageTo.equals(property.pageTo) : property.pageTo != null) return false;
        return actionId != null ? actionId.equals(property.actionId) : property.actionId == null;
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
        return "Property{" +
                "locationX=" + locationX +
                ", locationY=" + locationY +
                ", viewedID='" + viewedID + '\'' +
                ", pageFrom='" + pageFrom + '\'' +
                ", pageTo='" + pageTo + '\'' +
                '}';
    }
}
