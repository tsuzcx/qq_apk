package com.tencent.qapmsdk.dns.logic;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.model.DnsCacheObj;
import com.tencent.qapmsdk.dns.model.DnsInfo;
import com.tencent.qapmsdk.dns.model.IpCachedItem;
import com.tencent.qapmsdk.dns.network.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DnsCacheManager
{
  static final int FROM_HTTP_DNS = 1;
  static final int FROM_SYSTEM_DNS = 2;
  private static final String TAG = "QAPM_DNS_DnsCacheManager";
  private static DnsCacheManager instance = new DnsCacheManager();
  private Map<String, DnsCacheObj> dnsCacheObjMap = new ConcurrentHashMap();
  
  public static DnsCacheManager getInstance()
  {
    return instance;
  }
  
  public void clear()
  {
    this.dnsCacheObjMap.clear();
    DnsInfo.clear();
  }
  
  public DnsCacheObj getDnsCache(String paramString)
  {
    return (DnsCacheObj)this.dnsCacheObjMap.get(paramString);
  }
  
  List<String> getIpList(String paramString)
  {
    DnsCacheObj localDnsCacheObj = (DnsCacheObj)this.dnsCacheObjMap.get(paramString);
    if (localDnsCacheObj != null) {
      if (System.currentTimeMillis() - localDnsCacheObj.updateTime > localDnsCacheObj.ttl * 1000L)
      {
        this.dnsCacheObjMap.remove(paramString);
        DnsInfo.remove(paramString);
        return null;
      }
    }
    for (paramString = new ArrayList(localDnsCacheObj.getIpList());; paramString = null) {
      return paramString;
    }
  }
  
  public void invalidate()
  {
    Iterator localIterator = this.dnsCacheObjMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (DnsCacheObj)this.dnsCacheObjMap.get(localObject);
      if (localObject != null) {
        ((DnsCacheObj)localObject).ttl = 0L;
      }
    }
  }
  
  public void update(String paramString, List<String> paramList, long paramLong, int paramInt)
  {
    Object localObject1 = (DnsCacheObj)this.dnsCacheObjMap.get(paramString);
    if ((localObject1 == null) || (((DnsCacheObj)localObject1).from != 1) || (paramInt != 2))
    {
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = (DnsCacheObj)this.dnsCacheObjMap.get(paramString);
          if ((localObject1 != null) && (((DnsCacheObj)localObject1).from == 1) && (paramInt == 2)) {
            break label307;
          }
          localObject2 = Logger.INSTANCE;
          String str = ", ipList: " + paramList;
          if (paramInt == 1)
          {
            localObject1 = "httpdns";
            ((Logger)localObject2).d(new String[] { "QAPM_DNS_DnsCacheManager", "update cache, host: ", paramString, str, ", ttl: ", String.valueOf(paramLong), "s", ", from: ", localObject1 });
            localObject1 = new DnsCacheObj();
            ((DnsCacheObj)localObject1).host = paramString;
            ((DnsCacheObj)localObject1).ttl = paramLong;
            ((DnsCacheObj)localObject1).updateTime = System.currentTimeMillis();
            ((DnsCacheObj)localObject1).wifi = NetworkUtils.isWifi();
            ((DnsCacheObj)localObject1).ssid = DnsCacheObj.hash(NetworkUtils.getWifiSsid());
            localObject2 = new CopyOnWriteArrayList();
            paramList = paramList.iterator();
            if (!paramList.hasNext()) {
              break;
            }
            ((CopyOnWriteArrayList)localObject2).add(new IpCachedItem((String)paramList.next()));
            continue;
          }
          localObject1 = "systemdns";
        }
        finally {}
      }
      ((DnsCacheObj)localObject1).ipList = ((CopyOnWriteArrayList)localObject2);
      ((DnsCacheObj)localObject1).from = paramInt;
      this.dnsCacheObjMap.put(paramString, localObject1);
      for (;;)
      {
        return;
        label307:
        Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheManager", "no need to update cache: ", ((DnsCacheObj)localObject1).host });
      }
    }
    Logger.INSTANCE.d(new String[] { "QAPM_DNS_DnsCacheManager", "no need to update cache: ", ((DnsCacheObj)localObject1).host });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.logic.DnsCacheManager
 * JD-Core Version:    0.7.0.1
 */