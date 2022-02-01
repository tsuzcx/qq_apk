package com.tencent.mobileqq.activity;

import afrz;
import afsb;
import afsf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevConfirmPhoneNoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView Cg;
  private TextView Ch;
  private TextView Ci;
  private String QW;
  private String aKX;
  private String aKY;
  private String aKZ;
  private String aLa;
  private DevlockInfo b;
  private Button cU;
  private Button cV;
  private String mUin;
  
  private void initUI()
  {
    super.setContentView(2131561307);
    setTitle(2131693215);
    this.Cg = ((TextView)findViewById(2131379480));
    this.Ch = ((TextView)findViewById(2131379479));
    this.Ci = ((TextView)findViewById(2131379522));
    this.cU = ((Button)findViewById(2131363829));
    this.cV = ((Button)findViewById(2131363907));
    if ((QLog.isColorLevel()) && ((this.Cg == null) || (this.Ch == null) || (this.Ci == null) || (this.cU == null) || (this.cV == null)))
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "one or more controls is null! ");
      return;
    }
    onCreateRightView();
    setRightButton(2131693186, this);
    Object localObject = (TextView)findViewById(2131369579);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    if (this.aKX != null) {
      this.Cg.setText(this.aKX);
    }
    if (this.aKY != null) {
      this.Ch.setText(this.aKY);
    }
    if (this.aKZ != null) {
      this.Ci.setText(this.aKZ);
    }
    localObject = getString(2131693183);
    String str = getString(2131693217);
    this.cU.setText((CharSequence)localObject);
    this.cU.setClickable(true);
    this.cU.setOnClickListener(this);
    this.cV.setText(str);
    this.cV.setClickable(true);
    this.cV.setOnClickListener(this);
    try
    {
      afsf.a().u(null, this.app.getCurrentAccountUin(), 6);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "verify page call back resultCode = " + paramInt2);
            }
            if (paramInt2 == -1)
            {
              if (paramIntent != null) {}
              for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
              {
                paramIntent.putExtra("requestCode", paramInt1);
                setResult(-1, paramIntent);
                finish();
                return;
              }
            }
          } while (paramInt2 != 0);
          return;
        } while (paramIntent == null);
        localObject = paramIntent.getExtras();
      } while (localObject == null);
      paramInt2 = ((Bundle)localObject).getInt("resultState", 1);
      localObject = ((Bundle)localObject).getString("resultMobileMask");
    } while (paramInt2 == 1);
    if (paramInt2 == 2) {
      afrz.a().Nd(afrz.cTF);
    }
    for (;;)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.putExtra("requestCode", paramInt1);
      paramIntent.putExtra("phone_num", (String)localObject);
      setResult(-1, paramIntent);
      finish();
      return;
      if (paramInt2 == 3)
      {
        afrz.a().Nd(afrz.cTE);
        afrz.a().je(0L);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772013);
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click confirm mobile phone button! ");
      }
      try
      {
        afsf.a().u(null, this.app.getCurrentAccountUin(), 7);
        label78:
        Intent localIntent = new Intent(this, AuthDevVerifyCodeActivity.class);
        localIntent.putExtra("phone_num", this.b.Mobile);
        localIntent.putExtra("country_code", this.b.CountryCode);
        localIntent.putExtra("mobile_type", 0);
        startActivityForResult(localIntent, 1001);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click modify mobile phone button! ");
        }
        try
        {
          afsf.a().u(null, this.app.getCurrentAccountUin(), 8);
          label168:
          if (this.app != null) {
            this.app.sendWirelessMeibaoReq(1);
          }
          if ((!TextUtils.isEmpty(this.QW)) && (this.QW.equals("subaccount")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "subaccount enter webview mUin=" + this.mUin + " mMainAccount=" + this.aLa);
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
            }
            afsb.a(this, this.aLa, this.mUin, afsb.cTJ, 1002, null);
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mainaccount enter webview mUin=" + this.mUin);
          }
          if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
          }
          afsb.a(this, this.mUin, this.mUin, afsb.cTJ, 1002, null);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "onClick right cancel button! ");
          }
          finish();
          overridePendingTransition(0, 2130772013);
        }
        catch (Exception localException1)
        {
          break label168;
        }
      }
      catch (Exception localException2)
      {
        break label78;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.aKX = ((Bundle)localObject).getString("ParaTextUp");
    this.aKY = ((Bundle)localObject).getString("ParaTextDown");
    this.aKZ = ((Bundle)localObject).getString("PhoneNO");
    this.mUin = ((Bundle)localObject).getString("uin");
    this.QW = ((Bundle)localObject).getString("from_where");
    this.aLa = ((Bundle)localObject).getString("mainaccount");
    this.b = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphUp : " + this.aKX);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphDown : " + this.aKY);
    }
    super.onCreate(paramBundle);
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevConfirmPhoneNoActivity
 * JD-Core Version:    0.7.0.1
 */