package cschacksClasses;

public class Station 
{
	private int WORKLOAD= 50; 
    public static final int Dessert = 0, Fish = 1, Meat = 2, Apps= 3, Garnish = 4;
    private int type;
    
    public Station(int type, int Workload)
    {
        this.type = type;
        this.WORKLOAD= Workload;
    	
    }

}
