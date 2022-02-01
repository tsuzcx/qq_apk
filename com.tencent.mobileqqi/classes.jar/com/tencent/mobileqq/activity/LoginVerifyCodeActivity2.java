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
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cvj;
import cvk;
import cvl;
import cvm;
import cvn;
import cvo;
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
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new cvk(this);
  public SSOAccountObserver a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new cvl(this);
  private int c;
  private int h;
  
  public LoginVerifyCodeActivity2()
  {
    this.jdField_c_of_type_Int = 60;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new cvj(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562863) + "(" + this.jdField_c_of_type_Int + ")");
    this.b.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void i()
  {
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232963)).setText(getString(2131563062, new Object[] { this.jdField_c_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232965));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562863) + "(" + this.jdField_c_of_type_Int + ")");
    this.b.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232997));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232016));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
  }
  
  private void j()
  {
    PhoneNumLoginImpl.a().b(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.d, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void k()
  {
    a(2131562877);
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
      a(2131563166);
      if (PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.d, this.jdField_c_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        g();
        d();
      }
      return;
    }
    a(2131562029, 0);
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
    a(2131562783, 1);
  }
  
  public void e()
  {
    this.b.post(new cvm(this));
  }
  
  public void f()
  {
    this.b.post(new cvn(this));
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new cvo(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131562452, 0);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232965: 
      k();
      return;
    }
    l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)c(2130903590));
    setTitle(2131562240);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.h = getIntent().getIntExtra("key_req_src", -1);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.d = getIntent().getStringExtra("key");
    i();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */