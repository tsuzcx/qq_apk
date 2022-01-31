package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;
import yz;
import za;
import zb;
import zc;
import zd;
import ze;
import zf;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static final int a = 60;
  public static final int b = 1000;
  private static final String f = "Q.devlock.AuthDevVerifyCodeActivity";
  private static final String jdField_g_of_type_JavaLangString = "UserBehavior";
  private static final String h = "Manually";
  private static final String i = "Push";
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new yz(this);
  protected String a;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new zc(this);
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new zb(this);
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  protected String b;
  private int c;
  private int jdField_g_of_type_Int;
  
  public AuthDevVerifyCodeActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.g = 60;
    this.jdField_a_of_type_AndroidOsHandler = new za(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.g = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363325) + "(" + this.g + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131362785), 0).b(getTitleBarHeight());
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
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
        }
        j = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver, (String)localObject1);
        if (j == 0)
        {
          i();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + j);
        }
        a(2131363314, 1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
      }
      int j = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2, (String)localObject1, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (j == 0)
      {
        i();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + j);
      }
      a(2131363314, 1);
      return;
    }
    a(2131363323, 0);
  }
  
  private void f()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131362785), 0).b(getTitleBarHeight());
    }
    int j;
    do
    {
      String str;
      do
      {
        return;
        str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        j = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        if (j == 0)
        {
          a(2131363296);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + j);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      j = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (j == 0)
      {
        a(2131363296);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.AskDevLockSms failed ret=" + j);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new zd(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ze(this));
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
    runOnUiThread(new zf(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298223: 
      e();
      return;
    }
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903496);
    super.setTitle(2131363322);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("from_login");
    this.jdField_c_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.d = paramBundle.getExtras().getString("country_code");
    this.jdField_c_of_type_Int = paramBundle.getExtras().getInt("seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.jdField_c_of_type_Int + " phoneNum=" + this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298230));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131297386));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298223));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131363324, new Object[] { this.jdField_c_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298232));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363325));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362791));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131363325));
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
    }
    g();
    j();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */