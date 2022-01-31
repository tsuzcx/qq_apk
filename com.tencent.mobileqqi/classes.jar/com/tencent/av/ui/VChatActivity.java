package com.tencent.av.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import bkq;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public class VChatActivity
  extends BaseActivity
{
  static final String jdField_a_of_type_JavaLangString = "VChatActivity";
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new bkq(this);
  public VideoController a;
  public VideoAppInterface a;
  
  private void a()
  {
    super.finish();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VChatActivity", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    paramBundle = super.getIntent();
    String str = paramBundle.getStringExtra("uin");
    if (str != null) {
      try
      {
        ((MobileQQ)getApplication()).getAppRuntime(str);
        switch (paramBundle.getIntExtra("istatus", 0))
        {
        default: 
          super.finish();
          return;
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          QLog.d("VChatActivity", 1, "AV_UIN_NOT_MATCH, MSFUIN: " + str + " AVUIN:" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
          HashMap localHashMap = new HashMap();
          localHashMap.put("avuin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
          localHashMap.put("msfuin", String.valueOf(str));
          StatisticCollector.a(getApplicationContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), "AV_UIN_NOT_MATCH", false, 0L, 0L, localHashMap, "", true);
          if (!str.equals("0"))
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str);
            continue;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().d(0);
            continue;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().d(1);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.g();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    super.finish();
    a();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    String str = super.getString(2131560245);
    DialogUtil.a(this, 230, super.getString(2131560225), str, 2131560231, 2131560231, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VChatActivity
 * JD-Core Version:    0.7.0.1
 */