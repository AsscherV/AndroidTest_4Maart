package com.example.trippyTraveler_android.controllers;

import com.example.trippyTraveler_android.Globals;
import com.example.trippyTraveler_android.model.TripUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import flexjson.JSONDeserializer;

import javax.ws.rs.core.MediaType;
import java.lang.reflect.Type;


public class DataParser {

	public DataParser() {
		
	}
	
	public TripUser parseData(String data) {

        /*
		Gson gson = new GsonBuilder().create();
		Type rootType = new TypeToken<TripUser>(){}.getType();
		
		TripUser object = gson.fromJson(data, rootType);
		if(object == null) {
			throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
		}
        return object;
        */

        //TODO:Model tripuser overnemen van webapp. Trips moeten eraan kunnen hangen
        TripUser Tuser = null;
        try{
            Tuser = new JSONDeserializer<TripUser>().deserialize(data);
            if (Tuser == null) {
                throw new JsonSyntaxException("Error while parsing data from JSON: " + data);
            }
        }catch (Exception ex){
            System.out.println("FB"+ex.getMessage().toString());
        }

        System.out.println("OUTPUT"+data.toString());
        return Tuser;

	}


}
