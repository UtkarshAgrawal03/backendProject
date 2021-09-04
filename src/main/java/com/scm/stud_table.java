package com.scm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class stud_table {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int stu_id;
private String  stu_name;
private String stu_Address;
private  long stu_contact;
private char stu_gen;
public char getStu_gen() {
	return stu_gen;
}
public void setStu_gen(char stu_gen) {
	this.stu_gen = stu_gen;
}
@ManyToOne
private class_table stu_class;
public int getStu_id() {
	return stu_id;
}
public void setStu_id(int stu_id) {
	this.stu_id = stu_id;
}
public String getStu_name() {
	return stu_name;
}
public void setStu_name(String stu_name) {
	this.stu_name = stu_name;
}
public String getStu_Address() {
	return stu_Address;
}
public void setStu_Address(String stu_Address) {
	this.stu_Address = stu_Address;
}
public long getStu_contact() {
	return stu_contact;
}
public void setStu_contact(long stu_contact) {
	this.stu_contact = stu_contact;
}
public class_table getStu_class() {
	return stu_class;
}
public void setStu_class(class_table stu_class) {
	this.stu_class = stu_class;
}
@Override
public String toString() {
	return "stud_table [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_Address=" + stu_Address + ", stu_contact="
			+ stu_contact + ", stu_gen=" + stu_gen + ", stu_class=" + stu_class + "]";
}
}
