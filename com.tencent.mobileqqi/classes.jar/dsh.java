import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import java.util.Comparator;

public class dsh
  implements Comparator
{
  private dsh(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public int a(TroopMemberListActivity.ATroopMember paramATroopMember1, TroopMemberListActivity.ATroopMember paramATroopMember2)
  {
    return paramATroopMember1.f.compareToIgnoreCase(paramATroopMember2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsh
 * JD-Core Version:    0.7.0.1
 */