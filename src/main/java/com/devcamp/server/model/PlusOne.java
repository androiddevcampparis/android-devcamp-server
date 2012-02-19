package com.devcamp.server.model;

import com.google.code.morphia.annotations.Embedded;
import org.bson.types.ObjectId;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/19/12
 * Time: 5:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Embedded
public class PlusOne {
    public ObjectId id;
    public String md5;
    public String bool;

    public PlusOne(){

    }

    public PlusOne(ObjectId id, String md5, String bool) {
        this.id = id;
        this.md5 = md5;
        this.bool = bool;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getBool() {
        return bool;
    }

    public void setBool(String bool) {
        this.bool = bool;
    }
}
