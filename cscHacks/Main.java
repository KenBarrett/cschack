package cscHacks;

import java.util.ArrayList;

public class Main 
{
	private static int money = 10000;
	private static int stepsPerDay = 10;
	public int count= 0;
	public boolean dayIsOver= false;
	public int dayNumber= 0;
	private int ordersInDay= 10;
	public boolean customerSatisfied= false;
	ArrayList<Worker> employees = new ArrayList<Worker>();
	
	
	Station Dessert = new Station(0);
	Station Meat = new Station(2);
	Station Fish = new Station(1);
	Station Apps = new Station(3);
	Station Garnish = new Station(4);
	
	

	public Main()
	{
		Worker joe1 = new Worker();
		Worker bo1= new Worker();
		Worker HeadChef = new Worker("Head Chef");
		this.employees.add(joe1);
		employees.add(bo1);
		employees.add(HeadChef);
	}
	
	public void step()
	{
		if(dayIsOver)
		{
			dayNumber++;
			count =0;
		}
		
		for(int i = 0; i< employees.size(); i++)
		{
			
		}
		
		
	}
	
	
	

}
