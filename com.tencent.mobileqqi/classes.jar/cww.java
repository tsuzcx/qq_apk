import com.tencent.mobileqq.activity.MySelfTroopMemberCard;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import java.util.ArrayList;

public class cww
  extends TroopObserver
{
  public cww(MySelfTroopMemberCard paramMySelfTroopMemberCard) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null)) {
      return;
    }
    int i = 0;
    label11:
    TroopMemberCardInfo localTroopMemberCardInfo;
    if (i < paramArrayList.size())
    {
      localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
      if ((localTroopMemberCardInfo != null) && (localTroopMemberCardInfo.memberuin != null)) {
        break label49;
      }
    }
    label49:
    while (!localTroopMemberCardInfo.memberuin.equals(this.a.b.a()))
    {
      i += 1;
      break label11;
      break;
    }
    this.a.a(localTroopMemberCardInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cww
 * JD-Core Version:    0.7.0.1
 */