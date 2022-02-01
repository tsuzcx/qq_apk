package com.tencent.mobileqq.activity;

import acfp;
import akwl;
import akwn;
import akwp;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqiw;
import aqwc;
import aqwf;
import aqwp.a;
import arhz;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import vrz;
import vsa;
import vsb;

public class RegisterQQNumberActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private TextView Fy;
  akwl jdField_a_of_type_Akwl = new vsa(this);
  private aqwf jdField_a_of_type_Aqwf;
  private String aLw;
  private boolean aRS;
  private boolean aRT;
  private boolean aRU;
  private boolean aRV = true;
  private boolean aRW = true;
  private boolean aRX;
  private boolean aRY;
  private boolean aRZ;
  private byte[] bW;
  private byte[] bX;
  private AccountObserver jdField_c_of_type_MqqObserverAccountObserver = new vsb(this);
  WtloginObserver jdField_c_of_type_MqqObserverWtloginObserver = new vrz(this);
  private String mUin;
  private arhz w;
  
  private void bGA()
  {
    akwp.a().Nq(true);
    akwp.a().b(this.app, this.countryCode, this.phoneNum, this.jdField_c_of_type_MqqObserverWtloginObserver);
  }
  
  private void bwV()
  {
    this.handler.post(new RegisterQQNumberActivity.6(this));
  }
  
  private void iF(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    if (this.aRU) {
      anot.c(this.app, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    if (!this.aRQ) {
      anot.c(this.app, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("key_register_from_send_sms", false))
      {
        if (bool) {
          break;
        }
        anot.c(this.app, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
      }
      return;
      if (!this.aRR) {
        anot.c(this.app, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
      } else if (!bool) {
        anot.c(this.app, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
      } else {
        anot.c(this.app, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
      }
    }
    anot.c(this.app, "dc00898", "", "", paramString, paramString, 7, 0, "", "", "", "");
  }
  
  private void initViews()
  {
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    View localView;
    if (this.aRV)
    {
      i = 2131717136;
      tK(i);
      bVd();
      Bw(100);
      localObject1 = (ImageView)findViewById(2131375317);
      ((ImageView)localObject1).setVisibility(0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).rightMargin = ((int)(10.0F * getResources().getDisplayMetrics().density));
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject5 = (ImageView)findViewById(2131375317);
      localObject3 = (TextView)findViewById(2131381120);
      this.Fy = ((TextView)findViewById(2131381107));
      localObject4 = (Button)findViewById(2131363894);
      ((Button)localObject4).setOnClickListener(this);
      localObject2 = (TextView)findViewById(2131373081);
      localObject1 = (TextView)findViewById(2131372479);
      localView = findViewById(2131369362);
      if (this.aRV) {
        break label386;
      }
      ((ImageView)localObject5).setImageResource(2130847837);
      ((TextView)localObject3).setVisibility(8);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131375312);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(50.0F * getResources().getDisplayMetrics().density));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      this.Fy.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.Fy.setTextSize(2, 20.0F);
      this.Fy.setText(2131717040);
      ((TextView)localObject2).setVisibility(8);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131381107);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(50.0F * getResources().getDisplayMetrics().density));
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((Button)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((Button)localObject4).setText(2131720564);
      ((TextView)localObject1).setVisibility(8);
    }
    label386:
    do
    {
      return;
      i = 2131717039;
      break;
      this.Fy.setText(this.mUin);
      if (this.aRU) {
        if (!TextUtils.isEmpty(this.aLw))
        {
          localObject4 = new SpannableString(String.format(getString(2131717122), new Object[] { this.aLw }));
          ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 8, this.aLw.length() + 8, 33);
          ((TextView)localObject2).setText((CharSequence)localObject4);
        }
      }
      while (this.aRW)
      {
        ((TextView)localObject3).setText(2131717087);
        ((TextView)localObject1).setVisibility(8);
        return;
        ((TextView)localObject2).setVisibility(8);
        continue;
        if (!this.aRT)
        {
          localObject4 = "+" + this.countryCode + " " + this.phoneNum.substring(0, 3) + "-" + this.phoneNum.substring(3, 7) + "-" + this.phoneNum.substring(7);
          localObject5 = new SpannableString(String.format(getString(2131717078), new Object[] { localObject4 }));
          ((SpannableString)localObject5).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 9, ((String)localObject4).length() + 9, 33);
          ((TextView)localObject2).setText((CharSequence)localObject5);
        }
        else
        {
          ((TextView)localObject2).setVisibility(8);
        }
      }
      ((TextView)localObject3).setText(2131717085);
      ((TextView)localObject1).setVisibility(0);
    } while (TextUtils.isEmpty(this.aLv));
    localView.setVisibility(0);
  }
  
  private void showProgressDialog()
  {
    this.handler.post(new RegisterQQNumberActivity.5(this));
  }
  
  private void startMainActivity()
  {
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
    ((Intent)localObject).putExtra("fragment_id", 1);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
    localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
  }
  
  public void aO(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.mUin))) {
      return;
    }
    this.aRX = paramBoolean;
    if ((!this.aRX) && (this.aRY))
    {
      bwV();
      J(2131717084, 0);
    }
    for (;;)
    {
      this.aRY = false;
      this.aRZ = false;
      return;
      if ((this.aRX) && (this.aRY)) {
        if (this.aRT) {
          getAppRuntime().login(this.mUin, this.bX, this.jdField_c_of_type_MqqObserverAccountObserver);
        } else {
          akwn.a(this.app, this.bW, this.mUin);
        }
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged success");
    }
    if (this.aRT)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
      if (this.aRU)
      {
        this.app = ((QQAppInterface)getAppRuntime());
        LoginActivity.o(this.app, this.app.getAccount());
      }
      startMainActivity();
      bwV();
    }
    do
    {
      return;
      if (akwp.a().asQ()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged not phonenum login");
    return;
    this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_Akwl);
    if (this.aRS)
    {
      this.app.execute(new RegisterQQNumberActivity.1(this));
      QQToast.a(BaseApplicationImpl.sApplication, acfp.m(2131713842), 0).show();
    }
    LoginActivity.o(this.app, this.app.getAccount());
    startMainActivity();
    bwV();
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
      anot.a(this.app, "CliOper", "", "", "0X8006655", "0X8006655", 0, 0, "", "", "", "");
      anot.a(this.app, "new_reg", "result_page", "login_clk", "", 1, "", this.mUin, "", "", "", "", "", "", " ");
      if (this.aRV)
      {
        anot.c(this.app, "dc00898", "", "", "0X8007CCB", "0X8007CCB", 0, 0, "", "", "", "");
        iF("0X8007CCB");
        if (this.aRU) {
          anot.c(this.app, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
        }
        if (!aqiw.isNetSupport(BaseApplication.getContext())) {
          J(2131693404, 0);
        }
      }
      else
      {
        finish();
        continue;
      }
      if ((this.aRW) && (!this.aRX))
      {
        if (!this.aRZ)
        {
          this.aRZ = true;
          if (this.jdField_a_of_type_Aqwf == null) {
            this.jdField_a_of_type_Aqwf = new aqwf(this, null);
          }
          this.jdField_a_of_type_Aqwf.a(this.mUin, new a(this));
        }
        this.aRY = true;
        showProgressDialog();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("RegisterQQNumberActivity", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
        }
        showProgressDialog();
        if (QLog.isColorLevel())
        {
          if (this.bW == null) {
            break label386;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RegisterQQNumberActivity", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.bW));
          }
        }
        for (;;)
        {
          if (!this.aRT) {
            break label405;
          }
          getAppRuntime().login(this.mUin, this.bX, this.jdField_c_of_type_MqqObserverAccountObserver);
          break;
          label386:
          if (QLog.isColorLevel()) {
            QLog.d("RegisterQQNumberActivity", 2, "swz mSign = null");
          }
        }
        label405:
        if (QLog.isDevelopLevel()) {
          QLog.d("RegisterQQNumberActivity", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.mUin, com.tencent.qphone.base.util.MD5.toMD5(this.bW) }));
        }
        akwn.a(this.app, this.bW, this.mUin);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131562061);
    if (QLog.isDevelopLevel()) {
      aqwc.h(getClass().getSimpleName(), getIntent());
    }
    this.aRU = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    if (this.aRU) {
      this.aLw = getIntent().getStringExtra("key_register_secret_phone");
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.aLv = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.aRQ = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.aRR = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.mUin = getIntent().getStringExtra("uin");
    this.bW = getIntent().getByteArrayExtra("key_register_sign");
    String str;
    if (QLog.isDevelopLevel())
    {
      localObject1 = Locale.getDefault();
      localObject2 = this.mUin;
      str = com.tencent.qphone.base.util.MD5.toMD5(this.bW);
      if (this.aLv != null) {
        break label339;
      }
    }
    label339:
    for (paramBundle = "";; paramBundle = this.aLv)
    {
      QLog.d("RegisterQQNumberActivity", 4, String.format((Locale)localObject1, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { localObject2, str, paramBundle }));
      paramBundle = getIntent().getStringExtra("key_register_password");
      if (paramBundle != null) {
        this.bX = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte(paramBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "onCreate ,pwd = " + paramBundle + ",mPassByte = " + this.bX);
      }
      this.aRT = getIntent().getBooleanExtra("key_register_unbind", false);
      if (this.app != null) {
        break;
      }
      QLog.d("RegisterQQNumberActivity", 2, "onCreate app is null");
      finish();
      return;
    }
    this.app.registObserver(this.jdField_a_of_type_Akwl);
    this.aRV = getIntent().getBooleanExtra("key_register_result", true);
    this.aRW = getIntent().getBooleanExtra("key_register_is_lh", false);
    if ((this.aRV) && (this.aRW))
    {
      this.aRY = false;
      this.aRZ = true;
      this.jdField_a_of_type_Aqwf = new aqwf(this, null);
      this.jdField_a_of_type_Aqwf.a(this.mUin, new a(this));
    }
    initViews();
    xX(true);
    anot.a(this.app, "CliOper", "", "", "0X8006654", "0X8006654", 0, 0, "", "", "", "");
    Object localObject2 = this.app;
    if (this.aRV)
    {
      paramBundle = "0X800735F";
      if (!this.aRV) {
        break label586;
      }
    }
    label586:
    for (Object localObject1 = "0X800735F";; localObject1 = "0X8007CCA")
    {
      anot.c((QQAppInterface)localObject2, "dc00898", "", "", paramBundle, (String)localObject1, 0, 0, "", "", "", "");
      anot.a(this.app, "new_reg", "result_page", "page_exp", "", 1, "", this.mUin, "", "", "", "", "", "", "");
      iF("0X800735F");
      return;
      paramBundle = "0X8007CCA";
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
    }
    gV();
    bwV();
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      if ((this.w != null) && (this.w.isShowing()))
      {
        this.w.dismiss();
        this.w.cancel();
      }
      this.w = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  static class a
    implements aqwp.a
  {
    private final WeakReference<RegisterQQNumberActivity> mRef;
    
    a(RegisterQQNumberActivity paramRegisterQQNumberActivity)
    {
      this.mRef = new WeakReference(paramRegisterQQNumberActivity);
    }
    
    public void aP(String paramString, boolean paramBoolean)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        if (QLog.isColorLevel()) {
          QLog.i("RegisterQQNumberActivity", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
        }
      }
      RegisterQQNumberActivity localRegisterQQNumberActivity;
      do
      {
        return;
        localRegisterQQNumberActivity = (RegisterQQNumberActivity)this.mRef.get();
      } while (localRegisterQQNumberActivity == null);
      localRegisterQQNumberActivity.aO(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity
 * JD-Core Version:    0.7.0.1
 */