# RentCalc
A program to calculate how much rent to be paid in a household, depending on how many household members and their respective income

<h2>Running the program</h2>

The program is built into a .jar application located in the target folder. Simply run thru command line with <i>java -jar RentCalc.jar</i> and the program will run on the command line.

<h4>Main Functions</h4>

Upon init. user will be prompted to instantiate a household. This is simply done by adding a new HouseholdMember into an internal list. Request is finished by pressing enter without entering any input upon completition. Once all Household Member has been added, user will be prompted to add the income for each member. Note that this is done by the UI for <i>console version</i>. 

The application is built with modularity in mind. The main methods that make up the function of the application are <i>setRent(), setTotalIncome()</i> and <i>calculatePercentage()</i>. 

<b>setRent()</b> is called as soon as household has been initialized, and takes user input. Currently, there's no method to check for valid input, but the by having small and decoupled methods, this isn't a difficult solution to implement. The input represents the total rent for the household and will be stored internally.

<b>setTotalIncome()</b> is called next and represents the total added monetary amount for each member and adds it to an internal variable. 

<b>calculatePercentage()</b> takes the total income and displays how much each member is to pay in percentage and monetary amount.

<h4>Modularity</h4>

As mentioned, modularity and encapsulation is thought as a main feature. Introducing a GUI element would be easy, as all the business logic in the Logic class kan be called from either a main method alone, or added to a buttonlistener in a Swing/JavaFX application. It could potentially be made into a web app, however the application logic is extremely simple and could be done just as well using only Javascript.

