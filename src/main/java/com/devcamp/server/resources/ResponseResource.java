package com.devcamp.server.resources;

import com.devcamp.server.model.PoiData;
import com.devcamp.server.service.PoiDataService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/")
public class ResponseResource {

    PoiDataService poiService;

    public ResponseResource(){

        poiService = new PoiDataService();
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
        poiData.setLongitute(Double.valueOf(reqs[1]));

        //find the closest neighbors
        List<ResponseData> responses= poiService.findData(poiData, radius, category);
        ResponseConverter rc = new ResponseConverter();
        rc.setPoiDatas(responses);

        return rc;

    }


    public static void main(String[] args){
        ResponseResource rr = new ResponseResource();
        //

        for(ResponseData resd : rr.getClosestPOI("5+8+1000+monument").getPoiDatas()){
            System.out.println(resd);

        }
    }
}
