package com.tencent.map.sdk.a;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class bf
  implements HostnameVerifier
{
  private String a;
  
  public bf(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((TextUtils.isEmpty(this.a)) || (!(paramObject instanceof bf))) {}
    do
    {
      return false;
      paramObject = ((bf)paramObject).a;
    } while (TextUtils.isEmpty(paramObject));
    return this.a.equals(paramObject);
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.bf
 * JD-Core Version:    0.7.0.1
 */