package com.tencent.mobileqq.activity;

import afrz;
import afsb;
import afsf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uhk;
import uhl;

public class AuthDevOpenUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static boolean aRN;
  private String QW;
  private String aLa;
  private String aLc;
  private String aLd;
  private String aLe;
  private String aLf;
  private String aLg;
  private String aLh;
  private String aLi;
  private String aLj;
  private boolean aRL;
  private boolean aRM = true;
  private WtloginObserver jdField_b_of_type_MqqObserverWtloginObserver = new uhk(this);
  private DevlockInfo jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private int bDZ;
  private int bEa;
  private Button cl;
  private String mUin;
  VerifyDevLockManager.VerifyDevLockObserver mVerifyObserver = new uhl(this);
  
  public static boolean OH()
  {
    return aRN;
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    try
    {
      afsf.a().u(null, this.app.getCurrentAccountUin(), 3);
      afrz localafrz = afrz.a();
      if ((localafrz != null) && (localafrz.Dx() == afrz.cTE))
      {
        String str2 = "";
        String str1 = str2;
        if (paramDevlockInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(paramDevlockInfo.Mobile)) {
            str1 = paramDevlockInfo.Mobile;
          }
        }
        localafrz.E(this, str1);
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          if ((paramDevlockInfo == null) || (TextUtils.isEmpty(paramDevlockInfo.Mobile))) {
            break label440;
          }
          if ((paramDevlockInfo.AllowSet != 1) || (paramDevlockInfo.DevSetup == 1)) {
            break;
          }
          if (afsf.a().a(this.app, this.app.getCurrentAccountUin(), "", null, this.jdField_b_of_type_MqqObserverWtloginObserver) != 0) {
            QQToast.a(getApplicationContext(), getString(2131693218), 0).show(getTitleBarHeight());
          }
        } while (!aRN);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "BIND_AND_CREDIT_NOT_OPEN_DEVLOCK" });
        afsf.a().v(null, this.app.getCurrentAccountUin(), 9);
        finish();
        startActivity(new Intent(this, LoginInfoActivity.class));
        return;
        if (paramDevlockInfo.DevSetup != 1) {
          break;
        }
      } while (!aRN);
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "OPENED_DEVLOCK" });
      finish();
      startActivity(new Intent(this, LoginInfoActivity.class));
      return;
      if (aRN)
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "BIND_BUT_CREDIT_NOT_OPEN_DEVLOCK" });
        afsf.a().v(null, this.app.getCurrentAccountUin(), 7);
      }
      Intent localIntent = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
      if (getIntent() != null) {
        localIntent.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
      }
      localIntent.putExtra("ParaTextUp", this.aLh);
      localIntent.putExtra("ParaTextDown", this.aLi);
      localIntent.putExtra("PhoneNO", paramDevlockInfo.Mobile);
      localIntent.putExtra("mainaccount", this.aLa);
      localIntent.putExtra("uin", this.mUin);
      localIntent.putExtra("from_where", this.QW);
      localIntent.putExtra("DevlockInfo", paramDevlockInfo);
      startActivityForResult(localIntent, 1001);
      overridePendingTransition(0, 2130772009);
      return;
      label440:
      if (aRN)
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "NO_BIND_AND_NO_CREDIT_NOT_OPEN_DEVLOCK" });
        afsf.a().v(null, this.app.getCurrentAccountUin(), 6);
      }
      afsb.a(this, this.app, afsb.cTJ, 1003, null);
    }
  }
  
  private void aD(String paramString)
  {
    for (;;)
    {
      int i;
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        this.aLc = paramString.getString("title");
        this.aLd = paramString.getString("smallTitle");
        this.aLe = paramString.getString("guideTitle");
        paramString = paramString.getJSONArray("guideArray");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            str = paramString.getString(i);
            if (i == 0) {
              this.aLf = str;
            } else if (i == 1) {
              this.aLg = str;
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "parseJson error.");
        }
      }
      return;
      if (i == 2) {
        this.aLh = str;
      } else if (i == 3) {
        this.aLi = str;
      }
      i += 1;
    }
  }
  
  private void an(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = getIntent();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((Intent)localObject1).getExtras();
    } while ((localObject1 == null) || (!((Bundle)localObject1).containsKey("devlock_need_broadcast")) || (!((Bundle)localObject1).getBoolean("devlock_need_broadcast")));
    localObject1 = new Intent();
    ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
    ((Intent)localObject1).putExtra("auth_dev_open", paramBoolean);
    ((Intent)localObject1).putExtra("auth_dev_open_cb_reason", paramInt);
    if (paramBoolean)
    {
      Object localObject2 = (WtloginManager)this.app.getManager(1);
      if (localObject2 != null)
      {
        localObject2 = ((WtloginManager)localObject2).GetLocalTicket(this.app.getCurrentAccountUin(), 16L, 33554432);
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("devlock_roam_sig", ((Ticket)localObject2)._sig);
        }
      }
    }
    sendBroadcast((Intent)localObject1, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  private boolean u(Bundle paramBundle)
  {
    return "true".equals(paramBundle.getString("AUTH_DEV_OPEN_UG_ACTIVITY"));
  }
  
  private void uY(String paramString)
  {
    Object localObject = (TextView)findViewById(2131368276);
    if (TextUtils.isEmpty(paramString))
    {
      ((TextView)localObject).setVisibility(8);
      localObject = this.cl;
      if (TextUtils.isEmpty(this.aLd)) {
        break label178;
      }
    }
    label178:
    for (paramString = this.aLd;; paramString = getString(2131693211))
    {
      ((Button)localObject).setText(paramString);
      this.cl.setContentDescription(getString(2131693169));
      if (!TextUtils.isEmpty(this.aLe)) {
        setTitle(this.aLe);
      }
      if (this.bEa != 0)
      {
        paramString = (ImageView)findViewById(2131368254);
        if (paramString != null) {
          paramString.setImageResource(this.bEa);
        }
      }
      if (!TextUtils.isEmpty(this.aLj))
      {
        paramString = (Button)findViewById(2131368255);
        if (paramString != null)
        {
          paramString.setVisibility(0);
          paramString.setText(this.aLj);
          paramString.setOnClickListener(this);
        }
      }
      afsf.a().u(null, this.app.getCurrentAccountUin(), 1);
      return;
      ((TextView)localObject).setText(paramString);
      break;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if ((paramIntent == null) || (paramIntent.getExtras().getInt("requestCode") != 1002)) {
          break label46;
        }
        v(-1, paramIntent);
      }
    }
    label46:
    label835:
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
                  an(true, 0);
                  if (afsf.a().ajT())
                  {
                    paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
                    if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                    {
                      paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                      paramIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                    }
                    if (aRN) {
                      paramIntent.putExtra("h5_flag", true);
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
                    v(-1, paramIntent);
                    return;
                    if (this.aRM)
                    {
                      paramIntent = new Intent(this, AuthDevActivity.class);
                      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      if (getIntent() != null) {
                        paramIntent.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
                      }
                      paramIntent.putExtra("auth_dev_open", true);
                      if (aRN) {
                        paramIntent.putExtra("h5_flag", true);
                      }
                      startActivity(paramIntent);
                    }
                  }
                  if (paramInt1 != 1002) {
                    break;
                  }
                } while (paramInt2 != -1);
                finish();
                return;
                if (paramInt1 != 1003) {
                  break label835;
                }
                if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
                  break;
                }
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              String str = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
              }
              if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
              }
            } while (!bool);
            afsf.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
            an(true, 0);
            boolean bool = afsf.a().ajT();
            paramIntent = new Intent(getIntent());
            if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
            {
              paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              paramIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            if (bool)
            {
              paramIntent.setClass(this, AuthDevEnableCompleteActivity.class);
              startActivity(paramIntent);
            }
            for (;;)
            {
              QQToast.a(getApplicationContext(), 2, getString(2131693163), 0).show(getTitleBarHeight());
              paramIntent = new Intent();
              paramIntent.putExtra("auth_dev_open", true);
              paramIntent.putExtra("allow_set", true);
              if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                paramIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              }
              v(-1, paramIntent);
              return;
              if (this.aRM)
              {
                paramIntent.setClass(this, AuthDevActivity.class);
                paramIntent.putExtra("auth_dev_open", true);
                startActivity(paramIntent);
              }
            }
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          afsf.a().a(this.app, this.app.getCurrentAccountUin(), null);
        }
      } while (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
      return;
    } while (paramInt1 != 1004);
    if (paramInt2 == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd failed");
      }
      an(false, 3);
      finish();
      overridePendingTransition(2130771989, 2130771990);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd succ");
    }
    if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
    {
      afsf.a().a(this.app, this.app.getCurrentAccountUin(), this.jdField_b_of_type_MqqObserverWtloginObserver);
      return;
    }
    a(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    Bundle localBundle = ((Intent)localObject).getExtras();
    if (localBundle == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    aRN = u(localBundle);
    afsf.a().Ik(false);
    localObject = localBundle.getString("devlock_open_source");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "Manually";
    }
    for (;;)
    {
      afsf.a().Ig((String)localObject);
      this.aRL = localBundle.getBoolean("from_login");
      this.bDZ = localBundle.getInt("seq");
      this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)localBundle.get("DevlockInfo"));
      this.mUin = localBundle.getString("uin");
      this.QW = localBundle.getString("from_where");
      this.aLa = localBundle.getString("mainaccount");
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate mIsFromLogin = " + this.aRL + " mVerifySeq=" + this.bDZ + " mUin=" + this.mUin + " mFromWhere=" + this.QW + " mMainAccount=" + this.aLa);
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
        }
      }
      super.doOnCreate(paramBundle);
      super.setContentView(2131561308);
      super.setTitle(2131693215);
      if (this.app == null) {
        this.app = ((QQAppInterface)getAppRuntime());
      }
      if (this.app == null)
      {
        super.doOnCreate(paramBundle);
        finish();
        return false;
      }
      if (TextUtils.equals((CharSequence)localObject, "PhoneUnity")) {
        this.leftView.setText(2131701652);
      }
      this.cl = ((Button)findViewById(2131381180));
      this.cl.setOnClickListener(this);
      this.aRM = localBundle.getBoolean("devlock_show_auth_dev_list", true);
      paramBundle = localBundle.getString("devlock_guide_config");
      if (!TextUtils.isEmpty(paramBundle)) {}
      for (;;)
      {
        try
        {
          paramBundle = new JSONObject(paramBundle);
          this.aLe = paramBundle.getString("title");
          this.aLc = paramBundle.getString("wording");
          this.bEa = paramBundle.getInt("image_res_id");
          this.aLd = paramBundle.getString("btn_text");
          this.aLj = paramBundle.getString("jump_text");
          if (TextUtils.isEmpty(this.aLc)) {
            this.aLc = getString(2131693210);
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
          uY(this.aLc);
          this.mVerifyObserver.setSeq(this.bDZ);
          return true;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          continue;
        }
        if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          aD(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
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
  
  public boolean onBackEvent()
  {
    an(false, 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    if ((this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
      localIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    }
    v(0, localIntent);
    if (aRN) {
      startActivity(new Intent(this, LoginInfoActivity.class));
    }
    return false;
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
      if (this.app != null) {
        this.app.sendWirelessMeibaoReq(1);
      }
      if (mAppForground)
      {
        if ((!TextUtils.isEmpty(this.QW)) && (this.QW.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "subaccount enter webview mUin=" + this.mUin + " mMainAccount=" + this.aLa);
          }
          if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
          }
          afsb.f(this, this.aLa, this.mUin, afsb.cTH);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mainaccount enter webview mUin=" + this.mUin);
          }
          if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
          }
          afsb.f(this, this.mUin, this.mUin, afsb.cTH);
        }
      }
      else
      {
        afsb.a(this, this.app, afsb.cTH);
        continue;
        anot.a(null, "dc00898", "", "", "0X800A71F", "0X800A71F", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "点击打开设备锁上报！0X800A71F");
        }
        Object localObject;
        if (getIntent().getBooleanExtra("open_devlock_verify_passwd", false))
        {
          localObject = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "open_devlock"));
          startActivityForResult((Intent)localObject, 1004);
        }
        for (;;)
        {
          localObject = getIntent().getStringExtra("devlock_open_source");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).equals("RoamMsg")) && (!((String)localObject).equals("RoamMsgWeb")))) {
            break;
          }
          VipUtils.a(this.app, "chat_history", "LockSet", "Clk_buttonUse", 1, 0, new String[0]);
          break;
          if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) {
            afsf.a().a(this.app, this.app.getCurrentAccountUin(), this.jdField_b_of_type_MqqObserverWtloginObserver);
          } else {
            a(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onClick.cancelVerifyCode mVerifyObserver.seq=" + this.mVerifyObserver.getSeq());
        }
        afsf.a().a(this.app, this.mVerifyObserver);
        this.mVerifyObserver = null;
        finish();
        overridePendingTransition(0, 2130772013);
        an(false, 2);
        finish();
        overridePendingTransition(2130771989, 2130771990);
      }
    }
  }
  
  public void v(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    if (getIntent().getBooleanExtra("open_devlock_from_roam", false))
    {
      finish();
      overridePendingTransition(2130771989, 2130771990);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevOpenUgActivity
 * JD-Core Version:    0.7.0.1
 */