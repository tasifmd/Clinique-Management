package com.tasif.service;

import java.util.List;

import com.tasif.model.Doctor;
import com.tasif.model.Patient;

public interface SearchDetails {
	void searchDoctorById(List<Doctor> doctorList);
	void searchDoctorByName(List<Doctor> doctorList);
	void searchDoctorBySpecialization(List<Doctor> doctorList);
	void searchDoctorByAvailability(List<Doctor> doctorList);
	void searchPatientById(List<Patient> patientList);
	void searchPatientByName(List<Patient> patientList);
	void searchPatientByContact(List<Patient> patientList);
}
