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

public final class o
  implements dg
{
  public o(String paramString) {}
  
  public dh a(int paramInt, byte[] paramArrayOfByte)
  {
    int j = -4000;
    Berry localBerry = new Berry();
    Object localObject4 = this.a;
    Object localObject1 = ed.b();
    Object localObject5;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject5 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject5 == null) || ((((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTING) && (((NetworkInfo)localObject5).getState() != NetworkInfo.State.CONNECTED)))
        {
          localObject1 = Berry.do.Gi;
          if (localObject1 != Berry.do.Gi) {
            break label223;
          }
          paramInt = -1052;
          if (paramInt == 0) {
            break;
          }
          if (paramInt == 0) {
            break label824;
          }
          return dh.a(paramInt, new byte[0]);
        }
        if (((NetworkInfo)localObject5).getType() == 1)
        {
          localObject1 = Berry.do.Di;
          continue;
        }
        if (((NetworkInfo)localObject5).getType() == 0)
        {
          localObject5 = Berry.a((Context)localObject1);
          if ((localObject5 != null) && (((String)localObject5).length() > 0) && (Berry.b((Context)localObject1) > 0))
          {
            localObject1 = Berry.do.Ei;
            continue;
          }
          localObject1 = Berry.do.Fi;
          continue;
        }
        localObject1 = Berry.do.Fi;
        continue;
        if (!((String)localObject2).contains("ACCESS_NETWORK_STATE")) {
          break label999;
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject2 = localThrowable1.getMessage();
        if (localObject2 == null) {
          break label999;
        }
      }
      paramInt = 1;
      label203:
      if (paramInt != 0)
      {
        localObject2 = Berry.do.Di;
      }
      else
      {
        localObject2 = Berry.do.Gi;
        continue;
        try
        {
          label223:
          localObject4 = new URL((String)localObject4);
          if (localObject2 == Berry.do.Ei) {}
          for (localBerry.a = ((HttpURLConnection)((URL)localObject4).openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(Berry.a(ed.b()), Berry.b(ed.b())))));; localBerry.a = ((HttpURLConnection)((URL)localObject4).openConnection()))
          {
            localBerry.a.setReadTimeout(15000);
            localBerry.a.setConnectTimeout(15000);
            paramInt = 0;
            break;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          paramInt = -1053;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          paramInt = -1000;
        }
        catch (IOException localIOException1)
        {
          bu.a().b(localIOException1);
          localIOException1.printStackTrace();
          paramInt = -1056;
        }
        catch (UnsupportedOperationException localUnsupportedOperationException)
        {
          localUnsupportedOperationException.printStackTrace();
          paramInt = -1059;
        }
        catch (SecurityException localSecurityException)
        {
          localSecurityException.printStackTrace();
          paramInt = -1058;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          paramInt = -1057;
        }
      }
    }
    localBerry.b = false;
    for (;;)
    {
      label637:
      int k;
      try
      {
        for (;;)
        {
          paramInt = paramArrayOfByte.length;
          localBerry.a.setDoOutput(true);
          localBerry.a.setDoInput(true);
          localBerry.a.setUseCaches(false);
          localObject3 = localBerry.a;
          ((HttpURLConnection)localObject3).setRequestMethod("POST");
          localObject3 = localBerry.a;
          ((HttpURLConnection)localObject3).setRequestProperty("Pragma", "no-cache");
          localObject3 = localBerry.a;
          ((HttpURLConnection)localObject3).setRequestProperty("Cache-Control", "no-cache");
          localBerry.a.setInstanceFollowRedirects(false);
          localObject3 = localBerry.a;
          ((HttpURLConnection)localObject3).setRequestProperty("User-Agent", "QQPimSecure");
          localObject3 = localBerry.a;
          ((HttpURLConnection)localObject3).setRequestProperty("Accept", "*/*");
          localObject3 = localBerry.a;
          ((HttpURLConnection)localObject3).setRequestProperty("Accept-Charset", "utf-8");
          localObject3 = localBerry.a;
          ((HttpURLConnection)localObject3).setRequestProperty("Content-Type", "application/octet-stream");
          localObject3 = localBerry.a;
          localObject4 = new StringBuilder();
          ((HttpURLConnection)localObject3).setRequestProperty("Content-length", "" + paramInt);
          try
          {
            if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT > 13))
            {
              localObject3 = localBerry.a;
              ((HttpURLConnection)localObject3).setRequestProperty("Connection", "close");
            }
          }
          catch (Exception localException2)
          {
            break label637;
          }
          localObject3 = localBerry.a.getOutputStream();
          ((OutputStream)localObject3).write(paramArrayOfByte);
          ((OutputStream)localObject3).flush();
          ((OutputStream)localObject3).close();
          i = localBerry.a.getResponseCode();
          if (i == 200)
          {
            localBerry.b = true;
            paramInt = 0;
            break label1004;
            i = paramInt;
            if (k != 0)
            {
              localObject3 = bu.a();
              paramArrayOfByte = localBerry.a;
            }
          }
          else
          {
            try
            {
              paramArrayOfByte = paramArrayOfByte.getHeaderField("Location");
              ((bu)localObject3).a("3", paramArrayOfByte);
              break;
              if (i == -1)
              {
                paramInt = -2000;
                break label1004;
              }
              paramInt = -2000 - i;
              break label1004;
              k = 0;
            }
            catch (Exception paramArrayOfByte)
            {
              for (;;)
              {
                paramArrayOfByte = "";
              }
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2000;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2056;
      }
      catch (ProtocolException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2051;
      }
      catch (IllegalStateException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = -2061;
      }
      catch (IllegalAccessError paramArrayOfByte)
      {
        i = -2060;
        paramArrayOfByte.printStackTrace();
        paramInt = i;
      }
      break;
      label824:
      localObject4 = new AtomicReference();
      Object localObject3 = localBerry.a;
      int i = j;
      if (localObject3 != null)
      {
        if (localBerry.b) {
          break label871;
        }
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          return dh.a(i, new byte[0]);
          label871:
          paramArrayOfByte = null;
          try
          {
            localObject3 = ((HttpURLConnection)localObject3).getInputStream();
            localObject5 = new ByteArrayOutputStream();
            for (;;)
            {
              paramInt = ((InputStream)localObject3).read();
              if (paramInt == -1) {
                break;
              }
              ((ByteArrayOutputStream)localObject5).write(paramInt);
            }
          }
          catch (IOException localIOException2)
          {
            paramInt = -4056;
            localIOException2.printStackTrace();
            for (;;)
            {
              ((AtomicReference)localObject4).set(paramArrayOfByte);
              paramArrayOfByte = localBerry.a;
              i = paramInt;
              if (paramArrayOfByte == null) {
                break;
              }
              paramArrayOfByte.disconnect();
              localBerry.a = null;
              i = paramInt;
              break;
              byte[] arrayOfByte = ((ByteArrayOutputStream)localObject5).toByteArray();
              paramArrayOfByte = arrayOfByte;
              paramInt = 0;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
              paramInt = j;
            }
          }
        }
      }
      return dh.a(i, (byte[])((AtomicReference)localObject4).get());
      label999:
      paramInt = 0;
      break label203;
      label1004:
      if ((i >= 301) && (i <= 305)) {
        k = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.o
 * JD-Core Version:    0.7.0.1
 */