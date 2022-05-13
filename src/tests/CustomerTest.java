package tests;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Viktor");
    }

    @Test
    public void getName() {
        assertEquals("Viktor", customer.getName());
    }

    @Test
    public void statement() {
        assertTrue(customer.statement().startsWith("Rental Record for Viktor"));
        assertTrue(customer.statement().endsWith(" frequent renter points"));
    }

}