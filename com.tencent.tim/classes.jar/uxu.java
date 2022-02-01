import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxu
  implements View.OnClickListener
{
  public uxu(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.this$0)) {
      if (ForwardRecentActivity.a(this.this$0, acbn.bkw, 6000))
      {
        ForwardRecentActivity.a(this.this$0).Du(false);
        ForwardRecentActivity.a(this.this$0, acbn.bkw, 6000);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ForwardRecentActivity.a(this.this$0, this.a))
      {
        ForwardRecentActivity.a(this.this$0).Du(true);
        continue;
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", String.valueOf(acbn.bkw));
        localBundle.putInt("uintype", -1);
        localBundle.putBoolean("forward_report_confirm", true);
        localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
        localBundle.putString("forward_report_confirm_reverse2", "0");
        localBundle.putString("caller_name", this.this$0.aNa);
        this.this$0.a.H(ahgg.a.W.intValue(), localBundle);
        this.this$0.a.dnX();
        anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
        if (this.this$0.isSdkShare) {
          arts.a().a(this.this$0.app.getAccount(), "", this.this$0.appid, "1000", "34", "0", false, this.this$0.isSdkShare);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxu
 * JD-Core Version:    0.7.0.1
 */