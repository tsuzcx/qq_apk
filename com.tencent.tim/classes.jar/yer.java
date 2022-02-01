import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yer
  implements jrp.a
{
  public yer(TroopChatPie paramTroopChatPie) {}
  
  public void onFailed()
  {
    if ((ChatActivityUtils.a(this.this$0.sessionInfo.aTl, this.this$0.app.getCurrentAccountUin()) != null) || (QLog.isColorLevel())) {
      QLog.d(".troop.notify_feeds.aio", 2, "getAppIds onFailed, reqNotifyItems");
    }
    apro.aV(this.this$0.app, this.this$0.sessionInfo.aTl);
  }
  
  public void onSuccess(ArrayList<TroopAppInfo> paramArrayList)
  {
    if (ChatActivityUtils.a(this.this$0.sessionInfo.aTl, this.this$0.app.getCurrentAccountUin()) != null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1L));
      localArrayList.add(Long.valueOf(2L));
      localArrayList.add(Long.valueOf(1101236949L));
      localArrayList.add(Long.valueOf(1101484419L));
      localArrayList.add(Long.valueOf(1102858908L));
      localArrayList.add(Long.valueOf(1106611799L));
      localArrayList.add(Long.valueOf(1104445552L));
      localArrayList.add(Long.valueOf(1106717414L));
      localArrayList.add(Long.valueOf(101509131L));
      localArrayList.add(Long.valueOf(1106588005L));
      localArrayList.add(Long.valueOf(1106664488L));
      localArrayList.add(Long.valueOf(101618516L));
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(Long.valueOf(((TroopAppInfo)paramArrayList.next()).appId));
        }
      }
      paramArrayList = (acms)this.this$0.app.getBusinessHandler(20);
    } while (paramArrayList == null);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "send_oidb_0x8c9_2, appIds.size=" + localArrayList.size());
    }
    paramArrayList.d(this.this$0.sessionInfo.aTl, localArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yer
 * JD-Core Version:    0.7.0.1
 */