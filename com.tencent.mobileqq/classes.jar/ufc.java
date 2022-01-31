import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import java.util.Comparator;

public class ufc
  implements Comparator
{
  private ufc(TroopTransferActivity paramTroopTransferActivity) {}
  
  public int a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem1, TroopTransferActivity.TroopMemberItem paramTroopMemberItem2)
  {
    return paramTroopMemberItem1.f.compareToIgnoreCase(paramTroopMemberItem2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufc
 * JD-Core Version:    0.7.0.1
 */