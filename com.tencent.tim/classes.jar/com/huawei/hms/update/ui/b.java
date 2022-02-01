package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.HMSLog;

public abstract class b
{
  private AlertDialog a;
  private a b;
  
  private static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  protected abstract AlertDialog a();
  
  public void a(a parama)
  {
    this.b = parama;
    if ((f() == null) || (f().isFinishing()))
    {
      HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
      return;
    }
    this.a = a();
    this.a.setCanceledOnTouchOutside(false);
    this.a.setOnCancelListener(new b.1(this));
    this.a.show();
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.cancel();
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.dismiss();
    }
  }
  
  protected void d()
  {
    if (this.b != null) {
      this.b.a(this);
    }
  }
  
  protected void e()
  {
    if (this.b != null) {
      this.b.b(this);
    }
  }
  
  protected Activity f()
  {
    if (this.b != null) {
      return this.b.b();
    }
    return null;
  }
  
  protected int g()
  {
    if ((a(f()) != 0) && (Build.VERSION.SDK_INT >= 16)) {
      return 0;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.b
 * JD-Core Version:    0.7.0.1
 */