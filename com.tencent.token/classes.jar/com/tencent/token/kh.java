package com.tencent.token;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.UserHandle;
import com.oasisfeng.condom.CondomCore;
import com.oasisfeng.condom.CondomCore.CondomEvent;
import com.oasisfeng.condom.CondomCore.e;
import com.oasisfeng.condom.CondomCore.f;
import com.oasisfeng.condom.OutboundType;

public final class kh
  extends Application
{
  private final CondomCore a;
  private final Application b;
  private final String c;
  
  public kh(CondomCore paramCondomCore, Application paramApplication, String paramString)
  {
    this.a = paramCondomCore;
    this.b = paramApplication;
    this.c = CondomCore.buildLogTag("CondomApp", "CondomApp.", paramString);
  }
  
  public final void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public final boolean bindService(final Intent paramIntent, final ServiceConnection paramServiceConnection, final int paramInt)
  {
    boolean bool = ((Boolean)this.a.proceed(OutboundType.BIND_SERVICE, paramIntent, Boolean.FALSE, new CondomCore.f() {})).booleanValue();
    if (bool) {
      this.a.logIfOutboundPass(this.c, paramIntent, CondomCore.getTargetPackage(paramIntent), CondomCore.CondomEvent.BIND_PASS);
    }
    return bool;
  }
  
  public final int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == Process.myPid()) && (paramInt2 == Process.myUid()) && (this.a.shouldSpoofPermission(paramString))) {
      return 0;
    }
    return super.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  public final int checkSelfPermission(String paramString)
  {
    if (this.a.shouldSpoofPermission(paramString)) {
      return 0;
    }
    return super.checkSelfPermission(paramString);
  }
  
  public final Context getApplicationContext()
  {
    return this;
  }
  
  public final Context getBaseContext()
  {
    this.a.logConcern(this.c, "Application.getBaseContext");
    return super.getBaseContext();
  }
  
  public final ContentResolver getContentResolver()
  {
    return this.a.getContentResolver();
  }
  
  public final PackageManager getPackageManager()
  {
    return this.a.getPackageManager();
  }
  
  public final Object getSystemService(String paramString)
  {
    Object localObject = this.a.getSystemService(paramString);
    if (localObject != null) {
      return localObject;
    }
    return super.getSystemService(paramString);
  }
  
  public final void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
    }
  }
  
  public final void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.registerComponentCallbacks(paramComponentCallbacks);
    }
  }
  
  public final void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.b.registerOnProvideAssistDataListener(paramOnProvideAssistDataListener);
    }
  }
  
  public final void sendBroadcast(final Intent paramIntent)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendBroadcast(paramIntent);
      }
    }, null);
  }
  
  public final void sendBroadcast(final Intent paramIntent, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendBroadcast(paramIntent, paramString);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendBroadcastAsUser(paramIntent, paramUserHandle);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendBroadcastAsUser(paramIntent, paramUserHandle, paramString);
      }
    }, null);
  }
  
  public final void sendOrderedBroadcast(final Intent paramIntent, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendOrderedBroadcast(paramIntent, paramString);
      }
    }, null);
  }
  
  public final void sendOrderedBroadcast(final Intent paramIntent, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyBroadcast(final Intent paramIntent)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendStickyBroadcast(paramIntent);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendStickyBroadcastAsUser(paramIntent, paramUserHandle);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyOrderedBroadcast(final Intent paramIntent, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        kh.a(kh.this).sendStickyOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  public final ComponentName startService(final Intent paramIntent)
  {
    ComponentName localComponentName = (ComponentName)this.a.proceed(OutboundType.START_SERVICE, paramIntent, null, new CondomCore.f() {});
    if (localComponentName != null) {
      this.a.logIfOutboundPass(this.c, paramIntent, localComponentName.getPackageName(), CondomCore.CondomEvent.START_PASS);
    }
    return localComponentName;
  }
  
  public final void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
    }
  }
  
  public final void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.unregisterComponentCallbacks(paramComponentCallbacks);
    }
  }
  
  public final void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.b.unregisterOnProvideAssistDataListener(paramOnProvideAssistDataListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kh
 * JD-Core Version:    0.7.0.1
 */