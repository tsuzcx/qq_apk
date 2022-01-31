import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import java.util.Comparator;

public class dto
  implements Comparator
{
  private dto(TroopTransferActivity paramTroopTransferActivity) {}
  
  public int a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem1, TroopTransferActivity.TroopMemberItem paramTroopMemberItem2)
  {
    return paramTroopMemberItem1.f.compareToIgnoreCase(paramTroopMemberItem2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dto
 * JD-Core Version:    0.7.0.1
 */