package com.tasif.controller;

import java.util.ArrayList;
import java.util.List;

import com.tasif.model.Appointment;
import com.tasif.model.Doctor;
import com.tasif.model.Patient;
import com.tasif.service.AddDetailsImpl;
import com.tasif.service.DisplayDetailsImpl;
import com.tasif.service.SearchDetailsImpl;
import com.tasif.utility.Utility;

@SuppressWarnings({ "unchecked", "rawtypes" })

public class ClinicManagementMain {

	
	public static List<Doctor> doctorList = new ArrayList();
	public static List<Patient> patientList = new ArrayList();
	public static List<Appointment> appointmentList = new ArrayList();
	
	public static void main(String[] args) throws Exception {
		AddDetailsImpl addDetails = new AddDetailsImpl();
		DisplayDetailsImpl displayDetails = new DisplayDetailsImpl();
		SearchDetailsImpl searchDetails = new SearchDetailsImpl();
		doctorList = addDetails.read(doctorList, "doctor","doctor");
		patientList = addDetails.read(patientList, "patient", "patient");
		appointmentList = addDetails.read(appointmentList, "appointment", "appointment");
		int loop = 0;
		while (loop == 0) {
			System.out.println("\t__________________________________\n"
					+ "\t Clinic  \n"
					+ "\t--------\n"
					+ "\t 1. Add new entries \n"
					+ "\t 2. Take Appointment \n"
					+ "\t 3. Save in file \n" 
					+ "\t 4. Display Details \n"
					+ "\t 5. Search Details \n" 
					+ "\t 6. Close the Clinic \n"
					+ "\t_________________________________\n");
			int choice = Utility.inputInteger();
			switch (choice) {
			case 1:
				int loopAdd = 0;
				while (loopAdd == 0) {

					System.out.println("\t _______________________\n"
							+ "\t Add Menu \n"
							+ "\t ---------- \n"
							+ "\t 1. Add Doctor \n" 
							+ "\t 2. Add Patient \n" 
							+ "\t 3. Exit \n"
							+ "\t ______________________\n");
					int choiceAdd = Utility.inputInteger();
					switch (choiceAdd) {
					case 1:
						String admin = "admin";
						String pass = "admin";
						System.out.println("\n\tEnter Admin Id");
						String user = Utility.inputSingleString();
						System.out.println("\n\tEnter password");
						String password = Utility.inputSingleString();
						if(user.equals(admin) && password.equals(pass)) {
							System.out.println("\n\tEnter doctor details");
							doctorList = addDetails.addDoctor(doctorList);
						}
						else {
							System.out.println("\n\tWrong ID or password");
						}	
						break;
					case 2:
						patientList = addDetails.addPatient(patientList);
						break;
					case 3:
						loopAdd = 1;
						System.out.println("\n\tAdd Service closed\n");
						break;
					default:
						loopAdd = 1;
						System.out.println("\n\tSomething went wrong\n\tAdd menu closed\n");
						break;
					}
				}
				break;
			case 2:
				appointmentList = addDetails.takeAppointment(doctorList,patientList,appointmentList);
				break;
			case 3:
				int loopSave = 0;
				while (loopSave == 0) {
					System.out.println("\t________________________\n"
							+ "\tSave Menu \n"
							+ "\t-----------\n"
							+ "\t 1. Save Doctors \n"
							+ "\t 2. Save Patients \n"
							+ "\t 3. Save Appointments \n"
							+ "\t 4. Exit \n"
							+ "\t_______________________\n");
					int choiceSave = Utility.inputInteger();
					switch (choiceSave) {
					case 1:
						addDetails.save(doctorList, "doctor");
						break;
					case 2:
						addDetails.save(patientList, "patient");
						break;
					case 3:
						addDetails.save(appointmentList, "appointment");
						break;
					case 4:
						loopSave = 1;
						System.out.println("\n\tSave Service closed\n");
						break;
					default:
						loopSave = 1;
						System.out.println("\n\tSomething went wrong\n\tSave menu closed\n");
						break;
					}
				}
				break;
			case 4:
				int loopDisplay = 0;
				while (loopDisplay == 0) {
					System.out.println("\t________________________________________\n"
							+ "\t Display Menu \n"
							+ "\t --------------\n"
							+ "\t 1. Display all Doctors \n" 
							+ "\t 2. Display all Patients \n" 
							+ "\t 3. Display all Appointments \n"
							+ "\t 4. Display Popular Doctors \n" 
							+ "\t 5. Display Popular Specialization \n" 
							+ "\t 6. Exit \n"
							+ "\t _______________________________________\n");
					int choiceDisplay = Utility.inputInteger();
					switch (choiceDisplay) {
					case 1:
						displayDetails.displayDoctor(doctorList);
						break;
					case 2:
						displayDetails.displayPatient(patientList);
						break;
					case 3:
						displayDetails.displayAppointment(appointmentList);
						break;
					case 4:
						displayDetails.displayPopularDoctor(doctorList);
						break;
					case 5:
						displayDetails.displayPopularSpecialization(doctorList);
						break;
					case 6:
						loopDisplay = 1;
						System.out.println("\n\t\t\tDisplay Service closed\n");
						break;
					default:
						loopDisplay = 1;
						System.out.println("\n\t\t\tSomething went wrong\n\t\t\tDisplay menu closed\n");
						break;
					}
				}
				break;
			case 5:
				int loopSearch = 0;
				while(loopSearch == 0) {
					System.out.println("\t ____________________\n"
									 + "\t Search Menu \n"
							         + "\t ------------- \n"
									 + "\t 1. Search Doctor \n"
									 + "\t 2. Search Patient \n"
									 + "\t 3. Exit  \n"
									 + "\t ____________________\n");
					int choiceSearch = Utility.inputInteger();
					switch(choiceSearch) {
					case 1:
						int loopSearchDoctor = 0;
						while(loopSearchDoctor == 0) {
							System.out.println("\t _________________________________________\n"
											 + "\t  Doctor Search Menu \n"
											 + "\t -------------------- \n"
											 + "\t 1. Search Doctor by Id \n"
											 + "\t 2. Search Doctor by Name \n"
											 + "\t 3. Search Doctor by Specialization \n"
											 + "\t 4. Search Doctor by Availability \n"
											 + "\t 5. Exit \n"
											 + "\t ________________________________________\n");
							int choiceSearchDoctor = Utility.inputInteger();
							switch(choiceSearchDoctor) {
							case 1:
								searchDetails.searchDoctorById(doctorList);
								break;
							case 2:
								searchDetails.searchDoctorByName(doctorList);
								break;
							case 3:
								searchDetails.searchDoctorBySpecialization(doctorList);
								break;
							case 4:
								searchDetails.searchDoctorByAvailability(doctorList);
								break;
							case 5:
								loopSearchDoctor = 1;
								System.out.println("\n\t Doctor Search Service closed\n");
								break;
							default:
								loopSearchDoctor = 1;
								System.out.println("\n\t Something went wrong\n\t Doctor Search menu closed\n");
								break;
							}
						}
						break;
					case 2:
						int loopSearchPatient = 0;
						while(loopSearchPatient == 0) {
							System.out.println("\t ___________________________________\n"
											 + "\t Patient Search Menu \n"
											 + "\t --------------------- \n"
											 + "\t 1. Search Patient by Id \n"
											 + "\t 2. Search Patient by Name \n"
											 + "\t 3. Search Patient by Contact \n"
											 + "\t 4. Exit \n"
											 + "\t __________________________________\n");
							int choiceSearchPatient = Utility.inputInteger();
							switch(choiceSearchPatient) {
							case 1:
								searchDetails.searchPatientById(patientList);
								break;
							case 2:
								searchDetails.searchPatientByName(patientList);
								break;
							case 3:
								searchDetails.searchPatientByContact(patientList);
								break;
							case 4:
								loopSearchPatient = 1;
								System.out.println("\n\tPateint Search Service closed\n");
								break;
							default:
								loopSearchPatient = 1;
								System.out.println("\n\tSomething went wrong\n\t\t\tPatient Search menu closed\n");
								break;
							}
						}
						break;
					case 3:
						loopSearch = 1;
						System.out.println("\n\tSearch Service closed\n");
						break;
						default:
							loopSearch = 1;
							System.out.println("\n\tSomething went wrong\n\t Search menu closed\n");
							break;
					}
				}
				break;
			case 6:
				loop = 1;
				System.out.println("\n\n\t Clinic service closed\n\t Thank You\n");
				break;
			default:
				loop = 1;
				System.out.println("\n\n\t Something went wrong\n\t Clinic service closed\n\t Thank You");
				break;
			}
		}

	}

}
