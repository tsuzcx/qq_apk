package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.b.i;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class g
{
  public static final int a = -100;
  public static final int b = -200;
  public static ArrayList n = new ArrayList();
  InetSocketAddress c;
  d d;
  int e;
  int f = 30000;
  public Socket g;
  OutputStream h = null;
  c i;
  a j;
  MsfSocketInputBuffer k = null;
  public String l = "";
  public int m = 0;
  AtomicLong o = new AtomicLong();
  AtomicLong p = new AtomicLong();
  long q = 0L;
  boolean r = false;
  AtomicBoolean s = new AtomicBoolean();
  AtomicBoolean t = new AtomicBoolean();
  ReentrantLock u = new ReentrantLock();
  boolean v;
  MsfCore w;
  public d x;
  private AtomicInteger y = new AtomicInteger();
  
  public g(MsfCore paramMsfCore, boolean paramBoolean)
  {
    this.w = paramMsfCore;
    this.v = paramBoolean;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((this.t.get()) || (!this.s.get()) || (this.i == null)) {
      return -100;
    }
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      paramMsfCommand = this.i.a(this.d, paramString1, paramString2, paramArrayOfByte);
      if ((paramString2.equals("SSO.LoginMerge")) && (!this.w.sender.l))
      {
        paramString1 = (ArrayList)this.w.sender.f().remove(Integer.valueOf(paramInt3));
        QLog.d("MSF.C.NetConnTag", 1, "NetChanged devide merge package, " + Arrays.toString(paramString1.toArray()) + " resend.");
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (Integer)paramString1.next();
            paramString2 = this.w.sender.a(paramString2.intValue());
            this.w.sender.b(paramString2);
          }
        }
        return -200;
      }
      this.h.write(paramMsfCommand);
      this.h.flush();
      this.o.addAndGet(paramMsfCommand.length);
      StringBuilder localStringBuilder = new StringBuilder();
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 1, "netSend appid:" + paramInt1 + " appSeq:" + paramInt2 + " ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2 + " len:" + paramArrayOfByte.length);
      }
      while (paramString2.equals("SSO.LoginMerge"))
      {
        return paramArrayOfByte.length;
        QLog.d("MSF.C.NetConnTag", 1, "netSend ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2.hashCode() + new StringBuilder().append(" ").append(paramArrayOfByte.length + paramInt3).toString());
      }
      if (paramString3 == null) {
        i.a(true, paramString1, paramMsfCommand.length, paramString2, 0, this.l, this.m);
      } else {
        i.a(true, paramString1, paramMsfCommand.length, paramString3, 0, this.l, this.m);
      }
    }
  }
  
  public void a(d paramd, int paramInt1, int paramInt2, c paramc, boolean paramBoolean, a parama)
  {
    if (((this.t.get()) || (!this.s.get())) && (this.t.get()))
    {
      this.t.set(false);
      a(com.tencent.qphone.base.a.f);
    }
    this.d = paramd;
    this.i = paramc;
    this.r = paramBoolean;
    this.w.sender.l = paramd.h();
    Object localObject4 = q.b;
    String str1 = "";
    this.q = 0L;
    long l1;
    Object localObject2;
    label2330:
    do
    {
      for (;;)
      {
        try
        {
          if (this.u.tryLock(3000L, TimeUnit.MILLISECONDS))
          {
            l5 = SystemClock.elapsedRealtime();
            l1 = System.currentTimeMillis();
            System.currentTimeMillis();
            l2 = l1;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
          }
          try
          {
            this.c = new InetSocketAddress(paramd.c(), paramd.d());
            l2 = l1;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            localStringBuilder1 = new StringBuilder();
            l2 = l1;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            StringBuilder localStringBuilder2 = new StringBuilder().append("try open Conn " + this.c);
            l2 = l1;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            if (!paramd.h) {
              continue;
            }
            localObject5 = " proxy";
            l2 = l1;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            QLog.d("MSF.C.NetConnTag", 1, (String)localObject5);
            l2 = l1;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            l3 = System.currentTimeMillis();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.g = new Socket();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.g.setSoTimeout(paramInt2);
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.g.setTcpNoDelay(true);
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.g.setKeepAlive(true);
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.g.connect(this.c, paramd.e());
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            parama.d = true;
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            parama.j += 1;
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.q = System.currentTimeMillis();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            long l4 = this.q - l3;
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            localObject5 = this.w.sender.a;
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            ((h)localObject5).o += l4;
            l1 = l4;
            if (l4 < 0L) {
              l1 = 0L;
            }
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            l.C = this.q;
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.o.set(0L);
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.p.set(0L);
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.h = this.g.getOutputStream();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            if (!n.contains(this.h.toString()))
            {
              l2 = l3;
              localObject2 = str1;
              localObject1 = localObject4;
              localObject3 = str1;
              paramc = (c)localObject4;
              n.add(this.h.toString());
            }
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.k = new MsfSocketInputBuffer(this.g, paramInt1, "US-ASCII", -1);
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.j = new a();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.j.setName("MsfCoreSocketReader");
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.j.start();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.s.set(true);
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            localObject4 = q.c;
            str1 = "conSucc";
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.x = paramd;
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            l.g();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            l.r = this.x.c() + ":" + this.x.d();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            l.s = this.g.getLocalSocketAddress() + "|" + this.g.getLocalPort();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            if (!NetConnInfoCenterImpl.isWifiConn()) {
              continue;
            }
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            l.t = 1;
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.x.f();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            localStringBuilder1.delete(0, localStringBuilder1.length());
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.l = this.g.getInetAddress().getHostName();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            this.m = this.g.getPort();
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            localStringBuilder1 = new StringBuilder().append("open conn at " + this.c + " costTime:" + l1 + " configTimeout: " + paramd.e() + " localSocket:" + this.g.getLocalAddress().getHostAddress() + ":" + this.g.getLocalPort());
            l2 = l3;
            localObject2 = str1;
            localObject1 = localObject4;
            localObject3 = str1;
            paramc = (c)localObject4;
            if (!paramd.h) {
              continue;
            }
            localObject5 = " proxy";
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder1;
            Object localObject5;
            long l3;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            l1 = System.currentTimeMillis() - l2;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            localObject4 = this.w.sender.a;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            ((h)localObject4).o += l1;
            localObject3 = localObject2;
            paramc = (c)localObject1;
            str1 = localThrowable.toString().toLowerCase();
            localObject3 = str1;
            paramc = (c)localObject1;
            if (NetConnInfoCenterImpl.getSystemNetworkType() != 0) {
              continue;
            }
            localObject3 = str1;
            paramc = (c)localObject1;
            localObject2 = q.m;
            localObject3 = str1;
            paramc = (c)localObject2;
            localObject1 = ((q)localObject2).toString();
            localObject3 = localObject1;
            paramc = (c)localObject2;
            parama.h = 5000;
            this.u.unlock();
            if (localObject2 == q.c) {
              continue;
            }
            parama.d = false;
            parama.k += 1;
            parama.e = ((q)localObject2);
            parama.f = ((String)localObject1);
            parama.a = (SystemClock.elapsedRealtime() - l5);
            continue;
            str2 = " noneProxy";
            continue;
            localObject3 = str1;
            paramc = (c)localObject1;
            if (str1.indexOf("illegal") <= -1) {
              continue;
            }
            localObject3 = str1;
            paramc = (c)localObject1;
            localObject2 = q.g;
            localObject3 = str1;
            paramc = (c)localObject2;
            localObject1 = ((q)localObject2).toString();
            continue;
            localObject3 = str1;
            paramc = (c)localObject1;
            if (str1.indexOf("route to host") <= -1) {
              continue;
            }
            localObject3 = str1;
            paramc = (c)localObject1;
            localObject2 = q.q;
            localObject3 = str1;
            paramc = (c)localObject2;
            localObject1 = ((q)localObject2).toString();
            continue;
            localObject3 = str1;
            paramc = (c)localObject1;
            if (str1.indexOf("unreachable") <= -1) {
              break label2330;
            }
            localObject3 = str1;
            paramc = (c)localObject1;
            localObject2 = q.m;
            localObject3 = str1;
            paramc = (c)localObject2;
            localObject1 = ((q)localObject2).toString();
            localObject3 = localObject1;
            paramc = (c)localObject2;
            parama.h = 5000;
            continue;
          }
          finally
          {
            this.u.unlock();
            if (paramc == q.c) {
              continue;
            }
            parama.d = false;
            parama.k += 1;
            parama.e = paramc;
            parama.f = ((String)localObject3);
            parama.a = (SystemClock.elapsedRealtime() - l5);
          }
          l2 = l3;
          localObject2 = str1;
          localObject1 = localObject4;
          localObject3 = str1;
          paramc = (c)localObject4;
          QLog.d("MSF.C.NetConnTag", 1, (String)localObject5);
          l2 = l3;
          localObject2 = str1;
          localObject1 = localObject4;
          localObject3 = str1;
          paramc = (c)localObject4;
          this.y.set(0);
          this.u.unlock();
          if (localObject4 != q.c)
          {
            parama.d = false;
            parama.k += 1;
          }
          parama.e = ((q)localObject4);
          parama.f = "conSucc";
          parama.a = (SystemClock.elapsedRealtime() - l5);
          localObject2 = localObject4;
          if ((localObject2 != q.c) || (!this.v)) {
            break;
          }
          if (!NetConnInfoCenterImpl.isNetSupport()) {
            NetConnInfoCenterImpl.setNetSupport(true);
          }
          this.w.sender.a(null);
          this.w.sender.c();
          l.o.set(0);
          if (this.g != null)
          {
            this.w.nowSocketConnAdd = (this.g.getLocalAddress().getHostAddress() + ":" + this.g.getLocalPort());
            NetConnInfoCenter.onConnOpened(this.c.toString(), this.w.nowSocketConnAdd);
            this.w.sender.k();
          }
          return;
        }
        catch (InterruptedException paramd)
        {
          long l5;
          long l2;
          parama.d = false;
          parama.k += 1;
          parama.e = q.f;
          parama.f = paramd.toString();
          parama.a = 0L;
          return;
        }
        localObject5 = " noneProxy";
        continue;
        l2 = l3;
        localObject2 = str1;
        Object localObject1 = localObject4;
        Object localObject3 = str1;
        paramc = (c)localObject4;
        if (NetConnInfoCenterImpl.isMobileConn())
        {
          l2 = l3;
          localObject2 = str1;
          localObject1 = localObject4;
          localObject3 = str1;
          paramc = (c)localObject4;
          l.t = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
          continue;
          for (;;)
          {
            String str2;
            localObject3 = str1;
            paramc = (c)localObject1;
            if (str1.indexOf("permission") > -1)
            {
              localObject3 = str1;
              paramc = (c)localObject1;
              localObject2 = q.i;
              localObject3 = str1;
              paramc = (c)localObject2;
              localObject1 = ((q)localObject2).toString();
            }
            else
            {
              localObject3 = str1;
              paramc = (c)localObject1;
              if (str1.indexOf("refused") > -1)
              {
                localObject3 = str1;
                paramc = (c)localObject1;
                localObject2 = q.s;
                localObject3 = str1;
                paramc = (c)localObject2;
                localObject1 = ((q)localObject2).toString();
              }
              else
              {
                localObject3 = str1;
                paramc = (c)localObject1;
                if (str1.indexOf("reset") > -1)
                {
                  localObject3 = str1;
                  paramc = (c)localObject1;
                  localObject2 = q.r;
                  localObject3 = str1;
                  paramc = (c)localObject2;
                  localObject1 = ((q)localObject2).toString();
                }
                else
                {
                  localObject3 = str1;
                  paramc = (c)localObject1;
                  if (str1.indexOf("timeoutexception") <= -1)
                  {
                    localObject3 = str1;
                    paramc = (c)localObject1;
                    if (str1.indexOf(") after") <= -1) {}
                  }
                  else
                  {
                    localObject3 = str1;
                    paramc = (c)localObject1;
                    localObject2 = q.t;
                    localObject3 = str1;
                    paramc = (c)localObject2;
                    localObject1 = ((q)localObject2).toString();
                    continue;
                  }
                  localObject3 = str1;
                  paramc = (c)localObject1;
                  if (str1.indexOf("unknownhost") > -1)
                  {
                    localObject3 = str1;
                    paramc = (c)localObject1;
                    localObject2 = q.p;
                    localObject3 = str1;
                    paramc = (c)localObject2;
                    localObject1 = ((q)localObject2).toString();
                  }
                  else
                  {
                    localObject3 = str1;
                    paramc = (c)localObject1;
                    if (str1.indexOf("unresolved") > -1)
                    {
                      localObject3 = str1;
                      paramc = (c)localObject1;
                      localObject2 = q.o;
                      localObject3 = str1;
                      paramc = (c)localObject2;
                      localObject1 = ((q)localObject2).toString();
                    }
                    else
                    {
                      localObject3 = str1;
                      paramc = (c)localObject1;
                      if (str1.indexOf("enotsock") > -1)
                      {
                        localObject3 = str1;
                        paramc = (c)localObject1;
                        localObject2 = q.h;
                        localObject3 = str1;
                        paramc = (c)localObject2;
                        localObject1 = ((q)localObject2).toString();
                      }
                      else
                      {
                        localObject3 = str1;
                        paramc = (c)localObject1;
                        if (str1.indexOf("enobufs") > -1)
                        {
                          localObject3 = str1;
                          paramc = (c)localObject1;
                          localObject2 = q.l;
                          localObject3 = str1;
                          paramc = (c)localObject2;
                          localObject1 = ((q)localObject2).toString();
                        }
                        else
                        {
                          localObject3 = str1;
                          paramc = (c)localObject1;
                          if (str1.indexOf("ebadf") > -1)
                          {
                            localObject3 = str1;
                            paramc = (c)localObject1;
                            localObject2 = q.j;
                            localObject3 = str1;
                            paramc = (c)localObject2;
                            localObject1 = ((q)localObject2).toString();
                          }
                          else
                          {
                            localObject3 = str1;
                            paramc = (c)localObject1;
                            if (str1.indexOf("operation") > -1)
                            {
                              localObject3 = str1;
                              paramc = (c)localObject1;
                              localObject2 = q.t;
                              localObject3 = str1;
                              paramc = (c)localObject2;
                              localObject1 = ((q)localObject2).toString();
                            }
                            else
                            {
                              localObject3 = str1;
                              paramc = (c)localObject1;
                              if (str1.indexOf("invalid") > -1)
                              {
                                localObject3 = str1;
                                paramc = (c)localObject1;
                                localObject2 = q.n;
                                localObject3 = str1;
                                paramc = (c)localObject2;
                                localObject1 = ((q)localObject2).toString();
                              }
                              else
                              {
                                localObject3 = str1;
                                paramc = (c)localObject1;
                                localObject4 = q.u;
                                localObject3 = str1;
                                paramc = (c)localObject4;
                                str1 = a(str2);
                                localObject1 = str1;
                                localObject2 = localObject4;
                                localObject3 = str1;
                                paramc = (c)localObject4;
                                if (str1.length() > 200)
                                {
                                  localObject3 = str1;
                                  paramc = (c)localObject4;
                                  localObject1 = str1.substring(0, 200);
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
    } while (localObject2 == q.c);
    paramc = new StringBuilder();
    paramc = new StringBuilder().append("open " + this.c + " failed " + parama.f + " costTime: " + l1 + " configTimeout: " + paramd.e());
    if (paramd.h) {}
    for (paramd = " proxy";; paramd = " noneProxy")
    {
      QLog.d("MSF.C.NetConnTag", 1, paramd);
      return;
    }
  }
  
  /* Error */
  public void a(com.tencent.qphone.base.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4: getfield 170	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   7: iconst_0
    //   8: putfield 632	com/tencent/mobileqq/msf/core/l:k	Z
    //   11: aload_0
    //   12: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   15: getfield 170	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   18: iconst_0
    //   19: putfield 174	com/tencent/mobileqq/msf/core/l:l	Z
    //   22: aload_0
    //   23: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   26: getfield 170	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   29: lconst_0
    //   30: putfield 634	com/tencent/mobileqq/msf/core/l:j	J
    //   33: aload_0
    //   34: getfield 360	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   37: ifnonnull +30 -> 67
    //   40: ldc 191
    //   42: iconst_1
    //   43: new 193	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 636
    //   53: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: iconst_1
    //   68: istore_3
    //   69: aload_0
    //   70: getfield 360	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   73: invokevirtual 637	java/net/Socket:toString	()Ljava/lang/String;
    //   76: astore 6
    //   78: aload_0
    //   79: getfield 102	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   82: ldc2_w 313
    //   85: getstatic 320	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   88: invokevirtual 324	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   91: istore_2
    //   92: iload_2
    //   93: ifeq +473 -> 566
    //   96: aload_0
    //   97: getfield 79	com/tencent/mobileqq/msf/core/net/g:y	Ljava/util/concurrent/atomic/AtomicInteger;
    //   100: iconst_0
    //   101: invokevirtual 497	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   104: aload_0
    //   105: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   108: getfield 170	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   111: aconst_null
    //   112: invokevirtual 516	com/tencent/mobileqq/msf/core/l:a	([B)V
    //   115: aload_0
    //   116: getfield 95	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   119: invokevirtual 141	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   122: istore_2
    //   123: aload_0
    //   124: getfield 418	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   127: ifnull +14 -> 141
    //   130: aload_0
    //   131: getfield 418	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   134: getfield 639	com/tencent/mobileqq/msf/core/net/g$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   137: iconst_0
    //   138: invokevirtual 295	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   141: aload_0
    //   142: getfield 360	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   145: invokevirtual 643	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   148: ifnull +13 -> 161
    //   151: aload_0
    //   152: getfield 360	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   155: invokevirtual 643	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   158: invokevirtual 648	java/io/InputStream:close	()V
    //   161: aload_0
    //   162: getfield 66	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   165: astore 7
    //   167: aload 7
    //   169: ifnull +24 -> 193
    //   172: getstatic 59	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   175: aload_0
    //   176: getfield 66	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   179: invokevirtual 400	java/lang/Object:toString	()Ljava/lang/String;
    //   182: invokevirtual 650	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: aload_0
    //   187: getfield 66	com/tencent/mobileqq/msf/core/net/g:h	Ljava/io/OutputStream;
    //   190: invokevirtual 651	java/io/OutputStream:close	()V
    //   193: aload_0
    //   194: aconst_null
    //   195: putfield 418	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   198: aload_0
    //   199: getfield 360	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   202: astore 7
    //   204: aload 7
    //   206: ifnull +20 -> 226
    //   209: aload_0
    //   210: getfield 360	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   213: invokevirtual 652	java/net/Socket:close	()V
    //   216: aload_1
    //   217: invokestatic 655	com/tencent/mobileqq/msf/core/p:a	(Lcom/tencent/qphone/base/a;)V
    //   220: getstatic 59	com/tencent/mobileqq/msf/core/net/g:n	Ljava/util/ArrayList;
    //   223: invokevirtual 658	java/util/ArrayList:clear	()V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 360	com/tencent/mobileqq/msf/core/net/g:g	Ljava/net/Socket;
    //   231: aload_0
    //   232: getfield 95	com/tencent/mobileqq/msf/core/net/g:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   235: iconst_0
    //   236: invokevirtual 295	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 143	com/tencent/mobileqq/msf/core/net/g:i	Lcom/tencent/mobileqq/msf/core/net/c;
    //   244: aload_0
    //   245: getfield 102	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   248: invokevirtual 500	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   251: aload_0
    //   252: getfield 97	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   255: invokevirtual 141	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   258: ifne +189 -> 447
    //   261: iload_2
    //   262: ifeq +185 -> 447
    //   265: aload_0
    //   266: getfield 106	com/tencent/mobileqq/msf/core/net/g:v	Z
    //   269: ifeq +178 -> 447
    //   272: aload_0
    //   273: getfield 88	com/tencent/mobileqq/msf/core/net/g:q	J
    //   276: lconst_0
    //   277: lcmp
    //   278: ifle +96 -> 374
    //   281: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   284: aload_0
    //   285: getfield 88	com/tencent/mobileqq/msf/core/net/g:q	J
    //   288: lsub
    //   289: lstore 4
    //   291: aload_0
    //   292: lconst_0
    //   293: putfield 88	com/tencent/mobileqq/msf/core/net/g:q	J
    //   296: aload_0
    //   297: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   300: getfield 170	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   303: invokevirtual 661	com/tencent/mobileqq/msf/core/l:b	()[B
    //   306: invokestatic 667	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   309: astore 7
    //   311: invokestatic 670	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getCurrentAPN	()Ljava/lang/String;
    //   314: astore 8
    //   316: aload_0
    //   317: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   320: getfield 170	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
    //   323: getfield 385	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   326: invokevirtual 671	com/tencent/mobileqq/msf/core/net/h:c	()V
    //   329: aload_0
    //   330: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   333: invokevirtual 675	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/b/m;
    //   336: iconst_0
    //   337: lload 4
    //   339: ldc2_w 676
    //   342: ldiv
    //   343: aload_0
    //   344: getfield 151	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   347: aload_1
    //   348: getstatic 457	com/tencent/mobileqq/msf/core/l:t	I
    //   351: lload 4
    //   353: aload_0
    //   354: getfield 84	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   357: invokevirtual 679	java/util/concurrent/atomic/AtomicLong:get	()J
    //   360: aload_0
    //   361: getfield 86	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   364: invokevirtual 679	java/util/concurrent/atomic/AtomicLong:get	()J
    //   367: aload 7
    //   369: aload 8
    //   371: invokevirtual 684	com/tencent/mobileqq/msf/core/b/m:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   374: ldc 191
    //   376: iconst_1
    //   377: new 193	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 686
    //   387: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 6
    //   392: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc_w 688
    //   398: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_0
    //   412: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   415: aconst_null
    //   416: putfield 523	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   419: aload_0
    //   420: aconst_null
    //   421: putfield 151	com/tencent/mobileqq/msf/core/net/g:d	Lcom/tencent/mobileqq/msf/core/d;
    //   424: aload_0
    //   425: getfield 84	com/tencent/mobileqq/msf/core/net/g:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   428: lconst_0
    //   429: invokevirtual 395	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   432: aload_0
    //   433: getfield 86	com/tencent/mobileqq/msf/core/net/g:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   436: lconst_0
    //   437: invokevirtual 395	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   440: invokestatic 693	com/tencent/qphone/base/util/CodecWarpper:onConnClose	()V
    //   443: aload_1
    //   444: invokestatic 696	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   447: aload_0
    //   448: getfield 433	com/tencent/mobileqq/msf/core/net/g:x	Lcom/tencent/mobileqq/msf/core/d;
    //   451: ifnull +28 -> 479
    //   454: aload_0
    //   455: getfield 433	com/tencent/mobileqq/msf/core/net/g:x	Lcom/tencent/mobileqq/msf/core/d;
    //   458: aload_1
    //   459: invokevirtual 699	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   462: ifeq +17 -> 479
    //   465: aload_0
    //   466: getfield 104	com/tencent/mobileqq/msf/core/net/g:w	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   469: invokevirtual 703	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/d;
    //   472: aload_0
    //   473: getfield 433	com/tencent/mobileqq/msf/core/net/g:x	Lcom/tencent/mobileqq/msf/core/d;
    //   476: invokevirtual 708	com/tencent/mobileqq/msf/core/a/d:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   479: aload_0
    //   480: aconst_null
    //   481: putfield 433	com/tencent/mobileqq/msf/core/net/g:x	Lcom/tencent/mobileqq/msf/core/d;
    //   484: ldc_w 437
    //   487: putstatic 439	com/tencent/mobileqq/msf/core/l:r	Ljava/lang/String;
    //   490: ldc_w 710
    //   493: putstatic 450	com/tencent/mobileqq/msf/core/l:s	Ljava/lang/String;
    //   496: return
    //   497: astore_1
    //   498: aload_1
    //   499: invokevirtual 712	java/lang/Exception:printStackTrace	()V
    //   502: return
    //   503: astore 7
    //   505: aload 7
    //   507: invokevirtual 713	java/lang/Throwable:printStackTrace	()V
    //   510: goto -290 -> 220
    //   513: astore 7
    //   515: goto -289 -> 226
    //   518: astore 7
    //   520: iconst_1
    //   521: istore_2
    //   522: aload_0
    //   523: getfield 102	com/tencent/mobileqq/msf/core/net/g:u	Ljava/util/concurrent/locks/ReentrantLock;
    //   526: invokevirtual 500	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   529: aload 7
    //   531: athrow
    //   532: astore 7
    //   534: ldc 191
    //   536: iconst_1
    //   537: new 193	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 715
    //   547: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 7
    //   552: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: aload 7
    //   560: invokestatic 718	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   563: goto -312 -> 251
    //   566: aload_0
    //   567: getfield 418	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   570: ifnull +14 -> 584
    //   573: aload_0
    //   574: getfield 418	com/tencent/mobileqq/msf/core/net/g:j	Lcom/tencent/mobileqq/msf/core/net/g$a;
    //   577: getfield 639	com/tencent/mobileqq/msf/core/net/g$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   580: iconst_0
    //   581: invokevirtual 295	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   584: ldc 191
    //   586: iconst_1
    //   587: ldc_w 720
    //   590: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: aload_0
    //   594: getfield 97	com/tencent/mobileqq/msf/core/net/g:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   597: iconst_1
    //   598: invokevirtual 295	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   601: iload_3
    //   602: istore_2
    //   603: aload_0
    //   604: getfield 79	com/tencent/mobileqq/msf/core/net/g:y	Ljava/util/concurrent/atomic/AtomicInteger;
    //   607: iconst_1
    //   608: invokevirtual 723	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   611: bipush 10
    //   613: if_icmpne -362 -> 251
    //   616: invokestatic 728	android/os/Process:myPid	()I
    //   619: invokestatic 731	android/os/Process:killProcess	(I)V
    //   622: iload_3
    //   623: istore_2
    //   624: goto -373 -> 251
    //   627: astore 7
    //   629: iconst_1
    //   630: istore_2
    //   631: goto -97 -> 534
    //   634: astore 6
    //   636: ldc 191
    //   638: iconst_1
    //   639: new 193	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 733
    //   649: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 6
    //   654: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   657: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: aload 6
    //   662: invokestatic 718	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   665: goto -222 -> 443
    //   668: astore 7
    //   670: iconst_1
    //   671: istore_2
    //   672: ldc 70
    //   674: astore 6
    //   676: goto -142 -> 534
    //   679: astore 7
    //   681: goto -147 -> 534
    //   684: astore 7
    //   686: goto -164 -> 522
    //   689: astore 7
    //   691: goto -498 -> 193
    //   694: astore 7
    //   696: goto -535 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	g
    //   0	699	1	parama	com.tencent.qphone.base.a
    //   91	581	2	bool1	boolean
    //   68	555	3	bool2	boolean
    //   289	63	4	l1	long
    //   76	315	6	str1	String
    //   634	27	6	localException1	java.lang.Exception
    //   674	1	6	str2	String
    //   165	203	7	localObject1	Object
    //   503	3	7	localThrowable1	Throwable
    //   513	1	7	localThrowable2	Throwable
    //   518	12	7	localObject2	Object
    //   532	27	7	localThrowable3	Throwable
    //   627	1	7	localThrowable4	Throwable
    //   668	1	7	localThrowable5	Throwable
    //   679	1	7	localThrowable6	Throwable
    //   684	1	7	localObject3	Object
    //   689	1	7	localException2	java.lang.Exception
    //   694	1	7	localThrowable7	Throwable
    //   314	56	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   447	479	497	java/lang/Exception
    //   479	496	497	java/lang/Exception
    //   216	220	503	java/lang/Throwable
    //   209	216	513	java/lang/Throwable
    //   220	226	513	java/lang/Throwable
    //   505	510	513	java/lang/Throwable
    //   96	123	518	finally
    //   522	532	532	java/lang/Throwable
    //   78	92	627	java/lang/Throwable
    //   566	584	627	java/lang/Throwable
    //   584	601	627	java/lang/Throwable
    //   603	622	627	java/lang/Throwable
    //   440	443	634	java/lang/Exception
    //   69	78	668	java/lang/Throwable
    //   244	251	679	java/lang/Throwable
    //   123	141	684	finally
    //   141	161	684	finally
    //   161	167	684	finally
    //   172	193	684	finally
    //   193	204	684	finally
    //   209	216	684	finally
    //   216	220	684	finally
    //   220	226	684	finally
    //   226	244	684	finally
    //   505	510	684	finally
    //   172	193	689	java/lang/Exception
    //   141	161	694	java/lang/Throwable
  }
  
  public boolean a()
  {
    return this.r;
  }
  
  public boolean b()
  {
    return this.s.get();
  }
  
  public long c()
  {
    return this.q;
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
          while (!g.this.k.isDataAvailable(g.this.f)) {
            if (!this.a.get()) {
              return;
            }
          }
          if (!this.a.get()) {
            break;
          }
          g.this.i.a(g.this.k);
          g.this.p.addAndGet(g.this.k.getBufferlen());
          g.this.k.reset();
        }
        catch (Throwable localThrowable)
        {
          this.a.set(false);
          QLog.d("MSF.C.NetConnTag", 1, "read DataError " + localThrowable);
          g.this.a(com.tencent.qphone.base.a.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.g
 * JD-Core Version:    0.7.0.1
 */