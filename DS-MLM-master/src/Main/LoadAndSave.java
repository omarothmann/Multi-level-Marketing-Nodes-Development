package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoadAndSave {
    
    private static String crunchify_file_location = "/Users/appshah/Documents/crunchify.txt";
	private static Gson gson = new Gson();
 
	// CrunchifyComapny Class with two fields
	// - Employees
	// - CompanyName
	private static class CrunchifyCompany {
		private int employees;
		private String companyName;
 
		public int getEmployees() {
			return employees;
		}
 
		public void setEmployees(int employees) {
			this.employees = employees;
		}
 
		public String getCompanyName() {
			return companyName;
		}
 
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
 
	}
 
	// Main Method
	public static void main(String[] args) {
		CrunchifyCompany crunchify = new CrunchifyCompany();
		crunchify.setCompanyName("Crunchify.com");
		crunchify.setEmployees(4);
 
		// Save data to file
		crunchifyWriteToFile(gson.toJson(crunchify));
		
		// Retrieve data from file
		crunchifyReadFromFile();
	}
 
	// Save to file Utility
	private static void crunchifyWriteToFile(String myData) {
		File crunchifyFile = new File(crunchify_file_location);
		if (!crunchifyFile.exists()) {
			try {
				File directory = new File(crunchifyFile.getParent());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				crunchifyFile.createNewFile();
			} catch (IOException e) {
				log("Excepton Occured: " + e.toString());
			}
		}
 
		try {
			// Convenience class for writing character files
			FileWriter crunchifyWriter;
			crunchifyWriter = new FileWriter(crunchifyFile.getAbsoluteFile(), true);
 
			// Writes text to a character-output stream
			BufferedWriter bufferWriter = new BufferedWriter(crunchifyWriter);
			bufferWriter.write(myData.toString());
			bufferWriter.close();
 
			log("Company data saved at file location: " + crunchify_file_location + " Data: " + myData + "\n");
		} catch (IOException e) {
			log("Hmm.. Got an error while saving Company data to file " + e.toString());
		}
	}
 
	// Read From File Utility
	public static void crunchifyReadFromFile() {
		File crunchifyFile = new File(crunchify_file_location);
		if (!crunchifyFile.exists())
			log("File doesn't exist");
 
		InputStreamReader isReader;
		try {
			isReader = new InputStreamReader(new FileInputStream(crunchifyFile), "UTF-8");
 
			JsonReader myReader = new JsonReader(isReader);
			CrunchifyCompany company = gson.fromJson(myReader, CrunchifyCompany.class);
 
			log("Company Name: " + company.getCompanyName());
			Integer employee = company.getEmployees();
			log("# of Employees: " + employee.toString());
 
		} catch (Exception e) {
			log("error load cache from file " + e.toString());
		}
 
		log("\nComapny Data loaded successfully from file " + crunchify_file_location);
 
	}
 
	private static void log(String string) {
		System.out.println(string);
	}
 
}
    
    
    
    

