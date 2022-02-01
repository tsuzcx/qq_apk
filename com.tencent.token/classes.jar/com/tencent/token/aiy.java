package com.tencent.token;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.oasisfeng.condom.CondomContext;
import epsysproxy.l;
import java.util.HashMap;
import java.util.Iterator;

public final class aiy
  extends ContextWrapper
{
  public static Context a;
  CondomContext b = null;
  long c = 0L;
  private HashMap<BroadcastReceiver, BroadcastReceiver> d = new HashMap();
  
  public aiy(Context paramContext, CondomContext paramCondomContext, long paramLong)
  {
    super(paramContext);
    a = paramContext;
    this.b = paramCondomContext;
    this.c = paramLong;
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
      if (ajh.f.a.a != null)
      {
        localObject1 = ajh.f.a.a;
        localObject2 = ((kw)localObject1).a("registerReceiver");
        localObject1 = paramIntentFilter;
        if (localObject2 != null)
        {
          localObject1 = paramIntentFilter;
          if (((kx.a)localObject2).a != null) {
            localObject1 = (IntentFilter)((kx.a)localObject2).a;
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
      if (this.d.containsKey(paramBroadcastReceiver)) {
        unregisterReceiver((BroadcastReceiver)this.d.remove(paramBroadcastReceiver));
      }
      this.d.put(paramBroadcastReceiver, paramIntentFilter);
    }
  }
  
  public final Context getApplicationContext()
  {
    Context localContext = this.b.getApplicationContext();
    if ((localContext != null) && ((localContext instanceof Application))) {
      return new l((Application)localContext, this.c);
    }
    return localContext;
  }
  
  public final PackageManager getPackageManager()
  {
    if (kx.a()) {
      return super.getPackageManager();
    }
    if ((this.c & 0x2) != 0L) {
      return this.b.getPackageManager();
    }
    return super.getPackageManager();
  }
  
  public final Object getSystemService(String paramString)
  {
    return this.b.getSystemService(paramString);
  }
  
  public final Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.b.registerReceiver((BroadcastReceiver)this.d.get(paramBroadcastReceiver), paramIntentFilter);
    }
    return this.b.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  @SuppressLint({"NewApi"})
  public final Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, int paramInt)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.b.registerReceiver((BroadcastReceiver)this.d.get(paramBroadcastReceiver), paramIntentFilter, paramInt);
    }
    return this.b.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramInt);
  }
  
  public final Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.b.registerReceiver((BroadcastReceiver)this.d.get(paramBroadcastReceiver), paramIntentFilter, paramString, paramHandler);
    }
    return this.b.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  @SuppressLint({"NewApi"})
  public final Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler, int paramInt)
  {
    if (paramBroadcastReceiver != null)
    {
      a(paramBroadcastReceiver, paramIntentFilter);
      return this.b.registerReceiver((BroadcastReceiver)this.d.get(paramBroadcastReceiver), paramIntentFilter, paramString, paramHandler, paramInt);
    }
    return this.b.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler, paramInt);
  }
  
  public final void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    if ((paramBroadcastReceiver != null) && (this.d.containsKey(paramBroadcastReceiver))) {
      this.b.unregisterReceiver((BroadcastReceiver)this.d.remove(paramBroadcastReceiver));
    }
  }
  
  final class a
    extends BroadcastReceiver
  {
    a(BroadcastReceiver paramBroadcastReceiver) {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      paramBroadcastReceiver.onReceive(aiy.this, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aiy
 * JD-Core Version:    0.7.0.1
 */