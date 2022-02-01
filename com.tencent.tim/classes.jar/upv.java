import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;

public class upv
  implements jrp.a
{
  public upv(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onFailed() {}
  
  public void onSuccess(ArrayList<TroopAppInfo> paramArrayList)
  {
    if ((this.this$0.isFinishing()) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      ajdr localajdr = (ajdr)this.this$0.app.getManager(37);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopAppInfo localTroopAppInfo = (TroopAppInfo)paramArrayList.next();
        localajdr.a(Long.valueOf(localTroopAppInfo.appId), localTroopAppInfo);
        localArrayList.add(Long.valueOf(localTroopAppInfo.appId));
      }
      localajdr.x(this.this$0.a.troopUin, localArrayList);
    } while (this.this$0.aUu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upv
 * JD-Core Version:    0.7.0.1
 */