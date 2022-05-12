class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie movie, int daysRented) {
        movie = movie;
        daysRented = daysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        double charge = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                charge += 2;
                if (getDaysRented() > 2)
                    charge += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                charge += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                charge += 1.5;
                if (getDaysRented() > 3)
                    charge += (getDaysRented() - 3) * 1.5;
                break;
        }
        return charge;
    }

    int getFrequentRenterPoints(int frequentRenterPoints) {
        frequentRenterPoints++;
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}