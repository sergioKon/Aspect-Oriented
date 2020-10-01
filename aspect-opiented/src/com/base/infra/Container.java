package com.base.infra;

import java.util.HashSet;
import java.util.Set;

import com.base.pojo.Person;
import com.google.gson.Gson;

public class Container<T extends Set<? extends Person>,Type extends Number> {
   private T t;
   private Type type;
   public Container(T t, Type type ) {
	   this.t= t ;
	   this.type=type;
	   System.out.println(" generic is "+t.getClass().getCanonicalName());
   }
   @Override
   public String toString() {
	  return  new Gson().toJson(t) + type.getClass().getCanonicalName();
   }
	
	public static void main(String[] args) {
	 //   String output = "\t"+"La ".repeat(3) + "nd"+ "\t";
	//	System.out.println(output);
	//	System.out.println(output.strip());
	//	System.exit(-3);
		
		Person p1= new Person(15, "John");
		Person p2= new Person(16, "Johnni");
		Person p3= new Person(17, "Johnni");
		
	    HashSet < Person > persons = new HashSet < Person > ();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
		
        System.out.println(persons.contains(new Person(15,"John")));
		
	/*	java.util.List<Person>  p= new java.util.ArrayList<>();
		p.add(new Person(1, "one"));
		p.add(new Person());
		p.add(new Person(3, "three"));
	*/	
		Container<HashSet<Person>,Number> hashPersons = new Container<>(persons, 25.2);
		System.out.println( hashPersons);
	}

}
