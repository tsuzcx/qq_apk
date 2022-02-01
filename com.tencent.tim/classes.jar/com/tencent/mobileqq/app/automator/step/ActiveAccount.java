package com.tencent.mobileqq.app.automator.step;

import acbn;
import aglz;
import anaz;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anxk;
import aqhq;
import ardq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jof;
import yxe;

public class ActiveAccount
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.app.getAccount());
    }
    this.a.Ra = System.currentTimeMillis();
    this.a.O = this.a.app.getApp().getSharedPreferences("acc_info" + this.a.app.getAccount(), 0);
    localObject = this.a.app;
    ThemeUtil.initTheme((QQAppInterface)localObject);
    try
    {
      ((QQAppInterface)localObject).G(true, this.a.O.getLong("PREF_PLUGIN_DELAY_TIME", -1L));
      bool = false;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        boolean bool;
        ((QQAppInterface)localObject).Fy(true);
        try
        {
          this.a.O.edit().putLong("PREF_PLUGIN_DELAY_TIME", 0L).apply();
          bool = true;
        }
        catch (Throwable localThrowable2)
        {
          bool = true;
        }
      }
    }
    anxk.ed((QQAppInterface)localObject);
    ((QQAppInterface)localObject).initFaceSettingCache();
    aglz.a().onActiveAccount();
    UnifiedMonitor.a().onActiveAccount();
    OpenApiManager.getInstance().onRuntimeActive((QQAppInterface)localObject);
    if (yxe.ik(((QQAppInterface)localObject).getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      ((QQAppInterface)localObject).a().aN("last_group_seq", 0L);
      ((QQAppInterface)localObject).a().aN("last_group_suspicious_seq", 0L);
      yxe.bg(((QQAppInterface)localObject).getCurrentAccountUin(), false);
      ((QQAppInterface)localObject).a().aN("last_friend_seq_47", 0L);
    }
    if (jof.a != null) {
      jof.a().clear();
    }
    if ((((QQAppInterface)localObject).getBusinessHandler(107) instanceof ardq)) {
      ((ardq)((QQAppInterface)localObject).getBusinessHandler(107)).clear();
    }
    localObject = new File(acbn.SDCARD_PATH);
    if (!aqhq.fileExists(acbn.SDCARD_PATH)) {
      ((File)localObject).mkdirs();
    }
    CleanCache.FO(acbn.SDCARD_PATH);
    QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(this.a.O.getLong("PREF_PLUGIN_DELAY_TIME", -1L)), " hasCrashInAddManager=", Boolean.valueOf(bool) });
    return 7;
  }
  
  public void onCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */