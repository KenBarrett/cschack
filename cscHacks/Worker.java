package cscHacks;
<<<<<<< HEAD
public class Worker{
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
=======

public class Worker 
{
	public int DessertSpeed = 4;
	public int MeatSpeed = 4;
	public int FishSpeed = 4;
	public int AppsSpeed = 4;
	public int GarnishSpeed = 4;
	public boolean isHeadChef = false;
	
	
	public Worker() 
	{
		
	}
	public Worker(int joe)
	{
		if(joe==1)
		{
			this.DessertSpeed=8;
			this.MeatSpeed=8;
			this.FishSpeed=8;
			this.AppsSpeed =8;
			this.GarnishSpeed=8;
			this.isHeadChef= true;

		}
	}
	
>>>>>>> bf149a2c7cc28de65aeb789a49b1cd1cb4904012
}
