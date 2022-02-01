package com.tencent.mobileqq.activity;

import acfp;
import altz;
import alub;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anot;
import aqwc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import vsc;
import vsd;

public class RegisterSendUpSms
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private altz jdField_a_of_type_Altz;
  private alub jdField_a_of_type_Alub;
  private String aPt;
  private String aPu;
  private String aPv;
  private String aPw;
  private String aPx;
  private MqqHandler b = new vsc(this);
  private int bKB = -1;
  private int bKC = 10;
  private AccountObserver d = new vsd(this);
  private Button dc;
  private int mState = 0;
  private Runnable runnableCountdown = new RegisterSendUpSms.2(this);
  
  private void bVe()
  {
    anot.a(this.app, "new_reg", "send_msg", "next_clk", "", 1, "");
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      if (this.jdField_a_of_type_Alub == null) {
        this.jdField_a_of_type_Alub = new alub(this);
      }
      getIntent().putExtra("key_register_smscode", this.aPt);
      getIntent().putExtra("key_register_autologin", true);
      this.jdField_a_of_type_Alub.dI(getIntent());
      return;
    }
    if (this.aRQ)
    {
      Intent localIntent = new Intent(this, RegisterChooseLoginActivity.class);
      localIntent.putExtra("phonenum", this.phoneNum);
      localIntent.putExtra("invite_code", this.aLv);
      localIntent.putExtra("key", this.countryCode);
      localIntent.putExtra("key_register_smscode", this.aPt);
      localIntent.putExtra("key_register_binded_qq", this.aPv);
      localIntent.putExtra("key_register_binded_qq_nick", this.aPw);
      localIntent.putExtra("key_register_binded_qq_face_url", this.aPx);
      localIntent.putExtra("key_register_has_pwd", this.aRR);
      localIntent.putExtra("key_register_from", 4);
      startActivity(localIntent);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.app, this, this.phoneNum, this.countryCode, this.aPt, true, false, false, this.aLv, 4, "", "", true);
  }
  
  private void du(String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setData(Uri.parse("smsto:"));
      localIntent1.setType("vnd.android-dir/mms-sms");
      localIntent1.putExtra("address", paramString1);
      localIntent1.putExtra("sms_body", paramString2);
      startActivity(localIntent1);
      if (QLog.isColorLevel()) {
        QLog.d("RegisterSendUpSms", 2, String.format("sendSMS phoneNum:%s, msgBody:%s", new Object[] { paramString1, paramString2 }));
      }
      anot.a(this.app, "new_reg_805", "send_msg", "send_clk", "", 1, "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Intent localIntent2 = new Intent("android.intent.action.SENDTO");
        localIntent2.setData(Uri.parse("smsto:" + paramString1));
        localIntent2.putExtra("sms_body", paramString2);
        startActivity(localIntent2);
      }
    }
  }
  
  private void ws(String paramString)
  {
    int i = 0;
    try
    {
      paramString = new JSONObject(paramString);
      this.aPt = paramString.getString("upmsg");
      Object localObject;
      if (!TextUtils.isEmpty(this.aPt))
      {
        localObject = (TextView)super.findViewById(2131381109);
        if (localObject != null) {
          ((TextView)localObject).setText(this.aPt);
        }
      }
      this.aPu = paramString.getString("upnum");
      if (!TextUtils.isEmpty(this.aPu))
      {
        paramString = (TextView)super.findViewById(2131381111);
        if (paramString != null)
        {
          localObject = new StringBuilder();
          int k = this.aPu.length() / 4;
          int j = 0;
          while (i < k)
          {
            ((StringBuilder)localObject).append(this.aPu.substring(j, j + 4));
            ((StringBuilder)localObject).append(" ");
            j += 4;
            i += 1;
          }
          ((StringBuilder)localObject).append(this.aPu.substring(j));
          paramString.setText(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562987);
    tK(2131717108);
    bVd();
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      Bw(90);
      this.app.setHandler(RegisterSendUpSms.class, this.b);
      Intent localIntent = super.getIntent();
      if (localIntent != null)
      {
        this.phoneNum = localIntent.getStringExtra("phonenum");
        this.aLv = localIntent.getStringExtra("invite_code");
        this.countryCode = localIntent.getStringExtra("key");
        this.aRQ = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
        this.aRR = getIntent().getBooleanExtra("key_register_has_pwd", true);
        this.aPv = getIntent().getStringExtra("key_register_binded_qq");
      }
      if (QLog.isDevelopLevel()) {
        aqwc.h(getClass().getSimpleName(), getIntent());
      }
      this.aPt = super.getString(2131717109);
      this.aPu = super.getString(2131717110);
      this.dc = ((Button)super.findViewById(2131363966));
      if (this.dc != null) {
        this.dc.setOnClickListener(this);
      }
      paramBundle = "";
      if (localIntent != null) {
        paramBundle = localIntent.getStringExtra("key_register_prompt_info");
      }
      if (!TextUtils.isEmpty(paramBundle)) {
        ws(paramBundle);
      }
      anot.c(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 0, 0, "", "", "", "");
      if (this.aRQ) {
        break label398;
      }
      anot.c(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 1, 0, "", "", "", "");
      label302:
      if (!TextUtils.isEmpty(this.aPv)) {
        anot.c(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 3, 0, "", "", "", "");
      }
      if (this.mFrom != 7) {
        break label438;
      }
      anot.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      Bw(50);
      break;
      label398:
      if (this.aRR) {
        break label302;
      }
      anot.c(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 2, 0, "", "", "", "");
      break label302;
      label438:
      anot.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "doOnResume mState: %s, mQuerySMSStatusRetCode: %s", new Object[] { Integer.valueOf(this.mState), Integer.valueOf(this.bKB) }));
    }
    if ((this.mState == 1) && (this.bKB != 0))
    {
      AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
      if (localAccountManager != null) {
        localAccountManager.queryUpSmsStat(this.d);
      }
      this.dc.setEnabled(false);
      this.dc.setText(acfp.m(2131713828) + "(" + this.bKC + "s)");
      this.handler.postDelayed(this.runnableCountdown, 1000L);
    }
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onResume();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onAccountChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "onClick mState: %s, mQuerySMSStatusRetCode: %s", new Object[] { Integer.valueOf(this.mState), Integer.valueOf(this.bKB) }));
    }
    if (this.mState == 0)
    {
      du(this.aPu, this.aPt);
      this.bKB = -1;
      this.mState = 1;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mState == 1) {
        if (this.bKB == 0)
        {
          bVe();
        }
        else
        {
          AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
          if (localAccountManager != null) {
            localAccountManager.queryUpSmsStat(this.d);
          }
          this.dc.setEnabled(false);
          this.dc.setText(acfp.m(2131713830) + "(" + this.bKC + "s)");
          this.handler.postDelayed(this.runnableCountdown, 1000L);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.removeHandler(RegisterSendUpSms.class);
    if (this.jdField_a_of_type_Altz != null) {
      this.jdField_a_of_type_Altz.onDestroy();
    }
    this.jdField_a_of_type_Altz = null;
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onDestroy();
    }
    this.jdField_a_of_type_Alub = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */