package com.tasif.service;

import java.util.List;

import com.tasif.model.Doctor;
import com.tasif.model.Patient;
import com.tasif.utility.Utility;

public class SearchDetailsImpl implements SearchDetails {
	public void searchDoctorById(List<Doctor> doctorList) {
		System.out.println("\n\tEnter the ID to be searched");
		long id = Utility.inputLong();
		int count = 0;
		for(Doctor doctor : doctorList) {
			if(doctor.getId()==id) {
				System.out.println(doctor.toString());
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("\n\tNo doctor found of id "+id);
		}
	}

	public void searchDoctorByName(List<Doctor> doctorList) {
		System.out.println("\n\tEnter the name to be searched");
		String name = Utility.inputSingleString();
		int count = 0;
		for(Doctor doctor : doctorList) {
			if(doctor.getName().equals(name)) {
				System.out.println(doctor.toString());
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("\n\tNo doctor found of name "+name);
		}
	}

	public void searchDoctorBySpecialization(List<Doctor> doctorList) {
		System.out.println("\n\tEnter the specialization to be searched");
		String specialization = Utility.inputSingleString();
		int count = 0;
		for(Doctor doctor : doctorList) {
			if(doctor.getSpecialization().equals(specialization)) {
				System.out.println(doctor.toString());
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("\n\tNo doctor found of specialization "+specialization);
		}

	}

	public void searchDoctorByAvailability(List<Doctor> doctorList) {
		System.out.println("\n\tEnter the availability as AM, PM or both to be searched");
		String availability = Utility.inputSingleString();
		int count = 0;
		for(Doctor doctor : doctorList) {
			if(doctor.getAvailability().equals(availability)) {
				System.out.println(doctor.toString());
				count ++;
			}
		}
		if(count == 0) {
			System.out.println("No doctor found of availability "+availability);
		}

	}

	public void searchPatientById(List<Patient> patientList) {
		System.out.println("\n\tEnter the ID to be searched");
		long id = Utility.inputLong();
		int count = 0;
		for(Patient patient : patientList) {
			if(patient.getId()==id) {
				System.out.println(patient.toString());
				count++;
			}
		}
		if(count==0) {
			System.out.println("\n\tNo patient found of id "+id);
		}

	}

	public void searchPatientByName(List<Patient> patientList) {
		System.out.println("\n\tEnter the Name to be searched");
		String name = Utility.inputSingleString();
		int count = 0;
		for(Patient patient : patientList) {
			if(patient.getName().equals(name)) {
				System.out.println(patient.toString());
				count++;
			}
		}
		if(count==0) {
			System.out.println("\n\tNo patient found of name "+name);
		}

	}

	public void searchPatientByContact(List<Patient> patientList) {
		System.out.println("\n\tEnter the phone number to be searched");
		String number = Utility.inputSingleString();
		int count = 0;
		for(Patient patient : patientList) {
			if(patient.getPhone().equals(number)) {
				System.out.println(patient.toString());
				count++;
			}
		}
		if(count==0) {
			System.out.println("\n\tNo patient found with phone number "+number);
		}

	}
}
