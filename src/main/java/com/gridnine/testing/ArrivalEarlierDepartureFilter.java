package com.gridnine.testing;
import java.util.List;
import java.util.stream.Collectors;

public class ArrivalEarlierDepartureFilter implements Filter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
