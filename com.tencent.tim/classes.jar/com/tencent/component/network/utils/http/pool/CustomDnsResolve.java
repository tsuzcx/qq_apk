package com.tencent.component.network.utils.http.pool;

import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CustomDnsResolve
{
  private static final ConcurrentHashMap<String, Boolean> mapIPDirectEnable = new ConcurrentHashMap();
  private final List<IPStrategy> mIPStrategys = new ArrayList();
  
  private InetAddress[] getDirectIpList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.mIPStrategys.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((IPStrategy)localIterator.next()).resolveIP(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = InetAddress.getByName((String)localObject);
          if (!localArrayList.contains(localObject)) {
            localArrayList.add(localObject);
          }
        }
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      QDLog.e("CustomDnsResolve", "", paramString);
      paramString = new InetAddress[localArrayList.size()];
      localArrayList.toArray(paramString);
    }
  }
  
  private boolean isIPDirectEnable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!mapIPDirectEnable.containsKey(paramString)) {
      return true;
    }
    return ((Boolean)mapIPDirectEnable.get(paramString)).booleanValue();
  }
  
  public static void setIPDirectEnable(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    mapIPDirectEnable.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void addIpStrategy(IPStrategy paramIPStrategy)
  {
    if ((paramIPStrategy != null) && (!this.mIPStrategys.contains(paramIPStrategy))) {
      this.mIPStrategys.add(paramIPStrategy);
    }
  }
  
  public InetAddress[] getAllByName(String paramString)
    throws UnknownHostException
  {
    if (TextUtils.isEmpty(paramString)) {
      return new InetAddress[0];
    }
    if (isIPDirectEnable(paramString)) {
      return getDirectIpList(paramString);
    }
    return resolveByDns(paramString);
  }
  
  public InetAddress[] resolveByDns(String paramString)
    throws UnknownHostException
  {
    if (TextUtils.isEmpty(paramString)) {
      return new InetAddress[0];
    }
    paramString = DnsService.getInstance().getDomainIP(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return new InetAddress[0];
    }
    return new InetAddress[] { InetAddress.getByName(paramString) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.CustomDnsResolve
 * JD-Core Version:    0.7.0.1
 */