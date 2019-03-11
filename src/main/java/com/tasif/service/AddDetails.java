package com.tasif.service;

import java.util.List;

import com.tasif.model.Appointment;
import com.tasif.model.Doctor;
import com.tasif.model.Patient;

public interface AddDetails {
	List<Doctor> addDoctor(List<Doctor> doctorList);
	List<Patient> addPatient(List<Patient> patientList);
	List<Appointment> takeAppointment(List<Doctor> doctorList, List<Patient> patientList, List<Appointment> appointmentList);
	<T> void save(List<T> T, String file);
	<T> List<T> read(List<T> T, String file, String model) throws Exception;
}
