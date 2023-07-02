package presentation;

import business.ManagementService;
import business.comparators.*;
import business.entities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class UserInterface {

    private final BufferedReader bufferedReader;
    private final ManagementService managementService;

    public UserInterface(ManagementService managementService) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.managementService = managementService;
    }

    public void printGreetingMessage() {
        System.out.println("Hello from Hotel Management System! :)");
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void showMainMenu() {
        String option;
        do {
            printOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handleOption(option);
        } while (shouldContinue(option));
    }

    private void showHotelMenu() {
        String option;
        do {
            printHotelOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handleHotelOption(option);
        } while (shouldContinue(option));
    }

    private void showRoomMenu() {
        String option;
        do {
            printRoomOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handleRoomOption(option);
        } while (shouldContinue(option));
    }

    private void showReservationMenu() {
        String option;
        do {
            printReservationOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handleReservationOption(option);
        } while (shouldContinue(option));
    }

    private void showCustomerMenu() {
        String option;
        do {
            printCustomerOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handleCustomerOption(option);
        } while (shouldContinue(option));
    }

    private void showPaymentMenu() {
        String option;
        do {
            printPaymentOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handlePaymentOption(option);
        } while (shouldContinue(option));
    }

    private void printOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Hotel Menu");
        System.out.println("2 - Room Menu");
        System.out.println("3 - Reservation Menu");
        System.out.println("4 - Customer Menu");
        System.out.println("5 - Payment Menu");
        System.out.println("0 - Exit Application ");
        System.out.println("----------------------------");
    }
    private void printPaymentOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Print payment data");
        System.out.println("2 - Sort payment data");
        System.out.println("3 - Search payment by customer ID");
        System.out.println("0 - Go back to main menu");
        System.out.println("----------------------------");
    }
    private void printCustomerOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Print customer data");
        System.out.println("2 - Sort the customer data");
        System.out.println("3 - Search customer by reservation ID");
        System.out.println("0 - Go back to main menu");
        System.out.println("----------------------------");
    }
    private void printReservationOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Print reservation data");
        System.out.println("2 - Add new reservation");
        System.out.println("3 - Remove existing reservation");
        System.out.println("4 - Sort the reservation data");
        System.out.println("5 - Change reservation data");
        System.out.println("0 - Go back to main menu");
        System.out.println("----------------------------");
    }
    private void printRoomOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Print room data");
        System.out.println("2 - Sort room data");
        System.out.println("3 - Change room price");
        System.out.println("0 - Go back to main menu");
        System.out.println("----------------------------");
    }
    private void printHotelOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Print hotel data");
        System.out.println("2 - Sort hotel data");
        System.out.println("0 - Go back to main menu");
        System.out.println("----------------------------");
    }

    private void handleOption(String option) {
        switch (option) {
            case "1":
                showHotelMenu();
                break;
            case "2":
                showRoomMenu();
                break;
            case "3":
                showReservationMenu();
                break;
            case "4":
                showCustomerMenu();
                break;
            case "5":
                showPaymentMenu();
                break;
            case "0":
                handleExitApplication();
                break;
            default:
                handleInvalidOption(option);
        }
    }

    private void handleHotelOption(String option) {
        switch (option) {
            case "1":
                handlePrintHotelData();
                break;
            case "2":
                handleSortingHotelData();
                break;
            case "0":
                return;
            default:
                handleInvalidOption(option);
        }
    }
    private void handleRoomOption(String option) {
        switch (option) {
            case "1":
                handlePrintRoomData();
                break;
            case "2":
                handleSortingRoomData();
                break;
            case "3":
                handleChangeRoomPrice();
                break;
            case "0":
                return;
            default:
                handleInvalidOption(option);
        }
    }
    private void handleReservationOption(String option) {
        switch (option) {
            case "1":
                handlePrintReservationData();
                break;
            case "2":
                handleAddNewReservation();
                break;
            case "3":
                handleRemoveExistingReservation();
                break;
            case "4":
                handleSortingReservationData();
                break;
            case "5":
                handleChangeReservationData();
                break;
            case "0":
                return;
            default:
                handleInvalidOption(option);
        }
    }
    private void handleCustomerOption(String option) {
        switch (option) {
            case "1":
                handlePrintCustomerData();
                break;
            case "2":
                handleSortingCustomerData();
                break;
            case "3":
                handleSearchCustomerByReservationId();
                break;
            case "0":
                return;
            default:
                handleInvalidOption(option);
        }
    }
    private void handlePaymentOption(String option) {
        switch (option) {
            case "1":
                handlePrintPaymentData();
                break;
            case "2":
                handleSortingPaymentData();
                break;
            case "3":
                handleSearchPaymentByCustomerId();
                break;
            case "0":
                return;
            default:
                handleInvalidOption(option);
        }
    }

    private void handleSearchPaymentByCustomerId() {
        System.out.print("Please enter customer ID: ");
        String customerIdString = readLine();
        int customerId = Integer.parseInt(customerIdString);
        HashMap<Customer, Payment> paymentByCustomerId = managementService.getPaymentByCustomerId(customerId);
        for (Customer customer : paymentByCustomerId .keySet()) {
            String key = customer.toString();
            String value = paymentByCustomerId .get(customer).toString();
            System.out.println(key + "\n" + value);
        }
    }

    private void handleSortingPaymentData() {
        List<Payment> payments = managementService.getPayments();
        payments.sort(new PaymentComparator());
        printPaymentData(payments);
    }

    private void handlePrintPaymentData() {
        System.out.println("Print payment data...");
        List<Payment> payments = managementService.getPayments();
        printPaymentData(payments);
    }
    private void printPaymentData(List<Payment> payments) {
        for (Payment currentPayment : payments) {
            System.out.println(currentPayment.toString());
        }
    }

    private void handleChangeRoomPrice() {
        System.out.print("Please enter room ID: ");
        String reservationIdString = readLine();
        int roomId = Integer.parseInt(reservationIdString);
        System.out.print("Please enter the new price: ");
        String priceString = readLine();
        Double newPrice = Double.parseDouble(priceString);
        System.out.println(managementService.updateRoomPrice(roomId, newPrice));
    }

    private void handleSortingRoomData() {
        List<Room> rooms = managementService.getRooms();
        rooms.sort(new RoomComparator());
        printRoomData(rooms);
    }

    private void handlePrintRoomData() {
        System.out.println("Print room data...");
        List<Room> rooms = managementService.getRooms();
        printRoomData(rooms);
    }

    private void printRoomData(List<Room> rooms) {
        for (Room currentRoom : rooms) {
            System.out.println(currentRoom.toString());
        }
    }

    private void handleChangeReservationData() {
        System.out.print("Please enter reservation ID: ");
        String reservationIdString = readLine();
        int reservationId = Integer.parseInt(reservationIdString);
        System.out.print("Please enter the new check-in date: ");
        String checkInDateString = readLine();
        LocalDate newDate = LocalDate.parse(checkInDateString);
        System.out.println(managementService.updateExistingReservationCheckInDate(reservationId, newDate));
    }

    private void handleSearchCustomerByReservationId() {
        System.out.print("Please enter reservation ID: ");
        String reservationIdString = readLine();
        int reservationId = Integer.parseInt(reservationIdString);
        HashMap<Reservation, Customer> customerByReservationId = managementService.getCustomerByReservationId(reservationId);
        for (Reservation reservation : customerByReservationId.keySet()) {
            String key = reservation.toString();
            String value = customerByReservationId.get(reservation).toString();
            System.out.println(key + "\n" + value);
        }
    }

    private void handlePrintHotelData() {
        System.out.println("Print hotel data...");
        List<Hotel> hotels = managementService.getHotels();
        printHotelData(hotels);
    }

    private void printHotelData(List<Hotel> hotels) {
        for (Hotel currentHotel : hotels) {
            System.out.println(currentHotel.toString());
        }
    }

    private void handleSortingHotelData() {
        List<Hotel> hotels = managementService.getHotels();
        hotels.sort(new HotelComparator());
        printHotelData(hotels);
    }

    private void handlePrintReservationData() {
        System.out.println("Print reservation data...");
        List<Reservation> reservations = managementService.getReservations();
        printReservationData(reservations);
    }

    private void printReservationData(List<Reservation> reservations) {
        for (Reservation currentReservation : reservations) {
            System.out.println(currentReservation.toString());
        }
    }

    private void handleAddNewReservation() {
        System.out.println("Add new reservation...");
        Reservation newReservation = readReservation();
        managementService.addNewReservation(newReservation);
        System.out.println("New reservation added successfully!");
    }

    private Reservation readReservation() {
        System.out.print("Please enter reservation ID: ");
        String reservationIdString = readLine();
        int reservationId = Integer.parseInt(reservationIdString);
        System.out.print("Please enter date of reservation: ");
        String dateOfReservationString = readLine();
        LocalDate dateOfReservation = LocalDate.parse(dateOfReservationString);
        System.out.print("Please enter date of check in: ");
        String dateOfCheckInString = readLine();
        LocalDate dateOfCheckIn = LocalDate.parse(dateOfCheckInString);
        System.out.print("Please enter date of check out: ");
        String dateOfCheckOutString = readLine();
        LocalDate dateOfCheckOut = LocalDate.parse(dateOfCheckOutString);
        System.out.print("Please enter number of persons: ");
        String numberOfPersonsString = readLine();
        int numberOfPersons = Integer.parseInt(numberOfPersonsString);
        System.out.print("Please enter room ID: ");
        String roomIdString = readLine();
        int roomId = Integer.parseInt(roomIdString);

        Reservation reservation = new Reservation(reservationId, dateOfReservation, dateOfCheckIn, dateOfCheckOut, numberOfPersons, roomId);
        return reservation;

    }

    private void handleRemoveExistingReservation() {
        System.out.println("Remove existing reservation...");
        System.out.print("Please enter reservation ID: ");
        String reservationIdString = readLine();
        int reservationId = Integer.parseInt(reservationIdString);
        managementService.removeExistingReservation(reservationId);
        System.out.println("Reservation removed successfully!");
    }

    private void handleSortingReservationData() {
        List<Reservation> reservations = managementService.getReservations();
        reservations.sort(new ReservationComparator());
        printReservationData(reservations);
    }

    private void handlePrintCustomerData() {
        System.out.println("Print customer data...");
        List<Customer> customers = managementService.getCustomers();
        printCustomerData(customers);
    }

    private void printCustomerData(List<Customer> customers) {
        for (Customer currentCustomer : customers) {
            System.out.println(currentCustomer.toString());
        }
    }

    private void handleSortingCustomerData() {
        List<Customer> customers = managementService.getCustomers();
        customers.sort(new CustomerComparator());
        printCustomerData(customers);
    }

    private void handleExitApplication() {
        System.out.println("Exit application...");
        System.out.println("Bye bye!");
    }

    private void handleInvalidOption(String option) {
        System.out.println(option + " is invalid.");
    }

    private boolean shouldContinue(String option) {
        if ("0".equals(option)) {
            return false;
        } else {
            return true;
        }
    }
}





