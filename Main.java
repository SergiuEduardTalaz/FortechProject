import business.HotelService;
import business.ManagementService;
import persistence.DataAccessObject;
import persistence.HotelDaoPostgresImpl;
import presentation.UserInterface;

public class Main {
    public static void main(String[] args) {

        DataAccessObject dataAccessObject = new DataAccessObject();
        ManagementService managementService = new ManagementService(dataAccessObject);
        UserInterface userInterface = new UserInterface(managementService);

        HotelService service = new HotelService(new HotelDaoPostgresImpl());
        service.update("   '; DROP table cars_tmp;update hotels set adress ='aaaa' WHERE ''='", "adddress");

        userInterface.printGreetingMessage();
        userInterface.showMainMenu();
    }

}