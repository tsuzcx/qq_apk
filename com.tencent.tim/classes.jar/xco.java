import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class xco
  implements ahav.d
{
  xco(xci paramxci) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("uin", this.this$0.sessionInfo.aTl);
    paramView.putExtra("uinname", this.this$0.sessionInfo.aTn);
    awjb.a().a((Activity)this.this$0.mContext, this.this$0.app, this.this$0.app.getAccount(), paramView, "com.tencent.device.activities.DeviceGroupChatConfirmActivity", -1, null, SmartDevicePluginProxyActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xco
 * JD-Core Version:    0.7.0.1
 */