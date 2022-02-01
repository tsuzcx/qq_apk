package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
  implements IPStrategy
{
  private static final String TAG = "IPConfigStrategy";
  private byte[] CONFIG_LOCK = new byte[0];
  private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
  private Map<String, Map<Integer, IPConfig>> mCacheIPConfigs = new HashMap();
  private Map<String, String> mConfigs = new HashMap();
  private int mDefaultIsp = -1;
  private Map<String, Pattern> mDominPatterns = new HashMap();
  private Map<String, Map<Integer, IPConfig>> mIPConfigs = new HashMap();
  private Map<String, String> mValidIPCache = new ConcurrentHashMap();
  
  private final void addConfig(String paramString, Map<String, Map<Integer, IPConfig>> paramMap, Map<String, Pattern> paramMap1)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap1 == null)) {}
    for (;;)
    {
      return;
      paramString = paramString.trim();
      if (paramString.startsWith(","))
      {
        paramString = "{" + paramString.substring(1);
        try
        {
          for (;;)
          {
            JSONObject localJSONObject = new JSONObject(paramString);
            if (localJSONObject == null) {
              break;
            }
            JSONArray localJSONArray1 = localJSONObject.names();
            if (localJSONArray1 == null) {
              break;
            }
            int i = 0;
            if (i >= localJSONArray1.length()) {
              break;
            }
            String str = localJSONArray1.getString(i);
            HashMap localHashMap = new HashMap();
            JSONArray localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
            if (localJSONArray2 != null)
            {
              int j = 0;
              while (j < localJSONArray2.length())
              {
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
              }
            }
            Object localObject1 = (Map)paramMap.get(str);
            if (localObject1 == null) {
              paramMap.put(str, localHashMap);
            }
            for (;;)
            {
              paramMap1.put(str, Pattern.compile(str, 2));
              i += 1;
              break;
              ((Map)localObject1).putAll(localHashMap);
            }
          }
        }
        catch (Throwable paramMap)
        {
          QDLog.e("IPConfigStrategy", "exception when add ip config: " + paramString, paramMap);
          return;
        }
      }
    }
  }
  
  private Map<Integer, IPConfig> findIPConfigs(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    int j = 1;
    this.RW_LOCK.readLock().lock();
    int i = j;
    for (;;)
    {
      try
      {
        if (!this.mCacheIPConfigs.containsKey(paramString)) {
          continue;
        }
        i = j;
        localObject2 = (Map)this.mCacheIPConfigs.get(paramString);
        localObject1 = localObject2;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        QDLog.w("IPConfigStrategy", "findIPConfigs", localThrowable);
        this.RW_LOCK.readLock().unlock();
        continue;
      }
      finally
      {
        this.RW_LOCK.readLock().unlock();
      }
      localObject2 = localObject1;
      if (i != 0) {
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      try
      {
        this.RW_LOCK.writeLock().lock();
        this.mCacheIPConfigs.put(paramString, localObject1);
        this.RW_LOCK.writeLock().unlock();
        return localObject1;
      }
      finally
      {
        this.RW_LOCK.writeLock().unlock();
      }
      j = 0;
      i = j;
      localObject2 = getDominKey(paramString);
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = j;
        if (this.mIPConfigs.containsKey(localObject2))
        {
          i = j;
          localObject2 = (Map)this.mIPConfigs.get(localObject2);
          localObject1 = localObject2;
          i = 0;
          continue;
        }
      }
      i = 0;
      localObject1 = null;
    }
  }
  
  private String getDominKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.mIPConfigs.entrySet().iterator();
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      str = (String)((Map.Entry)localIterator.next()).getKey();
    } while (!Utils.match((Pattern)this.mDominPatterns.get(str), paramString));
    for (paramString = str;; paramString = null) {
      return paramString;
    }
  }
  
  private String resolveIP(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Map localMap = findIPConfigs(paramString);
    this.RW_LOCK.readLock().lock();
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
            paramString = paramString.ip;
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        QDLog.w("IPConfigStrategy", "resolveIP", paramString);
        return null;
      }
      finally
      {
        this.RW_LOCK.readLock().unlock();
      }
      paramString = null;
    }
  }
  
  private List<IPInfo> resolveVideoIP(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Map localMap = findIPConfigs(paramString);
    this.RW_LOCK.readLock().lock();
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
        if (paramString != null)
        {
          paramString = paramString.ipInfos;
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QDLog.w("IPConfigStrategy", "resolveIP", paramString);
        return null;
      }
      finally
      {
        this.RW_LOCK.readLock().unlock();
      }
      paramString = null;
    }
  }
  
  private boolean strEqual(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return paramString2 == null;
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
    } while (paramString2.equals((String)this.mValidIPCache.get(str)));
    Map localMap = findIPConfigs(paramString1);
    this.RW_LOCK.readLock().lock();
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
          if (this.mDefaultIsp != -1) {
            paramString1 = (IPConfig)localMap.get(Integer.valueOf(this.mDefaultIsp));
          }
        }
        if ((paramString1 == null) || (paramString1.ipInfos == null)) {
          break label297;
        }
        paramString1 = paramString1.ipInfos.iterator();
        if (!paramString1.hasNext()) {
          break label297;
        }
        bool1 = paramString2.equals(((IPInfo)paramString1.next()).ip);
        if (!bool1) {
          continue;
        }
        bool1 = true;
        this.RW_LOCK.readLock().unlock();
        bool2 = bool1;
      }
      catch (Throwable paramString1)
      {
        QDLog.w("IPConfigStrategy", "isIPValid", paramString1);
        this.RW_LOCK.readLock().unlock();
        boolean bool2 = false;
        continue;
      }
      finally
      {
        this.RW_LOCK.readLock().unlock();
      }
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      this.mValidIPCache.put(str, paramString2);
      return bool2;
      label297:
      bool1 = false;
    }
  }
  
  public void onIPAccessResult(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBoolean) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    int i = NetworkManager.getIspType();
    paramString1 = findIPConfigs(paramString1);
    this.RW_LOCK.writeLock().lock();
    if (paramString1 != null) {}
    try
    {
      paramString1 = (IPConfig)paramString1.get(Integer.valueOf(i));
      if ((paramString1 != null) && (paramString1.ipInfos != null))
      {
        if (paramString1.getCurrFailCount() < 0) {
          paramString1.initFailCount(paramString2);
        }
        if (paramString2.equals(((IPInfo)paramString1.ipInfos.get(paramString1.getFailCount() % paramString1.ipInfos.size())).ip)) {
          paramString1.setFailCount(paramString1.getFailCount() + 1);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QDLog.w("IPConfigStrategy", "onIPAccessResult", paramString1);
      return;
    }
    finally
    {
      this.RW_LOCK.writeLock().unlock();
    }
  }
  
  public String resolveIP(String paramString)
  {
    return resolveIP(paramString, NetworkManager.getIspType(), this.mDefaultIsp);
  }
  
  public String resolveIP(String paramString, int paramInt)
  {
    return resolveIP(paramString, paramInt, -1);
  }
  
  public List<IPInfo> resolveVideoIP(String paramString)
  {
    return resolveVideoIP(paramString, NetworkManager.getIspType(), this.mDefaultIsp);
  }
  
  public final void setConfig(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.CONFIG_LOCK)
      {
        if (paramMap.size() != this.mConfigs.size())
        {
          i = 1;
          if (i != 0)
          {
            this.mConfigs.clear();
            this.mConfigs.putAll(paramMap);
          }
          if (i == 0) {
            break;
          }
          ??? = new HashMap();
          localObject2 = new HashMap();
          paramMap = paramMap.entrySet().iterator();
          if (!paramMap.hasNext()) {
            break label274;
          }
          localObject4 = (Map.Entry)paramMap.next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (String)((Map.Entry)localObject4).getValue();
          QDLog.i(getLogTag(), "IP Config -- " + (String)localObject3 + ":" + (String)localObject4, null);
          addConfig((String)localObject4, (Map)???, (Map)localObject2);
          continue;
        }
        localObject2 = paramMap.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label377;
        }
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject4 = (String)((Map.Entry)localObject3).getKey();
        if (strEqual((String)((Map.Entry)localObject3).getValue(), (String)this.mConfigs.get(localObject4))) {
          continue;
        }
        i = 1;
      }
      try
      {
        label274:
        this.RW_LOCK.writeLock().lock();
        this.mIPConfigs.clear();
        this.mIPConfigs.putAll((Map)???);
        this.mDominPatterns.clear();
        this.mDominPatterns.putAll((Map)localObject2);
        this.mCacheIPConfigs.clear();
        this.mValidIPCache.clear();
        return;
      }
      finally
      {
        this.RW_LOCK.writeLock().unlock();
      }
      label377:
      int i = 0;
    }
  }
  
  public void setDefaultIsp(int paramInt)
  {
    this.mDefaultIsp = paramInt;
  }
  
  public static class IPConfig
  {
    private int failCount = -1;
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
      return this.failCount;
    }
    
    public int getFailCount()
    {
      if (this.failCount < 0) {
        initStrarIndex();
      }
      return this.failCount;
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
      } while (!paramString.endsWith(localIPInfo.ip));
      this.failCount = j;
    }
    
    public void initStrarIndex()
    {
      if ((this.ipInfos == null) || (this.ipInfos.size() <= 0)) {
        return;
      }
      this.failCount = (Math.abs(new Random(System.currentTimeMillis()).nextInt()) % this.ipInfos.size());
    }
    
    public void setFailCount(int paramInt)
    {
      this.failCount = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.IPConfigStrategy
 * JD-Core Version:    0.7.0.1
 */