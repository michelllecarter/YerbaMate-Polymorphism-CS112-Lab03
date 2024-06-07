/**
* Tea.java : Represents one tea, containing all data 
* from CaffeinatedBeverage and brew temperature in Celsius (not current)
*
* @author Michelle Carter
* @version 1.0
*/

public class Tea extends CaffeinatedBeverage {
  //CONSTANT VARIABLES
  public static final int DEFAULT_BREW_TEMP = 90;

  //INSTANCE VARIABLES
  private int brewTemp;

  //CONSTRUCTORS
/**
  * Full constructor with error handling (shuts down on invalid data)
  *
  * @param name beverage name, can be as specific as you'd like
  * @param ounces number of fluid ounces in container (not total capacity)
  * @param price cost of beverage, either purchase or material cost 
  * @param brewTemp temperature tea is brewed at (in Celsius) 
  */
  public Tea(String name, int ounces, double price, int brewTemp){
    //set old data 
    super(name, ounces, price);
    //set new data 
    if(!this.setBrewTemp(brewTemp)){
      System.out.println("ERRORL: Bad data given to full Tea constructor");
      System.exit(0);
    }
  }

/**
  * Default constructor using constant variable default values
*/
  public Tea(){
    //set old data
    super();
    //set new data 
    this.setBrewTemp(DEFAULT_BREW_TEMP);

    //this.(CaffeinatedBeverage.DEFAULT_NAME, CaffeinatedBeverage.DEFAULT_OUNCES, CaffeinatedBeverage, DEFAULT_PRICE, DEFAULT_BREW_TEMP);
  }

  /**
    * Copy constructor creates dpeep copy of all instance variables
  */
  public Tea(Tea original){
      if(original != null){
        this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.getBrewTemp());
    } else{
        System.out.println("ERROR: null data given to copy Tea constructor");
        System.exit(0);
    }

  }

//SETTER.MUTATORS
/**
  * Set brew temperature for object with error checking
  *
  * @param brewTemp brewing temperature in Celsius 
  *
  * @return boolean true if valid (> 0), false otherwise
  */
  public boolean setBrewTemp(int brewTemp){
    if(brewTemp > 0){
      this.brewTemp = brewTemp;
      return true;
    } else{
      return false;
    }
  }

/**
  * Sets all valid instance variables
  *
  * @param name beverage name, can be as specific as you'd like
  * @param ounces number of fluid ounces in container (not total capacity)
  * @param price cost of beverage, either purchase or material cost
  * @param brewTemp brewing temperature in Celsius
  *
  * @return boolean if all four parameters are valid
  */
  public boolean setAll(String name, int ounces, double price, int brewTemp){
    return super.setAll(name, ounces, price) && this.setBrewTemp(brewTemp);
  }

//GETTERS//ACCESSORS
/**
  * Gets brew temperature (in Celsius)
  *
  * @return temperature tea was brewed at in Celsius
  */
  public int getBrewTemp(){
    return this.brewTemp;
  }

 @Override 
  public boolean equals(Object other){
    if (other == null || other instanceof Tea){
      return false;
    }
    Tea otherTea = (Tea)other;
    return super.equals(otherTea) && brewTemp == otherTea.brewTemp;
  }

  @Override
  public String toString(){
    String caffeineString = super.toString();
    int colonLocation = caffeineString.indexOf(":");
    caffeineString = caffeineString.substring(colonLocation + 2); 
    //cut off front label from CaffeinatedBeverage

    return String.format("Tea: %s, brewed @ %d C", caffeineString, this.brewTemp);
  }
}