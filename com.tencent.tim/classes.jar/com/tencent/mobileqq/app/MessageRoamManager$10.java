package com.tencent.mobileqq.app;

import achs;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class MessageRoamManager$10
  implements Runnable
{
  public MessageRoamManager$10(achs paramachs) {}
  
  public void run()
  {
    Object localObject = new File(this.this$0.app.getApp().getFilesDir(), "https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json");
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkBlueBanner local file exists: " + ((File)localObject).exists());
    }
    SharedPreferences localSharedPreferences;
    String str1;
    if (((File)localObject).exists())
    {
      localSharedPreferences = this.this$0.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      str1 = this.this$0.app.getCurrentAccountUin();
      int i = localSharedPreferences.getInt("message_roam_is_first_show" + str1, 0);
      bool = this.this$0.aaX();
      long l1 = localSharedPreferences.getLong("banner_last_show_timestamp" + str1, 0L);
      long l2 = localSharedPreferences.getInt("blue_banner_show_internal", 24);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      long l4 = localSharedPreferences.getInt("blue_banner_show_time", 0);
      if (((!bool) && ((l3 - l1 > l2 * 3600000L) || (l3 < l1))) || ((i == 0) && (l4 * 1000L != 0L)))
      {
        if (!VipUtils.ce(this.this$0.app)) {
          break label426;
        }
        localObject = localSharedPreferences.getString("blue_banner_svip_text", null);
        if (i == 0) {}
        String str2 = localSharedPreferences.getString("blue_banner_go_url", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("showText", (String)localObject);
          localBundle.putString("goUrl", str2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkBlueBanner showText: " + (String)localObject + ", goUrl: " + str2);
          }
          this.this$0.z(14, localBundle);
          if (i != 0) {
            break label469;
          }
          localSharedPreferences.edit().putInt("message_roam_is_first_show" + str1, 1).commit();
        }
      }
    }
    label415:
    for (boolean bool = false;; bool = true)
    {
      this.this$0.Fu(bool);
      return;
      label426:
      if (VipUtils.cf(this.this$0.app))
      {
        localObject = localSharedPreferences.getString("blue_banner_vip_text", null);
        break;
      }
      localObject = localSharedPreferences.getString("blue_banner_notvip_text", null);
      break;
      label469:
      localSharedPreferences.edit().putLong("banner_last_show_timestamp" + str1, NetConnInfoCenter.getServerTimeMillis()).commit();
      break label415;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.10
 * JD-Core Version:    0.7.0.1
 */