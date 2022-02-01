import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class xcp
  implements ahav.d
{
  xcp(xci paramxci) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("device_info", ((syw)this.this$0.app.getBusinessHandler(51)).a(Long.parseLong(this.this$0.sessionInfo.aTl)));
    awjb.a().a((Activity)this.this$0.mContext, this.this$0.app, this.this$0.app.getAccount(), paramView, "com.tencent.device.activities.DeviceUnBindActivity", -1, null, SmartDevicePluginProxyActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcp
 * JD-Core Version:    0.7.0.1
 */