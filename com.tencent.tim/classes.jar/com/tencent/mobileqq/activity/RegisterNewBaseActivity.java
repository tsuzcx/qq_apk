package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import arie;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;
import vrp;
import vrr;

public class RegisterNewBaseActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  public String aLv;
  public boolean aRQ;
  public boolean aRR = true;
  public String countryCode = "86";
  protected Dialog dialog;
  public Handler handler = new vrp(this);
  public int mFrom = -1;
  protected View.OnClickListener onBackListeger = new vrr(this);
  public String phoneNum;
  
  public void Bv(int paramInt)
  {
    try
    {
      this.handler.post(new RegisterNewBaseActivity.4(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void Bw(int paramInt)
  {
    ((ProgressBar)findViewById(2131377074)).setProgress(paramInt);
  }
  
  public void J(int paramInt1, int paramInt2)
  {
    new arie(this).V(paramInt1, getTitleBarHeight(), 1, paramInt2);
  }
  
  protected void bVd()
  {
    TextView localTextView = (TextView)findViewById(2131364121);
    localTextView.setOnClickListener(this.onBackListeger);
    if (AppSetting.enableTalkBack) {
      localTextView.setContentDescription(getResources().getString(2131691039));
    }
  }
  
  public void cq(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    new arie(this).p(str, getTitleBarHeight(), 0, paramInt);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(1024);
    this.mFrom = getIntent().getIntExtra("key_register_from", -1);
    return true;
  }
  
  public void dt(String paramString1, String paramString2)
  {
    try
    {
      this.handler.post(new RegisterNewBaseActivity.2(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void gV()
  {
    this.handler.post(new RegisterNewBaseActivity.3(this));
  }
  
  public String oX()
  {
    return this.phoneNum;
  }
  
  public String oY()
  {
    return this.aLv;
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface.dismiss();
  }
  
  protected void setTitleText(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131381095);
    localTextView.setText(paramString);
    if (AppSetting.enableTalkBack) {
      localTextView.setContentDescription(paramString);
    }
  }
  
  protected void tK(int paramInt)
  {
    TextView localTextView = (TextView)findViewById(2131381095);
    String str = getResources().getString(paramInt);
    localTextView.setText(str);
    if (AppSetting.enableTalkBack) {
      localTextView.setContentDescription(str);
    }
  }
  
  protected void xW(boolean paramBoolean)
  {
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131377074);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  public void xX(boolean paramBoolean)
  {
    MqqHandler localMqqHandler = this.app.getHandler(RegisterChooseLoginActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(105);
    }
    localMqqHandler = this.app.getHandler(RegisterSendUpSms.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(107);
    }
    localMqqHandler = this.app.getHandler(RegisterVerifyCodeActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(106);
    }
    localMqqHandler = this.app.getHandler(RegisterPhoneNumActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(103);
    }
    if (paramBoolean)
    {
      localMqqHandler = this.app.getHandler(RegisterPersonalInfoActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(109);
      }
      localMqqHandler = this.app.getHandler(RegisterByNicknameAndPwdActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(109);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */