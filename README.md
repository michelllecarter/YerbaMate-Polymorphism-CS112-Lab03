# YerbaMate-Polymorphism-CS112-Lab03

Lab 03 - Mate + Polymorphism
In this assignment, you will be creating an application for inventory of caffeinated beverages, which will keep track of how many beverages a student study group consumes to survive early morning classes and CS programming labs. A student intern has started the project but was moved to another project, so you're taking over the unfinished code. Note that nothing is documented, you are expected to complete the documentation and clean up the existing code (to follow our convention), as well as implement and document the parts of the project that are missing.

You will be creating 3 classes to represent this data: CaffeinatedBeverage.java, Tea.java and YerbaMate.java.  For our purposes, CaffeinatedBeverage will be the base (parent) class, Tea and YerbaMate will be the derived (child) classes. The UML diagram below visualizes this:

uml class diagram showing inheritance from CaffeinatedBeverage, Tea, and YerbaMate

Each are described below, along with the steps to complete this lab:

CaffeinatedBeverage: This is the ancestor class of the other two.Here are the specifications:

Create instance variables for name (String), **ounces **(int) and price (double).
Create all required methods for model classes (constructors, setters, getters, toString, equals)
Error check that **ounces** is valid (>= 0), as well as **price** (>= 0)
Create the sip() method that, when given a sip amount, subtracts it from the **ounces** instance variable. If the sip is greater than the number of ounces, it should leave it at 0 (not go into negatives!) and return false meaning there is no more liquid left (return true if there is still more left).
Tea: This one of the child (derived) classes.  Here are the specifications:

Create instance variable for brewTemp (int), the brew temperature in Celsius.
Create accessor/mutator for brewTemp, make sure to error check it is valid when setting.
Create a public constructor with 4 parameters (name, ounces, price, brewTemp), as well as default and copy constructors
Override the equals() method to compare all instance variables for equality.
Override the toString() method that displays all fields in the following format (ensure that price is formatted as currency): Tea: name, ounces, brewTemp, price.
For example: Tea: Chamomile, 16 ounces, brewed @ 90°C, $1.50

YerbaMate: This is the other descendent class, the child class of Tea.  Here are the specifications:

Create instance variable for numPasses (int), it represents the number of people that have drank from the same gourd when sharing a mate in the traditional customs.
Create accessor for numPasses, but the mutator will not be the usual setter. Instead, create a method passMate() that increments numPasses and prints a notification to the console that the mate was passed, along with the current count.
Create a constructor with 5 parameters (name, ounces, price, brewTemp, numPasses), as well as default and copy constructors
Create the refill() method that, when given a number of ounces of water that were added, will add to the **ounces** instance variable inherited from CaffeinatedBeverage
Override the equals() method to compare all instance variables for equality.
Override the toString() method that displays all fields in the following format: Yerba Mate: name, ounces, brewTemp, price, numPasses
For example: Yerba Mate: Cruz de Malta, 24 ounces, brewed @ 80°C, $3.50, 3 passes so far

Main.java: in this demo, write a main method that performs the following:

Creates an array that can store both Tea and YerbaMate
In a loop, prompt the user with 3 options to enter a new Tea (option 1), YerbaMate (option 2) in the inventory.  Option 3 is to exit.
If the user enters option 1, prompt for name, ounces, price and brew temperature.  Create a new Tea object and add it to the array.
Else if the user enters option 2, prompt for name, ounces, price, and brew temperature (passing 0 for number of passes since they just purchased the drink).  Create a new YerbaMate object and add it to the array.
Else if the user enters option 3 (exit option), loop through the array and print each object to the console.  Then display the YerbaMate with the highest price (maximum price) and average price of the whole array using the method you write in the next step.
Finally, create two methods (outside the main method):
public static double findAveragePrice(CaffeinatedBeverage[] inventory)  that will find the average of all beverages (Tea and YerbaMate together) in the array.  Call this in your main method to display the average price of all beverages (see step above)
public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory)  that will find the YerbaMate with the highest price (maximum price) in the array.  Use this in your main method to display the beverage with the highest price (see step above)
Hacker Challenge
coffee cup

Create another subclass to CaffeinatedBeverage, fully documented, and add it as a menu option to the driver (with the appropriate inputs). Think about who the parent should be, as it depends on the kind of beverage you are representing. It should have at least one other instance variable, with appropriate changes and new methods. For example, Coffee could have brewType (i.e., french press, espresso, pour over, etc.) with the additional setter/getter and appropriate constructor/equals/toString. Other ideas could be a class representing energy drinks, soda, etc.

Looking for an additional challenge?

man holding mate gourd out to viewer

Create a simulation of the mate ritual of passing the gourd around a circle of people. Start by asking how many people will be sharing the mate, and asking for each of their names. Print out each person's name when it's their turn.

Want even more of a challenge?

add the ability to refill the mate by having each person check if it's empty, if so have that person tell the cebador to refill the mate.
allow each person to choose to sip or opt out (by saying "Thank you" and passing it on, without sipping or incrementing the number of passes)
