package com.tasif.model;

public class Appointment {
	Patient patient;
	Doctor doctor;
	String date;
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [patient=" + patient + ", doctor=" + doctor + ", date=" + date + "]";
	}
}
