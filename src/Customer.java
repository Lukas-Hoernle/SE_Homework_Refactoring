
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String name){
        this.name = name;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        StringBuilder resultBuilder = new StringBuilder().append("Rental Record for ").append(this.getName()).append("\n");
        resultBuilder.append("\t").append("Title").append("\t").append("\t").append("Days").append("\t").append("Amount").append("\n");


        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, rental);
            double amountPerLine = rental.amountFor();
            resultBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(String.valueOf(amountPerLine)).append("\n");
            totalAmount += amountPerLine;
        }

        //add footer lines
        resultBuilder.append("Amount owed is ").append(totalAmount).append("\n");
        resultBuilder.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return resultBuilder.toString();
    }

    private int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

}
    