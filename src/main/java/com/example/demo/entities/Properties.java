package com.example.demo.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Properties Entity for the MongoDB
 */
@Document
public class Properties {
    /**
     * id
     */
    @Id
    private ObjectId id;

    /**
     * locationX and locationY
     */
    private int locationX;
    private int locationY;

    /**
     * Viewed ID
     */
    private String viewedId;

    /**
     * PageFrom
     */
    private String pageFrom;

    /**
     * PageTo
     */
    private String pageTo;

    /**
     * Constructors and Getter and Setter
     */
    public Properties(){

    }
    @PersistenceConstructor
    public Properties(ObjectId id, int locationX, int locationY, String viewedId, String pageFrom, String pageTo){
        this.id = id;
        this.locationX = locationX;
        this.locationY = locationY;
        this.viewedId = viewedId;
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

    public String getViewedId() {
        return viewedId;
    }

    public void setViewedId(String viewedId) {
        this.viewedId = viewedId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Properties properties = (Properties) o;

        if (locationX != properties.locationX) return false;
        if (locationY != properties.locationY) return false;
        if (id != null ? !id.equals(properties.id) : properties.id != null) return false;
        if (viewedId != null ? !viewedId.equals(properties.viewedId) : properties.viewedId != null) return false;
        if (pageFrom != null ? !pageFrom.equals(properties.pageFrom) : properties.pageFrom != null) return false;
        return (pageTo != null ? !pageTo.equals(properties.pageTo) : properties.pageTo != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + locationX;
        result = 31 * result + locationY;
        result = 31 * result + (viewedId != null ? viewedId.hashCode() : 0);
        result = 31 * result + (pageFrom != null ? pageFrom.hashCode() : 0);
        result = 31 * result + (pageTo != null ? pageTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "locationX=" + locationX +
                ", locationY=" + locationY +
                ", viewedId='" + viewedId + '\'' +
                ", pageFrom='" + pageFrom + '\'' +
                ", pageTo='" + pageTo + '\'' +
                '}';
    }
}
