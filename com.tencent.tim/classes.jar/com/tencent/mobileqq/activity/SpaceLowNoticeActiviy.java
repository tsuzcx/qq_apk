package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import aqha;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.ServerConfigManager.ConfigType;
import vvm;
import vvn;
import vvo;

public class SpaceLowNoticeActiviy
  extends BaseActivity
{
  private aqju dialog;
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return paramLong;
      try
      {
        long l = Long.parseLong(paramQQAppInterface.a(ServerConfigManager.ConfigType.common, paramString));
        if (l > 0L) {
          return l;
        }
      }
      catch (Throwable paramQQAppInterface) {}
    }
    return paramLong;
  }
  
  public static boolean bu(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication());
    long l2 = localSharedPreferences.getLong("lastCheckTime", 0L);
    if ((l2 <= 0L) || (l1 - l2 > paramLong))
    {
      localSharedPreferences.edit().putLong("lastCheckTime", l1).commit();
      return true;
    }
    return false;
  }
  
  public static void dh(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, SpaceLowNoticeActiviy.class);
    paramContext.startActivity(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559712);
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    this.dialog = null;
    this.dialog = aqha.a(this, 230);
    this.dialog.setContentView(2131559127);
    this.dialog.setTitle(getString(2131701072)).setMessage(getString(2131701073)).setPositiveButton(2131701630, new vvn(this)).setNegativeButton(2131721058, new vvm(this));
    this.dialog.setOnKeyListener(new vvo(this));
    this.dialog.show();
    return false;
  }
  
  public void finish()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    this.dialog = null;
    super.finish();
  }
  
  public void onBackPressed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SpaceLowNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */