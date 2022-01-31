package com.tencent.mobileqq.activity;

import aif;
import aig;
import aih;
import aii;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class DevlockPushActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.DevlockPushActivity";
  private static final String b = "UserBehavior";
  private static final String c = "Push";
  private Handler jdField_a_of_type_AndroidOsHandler = new aif(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aig(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private boolean jdField_a_of_type_Boolean = false;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    int n;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        n = 1;
      }
    }
    for (;;)
    {
      if (n != 0) {
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          break label99;
        }
        return;
        n = 0;
        break;
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
      }
      label99:
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        paramDevlockInfo.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramDevlockInfo.putExtra("auth_dev_open", true);
        startActivity(paramDevlockInfo);
        finish();
        overridePendingTransition(0, 0);
        return;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1))
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramDevlockInfo.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramDevlockInfo.putExtra("auth_dev_open", false);
        paramDevlockInfo.putExtra("allow_set", true);
        startActivity(paramDevlockInfo);
        finish();
        return;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        paramDevlockInfo = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
        paramDevlockInfo.putExtra("ParaTextUp", this.l);
        paramDevlockInfo.putExtra("ParaTextDown", this.m);
        paramDevlockInfo.putExtra("PhoneNO", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("mainaccount", this.f);
        paramDevlockInfo.putExtra("uin", this.d);
        paramDevlockInfo.putExtra("from_where", this.e);
        paramDevlockInfo.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramDevlockInfo, 1001);
        overridePendingTransition(0, 2130968592);
        return;
      }
      EquipLockWebEntrance.a(this, this.app, 1003, null);
      return;
      n = 0;
    }
  }
  
  private void c()
  {
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_a_of_type_Boolean)
    {
      setRightButton(2131362801, this);
      this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(getString(2131362801));
    }
    TextView localTextView = (TextView)findViewById(2131298201);
    if (TextUtils.isEmpty(this.g)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131364239));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364203));
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.app.a(), "UserBehavior", "Push", 0, 1, "", "", "", "");
      return;
      localTextView.setText(this.g);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aih(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aii(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.app.a();
    int n = EquipmentLockImpl.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (n != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus.CheckDevLockStatus fail ret=" + n);
      }
      str = getString(2131364223);
      QQToast.a(getApplicationContext(), str, 0).b(getTitleBarHeight());
      return;
    }
    d();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      finish();
      overridePendingTransition(0, 2130968593);
    }
    return true;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if (!EquipmentLockImpl.a().a()) {
          break label128;
        }
        paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("allow_set", true);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        }
        setResult(-1, paramIntent);
        finish();
      }
    }
    label128:
    label207:
    do
    {
      do
      {
        do
        {
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
                    paramIntent = new Intent(this, AuthDevActivity.class);
                    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                    {
                      paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                      paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                    }
                    paramIntent.putExtra("auth_dev_open", true);
                    startActivity(paramIntent);
                    break;
                    if (paramInt1 != 1002) {
                      break label207;
                    }
                  } while (paramInt2 != -1);
                  finish();
                  return;
                } while (paramInt1 != 1003);
                if (paramInt2 != -1) {
                  break label591;
                }
              } while ((paramIntent == null) || (paramIntent.getExtras() == null));
              paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
              }
            } while (paramInt1 != 2);
            String str = paramIntent.getExtras().getString("resultMobileMask");
            bool = paramIntent.getExtras().getBoolean("resultSetMobile");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
            }
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
            }
          } while (!bool);
          EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
          if (EquipmentLockImpl.a().a())
          {
            paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
            {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            startActivity(paramIntent);
          }
          for (;;)
          {
            QQToast.a(getApplicationContext(), 2, getString(2131364205), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            setResult(-1, paramIntent);
            finish();
            return;
            paramIntent = new Intent(this, AuthDevActivity.class);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
            {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
          }
        } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
        }
      } while (paramInt1 != 2);
      paramIntent = paramIntent.getExtras().getString("resultMobileMask");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        EquipmentLockImpl.a().a(this.app, this.app.a(), null);
      }
    } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
    label591:
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    try
    {
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.app.a(), "UserBehavior", "Push", 0, 3, "", "", "", "");
      label62:
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (!NetworkUtil.e(this))
        {
          QQToast.a(this, getString(2131362797), 0).b(getTitleBarHeight());
          return;
        }
        a();
        return;
      }
      a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      return;
      try
      {
        ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.app.a(), "UserBehavior", "Push", 0, 2, "", "", "", "");
        label140:
        finish();
        overridePendingTransition(0, 2130968593);
        return;
      }
      catch (Exception paramView)
      {
        break label140;
      }
    }
    catch (Exception paramView)
    {
      break label62;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int n = 0;
    setTheme(2131624268);
    super.onCreate(paramBundle);
    setContentView(2130903486);
    setTitle(2131364200);
    if (this.app == null)
    {
      finish();
      return;
    }
    this.app.setDevLockIntent(null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298202));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    EquipmentLockImpl.a().a(true);
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    this.d = ((Bundle)localObject).getString("uin");
    this.e = ((Bundle)localObject).getString("from_where");
    this.f = ((Bundle)localObject).getString("mainaccount");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("canCancel", false);
    this.g = getIntent().getExtras().getString("title");
    this.jdField_h_of_type_JavaLangString = getIntent().getExtras().getString("secondTitle");
    this.i = getIntent().getExtras().getString("thirdTitle");
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getExtras().getStringArrayList("wordsList");
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      if (n < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = (String)this.jdField_a_of_type_JavaUtilArrayList.get(n);
        if (n == 0) {
          this.jdField_j_of_type_JavaLangString = paramBundle;
        }
        for (;;)
        {
          n += 1;
          break;
          if (n == 1) {
            this.k = paramBundle;
          } else if (n == 2) {
            this.l = paramBundle;
          } else if (n == 3) {
            this.m = paramBundle;
          }
        }
      }
    }
    if (TextUtils.isEmpty(this.g)) {
      this.g = getString(2131364250);
    }
    if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      this.jdField_h_of_type_JavaLangString = getString(2131364239);
    }
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      this.jdField_j_of_type_JavaLangString = getString(2131364241);
    }
    if (TextUtils.isEmpty(this.k)) {
      this.k = getString(2131364242);
    }
    if (TextUtils.isEmpty(this.l)) {
      this.l = getString(2131364243);
    }
    if (TextUtils.isEmpty(this.m)) {
      this.m = getString(2131364244);
    }
    if (TextUtils.isEmpty(this.i)) {
      this.i = getString(2131364240);
    }
    c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity
 * JD-Core Version:    0.7.0.1
 */