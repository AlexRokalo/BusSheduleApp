import BusesShedule.Bus;
import OperationsBase.SortOperation.OperationSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortOperationTest {

    @Test
    public void testSortPrice() {
        OperationSort operationSort = new OperationSort();
        Bus bus1 = new Bus.BusBuilder().setBusNumber("1").setID("1").setDateEnd("2018-08-21 12:35:00 +0300")
                .setDateStart("2018-08-20 12:35:00 +0300").setlocationEnd("Brest")
                .setlocationStart("Minsk").setPrice("200").setWaypoints(new ArrayList<String>()).create();

        Bus bus2 = new Bus.BusBuilder().setBusNumber("2").setID("2").setDateEnd("2018-08-21 12:35:00 +0300 ")
                .setDateStart("2018-08-20 12:35:00 +0300").setlocationEnd("Brest")
                .setlocationStart("Minsk").setPrice("400").setWaypoints(new ArrayList<String>()).create();

        List<Bus> buses = new ArrayList<>();
        buses.add(bus1);
        buses.add(bus2);

        List<Bus> buses1 = new ArrayList<>();
        buses1.add(bus1);
        buses1.add(bus2);


        assertEquals(buses, operationSort.sortByPrice(buses1));
    }

    @Test
    public void testSortTime(){
        OperationSort operationSort = new OperationSort();
        Bus bus1 = new Bus.BusBuilder().setBusNumber("1").setID("1").setDateEnd("2018-08-21 12:35:00 +0300")
                .setDateStart("2018-08-20 12:35:00 +0300").setlocationEnd("Brest")
                .setlocationStart("Minsk").setPrice("200").setWaypoints(new ArrayList<String>()).create();

        Bus bus2 = new Bus.BusBuilder().setBusNumber("2").setID("2").setDateEnd("2018-08-11 12:35:00 +0300 ")
                .setDateStart("2018-08-10 12:35:00 +0300").setlocationEnd("Brest")
                .setlocationStart("Minsk").setPrice("400").setWaypoints(new ArrayList<String>()).create();

        List<Bus> buses = new ArrayList<>();
        buses.add(bus2);
        buses.add(bus1);

        List<Bus> buses1 = new ArrayList<>();
        buses1.add(bus1);
        buses1.add(bus2);

        assertEquals(buses, operationSort.sortByTime(buses1));
    }

}
