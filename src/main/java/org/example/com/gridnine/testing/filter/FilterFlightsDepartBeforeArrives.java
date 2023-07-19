package org.example.com.gridnine.testing.filter;

import org.example.com.gridnine.testing.model.Flight;
import org.example.com.gridnine.testing.model.Segment;

import java.util.List;

public class FilterFlightsDepartBeforeArrives implements FilterFlights {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Successfully Filtered issue : departing is before arrive");
        return flights
                .stream()
                .filter(flight -> checkDepartureDate(flight.getSegments()))
                .toList();
    }

    private boolean checkDepartureDate(List<Segment> segments){
        return segments
                .stream()
                .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()));
    }
}
