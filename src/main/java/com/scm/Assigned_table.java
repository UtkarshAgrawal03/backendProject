package com.scm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Assigned_table {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int sid;
@OneToOne
private sub_table subId;
@OneToOne
private class_table cId;
@OneToOne
private teacher_table tid;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public sub_table getSubId() {
	return subId;
}
public void setSubId(sub_table subId) {
	this.subId = subId;
}
public class_table getcId() {
	return cId;
}
public void setcId(class_table cId) {
	this.cId = cId;
}
public teacher_table getTid() {
	return tid;
}
public void setTid(teacher_table tid) {
	this.tid = tid;
}
@Override
public String toString() {
	return "Assigned_table [sid=" + sid + ", subId=" + subId + ", cId=" + cId + ", tid=" + tid + "]";
}
}
