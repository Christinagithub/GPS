package com.map;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Getlocation {
	private static final String KEY=JsdkCommonUtil.getProJsdk().getProperty("key");
	 
	public static Map<String,Object> getlocation(String Ing,String Iat){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String urlString = "https://apis.map.qq.com/ws/geocoder/v1/?location= "+ Iat+","+Ing+"&key="+KEY;
		String result="";
				try {
					URL url= new URL(urlString);
					HttpURLConnection conn= (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("GET");
					BufferedReader
				}
		
		
		
	}

}
