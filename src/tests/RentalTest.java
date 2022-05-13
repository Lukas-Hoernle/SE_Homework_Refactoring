package tests;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RentalTest {

    private Rental rental;
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Movie Title", 0);
        rental = new Rental(movie, 10);
    }

    @Test
    public void getDaysRented() {
        assertEquals(10, rental.getDaysRented());
    }

    @Test
    public void getMovie() {
        assertEquals(movie, rental.getMovie());
    }

}