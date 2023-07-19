package org.example.com.gridnine.testing.filter;

import org.example.com.gridnine.testing.model.Flight;

import java.util.List;

public interface FilterFlights {
    List<Flight> filter(List<Flight> flights);
}
