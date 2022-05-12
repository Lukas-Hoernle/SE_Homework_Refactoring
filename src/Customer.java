
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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        StringBuilder resultBuilder = new StringBuilder();
        addHeader(resultBuilder);


        while (rentalEnumeration.hasMoreElements()) {
            Rental rental = rentalEnumeration.nextElement();
            frequentRenterPoints = rental.getFrequentRenterPoints(frequentRenterPoints);
            double amountPerLine = rental.amountFor();
            resultBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(String.valueOf(amountPerLine)).append("\n");
            totalAmount += amountPerLine;
        }
        addFooter(totalAmount, frequentRenterPoints, resultBuilder);
        return resultBuilder.toString();
    }

    private void addHeader(StringBuilder resultBuilder) {
        resultBuilder.append("Rental Record for ").append(this.getName()).append("\n");
        resultBuilder.append("\t").append("Title").append("\t").append("\t").append("Days").append("\t").append("Amount").append("\n");
    }

    private void addFooter(double totalAmount, int frequentRenterPoints, StringBuilder resultBuilder) {
        resultBuilder.append("Amount owed is ").append(totalAmount).append("\n");
        resultBuilder.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
    }

}
    