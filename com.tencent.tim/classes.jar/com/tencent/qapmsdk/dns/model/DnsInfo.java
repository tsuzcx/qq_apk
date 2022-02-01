package com.tencent.qapmsdk.dns.model;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DnsInfo
{
  private static final ConcurrentHashMap<String, Dns> DNS_MAP = new ConcurrentHashMap();
  
  public static void clear()
  {
    DNS_MAP.clear();
  }
  
  public static long getDnsElapse(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (DNS_MAP.get(paramString) == null)) {
      return 0L;
    }
    Dns localDns = (Dns)DNS_MAP.get(paramString);
    if (!localDns.hasReport)
    {
      localDns.hasReport = true;
      DNS_MAP.put(paramString, localDns);
      return localDns.dnsTime;
    }
    return 0L;
  }
  
  public static String getHostFromIp(String paramString)
  {
    Iterator localIterator = DNS_MAP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      InetAddress[] arrayOfInetAddress = ((Dns)DNS_MAP.get(str)).inetAddresses;
      int j = arrayOfInetAddress.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(arrayOfInetAddress[i].getHostAddress())) {
          return str;
        }
        i += 1;
      }
    }
    return paramString;
  }
  
  public static void remove(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (DNS_MAP.get(paramString) != null)) {
      DNS_MAP.remove(paramString);
    }
  }
  
  public static void setDns(String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong >= 0L) && (DNS_MAP.get(paramString) == null)) {
      DNS_MAP.put(paramString, new Dns(paramArrayOfInetAddress, paramLong));
    }
  }
  
  public static class Dns
  {
    public long dnsTime;
    public boolean hasReport;
    public InetAddress[] inetAddresses;
    
    public Dns(InetAddress[] paramArrayOfInetAddress, long paramLong)
    {
      this.inetAddresses = paramArrayOfInetAddress;
      this.dnsTime = paramLong;
      this.hasReport = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.model.DnsInfo
 * JD-Core Version:    0.7.0.1
 */