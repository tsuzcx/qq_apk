package com.tencent.mobileqq.activity;

import afsb;
import afsf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import anot;
import assi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import uhp;

public class AuthDevUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static int bEb = 0;
  public static final ArrayList<String> oR = new ArrayList(Arrays.asList(new String[] { "0X800AA33", "0X800AA34", "0X800AA35", "0X800AA36", "0X800AA37" }));
  private TextView Cj;
  private TextView Ck;
  private TextView Cl;
  private TextView Cm;
  private long Fl;
  private long Fm;
  private String QW;
  private String aLa;
  private boolean aRL;
  private DevlockInfo b;
  private int bDZ;
  private Button cX;
  private Button cl;
  private AppInterface mApp;
  private String mUin;
  VerifyDevLockManager.VerifyDevLockObserver mVerifyObserver = new uhp(this);
  
  private void bGr()
  {
    boolean bool = true;
    if ((this.b == null) || (TextUtils.isEmpty(this.b.OtherDevLockVerifyUrl)))
    {
      QLog.e("Q.devlock.AuthDevUgActivity", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", this.b.OtherDevLockVerifyUrl);
    localIntent.putExtra("subAccountUin", this.mUin);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    if ((this.aLa != null) && (!this.aLa.equals(this.mUin))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "other_verify,  mMainAccount =" + this.aLa + " mUin =" + this.mUin + " isSubaccount=" + bool);
      }
      localIntent.putExtra("isSubaccount", bool);
      localIntent.putExtra("avoidLoginWeb", bool);
      bGs();
      try
      {
        VasWebviewUtil.openQQBrowserActivity(this, "", 16384L, localIntent, false, -1);
        label199:
        bGt();
        anot.c(this.app, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
        return;
      }
      catch (SecurityException localSecurityException)
      {
        break label199;
      }
      bool = false;
    }
  }
  
  private void bGu()
  {
    if ("com.tencent.tim:openSdk".equals(this.mApp.getApplication().getQQProcessName())) {}
    for (Intent localIntent = new Intent(this, AuthDevVerifyCodeActivity2.class);; localIntent = new Intent(this, AuthDevVerifyCodeActivity.class))
    {
      if (this.b != null)
      {
        localIntent.putExtra("phone_num", this.b.Mobile);
        localIntent.putExtra("country_code", this.b.CountryCode);
        localIntent.putExtra("mobile_type", 0);
      }
      localIntent.putExtra("from_login", this.aRL);
      localIntent.putExtra("uin", this.mUin);
      localIntent.putExtra("seq", this.bDZ);
      startActivityForResult(localIntent, 1002);
      return;
    }
  }
  
  private void initUI()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.OtherDevLockVerifyUrl))) {
      this.Cm.setVisibility(0);
    }
    String str;
    if (this.aRL) {
      if ((this.b != null) && (!TextUtils.isEmpty(this.b.VerifyReason)))
      {
        this.Cj.setText(this.b.VerifyReason);
        if (this.b != null)
        {
          str = getString(2131693221) + ":" + this.b.Mobile;
          this.Cl.setText(str);
        }
        this.cl.setText(getString(2131693253));
        this.Ck.setVisibility(8);
        if ((this.b != null) && (!TextUtils.isEmpty(this.b.Mobile))) {
          break label265;
        }
        this.Cl.setVisibility(8);
        this.cX.setVisibility(8);
        if (this.Cm != null) {
          this.Cm.setVisibility(4);
        }
        label197:
        this.leftView.setVisibility(4);
        setRightButton(2131721058, this);
        if (AppSetting.enableTalkBack)
        {
          this.cX.setContentDescription(getString(2131693251));
          this.cl.setContentDescription(getString(2131693253));
        }
      }
    }
    label265:
    label472:
    do
    {
      return;
      this.Cj.setText(getString(2131693252));
      break;
      this.Cl.setVisibility(0);
      this.cX.setVisibility(0);
      break label197;
      if ((this.b != null) && (!TextUtils.isEmpty(this.b.ProtectIntro))) {
        this.Cj.setText(this.b.ProtectIntro);
      }
      for (;;)
      {
        if ((this.b == null) || (this.b.MbGuideType != 2)) {
          break label472;
        }
        str = getString(2131693221) + ":" + this.b.Mobile;
        this.Cl.setText(str);
        this.cl.setText(getString(2131693169));
        this.Ck.setVisibility(8);
        this.Cl.setVisibility(0);
        this.cX.setVisibility(0);
        if (!AppSetting.enableTalkBack) {
          break;
        }
        this.cX.setContentDescription(getString(2131693251));
        this.cl.setContentDescription(getString(2131693169));
        return;
        this.Cj.setText(getString(2131693252));
      }
      if ((this.b != null) && (!TextUtils.isEmpty(this.b.MbGuideMsg))) {
        this.Ck.setText(this.b.MbGuideMsg);
      }
      this.cl.setText(getString(2131693169));
    } while (!AppSetting.enableTalkBack);
    this.cX.setContentDescription(getString(2131693251));
    this.cl.setContentDescription(getString(2131693169));
  }
  
  public static int vj()
  {
    return bEb;
  }
  
  public static void zK(int paramInt)
  {
    bEb = paramInt;
  }
  
  protected void bGs()
  {
    finish();
    QLog.d("Q.devlock.AuthDevUgActivity", 1, "beforeOpenBrowser do finish");
  }
  
  protected void bGt()
  {
    QLog.d("Q.devlock.AuthDevUgActivity", 1, "afterOpenBrowser do nothing");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
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
    for (;;)
    {
      try
      {
        this.aRL = paramBundle.getBoolean("from_login");
        this.bDZ = paramBundle.getInt("seq");
        Object localObject = paramBundle.get("DevlockInfo");
        if ((localObject instanceof DevlockInfo)) {
          this.b = ((DevlockInfo)localObject);
        }
        this.mUin = paramBundle.getString("uin");
        this.QW = paramBundle.getString("from_where");
        this.aLa = paramBundle.getString("mainaccount");
        if (QLog.isColorLevel())
        {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate mIsFromLogin = " + this.aRL + " mVerifySeq=" + this.bDZ + " mUin=" + this.mUin + " mFromWhere=" + this.QW + " mMainAccount=" + this.aLa);
          if (this.b != null)
          {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.b.DevSetup + " countryCode:" + this.b.CountryCode + " mobile:" + this.b.Mobile + " MbItemSmsCodeStatus:" + this.b.MbItemSmsCodeStatus + " TimeLimit:" + this.b.TimeLimit + " AvailableMsgCount:" + this.b.AvailableMsgCount + " AllowSet:" + this.b.AllowSet);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.b.ProtectIntro + "  info.MbGuideType:" + this.b.MbGuideType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.b.MbGuideMsg);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.b.MbGuideInfoType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.b.MbGuideInfo);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.OtherDevLockVerifyUrl" + this.b.OtherDevLockVerifyUrl);
          }
        }
        super.getWindow().setFormat(-3);
        if (this.aRL) {
          setTheme(2131756129);
        }
        super.setContentView(2131561312);
        if (this.aRL)
        {
          super.setTitle(2131693216);
          this.mApp = this.app;
          if (this.mApp == null) {
            this.mApp = ((AppInterface)getAppRuntime());
          }
          if (this.mApp != null) {
            break;
          }
          finish();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        return true;
      }
      super.setTitle(2131693215);
    }
    if (this.aRL)
    {
      assi.K(this.mApp);
      if ((this.b == null) || (TextUtils.isEmpty(this.b.MbGuideInfo))) {
        break label857;
      }
      afsf.a().cR(this.b.MbGuideInfo);
    }
    for (;;)
    {
      this.Cj = ((TextView)super.findViewById(2131371104));
      this.Ck = ((TextView)super.findViewById(2131378104));
      this.Cl = ((TextView)super.findViewById(2131373064));
      this.cX = ((Button)super.findViewById(2131364421));
      this.cl = ((Button)super.findViewById(2131381180));
      this.cX.setOnClickListener(this);
      this.cl.setOnClickListener(this);
      this.Cm = ((TextView)super.findViewById(2131372756));
      this.Cm.setOnClickListener(this);
      initUI();
      this.mVerifyObserver.setSeq(this.bDZ);
      anot.c(this.app, "dc00898", "", this.mUin, "0X800AA33", "0X800AA33", bEb, 0, "", "", "", "");
      if (bEb != 1) {
        break;
      }
      anot.c(this.app, "dc00898", "", this.mUin, "0X800AC0B", "0X800AC0B", bEb, 0, "", "", "", "");
      return true;
      label857:
      finish();
      overridePendingTransition(0, 0);
      QQToast.a(this, 1, getString(2131695507), 0).show();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mApp = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, LoginInfoActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public boolean isWrapContent()
  {
    return !this.aRL;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent(this, AuthDevActivity.class);
        if (this.b != null)
        {
          paramIntent.putExtra("phone_num", this.b.Mobile);
          paramIntent.putExtra("country_code", this.b.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        if (this.b != null) {
          paramIntent.putExtra("phone_num", this.b.Mobile);
        }
        v(-1, paramIntent);
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
                    setResult(paramInt2, paramIntent);
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
              if (this.b != null)
              {
                this.b.Mobile = str;
                if (!TextUtils.isEmpty(this.b.Mobile))
                {
                  paramIntent = getString(2131693221) + ":" + this.b.Mobile;
                  this.Cl.setText(paramIntent);
                  this.cl.setText(getString(2131693169));
                  this.Ck.setVisibility(8);
                  this.Cl.setVisibility(0);
                  this.cX.setVisibility(0);
                }
              }
            } while (!bool);
            afsf.a().a(this.mApp, this, this.mApp.getCurrentAccountUin(), true);
            paramIntent = new Intent(this, AuthDevActivity.class);
            paramIntent.putExtra("phone_num", str);
            if (this.b != null) {
              paramIntent.putExtra("country_code", this.b.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
            QQToast.a(getApplicationContext(), 2, getString(2131693163), 0).show(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.b != null) {
              paramIntent.putExtra("phone_num", this.b.Mobile);
            }
            v(-1, paramIntent);
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
          afsf.a().a(this.mApp, this.mApp.getCurrentAccountUin(), null);
        }
      } while (this.b == null);
      this.b.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.b.Mobile));
    paramIntent = getString(2131693221) + ":" + this.b.Mobile;
    this.Cl.setText(paramIntent);
    this.cl.setText(getString(2131693169));
    this.Ck.setVisibility(8);
    this.Cl.setVisibility(0);
    this.cX.setVisibility(0);
  }
  
  public boolean onBackEvent()
  {
    if (this.aRL)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onBackEvent.cancelVerifyCode mVerifyObserver.seq=");
        if (this.mVerifyObserver == null) {
          break label95;
        }
      }
      label95:
      for (int i = this.mVerifyObserver.getSeq();; i = 0)
      {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, i);
        setResult(0);
        afsf.a().a(this.mApp, this.mVerifyObserver);
        this.mVerifyObserver = null;
        finish();
        overridePendingTransition(0, 2130772013);
        return false;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    String str = "";
    Object localObject = str;
    if (this.b != null)
    {
      localObject = str;
      if (this.b.Mobile != null) {
        localObject = this.b.Mobile;
      }
    }
    localIntent.putExtra("phone_num", (String)localObject);
    v(0, localIntent);
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((this.Fl > 0L) && (System.currentTimeMillis() - this.Fl > 0L) && (System.currentTimeMillis() - this.Fl < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.Fl = System.currentTimeMillis();
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364421: 
        anot.c(this.app, "dc00898", "", this.mUin, "0X800AA34", "0X800AA34", bEb, 0, "", "", "", "");
        this.mApp.sendWirelessMeibaoReq(1);
        if (mAppForground)
        {
          if ((!TextUtils.isEmpty(this.QW)) && (this.QW.equals("subaccount")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "subaccount enter webview mUin=" + this.mUin + " mMainAccount=" + this.aLa);
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
            }
            afsb.f(this, this.aLa, this.mUin, afsb.cTH);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mainaccount enter webview mUin=" + this.mUin);
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
            }
            afsb.f(this, this.mApp.getCurrentAccountUin(), this.mUin, afsb.cTH);
          }
        }
        else {
          afsb.a(this, this.mApp, afsb.cTH);
        }
        break;
      case 2131381180: 
        if (this.aRL)
        {
          anot.c(this.app, "dc00898", "", this.mUin, "0X800AA35", "0X800AA35", bEb, 0, "", "", "", "");
          if (TextUtils.isEmpty(this.b.Mobile)) {
            bGr();
          } else {
            bGu();
          }
        }
        else if ((this.b != null) && (!TextUtils.isEmpty(this.b.Mobile)))
        {
          anot.a(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
          localObject = new Intent(this, AuthDevVerifyCodeActivity.class);
          ((Intent)localObject).putExtra("phone_num", this.b.Mobile);
          ((Intent)localObject).putExtra("country_code", this.b.CountryCode);
          startActivityForResult((Intent)localObject, 1001);
        }
        else
        {
          afsb.a(this, this.mApp, afsb.cTH, 1003, null);
        }
        break;
      case 2131369612: 
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("onClick.cancelVerifyCode mVerifyObserver.seq=");
          if (this.mVerifyObserver == null) {
            break label653;
          }
        }
        for (int i = this.mVerifyObserver.getSeq();; i = 0)
        {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, i);
          anot.c(this.app, "dc00898", "", this.mUin, "0X800AA37", "0X800AA37", bEb, 0, "", "", "", "");
          afsf.a().a(this.mApp, this.mVerifyObserver);
          this.mVerifyObserver = null;
          finish();
          overridePendingTransition(0, 2130772013);
          break;
        }
      case 2131372756: 
        label653:
        if ((this.Fm <= 0L) || (System.currentTimeMillis() - this.Fm <= 0L) || (System.currentTimeMillis() - this.Fm >= 3000L))
        {
          this.Fm = System.currentTimeMillis();
          anot.c(this.app, "dc00898", "", this.mUin, "0X800AA36", "0X800AA36", bEb, 0, "", "", "", "");
          bGr();
        }
        break;
      }
    }
  }
  
  public void v(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevUgActivity
 * JD-Core Version:    0.7.0.1
 */