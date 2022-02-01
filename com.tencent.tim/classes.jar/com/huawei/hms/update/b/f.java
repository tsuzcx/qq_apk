package com.huawei.hms.update.b;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

final class f
  extends SSLSocketFactory
{
  private static final Object a = new Object();
  private static SocketFactory b;
  private final SSLContext c;
  private Context d;
  
  private f(Context paramContext)
    throws NoSuchAlgorithmException, KeyManagementException, CertificateException, KeyStoreException, IOException
  {
    this.d = paramContext;
    this.c = SSLContext.getInstance("TLSv1.2");
    paramContext = new e(this.d);
    this.c.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  /* Error */
  public static SocketFactory a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 21	com/huawei/hms/update/b/f:a	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic 62	com/huawei/hms/update/b/f:b	Ljavax/net/SocketFactory;
    //   9: ifnonnull +14 -> 23
    //   12: new 2	com/huawei/hms/update/b/f
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 63	com/huawei/hms/update/b/f:<init>	(Landroid/content/Context;)V
    //   20: putstatic 62	com/huawei/hms/update/b/f:b	Ljavax/net/SocketFactory;
    //   23: getstatic 62	com/huawei/hms/update/b/f:b	Ljavax/net/SocketFactory;
    //   26: astore_0
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: ldc 65
    //   33: new 67	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   40: ldc 70
    //   42: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 80	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   49: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 89	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: invokestatic 93	javax/net/ssl/SSLSocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   61: astore_0
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_0
    //   65: areturn
    //   66: astore_0
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    //   71: astore_0
    //   72: goto -41 -> 31
    //   75: astore_0
    //   76: goto -45 -> 31
    //   79: astore_0
    //   80: goto -49 -> 31
    //   83: astore_0
    //   84: goto -53 -> 31
    //   87: astore_0
    //   88: goto -57 -> 31
    //   91: astore_0
    //   92: goto -61 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   6	23	66	finally
    //   23	27	66	finally
    //   27	29	66	finally
    //   31	64	66	finally
    //   67	69	66	finally
    //   6	23	71	java/security/NoSuchAlgorithmException
    //   23	27	71	java/security/NoSuchAlgorithmException
    //   6	23	75	java/security/cert/CertificateException
    //   23	27	75	java/security/cert/CertificateException
    //   6	23	79	java/io/IOException
    //   23	27	79	java/io/IOException
    //   6	23	83	java/lang/IllegalArgumentException
    //   23	27	83	java/lang/IllegalArgumentException
    //   6	23	87	java/security/KeyManagementException
    //   23	27	87	java/security/KeyManagementException
    //   6	23	91	java/security/KeyStoreException
    //   23	27	91	java/security/KeyStoreException
  }
  
  private void a(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket))
    {
      b((SSLSocket)paramSocket);
      a((SSLSocket)paramSocket);
    }
  }
  
  public static void a(SSLSocket paramSSLSocket)
  {
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      if (a(str)) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(str);
      }
    }
    paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
  }
  
  private static boolean a(String paramString)
  {
    return (paramString.contains("RC2")) || (paramString.contains("RC4")) || (paramString.contains("DES")) || (paramString.contains("MD2")) || (paramString.contains("MD4")) || (paramString.contains("MD5")) || (paramString.contains("ANON")) || (paramString.contains("NULL")) || (paramString.contains("SKIPJACK")) || (paramString.contains("SHA1")) || (paramString.contains("TEA")) || (paramString.contains("SHA0")) || (paramString.contains("RIPEMD")) || (paramString.contains("TLS_EMPTY_RENEGOTIATION_INFO_SCSV")) || (paramString.contains("aNULL")) || (paramString.contains("eNULL")) || (paramString.contains("TLS_DH_anon_WITH_AES_256_CBC_SHA")) || (paramString.contains("DES40")) || (paramString.contains("DESX")) || (paramString.contains("TLS_RSA")) || (paramString.contains("SSL_RSA"));
  }
  
  private void b(SSLSocket paramSSLSocket)
  {
    paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    paramString = this.c.getSocketFactory().createSocket(paramString, paramInt);
    a(paramString);
    return paramString;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    paramString = this.c.getSocketFactory().createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    a(paramString);
    return paramString;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    paramInetAddress = this.c.getSocketFactory().createSocket(paramInetAddress, paramInt);
    a(paramInetAddress);
    return paramInetAddress;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    paramInetAddress1 = this.c.getSocketFactory().createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    a(paramInetAddress1);
    return paramInetAddress1;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    paramSocket = this.c.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(paramSocket);
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.b.f
 * JD-Core Version:    0.7.0.1
 */