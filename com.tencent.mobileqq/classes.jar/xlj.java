import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import java.util.List;

public final class xlj
  implements Runnable
{
  public xlj(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    List localList = TroopBarAssistantManager.a().a(this.a);
    int i;
    int j;
    label19:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localObject = (TroopBarData)localList.get(j);
      if (localObject != null) {
        break label58;
      }
    }
    for (;;)
    {
      j += 1;
      break label19;
      i = localList.size();
      break;
      label58:
      localObject = this.a.a().a(((TroopBarData)localObject).mUin, 1008);
      if (localObject != null) {
        TroopBarAssistantManager.a().a(this.a, ((QQMessageFacade.Message)localObject).time);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlj
 * JD-Core Version:    0.7.0.1
 */