package com.base.pojo;

public class Person {
  private int id ;
  private String name;
  
	 public  Person(){
		  System.out.println(" default  ctor called "); 
	  }
 
	 public  Person(int id , String name   ){
		  this.id=id;
		  this.name= name; 
	 }
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	@Override
	 public int hashCode() {
	//	 System.out.println(" hash method called ");
		 return this.id * 17 + (int)this.name.hashCode();
	 }
	
	@Override
	public boolean equals(Object other) {
	//	 System.out.println(" equals method called ");
		if (other instanceof Person ) {
			if( this.id== ((Person)other).id ) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}	
	  } 
	}
