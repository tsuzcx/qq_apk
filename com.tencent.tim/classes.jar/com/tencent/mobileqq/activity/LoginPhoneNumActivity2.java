package com.tencent.mobileqq.activity;

import akwp;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anot;
import aqiw;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import vgw;
import vgx;

public class LoginPhoneNumActivity2
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private TextView Ep;
  private OpenSDKAppInterface a;
  MqqHandler b = new vgw(this);
  private int bIi;
  WtloginObserver c = new vgx(this);
  private Button dm;
  private ClearableEditText f;
  private String mAppId;
  
  private boolean Qd()
  {
    boolean bool = true;
    this.phoneNum = hh(this.f.getText().toString());
    if (this.phoneNum == null)
    {
      J(2131717079, 1);
      bool = false;
    }
    return bool;
  }
  
  private void bRq()
  {
    if (!Qd()) {}
    do
    {
      return;
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        J(2131693404, 0);
        return;
      }
      Bv(2131717125);
      if (QLog.isColorLevel()) {
        QLog.d("LoginPhoneNumActivity", 2, "-->startQueryAccount--CheckSMSVerifyLoginAccount, countryCode = " + this.countryCode + "phoneNum = " + this.phoneNum);
      }
    } while (akwp.a().a(this.a, this.phoneNum, this.countryCode, this.c) == 0);
    gV();
    cq(getString(2131717096), 1);
  }
  
  private void dm(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + " " + paramString2;
    Rect localRect = new Rect();
    this.Ep.getPaint().getTextBounds(paramString1, 0, paramString1.length(), localRect);
    int i = getResources().getDimensionPixelSize(2131297878);
    int j = getResources().getDimensionPixelSize(2131297877);
    if (localRect.right > i - j)
    {
      this.Ep.setText(paramString2);
      return;
    }
    this.Ep.setText(paramString1);
  }
  
  private String hh(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.countryCode)) {
          break label147;
        }
        if ("853".equals(this.countryCode))
        {
          break label147;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        if (paramString.startsWith("1")) {
          break label137;
        }
        bool = "86".equals(this.countryCode);
        if (!bool) {
          break label137;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label120;
        i = j;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.countryCode);
      if (bool)
      {
        i = 9;
        continue;
        label120:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label137:
        continue;
        label147:
        i = 6;
      }
    }
  }
  
  private void initViews()
  {
    this.Ep = ((TextView)this.cX.findViewById(2131381072));
    this.Ep.setOnClickListener(this);
    dm(getString(2131717023), "+" + this.countryCode);
    this.f = ((ClearableEditText)this.cX.findViewById(2131372579));
    this.f.addTextChangedListener(this);
    this.dm = ((Button)this.cX.findViewById(2131363918));
    this.dm.setOnClickListener(this);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (hh(paramEditable.toString()) != null)
    {
      this.dm.setEnabled(true);
      return;
    }
    this.dm.setEnabled(false);
  }
  
  public void bRp()
  {
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity2.class);
    localIntent.putExtra("phonenum", this.phoneNum);
    localIntent.putExtra("key", this.countryCode);
    localIntent.putExtra("key_req_src", this.bIi);
    localIntent.putExtra("appid", this.mAppId);
    startActivityForResult(localIntent, 10000);
  }
  
  public void bRr()
  {
    J(2131718832, 1);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginPhoneNumActivity", 2, "-->onActivityResult--reqCode = " + paramInt1 + ", resCode = " + paramInt2);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra("last_account");
      str2 = paramIntent.getStringExtra("wtTicket");
      localIntent = new Intent();
      localIntent.putExtra("last_account", str1);
      localIntent.putExtra("wtTicket", str2);
      localIntent.putExtra("ssobundle", paramIntent.getBundleExtra("ssobundle"));
      setResult(-1, localIntent);
      finish();
    }
    while ((paramInt1 != 1) || (paramInt2 != -1))
    {
      String str2;
      Intent localIntent;
      return;
    }
    String str1 = paramIntent.getStringExtra("k_name");
    this.countryCode = paramIntent.getStringExtra("k_code");
    dm(str1, "+" + this.countryCode);
    try
    {
      if (hh(this.f.getText().toString()) != null)
      {
        this.dm.setEnabled(true);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
      return;
    }
    this.dm.setEnabled(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      continue;
      bRq();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.cX = ((ViewGroup)setContentViewB(2131561416));
    setTitle(2131721669);
    paramBundle = getIntent();
    this.bIi = paramBundle.getIntExtra("key_req_src", -1);
    this.mAppId = paramBundle.getStringExtra("appid");
    if (QLog.isColorLevel()) {
      QLog.d("LoginPhoneNumActivity", 2, "-->onCreate--mReqSrc = " + this.bIi);
    }
    this.a = ((OpenSDKAppInterface)getAppRuntime());
    this.a.setHandler(getClass(), this.b);
    initViews();
    anot.c(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    anot.c(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 4, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    this.a.removeHandler(getClass());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity2
 * JD-Core Version:    0.7.0.1
 */