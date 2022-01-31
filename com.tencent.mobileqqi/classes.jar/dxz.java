import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import java.util.Comparator;

public class dxz
  implements Comparator
{
  private dxz(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public int a(TroopMemberListActivity.ATroopMember paramATroopMember1, TroopMemberListActivity.ATroopMember paramATroopMember2)
  {
    return paramATroopMember1.f.compareToIgnoreCase(paramATroopMember2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxz
 * JD-Core Version:    0.7.0.1
 */