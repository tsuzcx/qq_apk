package com.tencent.token;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class ge
{
  static int a = -1;
  private static boolean b = false;
  
  public static ge a(Activity paramActivity, gd paramgd)
  {
    return a(paramActivity, paramActivity.getWindow(), paramgd);
  }
  
  public static ge a(Dialog paramDialog, gd paramgd)
  {
    return a(paramDialog.getContext(), paramDialog.getWindow(), paramgd);
  }
  
  private static ge a(Context paramContext, Window paramWindow, gd paramgd)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new gg(paramContext, paramWindow, paramgd);
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new gi(paramContext, paramWindow, paramgd);
    }
    return new gh(paramContext, paramWindow, paramgd);
  }
  
  public static boolean l()
  {
    return b;
  }
  
  public abstract ActionBar a();
  
  public abstract <T extends View> T a(int paramInt);
  
  public abstract gw a(gw.a parama);
  
  public abstract void a(Configuration paramConfiguration);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(Toolbar paramToolbar);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public abstract MenuInflater b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void b(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void c();
  
  public abstract boolean c(int paramInt);
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract gc.a i();
  
  public abstract void j();
  
  public abstract boolean k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ge
 * JD-Core Version:    0.7.0.1
 */