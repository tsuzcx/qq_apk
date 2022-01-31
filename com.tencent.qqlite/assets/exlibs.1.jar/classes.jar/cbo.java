import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class cbo
  implements Runnable
{
  public cbo(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)TroopChatPie.m(this.a).getManager(33);
    if (localTroopInfoManager != null) {
      localTroopInfoManager.a(Long.valueOf(Long.parseLong(this.a.a.a)), true).a();
    }
    TroopNotificationHelper.a(TroopChatPie.n(this.a), this.a.a.a);
    TroopChatPie.g(this.a).sendEmptyMessage(29);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbo
 * JD-Core Version:    0.7.0.1
 */