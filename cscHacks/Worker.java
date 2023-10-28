package cscHacks;

public class Worker 
{
    private int DessertSpeed = 4;
    private int MeatSpeed = 4;
    private int FishSpeed = 4;
    private int AppsSpeed = 4;
    private int GarnishSpeed = 4;
    private boolean isHeadChef = false;

<<<<<<< HEAD

    public Worker(){
=======
    public Worker()
    {
    	
    }
>>>>>>> 398a8a47eb8cd20bd7bbfc65ac1809aafc5e2256

    }
    public Worker(int joe)
    {
        if(joe==1)
        {
            this.DessertSpeed=8;
            this.MeatSpeed=8;
            this.FishSpeed=8;
            this.AppsSpeed=8;
            this.GarnishSpeed=8;
            this.isHeadChef= true;

        }
    }
    public int getDessertSpeed() {
        return DessertSpeed;
    }

    public int getMeatSpeed() {
        return MeatSpeed;
    }

    public int getFishSpeed() {
        return FishSpeed;
    }

    public int getAppsSpeed() {
        return AppsSpeed;
    }

    public int getGarnishSpeed() {
        return GarnishSpeed;
    }

    public boolean isHeadChef() {
        return isHeadChef;
    }

    // Setter methods
    public void setDessertSpeed(int dessertSpeed) {
        this.DessertSpeed = dessertSpeed;
    }

    public void setMeatSpeed(int meatSpeed) {
        this.MeatSpeed = meatSpeed;
    }

    public void setFishSpeed(int fishSpeed) {
        this.FishSpeed = fishSpeed;
    }

    public void setAppsSpeed(int appsSpeed) {
        this.AppsSpeed = appsSpeed;
    }

    public void setGarnishSpeed(int garnishSpeed) {
        this.GarnishSpeed = garnishSpeed;
    }

    public void setHeadChef(boolean isHeadChef) {
        this.isHeadChef = isHeadChef;
    }
    

}
