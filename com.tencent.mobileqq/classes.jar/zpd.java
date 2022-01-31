import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.os.MqqHandler;

class zpd
  extends BroadcastReceiver
{
  zpd(zpa paramzpa) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getAction().equalsIgnoreCase("SmartDevice_devListChang")) || (paramIntent.getAction().equalsIgnoreCase("onDeviceDisconnected")) || (paramIntent.getAction().equalsIgnoreCase("onDeviceLogined")))
    {
      zpa.a(this.a).sendEmptyMessage(1003);
      new aabb().a();
      this.a.b = 2;
    }
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_devListChangeUI")) {
                break;
              }
              paramContext = this.a.a();
              zpa.a(this.a, "DeviceList @@ cache receivechange for ui list:" + paramContext);
            } while (paramContext == null);
            this.a.notifyUI(1, true, new ArrayList(Arrays.asList(paramContext)));
            return;
            if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_login"))
            {
              i = paramIntent.getExtras().getInt("logincode");
              zpa.a(this.a, "SmartDeviceProxyMgr::receive qq login broadcast!!!resultCode = " + i);
              SettingCloneUtil.writeValue(this.a.app.getApp(), this.a.app.getCurrentAccountUin(), null, "account_login_success_time", String.valueOf(ayvc.a()));
              if (i == 0)
              {
                this.a.jdField_a_of_type_Int = 2;
                return;
              }
              this.a.jdField_a_of_type_Int = 3;
              return;
            }
            if ((paramIntent.getAction().equalsIgnoreCase("mqq.intent.action.LOGOUT")) || (paramIntent.getAction().equalsIgnoreCase("mqq.intent.action.ACCOUNT_CHANGED")))
            {
              if (this.a.a())
              {
                zpa.a(this.a, "SmartDeviceProxyMgr::receive qq logout broadcast!!!");
                this.a.d();
              }
              aabb.c();
              return;
            }
            if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_clickOnDeviceList"))
            {
              if (this.a.a())
              {
                this.a.b(false);
                this.a.e();
              }
              aabm.a(null, "Usr_Click_MyDevice", 0, 0, 0);
              return;
            }
            if (!paramIntent.getAction().equalsIgnoreCase("onQFindLostDeviceList")) {
              break;
            }
          } while (paramIntent.getExtras().getInt("qfind_result", 1) != 0);
          this.a.jdField_a_of_type_JavaUtilArrayList.clear();
          paramContext = paramIntent.getExtras().getLongArray("qfind_dins");
          int j = paramContext.length;
          while (i < j)
          {
            l = paramContext[i];
            this.a.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
            i += 1;
          }
          paramContext = this.a.a();
        } while (paramContext == null);
        this.a.notifyUI(1, true, new ArrayList(Arrays.asList(paramContext)));
        return;
      } while ((paramIntent.getAction().equals("SmartDevice_receiveDPMsg")) || (!paramIntent.getAction().equals("SmartDevice_DeviceBindRst")) || (paramIntent.getExtras().getInt("deviceoprstcode") != 0));
      zpa.a(this.a, 1);
      SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.a.app.getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", zpa.a(this.a));
      l = paramIntent.getExtras().getLong("deviceopdin", 0L);
      paramContext = this.a.a(l);
    } while ((paramContext == null) || (paramContext.productId < 2000000000L) || (paramContext.productId >= 3000000000L));
    this.a.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zpd
 * JD-Core Version:    0.7.0.1
 */