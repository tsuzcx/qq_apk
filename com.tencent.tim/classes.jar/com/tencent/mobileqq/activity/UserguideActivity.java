package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import anpc;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UserguideActivity
  extends FragmentActivity
{
  private static boolean bbS;
  public static boolean bbT;
  public static boolean bbU;
  boolean isDestroyed = false;
  
  public static boolean L(Context paramContext, String paramString)
  {
    return bbT;
  }
  
  public static boolean a(SplashActivity paramSplashActivity)
  {
    if ((AppSetting.enableTalkBack) || (Build.VERSION.SDK_INT < 14) || (bbS))
    {
      if (QLog.isColorLevel()) {
        QLog.i("UserGuide", 2, String.format("showUserGuide [%s, %s, %s]", new Object[] { Boolean.valueOf(AppSetting.enableTalkBack), Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(bbS) }));
      }
      return false;
    }
    bbS = true;
    boolean bool2 = false;
    try
    {
      bool1 = paramSplashActivity.getIntent().getBooleanExtra("k_from_login", false);
      if (QLog.isColorLevel()) {
        QLog.i("UserGuide", 2, String.format("showUserGuide noNeedShowGuide[%s]", new Object[] { Boolean.valueOf(bool1) }));
      }
      bbT = false;
      if (!bool1)
      {
        Object localObject = paramSplashActivity.getSharedPreferences("UserGuide", 0);
        String str1 = ((SharedPreferences)localObject).getString("qq_version", "");
        String str2 = ((SharedPreferences)localObject).getString("qq_version_full", "");
        if (QLog.isColorLevel()) {
          QLog.e("UserGuide", 2, "pkg build num is 3058, local build num is " + str1);
        }
        if (!"3058".equals(str1))
        {
          localHashMap = new HashMap();
          if (!TextUtils.isEmpty(str1)) {
            break label424;
          }
          if (QLog.isColorLevel()) {
            QLog.e("UserGuide", 2, "this is a new install");
          }
          localHashMap.put("userguide_update_type", "2");
          anpc.a(paramSplashActivity).collectPerformance(null, "userguide_update2", true, 0L, 0L, localHashMap, "", false);
          paramSplashActivity = ((SharedPreferences)localObject).edit();
          localObject = AppSetting.nT();
          paramSplashActivity.putString("qq_version_pre", str1);
          paramSplashActivity.putString("qq_version_full_pre", str2);
          paramSplashActivity.putString("qq_version", "3058");
          paramSplashActivity.putString("qq_version_full", (String)localObject);
          paramSplashActivity.commit();
          if (QLog.isColorLevel()) {
            QLog.i("UserGuide", 2, String.format("update version pre[%s, %s], cur[%s, %s]", new Object[] { str1, str2, "3058", localObject }));
          }
        }
        QLog.e("UserGuide", 1, "showUserGuide " + bbT + ", " + str1 + ", " + "3058");
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        HashMap localHashMap;
        boolean bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          bool1 = bool2;
          continue;
          label424:
          if (QLog.isColorLevel()) {
            QLog.e("UserGuide", 2, "this is a old install");
          }
          localHashMap.put("userguide_update_type", "1");
        }
      }
    }
  }
  
  public static void bXF()
  {
    if (bbU) {
      QLog.w("UserGuide", 1, "clearIsUserGuiderShowed");
    }
    bbU = false;
  }
  
  public void bXG()
  {
    Intent localIntent = getIntent();
    if ((getAppRuntime() != null) && (getAppRuntime().isLogin()))
    {
      localIntent.setClass(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      localIntent.setClass(this, LoginActivity.class);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(null);
    setContentView(null);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("UserGuide", 4, "UserguideActivity.doOnDestroy()");
    }
    bbT = false;
    this.isDestroyed = true;
    System.gc();
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UserGuide", 4, "UserguideActivity.finish()");
    }
    if (isFinishing()) {
      return;
    }
    bXG();
    bbT = false;
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideActivity
 * JD-Core Version:    0.7.0.1
 */