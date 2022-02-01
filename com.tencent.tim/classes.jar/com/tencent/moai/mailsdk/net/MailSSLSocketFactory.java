package com.tencent.moai.mailsdk.net;

import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class MailSSLSocketFactory
  extends SSLSocketFactory
{
  private static final String[] SUPPORT_PROTOCOLS = { "TLSv1", "TLSv1.1", "TLSv1.2" };
  private static final String TAG = "MailSSLSocketFactory";
  private SSLSocketFactory adapteeFactory = null;
  private KeyManager[] keyManagers;
  private SecureRandom secureRandom;
  private SSLContext sslcontext;
  private boolean trustAllHosts = false;
  private TrustManager[] trustManagers;
  private String[] trustedHosts = null;
  
  public MailSSLSocketFactory()
    throws GeneralSecurityException
  {
    this("TLS");
  }
  
  public MailSSLSocketFactory(String paramString)
    throws GeneralSecurityException
  {
    this.sslcontext = SSLContext.getInstance(paramString);
    this.keyManagers = null;
    this.trustManagers = new TrustManager[] { new MailTrustManager(null) };
    this.secureRandom = null;
    newAdapteeFactory();
  }
  
  private static SSLSocketFactory expandCipherSuites(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      Object localObject1 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      Field localField = ((Class)localObject1).getDeclaredField("enabledCipherSuites");
      localField.setAccessible(true);
      Object localObject2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketFactoryImpl").getDeclaredField("sslParameters");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(paramSSLSocketFactory);
      localObject1 = ((Class)localObject1).getDeclaredField("enabledProtocols");
      ((Field)localObject1).setAccessible(true);
      ((Field)localObject1).set(localObject2, SUPPORT_PROTOCOLS);
      localField.set(localObject2, paramSSLSocketFactory.getSupportedCipherSuites());
      return paramSSLSocketFactory;
    }
    catch (Exception localException)
    {
      Logger.log(5, "MailSSLSocketFactory", "expandCipherSuites failed " + localException.getMessage());
    }
    return paramSSLSocketFactory;
  }
  
  private void newAdapteeFactory()
    throws KeyManagementException
  {
    try
    {
      this.sslcontext.init(this.keyManagers, this.trustManagers, this.secureRandom);
      this.adapteeFactory = this.sslcontext.getSocketFactory();
      expandCipherSuites(this.adapteeFactory);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Socket createSocket()
    throws IOException
  {
    try
    {
      Socket localSocket = this.adapteeFactory.createSocket();
      return localSocket;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    try
    {
      paramString = this.adapteeFactory.createSocket(paramString, paramInt);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    try
    {
      paramString = this.adapteeFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    try
    {
      paramInetAddress = this.adapteeFactory.createSocket(paramInetAddress, paramInt);
      return paramInetAddress;
    }
    finally
    {
      paramInetAddress = finally;
      throw paramInetAddress;
    }
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    try
    {
      paramInetAddress1 = this.adapteeFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
      return paramInetAddress1;
    }
    finally
    {
      paramInetAddress1 = finally;
      throw paramInetAddress1;
    }
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    try
    {
      paramSocket = this.adapteeFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
      return paramSocket;
    }
    finally
    {
      paramSocket = finally;
      throw paramSocket;
    }
  }
  
  public String[] getDefaultCipherSuites()
  {
    try
    {
      String[] arrayOfString = this.adapteeFactory.getDefaultCipherSuites();
      return arrayOfString;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public KeyManager[] getKeyManagers()
  {
    try
    {
      KeyManager[] arrayOfKeyManager = (KeyManager[])this.keyManagers.clone();
      return arrayOfKeyManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SecureRandom getSecureRandom()
  {
    try
    {
      SecureRandom localSecureRandom = this.secureRandom;
      return localSecureRandom;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String[] getSupportedCipherSuites()
  {
    try
    {
      String[] arrayOfString = this.adapteeFactory.getSupportedCipherSuites();
      return arrayOfString;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public TrustManager[] getTrustManagers()
  {
    try
    {
      TrustManager[] arrayOfTrustManager = this.trustManagers;
      return arrayOfTrustManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String[] getTrustedHosts()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/tencent/moai/mailsdk/net/MailSSLSocketFactory:trustedHosts	[Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 52	com/tencent/moai/mailsdk/net/MailSSLSocketFactory:trustedHosts	[Ljava/lang/String;
    //   21: invokevirtual 194	[Ljava/lang/String;:clone	()Ljava/lang/Object;
    //   24: checkcast 193	[Ljava/lang/String;
    //   27: astore_1
    //   28: goto -15 -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	MailSSLSocketFactory
    //   6	22	1	arrayOfString	String[]
    //   31	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   17	28	31	finally
  }
  
  /* Error */
  public boolean isServerTrusted(String paramString, javax.net.ssl.SSLSocket paramSSLSocket)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 56	com/tencent/moai/mailsdk/net/MailSSLSocketFactory:trustAllHosts	Z
    //   8: istore 4
    //   10: iload 4
    //   12: ifeq +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 52	com/tencent/moai/mailsdk/net/MailSSLSocketFactory:trustedHosts	[Ljava/lang/String;
    //   23: ifnull -8 -> 15
    //   26: aload_0
    //   27: getfield 52	com/tencent/moai/mailsdk/net/MailSSLSocketFactory:trustedHosts	[Ljava/lang/String;
    //   30: invokestatic 202	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   33: aload_1
    //   34: invokeinterface 208 2 0
    //   39: istore_3
    //   40: goto -25 -> 15
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	MailSSLSocketFactory
    //   0	48	1	paramString	String
    //   0	48	2	paramSSLSocket	javax.net.ssl.SSLSocket
    //   1	39	3	bool1	boolean
    //   8	3	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	43	finally
    //   19	40	43	finally
  }
  
  public boolean isTrustAllHosts()
  {
    try
    {
      boolean bool = this.trustAllHosts;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setKeyManagers(KeyManager[] paramArrayOfKeyManager)
    throws GeneralSecurityException
  {
    try
    {
      this.keyManagers = ((KeyManager[])paramArrayOfKeyManager.clone());
      newAdapteeFactory();
      return;
    }
    finally
    {
      paramArrayOfKeyManager = finally;
      throw paramArrayOfKeyManager;
    }
  }
  
  public void setSecureRandom(SecureRandom paramSecureRandom)
    throws GeneralSecurityException
  {
    try
    {
      this.secureRandom = paramSecureRandom;
      newAdapteeFactory();
      return;
    }
    finally
    {
      paramSecureRandom = finally;
      throw paramSecureRandom;
    }
  }
  
  public void setTrustAllHosts(boolean paramBoolean)
  {
    try
    {
      this.trustAllHosts = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTrustManagers(TrustManager[] paramArrayOfTrustManager)
    throws GeneralSecurityException
  {
    try
    {
      this.trustManagers = paramArrayOfTrustManager;
      newAdapteeFactory();
      return;
    }
    finally
    {
      paramArrayOfTrustManager = finally;
      throw paramArrayOfTrustManager;
    }
  }
  
  public void setTrustedHosts(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      try
      {
        this.trustedHosts = null;
        return;
      }
      finally {}
      this.trustedHosts = ((String[])paramArrayOfString.clone());
    }
  }
  
  class MailTrustManager
    implements X509TrustManager
  {
    private X509TrustManager adapteeTrustManager = null;
    
    private MailTrustManager()
      throws GeneralSecurityException
    {
      this$1 = TrustManagerFactory.getInstance("X509");
      MailSSLSocketFactory.this.init((KeyStore)null);
      this.adapteeTrustManager = ((X509TrustManager)MailSSLSocketFactory.this.getTrustManagers()[0]);
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      if ((!MailSSLSocketFactory.this.isTrustAllHosts()) && (MailSSLSocketFactory.this.getTrustedHosts() == null)) {
        this.adapteeTrustManager.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      if ((!MailSSLSocketFactory.this.isTrustAllHosts()) && (MailSSLSocketFactory.this.getTrustedHosts() == null)) {
        this.adapteeTrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return this.adapteeTrustManager.getAcceptedIssuers();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.MailSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */