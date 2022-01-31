package com.qzone.utils.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemDefaultDnsResolver
  implements DnsResolver
{
  public InetAddress[] resolve(String paramString)
    throws UnknownHostException
  {
    return InetAddress.getAllByName(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.SystemDefaultDnsResolver
 * JD-Core Version:    0.7.0.1
 */