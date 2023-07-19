package org.example.com.gridnine.testing;

import org.example.com.gridnine.testing.filter.*;
import org.example.com.gridnine.testing.model.Flight;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        flightList.forEach(System.out::println);
        System.out.println();

        FilterFlights filter1 = new FilterFlightsDepartBeforeArrives();
        filter1.filter(flightList).forEach(System.out::println);
        System.out.println();

        FilterFlights filter2 = new FilterFlightsDepartingInFuture();
        filter2.filter(flightList).forEach(System.out::println);
        System.out.println();

        FilterFlights filter3 = new FilterFlightsGroundTimeIsMoreThan2Hours();
        filter3.filter(flightList).forEach(System.out::println);
        System.out.println();

        FlightFilterFabric filterFabric = new FlightFilterFabric(Arrays.asList(
                filter1,
                filter2,
                filter3
        ));

        filterFabric.doFilter(flightList).forEach(System.out::println);
    }
}