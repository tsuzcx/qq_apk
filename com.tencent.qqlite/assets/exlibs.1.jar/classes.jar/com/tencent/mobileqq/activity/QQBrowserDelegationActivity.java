package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class QQBrowserDelegationActivity
  extends BaseActivity
{
  public static final int a = 10012120;
  public static final String a = "param_force_internal_browser";
  public static final int b = 10012121;
  public static final String b = "动态";
  public static final int c = 10012122;
  private static final String c = "QQBrowserDelegationActivity";
  private Intent a = null;
  
  private void c()
  {
    Intent localIntent = new Intent(getIntent());
    localIntent.putExtra("needSkey", "true");
    localIntent.setClass(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    startActivity(localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = getIntent();
    if (this.a.getExtras() == null)
    {
      finish();
      return false;
    }
    c();
    return false;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    mAppForground = GesturePWDUtils.getAppForground(getActivity());
    if (QLog.isDevelopLevel()) {
      QLog.d("QQBrowserDelegationActivity", 4, "onResume.mAppForground = " + mAppForground + ",mCanLock=" + this.t);
    }
    if ((!mAppForground) && (this.t) && (this.app != null) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.a()))) {
      w();
    }
    if (!mAppForground)
    {
      mAppForground = true;
      GesturePWDUtils.setAppForground(getActivity(), mAppForground);
    }
    this.d_ = 0;
    this.t = true;
  }
  
  public int getPathNodeID()
  {
    return -1;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserDelegationActivity
 * JD-Core Version:    0.7.0.1
 */