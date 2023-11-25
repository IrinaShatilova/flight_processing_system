package com.gridnine.testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

class FlightFilterTest {

    private static List<Flight> flights;

    @BeforeAll
    static void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    void testDepartureUntilNowFilter() {
        Filter departureUntilNowFilter = new DepartureUntilNowFilter();
        List<Flight> result = departureUntilNowFilter.filter(flights);
        assertEquals(5, result.size());
    }

    @Test
    void testArrivalEarlierDepartureFilter() {
        Filter arrivalEarlierDepartureFilter = new ArrivalEarlierDepartureFilter();
        List<Flight> result = arrivalEarlierDepartureFilter.filter(flights);
        assertEquals(5, result.size());
    }

    @Test
    void testTotalTimeOnEarthMoreThanTwoHoursFilter() {
        Filter totalTimeOnEarthMoreThanTwoHoursFilter = new TotalTimeOnEarthMoreThanTwoHoursFilter();
        List<Flight> result = totalTimeOnEarthMoreThanTwoHoursFilter.filter(flights);
        assertEquals(4, result.size());
    }

}
