import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopNewcomerNoticeActivity;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class bzv
  implements Runnable
{
  public bzv(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopNotificationHelper.e(TroopChatPie.K(this.a).a);
    Intent localIntent = new Intent(TroopChatPie.f(this.a), TroopNewcomerNoticeActivity.class);
    localIntent.putExtra("troop_friend_uin", TroopChatPie.L(this.a).a);
    TroopChatPie.g(this.a).overridePendingTransition(2130968652, 2130968653);
    TroopChatPie.h(this.a).startActivity(localIntent);
    ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, TroopChatPie.M(this.a).a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzv
 * JD-Core Version:    0.7.0.1
 */