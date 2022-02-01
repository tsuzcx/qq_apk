package epsysproxy;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.token.ajw;
import com.tencent.token.akf;
import com.tencent.token.akf.f;
import com.tencent.token.lk;
import com.tencent.token.ll;
import com.tencent.token.ll.a;
import java.util.HashMap;
import java.util.Iterator;

public class l
  extends Application
{
  Application a = null;
  long b = 0L;
  private HashMap<BroadcastReceiver, BroadcastReceiver> c = new HashMap();
  
  public l(Application paramApplication, long paramLong)
  {
    attachBaseContext(paramApplication);
    this.a = paramApplication;
    this.b = paramLong;
  }
  
  private void a(final BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      Object localObject1 = new StringBuilder("registerReceiver:[");
      ((StringBuilder)localObject1).append(paramIntentFilter.countActions());
      ((StringBuilder)localObject1).append("]");
      localObject1 = paramIntentFilter.actionsIterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder("registerReceiver, ac:[");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("]");
      }
      if (akf.f.a.a != null)
      {
        localObject1 = akf.f.a.a;
        localObject2 = ((lk)localObject1).a("registerReceiver");
        localObject1 = paramIntentFilter;
        if (localObject2 != null)
        {
          localObject1 = paramIntentFilter;
          if (((ll.a)localObject2).a != null) {
            localObject1 = (IntentFilter)((ll.a)localObject2).a;
          }
        }
        paramIntentFilter = ((IntentFilter)localObject1).actionsIterator();
        while (paramIntentFilter.hasNext())
        {
          localObject1 = (String)paramIntentFilter.next();
          localObject2 = new StringBuilder("registerReceiver, 22 ac:[");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("]");
        }
      }
      return;
    }
    finally
    {
      paramIntentFilter.getMessage();
      paramIntentFilter = new a(paramBroadcastReceiver);
      if (this.c.containsKey(paramBroadcastReceiver)) {
        unregisterReceiver((BroadcastReceiver)this.c.remove(paramBroadcastReceiver));
      }
      this.c.put(paramBroadcastReceiver, paramIntentFilter);
    }
  }
  
  public Context getApplicationContext()
  {
    return this;
  }
  
  public PackageManager getPackageManager()
  {
    if (ll.a()) {
      return ajw.a.getPackageManager();
    }
    if ((this.b & 0x2) != 0L) {
      return this.a.getPackageManager();
    }
    return ajw.a.getPackageManager();
  }
  
  public Object getSystemService(String paramString)
  {
    return this.a.getSystemService(paramString);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.a.onConfigurationChanged(paramConfiguration);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void onCreate()
  {
    this.a.onCreate();
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void onLowMemory()
  {
    this.a.onLowMemory();
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void onTerminate()
  {
    this.a.onTerminate();
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void onTrimMemory(int paramInt)
  {
    this.a.onTrimMemory(paramInt);
  }
  
  public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    this.a.registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.a.registerComponentCallbacks(paramComponentCallbacks);
  }
  
  public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a.registerOnProvideAssistDataListener(paramOnProvideAssistDataListener);
    }
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.a.registerReceiver((BroadcastReceiver)this.c.get(paramBroadcastReceiver), paramIntentFilter);
    }
    return this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  @SuppressLint({"NewApi"})
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, int paramInt)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.a.registerReceiver((BroadcastReceiver)this.c.get(paramBroadcastReceiver), paramIntentFilter, paramInt);
    }
    return this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramInt);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.a.registerReceiver((BroadcastReceiver)this.c.get(paramBroadcastReceiver), paramIntentFilter, paramString, paramHandler);
    }
    return this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  @SuppressLint({"NewApi"})
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler, int paramInt)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.a.registerReceiver((BroadcastReceiver)this.c.get(paramBroadcastReceiver), paramIntentFilter, paramString, paramHandler, paramInt);
    }
    return this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler, paramInt);
  }
  
  public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    this.a.unregisterActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
  
  public void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.a.unregisterComponentCallbacks(paramComponentCallbacks);
  }
  
  public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener paramOnProvideAssistDataListener)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a.unregisterOnProvideAssistDataListener(paramOnProvideAssistDataListener);
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    if ((paramBroadcastReceiver != null) && (this.c.containsKey(paramBroadcastReceiver))) {
      this.a.unregisterReceiver((BroadcastReceiver)this.c.remove(paramBroadcastReceiver));
    }
  }
  
  final class a
    extends BroadcastReceiver
  {
    a(BroadcastReceiver paramBroadcastReceiver) {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      paramBroadcastReceiver.onReceive(l.this, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     epsysproxy.l
 * JD-Core Version:    0.7.0.1
 */