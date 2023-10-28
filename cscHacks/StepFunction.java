package cscHacks;

import java.util.ArrayList;

public class StepFunction 
{
	private static int money = 10000;
	private static int stepsPerDay = 10;
	public int count= 0;
	public boolean dayIsOver= false;
	public int dayNumber= 0;
	private int ordersInDay= 10;
	public boolean customerSatisfied= false;
	ArrayList<Worker> employees = new ArrayList<Worker>();
	private int employeesPay=0;
	public int DessertWork = ordersInDay;
	public int workRequired= 5;// work per hour needed
	public int totalWorkLeft = 0;//work remaining
	public int workForce=0;
	
	
	ArrayList<Station> Stations= new ArrayList<Station>();
	
	Station Dessert = new Station(0);
	Station Meat = new Station(2);
	Station Fish = new Station(1);
	Station Apps = new Station(3);
	Station Garnish = new Station(4);
	
	public void addWorker(Worker joeb)
    {
    	employees.add(joeb);
    }

	public StepFunction()
	{
		Worker joe1 = new Worker();
		Worker bo1= new Worker();
		Worker HeadChef = new Worker(1);
		this.addWorker(joe1);
		this.addWorker(bo1);
		this.addWorker(HeadChef);
		
		for(Worker i : employees)
		{
			workForce +=i.getAppsSpeed();
			employeesPay+=i.getPay();
		}
		
		Stations.add(Dessert);
		Stations.add(Meat);
		Stations.add(Fish);
		Stations.add(Apps);
		Stations.add(Garnish);
		
		
		
	}
	
	public void step()
	{
		if(dayIsOver)
		{
			
			dayNumber++;
			money-= employeesPay;
			if(customerSatisfied)
			{
				money+=workRequired*100;
				workRequired+=1;
			}
			else
			{
				money+=workRequired*30;
			}
			count =0;
		}
		while(count<stepsPerDay-1)
		{
		
		
		int joe = workRequired-workForce;
		if(joe <=0)
		{
			
			return;
		}
		else if(joe>0)
		{
			totalWorkLeft +=joe;
		}
		
		}
		if(count==stepsPerDay-1)
		{
			totalWorkLeft-=workForce;
			if(totalWorkLeft<=workRequired)
			{
				customerSatisfied =true;
			}
			else
			{
				customerSatisfied = false;
				
			}
				
		}
		count++;
		
	}
	
	
	

}
