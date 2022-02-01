package com.tencent.mobileqq.activity;

import accn;
import accy;
import android.content.Intent;
import android.os.Bundle;
import anot;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import vjm;
import vjn;
import vjo;
import vjp;

public class NotifyPCActiveActivity
  extends BaseActivity
{
  public static NotifyPCActiveActivity a;
  private int bIF;
  private accn cardObserver = new vjp(this);
  private aqju dialog;
  
  private void Bj(int paramInt)
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    this.dialog = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.dialog != null)
      {
        this.dialog.setCancelable(false);
        this.dialog.show();
      }
      return;
      this.app.addObserver(this.cardObserver, true);
      Object localObject1 = (CardHandler)this.app.getBusinessHandler(2);
      Object localObject3 = getIntent().getExtras();
      Object localObject2 = ((Bundle)localObject3).getString("Message");
      String str = ((Bundle)localObject3).getString("lButton");
      localObject3 = ((Bundle)localObject3).getString("rButton");
      this.dialog = aqha.a(this, 230);
      this.dialog.setContentView(2131559127);
      this.dialog.setTitle(null).setMessage((CharSequence)localObject2).setPositiveButton((String)localObject3, new vjn(this, (CardHandler)localObject1)).setNegativeButton(str, new vjm(this));
      continue;
      localObject2 = getIntent().getExtras();
      localObject1 = ((Bundle)localObject2).getString("Message");
      localObject2 = ((Bundle)localObject2).getString("button");
      this.dialog = aqha.a(this, 230).setMessage((CharSequence)localObject1).setPositiveButton((String)localObject2, new vjo(this));
    }
  }
  
  private void bRT()
  {
    accy localaccy = (accy)this.app.getBusinessHandler(4);
    if (localaccy != null) {
      localaccy.close();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559712);
    a = this;
    this.bIF = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationActivity", 2, "NotificationActivity action = " + paramBundle);
    }
    if ("mqq.intent.action.PCACTIVE_TIPS".equals(paramBundle))
    {
      anot.a(null, "CliOper", "", "", "0X8004975", "0X8004975", 0, 0, "", "", "", "");
      this.bIF = 1;
      bRT();
    }
    for (;;)
    {
      Bj(this.bIF);
      return false;
      if ("mqq.intent.action.NOTICE_ON_PCACTIVE".equals(paramBundle)) {
        this.bIF = 2;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.cardObserver);
    super.doOnDestroy();
    if (a != null) {
      a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotifyPCActiveActivity", 2, "Running in doOnDestroy()");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    this.dialog = null;
    super.finish();
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity
 * JD-Core Version:    0.7.0.1
 */