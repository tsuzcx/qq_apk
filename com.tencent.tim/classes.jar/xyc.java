import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class xyc
  implements View.OnClickListener
{
  xyc(xya paramxya) {}
  
  public void onClick(View paramView)
  {
    if (this.a.sessionInfo.aTl.equals(acbn.bkv)) {
      if (this.a.ad.booleanValue()) {
        this.a.finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("nickname", this.a.app.getCurrentNickname());
      ((Intent)localObject1).putExtra("bitmap", this.a.app.a(this.a.app.getCurrentAccountUin(), (byte)2, false));
      Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).getString("square_url_" + this.a.app.getCurrentAccountUin(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Intent)localObject1).putExtra("url", (String)localObject2);
      }
      for (;;)
      {
        awjb.a().a(this.a.a(), this.a.app, this.a.app.getAccount(), (Intent)localObject1, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
        break;
        ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
      }
      localObject1 = (syw)this.a.app.getBusinessHandler(51);
      localObject2 = ((syw)localObject1).a(Long.parseLong(this.a.sessionInfo.aTl));
      if (this.a.ad.booleanValue())
      {
        if (xya.a(this.a)) {
          ((syw)localObject1).a(this.a.mActivity, (DeviceInfo)localObject2, false);
        }
        this.a.finish();
      }
      else
      {
        ((syw)localObject1).a(this.a.mActivity, (DeviceInfo)localObject2, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyc
 * JD-Core Version:    0.7.0.1
 */