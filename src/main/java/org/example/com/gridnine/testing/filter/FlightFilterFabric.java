package org.example.com.gridnine.testing.filter;

import org.example.com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterFabric {
    private final List<FilterFlights> filters;

    public FlightFilterFabric(List<FilterFlights> filters) {
        this.filters = filters;
    }

    public List<Flight> doFilter(List<Flight> flights) {
        List<Flight> filterList = new ArrayList<>(flights);

        for(FilterFlights filter : filters){
            filterList = filter.filter(filterList);
        }

        return filterList;
    }
}
