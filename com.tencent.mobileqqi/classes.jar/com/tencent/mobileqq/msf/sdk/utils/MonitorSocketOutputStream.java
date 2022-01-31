package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.b.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class MonitorSocketOutputStream
  extends OutputStream
{
  private Context context;
  private OutputStream mOutputStream;
  private b monitorSocketImpl;
  
  public MonitorSocketOutputStream(OutputStream paramOutputStream, b paramb, Context paramContext)
  {
    this.mOutputStream = paramOutputStream;
    this.monitorSocketImpl = paramb;
    this.context = paramContext;
  }
  
  public static String getMType(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str1 = b.h;
    int i = paramInt1;
    int j = paramInt1;
    if ((i >= paramInt2 + paramInt1) || (i + 1 == paramInt2)) {}
    String str2;
    label100:
    do
    {
      return str1;
      int k = j;
      if (paramArrayOfByte[i] == 13)
      {
        k = j;
        if (paramArrayOfByte[(i + 1)] == 10)
        {
          str2 = new String(paramArrayOfByte, j, i - j);
          j = str2.indexOf("mType=");
          if (j != -1) {
            break label100;
          }
          k = i + 2;
        }
      }
      i += 1;
      j = k;
      break;
      paramInt1 = str2.indexOf("&", j + 6);
      if (paramInt1 != -1) {
        break label148;
      }
      paramInt1 = str2.indexOf(" ", j + 6);
    } while (paramInt1 == -1);
    return str2.substring(j + 6, paramInt1);
    label148:
    return str2.substring(j + 6, paramInt1);
  }
  
  public static String getRefer(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    Object localObject1;
    if (i < paramArrayOfByte.length) {
      if ((paramArrayOfByte[i] == 13) && (paramArrayOfByte[(i + 1)] == 10))
      {
        localObject1 = new String(paramArrayOfByte, paramInt, i - paramInt).trim().split(" ");
        if (localObject1.length == 2) {
          localObject1 = localObject1[0];
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        i = paramArrayOfByte.length - 1;
        for (;;)
        {
          localObject2 = localObject1;
          if (i < paramInt) {
            break;
          }
          if (paramArrayOfByte[i] == 32)
          {
            localObject1 = new String(paramArrayOfByte, paramInt, i - paramInt);
            localObject2 = ((String)localObject1).trim().split(" ");
            if (localObject2.length == 2) {
              localObject1 = localObject2[0];
            }
          }
          i -= 1;
        }
        localObject1 = "";
        continue;
        i += 1;
        break;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new String(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
      }
      paramArrayOfByte = (byte[])localObject1;
      if (((String)localObject1).length() > 42) {
        paramArrayOfByte = ((String)localObject1).substring(0, 41);
      }
      return paramArrayOfByte;
      localObject1 = null;
    }
  }
  
  public void close()
    throws IOException
  {
    this.mOutputStream.close();
  }
  
  public void flush()
    throws IOException
  {
    this.mOutputStream.flush();
  }
  
  public int hashCode()
  {
    return this.mOutputStream.hashCode();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.mOutputStream.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 2;
    this.mOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    for (;;)
    {
      int j;
      int k;
      Object localObject;
      a locala;
      try
      {
        j = NetConnInfoCenterImpl.getSystemNetworkType();
        if (j != 0) {
          break label1603;
        }
        k = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        if (k != 1) {
          break label1611;
        }
        localObject = new byte[4];
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, localObject.length);
        if (new String((byte[])localObject).equals("POST"))
        {
          localObject = getRefer(paramArrayOfByte, 5);
          this.monitorSocketImpl.g = getMType(paramArrayOfByte, paramInt1, paramInt2);
          paramArrayOfByte = "http://" + this.monitorSocketImpl.a + ":" + this.monitorSocketImpl.b + (String)localObject;
          if ((this.monitorSocketImpl.g == null) || (!this.monitorSocketImpl.g.equals(b.h))) {
            break label662;
          }
          locala = (a)this.monitorSocketImpl.j.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
          if (locala == null)
          {
            localObject = new a(this.monitorSocketImpl.a, (String)localObject, this.monitorSocketImpl.b, 0, paramInt2, i);
            ((a)localObject).h = this.monitorSocketImpl.g;
            this.monitorSocketImpl.j.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), localObject);
            if (!QLog.isColorLevel()) {
              break label589;
            }
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + paramArrayOfByte + "|write|" + paramInt2 + "|" + i + "|" + ((a)localObject).h);
            paramArrayOfByte = (byte[])localObject;
            if ((paramArrayOfByte == null) || (paramArrayOfByte.h.equals(b.h))) {
              break label1610;
            }
            MonitorSocketStat.dataFlow.add(paramArrayOfByte);
            this.monitorSocketImpl.j.clear();
            return;
            if (c.a(k) != true) {
              break label1603;
            }
            i = 1;
          }
        }
        else
        {
          if (new String((byte[])localObject).equals("GET "))
          {
            localObject = getRefer(paramArrayOfByte, 4);
            this.monitorSocketImpl.g = getMType(paramArrayOfByte, paramInt1, paramInt2);
            paramArrayOfByte = "http://" + this.monitorSocketImpl.a + ":" + this.monitorSocketImpl.b + (String)localObject;
            continue;
          }
          if ((this.monitorSocketImpl.g == null) || (!this.monitorSocketImpl.g.equals(b.h))) {
            break label1622;
          }
          this.monitorSocketImpl.g = getMType(paramArrayOfByte, paramInt1, paramInt2);
          break label1622;
        }
        this.monitorSocketImpl.j.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), locala.a(paramInt2));
        localObject = locala;
        continue;
        QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + paramArrayOfByte + "|write|" + paramInt2 + "|" + i + "|" + ((a)localObject).h);
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
        return;
      }
      label589:
      paramArrayOfByte = (byte[])localObject;
      continue;
      label662:
      if ((this.monitorSocketImpl.g != null) && (!this.monitorSocketImpl.g.equals(b.h)))
      {
        locala = (a)this.monitorSocketImpl.j.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
        if (locala == null) {
          localObject = new a(this.monitorSocketImpl.a, (String)localObject, this.monitorSocketImpl.b, 0, paramInt2, i);
        }
        for (((a)localObject).h = this.monitorSocketImpl.g;; ((a)localObject).h = this.monitorSocketImpl.g)
        {
          if (!QLog.isColorLevel()) {
            break label866;
          }
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + paramArrayOfByte + "|write|" + paramInt2 + "|" + i + "|" + ((a)localObject).h);
          paramArrayOfByte = (byte[])localObject;
          break;
          localObject = locala.a(paramInt2);
        }
        label866:
        QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + paramArrayOfByte + "|write|" + paramInt2 + "|" + i + "|" + ((a)localObject).h);
        paramArrayOfByte = (byte[])localObject;
      }
      else if (h.m.contains(toString()))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|MSF Signal");
          paramArrayOfByte = null;
        }
        else
        {
          QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|MSF Signal");
          paramArrayOfByte = null;
        }
      }
      else if (com.tencent.mobileqq.msf.core.b.a.c.g.contains(toString()))
      {
        paramArrayOfByte = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 0, paramInt2, i);
        paramArrayOfByte.h = "QualityTest";
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|" + "QualityTest.PushList");
        } else {
          QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|" + "QualityTest.PushList");
        }
      }
      else if (BaseApplication.exclusiveStreamList.contains(toString()))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|BigData");
          paramArrayOfByte = null;
        }
        else
        {
          QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|BigData");
          paramArrayOfByte = null;
        }
      }
      else
      {
        paramArrayOfByte = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 0, paramInt2, i);
        paramArrayOfByte.h = this.monitorSocketImpl.d.substring(0, this.monitorSocketImpl.d.indexOf("_"));
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|" + paramArrayOfByte.h);
        }
        else
        {
          QLog.d("MSF.D.MonitorSocket", 1, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|" + paramArrayOfByte.h);
          continue;
          label1603:
          i = j;
          continue;
          label1610:
          return;
          label1611:
          if (k == 0)
          {
            i = 1;
            continue;
            label1622:
            paramArrayOfByte = "";
            localObject = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketOutputStream
 * JD-Core Version:    0.7.0.1
 */