package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import awit;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import npi;
import npl;
import npl.a;
import npl.b;
import npv;

public class TemplateFactoryCache
  extends QQHashMap<String, npl.b>
{
  private volatile npl mStyleConfigHelper = new npl();
  
  public TemplateFactoryCache()
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
  
  public npl.b get(String paramString)
  {
    try
    {
      paramString = (npl.b)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public npi getAutoCreate(Context paramContext, String paramString)
  {
    npl.b localb = get(paramString);
    if ((localb != null) && (localb.b != null))
    {
      paramContext = npv.a(this.mStyleConfigHelper.a(paramContext, paramString).getKey());
      if ((paramContext != null) && (localb.b.aZ().equals(paramContext.aZ())) && (localb.b.getTemplateId() != paramContext.getTemplateId())) {
        return paramContext;
      }
      return localb.b;
    }
    paramContext = this.mStyleConfigHelper.a(paramContext, paramString);
    if ((paramContext != null) && (paramContext.b != null))
    {
      paramContext.b.os(paramString);
      put(paramString, paramContext);
      return paramContext.b;
    }
    return null;
  }
  
  public npl.b put(String paramString, npl.b paramb)
  {
    try
    {
      paramString = (npl.b)super.put(paramString, paramb);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public npl.b remove(String paramString)
  {
    try
    {
      paramString = (npl.b)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void reset()
  {
    Object localObject1 = this.mStyleConfigHelper;
    npl localnpl = new npl();
    Object localObject2 = ((npl)localObject1).I();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((npl.a)localEntry.getValue()).equals(localnpl.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    QLog.d("TemplateFactory", 2, "reset: " + localnpl);
    this.mStyleConfigHelper = localnpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */