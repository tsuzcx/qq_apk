package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import cbu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1001;
  public static final String a = "from_login";
  public static final int b = 1002;
  public static final String b = "phone_num";
  public static final int c = 1003;
  public static final String c = "country_code";
  public static final String d = "auth_dev_open";
  public static final String e = "allow_set";
  public static final String f = "user_guide";
  public static final String g = "user_uin";
  public static final String h = "seq";
  public static final String i = "DevlockInfo";
  private static final String j = "Q.devlock.AuthDevUgActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new cbu(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private int d;
  private String k;
  private String l;
  private String m;
  
  private void d()
  {
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason)))
      {
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason = LocaleString.i(getBaseContext(), this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          str = getString(2131562606) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
          this.c.setText(str);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131563162));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(4);
        c(2131561746, this);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562394));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131563162));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561942));
      }
    }
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
    }
    while ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType == 2))
    {
      str = getString(2131562606) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
      this.c.setText(str);
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131562008));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562394));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131562008));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561942));
    }
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg))) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131562008));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562394));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131562008));
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "onBackEvent.cancelVerifyCode mVerifyObserver.seq=" + this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq());
      }
      EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
      finish();
      overridePendingTransition(0, 2130968599);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    a(0, localIntent);
    return false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (BaseActivity.a(getIntent()))
    {
      finish();
      return true;
    }
    paramBundle = super.getIntent();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    paramBundle = paramBundle.getExtras();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("from_login");
    this.d = paramBundle.getInt("seq");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle.get("DevlockInfo"));
    this.jdField_k_of_type_JavaLangString = paramBundle.getString("uin");
    this.l = paramBundle.getString("from_where");
    this.m = paramBundle.getString("mainaccount");
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.d + " mUin=" + this.jdField_k_of_type_JavaLangString + " mFromWhere=" + this.l + " mMainAccount=" + this.m);
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
      }
    }
    super.getWindow().setFormat(-3);
    if (this.jdField_a_of_type_Boolean) {
      setTheme(2131624531);
    }
    super.setContentView(2130903572);
    if (this.jdField_a_of_type_Boolean)
    {
      super.setTitle(2131562326);
      if (this.jdField_a_of_type_Boolean)
      {
        paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(LoginActivity.class);
        if (paramBundle != null) {
          paramBundle.sendEmptyMessage(14825);
        }
        paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(SubLoginActivity.class);
        if (paramBundle != null) {
          paramBundle.sendEmptyMessage(14825);
        }
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo))) {
          break label725;
        }
        EquipmentLockImpl.a().a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232956));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232957));
      this.c = ((TextView)super.findViewById(2131232958));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232959));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232948));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      d();
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.d);
      return true;
      super.setTitle(2131561941);
      break;
      label725:
      finish();
      overridePendingTransition(0, 0);
      QQToast.a(this, 1, getString(2131562324), 0).a();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent(this, AuthDevActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        }
        a(-1, paramIntent);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            String str;
            boolean bool;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (paramInt1 != 1002) {
                        break;
                      }
                    } while (paramInt2 != -1);
                    finish();
                    return;
                  } while (paramInt1 != 1003);
                  if (paramInt2 != -1) {
                    break;
                  }
                } while ((paramIntent == null) || (paramIntent.getExtras() == null));
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              str = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
              }
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
              {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
                {
                  paramIntent = getString(2131562606) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                  this.c.setText(paramIntent);
                  this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131562008));
                  this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  this.c.setVisibility(0);
                  this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
                }
              }
            } while (!bool);
            EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
            paramIntent = new Intent(this, AuthDevActivity.class);
            paramIntent.putExtra("phone_num", str);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
            QQToast.a(getApplicationContext(), 2, getString(2131562015), 0).b(d());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            a(-1, paramIntent);
            return;
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile));
    paramIntent = getString(2131562606) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
    this.c.setText(paramIntent);
    this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131562008));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232959: 
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendWirelessMeibaoReq(1);
      }
      if (q)
      {
        if ((!TextUtils.isEmpty(this.l)) && (this.l.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "subaccount enter webview mUin=" + this.jdField_k_of_type_JavaLangString + " mMainAccount=" + this.m);
          }
          if ((TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
          }
          EquipLockWebEntrance.a(this, this.m, this.jdField_k_of_type_JavaLangString);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "mainaccount enter webview mUin=" + this.jdField_k_of_type_JavaLangString);
        }
        if ((TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.jdField_k_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString);
        return;
      }
      EquipLockWebEntrance.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    case 2131232948: 
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = new Intent(this, AuthDevVerifyCodeActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramView.putExtra("from_login", this.jdField_a_of_type_Boolean);
        paramView.putExtra("seq", this.d);
        startActivityForResult(paramView, 1002);
        return;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
        paramView = new Intent(this, AuthDevVerifyCodeActivity.class);
        paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        startActivityForResult(paramView, 1001);
        return;
      }
      EquipLockWebEntrance.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1003, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevUgActivity", 2, "onClick.cancelVerifyCode mVerifyObserver.seq=" + this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq());
    }
    EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
    finish();
    overridePendingTransition(0, 2130968599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevUgActivity
 * JD-Core Version:    0.7.0.1
 */