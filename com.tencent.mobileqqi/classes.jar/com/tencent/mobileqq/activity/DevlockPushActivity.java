package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cgh;
import cgi;
import cgj;
import cgk;
import cgl;
import cgm;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogDevLock;
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
  private Handler jdField_a_of_type_AndroidOsHandler = new cgh(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new cgi(this);
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
        EquipmentLockImpl.a().a(this.b, this, this.b.a(), true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          break label99;
        }
        return;
        n = 0;
        break;
        EquipmentLockImpl.a().a(this.b, this, this.b.a(), false);
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
      paramDevlockInfo = getString(2131561753);
      String str = getString(2131561863);
      QQCustomDialogDevLock.a(this, this.i, this.j, this.jdField_k_of_type_JavaLangString, paramDevlockInfo, str, new cgj(this), new cgk(this)).show();
      return;
      n = 0;
    }
  }
  
  private void d()
  {
    this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_a_of_type_Boolean)
    {
      c(2131561746, this);
      this.jdField_m_of_type_AndroidWidgetTextView.setContentDescription(getString(2131561746));
    }
    TextView localTextView = (TextView)findViewById(2131232950);
    if (TextUtils.isEmpty(this.g)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131562011));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562008));
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.b.a(), "UserBehavior", "Push", 0, 1, "", "", "", "");
      return;
      localTextView.setText(this.g);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new cgl(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new cgm(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.b.a();
    int n = EquipmentLockImpl.a().a(this.b, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (n != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus.CheckDevLockStatus fail ret=" + n);
      }
      str = getString(2131562568);
      QQToast.a(getApplicationContext(), str, 0).b(d());
      return;
    }
    e();
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      finish();
      overridePendingTransition(0, 2130968599);
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if (!EquipmentLockImpl.a().a()) {
          break label129;
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
    label129:
    label208:
    label593:
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
                      break label208;
                    }
                  } while (paramInt2 != -1);
                  finish();
                  return;
                } while (paramInt1 != 1003);
                if (paramInt2 != -1) {
                  break label593;
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
          EquipmentLockImpl.a().a(this.b, this, this.b.a(), true);
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
            QQToast.a(getApplicationContext(), 2, getString(2131562015), 0).b(d());
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
        EquipmentLockImpl.a().a(this.b, this.b.a(), null);
      }
    } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
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
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.b.a(), "UserBehavior", "Push", 0, 3, "", "", "", "");
      label62:
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (!NetworkUtil.e(this))
        {
          QQToast.a(this, getString(2131562452), 0).b(d());
          return;
        }
        a();
        return;
      }
      a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      return;
      try
      {
        ReportController.b(null, "P_CliOper", "Safe_DeviceLock", this.b.a(), "UserBehavior", "Push", 0, 2, "", "", "", "");
        label140:
        finish();
        overridePendingTransition(0, 2130968599);
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
    setTheme(2131624531);
    super.onCreate(paramBundle);
    setContentView(2130903570);
    setTitle(2131561941);
    this.b.setDevLockIntent(null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232951));
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
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    this.d = ((Bundle)localObject).getString("uin");
    this.e = ((Bundle)localObject).getString("from_where");
    this.f = ((Bundle)localObject).getString("mainaccount");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("canCancel", false);
    this.g = getIntent().getExtras().getString("title");
    this.h = getIntent().getExtras().getString("secondTitle");
    this.i = getIntent().getExtras().getString("thirdTitle");
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getExtras().getStringArrayList("wordsList");
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      if (n < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = (String)this.jdField_a_of_type_JavaUtilArrayList.get(n);
        if (n == 0) {
          this.j = paramBundle;
        }
        for (;;)
        {
          n += 1;
          break;
          if (n == 1) {
            this.jdField_k_of_type_JavaLangString = paramBundle;
          } else if (n == 2) {
            this.l = paramBundle;
          } else if (n == 3) {
            this.jdField_m_of_type_JavaLangString = paramBundle;
          }
        }
      }
    }
    if (TextUtils.isEmpty(this.g)) {
      this.g = getString(2131563211);
    }
    if (TextUtils.isEmpty(this.h)) {
      this.h = getString(2131562011);
    }
    if (TextUtils.isEmpty(this.j)) {
      this.j = getString(2131562682);
    }
    if (TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
      this.jdField_k_of_type_JavaLangString = getString(2131562939);
    }
    if (TextUtils.isEmpty(this.l)) {
      this.l = getString(2131561861);
    }
    if (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
      this.jdField_m_of_type_JavaLangString = getString(2131561622);
    }
    if (TextUtils.isEmpty(this.i)) {
      this.i = getString(2131562564);
    }
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity
 * JD-Core Version:    0.7.0.1
 */