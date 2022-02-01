package com.tencent.qqmail.utilities.qmnetwork.ssl;

import android.content.SharedPreferences;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public abstract class SSLStraetgy
  extends SSLSocketFactory
  implements HostnameVerifier
{
  private static final String TAG = "SSLStraetgy";
  static final String TRUSTED_CERTIFICATE_SP_NAME = "trusted_certificate";
  static final String UNCONFIRMED_CERTIFICATE_SP_NAME = "unconfirmed_certificate";
  static final String UNCONFIRMED_HOST_SP_NAME = "unconfirmed_host";
  String mHost;
  int mPort;
  private final SSLSocketFactory wrappedFactory = expandCipherSuites(getWrappedFactory());
  
  private SSLSocketFactory expandCipherSuites(SSLSocketFactory paramSSLSocketFactory)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "com.android.org.conscrypt.";
    arrayOfString[1] = "org.conscrypt.";
    arrayOfString[2] = "org.apache.harmony.xnet.provider.jsse.";
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < j) {
        localObject2 = arrayOfString[i];
      }
      try
      {
        Object localObject1 = Class.forName((String)localObject2 + "OpenSSLSocketFactoryImpl").getDeclaredField("sslParameters");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramSSLSocketFactory);
        localObject2 = Class.forName((String)localObject2 + "SSLParametersImpl");
        Method localMethod = ((Class)localObject2).getDeclaredMethod("setEnabledCipherSuites", new Class[] { [Ljava.lang.String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localObject1, new Object[] { paramSSLSocketFactory.getSupportedCipherSuites() });
        localObject2 = ((Class)localObject2).getDeclaredMethod("setEnabledProtocols", new Class[] { [Ljava.lang.String.class });
        ((Method)localObject2).setAccessible(true);
        ((Method)localObject2).invoke(localObject1, new Object[] { { "TLSv1", "TLSv1.1", "TLSv1.2", "SSLv3" } });
        return paramSSLSocketFactory;
      }
      catch (Exception localException)
      {
        QMLog.log(5, "SSLStraetgy", "expandCipherSuites failed", localException);
        i += 1;
      }
    }
  }
  
  static int getUrlId(String paramString)
  {
    return hashInt(paramString);
  }
  
  protected static int hashInt(String paramString)
  {
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      j = j * 131 + paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  private void logSocket(String paramString, int paramInt)
  {
    this.mHost = paramString;
    this.mPort = paramInt;
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    logSocket(paramString, paramInt);
    return this.wrappedFactory.createSocket(paramString, paramInt);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    logSocket(paramString, paramInt1);
    return this.wrappedFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    logSocket(paramInetAddress.getHostName(), paramInt);
    return this.wrappedFactory.createSocket(paramInetAddress, paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    logSocket(paramInetAddress1.getHostName(), paramInt1);
    return this.wrappedFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    logSocket(paramString, paramInt);
    return this.wrappedFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  int getCertificateId(X509Certificate paramX509Certificate)
  {
    if (paramX509Certificate == null)
    {
      QMLog.log(4, "SSLStraetgy", "null X509Certificate");
      return 0;
    }
    return hashInt(paramX509Certificate.getIssuerX500Principal() + "^" + paramX509Certificate.getSerialNumber().toString());
  }
  
  public String[] getDefaultCipherSuites()
  {
    return this.wrappedFactory.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.wrappedFactory.getSupportedCipherSuites();
  }
  
  abstract SSLSocketFactory getWrappedFactory();
  
  boolean isCertificateTrusted(X509Certificate paramX509Certificate)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramX509Certificate != null)
    {
      bool1 = bool2;
      if (SPManager.getSp("trusted_certificate").getBoolean(getCertificateId(paramX509Certificate) + "", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  boolean isHostTrusted(String paramString)
  {
    return SPManager.getSp("trusted_certificate").getBoolean(getUrlId(paramString) + "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SSLStraetgy
 * JD-Core Version:    0.7.0.1
 */