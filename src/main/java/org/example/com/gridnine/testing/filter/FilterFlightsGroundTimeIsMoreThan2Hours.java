package org.example.com.gridnine.testing.filter;

import org.example.com.gridnine.testing.model.Flight;
import org.example.com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FilterFlightsGroundTimeIsMoreThan2Hours implements FilterFlights {
        @Override
        public List<Flight> filter(List<Flight> flights) {
            System.out.println("Successfully filtered : flight's with more than two hours ground time");
            return flights
                    .stream()
                    .filter(flight -> checkTimeOnGround(flight.getSegments()))
                    .toList();
        }

        private boolean checkTimeOnGround(List<Segment> segments) {
            if (segments.size() == 1) {
                return true;
            }
            int transportTimeOnGround = 0;
            for (int i = 1; i < segments.size(); i++) {
                transportTimeOnGround += timeOnGround(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());
            }
            int hoursOnEarth = 2;

            return transportTimeOnGround <= hoursOnEarth;
        }

        private int timeOnGround(LocalDateTime arr, LocalDateTime dep) {
            return (int) ChronoUnit.HOURS.between(arr, dep);
        }
}
