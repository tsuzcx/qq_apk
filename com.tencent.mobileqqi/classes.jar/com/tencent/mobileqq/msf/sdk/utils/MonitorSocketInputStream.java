package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.b.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class MonitorSocketInputStream
  extends InputStream
{
  private Context context;
  private InputStream mInputStream;
  private b monitorSocketImpl;
  
  public MonitorSocketInputStream(InputStream paramInputStream, b paramb, Context paramContext)
  {
    this.mInputStream = paramInputStream;
    this.monitorSocketImpl = paramb;
    this.context = paramContext;
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
    int j = NetConnInfoCenterImpl.getSystemNetworkType();
    paramInt2 = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (j == 0)
    {
      try
      {
        paramInt1 = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        if (paramInt1 != 1) {
          break label1330;
        }
        paramInt1 = i;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
        return paramInt2;
      }
      if (c.a(paramInt1) == true)
      {
        paramInt1 = 1;
        break label1323;
      }
    }
    label1323:
    label1330:
    label1337:
    for (;;)
    {
      if ((this.monitorSocketImpl.g != null) && (this.monitorSocketImpl.g.equals(b.h)))
      {
        paramArrayOfByte = (a)this.monitorSocketImpl.i.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
          paramArrayOfByte.h = b.h;
          this.monitorSocketImpl.i.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), paramArrayOfByte);
          if (!QLog.isColorLevel()) {
            break label344;
          }
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
        }
      }
      for (;;)
      {
        if ((paramArrayOfByte == null) || (paramArrayOfByte.h.equals(b.h))) {
          return paramInt2;
        }
        MonitorSocketStat.dataFlow.add(paramArrayOfByte);
        this.monitorSocketImpl.i.clear();
        return paramInt2;
        this.monitorSocketImpl.i.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), paramArrayOfByte.a(paramInt2));
        break;
        label344:
        QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
        continue;
        if ((this.monitorSocketImpl.g != null) && (!this.monitorSocketImpl.g.equals(b.h)))
        {
          paramArrayOfByte = (a)this.monitorSocketImpl.i.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
          if (paramArrayOfByte == null) {
            paramArrayOfByte = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
          }
          for (paramArrayOfByte.h = this.monitorSocketImpl.g;; paramArrayOfByte.h = this.monitorSocketImpl.g)
          {
            if (!QLog.isColorLevel()) {
              break label594;
            }
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
            break;
            paramArrayOfByte = paramArrayOfByte.a(paramInt2);
          }
          label594:
          QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
        }
        else if (h.m.contains(toString()))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|MSF Signal");
            paramArrayOfByte = null;
          }
          else
          {
            QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|MSF Signal");
            paramArrayOfByte = null;
          }
        }
        else if (com.tencent.mobileqq.msf.core.b.a.c.f.contains(toString()))
        {
          paramArrayOfByte = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
          paramArrayOfByte.h = "QualityTest";
          if (QLog.isColorLevel()) {
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
          } else {
            QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
          }
        }
        else if (BaseApplication.exclusiveStreamList.contains(toString()))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|BigData");
            paramArrayOfByte = null;
          }
          else
          {
            QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|BigData");
            paramArrayOfByte = null;
          }
        }
        else
        {
          paramArrayOfByte = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
          paramArrayOfByte.h = this.monitorSocketImpl.d.substring(0, this.monitorSocketImpl.d.indexOf("_"));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
          } else {
            QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + paramArrayOfByte.h);
          }
        }
      }
      for (paramInt1 = j;; paramInt1 = 1)
      {
        if (paramInt2 != -1) {
          break label1337;
        }
        return paramInt2;
        if (paramInt1 != 0) {
          break;
        }
      }
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketInputStream
 * JD-Core Version:    0.7.0.1
 */