package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.c.k;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MonitorSocketInputStream
  extends InputStream
{
  private Context context;
  private boolean isFirstReadBuffer = true;
  private InputStream mInputStream;
  private c monitorSocketImpl;
  
  public MonitorSocketInputStream(InputStream paramInputStream, c paramc, Context paramContext)
  {
    this.mInputStream = paramInputStream;
    this.monitorSocketImpl = paramc;
    this.context = paramContext;
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void getHttpResponseInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = 0;
    int i = paramInt1;
    int k;
    for (int n = paramInt1; i < paramInt1 + paramInt2; n = k)
    {
      int j = m;
      k = n;
      if (paramArrayOfByte[i] == 13)
      {
        j = m;
        k = n;
        if (i + 1 < paramInt1 + paramInt2)
        {
          j = m;
          k = n;
          if (paramArrayOfByte[(i + 1)] == 10)
          {
            Object localObject;
            try
            {
              localObject = new String(paramArrayOfByte, n, i - n);
              n = i + 2;
              m += 1;
              if (m == 1)
              {
                localObject = ((String)localObject).split(" ");
                j = m;
                k = n;
                if (localObject.length < 2) {
                  break label815;
                }
                this.monitorSocketImpl.g.setResponseCode(localObject[1]);
                j = m;
                k = n;
                break label815;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                break label481;
              }
              if (n + 16 < paramInt1 + paramInt2)
              {
                localObject = bytesToHex(paramArrayOfByte, n, 16);
                if (((String)localObject).toUpperCase().startsWith("504B0304")) {
                  this.monitorSocketImpl.g.setFileType(1);
                }
                this.monitorSocketImpl.g.setResponseBodyHex((String)localObject);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "Read Head=", localObject, " String=", new String(paramArrayOfByte, n, 16) });
                }
              }
              while ((this.monitorSocketImpl.g.getUrl() != null) && (this.monitorSocketImpl.g.getUrl().contains(".apk")) && ((this.monitorSocketImpl.g.getFileType() != 1) || (this.monitorSocketImpl.g.getFileType() != 2)))
              {
                this.monitorSocketImpl.g.responseHeaderGuessInfo.add(this.monitorSocketImpl.g.getUrl());
                this.monitorSocketImpl.g.setFileType(2);
                return;
                localObject = bytesToHex(paramArrayOfByte, n, paramInt1 + paramInt2 - n);
                if (((String)localObject).toUpperCase().startsWith("504B0304")) {
                  this.monitorSocketImpl.g.setFileType(1);
                }
                this.monitorSocketImpl.g.setResponseBodyHex((String)localObject);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "Read Head=", localObject, " String=", new String(paramArrayOfByte, n, paramInt1 + paramInt2 - n) });
                }
              }
              QLog.d("MSF.D.MonitorSocket", 2, "getHttpResponseInfo ERROR=", paramArrayOfByte);
            }
            catch (Exception paramArrayOfByte)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
            }
            return;
            label481:
            int i1 = ((String)localObject).indexOf(":");
            j = m;
            k = n;
            if (i1 > 0) {
              try
              {
                String str1 = ((String)localObject).substring(0, i1);
                str2 = ((String)localObject).substring(i1 + 2);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "line", Integer.valueOf(m), "{", str1, str2, "}" });
                }
                if ("Content-Type".equals(str1))
                {
                  this.monitorSocketImpl.g.setMimeType(str2);
                  j = m;
                  k = n;
                  if (!"application/vnd.android.package-archive".equals(str2)) {
                    break label815;
                  }
                  this.monitorSocketImpl.g.setFileType(1);
                  j = m;
                  k = n;
                }
              }
              catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
              {
                String str2;
                j = m;
                k = n;
                if (QLog.isColorLevel())
                {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "header parse error, index=", Integer.valueOf(i1), " line=", localObject, " error info=", localStringIndexOutOfBoundsException });
                  j = m;
                  k = n;
                  break label815;
                  if ("Content-Length".equals(localStringIndexOutOfBoundsException))
                  {
                    this.monitorSocketImpl.g.setResponseLength(str2);
                    j = m;
                    k = n;
                  }
                  else
                  {
                    j = m;
                    k = n;
                    if (str2.indexOf(".apk") > 0)
                    {
                      j = m;
                      k = n;
                      if (this.monitorSocketImpl.g.getFileType() != 1)
                      {
                        this.monitorSocketImpl.g.responseHeaderGuessInfo.add(localObject);
                        this.monitorSocketImpl.g.setFileType(2);
                        k = n;
                        j = m;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label815:
      i += 1;
      m = j;
    }
  }
  
  public void close()
    throws IOException
  {
    this.mInputStream.close();
  }
  
  public int hashCode()
  {
    return this.mInputStream.hashCode();
  }
  
  public int read()
    throws IOException
  {
    return this.mInputStream.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 2;
    int j;
    try
    {
      j = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (this.isFirstReadBuffer)
      {
        this.isFirstReadBuffer = false;
        if ((!BaseApplication.httpMonitorBan) && (this.monitorSocketImpl.g != null)) {
          getHttpResponseInfo(paramArrayOfByte, paramInt1, paramInt2);
        }
      }
      if (j == -1) {
        return j;
      }
    }
    catch (SocketException paramArrayOfByte)
    {
      QLog.e("MSF.D.MonitorSocket", 1, "SocketException!", paramArrayOfByte);
      throw paramArrayOfByte;
    }
    catch (SocketTimeoutException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    if (MonitorSocketImplFactory.isServerSocket(toString())) {
      return j;
    }
    try
    {
      if ((this.monitorSocketImpl.d == null) || (!this.monitorSocketImpl.d.contains(":MSF"))) {
        break label217;
      }
      paramInt1 = NetConnInfoCenter.getSystemNetworkType();
      if (paramInt1 != 0) {
        break label980;
      }
      paramArrayOfByte = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramArrayOfByte == null) {
        break label980;
      }
      paramInt1 = paramArrayOfByte.getType();
      if (paramInt1 != 1) {
        break label224;
      }
      paramInt1 = i;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
        break;
        paramArrayOfByte = this.monitorSocketImpl;
        c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb.a(j));
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        label152:
        label217:
        label224:
        QLog.d("MSF.D.MonitorSocket", 1, "read OOM.");
        break;
        paramArrayOfByte = this.monitorSocketImpl;
        b localb = (b)c.n.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (localb == null)
        {
          localb = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.m, j, paramInt1);
          localb.i = BaseApplication.monitor.getSTATUS();
          localb.h = this.monitorSocketImpl.j;
          localb.j = this.monitorSocketImpl.e.hashCode();
          paramArrayOfByte = this.monitorSocketImpl;
          c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb);
        }
        for (;;)
        {
          paramArrayOfByte = localb;
          if (localb.l != null) {
            break;
          }
          this.monitorSocketImpl.a(localb.j, c.m);
          paramArrayOfByte = localb;
          break;
          paramArrayOfByte = this.monitorSocketImpl;
          c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb.a(j));
        }
        if (this.monitorSocketImpl.j != null)
        {
          paramArrayOfByte = this.monitorSocketImpl;
          paramArrayOfByte = (b)c.n.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
          if (paramArrayOfByte == null)
          {
            localb = new b(this.monitorSocketImpl.b, this.monitorSocketImpl.a, this.monitorSocketImpl.c, c.m, j, paramInt1);
            localb.h = this.monitorSocketImpl.j;
            localb.j = this.monitorSocketImpl.e.hashCode();
            paramArrayOfByte = this.monitorSocketImpl;
            c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb);
          }
          for (;;)
          {
            localb.i = BaseApplication.monitor.getSTATUS();
            paramArrayOfByte = localb;
            if (localb.l != null) {
              break;
            }
            this.monitorSocketImpl.a(localb.j, c.m);
            paramArrayOfByte = localb;
            break;
            localb = paramArrayOfByte.a(j);
            localb.h = this.monitorSocketImpl.j;
          }
        }
        paramArrayOfByte = null;
        continue;
      }
    }
    if ((this.monitorSocketImpl.d != null) && (this.monitorSocketImpl.d.contains(":MSF")))
    {
      if (m.r.contains(toString())) {
        paramArrayOfByte = null;
      }
      for (;;)
      {
        if (paramArrayOfByte == null) {
          break label983;
        }
        paramArrayOfByte.a = this.monitorSocketImpl.d;
        paramArrayOfByte.k = System.currentTimeMillis();
        break label983;
        paramInt1 = AppNetConnInfo.getSystemNetworkType();
        break;
        if (MonitorSocketImplFactory.isNetworkTypeMobile(paramInt1) != true) {
          break label977;
        }
        paramInt1 = 1;
        break label152;
        if (!k.f.contains(toString())) {
          break label572;
        }
        paramArrayOfByte = this.monitorSocketImpl;
        localb = (b)c.n.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (localb != null) {
          break label523;
        }
        localb = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.m, j, paramInt1);
        localb.h = "QualityTest";
        localb.i = BaseApplication.monitor.getSTATUS();
        localb.j = this.monitorSocketImpl.e.hashCode();
        paramArrayOfByte = this.monitorSocketImpl;
        c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localb);
        if (localb.l == null) {
          this.monitorSocketImpl.a(localb.j, c.m);
        }
        paramArrayOfByte = localb;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.MonitorSocket", 2, "qualityTest|" + this.monitorSocketImpl.e + "|read|" + j + "|" + paramInt1 + "|" + "QualityTest.PushList" + "|" + BaseApplication.monitor.getSTATUS() + "|" + localb.toString());
          paramArrayOfByte = localb;
        }
      }
    }
    label523:
    label572:
    label977:
    label980:
    label983:
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketInputStream
 * JD-Core Version:    0.7.0.1
 */