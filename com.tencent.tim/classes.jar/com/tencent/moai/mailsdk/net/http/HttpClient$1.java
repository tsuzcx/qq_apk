package com.tencent.moai.mailsdk.net.http;

import com.tencent.moai.mailsdk.net.MailSSLUtil;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class HttpClient$1
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    HostnameVerifier localHostnameVerifier = MailSSLUtil.getDelegateHostnameVerifier();
    if (localHostnameVerifier != null) {
      return localHostnameVerifier.verify(paramString, paramSSLSession);
    }
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.http.HttpClient.1
 * JD-Core Version:    0.7.0.1
 */