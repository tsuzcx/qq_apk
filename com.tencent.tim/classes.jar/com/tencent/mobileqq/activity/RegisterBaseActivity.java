package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.ViewGroup;
import arie;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import vri;

public class RegisterBaseActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  protected boolean aRR = true;
  protected ViewGroup cX;
  public String countryCode = "86";
  protected Dialog dialog;
  protected Handler handler = new vri(this);
  protected String phoneNum;
  
  protected void Bv(int paramInt)
  {
    try
    {
      this.handler.post(new RegisterBaseActivity.4(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void J(int paramInt1, int paramInt2)
  {
    new arie(this).V(paramInt1, getTitleBarHeight(), 1, paramInt2);
  }
  
  public void cq(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    new arie(this).p(str, getTitleBarHeight(), 0, paramInt);
  }
  
  public void dt(String paramString1, String paramString2)
  {
    try
    {
      this.handler.post(new RegisterBaseActivity.2(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void gV()
  {
    this.handler.post(new RegisterBaseActivity.3(this));
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
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity
 * JD-Core Version:    0.7.0.1
 */