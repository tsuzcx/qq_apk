package com.tencent.android.tpush.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private static volatile a a = null;
  private Context b = null;
  private PackageManager c = null;
  private HashMap<String, b> d = new HashMap();
  private Map<String, Long> e = new HashMap();
  
  private a(Context paramContext)
  {
    this.b = paramContext;
    this.c = paramContext.getPackageManager();
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private void c(String paramString)
  {
    Object localObject1 = (Long)this.e.get(paramString);
    if ((localObject1 != null) && (System.currentTimeMillis() > ((Long)localObject1).longValue())) {
      return;
    }
    localObject1 = b(paramString);
    TLogger.d("IPCManager", "tryWakeUpApp ipcAppInfo:" + localObject1);
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).a();
      TLogger.d("IPCManager", "tryWakeUpApp providerInfoList:" + localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ProviderInfo)((Iterator)localObject1).next();
          if (((ProviderInfo)localObject2).exported)
          {
            localObject2 = ((ProviderInfo)localObject2).authority;
            localObject2 = Uri.parse("content://" + (String)localObject2);
            TLogger.d("IPCManager", "tryWakeUpApp uri:" + localObject2);
            this.b.getContentResolver().getType((Uri)localObject2);
          }
        }
      }
    }
    long l = System.currentTimeMillis();
    this.e.put(paramString, Long.valueOf(l + 3600000L));
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    Object localObject = com.tencent.android.tpush.service.a.a.a(this.b).I;
    String str = Build.MANUFACTURER;
    TLogger.d("IPCManager", "wakeCtr:" + (String)localObject + ",mf:" + str);
    boolean bool1;
    int j;
    int i;
    if (i.b((String)localObject))
    {
      bool1 = bool2;
      if (i.b(str)) {}
    }
    else
    {
      localObject = ((String)localObject).split(",");
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (localObject[i].toLowerCase().equals(str.toLowerCase())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    try
    {
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("IPCManager", "init", localThrowable);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if ((d()) && (!this.b.getPackageName().equals(paramString)))
      {
        TLogger.d("IPCManager", "tryWakeUpApp packageName:" + paramString);
        c(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      TLogger.e("IPCManager", "tryWakeUpApp", paramString);
    }
  }
  
  public b b(String paramString)
  {
    if (!this.d.containsKey(paramString)) {
      a();
    }
    return (b)this.d.get(paramString);
  }
  
  public void b()
  {
    TLogger.d("IPCManager", "action - initProviders");
    Object localObject = this.c.queryContentProviders(null, 0, 0);
    List localList = c();
    if ((localObject != null) && (localList != null))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        ProviderInfo localProviderInfo = (ProviderInfo)localIterator.next();
        if ((localList.contains(localProviderInfo.packageName)) && (localProviderInfo.exported))
        {
          b localb = (b)this.d.get(localProviderInfo.packageName);
          localObject = localb;
          if (localb == null) {
            localObject = new b();
          }
          ((b)localObject).a(localProviderInfo.packageName);
          if (localProviderInfo.name.equals(XGPushProvider.class.getName())) {
            ((b)localObject).a(localProviderInfo);
          }
          for (;;)
          {
            this.d.put(localProviderInfo.packageName, localObject);
            break;
            ((b)localObject).b(localProviderInfo);
          }
        }
      }
    }
  }
  
  public List<String> c()
  {
    TLogger.d("IPCManager", "action - getAllLocalXGApps");
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.c.queryBroadcastReceivers(new Intent("com.tencent.android.xg.vip.action.SDK"), 0);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((ResolveInfo)((Iterator)localObject).next()).resolvePackageName);
      }
    }
    localObject = com.tencent.android.tpush.a.a(this.b);
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (!localArrayList.contains(localEntry.getKey())) {
          localArrayList.add(localEntry.getKey());
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.a.a
 * JD-Core Version:    0.7.0.1
 */