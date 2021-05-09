public class SingleTable
{

    private int seats;
    private int height;
    private double quality;
    
    public SingleTable(int s, int h, double q) {
        seats = s;
        height = h;
        quality = q;
    }

    /** Returns the number of seats at this table.
        The value is always greater than or equal to 4. */
    public int getNumSeats()
    {
        return seats;
    }

    public int getHeight()
    {
        return height;
    }

    public double getViewQuality()
    {
        return quality;
    }

    public void setViewQuality(double value)
    {
        quality = value;
    }

    public static void main(String[] args) {
        SingleTable t1 = new SingleTable(4,74,60.0);
        SingleTable t2 = new SingleTable(8,74,70.0);
        SingleTable t3 = new SingleTable(12,76,75.0);

        CombinedTable c1 = new CombinedTable(t1, t2);
        System.out.println("c1.canSeat(9) should be true: " +
                           c1.canSeat(9));
        System.out.println("c1.canSeat(11) should be false: " +
                           c1.canSeat(11));
        System.out.println("c1.getDesirability() should be 65.0: " +
                           c1.getDesirability());
        CombinedTable c2 = new CombinedTable(t2, t3);
        System.out.println("c2.canSeat(18) should be true: " +
                           c2.canSeat(18));
        System.out.println("c2.getDesirability() should be 62.5: " +
                           c2.getDesirability());
        t2.setViewQuality(80);
        System.out.println("c2.getDesirability() should be 67.5: " +
                           c2.getDesirability());
        
    }
}
