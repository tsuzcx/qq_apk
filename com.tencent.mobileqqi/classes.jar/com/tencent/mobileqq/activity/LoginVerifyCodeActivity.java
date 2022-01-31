package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import das;
import dat;
import dau;
import dav;
import day;
import daz;
import dba;
import mqq.observer.SubAccountObserver;
import mqq.observer.WtloginObserver;

public class LoginVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static final int a = 60;
  private static final String jdField_a_of_type_JavaLangString = "LoginVerifyCodeActivity";
  public static final int b = 1000;
  private long jdField_a_of_type_Long = 0L;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SubAccountBindObserver a;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new das(this);
  public SubAccountObserver a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new dat(this);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private int c;
  private int h = 60;
  
  public LoginVerifyCodeActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 60;
    this.jdField_a_of_type_MqqObserverSubAccountObserver = new dau(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new dav(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562863) + "(" + this.jdField_c_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void i()
  {
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232961)).setText(getString(2131563062, new Object[] { this.jdField_c_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232963));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562863) + "(" + this.jdField_c_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232995));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131232014));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "startLogin start...");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      PhoneNumLoginImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.d, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
    }
    PhoneNumLoginImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.d, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void k()
  {
    a(2131562877);
    if (PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.d, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      g();
      a(2131562783, 1);
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
      com.tencent.common.app.BaseApplicationImpl.f = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
      if (PhoneNumLoginImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.d, this.jdField_c_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        g();
        a(2131562783, 1);
      }
      return;
    }
    a(2131562029, 0);
  }
  
  protected boolean a()
  {
    return false;
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
  
  public void e()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new day(this));
  }
  
  public void f()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new daz(this));
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new dba(this, paramString1, paramString2));
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (getIntent().getBooleanExtra("login_from_account_change", false))
    {
      setResult(-1);
      finish();
    }
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
    case 2131232963: 
      k();
      return;
    }
    l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)c(2130903588));
    setTitle(2131562240);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isSubaccount", false);
    }
    if (this.jdField_a_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    }
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
    if (this.jdField_a_of_type_Boolean) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */