package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import eoy;

public class BindNumberDialogActivity
  extends DialogBaseActivity
{
  static final int jdField_a_of_type_Int = 2;
  protected static final String a = "BindNumberBusinessActivity";
  Handler jdField_a_of_type_AndroidOsHandler = null;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  
  public BindNumberDialogActivity()
  {
    this.jdField_b_of_type_JavaLangString = "+86";
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, BindNumberDialogActivity.class);
    localIntent.putExtra("phone_number", paramString);
    localIntent.putExtra("cmd_param_bind_type", 1);
    localIntent.putExtra("unbind", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void e()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131562488);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new eoy(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a(this.jdField_b_of_type_JavaLangString, this.c, 1);
    a(2131562875, 1000L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    if (paramBundle != null)
    {
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("unbind", false);
      this.c = getIntent().getStringExtra("phone_number");
      this.jdField_b_of_type_Int = getIntent().getIntExtra("cmd_param_bind_type", 0);
      paramBundle = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (this.jdField_b_of_type_Boolean) {
        break label169;
      }
      localRespondQueryQQBindingStat = paramBundle.a();
      int i = paramBundle.b();
      if (localRespondQueryQQBindingStat == null) {
        break label169;
      }
      if ((localRespondQueryQQBindingStat.type == 0) && (!TextUtils.isEmpty(localRespondQueryQQBindingStat.mobileNo)) && (i != 2))
      {
        this.c = localRespondQueryQQBindingStat.mobileNo;
        e();
      }
    }
    else
    {
      return true;
    }
    if ((1 == localRespondQueryQQBindingStat.type) && (QLog.isColorLevel())) {
      QLog.d("BindNumberBusinessActivity", 2, "already bind mobile = " + localRespondQueryQQBindingStat.mobileNo);
    }
    label169:
    BindNumberBusinessActivity.a(this, this.c, this.jdField_b_of_type_Boolean);
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130968595, 2130968683);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberDialogActivity
 * JD-Core Version:    0.7.0.1
 */