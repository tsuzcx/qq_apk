package com.tencent.sonic.sdk;

import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class SonicSessionConnection$SessionConnectionDefaultImpl$1
  implements HostnameVerifier
{
  SonicSessionConnection$SessionConnectionDefaultImpl$1(SonicSessionConnection.SessionConnectionDefaultImpl paramSessionConnectionDefaultImpl, URL paramURL, String paramString) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if (this.val$finalUrl.getHost().equals(paramString))
    {
      bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$finalOriginHost, paramSSLSession);
      SonicUtils.log("SonicSdk_SonicSessionConnection", 3, "verify hostname cost " + (System.currentTimeMillis() - l) + " ms.");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl.1
 * JD-Core Version:    0.7.0.1
 */