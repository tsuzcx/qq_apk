package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import cgw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class DirectForwardActivity
  extends BaseActivity
{
  public static final String a = "toUin";
  public static final String b = "uinType";
  public static final String c = "openerProc";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cgw(this);
  ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  public String d;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if ((paramBundle != null) && (this.b.isLogin()))
    {
      this.d = paramBundle.getStringExtra("openerProc");
      String str = paramBundle.getStringExtra("toUin");
      int i = paramBundle.getIntExtra("uinType", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.b, getIntent());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DirectForwardActivity
 * JD-Core Version:    0.7.0.1
 */