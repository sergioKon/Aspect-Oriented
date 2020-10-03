package com.base.main;

import java.io.File;
import org.apache.commons.io.FilenameUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import com.base.actors.DataSender;
import com.base.actors.Worker;
import com.base.aspect.Injector;
import com.metaData.annotation.InitPackage;

@InitPackage(packages="com.base.aspect")
public class Container<T extends Worker> implements IContainer {
	T t;
	Container(T t ){
		this.t=t;
	}
    Annotation[] annotations; 
    String[] packages;
	@Override
	public void start() {
	 if( getClass().getAnnotations()!=null) {
		 annotations= getClass().getAnnotations();
		 Class<? extends Annotation> type = annotations[0].annotationType();
         try {
        	 Method method=type.getMethod("packages");
             packages = (String[]) method.invoke(annotations[0]);   
             for(String p : packages) {
               readClasses(p);
             }
		} catch (Exception e) {
			e.printStackTrace();
		}  
	 }
	}

	public void readClasses(String folder) throws Exception {
		 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		 /*
		    Reflections reflections = new Reflections("my.project.prefix");
            Set<Class<? extends Object>> allClasses = 
            reflections.getSubTypesOf(Object.class);
		  */
			 String path = folder.replace('.', '/');
			 Enumeration<URL> resources = classLoader.getResources(path);
			 List<URL> list = Collections.list(resources);
			 for(URL r: list) {
				String[] files= new File(r.getFile()).list(); 
			    for(String file:files) {
			    	 String className = (folder+"."+file);
			    	 
			    	 className=FilenameUtils.removeExtension(className);
			    	 System.out.println(className);
			    	 
			    	 Class<?> clazz=  Class.forName(className);
			    	 if( clazz.isInterface()) {
			    		 continue;
			    	 }
			    	 Constructor<?> ctor = clazz.getConstructor();
			    	 Injector injector = (Injector) ctor.newInstance();
			    	 injector.before(t);
			    	 t.processStart();
			    	 
			    }
		     }
		 }
	

	public static void main(String[] args) throws MalformedURLException {
	 Worker worker = new DataSender(new URL("https://www.bizportal.co.il/")); 
	 IContainer container = new Container<>(worker);
     container.start();
	}

}
