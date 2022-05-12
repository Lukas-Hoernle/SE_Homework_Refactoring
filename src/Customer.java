
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
        ChargeStatement result = new ChargeStatement();
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        result.addHeader(this.getName());

        int frequentRenterPoints = 0;
        while (rentalEnumeration.hasMoreElements()) {
            Rental rental = rentalEnumeration.nextElement();
            result.addRental(rental);
            frequentRenterPoints = updateFrequentRenterPoints(frequentRenterPoints, rental);
        }
        double totalAmount = getTotalCharge();
        result.addFooter(totalAmount, frequentRenterPoints);
        return result.getContent();
    }

    private int updateFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints += rental.getFrequentRenterPoints(frequentRenterPoints);
        return frequentRenterPoints;
    }

    private void appendResult(StringBuilder resultBuilder, Rental rental) {
        resultBuilder.append("\t")
                .append(rental.getMovie().getTitle()).append("\t")
                .append(rental.getDaysRented()).append("\t")
                .append(rental.amountFor()).append("\n");
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
    