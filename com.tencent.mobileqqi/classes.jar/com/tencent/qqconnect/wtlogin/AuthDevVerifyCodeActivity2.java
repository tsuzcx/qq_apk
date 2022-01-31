package com.tencent.qqconnect.wtlogin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterBaseActivity;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import htw;
import htx;
import hty;
import htz;
import hua;
import hub;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;

public class AuthDevVerifyCodeActivity2
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static final int a = 60;
  public static final int b = 1000;
  private static final String f = "Q.devlock.AuthDevVerifyCodeActivity2";
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new htx(this);
  protected String a;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new htw(this);
  private TextView b;
  protected String b;
  private int c;
  
  public AuthDevVerifyCodeActivity2()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 60;
    this.jdField_a_of_type_AndroidOsHandler = new hty(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562863) + "(" + this.jdField_c_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131562452), 0).b(d());
      return;
    }
    Object localObject1 = "";
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
      }
      int i = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver, (String)localObject1);
      if (i == 0)
      {
        i();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "commitSmsCode.submitSms failed ret=" + i);
      }
      a(2131563224, 1);
      return;
    }
    a(2131562029, 0);
  }
  
  private void f()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131562452), 0).b(d());
    }
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "startGetVerifyCode.begin to refreshDevLockSms");
      }
      i = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
      if (i == 0)
      {
        a(2131562877);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + i);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new htz(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hua(this));
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
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new hub(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232954: 
      e();
      return;
    }
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903577);
    setTitle(2131562240);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    paramBundle = getIntent();
    this.jdField_c_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.d = paramBundle.getExtras().getString("country_code");
    int i = paramBundle.getExtras().getInt("seq");
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(i);
    EquipmentLockImpl.a().a(Integer.valueOf(90000), this.jdField_a_of_type_AndroidOsHandler);
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onCreate  phoneNum=" + this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232964));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131232017));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232954));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131563062, new Object[] { this.jdField_c_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232966));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562863));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562539));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131562863));
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    EquipmentLockImpl.a().a(Integer.valueOf(90000));
    g();
    j();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */