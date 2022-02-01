package com.huawei.updatesdk.service.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.huawei.updatesdk.service.otaupdate.g;

public class a
{
  private b a;
  private Context b;
  private String c;
  private CharSequence d;
  private AlertDialog e;
  private AlertDialog.Builder f;
  private DialogInterface.OnShowListener g;
  private DialogInterface.OnDismissListener h;
  
  protected a(Context paramContext, String paramString, CharSequence paramCharSequence)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = paramCharSequence;
    this.f = new AlertDialog.Builder(paramContext);
    this.f.setTitle(this.c);
    this.f.setPositiveButton(g.b(paramContext, "upsdk_third_app_dl_sure_cancel_download"), null);
    this.f.setNegativeButton(g.b(paramContext, "upsdk_cancel"), null);
    this.f.setMessage(this.d);
  }
  
  public static a a(Context paramContext, String paramString, CharSequence paramCharSequence)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return new c(paramContext, paramString, paramCharSequence);
    }
    return new a(paramContext, paramString, paramCharSequence);
  }
  
  public void a()
  {
    if (this.f == null) {
      return;
    }
    this.f.setNegativeButton(null, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (com.huawei.updatesdk.service.e.b.a().b() >= 11)
    {
      Button localButton = null;
      if (this.e != null) {
        localButton = this.e.getButton(-1);
      }
      if (localButton != null)
      {
        localButton.setBackgroundResource(paramInt1);
        localButton.setTextColor(this.b.getResources().getColor(paramInt2));
      }
    }
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.h = paramOnDismissListener;
  }
  
  public void a(DialogInterface.OnKeyListener paramOnKeyListener)
  {
    if (this.e != null) {
      this.e.setOnKeyListener(paramOnKeyListener);
    }
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.g = paramOnShowListener;
  }
  
  public void a(View paramView)
  {
    if (this.f != null)
    {
      int i = com.huawei.updatesdk.service.e.b.a().b();
      if ((i < 11) || (i >= 17))
      {
        ImageView localImageView = (ImageView)paramView.findViewById(g.a(paramView.getContext(), "divider"));
        if (localImageView != null) {
          localImageView.setVisibility(8);
        }
      }
      this.f.setMessage(null);
      this.f.setView(paramView);
    }
  }
  
  public void a(a parama, String paramString)
  {
    Button localButton = null;
    if (this.e == null) {}
    for (;;)
    {
      return;
      if (parama == a.a) {
        localButton = this.e.getButton(-1);
      }
      while (localButton != null)
      {
        localButton.setText(paramString);
        localButton.setAllCaps(true);
        return;
        if (parama == a.b) {
          localButton = this.e.getButton(-2);
        }
      }
    }
  }
  
  public void a(b paramb)
  {
    if ((this.b == null) || (((Activity)this.b).isFinishing()))
    {
      if (paramb != null) {
        paramb.a();
      }
      return;
    }
    if (!b()) {
      try
      {
        this.e = this.f.create();
        this.e.setCanceledOnTouchOutside(false);
        this.e.setOnShowListener(new a.1(this));
        this.e.setOnDismissListener(new a.2(this));
        this.e.show();
        return;
      }
      catch (Exception localException)
      {
        if (paramb != null) {
          paramb.a();
        }
        com.huawei.updatesdk.a.a.b.a.a.a.a("BaseAlertDialog", "show dlg error, e: ", localException);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("show dlg error, mContext = ").append(this.b).append(", mContext.isFinishing is ");
    if (this.b == null) {}
    for (paramb = "mContext == null";; paramb = Boolean.valueOf(((Activity)this.b).isFinishing()))
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("BaseAlertDialog", paramb);
      return;
    }
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.e != null) {
      this.e.setCancelable(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.e != null) && (this.e.isShowing());
  }
  
  public void c()
  {
    try
    {
      if (this.e != null)
      {
        this.e.dismiss();
        this.e = null;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("BaseAlertDialog", "dialog dismiss IllegalArgumentException");
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.f.a
 * JD-Core Version:    0.7.0.1
 */