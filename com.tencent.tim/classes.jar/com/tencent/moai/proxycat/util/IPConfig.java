package com.tencent.moai.proxycat.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPConfig
{
  public static final InetAddress FAKE_CLIENT_ADDRESS = getAddressQuietly("10.0.0.2");
  public static final InetAddress UDP_TO_VPN_ADDRESS = getAddressQuietly("10.0.0.3");
  public static final InetAddress VPN_ADDRESS = getAddressQuietly("10.0.0.1");
  
  private static InetAddress getAddressQuietly(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(paramString);
      return paramString;
    }
    catch (UnknownHostException paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.util.IPConfig
 * JD-Core Version:    0.7.0.1
 */