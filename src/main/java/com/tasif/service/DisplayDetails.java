package com.tasif.service;

import java.util.List;

import com.tasif.model.Appointment;
import com.tasif.model.Doctor;
import com.tasif.model.Patient;

public interface DisplayDetails {
	
	void displayDoctor(List<Doctor> doctorList);
	void displayPatient(List<Patient> patientList);
	void displayAppointment(List<Appointment> appointmentList);
	void displayPopularDoctor(List<Doctor> doctorList);
	void displayPopularSpecialization(List<Doctor> doctorList);
	
}
