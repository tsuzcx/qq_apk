package com.tencent.mobileqq.activity;

import afrz;
import afsb;
import afsf;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import aqiw;
import arhz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import utv;
import utw;

public class DevlockPushActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private String QW;
  private String aLa;
  private String aLc;
  private String aLe;
  private String aLf;
  private String aLg;
  private String aLh;
  private String aLi;
  private boolean aVA;
  private WtloginObserver b;
  public DevlockInfo b;
  private Button cl;
  Handler mHandler = new utv(this);
  private String mUin;
  private ArrayList<String> pd = new ArrayList();
  private String strButtonText;
  public arhz w;
  
  public DevlockPushActivity()
  {
    this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
    this.jdField_b_of_type_MqqObserverWtloginObserver = new utw(this);
  }
  
  private void initUI()
  {
    this.leftView.setVisibility(4);
    if (this.aVA)
    {
      setRightButton(2131721058, this);
      if (AppSetting.enableTalkBack) {
        this.rightViewText.setContentDescription(getString(2131721058));
      }
    }
    TextView localTextView = (TextView)findViewById(2131368276);
    if (TextUtils.isEmpty(this.aLc)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.cl.setText(getString(2131693211));
      this.cl.setContentDescription(getString(2131693169));
      afsf.a().u(null, this.app.getCurrentAccountUin(), 1);
      return;
      localTextView.setText(this.aLc);
    }
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new DevlockPushActivity.3(this));
  }
  
  public void b(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      afsf.a().cR(paramDevlockInfo.MbGuideInfo);
    }
    int i;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        afsf.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
      }
      for (;;)
      {
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          break label99;
        }
        return;
        i = 0;
        break;
        afsf.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
      }
      label99:
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        paramDevlockInfo.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramDevlockInfo.putExtra("auth_dev_open", true);
        startActivity(paramDevlockInfo);
        finish();
        overridePendingTransition(0, 0);
        return;
      }
      afrz localafrz = afrz.a();
      if ((localafrz != null) && (localafrz.Dx() == afrz.cTE))
      {
        paramDevlockInfo = "";
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramDevlockInfo = this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        }
        localafrz.E(this, paramDevlockInfo);
        return;
      }
      if ((this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1))
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramDevlockInfo.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramDevlockInfo.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramDevlockInfo.putExtra("auth_dev_open", false);
        paramDevlockInfo.putExtra("allow_set", true);
        startActivity(paramDevlockInfo);
        finish();
        return;
      }
      if ((this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        paramDevlockInfo = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
        paramDevlockInfo.putExtra("ParaTextUp", this.aLh);
        paramDevlockInfo.putExtra("ParaTextDown", this.aLi);
        paramDevlockInfo.putExtra("PhoneNO", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("mainaccount", this.aLa);
        paramDevlockInfo.putExtra("uin", this.mUin);
        paramDevlockInfo.putExtra("from_where", this.QW);
        paramDevlockInfo.putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramDevlockInfo, 1001);
        overridePendingTransition(0, 2130772009);
        return;
      }
      afsb.a(this, this.app, afsb.cTJ, 1003, null);
      return;
      i = 0;
    }
  }
  
  public void bMU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.app.getCurrentAccountUin();
    int i = afsf.a().a(this.app, str, this.jdField_b_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus.CheckDevLockStatus fail ret=" + i);
      }
      str = getString(2131693206);
      QQToast.a(getApplicationContext(), str, 0).show(getTitleBarHeight());
      return;
    }
    showProgressDialog();
  }
  
  public void bwV()
  {
    this.mHandler.post(new DevlockPushActivity.4(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if ((paramIntent == null) || (paramIntent.getExtras().getInt("requestCode") != 1002)) {
          break label50;
        }
        setResult(-1, null);
        finish();
      }
    }
    label50:
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
              do
              {
                do
                {
                  do
                  {
                    return;
                    afrz.a().Nd(afrz.cTF);
                    if (afsf.a().ajT())
                    {
                      paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
                      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      startActivity(paramIntent);
                    }
                    for (;;)
                    {
                      paramIntent = new Intent();
                      paramIntent.putExtra("allow_set", true);
                      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                        paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                      }
                      setResult(-1, paramIntent);
                      finish();
                      return;
                      paramIntent = new Intent(this, AuthDevActivity.class);
                      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      paramIntent.putExtra("auth_dev_open", true);
                      startActivity(paramIntent);
                    }
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
                QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
              }
            } while (paramInt1 != 2);
            String str = paramIntent.getExtras().getString("resultMobileMask");
            bool = paramIntent.getExtras().getBoolean("resultSetMobile");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
            }
            if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
            }
          } while (!bool);
          afsf.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
          boolean bool = afsf.a().ajT();
          paramIntent = new Intent();
          if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
          {
            paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            paramIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          }
          if (bool) {
            paramIntent.setClass(this, AuthDevEnableCompleteActivity.class);
          }
          for (;;)
          {
            startActivity(paramIntent);
            QQToast.a(getApplicationContext(), 2, getString(2131693163), 0).show(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            setResult(-1, paramIntent);
            finish();
            return;
            paramIntent.setClass(this, AuthDevActivity.class);
            paramIntent.putExtra("auth_dev_open", true);
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
        afsf.a().a(this.app, this.app.getCurrentAccountUin(), null);
      }
    } while (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
    this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
  }
  
  public boolean onBackEvent()
  {
    if (this.aVA)
    {
      finish();
      overridePendingTransition(0, 2130772013);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        afsf.a().u(null, this.app.getCurrentAccountUin(), 3);
        label55:
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!aqiw.isNetSupport(this))
          {
            QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
            continue;
          }
          bMU();
          continue;
        }
        b(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        continue;
        try
        {
          afsf.a().u(null, this.app.getCurrentAccountUin(), 2);
          label125:
          finish();
          overridePendingTransition(0, 2130772013);
        }
        catch (Exception localException1)
        {
          break label125;
        }
      }
      catch (Exception localException2)
      {
        break label55;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    setTheme(2131756129);
    super.onCreate(paramBundle);
    super.setContentView(2131561308);
    setTitle(2131693215);
    if (this.app == null)
    {
      finish();
      return;
    }
    this.app.setDevLockIntent(null);
    this.cl = ((Button)findViewById(2131381180));
    this.cl.setOnClickListener(this);
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
    afsf.a().Ik(true);
    afsf.a().Ig("Push");
    this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
      afrz.a().update(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
    }
    this.mUin = ((Bundle)localObject).getString("uin");
    this.QW = ((Bundle)localObject).getString("from_where");
    this.aLa = ((Bundle)localObject).getString("mainaccount");
    this.aVA = getIntent().getExtras().getBoolean("canCancel", false);
    this.aLc = getIntent().getExtras().getString("title");
    this.strButtonText = getIntent().getExtras().getString("secondTitle");
    this.aLe = getIntent().getExtras().getString("thirdTitle");
    this.pd = getIntent().getExtras().getStringArrayList("wordsList");
    if ((this.pd != null) && (this.pd.size() > 0)) {
      if (i < this.pd.size())
      {
        paramBundle = (String)this.pd.get(i);
        if (i == 0) {
          this.aLf = paramBundle;
        }
        for (;;)
        {
          i += 1;
          break;
          if (i == 1) {
            this.aLg = paramBundle;
          } else if (i == 2) {
            this.aLh = paramBundle;
          } else if (i == 3) {
            this.aLi = paramBundle;
          }
        }
      }
    }
    if (TextUtils.isEmpty(this.aLc)) {
      this.aLc = getString(2131693210);
    }
    if (TextUtils.isEmpty(this.strButtonText)) {
      this.strButtonText = getString(2131693211);
    }
    if (TextUtils.isEmpty(this.aLf)) {
      this.aLf = getString(2131693187);
    }
    if (TextUtils.isEmpty(this.aLg)) {
      this.aLg = getString(2131693188);
    }
    if (TextUtils.isEmpty(this.aLh)) {
      this.aLh = getString(2131693184);
    }
    if (TextUtils.isEmpty(this.aLi)) {
      this.aLi = getString(2131693185);
    }
    if (TextUtils.isEmpty(this.aLe)) {
      this.aLe = getString(2131693190);
    }
    initUI();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bwV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity
 * JD-Core Version:    0.7.0.1
 */