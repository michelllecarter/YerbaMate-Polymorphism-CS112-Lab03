/**
 * CaffeinatedBeverage.java : Represents one caffeinated beverage,
 * tracking name (either specifically given or general), amount of 
 * fluid ounces in container (not total capacity), and price 
 * purchase or material cost 
 *
 * @author Michelle Carter
 * @version 1.0
*/
public class CaffeinatedBeverage
{
  //CONSTANT VARIABLES 
    public static final String DEFAULT_NAME = "Caffeine Fix";
    public static final int DEFAULT_OUNCES = 16;
    public static final double DEFAULT_PRICE = 0.99;

  //INSTANCE VARIABLES
    private String name;
    private int ounces;
    private double price;

  //CONSTRUCTORS 
  /**
  * Full constructor with error handling (shuts down on invalid data)
  *
  * @param name beverage name, can be as specific as you'd like
  * @param ounces number of fluid ounces in container (not capacity of container) 
  * @param price cost of beverage, either purchase or material cost
  */
    public CaffeinatedBeverage(String name, int ounces, double price) {
        if(!this.setAll(name, ounces, price)){
          System.out.println("ERROR: Bad data given to full CaffeinatedBeverage constructor");
          System.exit(0);
        }
      
    }

/**
* Default constructor using constant variable default values 
*/
  public CaffeinatedBeverage(){
    this(DEFAULT_NAME, DEFAULT_OUNCES, DEFAULT_PRICE);
  }

  /**
  * Copy constructor created deep copy of all instance variables
  */
  public CaffeinatedBeverage(CaffeinatedBeverage original){
    if(original != null){
        this.setAll(original.name, original.ounces, original.price);
    } else{
      System.out.println("ERROR: null data given to copy CaffeinatedBeverage constructor");
      System.exit(0);
    }
  }
  
//SETTER/MUTATORS
/**
  * Set name for object with error checking
  *
  * @param name beverage name, can be as specific as you'd like
  *
  * @return boolean true if a valid String (not null and not empty), false otherwise 
  */
  
  public boolean setName(String name) {
      if(name != null && name.length() > 0){
        this.name = name;
        return true;
      }else{
        return false;
      }
  }
  
/**
  * Set liquid ounces in container with error checking
  *
  * @param ounces number of fluid ounces present in beverage container (not total container capacity)
  *
  * @return boolean true if valid (>= 0), false otherwise 
  */

  public boolean setOunces(int ounces) {
    if(ounces >= 0){
      this.ounces = ounces;
      return true; 
    }  else{
      return false;
    }
   
  }
/** 
  * Set beverage price, purchase value or cost of materials
  *
  * @param price cost of beverage, either purchase or material cost
  *
  * @return boolean true if valid (>= 0), false otherwise
*/

  public boolean setPrice(double price) {
    if(price >= 0){
      this.price = price;
      return true;
    }  else{
      return false;
    }
    
  }

  /**
   * Sets all valid instance variables
   *
   * @param name beverage name, can be as specific as you'd like
   * @param ounces number of fluid ounces present in beverage container (not total capacity of container)
   * @param price cost of beverage, either purchase or material cost
   *
   * @return boolean if all three parameters are valid 
  */
    public boolean setAll(String name, int ounces, double price){
      return this.setName(name) && this.setOunces(ounces) && this.setPrice(price);
    }

//GETTERS//ACCESORS
/** 
  * Gets beverage name
  *
  * @return beverage name 
  */
    public String getName() {
        return this.name;
    }
  /** 
  * Gets number of fluid ounces in container  
  *
  * @return number of fluid ounces in container (not total container capacity)
  */
    public int getOunces() {
        return this.ounces;
    }
  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public double getPrice() {
        return this.price;
    }


/*   @Override //given
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return this.ounces == that.ounces &&
                Double.compare(this.price, that.price) == 0 &&
               this.name.equals(that.name);
    }
*/  
    @Override //cleaned up (convention) 
  public boolean equals(Object other){
    if(other == null || other instanceof CaffeinatedBeverage){
      return false;
    }
    CaffeinatedBeverage otherCaffeine = (CaffeinatedBeverage) other; 
    return this.ounces == otherCaffeine.ounces && Double.compare(this.price, otherCaffeine.price) == 0 && this.name.equals(otherCaffeine.name);
  }
  
    @Override
    public String toString(){
      return String.format("CaffeinatedBeverage: name - %s, %d fl. oz., $%.2f", this.name, this.ounces, this.price);
    }

/**
  * Simulates sip taken of provided ounces, returns boolean if there is more liquid left 
  *
  * @param ounces sip size in fluid ounces 
  *
  * @return boolean true if ounces left > 0, false if empty 
  */
  public boolean sip(int ounces){
    if(this.ounces >= ounces){
      this.ounces -= ounces;
    } else{
      this.ounces = 0;
    }
    return this.ounces > 0;
  }

/** 
  * Checks status if container is empty
  *
  * @return true if 0 o unces, false if more left 
  */
  public boolean isEmpty() {
    return this.ounces == 0;
  }
}