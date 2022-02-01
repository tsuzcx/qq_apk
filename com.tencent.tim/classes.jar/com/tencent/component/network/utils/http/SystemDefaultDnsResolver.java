package com.tencent.component.network.utils.http;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.SystemDefaultDnsResolver
 * JD-Core Version:    0.7.0.1
 */