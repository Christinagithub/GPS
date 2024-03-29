package com.drew.metadata.exif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Logger;


public class AppSendUtils {
	private static final Logger Log = Logger.getLogger(AppSendUtils.class);
	public static String connectURL(String dest_url, String commString) {
		String rec_string = "";
		URL url = null;
		HttpURLConnection urlconn = null;
		OutputStream out = null;
		BufferedReader rd = null;
		try {
			url = new URL(dest_url);
			urlconn = (HttpURLConnection) url.openConnection();
			urlconn.setReadTimeout(1000 * 30);
			//urlconn.setRequestProperty("content-type", "text/html;charset=UTF-8");
			urlconn.setRequestMethod("POST");
			urlconn.setDoInput(true); 
			urlconn.setDoOutput(true);
			out = urlconn.getOutputStream();
			out.write(commString.getBytes("UTF-8"));
			out.flush(); 
			out.close();
			rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			int ch;
			while ((ch = rd.read()) > -1)
				sb.append((char) ch);
			rec_string = sb.toString();
		} catch (Exception e) {
			Log.error(e, e);
			return "";
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (urlconn != null) {
					urlconn.disconnect();
				}
				if (rd != null) {
					rd.close();
				}
			} catch (Exception e) {
				Log.error(e, e);
			}
		}
		return rec_string;
	}

	public static void main(String[] args) {
		String coords = "106.6519570767,26.6245856997";
		String result =connectURL("http://api.map.baidu.com/geoconv/v1/?coords="+coords+"&from=1&to=5&output=json&ak=Bs20qOsCclhn4W0Vf9mVKEfbNEjmB8UG","");
		System.out.println(result);
	}
}

