import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import java.util.Comparator;

public class dxt
  implements Comparator
{
  private dxt(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public int a(TroopMemberListActivity.ATroopMember paramATroopMember1, TroopMemberListActivity.ATroopMember paramATroopMember2)
  {
    return paramATroopMember1.c.compareToIgnoreCase(paramATroopMember2.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxt
 * JD-Core Version:    0.7.0.1
 */