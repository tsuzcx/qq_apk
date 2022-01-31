package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import auy;
import auz;
import ava;
import avb;
import avc;
import avd;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;

public class LoginVerifyCodeActivity2
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static final int a = 60;
  private static final String jdField_a_of_type_JavaLangString = "LoginVerifyCodeActivity";
  public static final int b = 1000;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new auz(this);
  public SSOAccountObserver a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new ava(this);
  private int c;
  private int g;
  
  public LoginVerifyCodeActivity2()
  {
    this.jdField_c_of_type_Int = 60;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new auy(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363338) + "(" + this.jdField_c_of_type_Int + ")");
    this.b.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void i()
  {
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298212)).setText(getString(2131363337, new Object[] { this.jdField_c_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298214));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363338) + "(" + this.jdField_c_of_type_Int + ")");
    this.b.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298243));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297382));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
  }
  
  private void j()
  {
    PhoneNumLoginImpl.a().b(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.d, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void k()
  {
    a(2131363309);
    if (PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.d, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      g();
      d();
    }
  }
  
  private void l()
  {
    Object localObject1 = "";
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject2 != null)
    {
      localObject2 = localObject2.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
    }
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      a(2131363313);
      if (PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.d, this.jdField_c_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        g();
        d();
      }
      return;
    }
    a(2131363336, 0);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void d()
  {
    a(2131363397, 1);
  }
  
  public void e()
  {
    this.b.post(new avb(this));
  }
  
  public void f()
  {
    this.b.post(new avc(this));
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new avd(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131362797, 0);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298214: 
      k();
      return;
    }
    l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130903504));
    setTitle(2131363335);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.g = getIntent().getIntExtra("key_req_src", -1);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.d = getIntent().getStringExtra("key");
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */