package com.tencent.mobileqq.service;

import com.dataline.util.DBNetworkUtil;
import gih;
import gim;
import gis;
import java.io.IOException;
import java.net.InetAddress;

public class HttpServer
{
  public static final String a = "dlFileTransfer.Server";
  private gim a = null;
  
  public int a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return 0;
  }
  
  public String a(long paramLong)
  {
    return gis.a(paramLong);
  }
  
  public InetAddress a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
  }
  
  public void a(long paramLong)
  {
    gis.a(paramLong);
  }
  
  public void a(long paramLong, String paramString)
  {
    gis.a(paramLong, paramString);
  }
  
  public boolean a()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return false;
  }
  
  public boolean a(String paramString, HttpNotify paramHttpNotify)
  {
    paramHttpNotify = new gih(paramHttpNotify);
    try
    {
      if (this.a != null)
      {
        if (this.a.c()) {
          return true;
        }
        a();
      }
      if (DBNetworkUtil.a())
      {
        this.a = new gim(paramString, paramHttpNotify);
        this.a.setDaemon(false);
        boolean bool = this.a.b();
        return bool;
      }
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public boolean b()
  {
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.HttpServer
 * JD-Core Version:    0.7.0.1
 */