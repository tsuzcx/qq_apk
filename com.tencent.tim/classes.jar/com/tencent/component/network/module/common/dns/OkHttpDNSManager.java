package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;

public class OkHttpDNSManager
{
  private CustomDnsResolve customDnsResolve;
  
  public OkHttpDNSManager(CustomDnsResolve paramCustomDnsResolve)
  {
    this.customDnsResolve = paramCustomDnsResolve;
  }
  
  public List<InetAddress> getAllByName(String paramString)
    throws UnknownHostException
  {
    Object localObject1 = null;
    if (this.customDnsResolve != null)
    {
      localObject1 = this.customDnsResolve.getAllByName(paramString);
      if ((localObject1 != null) && (localObject1.length > 0)) {
        QDLog.i("downloader", "OkHttpDNSManager customDnsResolve.getAllByName");
      }
    }
    else
    {
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break label137;
      }
      paramString = Arrays.asList((Object[])localObject1);
    }
    for (;;)
    {
      localObject1 = new StringBuilder();
      if (paramString == null) {
        break label157;
      }
      Object localObject2 = paramString.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(((InetAddress)((Iterator)localObject2).next()).getHostAddress());
        ((StringBuilder)localObject1).append(";");
      }
      localObject2 = this.customDnsResolve.resolveByDns(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject2;
      if (localObject2.length <= 0) {
        break;
      }
      QDLog.i("downloader", "OkHttpDNSManager customDnsResolve.resolveByDns");
      localObject1 = localObject2;
      break;
      label137:
      paramString = Dns.SYSTEM.lookup(paramString);
      QDLog.i("downloader", "OkHttpDNSManager Dns.SYSTEM.lookup");
    }
    label157:
    QDLog.i("downloader", "OkHttpDNSManager" + ((StringBuilder)localObject1).toString());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.OkHttpDNSManager
 * JD-Core Version:    0.7.0.1
 */