import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import java.util.Comparator;

public class bqp
  implements Comparator
{
  private bqp(TroopTransferActivity paramTroopTransferActivity) {}
  
  public int a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem1, TroopTransferActivity.TroopMemberItem paramTroopMemberItem2)
  {
    return paramTroopMemberItem1.f.compareToIgnoreCase(paramTroopMemberItem2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bqp
 * JD-Core Version:    0.7.0.1
 */