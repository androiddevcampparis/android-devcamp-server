package com.devcamp.server.util;

import com.devcamp.server.model.poi.Monument;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/18/12
 * Time: 2:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProcessMonumentFile {
    private final static String MONUMENTS_RESOURCES_URL="http://www.data.gouv.fr/var/download/MH-Ile-de-France.txt";

    
    public static List<Monument> parseTextFile(){
        List<Monument> monuments = new ArrayList<Monument>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new URL(MONUMENTS_RESOURCES_URL).openStream());
            scanner.nextLine();
            while ( scanner.hasNextLine() ){
                String[] lines = (scanner.nextLine()).split("\t");
                if (lines.length == 14){
                    Monument monument = new Monument(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6],lines[7],
                            lines[8],lines[9],lines[10],lines[11],lines[12],lines[13]);

                    monuments.add(monument);
                }

            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            scanner.close();
        }
        return monuments;

    }

    private static String serializeToJson(List<Monument> monuments){
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        sb.append("{" + "\n");
        for (Monument m : monuments){
            sb.append(gson.toJson(m));
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();

    }


}
