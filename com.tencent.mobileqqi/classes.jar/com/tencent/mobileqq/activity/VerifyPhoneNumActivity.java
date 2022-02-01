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
import com.tencent.mobileqq.activity.contact.newfriend.ContactRecommendActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import duv;
import duw;
import dux;
import duy;
import duz;
import dva;
import dvb;
import dvc;
import mqq.observer.WtloginObserver;

public class VerifyPhoneNumActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "VerifyPhoneNumActivity";
  public Dialog a;
  private Handler jdField_a_of_type_AndroidOsHandler = new duv(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new dva(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected QQToastNotifier a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new duz(this);
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler();
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f = null;
  
  private void e()
  {
    this.k.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234654));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234655));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234653));
    try
    {
      if ((this.d != null) && (this.d.length() > 4))
      {
        String str = "***" + this.d.substring(this.d.length() - 4, this.d.length());
        str = getString(2131561453, new Object[] { this.jdField_b_of_type_JavaLangString, str, this.e });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.e);
    localIntent.putExtra("password", this.f);
    localIntent.putExtra("tab_index", 0);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void g()
  {
    ContactBindServlet.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ArrayOfByte, this.e);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
    }
    PhoneNumLoginImpl.a().a(true);
    int i = PhoneNumLoginImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyPhoneNumActivity", 4, "startLogin.GetStViaSMSVerifyLogin ret =" + i);
      }
      m();
      f();
    }
  }
  
  private void i()
  {
    Handler localHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(LoginActivity.class);
    if (localHandler != null) {
      localHandler.sendEmptyMessage(14827);
    }
    startActivity(new Intent(this, ContactRecommendActivity.class));
    overridePendingTransition(2130968617, 0);
    finish();
  }
  
  private void j()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(LoginActivity.class);
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessage(14827);
    }
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", 0);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void k()
  {
    ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).e();
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new dvb(this));
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new dvc(this));
  }
  
  protected void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new dux(this, paramInt));
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(str, d(), 0, paramInt);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new duw(this));
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
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new duy(this));
      return;
    }
    LoginActivity.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    j();
    m();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131234654: 
      l();
      g();
      return;
    case 2131234655: 
      l();
      h();
      return;
    }
    f();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)c(2130904047));
    setTitle(2131563157);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.c = getIntent().getStringExtra("key");
    this.d = getIntent().getStringExtra("key_register_binduin");
    this.e = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    this.f = getIntent().getStringExtra("key_register_password");
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    e();
    c(2131561746, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */