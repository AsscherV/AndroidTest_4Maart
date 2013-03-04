package com.example.trippyTraveler_android.controllers;


import com.example.trippyTraveler_android.Globals;
import com.example.trippyTraveler_android.model.TripUser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;


public class NetworkController {
	
	private DataFetcher dataFetcher;
	private DataParser dataParser;
	
	public NetworkController() {
		this.dataParser = new DataParser();
		this.dataFetcher = new DataFetcher();
	}
	
	public TripUser getDataFromServer(String path) throws IOException {
		return dataParser.parseData(dataFetcher.getFromServer(new DataFetcher.ResponseHandler() {
			@Override
			public String handleResponse(InputStream input) throws IOException {
				return IOUtils.toString(input);
			}
		}, path, Globals.connectTimeout, Globals.readTimeout));
	}
	
}
