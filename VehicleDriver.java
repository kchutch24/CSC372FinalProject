import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class VehicleDriver {
  
	public static void main(String[]args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //experimenting with bufferedreader for user input (supposed to be faster)
		String userInput;
		int numVehicles;
		LinkedList<Vehicle> vehicles = new LinkedList<>(); //new linked list to store vehicle data
		String make, model;
		double milesPerGallon;
		
		System.out.print("How many vehicles would you like to enter? ");
		userInput = br.readLine();
		
		while(!isInteger(userInput)) { //check input for integer, repeat question/input prompt if not
			System.out.print("How many vehicles would you like to enter? ");
			userInput = br.readLine();
		}
		
		numVehicles = Integer.parseInt(userInput); //number of vehicles to be entered per user

		System.out.println();
		//for loop to get vehicle data for number of vehicles given prior
		for(int i = 0; i < numVehicles; i++) {
			System.out.println("Vehicle " + (i + 1) + ": ");
			System.out.print("Enter make of the vehicle: ");
			make = br.readLine().trim(); //user input for make
			  
			System.out.print("Enter model of the vehicle: ");
			model = br.readLine().trim(); //user input for model
			  
			System.out.print("Enter miles per gallon of the vehicle: ");
			userInput = br.readLine(); //user input for mpg
			
			while(!isDouble(userInput)) { //ask again if not double value
				System.out.print("Enter miles per gallon of the vehicle: ");
				userInput = br.readLine(); 
			}
			
			milesPerGallon = Double.parseDouble(userInput); //get double from input
			  
			Vehicle vehicle = new Vehicle(make, model, milesPerGallon); //new vehicle with previous info
			vehicles.add(vehicle); //add individual vehicle to vehicle class
			System.out.println();
		}
		  
		// sort the linked list in ascending order based on miles per gallon
		Collections.sort(vehicles);
		
		/* TEST ORDER 
		 * for(Vehicle vehicle : vehicles) {
			System.out.println(vehicle); //print vehicle list to file
		} 
		*/
		  
		// writing all vehicle details to a file
		System.out.print("Enter a file name and extension to output vehicle data: ");
		String fileName = br.readLine().trim(); //get filename/extension
		  
		FileWriter writer = new FileWriter(fileName); //new file created using user input
		
		for(Vehicle vehicle : vehicles) {
			writer.write(vehicle.toString() + System.lineSeparator()); //print vehicle list to file
		}
		
		writer.close(); //close filewriter
		System.out.println("Vehicle data has been successfully written to: " + fileName); //success message
	} //end main
	 
	//method to verify if input is int
	public static boolean isInteger(String test) {
		try {
			Integer.parseInt(test);
			return true;
		} catch(NumberFormatException e){
			System.out.println(test + " is not a valid integer.");
			return false;
		}
	}
	  
	//method to verify if input is a double
	public static boolean isDouble(String test) {
		try {
			Double.parseDouble(test);
			return true;
		} catch(NumberFormatException e){
			System.out.println(test + " is not a valid double.");
			return false;
		}
	}
} //class end