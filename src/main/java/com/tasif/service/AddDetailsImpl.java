package com.tasif.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.tasif.model.Appointment;
import com.tasif.model.Doctor;
import com.tasif.model.Patient;

public class AddDetailsImpl implements AddDetails{
	ObjectMapper objectMapper = new ObjectMapper();
	public List<Doctor> addDoctor(List<Doctor> doctorList) {
		doctorList.add(Process.addDoctorToList());
		return doctorList;
	}

	public List<Patient> addPatient(List<Patient> patientList) {
		patientList.add(Process.addPatientToList());
		return patientList;
	}

	public List<Appointment> takeAppointment(List<Doctor> doctorList, List<Patient> patientList,List<Appointment> appointmentList) {
		appointmentList.add(Process.addAppointmentToList(doctorList, patientList));
		return appointmentList;
	}

	public <T> void save(List<T> T, String file) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File("/home/admin1/eclipse-workspace/tasif/oops/CliniqueManagement/src/main/java/myfiles/" + file + ".json"), T);
			System.out.println("\n\tSaved");
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			objectMapper.writeValue(new File("/home/admin1/eclipse-workspace/tasif/oops/CliniqueManagement/src/main/java/myfiles/" + file + ".json"), T);
			System.out.println("\n\tSaved");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}

	public <T> List<T> read(List<T> T, String file, String model) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/admin1/eclipse-workspace/tasif/oops/CliniqueManagement/src/main/java/myfiles/" + file + ".json"));
			String arrayToJson;
			if ((arrayToJson = reader.readLine()) != null) {
				if(model.equals("doctor")) {
					TypeReference<ArrayList<Doctor>> type = new TypeReference<ArrayList<Doctor>>() {};
					T = objectMapper.readValue(arrayToJson, type);
				}
				else if(model.equals("patient")) {
					TypeReference<ArrayList<Patient>> type = new TypeReference<ArrayList<Patient>>() {};
					T = objectMapper.readValue(arrayToJson, type);
				}
				else if(model.equals("appointment")) {
					TypeReference<ArrayList<Appointment>> type = new TypeReference<ArrayList<Appointment>>() {};
					T = objectMapper.readValue(arrayToJson, type);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return T;
	}
}
