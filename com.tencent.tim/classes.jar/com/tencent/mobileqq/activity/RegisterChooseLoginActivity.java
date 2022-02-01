package com.tencent.mobileqq.activity;

import altz;
import alub;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqbn;
import aqha;
import aqju;
import aqwc;
import arhz;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import vrl;
import vrm;
import vrn;
import vro;
import wja;

public class RegisterChooseLoginActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private TextView Fv;
  private altz jdField_a_of_type_Altz;
  private alub jdField_a_of_type_Alub;
  private String aPq;
  private String aPr;
  private boolean aZZ;
  private boolean baa;
  public boolean bab;
  private InputMethodManager jdField_c_of_type_AndroidViewInputmethodInputMethodManager;
  private AccountObserver jdField_c_of_type_MqqObserverAccountObserver = new vro(this);
  public int mFrom;
  private String mSmsCode;
  private MqqHandler u = new vrl(this);
  private arhz w;
  
  private void bVc()
  {
    aqha.a(this, 0, null, super.getResources().getString(2131717059, new Object[] { "+" + this.countryCode + " " + this.phoneNum }), super.getResources().getString(2131717021), super.getResources().getString(2131717041), null, new vrm(this), new vrn(this)).show();
  }
  
  private void bwV()
  {
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
  
  private void xU(boolean paramBoolean)
  {
    this.bab = paramBoolean;
    if (paramBoolean)
    {
      super.setTitle(2131717095);
      this.Fv.setVisibility(8);
      return;
    }
    super.setTitle(2131717098);
    this.Fv.setVisibility(0);
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  private void xV(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "gotoRegisterByNickAndPwd ,isPhoneNumBindNewQQ=" + paramBoolean);
    }
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      if (this.jdField_a_of_type_Alub == null) {
        this.jdField_a_of_type_Alub = new alub(this);
      }
      this.jdField_a_of_type_Alub.dI(getIntent());
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.app, this, this.phoneNum, this.countryCode, this.mSmsCode, true, this.aRR, false, this.aLv, 6, "", "", paramBoolean);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562062);
    if (QLog.isDevelopLevel()) {
      aqwc.h(getClass().getSimpleName(), getIntent());
    }
    this.mFrom = super.getIntent().getIntExtra("key_register_from", -1);
    this.mSmsCode = super.getIntent().getStringExtra("key_register_smscode");
    if (this.mSmsCode == null) {
      this.mSmsCode = "";
    }
    this.phoneNum = super.getIntent().getStringExtra("phonenum");
    this.aLv = super.getIntent().getStringExtra("invite_code");
    this.countryCode = super.getIntent().getStringExtra("key");
    this.aPq = super.getIntent().getStringExtra("key_register_binded_qq");
    if (!TextUtils.isEmpty(this.aPq))
    {
      int i = this.aPq.length();
      this.aPr = (this.aPq.substring(0, 2) + "****" + this.aPq.substring(i - 2, i));
    }
    this.baa = super.getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    this.aRR = super.getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    this.aRQ = true;
    initViews();
    this.app.setHandler(getClass(), this.u);
    anot.c(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 0, 0, "", "", "", "");
    if (!this.aRR) {
      anot.c(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 1, 0, "", "", "", "");
    }
    if (!this.baa)
    {
      anot.c(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 2, 0, "", "", "", "");
      if (this.mFrom != 4) {
        break label447;
      }
      anot.a(this.app, "new_reg_805", "already_reg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      anot.c(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 3, 0, "", "", "", "");
      break;
      label447:
      if (this.mFrom == 5) {
        anot.a(this.app, "new_reg_805", "already_reg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
      } else {
        anot.a(this.app, "new_reg_805", "already_reg", "page_exp", "", 1, "", "3", "", "", "", "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Altz != null) {
      this.jdField_a_of_type_Altz.onDestroy();
    }
    this.jdField_a_of_type_Altz = null;
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onDestroy();
    }
    this.jdField_a_of_type_Alub = null;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_c_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public void initViews()
  {
    tK(2131717076);
    bVd();
    Bw(65);
    this.Fv = ((TextView)super.findViewById(2131381095));
    Object localObject1 = (ImageView)super.findViewById(2131374898);
    Object localObject2 = super.getIntent().getStringExtra("key_register_binded_qq_face_url");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        int i = wja.dp2px(70.0F, super.getResources());
        int j = wja.dp2px(70.0F, super.getResources());
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mLoadingDrawable = super.getResources().getDrawable(2130840645);
        localURLDrawableOptions.mFailedDrawable = super.getResources().getDrawable(2130841398);
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        ((URLDrawable)localObject2).setTag(aqbn.e(i, j));
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.b);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        localObject1 = (TextView)super.findViewById(2131374943);
        localObject2 = super.getIntent().getStringExtra("key_register_binded_qq_nick");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label270;
        }
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)super.findViewById(2131374944)).setText(this.aPr);
        ((Button)super.findViewById(2131363812)).setOnClickListener(this);
        ((Button)super.findViewById(2131363813)).setOnClickListener(this);
        xU(false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localException.setImageResource(2130841398);
      continue;
      label270:
      localException.setVisibility(8);
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "onAccountChanged success");
    }
    this.app = ((QQAppInterface)getAppRuntime());
    LoginActivity.o(this.app, this.app.getAccount());
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    super.finish();
    localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
    bwV();
  }
  
  public boolean onBackEvent()
  {
    if (this.bab) {
      xU(false);
    }
    for (;;)
    {
      return true;
      MqqHandler localMqqHandler = this.app.getHandler(RegisterVerifyCodeActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(108);
      }
      super.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363812: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Intent localIntent = new Intent(this, LoginActivity.class);
        localIntent.putExtra("from_register_choose", true);
        localIntent.putExtra("uin", this.aPq);
        localIntent.putExtra("hasPwd", this.aRR);
        startActivity(localIntent);
        anot.a(this.app, "new_reg_805", "already_reg", "log_clk", "", 1, "");
      }
    }
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false)) {
      xV(true);
    }
    for (;;)
    {
      anot.a(this.app, "new_reg_805", "already_reg", "con_clk", "", 1, "");
      break;
      if ((!this.aRR) || (!this.baa)) {
        xV(false);
      } else {
        bVc();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterChooseLoginActivity
 * JD-Core Version:    0.7.0.1
 */