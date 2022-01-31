import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class bxv
  implements View.OnClickListener
{
  public bxv(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    ChatActivity.a(this.a).a();
    ChatActivityUtils.a(this.a.b, this.a, this.a.a.a, true, true, null);
    ReportController.b(this.a.b, "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxv
 * JD-Core Version:    0.7.0.1
 */