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
import com.oasisfeng.condom.CondomCore.h;
import com.oasisfeng.condom.CondomCore.l;
import com.oasisfeng.condom.CondomCore.m;
import com.oasisfeng.condom.OutboundType;

public final class ky
  extends Application
{
  private final CondomCore a;
  private final Application b;
  private final String c;
  
  public ky(CondomCore paramCondomCore, Application paramApplication, String paramString)
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
    boolean bool = ((Boolean)this.a.proceed(OutboundType.BIND_SERVICE, paramIntent, Boolean.FALSE, new e(paramIntent, paramServiceConnection, paramInt))).booleanValue();
    if (bool) {
      this.a.logIfOutboundPass(this.c, paramIntent, CondomCore.getTargetPackage(paramIntent), CondomCore.h.b);
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
    Object localObject2 = this.a.getSystemService(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = super.getSystemService(paramString);
    }
    return localObject1;
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
    this.a.proceedBroadcast(this, paramIntent, new g(paramIntent), null);
  }
  
  public final void sendBroadcast(final Intent paramIntent, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new h(paramIntent, paramString), null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.a.proceedBroadcast(this, paramIntent, new i(paramIntent, paramUserHandle), null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new j(paramIntent, paramUserHandle, paramString), null);
  }
  
  public final void sendOrderedBroadcast(final Intent paramIntent, final String paramString)
  {
    this.a.proceedBroadcast(this, paramIntent, new k(paramIntent, paramString), null);
  }
  
  public final void sendOrderedBroadcast(final Intent paramIntent, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new l(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle), paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new m(paramIntent, paramUserHandle, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle), paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyBroadcast(final Intent paramIntent)
  {
    this.a.proceedBroadcast(this, paramIntent, new a(paramIntent), null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.a.proceedBroadcast(this, paramIntent, new b(paramIntent, paramUserHandle), null);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyOrderedBroadcast(final Intent paramIntent, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new c(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle), paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public final void sendStickyOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.a.proceedBroadcast(this, paramIntent, new d(paramIntent, paramUserHandle, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle), paramBroadcastReceiver);
  }
  
  public final ComponentName startService(final Intent paramIntent)
  {
    ComponentName localComponentName = (ComponentName)this.a.proceed(OutboundType.START_SERVICE, paramIntent, null, new f(paramIntent));
    if (localComponentName != null) {
      this.a.logIfOutboundPass(this.c, paramIntent, localComponentName.getPackageName(), CondomCore.h.c);
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
  
  final class a
    extends CondomCore.l
  {
    a(Intent paramIntent) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendStickyBroadcast(paramIntent);
    }
  }
  
  final class b
    extends CondomCore.l
  {
    b(Intent paramIntent, UserHandle paramUserHandle) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendStickyBroadcastAsUser(paramIntent, paramUserHandle);
    }
  }
  
  final class c
    extends CondomCore.l
  {
    c(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
    }
  }
  
  final class d
    extends CondomCore.l
  {
    d(Intent paramIntent, UserHandle paramUserHandle, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendStickyOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
    }
  }
  
  final class e
    implements CondomCore.m<Boolean>
  {
    e(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt) {}
  }
  
  final class f
    implements CondomCore.m<ComponentName>
  {
    f(Intent paramIntent) {}
  }
  
  final class g
    extends CondomCore.l
  {
    g(Intent paramIntent) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendBroadcast(paramIntent);
    }
  }
  
  final class h
    extends CondomCore.l
  {
    h(Intent paramIntent, String paramString) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendBroadcast(paramIntent, paramString);
    }
  }
  
  final class i
    extends CondomCore.l
  {
    i(Intent paramIntent, UserHandle paramUserHandle) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendBroadcastAsUser(paramIntent, paramUserHandle);
    }
  }
  
  final class j
    extends CondomCore.l
  {
    j(Intent paramIntent, UserHandle paramUserHandle, String paramString) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendBroadcastAsUser(paramIntent, paramUserHandle, paramString);
    }
  }
  
  final class k
    extends CondomCore.l
  {
    k(Intent paramIntent, String paramString) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendOrderedBroadcast(paramIntent, paramString);
    }
  }
  
  final class l
    extends CondomCore.l
  {
    l(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
    }
  }
  
  final class m
    extends CondomCore.l
  {
    m(Intent paramIntent, UserHandle paramUserHandle, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle) {}
    
    public final void a_()
    {
      ky.a(ky.this).sendOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ky
 * JD-Core Version:    0.7.0.1
 */