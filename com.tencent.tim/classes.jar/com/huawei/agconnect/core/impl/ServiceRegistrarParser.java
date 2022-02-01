package com.huawei.agconnect.core.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ServiceRegistrarParser
{
  private static final int DEFAULT_PRIORITY = 1000;
  private static final String SERVICE_FLAG = "com.huawei.agconnect.core.ServiceRegistrar";
  private static final String TAG = "ServiceRegistrarParser";
  private Context mContext;
  
  ServiceRegistrarParser(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Bundle getMetaData()
  {
    Object localObject = this.mContext.getPackageManager();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((PackageManager)localObject).getServiceInfo(new ComponentName(this.mContext, ServiceDiscovery.class), 128);
      if (localObject == null)
      {
        Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + localNameNotFoundException.getLocalizedMessage());
      return null;
    }
    Bundle localBundle = localNameNotFoundException.metaData;
    return localBundle;
  }
  
  private List<String> getServiceList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getMetaData();
    if (localObject == null) {
      return localArrayList;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((Bundle)localObject).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ("com.huawei.agconnect.core.ServiceRegistrar".equals(((Bundle)localObject).getString(str)))
      {
        String[] arrayOfString = str.split(":");
        if (arrayOfString.length == 2) {
          try
          {
            localHashMap.put(arrayOfString[0], Integer.valueOf(arrayOfString[1]));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Log.e("ServiceRegistrarParser", "registrar configuration format error:" + localNumberFormatException.getMessage());
          }
        } else if (arrayOfString.length == 1) {
          localHashMap.put(arrayOfString[0], Integer.valueOf(1000));
        } else {
          Log.e("ServiceRegistrarParser", "registrar configuration error, " + localNumberFormatException);
        }
      }
    }
    localObject = new ArrayList(localHashMap.entrySet());
    Collections.sort((List)localObject, new ValueComparator(null));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((Map.Entry)((Iterator)localObject).next()).getKey());
    }
    return localArrayList;
  }
  
  private <T extends ServiceRegistrar> T instantiate(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      if (!ServiceRegistrar.class.isAssignableFrom(localClass))
      {
        Log.e("ServiceRegistrarParser", localClass + " must extends from ServiceRegistrar.");
        return null;
      }
      paramString = (ServiceRegistrar)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.e("ServiceRegistrarParser", "Can not found service class, " + paramString.getMessage());
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("ServiceRegistrarParser", "instantiate service class exception " + paramString.getLocalizedMessage());
      }
    }
  }
  
  public List<Service> getServices()
  {
    Object localObject1 = getServiceList();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = instantiate((String)((Iterator)localObject1).next());
      if (localObject2 != null)
      {
        ((ServiceRegistrar)localObject2).initialize(this.mContext);
        localObject2 = ((ServiceRegistrar)localObject2).getServices(this.mContext);
        if (localObject2 != null) {
          localArrayList.addAll((Collection)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  static class ValueComparator
    implements Serializable, Comparator<Map.Entry<String, Integer>>
  {
    private static final long serialVersionUID = 44523L;
    
    public int compare(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
    {
      return ((Integer)paramEntry1.getValue()).intValue() - ((Integer)paramEntry2.getValue()).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.core.impl.ServiceRegistrarParser
 * JD-Core Version:    0.7.0.1
 */