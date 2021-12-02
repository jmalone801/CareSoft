package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;

    
    // TO DO: Implement HIPAACompliantUser!
    
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }


	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean assignPin(int pin) {
		int pinLength = String.valueOf(pin).length();
		if(pinLength == 4) {
			this.pin = pin;
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id == confirmedAuthID) {
			return true;	
		}
		else {
			return false;	
		}
	}
	
	
	// TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

}
