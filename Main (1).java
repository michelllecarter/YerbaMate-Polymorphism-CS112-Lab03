import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
  	{     
		CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
		Scanner keyboard = new Scanner(System.in);
		// Prompt user with options in a loop
		int choice, ounces = 0, brewTemp = 0, count = 0;
		String name = null, brewType;
		double price = 0.0;
		
		do{
      System.out.println();
			System.out.println("1) Enter new Tea");
			System.out.println("2) Enter new Yerba Mate");
      System.out.println("3) Enter new Coffee");
			System.out.println("4) Exit");
			System.out.print(">> ");
			choice = keyboard.nextInt();
      keyboard.nextLine(); //clean buffer   
			
			if(choice >= 1 && choice <= 3){
        //CaffenatedBeverage data: 
        System.out.print("Enter name      : ");
        name = keyboard.nextLine();
        System.out.print("Enter ounces    : ");
        ounces = keyboard.nextInt();
        System.out.print("Enter price     $ ");
        price = keyboard.nextDouble();
        keyboard.nextLine(); //clear newline in buffer 
        }

       //getting derived class specific data  
        switch (choice)
        {
          case 1: 
              //Tea specific data
              System.out.print("Enter brew temperature (in Celsius): ");
              brewTemp = keyboard.nextInt();

              //Create a Tea put into array
              inventory[count] = new Tea(name, ounces, price, brewTemp);

              count++;
              break;
          
          case 2:
                //YerbaMate specific data
                //name, assuring run passes is 0 but could input that data here if you wanted to 

            //Create a YerbaMate, put into array 
                inventory[count] = new YerbaMate(name, ounces, price, brewTemp);
          
              count++;
              break;
          
          case 3:
              //Coffee specific data
             System.out.print("Enter brew type or method used: ");
             brewType = keyboard.nextLine();
			
			        //Create a Coffee, put into array
			        inventory[count] = new Coffee(name, ounces, price, brewType);
        
			        count++;
			        break;
            
          case 4:
              //print all drinks
              System.out.println("\n\nAll drinks :");
              Main.printDrinks(inventory, count);

              //print average price 
              System.out.printf("\nAverage price = $%.2f%n", Main.findAveragePrice(inventory, count));

              //print highest priced yerba mate
              YerbaMate mostExpensive = Main.findHighestPricedYerbaMate(inventory, count);
              if(mostExpensive != null){
                System.out.printf("\nHighest Priced Mate = %s%n", mostExpensive);
              } else{
                System.out.println("No Yerba Mate found in list of drinks.");
              }
              break;
      default:
              System.out.println("ERROR: not a valid choice. Please try again. \n");
			 }

		} while (choice != 4);
      
      keyboard.close();

      //hacker challenge of doing yerba mate ritual 
	}

/**
  * Prints all drinks in partially filled array, numbered in array order
  *
  * @param drinks partially filled array with caffeinated drinks 
  * @param numDrinks size of partially filled aray 
  */
  
  public static void printDrinks(CaffeinatedBeverage[] drinks, int numDrinks){
    for(int i = 0; i < numDrinks; i++){
      System.out.println("Drink #" + (i + 1) + " = " + drinks[i]);
    }
  }

/**
  * Gets the average of all beverages in patially filled array
  * 
  * @param drinks partially filled array with caffeinated drinks 
  * @param numDrinks size of partially filled aray 
  *
  * @return average price of caffeinated drinks (no rounding)
  */

  public static double findAveragePrice(CaffeinatedBeverage[] drinks, int numDrinks){
    double totalPrice = 0;
    for(int i = 0; i < numDrinks; i++){
      totalPrice += drinks[i].getPrice();
    }
    return totalPrice / numDrinks;
  }

/**
  * Finds the YerbaMate with the highest price (maximum price) in the partially filled array
  *
  * @param drinks partially filled array with caffeinated drinks
  * @param numDrinks size of partially filled aray
  *
  * @return YerbaMate with highest price, or null if no YerbaMate found
  */

  public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] drinks, int numDrinks){
    YerbaMate mate = new YerbaMate(), highestPrice = null;

    for(int i = 0; i < numDrinks; i++){
        if(drinks[i].getClass() == mate.getClass()){ //drinks[i] instanceofYerbaMate 
          if(highestPrice == null){
            highestPrice = (YerbaMate) drinks[i];
          } else if(highestPrice.getPrice() < drinks[i].getPrice()){
            highestPrice = (YerbaMate) drinks[i];
          }
        }
      }
      return highestPrice;
    }
}