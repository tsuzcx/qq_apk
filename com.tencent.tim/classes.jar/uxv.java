import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxv
  implements View.OnClickListener
{
  public uxv(ForwardRecentActivity paramForwardRecentActivity, ResultRecord paramResultRecord) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.this$0)) {
      if (ForwardRecentActivity.a(this.this$0, acbn.bkx, 6003))
      {
        ForwardRecentActivity.b(this.this$0).Du(false);
        ForwardRecentActivity.a(this.this$0, acbn.bkx, 6003);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ForwardRecentActivity.a(this.this$0, this.a))
      {
        ForwardRecentActivity.b(this.this$0).Du(true);
        continue;
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", acbn.bkx);
        localBundle.putInt("uintype", -1);
        localBundle.putString("caller_name", this.this$0.aNa);
        this.this$0.a.H(ahgg.a.ab.intValue(), localBundle);
        anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X8009D90", ForwardRecentActivity.a(this.this$0), 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxv
 * JD-Core Version:    0.7.0.1
 */