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
    paramInt2 = -4000;
    transient localtransient = new transient();
    Object localObject4 = this.a;
    Object localObject1 = cm.a();
    Object localObject5;
    label83:
    label87:
    Object localObject2;
    try
    {
      localObject5 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject5 == null) || ((((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTING) && (((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTED))) {
        localObject1 = transient.do.Kj;
      }
      while (localObject1 == transient.do.Kj)
      {
        paramInt1 = -1052;
        if (paramInt1 == 0) {
          break label406;
        }
        if (paramInt1 == 0) {
          break label762;
        }
        return ck.a.a(paramInt1, new byte[0]);
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
          continue;
          if (!((String)localObject2).contains("ACCESS_NETWORK_STATE")) {
            break label941;
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      localObject2 = localThrowable1.getMessage();
      if (localObject2 == null) {}
    }
    label406:
    label811:
    label941:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      for (;;)
      {
        for (;;)
        {
          if (paramInt1 != 0)
          {
            localObject2 = transient.do.Hj;
            break;
          }
          localObject2 = transient.do.Kj;
          break;
          try
          {
            localObject4 = new URL((String)localObject4);
            if (localObject2 == transient.do.Ij) {}
            for (localtransient.a = ((HttpURLConnection)((URL)localObject4).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(transient.a(cm.a()), transient.b(cm.a())))));; localtransient.a = ((HttpURLConnection)((URL)localObject4).openConnection()))
            {
              localtransient.a.setReadTimeout(15000);
              localtransient.a.setConnectTimeout(15000);
              paramInt1 = 0;
              break;
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            localMalformedURLException.printStackTrace();
            paramInt1 = -1053;
          }
          catch (Throwable localThrowable2)
          {
            localThrowable2.printStackTrace();
            paramInt1 = -1000;
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
            paramInt1 = -1056;
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            localUnsupportedOperationException.printStackTrace();
            paramInt1 = -1059;
          }
          catch (SecurityException localSecurityException)
          {
            localSecurityException.printStackTrace();
            paramInt1 = -1058;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            paramInt1 = -1057;
          }
        }
        break label83;
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
          ((HttpURLConnection)localObject3).setRequestProperty("Content-length", "" + paramInt1);
          try
          {
            if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT > 13))
            {
              localObject3 = localtransient.a;
              ((HttpURLConnection)localObject3).setRequestProperty("Connection", "close");
            }
          }
          catch (Exception localException2)
          {
            label628:
            break label628;
          }
          localObject3 = localtransient.a.getOutputStream();
          ((OutputStream)localObject3).write(paramArrayOfByte);
          ((OutputStream)localObject3).flush();
          ((OutputStream)localObject3).close();
          paramInt1 = localtransient.a.getResponseCode();
          if (paramInt1 == 200)
          {
            localtransient.b = true;
            paramInt1 = 0;
            break label87;
          }
          if (paramInt1 == -1)
          {
            paramInt1 = -2000;
            break label87;
          }
          paramInt1 = -2000 - paramInt1;
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramInt1 = -2000;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramInt1 = -2056;
        }
        catch (ProtocolException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramInt1 = -2051;
        }
        catch (IllegalStateException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramInt1 = -2061;
        }
        catch (IllegalAccessError paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramInt1 = -2060;
        }
      }
      break label87;
      label762:
      localObject4 = new AtomicReference();
      Object localObject3 = localtransient.a;
      paramInt3 = paramInt2;
      if (localObject3 != null)
      {
        if (localtransient.b) {
          break label811;
        }
        paramInt3 = paramInt2;
      }
      for (;;)
      {
        if (paramInt3 != 0)
        {
          return ck.a.a(paramInt3, new byte[0]);
          paramArrayOfByte = null;
          try
          {
            localObject3 = ((HttpURLConnection)localObject3).getInputStream();
            localObject5 = new ByteArrayOutputStream();
            for (;;)
            {
              paramInt1 = ((InputStream)localObject3).read();
              if (paramInt1 == -1) {
                break;
              }
              ((ByteArrayOutputStream)localObject5).write(paramInt1);
            }
          }
          catch (IOException localIOException2)
          {
            paramInt1 = -4056;
            localIOException2.printStackTrace();
            for (;;)
            {
              ((AtomicReference)localObject4).set(paramArrayOfByte);
              paramArrayOfByte = localtransient.a;
              paramInt3 = paramInt1;
              if (paramArrayOfByte == null) {
                break;
              }
              paramArrayOfByte.disconnect();
              localtransient.a = null;
              paramInt3 = paramInt1;
              break;
              byte[] arrayOfByte = ((ByteArrayOutputStream)localObject5).toByteArray();
              paramArrayOfByte = arrayOfByte;
              paramInt1 = 0;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
              paramInt1 = paramInt2;
            }
          }
        }
      }
      return ck.a.a(paramInt3, (byte[])((AtomicReference)localObject4).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cr
 * JD-Core Version:    0.7.0.1
 */