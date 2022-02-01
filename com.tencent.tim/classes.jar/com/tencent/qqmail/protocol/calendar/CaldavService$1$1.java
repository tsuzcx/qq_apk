package com.tencent.qqmail.protocol.calendar;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.Proxy;

class CaldavService$1$1
  implements Authenticator
{
  CaldavService$1$1(CaldavService.1 param1, String paramString) {}
  
  public Request authenticate(Proxy paramProxy, Response paramResponse)
    throws IOException
  {
    return paramResponse.request().newBuilder().header("Authorization", this.val$credential).build();
  }
  
  public Request authenticateProxy(Proxy paramProxy, Response paramResponse)
    throws IOException
  {
    return paramResponse.request().newBuilder().header("Proxy-Authorization", this.val$credential).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.CaldavService.1.1
 * JD-Core Version:    0.7.0.1
 */