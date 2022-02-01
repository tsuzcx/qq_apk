package com.tencent.mobileqq.activity;

import acfp;
import aciu;
import altw;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import anot;
import aqju;
import aqnu;
import aqwc;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import vgy;
import vrt;
import vru;
import vrv;
import vrw;
import vrx;
import vry;

public class RegisterPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, Animation.AnimationListener, CompoundButton.OnCheckedChangeListener
{
  private TextView Ep;
  private TextView Fw;
  private TextView Fx;
  private altw jdField_a_of_type_Altw;
  private ConfigClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  protected vgy a;
  private String aPs = acfp.m(2131713831);
  private ConfigClearableEditText b;
  private boolean bad = true;
  private boolean bae;
  private boolean baf;
  private Button dm;
  private CheckBox t;
  private CheckBox jdField_u_of_type_AndroidWidgetCheckBox;
  private MqqHandler jdField_u_of_type_MqqOsMqqHandler = new vru(this);
  private View uE;
  private View uF;
  private View uG;
  
  private boolean QE()
  {
    int j = 0;
    boolean bool1;
    for (;;)
    {
      try
      {
        str = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
        str = this.jdField_a_of_type_Altw.hh(str);
        if (str != null)
        {
          i = 1;
          bool1 = i & 0x1;
        }
      }
      catch (Exception localException1)
      {
        String str;
        int i;
        return true;
      }
      try
      {
        str = this.b.getText().toString();
        if (this.bae)
        {
          i = j;
          if (this.bae)
          {
            boolean bool2 = TextUtils.isEmpty(str);
            i = j;
            if (bool2) {}
          }
        }
        else
        {
          i = 1;
        }
        return i & bool1;
      }
      catch (Exception localException2) {}
      i = 0;
    }
    return bool1;
  }
  
