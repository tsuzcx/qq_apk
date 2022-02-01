package com.tencent.tpns.baseapi.core.net;

import com.tencent.tpns.baseapi.base.util.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class a$1
  implements HostnameVerifier
{
  a$1(a parama, String paramString) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    Logger.d("HttpRequest", "HostnameVerifier : hostName " + paramString);
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.net.a.1
 * JD-Core Version:    0.7.0.1
 */