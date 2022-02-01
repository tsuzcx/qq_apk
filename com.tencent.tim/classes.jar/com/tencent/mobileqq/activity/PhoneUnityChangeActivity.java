package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acfp;
import ajdo;
import akwl;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqgv;
import aqiw;
import aqju;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vlu;
import yuu;

public class PhoneUnityChangeActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public ausj X;
  public ajdo a;
  public String aOD;
  public akwl c;
  public akwl d;
  public Button dn;
  public aqju mDialog;
  private int mSource;
  
  public boolean Qn()
  {
    Object localObject1 = (ajdo)this.app.getManager(11);
    int i = ((ajdo)localObject1).xy();
    localObject1 = ((ajdo)localObject1).a();
    if ((1 != i) && (5 != i)) {}
    try
    {
      this.aOD = ("" + ((RespondQueryQQBindingStat)localObject1).mobileNo);
      if (TextUtils.isEmpty(this.aOD))
      {
        super.finish();
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneUnityChangeActivity", 2, "" + i, localException);
        }
      }
      super.setTitle(acfp.m(2131709540));
      Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", yuu.hP(this.aOD));
      ((TextView)findViewById(2131380599)).setText((CharSequence)localObject2);
      this.dn = ((Button)findViewById(2131363809));
      this.dn.setOnClickListener(this);
      localObject2 = (ImageView)findViewById(2131369594);
      ((ImageView)localObject2).setVisibility(0);
      if (AppSetting.enableTalkBack) {
        ((ImageView)localObject2).setContentDescription(getString(2131696811));
      }
      i = 2130844509;
      if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        i = 2130840663;
      }
      ((ImageView)localObject2).setImageResource(i);
      ((ImageView)localObject2).setOnClickListener(this);
    }
    return true;
  }
  
  public void bSv()
  {
    if (this.X == null)
    {
      this.X = ((ausj)auss.a(this, null));
      this.X.setCanceledOnTouchOutside(true);
      this.X.addButton(acfp.m(2131709529), 3);
      this.X.addCancelButton(2131721058);
      this.X.a(new vlu(this));
      this.X.addCancelButton(2131721058);
    }
    if ((this.X != null) && (!this.X.isShowing()) && (!isFinishing())) {
      this.X.show();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      super.setResult(paramInt2);
      super.finish();
      return;
    }
    Qn();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent() == null) {
      super.finish();
    }
    do
    {
      return true;
      super.setContentView(2131559750);
      this.a = ((ajdo)this.app.getManager(11));
      this.mSource = getIntent().getIntExtra("kSrouce", -1);
    } while (Qn());
    super.finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.c != null)
    {
      this.app.unRegistObserver(this.c);
      this.c = null;
    }
    if (this.d != null)
    {
      this.app.unRegistObserver(this.d);
      this.d = null;
    }
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    if (this.X != null)
    {
      this.X.dismiss();
      this.X = null;
    }
    this.app.removeHandler(PhoneUnityChangeActivity.class);
    super.doOnDestroy();
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
      bSv();
      continue;
      if (aqiw.isNetSupport(this)) {
        break;
      }
      showToast(2131696348);
    }
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("kNeedUnbind", true);
    localIntent.putExtra("cmd_param_is_from_uni", true);
    localIntent.putExtra("cmd_param_is_from_change_bind", true);
    if (this.mSource != -1) {}
    for (int i = this.mSource;; i = 1)
    {
      localIntent.putExtra("kSrouce", i);
      localIntent.putExtra("kFPhoneChange", true);
      startActivityForResult(localIntent, 1001);
      anot.a(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      aqgv.Xr(1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity
 * JD-Core Version:    0.7.0.1
 */