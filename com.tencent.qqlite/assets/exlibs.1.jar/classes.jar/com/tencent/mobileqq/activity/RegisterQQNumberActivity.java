package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import bhr;
import bhu;
import bhv;
import bhw;
import bhx;
import bhy;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MenuPopupDialog;
import mqq.observer.WtloginObserver;

public class RegisterQQNumberActivity
  extends RegisterBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "RegisterQQNumberActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new bhw(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog = null;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new bhv(this);
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = null;
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298598));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298600));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298599));
    String str = String.format(getString(2131363347), new Object[] { this.c });
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString + "");
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(new bhr(this));
  }
  
  private void f()
  {
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", 0);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
    localObject = this.app.a(LoginActivity.class);
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessage(20140325);
    }
  }
  
  private void i()
  {
    PhoneNumLoginImpl.a().a(true);
    PhoneNumLoginImpl.a().b(this.app, this.d, this.c, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new bhx(this));
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new bhy(this));
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged success");
    }
    if (!PhoneNumLoginImpl.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged not phonenum login");
      }
      return;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.a(new bhu(this));
      return;
    }
    LoginActivity.a(this.app, this.app.getAccount());
    f();
    k();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131362790, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    j();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label129;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
    }
    for (;;)
    {
      ContactBindServlet.a(this.app, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_JavaLangString);
      return;
      label129:
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = null");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130903572));
    setTitle(2131363331);
    this.c = getIntent().getStringExtra("phonenum");
    this.d = getIntent().getStringExtra("key");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    g();
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity
 * JD-Core Version:    0.7.0.1
 */