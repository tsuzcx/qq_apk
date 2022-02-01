package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public final class cr
  implements ck
{
  public cr(String paramString) {}
  
  public ck.a a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    transient localtransient = new transient();
    Object localObject4 = this.a;
    Object localObject1 = cm.a();
    Object localObject2;
    try
    {
      Object localObject5 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject5 != null) && ((((NetworkInfo)localObject5).getState() == NetworkInfo.State.CONNECTING) || (((NetworkInfo)localObject5).getState() == NetworkInfo.State.CONNECTED)))
      {
        if (((NetworkInfo)localObject5).getType() == 1)
        {
          localObject1 = transient.do.Hj;
        }
        else if (((NetworkInfo)localObject5).getType() == 0)
        {
          localObject5 = transient.a((Context)localObject1);
          if ((localObject5 != null) && (((String)localObject5).length() > 0) && (transient.b((Context)localObject1) > 0)) {
            localObject1 = transient.do.Ij;
          } else {
            localObject1 = transient.do.Jj;
          }
        }
        else
        {
          localObject1 = transient.do.Jj;
        }
      }
      else {
        localObject1 = transient.do.Kj;
      }
    }
    catch (Throwable localThrowable1)
    {
      localObject2 = localThrowable1.getMessage();
      if ((localObject2 != null) && (((String)localObject2).contains("ACCESS_NETWORK_STATE"))) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        localObject2 = transient.do.Hj;
      } else {
        localObject2 = transient.do.Kj;
      }
    }
    if (localObject2 == transient.do.Kj) {
      paramInt1 = -1052;
    } else {
      try
      {
        localObject4 = new URL((String)localObject4);
        if (localObject2 == transient.do.Ij) {
          localtransient.a = ((HttpURLConnection)((URL)localObject4).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(transient.a(cm.a()), transient.b(cm.a())))));
        } else {
          localtransient.a = ((HttpURLConnection)((URL)localObject4).openConnection());
        }
        localtransient.a.setReadTimeout(15000);
        localtransient.a.setConnectTimeout(15000);
        paramInt1 = 0;
      }
      catch (Throwable localThrowable2)
      {
        paramInt1 = -1000;
        localThrowable2.printStackTrace();
      }
      catch (IOException localIOException)
      {
        paramInt1 = -1056;
        localIOException.printStackTrace();
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        paramInt1 = -1059;
        localUnsupportedOperationException.printStackTrace();
      }
      catch (SecurityException localSecurityException)
      {
        paramInt1 = -1058;
        localSecurityException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        paramInt1 = -1057;
        localIllegalArgumentException.printStackTrace();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        paramInt1 = -1053;
        localMalformedURLException.printStackTrace();
      }
    }
    if (paramInt1 == 0)
    {
      localtransient.b = false;
      try
      {
        paramInt1 = paramArrayOfByte.length;
        localtransient.a.setDoOutput(true);
        localtransient.a.setDoInput(true);
        localtransient.a.setUseCaches(false);
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestMethod("POST");
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestProperty("Pragma", "no-cache");
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestProperty("Cache-Control", "no-cache");
        localtransient.a.setInstanceFollowRedirects(false);
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestProperty("User-Agent", "QQPimSecure");
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestProperty("Accept", "*/*");
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestProperty("Accept-Charset", "utf-8");
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestProperty("Content-Type", "application/octet-stream");
        localObject3 = localtransient.a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(paramInt1);
        ((HttpURLConnection)localObject3).setRequestProperty("Content-length", ((StringBuilder)localObject4).toString());
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt1 = -2000;
      }
      catch (IOException paramArrayOfByte)
      {
        paramInt1 = -2056;
        paramArrayOfByte.printStackTrace();
      }
      catch (ProtocolException paramArrayOfByte)
      {
        paramInt1 = -2051;
        paramArrayOfByte.printStackTrace();
      }
      catch (IllegalStateException paramArrayOfByte)
      {
        paramInt1 = -2061;
        paramArrayOfByte.printStackTrace();
      }
      catch (IllegalAccessError paramArrayOfByte)
      {
        label629:
        paramInt1 = -2060;
        paramArrayOfByte.printStackTrace();
      }
    }
    try
    {
      if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT > 13))
      {
        localObject3 = localtransient.a;
        ((HttpURLConnection)localObject3).setRequestProperty("Connection", "close");
      }
    }
    catch (Exception localException)
    {
      break label629;
    }
    Object localObject3 = localtransient.a.getOutputStream();
    ((OutputStream)localObject3).write(paramArrayOfByte);
    ((OutputStream)localObject3).flush();
    ((OutputStream)localObject3).close();
    paramInt1 = localtransient.a.getResponseCode();
    if (paramInt1 == 200)
    {
      localtransient.b = true;
      paramInt1 = 0;
    }
    else if (paramInt1 == -1)
    {
      paramInt1 = -2000;
    }
    else
    {
      paramInt1 = -2000 - paramInt1;
    }
    if (paramInt1 != 0) {
      return ck.a.a(paramInt1, new byte[0]);
    }
    localObject3 = new AtomicReference();
    paramArrayOfByte = localtransient.a;
    paramInt1 = -4000;
    paramInt2 = paramInt1;
    if (paramArrayOfByte != null) {
      if (!localtransient.b)
      {
        paramInt2 = paramInt1;
      }
      else
      {
        try
        {
          paramArrayOfByte = paramArrayOfByte.getInputStream();
          localObject4 = new ByteArrayOutputStream();
          for (;;)
          {
            paramInt2 = paramArrayOfByte.read();
            if (paramInt2 == -1) {
              break;
            }
            ((ByteArrayOutputStream)localObject4).write(paramInt2);
          }
          paramArrayOfByte = ((ByteArrayOutputStream)localObject4).toByteArray();
          paramInt1 = 0;
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
          paramInt1 = -4056;
        }
        ((AtomicReference)localObject3).set(paramArrayOfByte);
        paramArrayOfByte = localtransient.a;
        paramInt2 = paramInt1;
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.disconnect();
          localtransient.a = null;
          paramInt2 = paramInt1;
        }
      }
    }
    if (paramInt2 != 0) {
      return ck.a.a(paramInt2, new byte[0]);
    }
    return ck.a.a(paramInt2, (byte[])((AtomicReference)localObject3).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cr
 * JD-Core Version:    0.7.0.1
 */