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

			int choice = scanner.nextInt();

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
								System.out.println("\n\t\t** -- ADD Driver -- **");
								System.out.print("Enter Driver's name:");
								scanner.nextLine();
								String name = scanner.nextLine();
								System.out.print("Enter Driver's age:");
								int age = scanner.nextInt();
								while (age<=0) {  //Η ηλικία πρέπει να είναι μεγαλύτερη του μηδενός//
									System.out.println("Age is wrong,insert again");
									age=scanner.nextInt();
								}
								System.out.print("Enter Driver's racing number:");
								int number = scanner.nextInt();
								while (number<0) { // Ο αριθμός ενός οδηγού είναι πάντοτε μεγαλύτερος ή ίσος του μηδενός//
									System.out.println("Please insert again");
									number=scanner.nextInt();
								}
								System.out.print("the available models are:\n");
								for (int i=0; i<Car.cars.length; i++){
									if(Car.cars[i]!=null)
								System.out.println(i+")"+Car.cars[i].toString());
								}
								System.out.println("Enter Driver's car");
								int carNumber= scanner.nextInt();
								while (carNumber<0 || carNumber>Car.counter-1) { // Ο αριθμός ενός αυτοκινήτου είναι πάντοτε θετικός και μικρότερος του ολικού αριθμού αυτοκινήτων//
									System.out.println("Please insert again");
									carNumber=scanner.nextInt();
								}
								System.out.print("Enter Driver's lap time:");
								double laptime= scanner.nextDouble();
								while (laptime<=0) {
									System.out.println("Laptime is wrong, please insert again"); //Ο χρονος γύρου είναι πάντοτε μεγαλύτερος του μηδενός//
									laptime=scanner.nextDouble();
								}
								new Driver (name,(short)age, (short)number, Car.cars[carNumber],laptime);


			}
			//--------------Display Car's list-------------
			else if (choice == 3){
				System.out.println("\n\t\t** -- Display Car List -- **");
											for (Car  c1: Car.cars){
									if (c1!= null)
										System.out.println("\t"+c1.toString());
								}
				System.out.printf("\n \t**Total number of cars: %d **\n",Car.counter);

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
