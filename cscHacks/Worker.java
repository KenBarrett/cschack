package cscHacks;

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
	
}
