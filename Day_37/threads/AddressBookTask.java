package Day_37.threads;

public class AddressBookTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Performing IO operation in separate thread");
    }
}

