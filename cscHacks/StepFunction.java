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
	public int DessertWork = ordersInDay;
	public int workRequired=ordersInDay*5;
	public int workForce=0;
	
	
	ArrayList<Station> Stations= new ArrayList<Station>();
	
	Station Dessert = new Station(0);
	Station Meat = new Station(2);
	Station Fish = new Station(1);
	Station Apps = new Station(3);
	Station Garnish = new Station(4);
	
	

	public StepFunction()
	{
		Worker joe1 = new Worker();
		Worker bo1= new Worker();
		Worker HeadChef = new Worker(1);
		this.employees.add(joe1);
		employees.add(bo1);
		employees.add(HeadChef);
		
		for(Worker i : employees)
		{
			workForce +=i.AppsSpeed;
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
			if(workRequired)
			dayNumber++;
			count =0;
		}
		
		int joe = workRequired-workForce;
		if(workRequired <=0)
		{
			workRequired = 0;
			dayIsOver = true;
		}
		
		
		
		
	}
	
	
	

}
