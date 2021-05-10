import java.util.ArrayList;

public class ClubMembers
{

    // read 2 minutes
    private ArrayList<MemberInfo> memberList;

    /** Adds new club members to memberList, as described in part (a). 
     *  Precondition: names is a non-empty array.
     */
    public void addMembers(String[] names, int gradYear)
    {
        // 1 minute
        for(String name : names)
        {
            memberList.add(new MemberInfo(name, gradYear, true));
        }
    }

    /** Removes members who have graduated and returns a list of 
     *  members who have graduated and are in good standing, 
     *  as described in part (b).
     */
    public ArrayList<MemberInfo> removeMembers(int year)
    {
        // 7 minutes
        ArrayList<MemberInfo> ret = new ArrayList<MemberInfo>();
        
        for(int i = memberList.size()-1; i >= 0; i--)
        {
            if(memberList.get(i).getGradYear() <= year)
            {
                MemberInfo mi = memberList.remove(i);
                if(mi.inGoodStanding())
                    ret.add(mi);
            }    
        }

        return ret;
    }

    public static void main(String[] args) {
        ClubMembers cma = new ClubMembers();
        cma.memberList = new ArrayList<MemberInfo>();
        cma.addMembers(new String[] {"One", "Two", "Three"}, 2001);
        System.out.println("One, Two, and Three, 2001, true:\n" +
                           cma.memberList);
        
        ClubMembers cmb = new ClubMembers();
        cmb.memberList = new ArrayList<MemberInfo>();
        cmb.memberList.add(new MemberInfo("SMITH,JANE", 2019, false));
        cmb.memberList.add(new MemberInfo("FOX,STEVE", 2018, true));
        cmb.memberList.add(new MemberInfo("XIN,MICHAEL", 2017, false));
        cmb.memberList.add(new MemberInfo("GARCIA,MARIA", 2020, true));

        ArrayList<MemberInfo> gradGood = cmb.removeMembers(2018);

        System.out.println("Only SMITH and GARCIA should be left:\n" +
                           cmb.memberList);
        System.out.println("Only FOX should be in returned list:\n" +
                           gradGood);
    }

}
