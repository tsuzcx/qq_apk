package com.tencent.mobileqq.msf.core.b;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.d.f;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class h
{
  public static final int a = -100;
  public static ArrayList m = new ArrayList();
  InetSocketAddress b;
  d c;
  int d;
  int e = 30000;
  public Socket f;
  OutputStream g = null;
  c h;
  a i;
  MsfSocketInputBuffer j = null;
  public String k = "";
  public int l = 0;
  AtomicLong n = new AtomicLong();
  AtomicLong o = new AtomicLong();
  long p = 0L;
  boolean q = false;
  AtomicBoolean r = new AtomicBoolean();
  AtomicBoolean s = new AtomicBoolean();
  ReentrantLock t = new ReentrantLock();
  boolean u;
  MsfCore v;
  public d w;
  
  public h(MsfCore paramMsfCore, boolean paramBoolean)
  {
    this.v = paramMsfCore;
    this.u = paramBoolean;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((this.s.get()) || (!this.r.get()) || (this.h == null)) {
      return -100;
    }
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      paramMsfCommand = this.h.a(this.c, paramString1, paramString2, paramArrayOfByte);
      this.g.write(paramMsfCommand);
      this.g.flush();
      this.n.addAndGet(paramMsfCommand.length);
      StringBuilder localStringBuilder = new StringBuilder();
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 1, "netSend appid:" + paramInt1 + " appSeq:" + paramInt2 + " ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2 + " len:" + paramArrayOfByte.length);
      }
      for (;;)
      {
        if (paramString3 != null) {
          break label281;
        }
        f.a(true, paramString1, paramMsfCommand.length, paramString2, 0, this.k, this.l);
        break;
        QLog.d("MSF.C.NetConnTag", 1, "netSend ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2.hashCode() + new StringBuilder().append(" ").append(paramArrayOfByte.length + paramInt3).toString());
      }
      label281:
      f.a(true, paramString1, paramMsfCommand.length, paramString3, 0, this.k, this.l);
    }
  }
  
  public void a(d paramd, int paramInt1, int paramInt2, c paramc, boolean paramBoolean, a parama)
  {
    if (((this.s.get()) || (!this.r.get())) && (this.s.get()))
    {
      this.s.set(false);
      a(com.tencent.qphone.base.a.f);
    }
    this.c = paramd;
    this.h = paramc;
    this.q = paramBoolean;
    Object localObject4 = t.b;
    String str = "";
    this.p = 0L;
    long l1;
    Object localObject2;
    label2087:
    do
    {
      for (;;)
      {
        try
        {
          if (this.t.tryLock(3000L, TimeUnit.MILLISECONDS))
          {
            l5 = SystemClock.elapsedRealtime();
            l1 = System.currentTimeMillis();
            System.currentTimeMillis();
            l2 = l1;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
          }
          try
          {
            this.b = new InetSocketAddress(paramd.c(), paramd.d());
            l2 = l1;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            StringBuilder localStringBuilder = new StringBuilder();
            l2 = l1;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            QLog.d("MSF.C.NetConnTag", 1, "try open Conn " + this.b);
            l2 = l1;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            l3 = System.currentTimeMillis();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.f = new Socket();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.f.setSoTimeout(paramInt2);
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.f.setTcpNoDelay(true);
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.f.setKeepAlive(true);
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.f.connect(this.b, paramd.e());
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            parama.d = true;
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            parama.j += 1;
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.p = System.currentTimeMillis();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            long l4 = this.p - l3;
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            i locali = this.v.sender.a;
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            locali.l += l4;
            l1 = l4;
            if (l4 < 0L) {
              l1 = 0L;
            }
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            l.s = this.p;
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.n.set(0L);
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.o.set(0L);
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.g = this.f.getOutputStream();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            m.add(this.g.toString());
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.j = new MsfSocketInputBuffer(this.f, paramInt1, "US-ASCII", -1);
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.i = new a();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.i.setName("MsfCoreSocketReader");
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.i.start();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.r.set(true);
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            localObject4 = t.c;
            str = "conSucc";
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.w = paramd;
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            l.f();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            l.h = this.w.c() + ":" + this.w.d();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            l.i = this.f.getLocalSocketAddress() + "|" + this.f.getLocalPort();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            if (!NetConnInfoCenterImpl.isWifiConn()) {
              continue;
            }
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            l.j = 1;
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.w.f();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            localStringBuilder.delete(0, localStringBuilder.length());
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.k = this.f.getInetAddress().getHostName();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            this.l = this.f.getPort();
            l2 = l3;
            localObject2 = str;
            localObject1 = localObject4;
            localObject3 = str;
            paramc = (c)localObject4;
            QLog.d("MSF.C.NetConnTag", 1, "open conn at " + this.b + " costTime:" + l1 + " configTimeout: " + paramd.e() + " localSocket:" + this.f.getLocalAddress().getHostAddress() + ":" + this.f.getLocalPort());
            this.t.unlock();
            if (localObject4 != t.c)
            {
              parama.d = false;
              parama.k += 1;
            }
            parama.e = ((t)localObject4);
            parama.f = "conSucc";
            parama.a = (SystemClock.elapsedRealtime() - l5);
            localObject2 = localObject4;
          }
          catch (Throwable localThrowable)
          {
            long l3;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            l1 = System.currentTimeMillis() - l2;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            localObject4 = this.v.sender.a;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            ((i)localObject4).l += l1;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            str = localThrowable.toString().toLowerCase();
            localObject3 = str;
            paramc = (c)localObject1;
            if (NetConnInfoCenterImpl.getSystemNetworkType() != 0) {
              continue;
            }
            localObject3 = str;
            paramc = (c)localObject1;
            localObject2 = t.m;
            localObject3 = str;
            paramc = (c)localObject2;
            localObject1 = ((t)localObject2).toString();
            localObject3 = localObject1;
            paramc = (c)localObject2;
            parama.h = 5000;
            this.t.unlock();
            if (localObject2 == t.c) {
              continue;
            }
            parama.d = false;
            parama.k += 1;
            parama.e = ((t)localObject2);
            parama.f = ((String)localObject1);
            parama.a = (SystemClock.elapsedRealtime() - l5);
            continue;
            localObject3 = str;
            paramc = (c)localObject1;
            if (str.indexOf("illegal") <= -1) {
              continue;
            }
            localObject3 = str;
            paramc = (c)localObject1;
            localObject2 = t.g;
            localObject3 = str;
            paramc = (c)localObject2;
            localObject1 = ((t)localObject2).toString();
            continue;
            localObject3 = str;
            paramc = (c)localObject1;
            if (str.indexOf("route to host") <= -1) {
              continue;
            }
            localObject3 = str;
            paramc = (c)localObject1;
            localObject2 = t.q;
            localObject3 = str;
            paramc = (c)localObject2;
            localObject1 = ((t)localObject2).toString();
            continue;
            localObject3 = str;
            paramc = (c)localObject1;
            if (str.indexOf("unreachable") <= -1) {
              break label2087;
            }
            localObject3 = str;
            paramc = (c)localObject1;
            localObject2 = t.m;
            localObject3 = str;
            paramc = (c)localObject2;
            localObject1 = ((t)localObject2).toString();
            localObject3 = localObject1;
            paramc = (c)localObject2;
            parama.h = 5000;
            continue;
          }
          finally
          {
            this.t.unlock();
            if (paramc == t.c) {
              continue;
            }
            parama.d = false;
            parama.k += 1;
            parama.e = paramc;
            parama.f = ((String)localObject3);
            parama.a = (SystemClock.elapsedRealtime() - l5);
          }
          if ((localObject2 != t.c) || (!this.u)) {
            break;
          }
          if (!NetConnInfoCenterImpl.isNetSupport()) {
            NetConnInfoCenterImpl.setNetSupport(true);
          }
          this.v.sender.a(null);
          this.v.sender.c();
          l.d.set(0);
          if (this.f != null)
          {
            this.v.nowSocketConnAdd = (this.f.getLocalAddress().getHostAddress() + ":" + this.f.getLocalPort());
            NetConnInfoCenter.onConnOpened(this.b.toString(), this.v.nowSocketConnAdd);
            this.v.sender.j();
          }
          return;
        }
        catch (InterruptedException paramd)
        {
          long l5;
          long l2;
          parama.d = false;
          parama.k += 1;
          parama.e = t.f;
          parama.f = paramd.toString();
          parama.a = 0L;
          return;
        }
        l2 = l3;
        localObject2 = str;
        Object localObject1 = localObject4;
        Object localObject3 = str;
        paramc = (c)localObject4;
        if (NetConnInfoCenterImpl.isMobileConn())
        {
          l2 = l3;
          localObject2 = str;
          localObject1 = localObject4;
          localObject3 = str;
          paramc = (c)localObject4;
          l.j = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
          continue;
          for (;;)
          {
            localObject3 = str;
            paramc = (c)localObject1;
            if (str.indexOf("permission") > -1)
            {
              localObject3 = str;
              paramc = (c)localObject1;
              localObject2 = t.i;
              localObject3 = str;
              paramc = (c)localObject2;
              localObject1 = ((t)localObject2).toString();
            }
            else
            {
              localObject3 = str;
              paramc = (c)localObject1;
              if (str.indexOf("refused") > -1)
              {
                localObject3 = str;
                paramc = (c)localObject1;
                localObject2 = t.s;
                localObject3 = str;
                paramc = (c)localObject2;
                localObject1 = ((t)localObject2).toString();
              }
              else
              {
                localObject3 = str;
                paramc = (c)localObject1;
                if (str.indexOf("reset") > -1)
                {
                  localObject3 = str;
                  paramc = (c)localObject1;
                  localObject2 = t.r;
                  localObject3 = str;
                  paramc = (c)localObject2;
                  localObject1 = ((t)localObject2).toString();
                }
                else
                {
                  localObject3 = str;
                  paramc = (c)localObject1;
                  if (str.indexOf("timeoutexception") <= -1)
                  {
                    localObject3 = str;
                    paramc = (c)localObject1;
                    if (str.indexOf(") after") <= -1) {}
                  }
                  else
                  {
                    localObject3 = str;
                    paramc = (c)localObject1;
                    localObject2 = t.t;
                    localObject3 = str;
                    paramc = (c)localObject2;
                    localObject1 = ((t)localObject2).toString();
                    continue;
                  }
                  localObject3 = str;
                  paramc = (c)localObject1;
                  if (str.indexOf("unknownhost") > -1)
                  {
                    localObject3 = str;
                    paramc = (c)localObject1;
                    localObject2 = t.p;
                    localObject3 = str;
                    paramc = (c)localObject2;
                    localObject1 = ((t)localObject2).toString();
                  }
                  else
                  {
                    localObject3 = str;
                    paramc = (c)localObject1;
                    if (str.indexOf("unresolved") > -1)
                    {
                      localObject3 = str;
                      paramc = (c)localObject1;
                      localObject2 = t.o;
                      localObject3 = str;
                      paramc = (c)localObject2;
                      localObject1 = ((t)localObject2).toString();
                    }
                    else
                    {
                      localObject3 = str;
                      paramc = (c)localObject1;
                      if (str.indexOf("enotsock") > -1)
                      {
                        localObject3 = str;
                        paramc = (c)localObject1;
                        localObject2 = t.h;
                        localObject3 = str;
                        paramc = (c)localObject2;
                        localObject1 = ((t)localObject2).toString();
                      }
                      else
                      {
                        localObject3 = str;
                        paramc = (c)localObject1;
                        if (str.indexOf("enobufs") > -1)
                        {
                          localObject3 = str;
                          paramc = (c)localObject1;
                          localObject2 = t.l;
                          localObject3 = str;
                          paramc = (c)localObject2;
                          localObject1 = ((t)localObject2).toString();
                        }
                        else
                        {
                          localObject3 = str;
                          paramc = (c)localObject1;
                          if (str.indexOf("ebadf") > -1)
                          {
                            localObject3 = str;
                            paramc = (c)localObject1;
                            localObject2 = t.j;
                            localObject3 = str;
                            paramc = (c)localObject2;
                            localObject1 = ((t)localObject2).toString();
                          }
                          else
                          {
                            localObject3 = str;
                            paramc = (c)localObject1;
                            if (str.indexOf("operation") > -1)
                            {
                              localObject3 = str;
                              paramc = (c)localObject1;
                              localObject2 = t.t;
                              localObject3 = str;
                              paramc = (c)localObject2;
                              localObject1 = ((t)localObject2).toString();
                            }
                            else
                            {
                              localObject3 = str;
                              paramc = (c)localObject1;
                              if (str.indexOf("invalid") > -1)
                              {
                                localObject3 = str;
                                paramc = (c)localObject1;
                                localObject2 = t.n;
                                localObject3 = str;
                                paramc = (c)localObject2;
                                localObject1 = ((t)localObject2).toString();
                              }
                              else
                              {
                                localObject3 = str;
                                paramc = (c)localObject1;
                                localObject4 = t.u;
                                localObject3 = str;
                                paramc = (c)localObject4;
                                str = Log.getStackTraceString(localThrowable);
                                localObject1 = str;
                                localObject2 = localObject4;
                                localObject3 = str;
                                paramc = (c)localObject4;
                                if (str.length() > 200)
                                {
                                  localObject3 = str;
                                  paramc = (c)localObject4;
                                  localObject1 = str.substring(0, 200);
                                  localObject2 = localObject4;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    } while (localObject2 == t.c);
    QLog.d("MSF.C.NetConnTag", 1, "open " + this.b + " failed " + parama.f + " costTime: " + l1 + " configTimeout: " + paramd.e());
  }
  
  /* Error */
  public void a(com.tencent.qphone.base.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 258	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
    //   4: ifnonnull +30 -> 34
    //   7: ldc 142
    //   9: iconst_1
    //   10: new 134	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 538
    //   20: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: iconst_1
    //   35: istore_2
    //   36: aload_0
    //   37: getfield 258	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
    //   40: invokevirtual 539	java/net/Socket:toString	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_0
    //   46: getfield 93	com/tencent/mobileqq/msf/core/b/h:t	Ljava/util/concurrent/locks/ReentrantLock;
    //   49: ldc2_w 213
    //   52: getstatic 220	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: invokevirtual 224	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   58: istore_3
    //   59: iload_3
    //   60: ifeq +446 -> 506
    //   63: aload_0
    //   64: getfield 95	com/tencent/mobileqq/msf/core/b/h:v	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   67: getfield 286	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   70: aconst_null
    //   71: invokevirtual 415	com/tencent/mobileqq/msf/core/l:a	([B)V
    //   74: aload_0
    //   75: getfield 86	com/tencent/mobileqq/msf/core/b/h:r	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   78: invokevirtual 104	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 321	com/tencent/mobileqq/msf/core/b/h:i	Lcom/tencent/mobileqq/msf/core/b/h$a;
    //   86: ifnull +14 -> 100
    //   89: aload_0
    //   90: getfield 321	com/tencent/mobileqq/msf/core/b/h:i	Lcom/tencent/mobileqq/msf/core/b/h$a;
    //   93: getfield 541	com/tencent/mobileqq/msf/core/b/h$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   96: iconst_0
    //   97: invokevirtual 199	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   100: aload_0
    //   101: getfield 258	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
    //   104: invokevirtual 545	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   107: ifnull +13 -> 120
    //   110: aload_0
    //   111: getfield 258	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
    //   114: invokevirtual 545	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   117: invokevirtual 550	java/io/InputStream:close	()V
    //   120: aload_0
    //   121: getfield 62	com/tencent/mobileqq/msf/core/b/h:g	Ljava/io/OutputStream;
    //   124: astore 7
    //   126: aload 7
    //   128: ifnull +24 -> 152
    //   131: getstatic 55	com/tencent/mobileqq/msf/core/b/h:m	Ljava/util/ArrayList;
    //   134: aload_0
    //   135: getfield 62	com/tencent/mobileqq/msf/core/b/h:g	Ljava/io/OutputStream;
    //   138: invokevirtual 305	java/lang/Object:toString	()Ljava/lang/String;
    //   141: invokevirtual 553	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: aload_0
    //   146: getfield 62	com/tencent/mobileqq/msf/core/b/h:g	Ljava/io/OutputStream;
    //   149: invokevirtual 554	java/io/OutputStream:close	()V
    //   152: aload_0
    //   153: aconst_null
    //   154: putfield 321	com/tencent/mobileqq/msf/core/b/h:i	Lcom/tencent/mobileqq/msf/core/b/h$a;
    //   157: aload_0
    //   158: getfield 258	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
    //   161: astore 7
    //   163: aload 7
    //   165: ifnull +16 -> 181
    //   168: aload_0
    //   169: getfield 258	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
    //   172: invokevirtual 555	java/net/Socket:close	()V
    //   175: getstatic 55	com/tencent/mobileqq/msf/core/b/h:m	Ljava/util/ArrayList;
    //   178: invokevirtual 558	java/util/ArrayList:clear	()V
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 258	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
    //   186: aload_0
    //   187: getfield 86	com/tencent/mobileqq/msf/core/b/h:r	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   190: iconst_0
    //   191: invokevirtual 199	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 106	com/tencent/mobileqq/msf/core/b/h:h	Lcom/tencent/mobileqq/msf/core/b/c;
    //   199: aload_0
    //   200: getfield 93	com/tencent/mobileqq/msf/core/b/h:t	Ljava/util/concurrent/locks/ReentrantLock;
    //   203: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   206: aload_0
    //   207: getfield 88	com/tencent/mobileqq/msf/core/b/h:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   210: invokevirtual 104	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   213: ifne +189 -> 402
    //   216: iload_2
    //   217: ifeq +185 -> 402
    //   220: aload_0
    //   221: getfield 97	com/tencent/mobileqq/msf/core/b/h:u	Z
    //   224: ifeq +178 -> 402
    //   227: aload_0
    //   228: getfield 79	com/tencent/mobileqq/msf/core/b/h:p	J
    //   231: lconst_0
    //   232: lcmp
    //   233: ifle +96 -> 329
    //   236: invokestatic 235	java/lang/System:currentTimeMillis	()J
    //   239: aload_0
    //   240: getfield 79	com/tencent/mobileqq/msf/core/b/h:p	J
    //   243: lsub
    //   244: lstore 4
    //   246: aload_0
    //   247: lconst_0
    //   248: putfield 79	com/tencent/mobileqq/msf/core/b/h:p	J
    //   251: aload_0
    //   252: getfield 95	com/tencent/mobileqq/msf/core/b/h:v	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   255: getfield 286	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   258: invokevirtual 561	com/tencent/mobileqq/msf/core/l:b	()[B
    //   261: invokestatic 567	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   264: astore 7
    //   266: invokestatic 570	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getCurrentAPN	()Ljava/lang/String;
    //   269: astore 8
    //   271: aload_0
    //   272: getfield 95	com/tencent/mobileqq/msf/core/b/h:v	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   275: getfield 286	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   278: getfield 291	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   281: invokevirtual 571	com/tencent/mobileqq/msf/core/b/i:c	()V
    //   284: aload_0
    //   285: getfield 95	com/tencent/mobileqq/msf/core/b/h:v	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   288: invokevirtual 575	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   291: iconst_0
    //   292: lload 4
    //   294: ldc2_w 576
    //   297: ldiv
    //   298: aload_0
    //   299: getfield 114	com/tencent/mobileqq/msf/core/b/h:c	Lcom/tencent/mobileqq/msf/core/d;
    //   302: aload_1
    //   303: getstatic 359	com/tencent/mobileqq/msf/core/l:j	I
    //   306: lload 4
    //   308: aload_0
    //   309: getfield 75	com/tencent/mobileqq/msf/core/b/h:n	Ljava/util/concurrent/atomic/AtomicLong;
    //   312: invokevirtual 579	java/util/concurrent/atomic/AtomicLong:get	()J
    //   315: aload_0
    //   316: getfield 77	com/tencent/mobileqq/msf/core/b/h:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   319: invokevirtual 579	java/util/concurrent/atomic/AtomicLong:get	()J
    //   322: aload 7
    //   324: aload 8
    //   326: invokevirtual 584	com/tencent/mobileqq/msf/core/d/j:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   329: ldc 142
    //   331: iconst_1
    //   332: new 134	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 586
    //   342: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 6
    //   347: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc_w 588
    //   353: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_1
    //   357: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_0
    //   367: getfield 95	com/tencent/mobileqq/msf/core/b/h:v	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   370: aconst_null
    //   371: putfield 427	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   374: aload_0
    //   375: aconst_null
    //   376: putfield 114	com/tencent/mobileqq/msf/core/b/h:c	Lcom/tencent/mobileqq/msf/core/d;
    //   379: aload_0
    //   380: getfield 75	com/tencent/mobileqq/msf/core/b/h:n	Ljava/util/concurrent/atomic/AtomicLong;
    //   383: lconst_0
    //   384: invokevirtual 300	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   387: aload_0
    //   388: getfield 77	com/tencent/mobileqq/msf/core/b/h:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   391: lconst_0
    //   392: invokevirtual 300	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   395: invokestatic 593	com/tencent/qphone/base/util/CodecWarpper:onConnClose	()V
    //   398: aload_1
    //   399: invokestatic 596	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   402: aload_0
    //   403: getfield 336	com/tencent/mobileqq/msf/core/b/h:w	Lcom/tencent/mobileqq/msf/core/d;
    //   406: ifnull +28 -> 434
    //   409: aload_0
    //   410: getfield 336	com/tencent/mobileqq/msf/core/b/h:w	Lcom/tencent/mobileqq/msf/core/d;
    //   413: aload_1
    //   414: invokevirtual 599	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   417: ifeq +17 -> 434
    //   420: aload_0
    //   421: getfield 95	com/tencent/mobileqq/msf/core/b/h:v	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   424: invokevirtual 603	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/d;
    //   427: aload_0
    //   428: getfield 336	com/tencent/mobileqq/msf/core/b/h:w	Lcom/tencent/mobileqq/msf/core/d;
    //   431: invokevirtual 608	com/tencent/mobileqq/msf/core/a/d:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   434: aload_0
    //   435: aconst_null
    //   436: putfield 336	com/tencent/mobileqq/msf/core/b/h:w	Lcom/tencent/mobileqq/msf/core/d;
    //   439: ldc_w 340
    //   442: putstatic 342	com/tencent/mobileqq/msf/core/l:h	Ljava/lang/String;
    //   445: ldc_w 610
    //   448: putstatic 353	com/tencent/mobileqq/msf/core/l:i	Ljava/lang/String;
    //   451: return
    //   452: astore_1
    //   453: aload_1
    //   454: invokevirtual 613	java/lang/Exception:printStackTrace	()V
    //   457: return
    //   458: astore 7
    //   460: iconst_1
    //   461: istore_2
    //   462: aload_0
    //   463: getfield 93	com/tencent/mobileqq/msf/core/b/h:t	Ljava/util/concurrent/locks/ReentrantLock;
    //   466: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   469: aload 7
    //   471: athrow
    //   472: astore 7
    //   474: ldc 142
    //   476: iconst_1
    //   477: new 134	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 615
    //   487: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 7
    //   492: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: aload 7
    //   500: invokestatic 618	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   503: goto -297 -> 206
    //   506: aload_0
    //   507: getfield 321	com/tencent/mobileqq/msf/core/b/h:i	Lcom/tencent/mobileqq/msf/core/b/h$a;
    //   510: ifnull +14 -> 524
    //   513: aload_0
    //   514: getfield 321	com/tencent/mobileqq/msf/core/b/h:i	Lcom/tencent/mobileqq/msf/core/b/h$a;
    //   517: getfield 541	com/tencent/mobileqq/msf/core/b/h$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   520: iconst_0
    //   521: invokevirtual 199	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   524: ldc 142
    //   526: iconst_1
    //   527: ldc_w 620
    //   530: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload_0
    //   534: getfield 88	com/tencent/mobileqq/msf/core/b/h:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   537: iconst_1
    //   538: invokevirtual 199	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   541: goto -335 -> 206
    //   544: astore 7
    //   546: iconst_1
    //   547: istore_2
    //   548: goto -74 -> 474
    //   551: astore 6
    //   553: ldc 142
    //   555: iconst_1
    //   556: new 134	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   563: ldc_w 622
    //   566: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 6
    //   571: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: aload 6
    //   579: invokestatic 618	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   582: goto -184 -> 398
    //   585: astore 7
    //   587: iconst_1
    //   588: istore_2
    //   589: ldc 66
    //   591: astore 6
    //   593: goto -119 -> 474
    //   596: astore 7
    //   598: goto -124 -> 474
    //   601: astore 7
    //   603: goto -141 -> 462
    //   606: astore 7
    //   608: goto -427 -> 181
    //   611: astore 7
    //   613: goto -461 -> 152
    //   616: astore 7
    //   618: goto -498 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	h
    //   0	621	1	parama	com.tencent.qphone.base.a
    //   35	554	2	bool1	boolean
    //   58	2	3	bool2	boolean
    //   244	63	4	l1	long
    //   43	303	6	str1	String
    //   551	27	6	localException1	java.lang.Exception
    //   591	1	6	str2	String
    //   124	199	7	localObject1	Object
    //   458	12	7	localObject2	Object
    //   472	27	7	localThrowable1	Throwable
    //   544	1	7	localThrowable2	Throwable
    //   585	1	7	localThrowable3	Throwable
    //   596	1	7	localThrowable4	Throwable
    //   601	1	7	localObject3	Object
    //   606	1	7	localThrowable5	Throwable
    //   611	1	7	localException2	java.lang.Exception
    //   616	1	7	localThrowable6	Throwable
    //   269	56	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   402	434	452	java/lang/Exception
    //   434	451	452	java/lang/Exception
    //   63	82	458	finally
    //   462	472	472	java/lang/Throwable
    //   45	59	544	java/lang/Throwable
    //   506	524	544	java/lang/Throwable
    //   524	541	544	java/lang/Throwable
    //   395	398	551	java/lang/Exception
    //   36	45	585	java/lang/Throwable
    //   199	206	596	java/lang/Throwable
    //   82	100	601	finally
    //   100	120	601	finally
    //   120	126	601	finally
    //   131	152	601	finally
    //   152	163	601	finally
    //   168	181	601	finally
    //   181	199	601	finally
    //   168	181	606	java/lang/Throwable
    //   131	152	611	java/lang/Exception
    //   100	120	616	java/lang/Throwable
  }
  
  public boolean a()
  {
    return this.q;
  }
  
  public boolean b()
  {
    return this.r.get();
  }
  
  public long c()
  {
    return this.p;
  }
  
  class a
    extends Thread
  {
    AtomicBoolean a = new AtomicBoolean(true);
    long b = SystemClock.elapsedRealtime();
    
    a() {}
    
    public void run()
    {
      while (this.a.get()) {
        try
        {
          while (!h.this.j.isDataAvailable(h.this.e)) {
            if (!this.a.get()) {
              return;
            }
          }
          if (!this.a.get()) {
            break;
          }
          h.this.h.a(h.this.j);
          h.this.o.addAndGet(h.this.j.getBufferlen());
          h.this.j.reset();
        }
        catch (Throwable localThrowable)
        {
          this.a.set(false);
          QLog.d("MSF.C.NetConnTag", 1, "read DataError " + localThrowable);
          h.this.a(com.tencent.qphone.base.a.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.h
 * JD-Core Version:    0.7.0.1
 */