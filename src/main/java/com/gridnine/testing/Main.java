package com.gridnine.testing;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Flight> flights = FlightBuilder.createFlights();
    Filter departureUntilNowFilter = new DepartureUntilNowFilter();
    Filter arrivalEarlierDepartureFilter = new ArrivalEarlierDepartureFilter();
    Filter totalTimeOnEarthMoreThanTwoHoursFilter = new TotalTimeOnEarthMoreThanTwoHoursFilter();

        System.out.println("\nВсе имеющиеся рейсы:");
        flights.forEach(System.out::println);

        System.out.println("\nРейсы, исключающие вылеты до текущего момента:");
        departureUntilNowFilter.filter(flights).forEach(System.out::println);

        System.out.println("\nРейсы, с исключением сегментов с датой прилета раньше даты вылета:");
        arrivalEarlierDepartureFilter.filter(flights).forEach(System.out::println);

        System.out.println("\nПерелеты, исключающие рейсы, где общее время на земле, превышает два часа:");
        totalTimeOnEarthMoreThanTwoHoursFilter.filter(flights).forEach(System.out::println);
    }
}