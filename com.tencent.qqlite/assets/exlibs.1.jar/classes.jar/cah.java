import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class cah
  implements Runnable
{
  public cah(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)TroopChatPie.l(this.a).getManager(33);
    if (localTroopInfoManager != null) {
      localTroopInfoManager.a(Long.valueOf(Long.parseLong(TroopChatPie.I(this.a).a)), true).a();
    }
    TroopNotificationHelper.a(TroopChatPie.m(this.a), TroopChatPie.J(this.a).a);
    TroopChatPie.e(this.a).sendEmptyMessage(29);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cah
 * JD-Core Version:    0.7.0.1
 */