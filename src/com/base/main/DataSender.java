package com.base.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import com.base.common.WrongDataSource;
import com.base.aspect.Validator;

// derived level 
public class DataSender <T extends Validator> {
	private static Logger LOGGER = Logger.getLogger(DataSender.class.getName());
	T t;
    URL address;
	 public DataSender(T t, URL address ) {
		 this.t= t;
		 this.address=address;
	 }
	 public void send() {
		 try {
			t.before(this); 
			parseData();
		    t.after(this);
		} catch (WrongDataSource e) {
			t.afterThrow(this);
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
		DataSender<Validator> dataSender = new DataSender<>(validator, address);
		dataSender.send();
	}
	
}
