package com.base.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.base.actors.IContainer;
import com.metaData.annotation.InitPackage;

@InitPackage(packages="com.base.aspect")
public class Container implements IContainer {
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
		} catch (Exception e) {
			e.printStackTrace();
		}  
	 }
	}

	public static void main(String[] args) {
	 IContainer container = new Container();
     container.start();
	}

}
