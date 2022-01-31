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
  private long jdField_a_of_type_Long = -1L;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void d()
  {
    Intent localIntent = new Intent(getIntent());
    localIntent.putExtra("needSkey", "true");
    localIntent.setClass(this, QQBrowserActivity.class);
    localIntent.putExtra("from", 0);
    localIntent.putExtra("uin", this.b.a());
    startActivity(localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if (this.jdField_a_of_type_AndroidContentIntent.getExtras() == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("appShareID", -1L);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isAppShare", false);
    d();
    return false;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    q = GesturePWDUtils.getAppForground(a());
    if (QLog.isDevelopLevel()) {
      QLog.d("QQBrowserDelegationActivity", 4, "onResume.mAppForground = " + q + ",mCanLock=" + this.p);
    }
    if ((!q) && (this.p) && (this.b != null) && (GesturePWDUtils.getJumpLock(a(), this.b.a()))) {
      B();
    }
    if (!q)
    {
      q = true;
      GesturePWDUtils.setAppForground(a(), q);
    }
    this.d_ = 0;
    this.p = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserDelegationActivity
 * JD-Core Version:    0.7.0.1
 */