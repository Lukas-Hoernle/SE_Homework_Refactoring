
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();
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
        ChargeStatement chargeStatement = new ChargeStatement();
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        chargeStatement.addHeader(this.getName());

        int frequentRenterPoints = 0;
        while (rentalEnumeration.hasMoreElements()) {
            Rental rental = rentalEnumeration.nextElement();
            chargeStatement.addRental(rental);
            frequentRenterPoints = updateFrequentRenterPoints(frequentRenterPoints, rental);
        }
        chargeStatement.addFooter(getTotalCharge(), frequentRenterPoints);
        return chargeStatement.getContent();
    }

    private int updateFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints += rental.getFrequentRenterPoints(frequentRenterPoints);
        return frequentRenterPoints;
    }

    private double getTotalCharge(){
     double result =0;
    Enumeration<Rental> rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {
            Rental rental = rentalEnumeration.nextElement();
            result += rental.amountFor();
        }
    return result;
    }
}
    