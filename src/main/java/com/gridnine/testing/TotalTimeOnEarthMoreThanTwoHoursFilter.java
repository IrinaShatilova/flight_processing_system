package com.gridnine.testing;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TotalTimeOnEarthMoreThanTwoHoursFilter implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> calculateTimeOnEarth(flight.getSegments()) <= 2 * 60)
                .collect(Collectors.toList());
    }
    private long calculateTimeOnEarth(List<Segment> segments) {
        long groundTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            groundTime += Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toMinutes();
        }
        return groundTime;
    }
}
