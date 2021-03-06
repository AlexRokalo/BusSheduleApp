package BusesShedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Bus {
    private int id;
    private int busNumber;
    private String locationStart;
    private String locationEnd;
    private int price;
    private Date dateStart;
    private Date dateEnd;
    private List<Waypoints> waypoints = new ArrayList<>();

    public int getBusNumber() {
        return busNumber;
    }

    public int getPrice() {
        return price;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public String getLocationStart() {
        return locationStart;
    }

    public String getLocationEnd() {
        return locationEnd;
    }

    public List<Waypoints> getWaypoints() {
        return waypoints;
    }

    public Date getDateEnd() {
        return dateEnd;
    }


    @Override
    public String toString() {
        return "\nАвтобус " + busNumber +
                "\n\tОтправляется с : " + locationStart + ", время отправиления " + dateStart +
                "\n\tПрибывает в : " + locationEnd + ", время прибытия " + dateEnd +
                "\n\tЦена :" + price +
                "\n\tОстановки в пути :" + show();
    }

    public static class Waypoints {
        private String place;

        public Waypoints(String place) {
            this.place = place;
        }

        public String getPlace() {
            return place;
        }

        @Override
        public String toString() {
            return "\n\t\t" + place;
        }
    }

    private String show() {
        String s = "";
        for (Waypoints waypoint : waypoints)
            s += waypoint.toString();
        return s;
    }

    public static class BusBuilder {
        private Bus bus = new Bus();

        public BusBuilder setID(String id) {
            bus.id = Integer.decode(id);
            return this;
        }

        public BusBuilder setBusNumber(String busNumber) {
            bus.busNumber = Integer.decode(busNumber);
            return this;
        }

        public BusBuilder setlocationStart(String locationStart) {
            bus.locationStart = locationStart;
            return this;
        }

        public BusBuilder setlocationEnd(String locationEnd) {
            bus.locationEnd = locationEnd;
            return this;
        }

        public BusBuilder setPrice(String price) {
            bus.price = Integer.decode(price);
            return this;
        }

        public BusBuilder setDateStart(String dateStart) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            try {
                bus.dateStart = format.parse(dateStart);
            } catch (ParseException e) {
                System.out.println("Ошибка в файле (формат ввода : yyyy-MM-dd HH:mm:ss Z) " + e.getMessage());
            }
            return this;
        }

        public BusBuilder setDateEnd(String dateEnd) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            try {
                bus.dateEnd = format.parse(dateEnd);
            } catch (ParseException e) {
                System.out.println("Ошибка в файле (формат ввода : yyyy-MM-dd HH:mm:ss Z) " + e.getMessage());
            }
            return this;
        }

        public BusBuilder setWaypoints(List<String> array) {
            for (int i = 0; i < array.size(); i++)
                bus.waypoints.add(new Waypoints(array.get(i)));
            return this;
        }

        public Bus create() {
            return bus;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return id == bus.id &&
                busNumber == bus.busNumber &&
                price == bus.price &&
                Objects.equals(locationStart, bus.locationStart) &&
                Objects.equals(locationEnd, bus.locationEnd) &&
                Objects.equals(dateStart, bus.dateStart) &&
                Objects.equals(dateEnd, bus.dateEnd) &&
                Objects.equals(waypoints, bus.waypoints);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, busNumber, locationStart, locationEnd, price, dateStart, dateEnd, waypoints);
    }
}