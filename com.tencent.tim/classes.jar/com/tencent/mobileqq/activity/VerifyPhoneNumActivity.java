package com.tencent.mobileqq.activity;

import acfp;
import akwl;
import akwn;
import akwp;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import wfl;
import wfm;
import wfn;

public class VerifyPhoneNumActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView GX;
  private String aRM;
  private String aRN;
  private boolean aRS;
  private byte[] bW;
  WtloginObserver c = new wfm(this);
  private ViewGroup cX;
  private String countryCode;
  private Button dJ;
  private Button dK;
  protected Dialog dialog;
  private akwl e = new wfn(this);
  private Handler handler = new Handler();
  private Handler mHandler = new wfl(this);
  private String mUin;
  private String phonenum;
  private arhz w;
  
  private void bGA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
    }
    akwp.a().Nq(true);
    int i = akwp.a().b(this.app, this.countryCode, this.phonenum, this.c);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyPhoneNumActivity", 4, "startLogin.GetStViaSMSVerifyLogin ret =" + i);
      }
      bwV();
      bUW();
    }
  }
  
  private void bUW()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.mUin);
    localIntent.putExtra("password", this.aRN);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void bXI()
  {
    akwn.b(this.app, this.bW, this.mUin);
  }
  
  private void bwV()
  {
    this.handler.post(new VerifyPhoneNumActivity.8(this));
  }
  
  private void initViews()
  {
    this.leftView.setVisibility(8);
    this.dJ = ((Button)this.cX.findViewById(2131363805));
    this.dJ.setOnClickListener(this);
    this.dK = ((Button)this.cX.findViewById(2131363923));
    this.dK.setOnClickListener(this);
    this.GX = ((TextView)this.cX.findViewById(2131381067));
    try
    {
      if ((this.aRM != null) && (this.aRM.length() > 4))
      {
        String str = "***" + this.aRM.substring(this.aRM.length() - 4, this.aRM.length());
        str = getString(2131696817, new Object[] { this.phonenum, str, this.mUin });
        this.GX.setText(str);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void showProgressDialog()
  {
    this.handler.post(new VerifyPhoneNumActivity.7(this));
  }
  
  private void startMainActivity()
  {
    Object localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.cX = ((ViewGroup)setContentViewB(2131563307));
    setTitle(2131696870);
    this.phonenum = getIntent().getStringExtra("phonenum");
    this.countryCode = getIntent().getStringExtra("key");
    this.aRM = getIntent().getStringExtra("key_register_binduin");
    this.mUin = getIntent().getStringExtra("uin");
    this.bW = getIntent().getByteArrayExtra("key_register_sign");
    this.aRN = getIntent().getStringExtra("key_register_password");
    this.app.registObserver(this.e);
    initViews();
    setRightButton(2131721058, this);
    return true;
  }
  
  public void gV()
  {
    try
    {
      this.mHandler.post(new VerifyPhoneNumActivity.2(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
    if (isFinishing()) {
      return;
    }
    if (!akwp.a().asQ())
    {
      QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
      return;
    }
    this.app.unRegistObserver(this.e);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.e);
    if (this.aRS)
    {
      this.app.execute(new VerifyPhoneNumActivity.4(this));
      QQToast.a(BaseApplicationImpl.sApplication, acfp.m(2131716324), 0).show();
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
      showProgressDialog();
      bXI();
      continue;
      showProgressDialog();
      bGA();
      continue;
      bUW();
      finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    this.app.unRegistObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */