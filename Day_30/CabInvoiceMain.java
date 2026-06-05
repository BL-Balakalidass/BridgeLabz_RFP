package Day_30;

import Day_30.model.InvoiceSummary;
import Day_30.model.Ride;
import Day_30.model.RideType;
import Day_30.repository.RideRepository;
import Day_30.service.InvoiceService;

public class CabInvoiceMain {
    public static void main(String[] args) {

        Ride[] rides = {
                new Ride(2.0, 5, RideType.NORMAL),
                new Ride(3.0, 10, RideType.PREMIUM)
        };

        RideRepository repository = new RideRepository();
        repository.addRides("USER_1", rides);

        InvoiceService service = new InvoiceService(repository);
        InvoiceSummary summary = service.getInvoice("USER_1");

        System.out.println("Total Rides: " + summary.totalRides);
        System.out.println("Total Fare: Rs." + summary.totalFare);
        System.out.println("Average Fare: Rs." + summary.averageFare);
    }
}
