import java.util.*;

public class Test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner (System.in);

		// dhmioyrgia antikeimenwn Car-Driver
		new Car ("Mercedes","W08","Mercedes",340,1);
		new Car ("Ferrari","F2018","Ferrari",330,0);
		new Car ("McLaren","MP24","Honda",325,1);
		new Car ("RedBull","RB13","Renault",335,1);
		new Driver ("Lewis Hamilton",(short)32, (short)44, Car.cars[0],4.2);
		new Driver ("Sebastian Vettel",(short)29, (short)5, Car.cars[1],3.0);
		new Driver ("Fernando Alonso",(short)36, (short)14, Car.cars[2],5.2);
		new Driver ("Daniel Ricciardo",(short)27, (short)3, Car.cars[3],1.8);

		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("\t\t************** Pole Ranking Results ***************");
		System.out.println("----------------------------------------------------------------------------------------");

		while (true){

			System.out.println("\n----------------MENU----------------");
			System.out.println("Type (1): Display Driver list");
			System.out.println("Type (2): Add a New Driver");
			System.out.println("Type (3): Display Car list");
			System.out.println("Type (4): Change Driver's lap time");
			System.out.println("Type (5): Display Ranking Table");
			System.out.println("------------------------------------");
			System.out.print("Type here:");

			int choice = GetAnInteger();

			//--------------Display Drivers---------
			if (choice == 1){
				System.out.println("\n\t** Display Drivers' List **");
				for (Driver  d1: Driver.drivers){
					if (d1!= null)
						System.out.println("\t"+d1.toString());
				}
				System.out.printf("\n \t**Total number of drivers: %d **\n\n",Driver.counter);
				System.out.println("Press ENTER to continue");
				scanner.nextLine();
			}
			//------------Add New Driver----------------
			else if (choice == 2 ){
				System.out.println("\n\t\t** -- ADD Driver -- **");
				System.out.print("Enter Driver's name:");
				String name = scanner.nextLine();
				System.out.print("Enter Driver's age:");
				int age = GetAnInteger();
				while (age<=0) {  //Η ηλικία πρέπει να είναι μεγαλύτερη του μηδενός//
					System.out.println("Age is wrong,insert again");
					age=GetAnInteger();
				}
				System.out.print("Enter Driver's racing number:");
				int number = GetAnInteger();
				while (number<0) { // Ο αριθμός ενός οδηγού είναι πάντοτε μεγαλύτερος ή ίσος του μηδενός//
					System.out.println("Please insert again");
					number=GetAnInteger();
				}
				System.out.print("the available models are:\n");
				for (int i=0; i<Car.cars.length; i++){
					if(Car.cars[i]!=null)
						System.out.println(i+")"+Car.cars[i].toString());
				}
				System.out.println("Enter Driver's car:");
				int carNumber= GetAnInteger();
				while (carNumber<0 || carNumber>Car.counter-1) { // Ο αριθμός ενός αυτοκινήτου είναι πάντοτε θετικός και μικρότερος του ολικού αριθμού αυτοκινήτων//
					System.out.println("Please insert again");
					carNumber=GetAnInteger();
				}
				System.out.print("Enter Driver's lap time:");
				double laptime= GetADouble();
				while (laptime<=0) {
					System.out.println("Laptime is wrong, please insert again"); //Ο χρονος γύρου είναι πάντοτε μεγαλύτερος του μηδενός//
					laptime=GetADouble();
				}
				new Driver (name,(short)age, (short)number, Car.cars[carNumber],laptime);
				System.out.printf("The registration of driver with the name %s has been completed successfully!!\n",Driver.drivers[Driver.counter-1].getName());
				System.out.print("Press ENTER to continue");
				scanner.nextLine();
			}
			//--------------Display Car's list-------------
			else if (choice == 3){
				System.out.println("\n\t\t** -- Display Car List -- **");
				for (Car  c1: Car.cars){
					if (c1!= null)
						System.out.println("\t"+c1.toString());
				}
				System.out.printf("\n \t**Total number of cars: %d **\n",Car.counter);
				System.out.println("Press ENTER to continue");
				scanner.nextLine();
			}
			//--------------Change Driver's Lap time-------------
			else if (choice == 4 ){
				int tempnum=0;


				System.out.println("\tDriver\t\t\tLaptime");
				System.out.println("\t------\t\t\t-------");
				//------------Loop with pointer for each of the Drivers that are in the Driver array--------
				//------------prints the drivers name and lap time --- used d1 instead of i --- d1.getName() instead of Driver[i].getName ()
				for (Driver d1: Driver.drivers){
					if(d1 != null)
						System.out.printf("%d)%-20s\t\t%f\n",tempnum++,d1.getName(),d1.getLapTime());
				}
				//---------------------Choose Driver to change LapTime -----------------------
				System.out.println("\nSelect Driver (Press 999 to go back to Menu):");
				int option = GetAnInteger();
				if (option == 999) {
					for (Driver d1: Driver.drivers){
						if(d1 != null)
							d1.setRankedPosition((short)(0));
					}
					continue;
				}
				//----------------- Limit the choice to only the available Drivers----------
				//----------------Den evala Driver.length epeidi o pinakas exei 20 theseis--------
				while (option > Driver.counter-1 || option < 0 ) {
					System.out.print("Not A Valid Driver\n\n");
					System.out.print("Select Driver or Press 999 to go back to Menu:");
					option=GetAnInteger();
					if (option == 999) {
						for (Driver d1: Driver.drivers){
							if(d1 != null)
								d1.setRankedPosition((short)(0));
						}
						continue;
					}
				}
				//------------Add lap time for the Selected Driver--------------------
				System.out.printf("Add lap time for %s:",Driver.drivers[option].getName());
				double lt = GetADouble();
				while (lt<=0) {
					System.out.println("Laptime is wrong, please insert again"); //Ο χρονος γύρου είναι πάντοτε μεγαλύτερος του μηδενός//
					lt=GetADouble();
				}
				Driver.drivers[option].setLapTime(lt);
				for (Driver d1: Driver.drivers){
					if(d1 != null)
						d1.setRankedPosition((short)(0));
				}
			}


			//--------------Show Ranking List----------
			else if (choice == 5 ){
				double laptimes[] = new double[Driver.counter];
				double tempmin=0;
				double templt2=0;
				int indicatorForMin=0;
				int position=0;

				for (Driver d1: Driver.drivers){
					if(d1 != null)
							laptimes[position]=d1.getLapTime();
					position++;

				}

				tempmin=getMin(laptimes);

				//----Short the min values in array----
				for (int i=0;i<laptimes.length;i++) {
					for (int j=i;j<laptimes.length;j++){
						if (tempmin==laptimes[j]) {
							indicatorForMin=j;
							break;
						}
					}
					templt2=laptimes[i];
					if(i==indicatorForMin)
						laptimes[i]=laptimes[indicatorForMin]+100;
					else {
						laptimes[i]=laptimes[indicatorForMin]+100;
						laptimes[indicatorForMin]=templt2;
					}
					tempmin=getMin(laptimes);

				}
				//--------------Print of Ranking table----------
				int pos=1;
				System.out.print("\n************ Ranking Table ************\n");
				System.out.print("-------------------------------------\n");
				for (double l1: laptimes){
					for (Driver d1: Driver.drivers){
						if(d1 != null)
							if (l1==d1.getLapTime()+100 && d1.getRankedPosition()==0)
							{

								System.out.printf("%d| %s\n",pos,d1.getName());
								System.out.print("-------------------------------------\n");
								d1.setRankedPosition((short)(pos++));
								break;
							}
					}
				}
				System.out.printf("Press ENTER to continue");
				scanner.nextLine();
			}


		}//------------end of while
	}//-------------end of main

	//-------------validation of Integer
	public static int GetAnInteger()
	{
		Scanner scanner = new Scanner (System.in);
		while (true)
		{
		   try
		   {
			   return scanner.nextInt();
		   }

		   catch (InputMismatchException e)
		   {
			   scanner.next();
			   System.err.print("That's not an integer. Try again: ");
		   }
		 }
	 }

	//-------------validation of Double
	public static double GetADouble()
	{
		Scanner scanner = new Scanner (System.in);
		while (true)
		{
		   try
		   {
			   return scanner.nextDouble();
		   }

		   catch (InputMismatchException e)
		   {
			   scanner.next();
			   System.err.print("That's not a double. Try again: ");
		   }
		 }
	 }

	//-----------method that returns the min number of an Array
	public static double getMin(double[] inputArray){
		double minValue = inputArray[0];
		for(int i=1;i<inputArray.length;i++){
		  if(inputArray[i] < minValue){
			minValue = inputArray[i];
		  }
		}
		return minValue;
	}



}//------end of class
