/** 
 * YerbaMate.java : represents one yerba mate drink, containng all data
 * from Tea and number of passes (represents the number of people that
 * have drank from teh same gourd when sharing a mate int he traditional customs.) 
 *
 * @author Michelle Carter
 * @version 1.0
*/ 

public class YerbaMate extends Tea{
  //CONSTANT VARIABLES
  public static final int DEFAULT_NUM_PASSES = 0;

  //INSTANCE VARIABLES
  private int numPasses;

  //CONSTRUCTORS
/**
  * Full constructor with error handling (shuts down on invalid data)
  *
  * @param name beverage name, can be as specific as you'd like
  * @param ounces number of fluid ounces in container (not total capacity)
  * @param price cost of beverage, either purchase or material cost
  * @param brewTemp temperature tea is brewed at (in Celsius)
  * @param numPasses number of people that have drank from the same gourd when sharing a mate
  */
  public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses){
    super(name, ounces, price, brewTemp);
    if(!this.setNumPasses(numPasses)){
      System.out.println("ERROR: Bad data given to full YerbaMate constrctor");
      System.exit(0);
    }
  }

  /**
   * Overloaded constructor with error handling (shuts down on invalid data), defaults numPasses to 0 for an easy alternative to build object
   *
   * @param name beverage name, can be as specific as you'd like
   * @param ounces number of fluid ounces in container (not total capacity)
   * @param price cost of beverage, either purchase or material cost
   * @param brewTemp temperature tea is brewed at (in Celsius)
   */ 
  public YerbaMate(String name, int ounces, double price, int brewTemp){
    this(name, ounces, price, brewTemp, DEFAULT_NUM_PASSES);
  }

/** 
  * Default constructor using constant variable default values 
  */
  public YerbaMate() {
    super();
    this.setNumPasses(DEFAULT_NUM_PASSES);
  }

  /** 
  * Copy constructor creates deep copy of all instance variables 
  */
  public YerbaMate(YerbaMate original) {
    if(original != null){
      this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.getBrewTemp(), original.numPasses);
    } else{
      System.out.println("ERROR: null data given to copy YerbaMate constructor");
      System.exit(0);
    }
  }

  //SETTER/MUTATORS
/**
  * Set number of passes with error checking
  *
  * @param numPasses number of people that have drank from the same gourd when sharing a mate
  *
  * @return boolean true if valid (>= 0), false otherwise
  */
  public boolean setNumPasses(int numPasses){
    if(numPasses >= 0){
      this.numPasses = numPasses; 
      return true;
    } else{
      return false;
    }
  }

/**
  * Sets all valid instance variables 
  *
  * @param name beverage name, can be as specific as you'd like
  * @param ounces bumber of fluid ounces in container (not total capacity) 
  * @param price cost of beverage, either purchase or material cost
  * @param brewTemp temperature tea is brewed at (in Celsius)
  * @param numPasses number of people that have drank from the same gourd when sharing a mate
  *
  * @return boolean true if all five parameters are valid
  */
  private boolean setAll(String name, int ounces, double price, int brewTemp, int numPasses){
    return super.setAll(name, ounces, price, brewTemp) && this.setNumPasses(numPasses);
  }

  /**
  * Increments numPasses and prints a notification to the console that the mate 
  * was passed along with the current count.
  */ 
  public void passNote(){
    this.numPasses++;
    System.out.println("Passed the mate, current # of passes" + this.numPasses);
  }

/**
  * When given a number of ounces of water that were added
  * will add to the ounces from CaffeinatedBeverage
  */
  public void refill(int ounces){
    if(ounces > 0) {
      this.setOunces( this.getOunces() + ounces );
    }
  }

//GETTER/ACCESSORS
/** 
  * Gets number of passes between people that have shared a drink from the gourd container
  *
  * @return number of passes of mate 
  */
  public int getNumPasses(){
    return this.numPasses;
  }

  @Override     
  public boolean equals(Object other){
    if(other == null || this.getClass() != other.getClass()){
      return false; 
    }
    YerbaMate otherMate = (YerbaMate) other;
    return super.equals(otherMate) && this.numPasses == otherMate.numPasses;
  }
  
  @Override
  public String toString() {
    String teaString = super.toString();
    int colonLocation = teaString.indexOf(":");
    teaString = teaString.substring(colonLocation + 2); 
    //cut off front label from Tea 

      return String.format("YerbaMate : %s, %d passes so far", teaString, this.numPasses);
  }
}