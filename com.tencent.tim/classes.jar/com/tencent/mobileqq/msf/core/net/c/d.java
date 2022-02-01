package com.tencent.mobileqq.msf.core.net.c;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class d
  implements HostnameVerifier
{
  d(c paramc) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if (this.a.j == null) {
      return false;
    }
    paramString = HttpsURLConnection.getDefaultHostnameVerifier();
    String str = this.a.j.getHost();
    boolean bool = paramString.verify(str, paramSSLSession);
    if (!bool) {
      QLog.d("MSF.C.QualityTestManager", 1, new Object[] { "QualityMtuTestClient.HostnameVerifier.host:", str, ",address:", paramSSLSession.getPeerHost(), ",isVerify:", Boolean.valueOf(false) });
    }
    for (;;)
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.QualityTestManager", 2, new Object[] { "QualityMtuTestClient.HostnameVerifier.host:", str, ",address:", paramSSLSession.getPeerHost(), ",isVerify:", Boolean.valueOf(true) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.d
 * JD-Core Version:    0.7.0.1
 */