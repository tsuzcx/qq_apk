package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import anxk;
import aqha;
import aqiw;
import aqju;
import arhz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class SubAccountBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  public String aOa;
  private arhz g;
  private aqju mDialog;
  
  public boolean QM()
  {
    return aqiw.isNetSupport(BaseApplication.getContext());
  }
  
  public boolean QN()
  {
    boolean bool = QM();
    if (!bool) {
      wz(getString(2131693404));
    }
    return bool;
  }
  
  public void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    aff();
    this.mDialog = aqha.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.mDialog.setPositiveButton(2131691970, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setNegativeButton(2131721058, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
  
  public void aff()
  {
    if ((this.mDialog != null) && (this.mDialog.isShowing())) {}
    try
    {
      this.mDialog.dismiss();
      label24:
      this.mDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void ath()
  {
    if ((this.g != null) && (this.g.isShowing())) {}
    try
    {
      this.g.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    aff();
    this.mDialog = aqha.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.mDialog.setPositiveButton(2131691970, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
  
  protected void bVG() {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.aOa = getIntent().getStringExtra("fromWhere");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    anxk localanxk = (anxk)this.app.getManager(62);
    if (localanxk != null) {
      localanxk.a(this);
    }
  }
  
  public void finish()
  {
    ath();
    aff();
    super.finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramDialogInterface.dismiss();
      return;
    }
    bVG();
  }
  
  public void wA(String paramString)
  {
    QQToast.a(this, 2, paramString, 0).show(getTitleBarHeight());
  }
  
  public void wz(String paramString)
  {
    QQToast.a(this, paramString, 0).show(getTitleBarHeight());
  }
  
  public void yC(int paramInt)
  {
    if (this.g == null)
    {
      this.g = new arhz(this, getTitleBarHeight());
      this.g.setBackAndSearchFilter(true);
    }
    if (paramInt > 0) {
      this.g.setMessage(paramInt);
    }
    for (;;)
    {
      if ((this.g != null) && (!this.g.isShowing()) && (!isFinishing())) {
        this.g.show();
      }
      return;
      this.g.setMessage(2131696693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBaseActivity
 * JD-Core Version:    0.7.0.1
 */