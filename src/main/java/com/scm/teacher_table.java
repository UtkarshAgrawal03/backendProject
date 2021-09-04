package com.scm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="teacher_record")
public class teacher_table {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int t_id;
	private String t_name;
	private String t_spec;
	private String t_gen;
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_spec() {
		return t_spec;
	}
	public void setT_spec(String t_spec) {
		this.t_spec = t_spec;
	}
	public String getT_gen() {
		return t_gen;
	}
	public void setT_gen(String t_gen) {
		this.t_gen = t_gen;
	}
	@Override
	public String toString() {
		return "teacher_table [t_id=" + t_id + ", t_name=" + t_name + ", t_spec=" + t_spec + ", t_gen=" + t_gen + "]";
	}
	

}
