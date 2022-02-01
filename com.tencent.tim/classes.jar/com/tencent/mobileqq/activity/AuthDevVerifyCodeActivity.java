package com.tencent.mobileqq.activity;

import adac;
import adae;
import afsf;
import aklm;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import aneg;
import anot;
import aqiw;
import arhz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;
import uhq;
import uhr;
import uhs;
import uht;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements adac, TextWatcher, View.OnClickListener
{
  public static long Fn;
  public static int mSecond = 1;
  private TextView Cn;
  private TextView Co;
  aklm jdField_a_of_type_Aklm = new uhs(this);
  private a jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b;
  private boolean aRL;
  private Button aX;
  private WtloginObserver b = new uhr(this);
  private int bDZ;
  protected int bEc = -1;
  private ClearableEditText d;
  private String mFrom;
  protected Handler mHandler = new uhq(this);
  VerifyDevLockManager.VerifyDevLockObserver mVerifyObserver = new uht(this);
  private WeakReference<AppInterface> n;
  private Runnable runnableCountdown = new AuthDevVerifyCodeActivity.1(this);
  private int second = 60;
  adae smsContent;
  private arhz w;
  
  private void bGv()
  {
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
      return;
    }
    Object localObject1 = "";
    Object localObject2 = this.d.getText();
    if (localObject2 != null)
    {
      localObject2 = localObject2.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        AppInterface localAppInterface = (AppInterface)this.n.get();
        localObject2 = "";
        if (localAppInterface != null) {
          localObject2 = localAppInterface.getAccount();
        }
        if ("f_SetFaceData".equals(this.mFrom))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "set face data commitSmsCode.begin to check smsCode=" + (String)localObject1);
          }
          anot.a(null, "dc00898", "", "", "0X800A31C", "0X800A31C", 0, 0, "", "", "", "");
          aneg.b(this.app, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$a);
          return;
        }
        if (this.aRL)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b = new b(this.mVerifyObserver);
          }
          i = afsf.a().a(localAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b, (String)localObject1);
          if (i == 0)
          {
            showProgressDialog();
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + i);
          }
          J(2131717144, 1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
        }
        int i = afsf.a().a(localAppInterface, (String)localObject2, (String)localObject1, null, this.b);
        if (i == 0)
        {
          showProgressDialog();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + i);
        }
        J(2131717144, 1);
        return;
      }
      J(2131717045, 0);
      return;
    }
  }
  
  private void bGw()
  {
    if (!aqiw.isNetSupport(this)) {
      QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
    }
    int i;
    do
    {
      AppInterface localAppInterface;
      String str;
      do
      {
        return;
        localAppInterface = (AppInterface)this.n.get();
        str = "";
        if (localAppInterface != null) {
          str = localAppInterface.getAccount();
        }
        if ("f_SetFaceData".equals(this.mFrom))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "Set Face Data startGetVerifyCode.begin");
          }
          this.Co.setVisibility(4);
          aneg.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$a);
          return;
        }
        if (!this.aRL) {
          break;
        }
        if (this.bEc != -1) {
          afsf.a().f(localAppInterface, this.bEc);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b = new b(this.mVerifyObserver);
        }
        i = afsf.a().a(localAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b);
        if (i == 0)
        {
          Bv(2131717125);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      i = afsf.a().a(localAppInterface, str, this.b);
      if (i == 0)
      {
        Bv(2131717125);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.AskDevLockSms failed ret=" + i);
  }
  
  private void bwV()
  {
    this.mHandler.post(new AuthDevVerifyCodeActivity.7(this));
  }
  
  private void restartTimer(int paramInt)
  {
    this.Cn.setEnabled(false);
    this.Cn.setClickable(false);
    mSecond = paramInt;
    Fn = System.currentTimeMillis();
    this.Cn.setText(getString(2131717113) + "(" + mSecond + ")");
    this.mHandler.postDelayed(this.runnableCountdown, 1000L);
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevVerifyCodeActivity.6(this));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.aX.setEnabled(true);
      return;
    }
    this.aX.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 21)
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 1, "onActivity requestCode == AuthDevActivity.REQ_LEGACY, resultCode is : " + paramInt2);
      if (paramInt2 == -1)
      {
        setResult(paramInt2, paramIntent);
        finish();
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ("f_SetFaceData".equals(this.mFrom)) {
      anot.a(null, "dc00898", "", "", "0X800A856", "0X800A856", 0, 0, "", "", "", "");
    }
    this.aX.setClickable(true);
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new AuthDevVerifyCodeActivity.8(this, paramString1, paramString2));
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
      bGv();
      continue;
      if (mSecond <= 1)
      {
        if ("f_SetFaceData".equals(this.mFrom)) {
          anot.a(null, "dc00898", "", "", "0X800A857", "0X800A857", 0, 0, "", "", "", "");
        }
        bGw();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131561313);
    super.setTitle(2131717154);
    QQAppInterface localQQAppInterface = this.app;
    paramBundle = localQQAppInterface;
    if (localQQAppInterface == null) {
      paramBundle = (AppInterface)getAppRuntime();
    }
    if (paramBundle == null) {
      super.finish();
    }
    for (;;)
    {
      return;
      this.n = new WeakReference(paramBundle);
      paramBundle = super.getIntent();
      this.aRL = paramBundle.getExtras().getBoolean("from_login");
      this.phoneNum = paramBundle.getExtras().getString("phone_num");
      this.countryCode = paramBundle.getExtras().getString("country_code");
      this.bEc = paramBundle.getExtras().getInt("mobile_type", -1);
      this.bDZ = paramBundle.getExtras().getInt("seq");
      this.mFrom = paramBundle.getExtras().getString("k_from");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onCreate mIsFromLogin = " + this.aRL + " mVerifySeq=" + this.bDZ + " phoneNum=" + this.phoneNum);
      }
      this.Co = ((TextView)super.findViewById(2131381120));
      this.d = ((ClearableEditText)super.findViewById(2131372579));
      this.d.addTextChangedListener(this);
      this.aX = ((Button)super.findViewById(2131365224));
      this.aX.setOnClickListener(this);
      this.Co.setText(getString(2131717145, new Object[] { this.phoneNum }));
      this.Cn = ((TextView)super.findViewById(2131363970));
      this.Cn.setOnClickListener(this);
      this.Cn.setText(getString(2131717113));
      if (AppSetting.enableTalkBack)
      {
        this.aX.setContentDescription(getString(2131721079));
        this.Cn.setContentDescription(getString(2131717113));
      }
      this.mVerifyObserver.setSeq(this.bDZ);
      this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$a = new a(this.jdField_a_of_type_Aklm);
      try
      {
        this.smsContent = new adae(null);
        this.smsContent.a(this, this);
        l = System.currentTimeMillis() - Fn;
        if (l >= 59000L)
        {
          mSecond = 1;
          if (mSecond > 1)
          {
            this.Cn.setEnabled(false);
            this.Cn.setClickable(false);
            this.Cn.setText(getString(2131717113) + "(" + mSecond + ")");
            this.mHandler.postDelayed(this.runnableCountdown, 1000L);
          }
          if (mSecond > 1) {
            continue;
          }
          if (!"f_SetFaceData".equals(this.mFrom)) {
            break label566;
          }
          restartTimer(60);
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          long l;
          paramBundle.printStackTrace();
          continue;
          mSecond = (int)((60000L - l) / 1000L);
        }
        label566:
        bGw();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.smsContent != null) {}
    try
    {
      this.smsContent.unregister();
      this.smsContent = null;
      this.handler.removeCallbacksAndMessages(null);
      this.mHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b.aoc();
        this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity$b = null;
      }
      gV();
      bwV();
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
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static class a
    extends aklm
  {
    private WeakReference<aklm> af;
    
    public a(aklm paramaklm)
    {
      this.af = new WeakReference(paramaklm);
    }
    
    public void dg(String paramString1, String paramString2)
    {
      aklm localaklm = (aklm)this.af.get();
      if (localaklm != null)
      {
        localaklm.dg(paramString1, paramString2);
        return;
      }
      super.dg(paramString1, paramString2);
    }
    
    public void onFailedResponse(String paramString1, int paramInt, String paramString2)
    {
      aklm localaklm = (aklm)this.af.get();
      if (localaklm != null)
      {
        localaklm.onFailedResponse(paramString1, paramInt, paramString2);
        return;
      }
      super.onFailedResponse(paramString1, paramInt, paramString2);
    }
    
    public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
    {
      aklm localaklm = (aklm)this.af.get();
      if (localaklm != null)
      {
        localaklm.sendSmsCodeSuccess(paramRspBody);
        return;
      }
      super.sendSmsCodeSuccess(paramRspBody);
    }
    
    public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
    {
      aklm localaklm = (aklm)this.af.get();
      if (localaklm != null)
      {
        localaklm.verifySmsCodeSuccess(paramRspBody);
        return;
      }
      super.verifySmsCodeSuccess(paramRspBody);
    }
  }
  
  static class b
    extends VerifyDevLockManager.VerifyDevLockObserver
  {
    private WeakReference<VerifyDevLockManager.VerifyDevLockObserver> dE;
    
    public b(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
    {
      this.dE = new WeakReference(paramVerifyDevLockObserver);
    }
    
    public void aoc()
    {
      this.dE.clear();
      this.dE = null;
    }
    
    public int getSeq()
    {
      if (this.dE != null)
      {
        VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.dE.get();
        if (localVerifyDevLockObserver != null) {
          return localVerifyDevLockObserver.getSeq();
        }
      }
      return super.getSeq();
    }
    
    public void onRecvNotice(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
    {
      if (this.dE != null)
      {
        VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.dE.get();
        if (localVerifyDevLockObserver != null) {
          localVerifyDevLockObserver.onRecvNotice(paramNotifyType, paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
        }
      }
    }
    
    public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
    {
      if (this.dE != null)
      {
        VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.dE.get();
        if (localVerifyDevLockObserver != null) {
          localVerifyDevLockObserver.onVerifyClose(paramInt1, paramString, paramInt2, paramErrMsg);
        }
      }
    }
    
    public void setSeq(int paramInt)
    {
      if (this.dE != null)
      {
        VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.dE.get();
        if (localVerifyDevLockObserver != null)
        {
          localVerifyDevLockObserver.setSeq(paramInt);
          return;
        }
      }
      super.setSeq(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */