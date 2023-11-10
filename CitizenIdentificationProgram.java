import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class CitizenIdentificationProgram {
    private static final Map<String, String> CITY_CODES = new HashMap<>();
    static {
		 CITY_CODES.put("001", "Hà Nội");
		 CITY_CODES.put("002", "Hà Giang");
		 CITY_CODES.put("004", "Cao Bằng");
		 CITY_CODES.put("006", "Bắc Kạn");
		 CITY_CODES.put("008", "Tuyên Quang");
		 CITY_CODES.put("010", "Lào Cai");
		 CITY_CODES.put("011", "Điện Biên");
		 CITY_CODES.put("012", "Lai Châu");
		 CITY_CODES.put("014", "Sơn La");
		 CITY_CODES.put("015", "Yên Bái");
		 CITY_CODES.put("017", "Hòa Bình");
		 CITY_CODES.put("019", "Thái Nguyên");
		 CITY_CODES.put("020", "Lạng Sơn");
		 CITY_CODES.put("022", "Quảng Ninh");
		 CITY_CODES.put("024", "Bắc Giang");
		 CITY_CODES.put("025", "Phú Thọ");
		 CITY_CODES.put("026", "Vĩnh Phúc");
		 CITY_CODES.put("027", "Bắc Ninh");
		 CITY_CODES.put("030", "Hải Dương");
		 CITY_CODES.put("031", "Hải Phòng");
		 CITY_CODES.put("033", "Hưng Yên");
		 CITY_CODES.put("034", "Thái Bình");
		 CITY_CODES.put("035", "Hà Nam");
		 CITY_CODES.put("036", "Nam Định");
		 CITY_CODES.put("037", "Ninh Bình");
		 CITY_CODES.put("038", "Thanh Hóa");
		 CITY_CODES.put("040", "Nghệ An");
		 CITY_CODES.put("042", "Hà Tĩnh");
		 CITY_CODES.put("044", "Quảng Bình");
		 CITY_CODES.put("045", "Quảng Trị");
		 CITY_CODES.put("046", "Thừa Thiên Huế");
		 CITY_CODES.put("048", "Đà Nẵng");
		 CITY_CODES.put("049", "Quảng Nam");
		 CITY_CODES.put("051", "Quảng Ngãi");
		 CITY_CODES.put("052", "Bình Định");
		 CITY_CODES.put("054", "Phú Yên");
		 CITY_CODES.put("056", "Khánh Hòa");
		 CITY_CODES.put("058", "Ninh Thuận");
		 CITY_CODES.put("060", "Bình Thuận");
		 CITY_CODES.put("062", "Kon Tum");
		 CITY_CODES.put("064", "Gia Lai");
		 CITY_CODES.put("066", "Đắk Lắk");
		 CITY_CODES.put("067", "Đắk Nông");
		 CITY_CODES.put("068", "Lâm Đồng");
		 CITY_CODES.put("070", "Bình Phước");
		 CITY_CODES.put("072", "Tây Ninh");
		 CITY_CODES.put("074", "Bình Dương");
		 CITY_CODES.put("075", "Đồng Nai");
		 CITY_CODES.put("077", "Bà Rịa - Vũng Tàu");
		 CITY_CODES.put("079", "Hồ Chí Minh");
		 CITY_CODES.put("080", "Long An");
		 CITY_CODES.put("082", "Tiền Giang");
		 CITY_CODES.put("083", "Bến Tre");
		 CITY_CODES.put("084", "Trà Vinh");
		 CITY_CODES.put("086", "Vĩnh Long");
		 CITY_CODES.put("087", "Đồng Tháp");
		 CITY_CODES.put("089", "An Giang");
		 CITY_CODES.put("091", "Kiên Giang");
		 CITY_CODES.put("092", "Cần Thơ");
		 CITY_CODES.put("093", "Hậu Giang");
		 CITY_CODES.put("094", "Sóc Trăng");
		 CITY_CODES.put("095", "Bạc Liêu");
		 CITY_CODES.put("096", "Cà Mau");        
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleAuthentication(scanner);
                    break;
                case 2:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (choice != 2);

        scanner.close();
    }


    private static void displayMainMenu() {
        System.out.println("Menu:");
        System.out.println("1. Enter Citizen Identification code");
        System.out.println("2. Exit");
        System.out.println("Please enter your choice: ");
    }


    private static void handleAuthentication(Scanner scanner) {
        int authenticationCode = generateRandomCode();
        int userCode;
        do {
            System.out.println("Enter the authentication code: " + authenticationCode);
            userCode = scanner.nextInt();

            if (userCode != authenticationCode) {
                System.out.println("Access is not accepted. Please try again.");
            }
        } while (userCode != authenticationCode);

        // Consume leftover newline
        scanner.nextLine();
        handleCitizenIdentification(scanner);
    }


    private static int generateRandomCode() {
        Random random = new Random();
        return 100 + random.nextInt(900);
    }


    private static void handleCitizenIdentification(Scanner scanner) {
        do {
            System.out.println("Please enter the Citizen Identification code:");
            String code = scanner.nextLine();

            if (isValidCitizenIdentificationCode(code)) {
                System.out.println("The Citizen Identification code is valid.");
                displayIdentificationFunctionsMenu(scanner, code);
                break;
            } else {
                System.out.println("The Citizen Identification code is invalid. Please type again or 'No' to exit:");
            }

            if (code.equals("No")) {
                System.out.println("Exiting the program.");
                break;
            }
           } while (true);
    }


    private static boolean isValidCitizenIdentificationCode(String citizenCode) {
        if (citizenCode.length() != 12) {
            return false;
        }
        for (char c : citizenCode.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    private static void displayIdentificationFunctionsMenu(Scanner scanner, String citizenCode) {
        int choice;
        do {
            System.out.println("Identification Functions:");
            System.out.println("1. Check place of birth");
            System.out.println("2. Check year of birth and gender");
            System.out.println("3. Check random numbers");
            System.out.println("0. Exit");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(getPlaceOfBirth(citizenCode));
                    break;
                case 2:
                    displayYearOfBirthAndGender(citizenCode);
                    break;
                case 3:
                    displayRandomNumbers(citizenCode);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (choice != 0);
    }


    public static String getPlaceOfBirth(String citizenCode) {        
        String birthCityCode = citizenCode.substring(0, 3);
        return CITY_CODES.getOrDefault(birthCityCode, "Unknown City");
    }


    private static void displayYearOfBirthAndGender(String citizenCode) {
        System.out.println("The citizen's gender is: " + getGender(citizenCode));
        System.out.println("The citizen's year of birth is: " + getYearOfBirth(citizenCode));
    }


    public static String getGender(String citizenId) {
        char genderCode = citizenId.charAt(3);
        switch (genderCode) {
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
                return "Male";
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
                return "Female";
            default:
                return "Unknown";
        }
    }


    public static int getYearOfBirth(String citizenId) {
        String yearOfBirthCode = citizenId.substring(4, 6);
        char centuryCode = citizenId.charAt(3);
        switch (centuryCode) {
            case '0':
            case '1':
                return 1900 + Integer.parseInt(yearOfBirthCode);
            case '2':
            case '3':
                return 2000 + Integer.parseInt(yearOfBirthCode);
            case '4':
            case '5':
                return 2100 + Integer.parseInt(yearOfBirthCode);
            case '6':
            case '7':
                return 2200 + Integer.parseInt(yearOfBirthCode);
            case '8':
            case '9':
                return 2300 + Integer.parseInt(yearOfBirthCode);
            default:
                return -1;
        }
    }


    private static void displayRandomNumbers(String citizenCode) {
        String randomNumbers = citizenCode.substring(6);
        System.out.println("Random Numbers: " + randomNumbers);
    }
}

