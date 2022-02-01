package com.tencent.qqmail.utilities.qmnetwork;

import java.net.Proxy.Type;

public class QMProxy
{
  public static final int PROXY_HTTP = 2;
  public static final int PROXY_NOUSE = 0;
  public static final int PROXY_SOCKS4 = 3;
  public static final int PROXY_SOCKS5 = 4;
  public static final int PROXY_SOCKS5H = 5;
  public static final int PROXY_SYSTEM = 1;
  private boolean authentication = false;
  private String proxyHost = "";
  private String proxyPassword = "";
  private int proxyPort = 0;
  private int proxyType = 0;
  private String proxyUserName = "";
  
  public QMProxy(int paramInt1, String paramString, int paramInt2)
  {
    this.proxyType = paramInt1;
    this.proxyHost = paramString;
    this.proxyPort = paramInt2;
  }
  
  public String getProxyHost()
  {
    return this.proxyHost;
  }
  
  public String getProxyPassword()
  {
    return this.proxyPassword;
  }
  
  public int getProxyPort()
  {
    return this.proxyPort;
  }
  
  public int getProxyType()
  {
    return this.proxyType;
  }
  
  public String getProxyUserName()
  {
    return this.proxyUserName;
  }
  
  public boolean isAuthentication()
  {
    return this.authentication;
  }
  
  public void setAuthentication(String paramString1, String paramString2)
  {
    this.authentication = true;
    this.proxyUserName = paramString1;
    this.proxyPassword = paramString2;
  }
  
  public void setProxyHost(String paramString)
  {
    this.proxyHost = paramString;
  }
  
  public void setProxyPort(int paramInt)
  {
    this.proxyPort = paramInt;
  }
  
  public void setProxyType(int paramInt)
  {
    this.proxyType = paramInt;
  }
  
  public int transferCalendarProxyType()
  {
    switch (this.proxyType)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public Proxy.Type transferHttpProxyType()
  {
    Proxy.Type localType = Proxy.Type.HTTP;
    switch (this.proxyType)
    {
    default: 
      return localType;
    case 0: 
      return Proxy.Type.HTTP;
    case 1: 
      return Proxy.Type.HTTP;
    case 2: 
      return Proxy.Type.HTTP;
    case 3: 
      return Proxy.Type.SOCKS;
    case 4: 
      return Proxy.Type.SOCKS;
    }
    return Proxy.Type.SOCKS;
  }
  
  public int transferProfileProxyType()
  {
    switch (this.proxyType)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMProxy
 * JD-Core Version:    0.7.0.1
 */