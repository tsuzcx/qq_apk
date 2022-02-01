package com.tencent.token;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegateImplV9;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

class gh
  extends AppCompatDelegateImplV9
{
  boolean o = true;
  private int w = -100;
  private boolean x;
  private b y;
  
  gh(Context paramContext, Window paramWindow, gd paramgd)
  {
    super(paramContext, paramWindow, paramgd);
  }
  
  private void t()
  {
    if (this.y == null) {
      this.y = new b(gm.a(this.b));
    }
  }
  
  private boolean u()
  {
    PackageManager localPackageManager;
    if ((this.x) && ((this.b instanceof Activity))) {
      localPackageManager = this.b.getPackageManager();
    }
    try
    {
      int i = localPackageManager.getActivityInfo(new ComponentName(this.b, this.b.getClass()), 0).configChanges;
      return (i & 0x200) == 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
    return true;
  }
  
  public final View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if ((paramBundle != null) && (this.w == -100)) {
      this.w = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    int i = this.w;
    if (i != -100) {
      paramBundle.putInt("appcompat:local_night_mode", i);
    }
  }
  
  public final void d()
  {
    super.d();
    k();
  }
  
  public final void e()
  {
    super.e();
    b localb = this.y;
    if (localb != null) {
      localb.a();
    }
  }
  
  int f(int paramInt)
  {
    if (paramInt != -100)
    {
      if (paramInt != 0) {
        return paramInt;
      }
      t();
      b localb = this.y;
      localb.b = localb.a.a();
      if (localb.b) {
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  public final void h()
  {
    super.h();
    b localb = this.y;
    if (localb != null) {
      localb.a();
    }
  }
  
  public final boolean k()
  {
    int i = this.w;
    if (i == -100) {
      i = ge.a;
    }
    int j = f(i);
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (j != -1)
    {
      localObject = this.b.getResources();
      Configuration localConfiguration = ((Resources)localObject).getConfiguration();
      int k = localConfiguration.uiMode;
      if (j == 2) {
        j = 32;
      } else {
        j = 16;
      }
      bool1 = bool2;
      if ((k & 0x30) != j)
      {
        if (u())
        {
          ((Activity)this.b).recreate();
        }
        else
        {
          localConfiguration = new Configuration(localConfiguration);
          DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
          localConfiguration.uiMode = (j | localConfiguration.uiMode & 0xFFFFFFCF);
          ((Resources)localObject).updateConfiguration(localConfiguration, localDisplayMetrics);
          if (Build.VERSION.SDK_INT < 26) {
            if (Build.VERSION.SDK_INT >= 24) {
              gj.c((Resources)localObject);
            } else if (Build.VERSION.SDK_INT >= 23) {
              gj.b((Resources)localObject);
            } else if (Build.VERSION.SDK_INT >= 21) {
              gj.a((Resources)localObject);
            }
          }
        }
        bool1 = true;
      }
    }
    if (i == 0)
    {
      t();
      localObject = this.y;
      ((b)localObject).a();
      if (((b)localObject).c == null) {
        ((b)localObject).c = new gh.b.1((b)localObject);
      }
      if (((b)localObject).d == null)
      {
        ((b)localObject).d = new IntentFilter();
        ((b)localObject).d.addAction("android.intent.action.TIME_SET");
        ((b)localObject).d.addAction("android.intent.action.TIMEZONE_CHANGED");
        ((b)localObject).d.addAction("android.intent.action.TIME_TICK");
      }
      ((b)localObject).e.b.registerReceiver(((b)localObject).c, ((b)localObject).d);
    }
    this.x = true;
    return bool1;
  }
  
  class a
    extends gf.b
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    final ActionMode a(ActionMode.Callback paramCallback)
    {
      paramCallback = new ha.a(gh.this.b, paramCallback);
      gw localgw = gh.this.a(paramCallback);
      if (localgw != null) {
        return paramCallback.b(localgw);
      }
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (gh.this.o) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
  }
  
  final class b
  {
    gm a;
    boolean b;
    BroadcastReceiver c;
    IntentFilter d;
    
    b(gm paramgm)
    {
      this.a = paramgm;
      this.b = paramgm.a();
    }
    
    final void a()
    {
      if (this.c != null)
      {
        gh.this.b.unregisterReceiver(this.c);
        this.c = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gh
 * JD-Core Version:    0.7.0.1
 */