package com.scm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class class_table {
	@Id
	private int std;
	private int strength;
	@OneToOne
	private teacher_table class_teacher;
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public teacher_table getClass_teacher() {
		return class_teacher;
	}
	public void setClass_teacher(teacher_table class_teacher) {
		this.class_teacher = class_teacher;
	}

}
