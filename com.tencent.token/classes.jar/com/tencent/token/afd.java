package com.tencent.token;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import com.tencent.turingfd.sdk.base.transient;
import com.tencent.turingfd.sdk.base.transient.do;
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

public final class afd
  implements aew
{
  public afd(String paramString) {}
  
  public final aew.a a(byte[] paramArrayOfByte)
  {
    transient localtransient = new transient();
    Object localObject4 = this.a;
    Object localObject1 = aey.a();
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
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject2 = transient.do.Hj;
      } else {
        localObject2 = transient.do.Kj;
      }
    }
    if (localObject2 == transient.do.Kj) {
      i = -1052;
    } else {
      try
      {
        localObject4 = new URL((String)localObject4);
        if (localObject2 == transient.do.Ij) {
          localtransient.a = ((HttpURLConnection)((URL)localObject4).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(transient.a(aey.a()), transient.b(aey.a())))));
        } else {
          localtransient.a = ((HttpURLConnection)((URL)localObject4).openConnection());
        }
        localtransient.a.setReadTimeout(15000);
        localtransient.a.setConnectTimeout(15000);
        i = 0;
      }
      catch (Throwable localThrowable2)
      {
        i = -1000;
        localThrowable2.printStackTrace();
      }
      catch (IOException localIOException)
      {
        i = -1056;
        localIOException.printStackTrace();
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        i = -1059;
        localUnsupportedOperationException.printStackTrace();
      }
      catch (SecurityException localSecurityException)
      {
        i = -1058;
        localSecurityException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i = -1057;
        localIllegalArgumentException.printStackTrace();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        i = -1053;
        localMalformedURLException.printStackTrace();
      }
    }
    int j = i;
    if (i == 0)
    {
      localtransient.b = false;
      try
      {
        i = paramArrayOfByte.length;
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
        ((StringBuilder)localObject4).append(i);
        ((HttpURLConnection)localObject3).setRequestProperty("Content-length", ((StringBuilder)localObject4).toString());
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        j = -2000;
      }
      catch (IOException paramArrayOfByte)
      {
        j = -2056;
        paramArrayOfByte.printStackTrace();
      }
      catch (ProtocolException paramArrayOfByte)
      {
        j = -2051;
        paramArrayOfByte.printStackTrace();
      }
      catch (IllegalStateException paramArrayOfByte)
      {
        j = -2061;
        paramArrayOfByte.printStackTrace();
      }
      catch (IllegalAccessError paramArrayOfByte)
      {
        label625:
        j = -2060;
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
      break label625;
    }
    Object localObject3 = localtransient.a.getOutputStream();
    ((OutputStream)localObject3).write(paramArrayOfByte);
    ((OutputStream)localObject3).flush();
    ((OutputStream)localObject3).close();
    int i = localtransient.a.getResponseCode();
    if (i == 200)
    {
      localtransient.b = true;
      j = 0;
    }
    else if (i == -1)
    {
      j = -2000;
    }
    else
    {
      j = -2000 - i;
    }
    if (j != 0) {
      return aew.a.a(new byte[0]);
    }
    localObject3 = new AtomicReference();
    paramArrayOfByte = localtransient.a;
    i = -4000;
    j = i;
    if (paramArrayOfByte != null)
    {
      j = i;
      if (localtransient.b)
      {
        try
        {
          paramArrayOfByte = paramArrayOfByte.getInputStream();
          localObject4 = new ByteArrayOutputStream();
          for (;;)
          {
            j = paramArrayOfByte.read();
            if (j == -1) {
              break;
            }
            ((ByteArrayOutputStream)localObject4).write(j);
          }
          paramArrayOfByte = ((ByteArrayOutputStream)localObject4).toByteArray();
          i = 0;
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
          i = -4056;
        }
        ((AtomicReference)localObject3).set(paramArrayOfByte);
        paramArrayOfByte = localtransient.a;
        j = i;
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.disconnect();
          localtransient.a = null;
          j = i;
        }
      }
    }
    if (j != 0) {
      return aew.a.a(new byte[0]);
    }
    return aew.a.a((byte[])((AtomicReference)localObject3).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afd
 * JD-Core Version:    0.7.0.1
 */