package com.qzone.common;

import java.io.Serializable;

public class IPInfo
  implements Serializable
{
  public String ip;
  public int port;
  
  public IPInfo() {}
  
  public IPInfo(String paramString, int paramInt)
  {
    this.ip = paramString;
    this.port = paramInt;
  }
  
  public IPInfo clone()
  {
    return new IPInfo(this.ip, this.port);
  }
  
  public boolean equalWith(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    if (paramString2 != null) {
      return paramString2.equals(paramString1);
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof IPInfo))) {
        break;
      }
      paramObject = (IPInfo)paramObject;
    } while ((equalWith(paramObject.ip, this.ip)) && (paramObject.port == this.port));
    return false;
    return false;
  }
  
  public String toString()
  {
    return new String(this.ip + ":" + this.port);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.IPInfo
 * JD-Core Version:    0.7.0.1
 */