/**
  * Coffee.java : represents one coffee, containing all data 
  * from CaffeinatedBeverage and brew type 
  *
  * @author Michelle Carter
  * @version 1.0
  */

public class Coffee extends CaffeinatedBeverage {

  //CONSTANT VARIABLES
  public static final String DEFAULT_BREW_TYPE = "Espresso Shot";

  //INSTANCE VARIABLES 
  private String brewType;

  //CONSTRUCTORS 
/**
  * Full constructor with error handling (shuts down on invalid data)
  *
  * @param name beverage name, can be as specific as you'd like
  * @param ounces number of fluid ounces in container (not total capacity)
  * @param price cost of beverage, either purchase or material cost
  * @param brewTemp type of brew method used to make coffee 
  * 
  */
  public Coffee(String name, int ounces, double price, String brewType){
    super(name, ounces, price);
    if(!this.setBrewType(brewType)){
      System.out.println("ERROR: bad data given to full Coffee constructor");
      System.exit(0);
    }
  }

/**
  * Default constructor using constant variable default values 
  *
  */
  public Coffee(){
    super();
    this.setBrewType(DEFAULT_BREW_TYPE);
  }
  
  /**
  * Copy constructor creates deep copy of all instance variables
  *
  */
  public Coffee(Coffee original){
    if(original != null){
      this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.brewType);
    } else{
      System.out.println("ERROR: null data given to copy Coffee constructor");
      System.exit(0);
    }
  }

 //SETTER/MUTATORS 
/**
  * Set brew type with error checking
  *
  * @param brewType type of brew method used to make coffee
  *
  * @return boolean true if valid (not null, string length > 0), false otherwise
  */
  public boolean setBrewType(String brewType){
    if(brewType != null || brewType.length() > 0){
      this.brewType = brewType;
      return true;
    } else{
      return false;
    }
  }

  /**
  * Sets all valid instance variables 
  *
  * @param ounces number of fluid ounces present in beverage container (not total capacity)
  * @param price cost of beverage, either purchase or material cost
  * @param brewTemp type of brew method used to make coffee 
  *
  * @return boolean true if all four parameters are valid
  */
  public boolean setAll(String name, int ounces, double price, String brewType){
    return super.setAll(name, ounces, price) && this.setBrewType(brewType);
  }

 //GETTTERS/ACCESSORS
/**
  * Gets brew method used to make coffee 
  *
  * @return type of brew method used to make coffee
  */
  public String getBrewType(){
    return this.brewType;
  }

  @Override
  public boolean equals(Object other){
    if (other == null || this.getClass() != other.getClass()){
      return false;
    }
    Coffee otherCoffee = (Coffee) other;
    return super.equals(otherCoffee) && this.brewType.equals(otherCoffee.brewType);
  }

  @Override
  public String toString(){
    String caffeineString = super.toString();
    int colonLocation = caffeineString.indexOf(":");
    caffeineString = caffeineString.substring(colonLocation + 2);
    //cut off front label from CaffeinatedBeverage

    return String.format("Coffee: %s, brewed by %s", caffeineString, this.brewType);
  }
}