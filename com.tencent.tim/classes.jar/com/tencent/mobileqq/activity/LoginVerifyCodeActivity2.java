package com.tencent.mobileqq.activity;

import adac;
import adae;
import akwp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import aqiw;
import arhz;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;
import vhc;
import vhd;

public class LoginVerifyCodeActivity2
  extends RegisterBaseActivity
  implements adac, TextWatcher, View.OnClickListener
{
  private TextView Eq;
  private OpenSDKAppInterface a;
  public SSOAccountObserver a;
  private int bIi;
  WtloginObserver c = new vhd(this);
  private Button dm;
  private EditText editText;
  private String mAppId;
  private Runnable runnableCountdown = new LoginVerifyCodeActivity2.2(this);
  private int second = 60;
  private adae smsContent;
  private arhz w;
  
  public LoginVerifyCodeActivity2()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new vhc(this);
  }
  
  private void bGA()
  {
    akwp.a().b(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.countryCode, this.phoneNum, this.c);
  }
  
  private void bGv()
  {
    Object localObject1 = "";
    Object localObject2 = this.editText.getText();
    if (localObject2 != null)
    {
      localObject2 = localObject2.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
    }
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      Bv(2131717032);
      if (akwp.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.countryCode, this.phoneNum, (String)localObject1, this.c) != 0)
      {
        gV();
        bRr();
      }
      return;
    }
    J(2131717045, 0);
  }
  
  private void bRs()
  {
    Bv(2131717125);
    if (akwp.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.countryCode, this.phoneNum, this.c) != 0)
    {
      gV();
      bRr();
    }
  }
  
  private void initViews()
  {
    ((TextView)this.cX.findViewById(2131381120)).setText(getString(2131717145, new Object[] { this.phoneNum }));
    this.Eq = ((TextView)this.cX.findViewById(2131363970));
    this.Eq.setOnClickListener(this);
    this.Eq.setText(getString(2131717113) + "(" + this.second + ")");
    this.handler.postDelayed(this.runnableCountdown, 1000L);
    this.dm = ((Button)this.cX.findViewById(2131363918));
    this.dm.setOnClickListener(this);
    this.editText = ((EditText)this.cX.findViewById(2131372579));
    this.editText.addTextChangedListener(this);
  }
  
  private void restartTimer(int paramInt)
  {
    this.Eq.setEnabled(false);
    this.Eq.setClickable(false);
    this.second = paramInt;
    this.Eq.setText(getString(2131717113) + "(" + this.second + ")");
    this.handler.postDelayed(this.runnableCountdown, 1000L);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.dm.setEnabled(true);
      return;
    }
    this.dm.setEnabled(false);
  }
  
  public void bRr()
  {
    J(2131718832, 1);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (QLog.isDevelopLevel())
      {
        paramIntent = new StringBuilder().append("doOnActivityResult, REQ_CODE_NOTIFICATION_LH  ");
        if (paramInt2 != -1) {
          break label64;
        }
      }
    }
    for (;;)
    {
      QLog.i("LoginVerifyCodeActivity", 4, bool);
      if (paramInt2 == -1) {
        finish();
      }
      return;
      label64:
      bool = false;
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new LoginVerifyCodeActivity2.6(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      J(2131693404, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363918: 
        bGv();
        break;
      case 2131363970: 
        bRs();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.cX = ((ViewGroup)setContentViewB(2131561418));
    setTitle(2131717154);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    paramBundle = getIntent();
    this.bIi = paramBundle.getIntExtra("key_req_src", -1);
    this.mAppId = paramBundle.getStringExtra("appid");
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.countryCode = getIntent().getStringExtra("key");
    initViews();
    this.smsContent = new adae(null);
    this.smsContent.a(this, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    if (this.smsContent != null) {
      this.smsContent.unregister();
    }
    this.smsContent = null;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */