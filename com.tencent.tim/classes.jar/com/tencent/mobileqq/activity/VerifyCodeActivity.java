package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import aqcu;
import assi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyCodeManager;
import mqq.observer.ServerNotifyObserver;
import wfg;
import wfh;
import wfi;
import wfj;
import wfk;

public class VerifyCodeActivity
  extends IphoneTitleBarActivity
{
  public ClearableEditText a;
  VerifyCodeManager a;
  public ImageView bE;
  private View bm;
  View.OnClickListener dE = new wfk(this);
  public TextView dU;
  private TextView dV;
  public boolean isRefresh = false;
  public boolean isSend;
  private AppInterface mApp;
  public ServerNotifyObserver serverNotifyObserver = new wfg(this);
  final int xA = 4;
  
  private void aC()
  {
    setTitle(2131721677);
    setLeftButton(2131721058, new wfh(this));
    setRightHighlightButton(2131721066, new wfi(this));
  }
  
  private void ci(Intent paramIntent)
  {
    Object localObject4 = null;
    aC();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("image");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          i = paramIntent.getIntExtra("seq", 0);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject3;
            int i = 0;
            paramIntent = null;
            localObject2 = localObject1;
            localObject1 = localException2;
          }
        }
        try
        {
          localObject2 = paramIntent.getStringExtra("key");
        }
        catch (Exception localException3)
        {
          paramIntent = null;
          localObject2 = localObject1;
          localObject1 = localException3;
          break label210;
        }
        try
        {
          localObject3 = paramIntent.getStringExtra("note");
          paramIntent = (Intent)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            this.dV.setText((CharSequence)localObject3);
          }
          localObject2 = paramIntent;
          if (paramIntent == null) {
            localObject2 = "";
          }
          if (arrayOfByte != null) {
            this.bE.setImageBitmap(aqcu.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
          }
          this.serverNotifyObserver.setSeq(i);
          this.serverNotifyObserver.setKey((String)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131369304));
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new wfj(this));
          this.bm = findViewById(2131382106);
          this.dU = ((TextView)findViewById(2131377030));
          this.jdField_a_of_type_MqqManagerVerifyCodeManager = ((VerifyCodeManager)this.mApp.getManager(6));
          this.dU.setOnClickListener(this.dE);
          this.bE.setOnClickListener(this.dE);
          return;
        }
        catch (Exception localException4)
        {
          paramIntent = (Intent)localObject2;
          localObject2 = localObject1;
          localObject1 = localException4;
          break label210;
        }
        localException1 = localException1;
        i = 0;
        localObject2 = null;
        paramIntent = null;
      }
      label210:
      localObject3 = localObject4;
      localObject1 = localObject2;
    }
  }
  
  public void bXH()
  {
    QLog.d("VerifyCodeActivity", 1, "cancelVerifyDialog");
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.cancelVerifyCode(this.serverNotifyObserver);
    }
    finish();
  }
  
  public void by(boolean paramBoolean)
  {
    QLog.d("VerifyCodeActivity", 1, new Object[] { "showWaitting isShow=", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.bm.setVisibility(0);
      this.bE.setVisibility(8);
      return;
    }
    this.bm.setVisibility(8);
    this.bE.setVisibility(0);
  }
  
  public void cG(String paramString)
  {
    QLog.d("VerifyCodeActivity", 1, "sendVerifyCode");
    this.isSend = true;
    by(true);
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.submitVerifyCode(this.serverNotifyObserver, paramString);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mApp = this.app;
    if (this.mApp == null) {
      this.mApp = ((AppInterface)getAppRuntime());
    }
    paramBundle = super.getIntent();
    if (paramBundle == null)
    {
      super.finish();
      return false;
    }
    super.setContentView(2131563305);
    setContentBackgroundResource(2130838900);
    this.bE = ((ImageView)findViewById(2131381481));
    this.dV = ((TextView)findViewById(2131372516));
    ci(paramBundle);
    assi.K(this.mApp);
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      bXH();
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void qW()
  {
    this.isRefresh = true;
    this.isSend = false;
    by(true);
    if (this.jdField_a_of_type_MqqManagerVerifyCodeManager != null) {
      this.jdField_a_of_type_MqqManagerVerifyCodeManager.refreVerifyCode(this.serverNotifyObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */