public class Worker {
    // Member variables
    private String name;
    private int age;
    private String jobTitle;
    private double hourlyWage;

    // Constructor
    public Worker(String name, int age, String jobTitle, double hourlyWage) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.hourlyWage = hourlyWage;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    // Method to calculate weekly earnings (assuming a 40-hour workweek)
    public double calculateWeeklyEarnings() {
        return hourlyWage * 40.0;
    }

    // Method to display worker information
    public void displayWorkerInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Hourly Wage: $" + hourlyWage);
        System.out.println("Weekly Earnings: $" + calculateWeeklyEarnings());
    }

    public static void main(String[] args) {
        // Example usage of the Worker class
        Worker worker = new Worker("John Doe", 30, "Software Developer", 25.0);
        worker.displayWorkerInfo();
    }
}