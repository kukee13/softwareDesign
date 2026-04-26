package exercise_4;

public class DeveloperRunner {
    public static void main(String[] args) {
        System.out.println("--Developer Main class--");
        
        try {
            // creating a developer instance
            Developer dev = new Developer("Kartik", 5, "Java", 50.0, true);
            
            // testing methods
            System.out.println("Info: " + dev.getInfo());
            dev.code();
            dev.debug();
            dev.attendMeeting();
            dev.drinkCoffee();
            
            System.out.println("\n- Integrity Check Test -");
            try {
                dev.setHourlyRate(-10);
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected error: " + e.getMessage());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
