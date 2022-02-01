package com.tencent.token;

import android.text.TextUtils;
import com.tencent.token.core.bean.OnlineDeviceResult.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class sc
{
  private ConcurrentMap<Long, List<OnlineDeviceResult.a>> a = new ConcurrentHashMap();
  
  public final List<OnlineDeviceResult.a> a(long paramLong)
  {
    try
    {
      List localList = (List)this.a.get(Long.valueOf(paramLong));
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      List localList = a(paramLong);
      if ((localList != null) && (!localList.isEmpty()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          OnlineDeviceResult.a locala = (OnlineDeviceResult.a)localIterator.next();
          if ((locala.e == paramInt1) && (locala.f == paramInt2) && (TextUtils.equals(locala.g, paramString1)) && (TextUtils.equals(locala.a, paramString2)))
          {
            localList.remove(locala);
            a(paramLong, localList);
            return;
          }
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public final void a(long paramLong, List<OnlineDeviceResult.a> paramList)
  {
    try
    {
      this.a.put(Long.valueOf(paramLong), paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public static final class a
  {
    private static final sc a = new sc((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sc
 * JD-Core Version:    0.7.0.1
 */