package com.huawei.hms.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.HMSLog;

public abstract class a
{
  private Activity a;
  private AlertDialog b;
  private a c;
  
  private static int e(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  protected AlertDialog a(Activity paramActivity)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(e(), f());
    String str = c(paramActivity);
    if (str != null) {
      localBuilder.setTitle(str);
    }
    str = a(paramActivity);
    if (str != null) {
      localBuilder.setMessage(str);
    }
    str = b(paramActivity);
    if (str != null) {
      localBuilder.setPositiveButton(str, new a.1(this));
    }
    paramActivity = d(paramActivity);
    if (paramActivity != null) {
      localBuilder.setNegativeButton(paramActivity, new a.2(this));
    }
    return localBuilder.create();
  }
  
  protected abstract String a(Context paramContext);
  
  public void a()
  {
    if (this.b != null) {
      this.b.cancel();
    }
  }
  
  public void a(Activity paramActivity, a parama)
  {
    this.a = paramActivity;
    this.c = parama;
    if ((this.a == null) || (this.a.isFinishing()))
    {
      HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
      return;
    }
    this.b = a(this.a);
    this.b.setCanceledOnTouchOutside(false);
    this.b.setOnCancelListener(new a.3(this));
    this.b.setOnKeyListener(new a.4(this));
    this.b.show();
  }
  
  protected abstract String b(Context paramContext);
  
  public void b()
  {
    if (this.b != null) {
      this.b.dismiss();
    }
  }
  
  protected abstract String c(Context paramContext);
  
  protected void c()
  {
    if (this.c != null) {
      this.c.b(this);
    }
  }
  
  protected abstract String d(Context paramContext);
  
  protected void d()
  {
    if (this.c != null) {
      this.c.a(this);
    }
  }
  
  protected Activity e()
  {
    return this.a;
  }
  
  protected int f()
  {
    if ((e(this.a) != 0) && (Build.VERSION.SDK_INT >= 16)) {
      return 0;
    }
    return 3;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void b(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.a.a
 * JD-Core Version:    0.7.0.1
 */