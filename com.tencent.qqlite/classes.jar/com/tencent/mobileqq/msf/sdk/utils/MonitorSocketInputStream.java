package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.net.b.c;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.sdk.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

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
    int j = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      paramInt2 = NetConnInfoCenterImpl.getSystemNetworkType();
      paramInt1 = paramInt2;
      if (paramInt2 != 0) {
        break label1147;
      }
      paramInt2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo().getType();
      if (paramInt2 == 1)
      {
        paramInt1 = i;
      }
      else
      {
        paramInt1 = paramInt2;
        if (MonitorSocketImplFactory.isNetworkTypeMobile(paramInt2) == true) {
          paramInt1 = 1;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      label1147:
      do
      {
        for (;;)
        {
          a locala;
          QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
          break;
          if ((this.monitorSocketImpl.g != null) && (!this.monitorSocketImpl.g.equals(b.h)))
          {
            paramArrayOfByte = (a)this.monitorSocketImpl.i.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
            if (paramArrayOfByte == null) {
              locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, j, paramInt1);
            }
            for (locala.h = this.monitorSocketImpl.g;; locala.h = this.monitorSocketImpl.g)
            {
              locala.i = MonitorSocketStat.STATUS;
              paramArrayOfByte = locala;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + j + "|" + paramInt1 + "|" + locala.h + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = locala;
              break;
              locala = paramArrayOfByte.a(j);
            }
          }
          if (g.n.contains(toString()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + j + "|" + paramInt1 + "|MSF Signal" + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = null;
            }
          }
          else
          {
            if (c.f.contains(toString()))
            {
              locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, j, paramInt1);
              locala.h = "QualityTest";
              locala.i = MonitorSocketStat.STATUS;
              paramArrayOfByte = locala;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + j + "|" + paramInt1 + "|" + "QualityTest.PushList" + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = locala;
              continue;
            }
            if (BaseApplication.exclusiveStreamList.contains(toString()))
            {
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + j + "|" + paramInt1 + "|BigData" + "|" + MonitorSocketStat.STATUS);
                paramArrayOfByte = null;
              }
            }
            else
            {
              locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, j, paramInt1);
              locala.i = MonitorSocketStat.STATUS;
              paramInt2 = this.monitorSocketImpl.d.indexOf("tencent.");
              if (paramInt2 > -1) {
                paramInt2 += 8;
              }
              for (locala.h = this.monitorSocketImpl.d.substring(paramInt2, this.monitorSocketImpl.d.indexOf(".", paramInt2));; locala.h = this.monitorSocketImpl.d.substring(0, this.monitorSocketImpl.d.indexOf("_")))
              {
                paramArrayOfByte = locala;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|read|" + j + "|" + paramInt1 + "|" + locala.h + "|" + MonitorSocketStat.STATUS);
                paramArrayOfByte = locala;
                break;
              }
            }
          }
          paramArrayOfByte = null;
        }
      } while (j != -1);
      return j;
    }
    if ((this.monitorSocketImpl.g != null) && (this.monitorSocketImpl.g.equals(b.h)))
    {
      locala = (a)this.monitorSocketImpl.i.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
      if (locala == null)
      {
        locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, j, paramInt1);
        locala.i = MonitorSocketStat.STATUS;
        locala.h = b.h;
        this.monitorSocketImpl.i.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), locala);
      }
      for (;;)
      {
        paramArrayOfByte = locala;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|read|" + j + "|" + paramInt1 + "|" + locala.h + "|" + MonitorSocketStat.STATUS);
          paramArrayOfByte = locala;
        }
        if ((paramArrayOfByte == null) || (paramArrayOfByte.h.equals(b.h))) {
          break;
        }
        MonitorSocketStat.dataFlow.add(paramArrayOfByte);
        this.monitorSocketImpl.i.clear();
        break;
        this.monitorSocketImpl.i.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), locala.a(j));
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketInputStream
 * JD-Core Version:    0.7.0.1
 */