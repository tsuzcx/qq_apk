package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class IPConfigStrategy
{
  private ReadWriteLock a = new ReentrantReadWriteLock();
  private Map<String, Map<Integer, IPConfig>> b = new HashMap();
  private Map<String, Map<Integer, IPConfig>> c = new HashMap();
  private Map<String, String> d = new ConcurrentHashMap();
  private Map<String, Pattern> e = new HashMap();
  private byte[] f = new byte[0];
  private Map<String, String> g = new HashMap();
  private int h = -1;
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Map localMap = a(paramString);
    this.a.readLock().lock();
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        IPConfig localIPConfig = (IPConfig)localMap.get(Integer.valueOf(paramInt1));
        paramString = localIPConfig;
        if (localIPConfig == null)
        {
          paramString = localIPConfig;
          if (paramInt2 != -1) {
            paramString = (IPConfig)localMap.get(Integer.valueOf(paramInt2));
          }
        }
        if ((paramString != null) && (paramString.ipInfos != null) && (paramString.ipInfos.size() > 0))
        {
          paramInt1 = paramString.getFailCount();
          paramInt2 = paramString.ipInfos.size();
          paramString = (IPInfo)paramString.ipInfos.get(paramInt1 % paramInt2);
          if (paramString != null)
          {
            paramString = paramString.a;
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        Const.b("IPConfigStrategy", "", paramString);
        return null;
      }
      finally
      {
        this.a.readLock().unlock();
      }
      paramString = null;
    }
  }
  
  private Map<Integer, IPConfig> a(String paramString)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      localObject4 = localObject1;
      return localObject4;
    }
    this.a.readLock().lock();
    int i;
    Object localObject3;
    for (;;)
    {
      try
      {
        if (!this.c.containsKey(paramString)) {
          continue;
        }
        localObject1 = (Map)this.c.get(paramString);
        i = 1;
      }
      catch (Throwable localThrowable1)
      {
        Const.b("IPConfigStrategy", "", localThrowable1);
        this.a.readLock().unlock();
        localObject2 = localObject4;
        continue;
      }
      finally
      {
        this.a.readLock().unlock();
      }
      this.a.readLock().unlock();
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
        this.a.writeLock().lock();
        this.c.put(paramString, localObject1);
        this.a.writeLock().unlock();
        return localObject1;
      }
      finally
      {
        Iterator localIterator;
        boolean bool;
        Object localObject2;
        this.a.writeLock().unlock();
      }
      i = 0;
    }
  }
  
  private static void a(String paramString, Map<String, Map<Integer, IPConfig>> paramMap, Map<String, Pattern> paramMap1)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        JSONArray localJSONArray1 = localJSONObject.names();
        if (localJSONArray1 == null) {
          continue;
        }
        int i = 0;
        if (i >= localJSONArray1.length()) {
          continue;
        }
        String str = localJSONArray1.getString(i);
        HashMap localHashMap = new HashMap();
        JSONArray localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
        int j;
        label79:
        Object localObject1;
        if (localJSONArray2 != null)
        {
          j = 0;
          if (j < localJSONArray2.length()) {}
        }
        else
        {
          localObject1 = (Map)paramMap.get(str);
          if (localObject1 != null) {
            break label258;
          }
          paramMap.put(str, localHashMap);
        }
        for (;;)
        {
          paramMap1.put(str, Pattern.compile(str, 2));
          i += 1;
          break;
          Object localObject2 = localJSONArray2.getJSONObject(j);
          localObject1 = ((JSONObject)localObject2).getString("ip");
          int k = ((JSONObject)localObject2).getInt("port");
          Integer localInteger = Integer.valueOf(((JSONObject)localObject2).getInt("apn"));
          IPInfo localIPInfo = new IPInfo((String)localObject1, Integer.valueOf(k).intValue());
          localObject2 = (IPConfig)localHashMap.get(localInteger);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new IPConfig();
            localHashMap.put(localInteger, localObject1);
          }
          ((IPConfig)localObject1).appendIP(localIPInfo);
          j += 1;
          break label79;
          label258:
          ((Map)localObject1).putAll(localHashMap);
        }
        return;
      }
      catch (Throwable paramMap)
      {
        Const.d("IPConfigStrategy", "exception when add ip config: " + paramString, paramMap);
      }
    }
  }
  
  protected String getLogTag()
  {
    return "IPConfigStrategy";
  }
  
  public boolean isIPValid(String paramString1, String paramString2)
  {
    boolean bool1 = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    int i;
    String str;
    do
    {
      return bool1;
      i = NetworkManager.getIspType();
      str = paramString1 + "_" + i;
    } while (paramString2.equals((String)this.d.get(str)));
    Map localMap = a(paramString1);
    this.a.readLock().lock();
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        IPConfig localIPConfig = (IPConfig)localMap.get(Integer.valueOf(i));
        paramString1 = localIPConfig;
        if (localIPConfig == null)
        {
          paramString1 = localIPConfig;
          if (this.h != -1) {
            paramString1 = (IPConfig)localMap.get(Integer.valueOf(this.h));
          }
        }
        if ((paramString1 == null) || (paramString1.ipInfos == null)) {
          break label305;
        }
        paramString1 = paramString1.ipInfos.iterator();
        bool1 = paramString1.hasNext();
        if (bool1) {
          continue;
        }
        bool1 = false;
        this.a.readLock().unlock();
        bool2 = bool1;
      }
      catch (Throwable paramString1)
      {
        Const.b("IPConfigStrategy", "", paramString1);
        this.a.readLock().unlock();
        boolean bool2 = false;
        continue;
      }
      finally
      {
        this.a.readLock().unlock();
      }
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      this.d.put(str, paramString2);
      return bool2;
      bool1 = paramString2.equals(((IPInfo)paramString1.next()).a);
      if (bool1)
      {
        bool1 = true;
        continue;
        label305:
        bool1 = false;
      }
    }
  }
  
  public void onIPAccessResult(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBoolean) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    int i = NetworkManager.getIspType();
    paramString1 = a(paramString1);
    this.a.writeLock().lock();
    if (paramString1 != null) {}
    try
    {
      paramString1 = (IPConfig)paramString1.get(Integer.valueOf(i));
      if ((paramString1 != null) && (paramString1.ipInfos != null))
      {
        if (paramString1.getCurrFailCount() < 0) {
          paramString1.initFailCount(paramString2);
        }
        if (paramString2.equals(((IPInfo)paramString1.ipInfos.get(paramString1.getFailCount() % paramString1.ipInfos.size())).a)) {
          paramString1.setFailCount(paramString1.getFailCount() + 1);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      Const.b("IPConfigStrategy", "", paramString1);
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public String resolveIP(String paramString)
  {
    return a(paramString, NetworkManager.getIspType(), this.h);
  }
  
  public String resolveIPByIsp(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1);
  }
  
  public final void setConfig(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.f)
      {
        int i;
        if (paramMap.size() != this.g.size())
        {
          i = 1;
          if (i != 0)
          {
            this.g.clear();
            this.g.putAll(paramMap);
          }
          if (i == 0) {
            break;
          }
          ??? = new HashMap();
          localObject2 = new HashMap();
          paramMap = paramMap.entrySet().iterator();
          if (paramMap.hasNext()) {
            break label313;
          }
        }
        try
        {
          this.a.writeLock().lock();
          this.b.clear();
          this.b.putAll((Map)???);
          this.e.clear();
          this.e.putAll((Map)localObject2);
          this.c.clear();
          this.d.clear();
          return;
        }
        finally
        {
          Object localObject3;
          String str;
          boolean bool;
          this.a.writeLock().unlock();
        }
        localObject2 = paramMap.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext())
        {
          i = 0;
          continue;
        }
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        str = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (String)((Map.Entry)localObject3).getValue();
        str = (String)this.g.get(str);
        if (localObject3 != null)
        {
          bool = ((String)localObject3).equals(str);
          if (!bool) {
            i = 1;
          }
        }
        else
        {
          if (str != null) {
            continue;
          }
          bool = true;
          continue;
        }
        continue;
        bool = false;
      }
      label313:
      localObject3 = (Map.Entry)paramMap.next();
      str = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      Const.c(getLogTag(), "IP Config -- " + str + ":" + (String)localObject3);
      a((String)localObject3, (Map)???, (Map)localObject2);
    }
  }
  
  public void setDefaultIsp(int paramInt)
  {
    this.h = paramInt;
  }
  
  public static class IPConfig
  {
    private int a = -1;
    public ArrayList<IPInfo> ipInfos = new ArrayList();
    
    public void appendIP(IPInfo paramIPInfo)
    {
      if (paramIPInfo == null) {
        return;
      }
      this.ipInfos.add(paramIPInfo);
    }
    
    public int getCurrFailCount()
    {
      return this.a;
    }
    
    public int getFailCount()
    {
      if (this.a < 0) {
        initStrarIndex();
      }
      return this.a;
    }
    
    public void initFailCount(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      IPInfo localIPInfo;
      int j;
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          localIterator = this.ipInfos.iterator();
          i = -1;
        }
        localIPInfo = (IPInfo)localIterator.next();
        j = i + 1;
        int i = j;
      } while (!paramString.endsWith(localIPInfo.a));
      this.a = j;
    }
    
    public void initStrarIndex()
    {
      if ((this.ipInfos == null) || (this.ipInfos.size() <= 0)) {
        return;
      }
      this.a = (Math.abs(new Random(System.currentTimeMillis()).nextInt()) % this.ipInfos.size());
    }
    
    public void setFailCount(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.IPConfigStrategy
 * JD-Core Version:    0.7.0.1
 */