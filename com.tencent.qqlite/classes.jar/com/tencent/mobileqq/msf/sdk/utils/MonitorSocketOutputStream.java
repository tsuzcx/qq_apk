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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

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
    int j = 2;
    this.mOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    for (;;)
    {
      int i;
      Object localObject1;
      Object localObject2;
      try
      {
        int k = NetConnInfoCenterImpl.getSystemNetworkType();
        i = k;
        if (k != 0) {
          break label1669;
        }
        k = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo().getType();
        if (k == 1)
        {
          i = j;
          localObject1 = new byte[4];
          System.arraycopy(paramArrayOfByte, 0, localObject1, 0, localObject1.length);
          if (new String((byte[])localObject1).equals("POST"))
          {
            localObject2 = getRefer(paramArrayOfByte, 5);
            this.monitorSocketImpl.g = getMType(paramArrayOfByte, paramInt1, paramInt2);
            localObject1 = "http://" + this.monitorSocketImpl.a + ":" + this.monitorSocketImpl.b + (String)localObject2;
            paramArrayOfByte = (byte[])localObject2;
            if ((this.monitorSocketImpl.g == null) || (!this.monitorSocketImpl.g.equals(b.h))) {
              break label889;
            }
            localObject2 = (a)this.monitorSocketImpl.j.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
            if (localObject2 != null) {
              break label847;
            }
            localObject2 = new a(this.monitorSocketImpl.a, paramArrayOfByte, this.monitorSocketImpl.b, 0, paramInt2, i);
            ((a)localObject2).i = MonitorSocketStat.STATUS;
            if ((!this.monitorSocketImpl.d.contains("beacon")) && (!this.monitorSocketImpl.d.contains("feedback"))) {
              continue;
            }
            this.monitorSocketImpl.g = "beacon";
            ((a)localObject2).h = this.monitorSocketImpl.g;
            paramArrayOfByte = (byte[])localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + (String)localObject1 + "|write|" + paramInt2 + "|" + i + "|" + ((a)localObject2).h + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = (byte[])localObject2;
            }
            if ((paramArrayOfByte == null) || (paramArrayOfByte.h.equals(b.h))) {
              break label1672;
            }
            MonitorSocketStat.dataFlow.add(paramArrayOfByte);
            this.monitorSocketImpl.j.clear();
          }
        }
        else
        {
          i = k;
          if (MonitorSocketImplFactory.isNetworkTypeMobile(k) != true) {
            break label1669;
          }
          i = 1;
          continue;
        }
        if (new String((byte[])localObject1).equals("GET "))
        {
          localObject1 = getRefer(paramArrayOfByte, 4);
          this.monitorSocketImpl.g = getMType(paramArrayOfByte, paramInt1, paramInt2);
          localObject2 = "http://" + this.monitorSocketImpl.a + ":" + this.monitorSocketImpl.b + (String)localObject1;
          paramArrayOfByte = (byte[])localObject1;
          localObject1 = localObject2;
          continue;
        }
        if ((this.monitorSocketImpl.g == null) || (!this.monitorSocketImpl.g.equals(b.h))) {
          break label1673;
        }
        this.monitorSocketImpl.g = getMType(paramArrayOfByte, paramInt1, paramInt2);
        break label1673;
        if (this.monitorSocketImpl.d.contains("map"))
        {
          this.monitorSocketImpl.g = "Map";
          ((a)localObject2).h = this.monitorSocketImpl.g;
          continue;
        }
        if (this.monitorSocketImpl.d.toLowerCase().contains("tmassistant")) {
          break label683;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
        return;
      }
      if (this.monitorSocketImpl.d.contains("apkupdate"))
      {
        label683:
        this.monitorSocketImpl.g = "yingyongbao";
        ((a)localObject2).h = this.monitorSocketImpl.g;
      }
      else if (this.monitorSocketImpl.d.contains("smtt"))
      {
        this.monitorSocketImpl.g = "Web";
        ((a)localObject2).h = this.monitorSocketImpl.g;
      }
      else if ((this.monitorSocketImpl.d.contains("biz")) || (this.monitorSocketImpl.d.contains("troop")))
      {
        this.monitorSocketImpl.g = "AppDepart";
        ((a)localObject2).h = this.monitorSocketImpl.g;
      }
      else
      {
        ((a)localObject2).h = this.monitorSocketImpl.g;
        this.monitorSocketImpl.j.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), localObject2);
        continue;
        label847:
        ((a)localObject2).i = MonitorSocketStat.STATUS;
        this.monitorSocketImpl.j.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), ((a)localObject2).a(paramInt2));
        continue;
        label889:
        if ((this.monitorSocketImpl.g != null) && (!this.monitorSocketImpl.g.equals(b.h)))
        {
          localObject2 = (a)this.monitorSocketImpl.j.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
          if (localObject2 == null) {
            localObject2 = new a(this.monitorSocketImpl.a, paramArrayOfByte, this.monitorSocketImpl.b, 0, paramInt2, i);
          }
          for (((a)localObject2).h = this.monitorSocketImpl.g;; ((a)localObject2).h = this.monitorSocketImpl.g)
          {
            ((a)localObject2).i = MonitorSocketStat.STATUS;
            paramArrayOfByte = (byte[])localObject2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + (String)localObject1 + "|write|" + paramInt2 + "|" + i + "|" + ((a)localObject2).h + "|" + MonitorSocketStat.STATUS);
            paramArrayOfByte = (byte[])localObject2;
            break;
            localObject2 = ((a)localObject2).a(paramInt2);
          }
        }
        if (g.n.contains(toString()))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|MSF Signal" + "|" + MonitorSocketStat.STATUS);
            paramArrayOfByte = null;
          }
        }
        else
        {
          if (c.g.contains(toString()))
          {
            localObject1 = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 0, paramInt2, i);
            ((a)localObject1).h = "QualityTest";
            ((a)localObject1).i = MonitorSocketStat.STATUS;
            paramArrayOfByte = (byte[])localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|" + "QualityTest.PushList" + "|" + MonitorSocketStat.STATUS);
            paramArrayOfByte = (byte[])localObject1;
            continue;
          }
          if (BaseApplication.exclusiveStreamList.contains(toString()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|BigData" + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = null;
            }
          }
          else
          {
            localObject1 = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 0, paramInt2, i);
            ((a)localObject1).i = MonitorSocketStat.STATUS;
            paramInt1 = this.monitorSocketImpl.d.indexOf("tencent.");
            if (paramInt1 > -1) {
              paramInt1 += 8;
            }
            for (((a)localObject1).h = this.monitorSocketImpl.d.substring(paramInt1, this.monitorSocketImpl.d.indexOf(".", paramInt1));; ((a)localObject1).h = this.monitorSocketImpl.d.substring(0, this.monitorSocketImpl.d.indexOf("_")))
            {
              paramArrayOfByte = (byte[])localObject1;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|write|" + paramInt2 + "|" + i + "|" + ((a)localObject1).h + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = (byte[])localObject1;
              break;
            }
          }
        }
        paramArrayOfByte = null;
        continue;
        label1669:
        continue;
        label1672:
        return;
        label1673:
        localObject1 = "";
        paramArrayOfByte = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketOutputStream
 * JD-Core Version:    0.7.0.1
 */