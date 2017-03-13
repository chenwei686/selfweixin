package com.self.commom.utils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MyHttpClient {

	public String doGet(String url){
	
		return doGet(url, null);
		
	}
	
	public String doGet(String url,Map<String, String> params){
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		CloseableHttpResponse response = null;
		
		String result = "";
		
		try {
			URIBuilder builder = new URIBuilder(url);
			if(params != null){
				
				for(String key : params.keySet()){
					builder.addParameter(key, params.get(key));
				}
			}
			
			HttpGet get = new HttpGet(builder.build());
			
			response = client.execute(get);
			
			Integer code = response.getStatusLine().getStatusCode();
			
			if(code.longValue() == 200){
				result = EntityUtils.toString(response.getEntity(), "utf-8");
			}
			
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (response != null) {
					response.close();
				}
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public String doPost(String url){
		return doGet(url, null);
	}
	
	public String doPost(String url,Map<String, String> params){
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		CloseableHttpResponse response = null;
		
		String result = "" ;
		
		try {
			HttpPost post = new HttpPost(url);
			
			if(params != null){
				
				List<NameValuePair> condis = new ArrayList<NameValuePair>();
						
				
				for (String key : params.keySet() ) {
					
					 condis.add(new BasicNameValuePair(key, params.get(key)));
					
				}
				
				StringEntity entity = new UrlEncodedFormEntity(condis,"utf-8");
				
				post.setEntity(entity);
				
				response = client.execute(post);
				
				Integer code = response.getStatusLine().getStatusCode();
				
				if(code.longValue() == 200){
					result = EntityUtils.toString(response.getEntity(),"utf-8");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(response != null){
					response.close();
				}
				
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public String doPostJson(String url,String json ){
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		CloseableHttpResponse response = null;
		
		String result = "";
		
		try {
			HttpPost post = new HttpPost();

			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			
			post.setEntity(entity);
			
			response = client.execute(post);
			
			Integer code = response.getStatusLine().getStatusCode();
			
			if (code.longValue() == 200) {
				result = EntityUtils.toString(response.getEntity(),"utf-8");
			}
		} catch (UnsupportedCharsetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(response != null){
					response.close();
				}
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}	
}
