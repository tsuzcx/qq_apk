package com.tencent.mobileqq.activity;

import aciu;
import acny;
import altq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.MobileQQ;

class QQSettingMe$13
  implements Runnable
{
  QQSettingMe$13(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    Object localObject = (altq)this.this$0.app.getManager(36);
    this.this$0.d = ((altq)localObject).getAppInfoByPath(String.valueOf(100190));
    int i = ((altq)localObject).aH(100007, 100);
    SharedPreferences localSharedPreferences;
    if (i > 0)
    {
      this.this$0.e = ((altq)localObject).a(1, 100007, "100007", i, false);
      this.this$0.f = ((altq)localObject).getAppInfoByPath(String.valueOf(100005));
      localSharedPreferences = this.this$0.app.getApplication().getSharedPreferences(this.this$0.app.getCurrentAccountUin(), 0);
      if ((this.this$0.f == null) || (this.this$0.f.iNewFlag.get() != 1)) {
        break label403;
      }
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", true).commit();
    }
    for (;;)
    {
      this.this$0.g = ((altq)localObject).getAppInfoByPath(String.valueOf(100400));
      this.this$0.h = ((altq)localObject).getAppInfoByPath(String.valueOf(100160));
      this.this$0.i = ((altq)localObject).getAppInfoByPath(String.valueOf(100450));
      this.this$0.j = ((altq)localObject).getAppInfoByPath(String.valueOf(100180));
      this.this$0.k = ((altq)localObject).getAppInfoByPath(String.valueOf(103000));
      this.this$0.m = ((altq)localObject).getAppInfoByPath(String.valueOf(100460));
      this.this$0.n = ((altq)localObject).getAppInfoByPath(String.valueOf("200010.200012"));
      this.this$0.o = ((altq)localObject).getAppInfoByPath(String.valueOf(100500));
      this.this$0.p = ((altq)localObject).getAppInfoByPath(String.valueOf(100066));
      this.this$0.q = ((altq)localObject).a(1, String.valueOf(100077));
      acny.a(this.this$0.app.getCurrentUin());
      QQSettingMe.b(this.this$0);
      QQSettingMe.d(this.this$0);
      aciu.cKZ();
      QQSettingMe.b(this.this$0);
      this.this$0.preloadWebProcess();
      localObject = this.this$0.bO.obtainMessage(0);
      this.this$0.bO.sendMessage((Message)localObject);
      return;
      this.this$0.e = ((altq)localObject).getAppInfoByPath(String.valueOf(100007));
      break;
      label403:
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.13
 * JD-Core Version:    0.7.0.1
 */