package com.tasif.service;

import java.util.List;

import com.tasif.model.Appointment;
import com.tasif.model.Doctor;
import com.tasif.model.Patient;

public class DisplayDetailsImpl implements DisplayDetails{
	public void displayDoctor(List<Doctor> doctorList) {
		for(Doctor doctor : doctorList) {
			System.out.println(doctor.toString());
		}

	}

	public void displayPatient(List<Patient> patientList) {
		for(Patient patient: patientList) {
			System.out.println(patient.toString());
		}
	}

	public void displayAppointment(List<Appointment> appointmentList) {
		for(Appointment appointment : appointmentList) {
			System.out.println(appointment.toString());
		}
	}

	public void displayPopularDoctor(List<Doctor> doctorList) {
		for(Doctor doctor : doctorList) {
			if(doctor.getNumberOfPatients()>=5) {
				System.out.println("\n\tPopular doctor is : Dr."+doctor.getName());
			}
		}

	}

	public void displayPopularSpecialization(List<Doctor> doctorList) {
		for(Doctor doctor : doctorList) {
			if(doctor.getNumberOfPatients()>=5) {
				System.out.println("\n\tPopular specialization of clinic : "+doctor.getSpecialization());
			}
		}

	}
}
