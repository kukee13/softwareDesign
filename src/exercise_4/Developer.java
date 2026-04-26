package exercise_4;

public class Developer {
    private String name;
    private int experienceYears;
    private String programmingLanguage;
    private double hourlyRate;
    private boolean isAvailable;

    // constructor
    public Developer(String name, int experienceYears, String programmingLanguage, double hourlyRate, boolean isAvailable) {
        setName(name);
        setExperienceYears(experienceYears);
        setProgrammingLanguage(programmingLanguage);
        setHourlyRate(hourlyRate);
        this.isAvailable = isAvailable;
    }

    // setters with Integrity checks
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public void setExperienceYears(int years) {
        if (years >= 0) {
            this.experienceYears = years;
        } else {
            throw new IllegalArgumentException("Experience cannot be negative.");
        }
    }

    public void setProgrammingLanguage(String lang) {
        if (lang != null) this.programmingLanguage = lang;
    }

    public void setHourlyRate(double rate) {
        if (rate > 0) {
            this.hourlyRate = rate;
        } else {
            throw new IllegalArgumentException("Rate must be positive.");
        }
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // 5 Methods
    public void code() {
        System.out.println(name + " is coding...");
    }
    public void debug() {
        System.out.println("Fixing bugs...");
    }
    public void attendMeeting() {
        System.out.println("In a Scrum meeting.");
    }
    public void drinkCoffee() {
        System.out.println("Refueling...");
    }
    public String getInfo() {
        return name + " (" + experienceYears + " yrs xp)";
    }
}