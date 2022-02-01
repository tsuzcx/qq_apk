package com.tencent.mobileqq.activity;

import acfp;
import altw;
import alub;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import anot;
import aqcl;
import aqiw;
import aqwc;
import aurd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import vrk;

public class RegisterByNicknameAndPwdActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private alub jdField_a_of_type_Alub;
  private aqwc jdField_a_of_type_Aqwc;
  private boolean aRU;
  private boolean aZX = true;
  private boolean aZY;
  private Button du;
  private Button dv;
  private ClearableEditText g;
  private ClearableEditText h;
  private ImageView qX;
  private ImageView qY;
  private ImageView qZ;
  private View uB;
  private View uC;
  private View uD;
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean4)
  {
    paramQQAppInterface = new Intent(paramContext, RegisterByNicknameAndPwdActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("invite_code", paramString4);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_smscode", paramString3);
    paramQQAppInterface.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    paramQQAppInterface.putExtra("key_register_has_pwd", paramBoolean2);
    paramQQAppInterface.putExtra("key_register_from", paramInt);
    paramQQAppInterface.putExtra("key_register_nick", paramString5);
    paramQQAppInterface.putExtra("key_register_password", paramString6);
    paramQQAppInterface.putExtra("key_register_phonenum_bindnewqq", paramBoolean4);
    if ((paramContext instanceof RegisterSendUpSms)) {
      paramQQAppInterface.putExtra("key_register_from_send_sms", true);
    }
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static int bG(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterByNicknameAndPwdActivity", 2, "getMixStringLength, str :" + paramString + ",length :" + i);
    }
    return i;
  }
  
  private void bVb()
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if ((this.h != null) && (!this.h.isEnabled()) && (this.g != null) && (!this.g.isEnabled())) {
      getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFB | 0x2);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterByNicknameAndPwdActivity", 2, "setSoftInputMode, isHideInput=" + bool + ",mode=" + localLayoutParams.softInputMode);
      }
      return;
      getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFD | 0x4);
    }
  }
  
  private boolean hq(String paramString)
  {
    return paramString.indexOf(" ") != -1;
  }
  
  private void initViews()
  {
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.aLv = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.aRQ = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.aRR = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.aRU = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    this.aZY = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    String str1 = getIntent().getStringExtra("key_register_nick");
    String str2 = getIntent().getStringExtra("key_register_password");
    setTitleText(acfp.m(2131713826));
    bVd();
    Bw(100);
    this.uB = findViewById(2131373868);
    this.uC = findViewById(2131373871);
    this.qY = ((ImageView)findViewById(2131373867));
    this.qZ = ((ImageView)findViewById(2131373870));
    this.g = ((ClearableEditText)findViewById(2131372889));
    this.g.addTextChangedListener(this);
    this.h = ((ClearableEditText)findViewById(2131372388));
    this.h.addTextChangedListener(this);
    this.du = ((Button)findViewById(2131363965));
    this.du.setOnClickListener(this);
    this.dv = ((Button)findViewById(2131370875));
    this.dv.setOnClickListener(this);
    this.uD = findViewById(2131382029);
    if (!TextUtils.isEmpty(str1)) {
      this.h.setText(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      this.g.setText(str2);
    }
    this.qX = ((ImageView)findViewById(2131372890));
    this.qX.setOnClickListener(this);
    if (this.aZX)
    {
      this.g.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.qX.setImageResource(2130847848);
      this.qX.setContentDescription(acfp.m(2131713846));
    }
    for (;;)
    {
      this.qX.setVisibility(8);
      this.g.setOnFocusChangeListener(new vrk(this));
      if (aqcl.bJ(this))
      {
        this.h.setHint(2131696320);
        this.g.setHint(2131721080);
      }
      return;
      this.g.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      this.qX.setImageResource(2130847849);
      this.qX.setContentDescription(acfp.m(2131713829));
    }
  }
  
  private boolean isPwdValid(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.length() <= 0))
    {
      bool1 = false;
      return bool1;
    }
    int i3 = paramString.length();
    int i = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    label36:
    if (i < i3)
    {
      int n = paramString.charAt(i);
      int i1;
      int i2;
      if ((n >= 48) && (n <= 57))
      {
        n = m;
        i1 = k;
        i2 = j;
        if (j == 0)
        {
          i2 = 1;
          i1 = k;
          n = m;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i2 + i1 + n >= 2) {
          break;
        }
        i += 1;
        m = n;
        k = i1;
        j = i2;
        break label36;
        if (((n >= 97) && (n <= 122)) || ((n >= 65) && (n <= 90)))
        {
          n = m;
          i1 = k;
          i2 = j;
          if (k == 0)
          {
            i1 = 1;
            n = m;
            i2 = j;
          }
        }
        else
        {
          n = m;
          i1 = k;
          i2 = j;
          if (m == 0)
          {
            n = 1;
            i1 = k;
            i2 = j;
          }
        }
      }
    }
    return false;
  }
  
  public boolean QC()
  {
    if ((this.h == null) || (this.g == null)) {
      return false;
    }
    String str1 = String.valueOf(this.g.getText());
    String str2 = this.h.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      J(2131696833, 1);
      return false;
    }
    if (hq(str1))
    {
      J(2131717116, 1);
      return false;
    }
    if (!isPwdValid(str1))
    {
      J(2131717115, 1);
      return false;
    }
    if ((TextUtils.isEmpty(str2)) || (str2.trim().length() == 0))
    {
      J(2131717064, 1);
      return false;
    }
    try
    {
      if (bG(str2) > 24L)
      {
        J(2131717065, 1);
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    Object localObject1;
    do
    {
      return;
      localObject2 = this.h.getText();
      localObject1 = this.g.getText();
    } while ((paramEditable != localObject2) && (paramEditable != localObject1));
    String str = localObject2.toString();
    Object localObject2 = localObject1.toString();
    int i;
    if (this.qY != null) {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() >= 8))
      {
        this.qY.setBackgroundResource(2130841267);
        i = 1;
      }
    }
    for (;;)
    {
      label86:
      int j;
      if (this.qZ != null) {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (isPwdValid((String)localObject2)))
        {
          this.qZ.setBackgroundResource(2130841267);
          j = 1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          label122:
          if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
            this.du.setEnabled(true);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Aqwc != null) {
              this.jdField_a_of_type_Aqwc.SX(this.du.isEnabled());
            }
            if (paramEditable != localObject1) {
              break;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label231;
            }
            this.g.setClearButtonVisible(false);
            return;
            this.qY.setBackgroundResource(2130841264);
            i = 0;
            break label86;
            this.qZ.setBackgroundResource(2130841264);
            j = 0;
            break label122;
            this.du.setEnabled(false);
          }
          label231:
          this.g.setClearButtonVisible(true);
          localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 1, ((String)localObject2).length());
          try
          {
            if (((String)localObject1).length() >= ((String)localObject1).getBytes("utf-8").length) {
              break;
            }
            paramEditable.delete(((String)localObject2).length() - 1, ((String)localObject2).length());
            return;
          }
          catch (UnsupportedEncodingException paramEditable)
          {
            paramEditable.printStackTrace();
            return;
          }
        }
        j = 0;
      }
      i = 0;
    }
  }
  
  public void bVa()
  {
    this.du.setVisibility(4);
    this.dv.setVisibility(0);
    this.dv.setEnabled(true);
    this.uD.setVisibility(8);
    this.h.setEnabled(false);
    this.g.setEnabled(false);
    this.qX.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1) && (this.jdField_a_of_type_Aqwc != null) && (this.jdField_a_of_type_Aqwc.b != null)) {
      this.jdField_a_of_type_Aqwc.b.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      aqwc.h("RegisterByNicknameAndPwdActivity -- doOnNewIntent", getIntent());
    }
    initViews();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onPause();
    }
    bVb();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
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
    boolean bool = false;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Aqwc != null) && (this.jdField_a_of_type_Aqwc.cWH))
      {
        this.jdField_a_of_type_Aqwc.SW(this.aZY);
      }
      else
      {
        anot.a(this.app, "CliOper", "", "", "0X8006653", "0X8006653", 0, 0, "", "", "", "");
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          J(2131693404, 0);
        }
        else if (QC())
        {
          String str1 = String.valueOf(this.g.getText());
          String str2 = this.h.getText().toString();
          if (this.jdField_a_of_type_Alub == null) {
            this.jdField_a_of_type_Alub = new alub(this);
          }
          this.jdField_a_of_type_Alub.j(str2, str1, true, this.aZY);
          anot.a(this.app, "new_reg_805", "setting_page", "reg_clk", "", 1, "");
          continue;
          str1 = this.g.getText().toString();
          if (this.aZX)
          {
            if (this.aRU) {
              anot.c(this.app, "dc00898", "", "", "0X80072FA", "0X80072FA", 0, 0, "", "", "", "");
            }
            this.g.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.qX.setImageResource(2130847849);
            this.qX.setContentDescription(acfp.m(2131713836));
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(str1)) {
              this.g.setSelection(this.g.length());
            }
            if (!this.aZX) {
              bool = true;
            }
            this.aZX = bool;
            break;
            this.g.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.qX.setImageResource(2130847848);
            this.qX.setContentDescription(acfp.m(2131713843));
          }
          aurd.cE(this);
          new Handler().postDelayed(new RegisterByNicknameAndPwdActivity.2(this), 200L);
          continue;
          if (this.jdField_a_of_type_Alub != null) {
            this.jdField_a_of_type_Alub.dJL();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131562058);
    if (QLog.isDevelopLevel()) {
      aqwc.h(getClass().getSimpleName(), getIntent());
    }
    initViews();
    anot.a(this.app, "CliOper", "", "", "0X8006652", "0X8006652", 0, 0, "", "", "", "");
    anot.c(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 0, 0, "", "", "", "");
    if (this.aRU) {
      anot.c(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 1, 0, "", "", "", "");
    }
    if (!this.aRQ) {
      anot.c(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("key_register_from_send_sms", false)) {
        anot.c(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 5, 0, "", "", "", "");
      }
      if (this.mFrom != 4) {
        break;
      }
      anot.a(this.app, "new_reg_805", "setting_page", "page_exp", "3", 1, "", "1", "", "", "", "", "", "", "");
      return;
      if (!this.aRR) {
        anot.c(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 3, 0, "", "", "", "");
      } else {
        anot.c(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 4, 0, "", "", "", "");
      }
    }
    if (this.mFrom == 5)
    {
      anot.a(this.app, "new_reg_805", "setting_page", "page_exp", "1", 1, "", "2", "", "", "", "", "", "", "");
      return;
    }
    if (this.mFrom == 6)
    {
      anot.a(this.app, "new_reg_805", "setting_page", "page_exp", "2", 1, "", "3", "", "", "", "", "", "", "");
      return;
    }
    if (this.aRU)
    {
      anot.a(this.app, "new_reg_805", "setting_page", "page_exp", "4", 1, "", "3", "", "", "", "", "", "", "");
      return;
    }
    anot.a(this.app, "new_reg_805", "setting_page", "page_exp", "5", 1, "", "4", "", "", "", "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    if (this.jdField_a_of_type_Aqwc != null) {
      this.jdField_a_of_type_Aqwc.onDestroy();
    }
    if (this.jdField_a_of_type_Alub != null) {
      this.jdField_a_of_type_Alub.onDestroy();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity
 * JD-Core Version:    0.7.0.1
 */