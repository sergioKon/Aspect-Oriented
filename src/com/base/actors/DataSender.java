package com.base.actors;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import com.base.common.WrongDataSource;
import com.base.aspect.Validator;

// derived level 
public class DataSender {
	private static Logger LOGGER = Logger.getLogger(DataSender.class.getName());
    URL address;
	 public DataSender(URL address ) {
		 this.address=address;
	 }
	 public void send() {
		 try {
			parseData();

		} catch (WrongDataSource e) {
		//	t.afterThrow(this);
		}
	 }
	private void parseData() throws WrongDataSource {
		LOGGER.info(" parsing data succeded ");
		
	}
	public URL getUrl() {
		return address;
	}
	public static void main(String[] args) throws MalformedURLException {
		Validator validator = new Validator();
	//	Logger logger = Logger.getLogger(DataSender.class.getName());
       // logger.setLevel(Level.CONFIG);
		//logger.severe(" hi " + logger.getParent().getLevel());
		
		URL address=new URL("https://www.planetware.com/tourist-attractions/germany-d.htm"); //("https://www.bizportal.co.il/");  
		DataSender dataSender = new DataSender(address);
		dataSender.send();
	}
	
}
