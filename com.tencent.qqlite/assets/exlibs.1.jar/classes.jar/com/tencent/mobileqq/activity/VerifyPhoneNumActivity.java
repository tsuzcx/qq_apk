package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import brs;
import brt;
import bru;
import brv;
import brw;
import brx;
import bry;
import brz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;

public class VerifyPhoneNumActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "VerifyPhoneNumActivity";
  public Dialog a;
  private Handler jdField_a_of_type_AndroidOsHandler = new brs(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new brx(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected QQToastNotifier a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new brw(this);
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler();
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f = null;
  
  private void d()
  {
    this.h.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298921));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298922));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298920));
    try
    {
      if ((this.d != null) && (this.d.length() > 4))
      {
        String str = "***" + this.d.substring(this.d.length() - 4, this.d.length());
        str = getString(2131363335, new Object[] { this.jdField_b_of_type_JavaLangString, str, this.e });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.e);
    localIntent.putExtra("password", this.f);
    localIntent.putExtra("tab_index", 0);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void f()
  {
    ContactBindServlet.b(this.app, this.jdField_a_of_type_ArrayOfByte, this.e);
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
    }
    PhoneNumLoginImpl.a().a(true);
    int i = PhoneNumLoginImpl.a().b(this.app, this.c, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyPhoneNumActivity", 4, "startLogin.GetStViaSMSVerifyLogin ret =" + i);
      }
      k();
      e();
    }
  }
  
  private void h()
  {
    Object localObject = this.app.a(LoginActivity.class);
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessage(20140325);
    }
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", 0);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void i()
  {
    ((PhoneContactManager)this.app.getManager(10)).f();
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new bry(this));
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new brz(this));
  }
  
  protected void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new bru(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(str, getTitleBarHeight(), 0, paramInt);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new brt(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
    if (isFinishing()) {
      return;
    }
    if (!PhoneNumLoginImpl.a().a())
    {
      QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
      return;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.a(new brv(this));
      return;
    }
    LoginActivity.a(this.app, this.app.getAccount());
    h();
    k();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298921: 
      j();
      f();
      return;
    case 2131298922: 
      j();
      g();
      return;
    }
    e();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130903690));
    setTitle(2131363334);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.c = getIntent().getStringExtra("key");
    this.d = getIntent().getStringExtra("key_register_binduin");
    this.e = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    this.f = getIntent().getStringExtra("key_register_password");
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    d();
    setRightButton(2131362794, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */