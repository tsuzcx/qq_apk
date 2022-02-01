package com.tencent.mobileqq.activity.phone;

import acfp;
import adac;
import adae;
import akwl;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import anot;
import aqft;
import aqha;
import aqiw;
import aqju;
import auru;
import auum;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import yuw;
import zqd;
import zqe;
import zqf;
import zqg;
import zqh;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements adac, Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, auum
{
  private TextView Nd;
  private Button X;
  private EditText aP;
  private boolean awY;
  private int bindType = 0;
  private boolean bsj;
  private boolean bsk;
  private int cez;
  private String countryCode;
  private akwl g;
  private akwl i;
  private int mSource = -1;
  private String number;
  private adae smsContent;
  private final Handler uiHandler = new auru(Looper.getMainLooper(), this);
  
  private void cE(Intent paramIntent)
  {
    this.bindType = paramIntent.getIntExtra("kBindType", 0);
    this.number = paramIntent.getStringExtra("k_number");
    this.countryCode = paramIntent.getStringExtra("k_country_code");
    setLeftViewName(2131690700);
    setTitle("");
    ((TextView)findViewById(2131372300)).setText(2131696830);
    paramIntent = this.countryCode + " " + this.number;
    String str = getString(2131696871, new Object[] { paramIntent });
    SpannableString localSpannableString = new SpannableString(str);
    int j = str.indexOf(paramIntent);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), j, paramIntent.length() + j, 17);
    ((TextView)findViewById(2131372298)).setText(localSpannableString);
    this.aP = ((EditText)findViewById(2131381486));
    this.aP.addTextChangedListener(this);
    this.aP.setOnKeyListener(this);
    this.X = ((Button)findViewById(2131377990));
    this.X.setOnClickListener(this);
    this.Nd = ((TextView)findViewById(2131377182));
    this.Nd.setOnClickListener(this);
    crf();
  }
  
  private void cqU()
  {
    this.aP.postDelayed(new BindVerifyActivity.7(this), 300L);
  }
  
  private void zE(String paramString)
  {
    cqU();
    report("dc00898", "0X8009F18", 0);
    if (!aqiw.isNetSupport(this)) {
      showToast(2131696348);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("BindVerifyActivity", 2, "doCommit cur: " + this.awY);
      }
    } while (this.awY);
    this.awY = true;
    if (this.i == null)
    {
      this.i = new zqe(this);
      this.app.registObserver(this.i);
    }
    this.f.d(paramString, this.bindType, this.bsj, this.bsk);
    j(2131719519, 1000L, true);
    this.uiHandler.sendEmptyMessageDelayed(4, 30000L);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.uiHandler.sendEmptyMessageDelayed(3, 100L);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() > 0)
    {
      this.X.setEnabled(true);
      return;
    }
    this.X.setEnabled(false);
  }
  
  public void bK(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("k_uin");
    paramBundle = getPhoneNumber();
    localObject = getResources().getString(2131696845, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
    int j = ((String)localObject).indexOf(paramBundle);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), j, paramBundle.length() + j, 17);
    paramBundle = aqha.a(this, 230, null, (CharSequence)localObject, getString(2131721058), getString(2131721079), new zqg(this), new zqh(this));
    if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
      paramBundle.show();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void cre()
  {
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      anot.a(this.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
    }
    if (getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("bind_mobile", getPhoneNumber());
      ((Intent)localObject).putExtra("check_permission_result", "");
      setResult(-1, (Intent)localObject);
      finish();
      return;
    }
    if (this.mSource == 10)
    {
      setResult(-1, null);
      finish();
      return;
    }
    if (this.mSource == 21)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("bind_mobile", getPhoneNumber());
      setResult(-1, (Intent)localObject);
      finish();
      return;
    }
    Object localObject = new BindVerifyActivity.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this, new zqf(this));
    yuw.a(this, this.app, (Runnable)localObject, localDenyRunnable);
  }
  
  public void crf()
  {
    this.awY = false;
    this.X.setEnabled(false);
    this.aP.setText("");
    this.aP.setHint(acfp.m(2131703228));
    this.Nd.setText(acfp.m(2131703232));
    this.Nd.setEnabled(false);
    this.Nd.setTextColor(getResources().getColor(2131167379));
    this.uiHandler.removeMessages(1);
    this.uiHandler.sendMessageDelayed(this.uiHandler.obtainMessage(1, 60, 0), 1000L);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.mSource == 10) {
      anot.a(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
    }
    QQAppInterface localQQAppInterface;
    if (getIntent().getBooleanExtra("k_is_block", false))
    {
      localQQAppInterface = this.app;
      if (gj().length() < 4) {
        break label107;
      }
    }
    label107:
    for (int j = 1;; j = 0)
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", j, 0, "", "", "", "");
      setResult(0);
      super.doOnBackPressed();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.bsj = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.bsk = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.mSource = getIntent().getIntExtra("kSrouce", -1);
    this.cez = getIntent().getIntExtra("keyReqBindMode", 0);
    getWindow().setSoftInputMode(18);
    setContentView(2131559740);
    if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BindVerifyActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.bsj), Boolean.valueOf(this.bsk), Integer.valueOf(this.mSource) }));
      }
      cE(getIntent());
      this.smsContent = new adae(null, System.currentTimeMillis());
      this.smsContent.a(this, this);
      report("dc00898", "0X8009F17", 0);
      return true;
      paramBundle = (BounceScrollView)findViewById(2131363711);
      if (paramBundle != null) {
        paramBundle.setOnSizeChangeListener(this);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.i != null)
    {
      this.app.unRegistObserver(this.i);
      this.i = null;
    }
    if (this.g != null)
    {
      this.app.unRegistObserver(this.g);
      this.g = null;
    }
    if (this.smsContent != null) {
      this.smsContent.unregister();
    }
    this.uiHandler.removeCallbacksAndMessages(null);
    this.aP.removeTextChangedListener(this);
    this.aP.setKeyListener(null);
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    cE(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnPause");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnResume");
    }
    if (gj().length() == 0) {
      cqU();
    }
  }
  
  public String getPhoneNumber()
  {
    return this.countryCode + " " + this.number;
  }
  
  public String gj()
  {
    String str = "";
    Object localObject = this.aP.getText();
    if (localObject != null) {
      str = localObject.toString();
    }
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = aqft.bX(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      this.uiHandler.obtainMessage(2, paramString1).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        int j = paramMessage.arg1 - 1;
        paramMessage.arg1 = j;
        if (j <= 0)
        {
          this.Nd.setEnabled(true);
          this.Nd.setTextColor(getResources().getColor(2131166145));
          this.Nd.setText(acfp.m(2131703229));
          this.aP.setText("");
          return true;
        }
        this.Nd.setEnabled(false);
        this.Nd.setTextColor(getResources().getColor(2131167379));
        this.Nd.setText(String.format(acfp.m(2131703226), new Object[] { Integer.valueOf(j) }));
        this.uiHandler.sendMessageDelayed(this.uiHandler.obtainMessage(1, j, 0), 1000L);
        return true;
        this.aP.setText((String)paramMessage.obj);
        return true;
        this.uiHandler.removeMessages(3);
        paramMessage = (BounceScrollView)findViewById(2131363711);
      } while (paramMessage == null);
      paramMessage.fullScroll(130);
      return true;
      this.awY = false;
      this.uiHandler.removeMessages(4);
      VI();
      aL(1, getString(2131718828));
    } while (!QLog.isColorLevel());
    QLog.i("BindVerifyActivity", 2, "MSG_REQUEST_TIMEOUT");
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (gj().length() <= 0) {
        break label31;
      }
      this.X.setEnabled(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label31:
      this.X.setEnabled(false);
    }
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
      doOnBackPressed();
      continue;
      if (this.g == null)
      {
        this.g = new zqd(this);
        this.app.registObserver(this.g);
      }
      if (this.cez == 1) {
        this.f.b(this.countryCode, this.number, this.bindType, this.bsj, this.bsk);
      }
      for (;;)
      {
        j(2131719519, 1000L, true);
        report("dc00898", "0X8009F1A", 0);
        break;
        this.f.dP(this.countryCode, this.number);
      }
      zE(gj());
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (gj().length() >= 4)) {
      zE(gj());
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void report(String paramString1, String paramString2, int paramInt)
  {
    anot.a(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */