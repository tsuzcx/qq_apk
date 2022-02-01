package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.n;
import com.tencent.tbs.one.impl.e.h;
import java.io.File;

public final class c
  extends TBSOneManager
{
  private final Object a = new Object();
  private String b;
  private h c;
  private boolean d;
  
  public c(Context paramContext, String paramString)
  {
    a.a(paramContext);
    f.a("[%s] Initializing %s (%s)", new Object[] { paramString, "0.0.2", "20210924170943" });
    this.b = paramString;
    this.c = a.a(paramContext, paramString);
  }
  
  private void a()
  {
    synchronized (this.a)
    {
      this.d = true;
      return;
    }
  }
  
  public final void cancelComponent(String paramString)
  {
    f.a("[%s] Canceling component %s", new Object[] { this.b, paramString });
    a();
    n.a(new c.5(this, paramString));
  }
  
  public final void configure(String paramString, Object paramObject)
  {
    f.a("[%s] Configuring %s = %s", new Object[] { this.b, paramString, paramObject });
    this.c.a(paramString, paramObject);
  }
  
  public final String getBuildNumber()
  {
    return "20210924170943";
  }
  
  public final TBSOneDebugger getDebugger()
  {
    return this.c.d();
  }
  
  public final File getInstalledComponentPath(String paramString)
  {
    if (!isComponentInstalled(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        File localFile = installComponentSync(paramString, null, 1000L);
        if (localFile != null) {
          return localFile;
        }
      }
      catch (Exception localException)
      {
        f.a("handle Loading component %s exception:%s", new Object[] { paramString, localException.toString() });
      }
    }
    return null;
  }
  
  public final int[] getInstalledVersionCodesOfComponent(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public final TBSOneComponent getLoadedComponent(String paramString)
  {
    return this.c.f(paramString);
  }
  
  public final TBSOneOnlineService getOnlineService()
  {
    a();
    return this.c.c();
  }
  
  public final int getVersionCode()
  {
    return 2;
  }
  
  public final String getVersionName()
  {
    return "0.0.2";
  }
  
  public final void installComponent(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    f.a("[%s] Installing component %s with options %s", new Object[] { this.b, paramString, paramBundle });
    a();
    n.a(new c.2(this, paramString, paramBundle, paramTBSOneCallback));
  }
  
  public final void installComponent(String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    installComponent(paramString, null, paramTBSOneCallback);
  }
  
  public final File installComponentSync(String paramString, Bundle paramBundle, long paramLong)
    throws TBSOneException
  {
    if (n.b()) {
      throw new RuntimeException("TBSOneManager.installComponentSync must not be called on TBSOne thread.");
    }
    a();
    b localb = new b();
    n.a(new c.6(this, paramString, paramBundle, localb));
    localb.a(paramLong);
    if (localb.b != 0) {
      throw new TBSOneException(localb.b, localb.c);
    }
    return (File)localb.a;
  }
  
  public final boolean isComponentInstalled(String paramString)
  {
    return this.c.b(paramString);
  }
  
  public final void loadComponentAsync(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    f.a("[%s] Loading component %s asynchronously", new Object[] { this.b, paramString });
    a();
    n.a(new c.3(this, paramString, paramBundle, paramTBSOneCallback));
  }
  
  public final void loadComponentAsync(String paramString, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    loadComponentAsync(paramString, null, paramTBSOneCallback);
  }
  
  public final TBSOneComponent loadComponentSync(String paramString, long paramLong)
    throws TBSOneException
  {
    return loadComponentSync(paramString, null, paramLong);
  }
  
  public final TBSOneComponent loadComponentSync(String paramString, Bundle paramBundle, long paramLong)
    throws TBSOneException
  {
    f.a("[%s] Loading component %s synchronously", new Object[] { this.b, paramString });
    if (n.b()) {
      throw new RuntimeException("TBSOneManager.loadComponentSync must not be called on TBSOne thread.");
    }
    a();
    b localb = new b();
    n.a(new c.4(this, paramString, paramBundle, localb));
    localb.a(paramLong);
    if (localb.b != 0) {
      throw new TBSOneException(localb.b, localb.c);
    }
    return (TBSOneComponent)localb.a;
  }
  
  public final void setAutoUpdateEnabled(boolean paramBoolean)
  {
    String str2 = this.b;
    if (paramBoolean) {}
    for (String str1 = "Enabling";; str1 = "Disabling")
    {
      f.a("[%s] %s auto update", new Object[] { str2, str1 });
      this.c.a(paramBoolean);
      return;
    }
  }
  
  public final void setDelegate(TBSOneDelegate paramTBSOneDelegate)
  {
    f.a("[%s] Setting delegate %s", new Object[] { this.b, paramTBSOneDelegate });
    n.a(new c.1(this, paramTBSOneDelegate));
  }
  
  public final void setPolicy(TBSOneManager.Policy paramPolicy)
  {
    f.a("[%s] Setting policy %s", new Object[] { this.b, paramPolicy });
    synchronized (this.a)
    {
      if (this.d)
      {
        Log.println(5, "TBSOne", Log.getStackTraceString(new Throwable("TBSOneManager.setPolicy should be called before doing any other operations.")));
        return;
      }
      this.c.h = paramPolicy;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c
 * JD-Core Version:    0.7.0.1
 */