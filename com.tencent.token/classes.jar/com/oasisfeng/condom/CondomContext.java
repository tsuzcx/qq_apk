package com.oasisfeng.condom;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.UserHandle;
import android.support.annotation.Keep;
import com.oasisfeng.condom.util.Lazy;
import com.tencent.token.kh;

@Keep
public class CondomContext
  extends ContextWrapper
{
  final String TAG;
  private final Context mApplicationContext;
  private final Lazy<Context> mBaseContext;
  CondomCore mCondom;
  
  private CondomContext(CondomCore paramCondomCore, Context paramContext, String paramString)
  {
    super(paramCondomCore.mBase);
    this.mCondom = paramCondomCore;
    if (paramContext != null) {
      paramCondomCore = paramContext;
    } else {
      paramCondomCore = this;
    }
    this.mApplicationContext = paramCondomCore;
    this.mBaseContext = new Lazy() {};
    this.TAG = CondomCore.buildLogTag("Condom", "Condom.", paramString);
  }
  
  public static CondomContext wrap(Context paramContext, String paramString)
  {
    return wrap(paramContext, paramString, new CondomOptions());
  }
  
  public static CondomContext wrap(Context paramContext, String paramString, CondomOptions paramCondomOptions)
  {
    if ((paramContext instanceof CondomContext))
    {
      paramContext = (CondomContext)paramContext;
      paramString = new StringBuilder("The wrapped context is already a CondomContext (tag: ");
      paramString.append(paramContext.TAG);
      paramString.append("), tag and options specified here will be ignore.");
      return paramContext;
    }
    Context localContext = paramContext.getApplicationContext();
    CondomCore localCondomCore = new CondomCore(paramContext, paramCondomOptions, CondomCore.buildLogTag("Condom", "Condom.", paramString));
    if ((localContext instanceof Application))
    {
      Application localApplication = (Application)localContext;
      kh localkh = new kh(localCondomCore, localApplication, paramString);
      paramCondomOptions = new CondomContext(localCondomCore, localkh, paramString);
      if (paramContext == localContext) {
        paramContext = paramCondomOptions;
      } else {
        paramContext = new CondomContext(localCondomCore, localApplication, paramString);
      }
      localkh.attachBaseContext(paramContext);
      return paramCondomOptions;
    }
    if (paramContext == localContext) {
      paramContext = null;
    } else {
      paramContext = new CondomContext(localCondomCore, localContext, paramString);
    }
    return new CondomContext(localCondomCore, paramContext, paramString);
  }
  
  public boolean bindService(final Intent paramIntent, final ServiceConnection paramServiceConnection, final int paramInt)
  {
    boolean bool = ((Boolean)this.mCondom.proceed(OutboundType.BIND_SERVICE, paramIntent, Boolean.FALSE, new CondomCore.f() {})).booleanValue();
    if (bool) {
      this.mCondom.logIfOutboundPass(this.TAG, paramIntent, CondomCore.getTargetPackage(paramIntent), CondomCore.CondomEvent.BIND_PASS);
    }
    return bool;
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == Process.myPid()) && (paramInt2 == Process.myUid()) && (this.mCondom.shouldSpoofPermission(paramString))) {
      return 0;
    }
    return super.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  public int checkSelfPermission(String paramString)
  {
    if (this.mCondom.shouldSpoofPermission(paramString)) {
      return 0;
    }
    return super.checkSelfPermission(paramString);
  }
  
  public Context getApplicationContext()
  {
    return this.mApplicationContext;
  }
  
  public Context getBaseContext()
  {
    this.mCondom.logConcern(this.TAG, "getBaseContext");
    return (Context)this.mBaseContext.get();
  }
  
  public ContentResolver getContentResolver()
  {
    return this.mCondom.getContentResolver();
  }
  
  public PackageManager getPackageManager()
  {
    return this.mCondom.getPackageManager();
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject = this.mCondom.getSystemService(paramString);
    if (localObject != null) {
      return localObject;
    }
    return super.getSystemService(paramString);
  }
  
  @Deprecated
  public CondomContext preventBroadcastToBackgroundPackages(boolean paramBoolean)
  {
    this.mCondom.mExcludeBackgroundReceivers = paramBoolean;
    return this;
  }
  
  @Deprecated
  public CondomContext preventServiceInBackgroundPackages(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 26) {
      this.mCondom.mExcludeBackgroundServices = paramBoolean;
    }
    return this;
  }
  
  @Deprecated
  public CondomContext preventWakingUpStoppedPackages(boolean paramBoolean)
  {
    this.mCondom.mExcludeStoppedPackages = paramBoolean;
    return this;
  }
  
  public void sendBroadcast(final Intent paramIntent)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendBroadcast(paramIntent);
      }
    }, null);
  }
  
  public void sendBroadcast(final Intent paramIntent, final String paramString)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendBroadcast(paramIntent, paramString);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendBroadcastAsUser(paramIntent, paramUserHandle);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendBroadcastAsUser(paramIntent, paramUserHandle, paramString);
      }
    }, null);
  }
  
  public void sendOrderedBroadcast(final Intent paramIntent, final String paramString)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendOrderedBroadcast(paramIntent, paramString);
      }
    }, null);
  }
  
  public void sendOrderedBroadcast(final Intent paramIntent, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final String paramString1, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString2, final Bundle paramBundle)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyBroadcast(final Intent paramIntent)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendStickyBroadcast(paramIntent);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendStickyBroadcastAsUser(paramIntent, paramUserHandle);
      }
    }, null);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyOrderedBroadcast(final Intent paramIntent, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendStickyOrderedBroadcastAsUser(final Intent paramIntent, final UserHandle paramUserHandle, final BroadcastReceiver paramBroadcastReceiver, final Handler paramHandler, final int paramInt, final String paramString, final Bundle paramBundle)
  {
    this.mCondom.proceedBroadcast(this, paramIntent, new CondomCore.e()
    {
      public final void b()
      {
        CondomContext.this.sendStickyOrderedBroadcastAsUser(paramIntent, paramUserHandle, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
      }
    }, paramBroadcastReceiver);
  }
  
  public CondomContext setDryRun(boolean paramBoolean)
  {
    if (paramBoolean == this.mCondom.mDryRun) {
      return this;
    }
    this.mCondom.mDryRun = paramBoolean;
    return this;
  }
  
  public ComponentName startService(final Intent paramIntent)
  {
    ComponentName localComponentName = (ComponentName)this.mCondom.proceed(OutboundType.START_SERVICE, paramIntent, null, new CondomCore.f() {});
    if (localComponentName != null) {
      this.mCondom.logIfOutboundPass(this.TAG, paramIntent, localComponentName.getPackageName(), CondomCore.CondomEvent.START_PASS);
    }
    return localComponentName;
  }
  
  static final class a
    extends PseudoContextWrapper
  {
    public a(CondomContext paramCondomContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.CondomContext
 * JD-Core Version:    0.7.0.1
 */