package com.tencent.mobileqq.activity.qquserguide;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class UserguideFragment
{
  protected UserguideActivity a;
  
  @Deprecated
  public UserguideFragment() {}
  
  public UserguideFragment(UserguideActivity paramUserguideActivity)
  {
    this.a = paramUserguideActivity;
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public UserguideActivity a()
  {
    return this.a;
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle) {}
  
  public void b() {}
  
  public void b(Bundle paramBundle) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
    ((SharedPreferences.Editor)localObject).putString("qq_version", "6500");
    ((SharedPreferences.Editor)localObject).commit();
    localObject = null;
    if ((this.a.getAppRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)this.a.getAppRuntime();
    }
    int i = a();
    String str = DeviceInfoUtil.g() + "-" + DeviceInfoUtil.h();
    ReportController.a((QQAppInterface)localObject, "CliOper", "", "", "Splash_Screen", "Video_guide", 0, 2, "" + i, "", str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qquserguide.UserguideFragment
 * JD-Core Version:    0.7.0.1
 */