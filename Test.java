import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		
		ArrayList<Double> list = new ArrayList<Double>();
		Scanner scanner = new Scanner (System.in);
		
		// dhmioyrgia antikeimenwn Car-Driver
		new Car ("Mercedes","W08","Mercedes",340,1);    
		new Driver ("Lewis Hamilton",(short)32, (short)44, Car.cars[0],4.2); 

		
		System.out.println("************* Pole Ranking Results *************");
		
		while (true){
			
			System.out.println("Menu:");
			System.out.println("Type (1) to display drivers' list");
			System.out.println("Type (2) to add a New Driver");
			System.out.println("Type (3) to display cars' list");
			System.out.println("Type (4) to add Drivers' lap time");
			System.out.println("Type (5) to see the Ranking Table");
			System.out.print("Type here:");
			
			int choice = GetAnInteger();
			
			//--------------Display Drivers---------
			if (choice == 1){
				System.out.println("\n\t** Display Drivers' List **");
				for (Driver  d1: Driver.drivers){
					if (d1!= null)
						System.out.println("\t"+d1.toString());
				}
				System.out.printf("\n \t**Total number of drivers: %d **\n",Driver.counter);
			}
			//------------Add New Driver----------------
			else if (choice == 2 ){
				
				
			}
			//--------------Display Car's list-------------
			else if (choice == 3){
				
			}
			//--------------Change Driver's Lap time-------------
			else if (choice == 4 ){
				
			}
			//--------------Show Ranking List----------
			else if (choice == 5 ){

				
			}
		}//------------end of while
	}//-------------end of main

		
		
		
	
}//------end of class
 