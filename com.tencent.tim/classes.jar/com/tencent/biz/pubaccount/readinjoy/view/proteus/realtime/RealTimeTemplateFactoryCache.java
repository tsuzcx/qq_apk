package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.content.Context;
import awit;
import com.tencent.commonsdk.cache.QQHashMap;
import npr;
import npt;

public class RealTimeTemplateFactoryCache
  extends QQHashMap<String, npt>
{
  public RealTimeTemplateFactoryCache()
  {
    super(2018, 10, 230000);
  }
  
  public void clear()
  {
    try
    {
      super.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearMemory()
  {
    if (!awit.aMM()) {
      clear();
    }
  }
  
  public npt get(String paramString)
  {
    try
    {
      paramString = (npt)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public npt getAutoCreate(Context paramContext, String paramString)
  {
    paramContext = get(paramString);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = npr.a(paramString);
    if (paramContext != null)
    {
      paramContext.os(paramString);
      put(paramString, paramContext);
      return paramContext;
    }
    return null;
  }
  
  public npt put(String paramString, npt paramnpt)
  {
    try
    {
      paramString = (npt)super.put(paramString, paramnpt);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public npt remove(String paramString)
  {
    try
    {
      paramString = (npt)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeTemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */