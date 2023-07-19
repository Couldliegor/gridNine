package org.example.com.gridnine.testing.filter;

import org.example.com.gridnine.testing.model.Flight;
import org.example.com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class FilterFlightsDepartingInFuture implements FilterFlights {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Successfully filtered : departing in the Future");
        return flights
                .stream()
                .filter(flight -> checkDepartInTheFuture(flight.getSegments()))
                .toList();
    }

    private boolean checkDepartInTheFuture(List<Segment> segments){
        return segments
                .stream()
                .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()));
    }
}