  private static final boolean aH(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        localPoint = new Point();
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        paramContext.getRealSize(localPoint);
        j = localPoint.y;
        if (j >= 1920) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        Point localPoint;
        int j;
        QLog.e("RegisterPhoneNumActivity", 2, "isNeedHideSoftkey", paramContext);
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterPhoneNumActivity", 2, "isNeedHideSoftkey, result=" + bool + ", mRealSizeHeight=" + i);
      }
      return bool;
      paramContext.getSize(localPoint);
    }
  }
  
  private void aU(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.bae == paramBoolean1) {
      return;
    }
    this.bae = paramBoolean1;
    this.t.setChecked(paramBoolean1);
    this.uE.clearAnimation();
    this.uF.clearAnimation();
    this.dm.clearAnimation();
    this.uG.clearAnimation();
    this.dm.setEnabled(QE());
    if (paramBoolean1)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131298966), 0.0F);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setInterpolator(new LinearInterpolator());
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
      localAlphaAnimation.setDuration(200L);
      localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.addAnimation(localAlphaAnimation);
      this.uE.setVisibility(0);
      this.uF.setVisibility(0);
      this.uE.startAnimation(localAnimationSet);
      this.uF.startAnimation(localAnimationSet);
      this.dm.startAnimation((Animation)localObject);
      this.uG.startAnimation((Animation)localObject);
      if (paramBoolean2)
      {
        localObject = getIntent().getStringExtra("invite_code");
        this.b.setText((CharSequence)localObject);
      }
      for (;;)
      {
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.b, 0);
        return;
        this.b.setText("");
        this.b.requestFocus();
      }
    }
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131298966));
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(200L);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.uE.startAnimation(localAnimationSet);
    this.uF.startAnimation(localAnimationSet);
    this.dm.startAnimation((Animation)localObject);
    this.uG.startAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(this);
  }
  
  private void c(EditText paramEditText)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramEditText.setCustomSelectionActionModeCallback(new vrw(this));
      return;
    }
    paramEditText.setOnCreateContextMenuListener(new vrx(this));
  }
  
  private void eP(View paramView)
  {
    paramView.setOnTouchListener(new vrv(this));
  }
  
  @TargetApi(11)
  private void initViews()
  {
    this.jdField_u_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364579));
    this.jdField_u_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    tK(2131717044);
    bVd();
    Bw(33);
    findViewById(2131373551).setOnClickListener(this);
    String str = getIntent().getStringExtra("invite_code");
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Fw = ((TextView)findViewById(2131381126));
      this.Fw.setOnClickListener(this);
      this.Fw.setContentDescription(getString(2131717142) + getString(2131692117));
      this.Fx = ((TextView)findViewById(2131381105));
      this.Fx.setOnClickListener(this);
      this.Fx.setContentDescription(getString(2131717083) + getString(2131692117));
      this.Ep = ((TextView)findViewById(2131381072));
      this.Ep.setText("+" + this.countryCode);
      this.Ep.setOnClickListener(this);
      eP(this.Ep);
      this.uE = findViewById(2131370223);
      this.uE.setVisibility(8);
      this.uF = findViewById(2131378039);
      this.uF.setVisibility(8);
      this.t = ((CheckBox)findViewById(2131364360));
      this.t.setChecked(bool);
      this.t.setOnCheckedChangeListener(this);
      this.uG = findViewById(2131370222);
      this.uG.setOnClickListener(this);
      eP(this.uG);
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131372579));
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
      c(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText);
      this.b = ((ConfigClearableEditText)findViewById(2131372575));
      this.b.addTextChangedListener(this);
      if (!TextUtils.isEmpty(str)) {
        this.b.setText(str);
      }
      this.dm = ((Button)findViewById(2131363918));
      this.dm.setOnClickListener(this);
      this.dm.post(new RegisterPhoneNumActivity.3(this, bool));
      return;
    }
  }
  
  public boolean QF()
  {
    if (this.jdField_u_of_type_AndroidWidgetCheckBox != null) {
      return this.jdField_u_of_type_AndroidWidgetCheckBox.isChecked();
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.dm != null) {
      this.dm.setEnabled(QE());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.aPs = paramIntent.getStringExtra("k_name");
      this.countryCode = paramIntent.getStringExtra("k_code");
      this.Ep.setText("+" + this.countryCode);
      this.dm.setEnabled(QE());
    }
    while ((paramInt1 != 2) || (paramInt2 != -1)) {
      return;
    }
    this.jdField_a_of_type_Altw.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (aH(this)) {
      getWindow().setSoftInputMode(2);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131562060);
    if (this.app == null)
    {
      paramBundle = getAppRuntime();
      if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
        this.app = ((QQAppInterface)paramBundle);
      }
    }
    if (this.app == null)
    {
      QLog.d("RegisterPhoneNumActivity", 1, "doOnCreate app == null");
      finish();
      return true;
    }
    if (QLog.isDevelopLevel()) {
      aqwc.h(getClass().getSimpleName(), getIntent());
    }
    this.jdField_a_of_type_Altw = new altw(this);
    this.app.setHandler(getClass(), this.jdField_u_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Altw.eP(getApplicationContext());
    initViews();
    anot.a(this.app, "CliOper", "", "", "0X8006650", "0X8006650", 0, 0, "", "", "", "");
    anot.c(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    anot.c(this.app, "dc00898", "", "", "0X8007360", "0X8007360", getIntent().getIntExtra("key_report_extra_from", 0), 0, "", "", "", "");
    if (this.mFrom == -1) {
      anot.a(this.app, "new_reg_805", "reg_page", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Vgy = new vgy();
      paramBundle = new vrt(this);
      this.jdField_a_of_type_Vgy.a(paramBundle);
      return true;
      anot.a(this.app, "new_reg_805", "reg_page", "page_exp", "", 1, "", Integer.toString(this.mFrom), "", "", "", "", "", "", "");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Altw.onDestroy();
    this.app.removeHandler(getClass());
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText);
    }
    this.uE.clearAnimation();
    this.uF.clearAnimation();
    this.dm.clearAnimation();
    this.uG.clearAnimation();
    aqnu.eeu();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.dm.setEnabled(QE());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public String oX()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
  }
  
  public String oY()
  {
    if (this.bae) {
      return this.b.getText().toString();
    }
    return "";
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.bae)
    {
      this.uE.setVisibility(8);
      this.uF.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.i("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onAnimationEnd");
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131364579) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean != this.bae) {
        anot.a(this.app, "dc00898", "", "", "0X8009700", "0X8009700", 0, 0, "", "", "", "");
      }
      aU(paramBoolean, false);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (paramView.getId())
    {
    default: 
    case 2131381072: 
    case 2131363918: 
    case 2131381105: 
    case 2131381126: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject = new Intent(this, NewStyleCountryActivity.class);
        ((Intent)localObject).putExtra("k_code", this.countryCode);
        ((Intent)localObject).putExtra("k_name", this.aPs);
        startActivityForResult((Intent)localObject, 1);
        continue;
        anot.a(this.app, "CliOper", "", "", "0X8006651", "0X8006651", 0, 0, "", "", "", "");
        anot.c(this.app, "dc00898", "", "", "0X8007CC7", "0X8007CC7", 0, 0, "", "", "", "");
        localObject = this.app;
        if ((!TextUtils.isEmpty(this.aPs)) && (this.aPs.equals(getString(2131717022))))
        {
          i = 1;
          anot.c((QQAppInterface)localObject, "dc00898", "", "", "0X8007CC7", "0X8007CC7", i, 0, "", "", "", "");
          localObject = this.app;
          if (!this.bae) {
            break label385;
          }
        }
        for (i = 1;; i = 2)
        {
          anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X8009701", "0X8009701", i, 0, "", "", "", "");
          anot.a(this.app, "new_reg_805", "reg_page", "next_clk", "", 1, "", "", "", "", "", "", "", "", "");
          if (QF()) {
            break label390;
          }
          J(2131691482, 0);
          break;
          i = 2;
          break label232;
        }
        if (this.baf)
        {
          this.jdField_a_of_type_Altw.bRq();
        }
        else
        {
          localObject = new vry(this);
          aciu.a(this, "", (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject).show();
          continue;
          if (this.bad)
          {
            this.bad = false;
            this.handler.postDelayed(new RegisterPhoneNumActivity.8(this), 1000L);
            for (;;)
            {
              try
              {
                if (paramView.getId() != 2131381126) {
                  continue;
                }
                localObject = "https://ti.qq.com/tim/serverinfo.html";
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)localObject)));
              }
              catch (Exception localException)
              {
                QLog.d("RegisterPhoneNumActivity", 1, "no system browser exp=", localException);
                continue;
              }
              if (i != 2131381126) {
                break label580;
              }
              anot.a(this.app, "new_reg_805", "reg_page", "terms_clk", "", 1, "", "", "", "", "", "", "", "", "");
              break;
              localObject = "https://tim.qq.com/timapp/agreement/tim_privacy_guid_ios.html";
            }
            if (i == 2131381105) {
              anot.a(this.app, "new_reg_805", "reg_page", "privacy_clk", "", 1, "", "", "", "", "", "", "", "", "");
            }
          }
        }
      }
    case 2131370222: 
      label232:
      localCheckBox = this.t;
      label385:
      label390:
      label580:
      if (!this.bae) {}
      for (bool = true;; bool = false)
      {
        localCheckBox.setChecked(bool);
        break;
      }
    }
    CheckBox localCheckBox = this.jdField_u_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_u_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */