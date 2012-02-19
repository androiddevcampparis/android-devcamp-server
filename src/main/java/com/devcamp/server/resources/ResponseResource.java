package com.devcamp.server.resources;

import com.devcamp.server.model.PlusOne;
import com.devcamp.server.model.PoiData;
import com.devcamp.server.service.MongoService;
import com.devcamp.server.service.PoiDataService;
import org.bson.types.ObjectId;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class ResponseResource {

    MongoService mongoService;

    PoiDataService poiService;

    public ResponseResource(){

        poiService = new PoiDataService();
        mongoService = new MongoService();
    }

    @GET
    @Path("/poi/{requestUrl}")
    @Produces("application/json")
    public ResponseConverter getClosestPOI(@PathParam("requestUrl")String req){

        //Parse requestUrl
        String[] reqs = req.split("\\+");
        Double radius = Double.valueOf(reqs[2]);
        String category = reqs[3];
        PoiData poiData = new PoiData();
        poiData.setLatitude(Double.valueOf(reqs[0]));
        poiData.setLongitude(Double.valueOf(reqs[1]));

        //find the closest neighbors
        List<ResponseData> responses= poiService.findData(poiData, radius, category);
        ResponseConverter rc = new ResponseConverter();
        rc.setPoiDatas(responses);

        return rc;

    }


    @GET
    @Path("/plus/{req_url}")
    public Response addPlusOne(@PathParam(value = "req_url") String req_url){
         //Parse req_url
        String[] reqs=req_url.split("\\+");
        PlusOne plusOne = new PlusOne(new ObjectId(reqs[0]),reqs[1],reqs[2]);
        //Add to the corresponding plusone  to corresponding datapoi
        PoiData poiData = mongoService.getDs().get(PoiData.class, plusOne.getId());
        poiData.getPlusOneList().add(plusOne);
        mongoService.getDs().save(PoiData.class);


        return Response.status(200).entity("OK").build();
    }


    @GET
    @Path("/initmongo")
    public Response initMongo(){
        String s = mongoService.initMongoCloud();
        return Response.status(200).entity(s).build();
    }

}
