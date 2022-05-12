
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
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        StringBuilder resultBuilder = new StringBuilder();
        addHeader(resultBuilder);

        int frequentRenterPoints = 0;
        while (rentalEnumeration.hasMoreElements()) {
            Rental rental = rentalEnumeration.nextElement();
            appendResult(resultBuilder, rental);
            frequentRenterPoints = updateFrequentRenterPoints(frequentRenterPoints, rental);
        }
        double totalAmount = getTotalCharge();
        addFooter(totalAmount, frequentRenterPoints, resultBuilder);
        return resultBuilder.toString();
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

    private void addHeader(StringBuilder resultBuilder) {
        resultBuilder.append("Rental Record for ").append(this.getName()).append("\n");
        resultBuilder.append("\t").append("Title").append("\t").append("\t").append("Days").append("\t").append("Amount").append("\n");
    }

    private void addFooter(double totalAmount, int frequentRenterPoints, StringBuilder resultBuilder) {
        resultBuilder.append("Amount owed is ")
                .append(totalAmount)
                .append("\n");
        resultBuilder.append("You earned ")
                .append(frequentRenterPoints)
                .append(" frequent renter points");
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
    