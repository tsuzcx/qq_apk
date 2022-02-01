package com.huawei.agconnect.core.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ServiceRepository
{
  private static final String TAG = "ServiceRepository";
  private Map<Class<?>, Object> mInstantiateMap = new HashMap();
  private Map<Class<?>, Service> mServiceMap = new HashMap();
  
  ServiceRepository(List<Service> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Service localService = (Service)paramList.next();
        this.mServiceMap.put(localService.getInterface(), localService);
      }
    }
  }
  
  private Object instantiate(AGConnectInstance paramAGConnectInstance, Service paramService)
  {
    paramService = paramService.getType();
    if (paramService == null) {
      return null;
    }
    try
    {
      Constructor localConstructor = matchConstructor(paramService, new Class[] { Context.class, AGConnectInstance.class });
      if (localConstructor != null) {
        return localConstructor.newInstance(new Object[] { paramAGConnectInstance.getContext(), paramAGConnectInstance });
      }
      localConstructor = matchConstructor(paramService, new Class[] { Context.class });
      if (localConstructor != null) {
        return localConstructor.newInstance(new Object[] { paramAGConnectInstance.getContext() });
      }
      paramAGConnectInstance = paramService.newInstance();
      return paramAGConnectInstance;
    }
    catch (Exception paramAGConnectInstance)
    {
      Log.e("ServiceRepository", "Instantiate service exception " + paramAGConnectInstance.getLocalizedMessage());
    }
    return null;
  }
  
  private static Constructor matchConstructor(Class paramClass, Class... paramVarArgs)
  {
    paramClass = paramClass.getDeclaredConstructors();
    int m = paramClass.length;
    int k = 0;
    int j;
    for (int i = 0; k < m; i = j)
    {
      Constructor localConstructor = paramClass[k];
      Class[] arrayOfClass = localConstructor.getParameterTypes();
      if (arrayOfClass.length == paramVarArgs.length)
      {
        j = 0;
        if (j < paramVarArgs.length)
        {
          if (arrayOfClass[j] == paramVarArgs[j]) {}
          for (i = 1;; i = 0)
          {
            j += 1;
            break;
          }
        }
        j = i;
        if (i != 0) {
          return localConstructor;
        }
      }
      else
      {
        j = i;
      }
      k += 1;
    }
    return null;
  }
  
  public <T> T getService(AGConnectInstance paramAGConnectInstance, Class<?> paramClass)
  {
    Service localService = (Service)this.mServiceMap.get(paramClass);
    if (localService == null) {
      return null;
    }
    if (localService.isSingleton())
    {
      Object localObject = this.mInstantiateMap.get(paramClass);
      if (localObject != null) {
        return localObject;
      }
    }
    paramAGConnectInstance = instantiate(paramAGConnectInstance, localService);
    if ((paramAGConnectInstance != null) && (localService.isSingleton())) {
      this.mInstantiateMap.put(paramClass, paramAGConnectInstance);
    }
    return paramAGConnectInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.core.impl.ServiceRepository
 * JD-Core Version:    0.7.0.1
 */