package com.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Getlocation {
	private static final String KEY=((System) JsdkCommonUtil.getProJsdk()).getProperty("key");
	 
	public static Map<String,Object> getlocation(String lng,String lat){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String urlString = "https://apis.map.qq.com/ws/geocoder/v1/?location= "+ lat+","+lng+"&key="+KEY;
		String result="";
				try {
					URL url= new URL(urlString);
					HttpURLConnection conn= (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("GET");
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
					String line;
					while((line = in.readLine()) != null) {
						result += line + "\n";
					}
					in.close();
				}catch (Exception e) {
					e.getMessage();
				}
				JSONObject jsonObject = ((JSONObject) JSONObject.fromObject(result)).getJSONObject("result");
				JSONObject adInfo = jsonObject.getJSONObject("address_component");
				resultMap.put("nation", adInfo.get("nation"));
				resultMap.put("province", adInfo.get("province"));
				resultMap.put("city", adInfo.get("city"));
				resultMap.put("district", adInfo.get("district"));
				resultMap.put("street", adInfo.get("street"));
				resultMap.put("street_number", adInfo.get("street_number"));
				return resultMap;
				}
public static void main(String[] args) {
	String lng = "113.588611";
	String lat = "22.7726";
	Map<String,Object> map = getlocation(lng,lat);
	System.out.println(map);
	System.out.println("国籍："+map.get("nation"));
	System.out.println("省份："+map.get("province"));
	System.out.println("区域："+map.get("district"));
	System.out.println("城市："+map.get("city"));
	System.out.println("街道："+map.get("street"));
	System.out.println("街道号码"+map.get("steet_number"));
}
}