import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopNewcomerNoticeActivity;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class ccv
  implements Runnable
{
  public ccv(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    TroopNotificationHelper.e(this.a.a.a);
    Intent localIntent = new Intent(this.a, TroopNewcomerNoticeActivity.class);
    localIntent.putExtra("troop_friend_uin", this.a.a.a);
    this.a.overridePendingTransition(2130968695, 2130968696);
    this.a.startActivity(localIntent);
    ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.a.a.a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ccv
 * JD-Core Version:    0.7.0.1
 */