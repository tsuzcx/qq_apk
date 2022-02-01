package com.oasisfeng.condom;

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
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.Size;

class a
  extends Application
{
  private final CondomCore a;
  private final Application b;
  private final String c;
  
  a(CondomCore paramCondomCore, Application paramApplication, @Nullable @Size(max=13L) String paramString)
  {
    this.a = paramCondomCore;
    this.b = paramApplication;
    this.c = CondomCore.buildLogTag("CondomApp", "CondomApp.", paramString);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public boolean bindService(final Intent paramIntent, final ServiceConnection paramServiceConnection, final int paramInt)
  {
    boolean bool = ((Boolean)this.a.proceed(OutboundType.BIND_SERVICE, paramIntent, Boolean.FALSE, new CondomCore.f()
    {
      public Boolean a()
      {
        return Boolean.valueOf(a.a(a.this).bindService(paramIntent, paramServiceConnection, paramInt));
      }
    })).booleanValue();
    if (bool) {
      this.a.logIfOutboundPass(this.c, paramIntent, CondomCore.getTargetPackage(paramIntent), CondomCore.CondomEvent.BIND_PASS);
    }
    return bool;
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == Process.myPid()) && (paramInt2 == Process.myUid()) && (this.a.shouldSpoofPermission(paramString))) {
      return 0;
    }
    return super.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  @RequiresApi(23)
  public int checkSelfPermission(String paramString)
  {
    if (this.a.shouldSpoofPermission(paramString)) {
      return 0;
    }
    return super.checkSelfPermission(paramString);
  }
  
  public Context getApplicationContext()
  {
    return this;
  }
  
  public Context getBaseContext()
  {
    this.a.logConcern(this.c, "Application.getBaseContext");
    return super.getBaseContext();
  }
  
  public ContentResolver getContentResolver()
  {
    return this.a.getContentResolver();
  }
  
  public PackageManager getPackageManager()
  {
    return this.a.getPackageManager();
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject = this.a.getSystemService(paramString);
    if (localObject != null) {
      return localObject;
    }
    return super.getSystemService(paramString);
  }
  
  public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
    }
  }
  
  public void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.registerComponentCallbacks(paramComponentCallbacks);
    }
  }
  
  public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.b.registerOnProvideAssistDataListener(paramOnProvideAssistDataListener);
    }
  }
  
  public void sendBroadcast(final Intent paramIntent)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendBroadcast(paramIntent);
      }
    }, null);
  }
  
  public void sendBroadcast(final Intent paramIntent, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendBroadcast(paramIntent, paramString);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendBroadcastAsUser(paramIntent, paramUserHandle);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendBroadcastAsUser(paramIntent, paramUserHandle, paramString);
      }
    }, null);
  }
  
  public void sendOrderedBroadcast(final Intent paramIntent, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendOrderedBroadcast(paramIntent, paramString);
      }
    }, null);
  }
  
  public void sendOrderedBroadcast(final Intent paramIntent, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyBroadcast(final Intent paramIntent)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendStickyBroadcast(paramIntent);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendStickyBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendStickyBroadcastAsUser(paramIntent, paramUserHandle);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyOrderedBroadcast(final Intent paramIntent, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  @RequiresApi(17)
  public void sendStickyOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public void a()
      {
        a.a(a.this).sendStickyOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  public ComponentName startService(final Intent paramIntent)
  {
    ComponentName localComponentName = (ComponentName)this.a.proceed(OutboundType.START_SERVICE, paramIntent, null, new CondomCore.f()
    {
      public ComponentName a()
      {
        return a.a(a.this).startService(paramIntent);
      }
    });
    if (localComponentName != null) {
      this.a.logIfOutboundPass(this.c, paramIntent, localComponentName.getPackageName(), CondomCore.CondomEvent.START_PASS);
    }
    return localComponentName;
  }
  
  public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
    }
  }
  
  public void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.b.unregisterComponentCallbacks(paramComponentCallbacks);
    }
  }
  
  public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.b.unregisterOnProvideAssistDataListener(paramOnProvideAssistDataListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.a
 * JD-Core Version:    0.7.0.1
 */