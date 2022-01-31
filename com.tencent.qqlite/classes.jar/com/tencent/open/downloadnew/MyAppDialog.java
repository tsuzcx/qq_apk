package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class MyAppDialog
{
  QQCustomDialog a;
  
  public MyAppDialog(Context paramContext)
  {
    this.a = DialogUtil.a(paramContext, 0);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.show();
    }
  }
  
  public void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (this.a != null) {
      this.a.setPositiveButton(paramInt, paramOnClickListener);
    }
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.a != null) {
      this.a.setOnCancelListener(paramOnCancelListener);
    }
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.a != null) {
      this.a.setOnDismissListener(paramOnDismissListener);
    }
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.setTitle(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setCancelable(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.a != null) {
      return this.a.isShowing();
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      this.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (this.a != null) {
      this.a.setNegativeButton(paramInt, paramOnClickListener);
    }
  }
  
  public void b(String paramString)
  {
    if (this.a != null) {
      this.a.setMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog
 * JD-Core Version:    0.7.0.1
 */