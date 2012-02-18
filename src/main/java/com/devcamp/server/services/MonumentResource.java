package com.devcamp.server.services;

import com.devcamp.server.model.Monument;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/18/12
 * Time: 5:20 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/monument/")
public class MonumentResource {

    @GET
    @Path("/{geoloc}")
    @Produces("application/json")
    public Monument getMonumentByLocation(@PathParam("geoloc")String coord){
        Monument monument = null;


        return monument;
    }


    public List<Monument> getMonumentsByLoc(){

        return null;
    }

    @GET
    @Path("/{interest}")
    @Produces("application/json")
    public Monument getMonumentByInterests(@PathParam("interests")String interests){



        return null;

    }

}
