package com.tencent.mobileqq.activity;

import acmf;
import adac;
import adae;
import akwp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import aqiw;
import arhz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.SubAccountObserver;
import mqq.observer.WtloginObserver;
import vgz;
import vha;
import vhb;

public class LoginVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements adac, TextWatcher, View.OnClickListener, View.OnKeyListener
{
  private static final int[] fu = { 2131381523, 2131381524, 2131381525, 2131381526, 2131381527, 2131381528 };
  private TextView Eq;
  public SubAccountObserver a;
  private EditText[] a;
  private String aOa;
  private String aOb;
  private String aOc;
  private String aOd;
  private boolean aYs;
  public acmf b = new vhb(this);
  WtloginObserver c = new vgz(this);
  private Runnable dU = new LoginVerifyCodeActivity.7(this);
  private Runnable runnableCountdown = new LoginVerifyCodeActivity.1(this);
  private int second = 60;
  private adae smsContent;
  private arhz w;
  
  public LoginVerifyCodeActivity()
  {
    this.jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
    this.jdField_a_of_type_MqqObserverSubAccountObserver = new vha(this);
  }
  
  private void bGA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "startLogin start...");
    }
    if (this.aYs)
    {
      akwp.a().b(this.app, this.app.getCurrentAccountUin(), this.countryCode, this.phoneNum, this.c);
      return;
    }
    akwp.a().b(this.app, this.countryCode, this.phoneNum, this.c);
  }
  
  private void bGv()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      J(2131693404, 0);
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = new StringBuilder("");
      int i = 0;
      while (i < 6)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
        if (localObject2 != null) {
          ((StringBuilder)localObject1).append(localObject2.toString());
        }
        i += 1;
      }
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break;
      }
      Bv(2131717032);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
    } while (akwp.a().a(this.app, this.countryCode, this.phoneNum, (String)localObject1, this.c) == 0);
    gV();
    J(2131718832, 1);
    return;
    J(2131717045, 0);
  }
  
  private void bRs()
  {
    Bv(2131717125);
    if (akwp.a().a(this.app, this.countryCode, this.phoneNum, this.c) != 0)
    {
      gV();
      J(2131718832, 1);
    }
  }
  
  private void initViews()
  {
    int i = 0;
    tK(2131717154);
    bVd();
    ((TextView)findViewById(2131381120)).setText(getString(2131717145, new Object[] { "+" + this.countryCode + " " + this.phoneNum }));
    this.Eq = ((TextView)findViewById(2131363970));
    this.Eq.setOnClickListener(this);
    this.Eq.setText(getString(2131717113) + "(" + this.second + ")");
    this.handler.postDelayed(this.runnableCountdown, 1000L);
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(fu[i]).findViewById(2131381127));
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
      i += 1;
    }
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
    int i = 1;
    int j = 0;
    Editable localEditable;
    if (j < 6)
    {
      localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].getText();
      if (localEditable == null) {
        break label207;
      }
    }
    label135:
    label207:
    for (int k = localEditable.toString().length();; k = 0)
    {
      View localView = findViewById(fu[j]).findViewById(2131370493);
      if ((localEditable != null) && (localEditable == paramEditable))
      {
        if (k <= 0) {
          break label135;
        }
        localView.setBackgroundColor(-9474193);
        if (j < 5)
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].requestFocus();
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].length());
        }
      }
      label116:
      if ((localEditable == null) || (k <= 0)) {
        i = 0;
      }
      for (;;)
      {
        j += 1;
        break;
        if (k != 0) {
          break label116;
        }
        localView.setBackgroundColor(-2170912);
        if ((j <= 0) || (j >= 6)) {
          break label116;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j - 1)].requestFocus();
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j - 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j - 1)].length());
        break label116;
        if (i != 0) {
          bGv();
        }
        return;
      }
    }
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
          break label65;
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
      label65:
      bool = false;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561417);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.aOa = paramBundle.getStringExtra("fromWhere");
      this.aYs = paramBundle.getBooleanExtra("isSubaccount", false);
    }
    if (this.aYs) {
      addObserver(this.b);
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.countryCode = getIntent().getStringExtra("key");
    initViews();
    this.smsContent = new adae(null);
    this.smsContent.a(this, this);
    return true;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    QLog.d("LoginVerifyCodeActivity", 1, new Object[] { "getSmsContent, smsAddress : ", paramString1, " smsBody : ", paramString2 });
    if (this.aOd != null) {
      this.handler.removeCallbacks(this.dU);
    }
    this.aOc = paramString1;
    this.aOd = paramString2;
    this.handler.postDelayed(this.dU, 1500L);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (getIntent().getBooleanExtra("login_from_account_change", false))
    {
      setResult(-1);
      finish();
    }
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
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    if (this.aYs) {
      removeObserver(this.b);
    }
    if (this.smsContent != null) {
      this.smsContent.unregister();
    }
    this.smsContent = null;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if ((paramKeyEvent.getAction() == 0) && ((paramView instanceof EditText)))
    {
      paramView = ((EditText)paramView).getText();
      i = 0;
    }
    for (;;)
    {
      if (i < 6)
      {
        paramKeyEvent = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
        if ((paramKeyEvent == null) || (paramKeyEvent != paramView)) {
          break label180;
        }
        if (paramInt != 67) {
          break label119;
        }
        if ((i > 0) && (i < 6) && (paramKeyEvent.toString().length() <= 0))
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i - 1)].requestFocus();
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i - 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i - 1)].length());
        }
      }
      label119:
      while ((i < 0) || (i >= 5) || (paramKeyEvent.toString().length() < 1)) {
        return false;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i + 1)].requestFocus();
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i + 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(i + 1)].length());
      return false;
      label180:
      i += 1;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */