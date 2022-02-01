package com.tencent.mobileqq.activity;

import acfp;
import altw;
import altz;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import anot;
import aqiw;
import aqwc;
import aurd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vrs;

public class RegisterPersonalInfoActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private altz jdField_a_of_type_Altz;
  private aqwc jdField_a_of_type_Aqwc;
  private boolean bac;
  private Button dw;
  private ClearableEditText h;
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt)
  {
    paramQQAppInterface = new Intent(paramContext, RegisterPersonalInfoActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("invite_code", paramString4);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_smscode", paramString3);
    paramQQAppInterface.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    paramQQAppInterface.putExtra("key_register_from", paramInt);
    if ((paramContext instanceof RegisterSendUpSms)) {
      paramQQAppInterface.putExtra("key_register_from_send_sms", true);
    }
    paramContext.startActivity(paramQQAppInterface);
  }
  
  private void init()
  {
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.aLv = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.aRQ = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.bac = getIntent().getBooleanExtra("key_register_from_send_sms", false);
    setTitleText(acfp.m(2131713845));
    bVd();
    Bw(80);
    this.dw = ((Button)findViewById(2131363867));
    this.dw.setOnClickListener(this);
    this.h = ((ClearableEditText)findViewById(2131372388));
    this.h.addTextChangedListener(new vrs(this));
    if (this.jdField_a_of_type_Aqwc != null)
    {
      this.jdField_a_of_type_Aqwc.bJy();
      return;
    }
    this.jdField_a_of_type_Aqwc = new aqwc(this, findViewById(2131370145), 2);
  }
  
  public boolean QD()
  {
    if (this.h == null) {
      return false;
    }
    String str = this.h.getText().toString();
    if ((TextUtils.isEmpty(str)) || (str.trim().length() == 0))
    {
      J(2131717064, 1);
      return false;
    }
    return true;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1) && (this.jdField_a_of_type_Aqwc != null) && (this.jdField_a_of_type_Aqwc.b != null)) {
      this.jdField_a_of_type_Aqwc.b.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562059);
    if (QLog.isDevelopLevel()) {
      aqwc.h(getClass().getSimpleName(), getIntent());
    }
    init();
    anot.a(this.app, "CliOper", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    anot.c(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    if (!this.aRQ)
    {
      anot.c(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 1, 0, "", "", "", "");
      if (this.bac) {
        anot.c(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 3, 0, "", "", "", "");
      }
      if (this.mFrom != 4) {
        break label232;
      }
      anot.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      anot.c(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 2, 0, "", "", "", "");
      break;
      label232:
      if (this.mFrom == 5) {
        anot.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
      } else if (this.mFrom == 6) {
        anot.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "3", "", "", "", "", "", "", "");
      } else {
        anot.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      aqwc.h("RegisterPersonalInfoActivity -- doOnNewIntent", getIntent());
    }
    init();
  }
  
  public boolean isWrapContent()
  {
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
      if ((this.jdField_a_of_type_Aqwc != null) && (this.jdField_a_of_type_Aqwc.cWH))
      {
        this.jdField_a_of_type_Aqwc.SW(true);
      }
      else if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        J(2131693404, 0);
      }
      else if (QD())
      {
        String str = this.h.getText().toString();
        if (this.jdField_a_of_type_Altz == null) {
          this.jdField_a_of_type_Altz = new altz(this);
        }
        this.jdField_a_of_type_Altz.doAction(str);
        anot.a(this.app, "new_reg", "setting_page_no", "reg_clk", "", 1, "");
        continue;
        aurd.cE(this);
        new Handler().postDelayed(new RegisterPersonalInfoActivity.2(this), 200L);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    if (this.jdField_a_of_type_Aqwc != null) {
      this.jdField_a_of_type_Aqwc.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */