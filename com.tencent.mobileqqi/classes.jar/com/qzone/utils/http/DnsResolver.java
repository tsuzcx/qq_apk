package com.qzone.utils.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract interface DnsResolver
{
  public abstract InetAddress[] resolve(String paramString)
    throws UnknownHostException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.DnsResolver
 * JD-Core Version:    0.7.0.1
 */