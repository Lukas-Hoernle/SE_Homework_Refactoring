public class ChargeStatement {
    private String content;
    private StringBuilder contentBuilder=new StringBuilder(content);
    public String getContent() {
        content=contentBuilder.toString();
        return content;
    }
    public void addHeader(String name) {
        contentBuilder.append("Rental Record for ")
                .append(name)
                .append("\n");
        contentBuilder.append("\t")
                .append("Title\t\t")
                .append("Days\t")
                .append("Amount")
                .append("\n");
    }
    public void addFooter(double totalAmount, int frequentRenterPoints) {
        contentBuilder.append("Amount owed is ")
                .append(totalAmount)
                .append("\n");
        contentBuilder.append("You earned ")
                .append(frequentRenterPoints)
                .append(" frequent renter points");
    }
    public void addRental(Rental rental) {
        contentBuilder.append("\t")
                .append(rental.getMovie().getTitle()).append("\t")
                .append(rental.getDaysRented()).append("\t")
                .append(rental.getCharge()).append("\n");
    }

}
