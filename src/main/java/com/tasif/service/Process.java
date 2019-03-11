package com.tasif.service;

import java.util.Date;
import java.util.List;

import com.tasif.model.Appointment;
import com.tasif.model.Doctor;
import com.tasif.model.Patient;
import com.tasif.utility.Utility;

public class Process {
	public static Doctor addDoctorToList() {
		Doctor doctor = new Doctor();
		System.out.println("\n\tEnter Name");
		doctor.setName(Utility.inputSingleString());
		System.out.println("\n\tEnter ID in number");
		doctor.setId(Utility.inputLong());
		System.out.println("\n\tEnter Specialization");
		doctor.setSpecialization(Utility.inputSingleString());
		System.out.println("\n\tEnter Availability");
		doctor.setAvailability(Utility.inputSingleString());
		doctor.setNumberOfPatients(0);
		return doctor;
	}

	/**
	 * Purpose : Adding patient in patient object and returning the object
	 * 
	 * @return object of having patient data
	 */
	public static Patient addPatientToList() {
		Patient patient = new Patient();

		System.out.println("\n\tEnter Name");
		patient.setName(Utility.inputSingleString());
		System.out.println("\n\tEnter ID in number");
		patient.setId(Utility.inputLong());
		System.out.println("\n\tEnter Phone Number");
		patient.setPhone(Utility.inputSingleString());
		System.out.println("\n\tEnter Age");
		patient.setAge(Utility.inputLong());
		return patient;
	}

	/**
	 * Purpose : Adding appointment details in appointment object and returning the object
	 * 
	 * @param doctorList
	 * @param patientList
	 * @return
	 */
	public static Appointment addAppointmentToList(List<Doctor> doctorList, List<Patient> patientList) {
		Appointment appointment = new Appointment();
		System.out.println("\n\tEnter name of Patient");
		String patientAppointment = Utility.inputSingleString();
		int count = 0;
		for (Patient patient : patientList) {
			if (patient.getName().equals(patientAppointment)) {
				count++;
				System.out.println("\n\tEnter the name of Doctor for Appointment");
				String doctorAppointment = Utility.inputSingleString();
				System.out.println("\n\tEnter the ID of Doctor for Appointment");
				long doctorAppointmentId = Utility.inputLong();
				System.out.println("Enter the year ");
				int year = Utility.inputInteger();
				System.out.println("Enter the month ");
				int month = Utility.inputInteger();
				System.out.println("Enter the day ");
				int day = Utility.inputInteger();
				Date d = new Date(year,month,day);
				String date = d.toString();
				for (Doctor doctor : doctorList) {
					if (doctor.getName().equals(doctorAppointment)) {
						if (doctor.getId() == doctorAppointmentId) {
							if (doctor.getNumberOfPatients() < 5) {
								appointment.setDoctor(doctor);
								appointment.setPatient(patient);
								appointment.setDate(date);
								doctor.setNumberOfPatients(doctor.getNumberOfPatients() + 1);
								System.out.println("\n\tAppointment fixed on " + date);
								return appointment;
							} else {
								System.out.println("\n\tTake appointment on some other day\n\tDoctor reached maximum number of patients");
							}
						}
					}
				}
			}
		}
		if (count == 0) {
			System.out.println("\n\tSorry you are not a registered patient\nClinic closed");
			System.exit(0);
		}
		return null;
	}
}
