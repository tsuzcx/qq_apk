package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PortConfigStrategy
{
  private String a = null;
  private Map<String, List<Integer>> b = new HashMap();
  private Map<String, List<Integer>> c = new HashMap();
  private Map<String, Pattern> d = new HashMap();
  private ReadWriteLock e = new ReentrantReadWriteLock();
  
  private List<Integer> a(String paramString)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      localObject4 = localObject1;
      return localObject4;
    }
    this.e.readLock().lock();
    int i;
    Object localObject3;
    for (;;)
    {
      try
      {
        if (!this.c.containsKey(paramString)) {
          continue;
        }
        localObject1 = (List)this.c.get(paramString);
        i = 1;
      }
      catch (Throwable localThrowable1)
      {
        Const.b("PortConfigStrategy", "", localThrowable1);
        this.e.readLock().unlock();
        localObject2 = localObject4;
        continue;
      }
      finally
      {
        this.e.readLock().unlock();
      }
      this.e.readLock().unlock();
      localObject4 = localObject1;
      if (i != 0) {
        break;
      }
      localObject4 = localObject1;
      if (localObject1 == null) {
        break;
      }
      try
      {
        this.e.writeLock().lock();
        this.c.put(paramString, localObject1);
        this.e.writeLock().unlock();
        return localObject1;
      }
      finally
      {
        Iterator localIterator;
        Map.Entry localEntry;
        boolean bool;
        Object localObject2;
        this.e.writeLock().unlock();
      }
      i = 0;
    }
  }
  
  public final int changePort(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (TextUtils.isEmpty(paramString))) {
      return 80;
    }
    paramString = a(paramString);
    if ((paramString != null) && (paramString.size() > 0)) {}
    try
    {
      this.e.readLock().lock();
      int i = paramString.indexOf(new Integer(paramInt));
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      paramInt = ((Integer)paramString.get((paramInt + 1) % paramString.size())).intValue();
      return paramInt;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    finally
    {
      this.e.readLock().unlock();
    }
  }
  
  public final void setConfig(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.a))) {
      return;
    }
    Const.c("PortConfigStrategy", "Downloader port config:" + paramString);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    try
    {
      localJSONObject = new JSONObject(paramString);
      localJSONArray1 = localJSONObject.names();
      if (localJSONArray1 != null)
      {
        i = 0;
        j = localJSONArray1.length();
        if (i < j) {
          break label176;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        JSONArray localJSONArray1;
        int i;
        int j;
        label176:
        String str;
        ArrayList localArrayList;
        JSONArray localJSONArray2;
        localException.printStackTrace();
      }
    }
    try
    {
      this.e.writeLock().lock();
      this.a = paramString;
      this.b.clear();
      this.b.putAll(localHashMap1);
      this.c.clear();
      this.d.clear();
      this.d.putAll(localHashMap2);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
    }
    str = localJSONArray1.getString(i);
    localArrayList = new ArrayList();
    localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
    if (localJSONArray2 != null) {
      j = 0;
    }
    for (;;)
    {
      if (j >= localJSONArray2.length())
      {
        localHashMap1.put(str, localArrayList);
        localHashMap2.put(str, Pattern.compile(str, 2));
        i += 1;
        break;
      }
      Integer localInteger = Integer.valueOf(localJSONArray2.getJSONObject(j).getInt("port"));
      localArrayList.add(localInteger);
      Const.c("PortConfigStrategy", "downloader port: domain:" + str + " port:" + localInteger);
      j += 1;
    }
  }
  
  public final boolean supportExtraPort(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.PortConfigStrategy
 * JD-Core Version:    0.7.0.1
 */