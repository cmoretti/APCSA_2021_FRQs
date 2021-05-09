public class CombinedTable {

    // read 4 minutes

    // IV + constructor: 2 minutes
    private SingleTable t1;
    private SingleTable t2;
    
    public CombinedTable(SingleTable one, SingleTable two) {
        t1 = one;
        t2 = two;
    }

    public boolean canSeat(int count) {
        // 1 minute
        return count <= t1.getNumSeats() + t2.getNumSeats() - 2;
    }

    public double getDesirability() {
        // 3 minutes
        if(t1.getHeight() == t2.getHeight())
            return (t1.getViewQuality() + t2.getViewQuality()) / 2;
        else
            return ((t1.getViewQuality() + t2.getViewQuality()) / 2) - 10;
    }
    
}
