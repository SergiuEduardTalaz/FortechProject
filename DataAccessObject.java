package persistence;

import business.entities.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataAccessObject {

    public List<Payment> loadAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/payments.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"***".equals(currentLine)) {
                Payment currentPayment = readPayment(bufferedReader);
                payments.add(currentPayment);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return payments;
    }

    public void saveAllPayments(List<Payment> payments) {
        try (FileWriter fileWriter = new FileWriter("resources/payments.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Payment currentPayment : payments) {
                writePayment(printWriter, currentPayment);
            }
            printWriter.println("***");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Payment readPayment(BufferedReader bufferedReader) throws IOException {
       String paymentIdString = bufferedReader.readLine();
       int paymentId = Integer.parseInt(paymentIdString);
       String dateOfPaymentString = bufferedReader.readLine();
       LocalDate dateOfPayment = LocalDate.parse(dateOfPaymentString);
       String amountString = bufferedReader.readLine();
       Double amount = Double.parseDouble(amountString);
       String typeOfPayment = bufferedReader.readLine();
       String customerIdString = bufferedReader.readLine();
       int customerId = Integer.parseInt(customerIdString);

        return new Payment(paymentId, dateOfPayment, amount, typeOfPayment, customerId);
    }

    private void writePayment(PrintWriter printWriter, Payment payment) {
        printWriter.println("+++");
        printWriter.println(payment.getPaymentId());
        printWriter.println(payment.getDateOfPayment());
        printWriter.println(payment.getAmount());
        printWriter.println(payment.getTypeOfPayment());
        printWriter.println(payment.getCustomerId());
    }

    public List<Room> loadAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/rooms.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"***".equals(currentLine)) {
                Room currentRoom = readRoom(bufferedReader);
                rooms.add(currentRoom);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return rooms;
    }

    public void saveAllRooms(List<Room> rooms) {
        try (FileWriter fileWriter = new FileWriter("resources/rooms.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Room currentRoom : rooms) {
                writeRoom(printWriter, currentRoom);
            }
            printWriter.println("***");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Room readRoom(BufferedReader bufferedReader) throws IOException {
       String roomIdString = bufferedReader.readLine();
       int roomId = Integer.parseInt(roomIdString);
       String numberOfRoom = bufferedReader.readLine();
       String type = bufferedReader.readLine();
       String capacityString = bufferedReader.readLine();
       int capacity = Integer.parseInt(capacityString);
       String priceString = bufferedReader.readLine();
       double price = Double.parseDouble(priceString);
       String status = bufferedReader.readLine();
       String hotelIdString = bufferedReader.readLine();
       int hotelId = Integer.parseInt(hotelIdString);

        return new Room (roomId, numberOfRoom, type, capacity, price, status, hotelId);
    }

    private void writeRoom(PrintWriter printWriter, Room room) {
        printWriter.println("+++");
        printWriter.println(room.getRoomId());
        printWriter.println(room.getNumberOfRoom());
        printWriter.println(room.getType());
        printWriter.println(room.getCapacity());
        printWriter.println(room.getPrice());
        printWriter.println(room.getStatus());
        printWriter.println(room.getHotelId());
    }


    public List<Customer> loadAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/customers.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"***".equals(currentLine)) {
                Customer currentCustomer = readCustomer(bufferedReader);
                customers.add(currentCustomer);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return customers;
    }

    public void saveAllCustomers(List<Customer> customers) {
        try (FileWriter fileWriter = new FileWriter("resources/customers.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Customer currentCustomer : customers) {
                writeCustomer(printWriter, currentCustomer);
            }
            printWriter.println("***");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Customer readCustomer(BufferedReader bufferedReader) throws IOException {
        String customerIdString = bufferedReader.readLine();
        int customerId = Integer.parseInt(customerIdString);
        String firstName = bufferedReader.readLine();
        String lastName = bufferedReader.readLine();
        String dateOfBirthString = bufferedReader.readLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        String phoneNumber = bufferedReader.readLine();
        String email = bufferedReader.readLine();
        String reservationIdString = bufferedReader.readLine();
        int reservationId = Integer.parseInt(reservationIdString);

        return new Customer(customerId, firstName, lastName, dateOfBirth, phoneNumber, email, reservationId);
    }

    private void writeCustomer(PrintWriter printWriter, Customer customer) {
        printWriter.println("+++");
        printWriter.println(customer.getCustomerId());
        printWriter.println(customer.getFirstName());
        printWriter.println(customer.getLastName());
        printWriter.println(customer.getDateOfBirth());
        printWriter.println(customer.getPhoneNumber());
        printWriter.println(customer.getEmail());
        printWriter.println(customer.getReservationId());
    }

    public List<Reservation> loadAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/reservations.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"***".equals(currentLine)) {
                Reservation currentReservation = readReservation(bufferedReader);
                reservations.add(currentReservation);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return reservations;
    }

    public void saveAllReservations(List<Reservation> reservations) {
        try (FileWriter fileWriter = new FileWriter("resources/reservations.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Reservation currentReservation : reservations) {
                writeReservation(printWriter, currentReservation);
            }
            printWriter.println("***");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Reservation readReservation(BufferedReader bufferedReader) throws IOException {
        String reservationIdString = bufferedReader.readLine();
        int reservationId = Integer.parseInt(reservationIdString);
        String dateOfReservationString = bufferedReader.readLine();
        LocalDate dateOfReservation = LocalDate.parse(dateOfReservationString);
        String dateOfCheckInString = bufferedReader.readLine();
        LocalDate dateOfCheckIn = LocalDate.parse(dateOfCheckInString);
        String dateOfCheckOutString = bufferedReader.readLine();
        LocalDate dateOfCheckOut = LocalDate.parse(dateOfCheckOutString);
        String numberOfPersonsString = bufferedReader.readLine();
        int numberOfPersons = Integer.parseInt(numberOfPersonsString);
        String roomIdString = bufferedReader.readLine();
        int roomId = Integer.parseInt(roomIdString);

        return new Reservation(reservationId, dateOfReservation, dateOfCheckIn,
                dateOfCheckOut, numberOfPersons, roomId);
    }

    private void writeReservation(PrintWriter printWriter, Reservation reservation) {
        printWriter.println("+++");
        printWriter.println(reservation.getReservationId());
        printWriter.println(reservation.getDateOfReservation());
        printWriter.println(reservation.getDateOfCheckIn());
        printWriter.println(reservation.getDateOfCheckOut());
        printWriter.println(reservation.getNumberOfPersons());
        printWriter.println(reservation.getRoomId());
    }

    public List<Hotel> loadAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/hotels.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"***".equals(currentLine)) {
                Hotel currentHotel = readHotel(bufferedReader);
                hotels.add(currentHotel);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return hotels;
    }

    public void saveAllHotels(List<Hotel> hotels) {
        try (FileWriter fileWriter = new FileWriter("resources/hotels.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Hotel currentHotel : hotels) {
                writeHotel(printWriter, currentHotel);
            }
            printWriter.println("***");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Hotel readHotel(BufferedReader bufferedReader) throws IOException {
        String hotelIdString = bufferedReader.readLine();
        int hotelId = Integer.parseInt(hotelIdString);
        String name = bufferedReader.readLine();
        String address = bufferedReader.readLine();
        String phoneNumber = bufferedReader.readLine();
        String services = bufferedReader.readLine();

        return new Hotel(hotelId, name, address, phoneNumber, services);
    }

    private void writeHotel(PrintWriter printWriter, Hotel hotel) {
        printWriter.println("+++");
        printWriter.println(hotel.getHotelId());
        printWriter.println(hotel.getName());
        printWriter.println(hotel.getAddress());
        printWriter.println(hotel.getPhoneNumber());
        printWriter.println(hotel.getServices());
    }
}
