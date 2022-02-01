package com.huawei.updatesdk.a.a.a;

import android.os.Build.VERSION;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class c
{
  private static final String[] a = { "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384" };
  private static final String[] b = { "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "aNULL", "eNULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "NULL", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA", "SSL_RSA", "TLS_DH_anon_WITH_AES_256_CBC_SHA" };
  private static final String[] c = { "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA" };
  
  public static SSLContext a()
    throws NoSuchAlgorithmException
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return SSLContext.getInstance("TLSv1.3");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return SSLContext.getInstance("TLSv1.2");
    }
    return SSLContext.getInstance("TLS");
  }
  
  public static void a(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 29) {
        paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.3", "TLSv1.2" });
      }
      if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 29))
      {
        paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.2" });
        return;
      }
    } while (Build.VERSION.SDK_INT >= 16);
    paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1" });
  }
  
  private static boolean a(SSLSocket paramSSLSocket, ArrayList<String> paramArrayList)
  {
    if ((paramSSLSocket == null) || (paramArrayList == null)) {
      return false;
    }
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      String str2 = str1.toUpperCase(Locale.ENGLISH);
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (str2.equals((String)localIterator.next())) {
          localArrayList.add(str1);
        }
      }
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return true;
    }
    return false;
  }
  
  public static void b(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    a(paramSSLSocket);
    c(paramSSLSocket);
  }
  
  private static void b(SSLSocket paramSSLSocket, ArrayList<String> paramArrayList)
  {
    if ((paramSSLSocket == null) || (paramArrayList == null)) {
      return;
    }
    String[] arrayOfString = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfString.length;
    int i = 0;
    label31:
    String str1;
    if (i < k)
    {
      str1 = arrayOfString[i];
      String str2 = str1.toUpperCase(Locale.ENGLISH);
      Iterator localIterator = paramArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!str2.contains(((String)localIterator.next()).toUpperCase(Locale.ENGLISH)));
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(str1);
      }
      i += 1;
      break label31;
      if (localArrayList.isEmpty()) {
        break;
      }
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return;
    }
  }
  
  private static void c(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if (Build.VERSION.SDK_INT >= 20)
      {
        localArrayList1.addAll(Arrays.asList(a));
        localArrayList2.addAll(Arrays.asList(b));
        localArrayList2.addAll(Arrays.asList(c));
      }
      while (!a(paramSSLSocket, localArrayList1))
      {
        b(paramSSLSocket, localArrayList2);
        return;
        localArrayList1.addAll(Arrays.asList(a));
        localArrayList2.addAll(Arrays.asList(b));
        localArrayList1.addAll(Arrays.asList(c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */