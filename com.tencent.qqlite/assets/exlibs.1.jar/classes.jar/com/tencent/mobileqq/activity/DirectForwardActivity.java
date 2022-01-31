package com.tencent.mobileqq.activity;

import aio;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class DirectForwardActivity
  extends BaseActivity
{
  public static final String a = "toUin";
  public static final String b = "uinType";
  public static final String c = "openerProc";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aio(this);
  ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  public String d;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (this.app.isLogin()))
    {
      this.d = paramBundle.getStringExtra("openerProc");
      String str = paramBundle.getStringExtra("toUin");
      int i = paramBundle.getIntExtra("uinType", 0);
      if ((paramBundle.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (paramBundle.getBooleanExtra("qqfav_extra_from_system_share", false))) {
        overridePendingTransition(0, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.app, getIntent());
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(str, i, str, null);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.process.exit");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      return true;
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DirectForwardActivity
 * JD-Core Version:    0.7.0.1
 */