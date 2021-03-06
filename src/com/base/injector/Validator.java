package com.base.injector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.base.common.WebLocation;
import com.base.common.WrongDataSource;
import com.base.main.DataSender;
import com.google.gson.Gson;

public class Validator  {
	Logger LOGGER = Logger.getLogger(Validator.class.getName());
	public  <U extends DataSender<? extends Validator>> void  before(U dataSender) {
	   String host =  dataSender.getUrl().getHost();
	  try {
			InetAddress address = InetAddress.getByName(host);
			StringBuilder output = getHostInfo(address);
			Gson gson= new Gson();
			WebLocation webLocation = gson.fromJson(output.toString(),WebLocation.class);
			webLocation.setCountryCode(webLocation.getCountryCode());
			System.out.println(webLocation.getCountryName());
			if(webLocation.getOrg().contains("someprovider")) {
				throw new WrongDataSource(webLocation.getOrg());
			}
	   } catch( IOException e) {
		  System.err.println(e.getMessage());
	  } catch (WrongDataSource e) {
		  LOGGER.log(Level.SEVERE, e.getMessage(), e);
	 }
	}
	private StringBuilder getHostInfo(InetAddress address) throws IOException {
		  String ip = address.getHostAddress();
		  String[] command =new String[] { "cmd.exe", "/c", "curl.exe http://ipinfo.io/"+ ip}; // for Windows only
		  ProcessBuilder processBuilder = new ProcessBuilder();
		  processBuilder.command(command);
		  Process process= processBuilder.start();
		  
		  BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
		   StringBuilder output = new StringBuilder();
		   String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		return output;
	}
	
	public void after(DataSender<?> dataSender)  {
		LOGGER.info(" data from "+ dataSender.getUrl() + " send successful ");
	}
	
	public void afterThrow(DataSender<?> dataSender) {
		LOGGER.severe(" Something crashed, for compete information read the message");
		  // send special message 
		 //
		}

}
