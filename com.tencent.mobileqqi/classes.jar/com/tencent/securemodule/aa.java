package com.tencent.securemodule;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public final class aa
{
  private HttpURLConnection a;
  private boolean b;
  private a c;
  
  public aa() {}
  
  public aa(Context paramContext)
  {
    this.a = null;
    this.b = false;
    this.c = a.d;
    this.c = a(paramContext);
  }
  
  private int a(Context paramContext, String paramString)
  {
    if (this.c == a.d) {
      return -1052;
    }
    try
    {
      URL localURL = new URL(paramString);
      Proxy.Type localType;
      if (this.c == a.b)
      {
        localType = Proxy.Type.HTTP;
        paramString = android.net.Proxy.getHost(paramContext);
        if ((paramString != null) && (paramString.length() != 0)) {
          break label194;
        }
        paramString = android.net.Proxy.getDefaultHost();
      }
      for (;;)
      {
        int j = android.net.Proxy.getPort(paramContext);
        int i = j;
        if (j <= 0) {
          i = android.net.Proxy.getDefaultPort();
        }
        for (this.a = ((HttpURLConnection)localURL.openConnection(new java.net.Proxy(localType, InetSocketAddress.createUnresolved(paramString, i))));; this.a = ((HttpURLConnection)localURL.openConnection()))
        {
          this.a.setReadTimeout(15000);
          this.a.setConnectTimeout(15000);
          return 0;
        }
      }
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
      return -1053;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return -1057;
    }
    catch (SecurityException paramContext)
    {
      paramContext.printStackTrace();
      return -1058;
    }
    catch (UnsupportedOperationException paramContext)
    {
      paramContext.printStackTrace();
      return -1059;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return -1056;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return -1000;
    }
  }
  
  public static a a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || ((localNetworkInfo.getState() != NetworkInfo.State.CONNECTING) && (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED))) {
      return a.d;
    }
    if (localNetworkInfo.getType() == 1) {
      return a.a;
    }
    if (localNetworkInfo.getType() == 0)
    {
      if ((android.net.Proxy.getDefaultHost() != null) || (android.net.Proxy.getHost(paramContext) != null)) {
        return a.b;
      }
      return a.c;
    }
    return a.d;
  }
  
  public final int a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    int i = a(paramContext, paramString);
    if (i != 0) {
      return i;
    }
    this.b = false;
    try
    {
      i = paramArrayOfByte.length;
      this.a.setDoOutput(true);
      this.a.setDoInput(true);
      this.a.setUseCaches(false);
      this.a.setRequestMethod("POST");
      this.a.setRequestProperty("User-Agent", "QQPimSecure");
      this.a.setRequestProperty("Accept", "*/*");
      this.a.setRequestProperty("Accept-Charset", "utf-8");
      this.a.setRequestProperty("Content-Type", "application/octet-stream");
      this.a.setRequestProperty("Content-length", i);
      paramContext = this.a.getOutputStream();
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      i = this.a.getResponseCode();
      if (i == 200)
      {
        this.b = true;
        return 0;
      }
    }
    catch (IllegalAccessError paramContext)
    {
      paramContext.printStackTrace();
      return -2060;
      if (i == -1) {
        return -2000;
      }
      return -2000 - i;
    }
    catch (IllegalStateException paramContext)
    {
      paramContext.printStackTrace();
      return -2061;
    }
    catch (ProtocolException paramContext)
    {
      paramContext.printStackTrace();
      return -2051;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return -2056;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -2000;
  }
  
  public final int a(AtomicReference<byte[]> paramAtomicReference)
  {
    int j;
    if ((this.a == null) || (!this.b))
    {
      j = -4000;
      return j;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.a.getInputStream();
        localByteArrayOutputStream = new ByteArrayOutputStream();
        i = ((InputStream)localObject1).read();
        if (i != -1) {
          continue;
        }
        localObject1 = localByteArrayOutputStream.toByteArray();
        i = 0;
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        ByteArrayOutputStream localByteArrayOutputStream;
        localIOException.printStackTrace();
        i = -4056;
        Object localObject2 = null;
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        int i = -4000;
        Object localObject3 = null;
        continue;
      }
      paramAtomicReference.set(localObject1);
      j = i;
      if (this.a == null) {
        break;
      }
      this.a.disconnect();
      this.a = null;
      return i;
      localByteArrayOutputStream.write(i);
    }
  }
  
  public static enum a
  {
    static
    {
      a locala = a;
      locala = b;
      locala = c;
      locala = d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.aa
 * JD-Core Version:    0.7.0.1
 */