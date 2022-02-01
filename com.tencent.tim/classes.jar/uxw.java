import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxw
  implements View.OnClickListener
{
  public uxw(ForwardRecentActivity paramForwardRecentActivity, DeviceInfo paramDeviceInfo, ForwardRecentItemView paramForwardRecentItemView, ResultRecord paramResultRecord, Resources paramResources, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.a(this.this$0)) {
      if (ForwardRecentActivity.a(this.this$0, String.valueOf(this.b.din), 9501))
      {
        this.c.Du(false);
        ForwardRecentActivity.a(this.this$0, String.valueOf(this.b.din), 9501);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ForwardRecentActivity.a(this.this$0, this.a))
      {
        this.c.Du(true);
        continue;
        if (!aqiw.isNetworkAvailable(this.this$0))
        {
          QQToast.a(this.this$0, acfp.m(2131706485), 1000).show(this.val$resources.getDimensionPixelSize(2131299627));
        }
        else
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("uin", String.valueOf(this.b.din));
          localBundle.putInt("uintype", 9501);
          localBundle.putString("uinname", this.aNb);
          this.this$0.a.H(ahgg.a.aa.intValue(), localBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxw
 * JD-Core Version:    0.7.0.1
 */