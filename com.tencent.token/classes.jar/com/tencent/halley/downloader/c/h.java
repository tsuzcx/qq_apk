package com.tencent.halley.downloader.c;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.halley.common.d;
import com.tencent.halley.downloader.DownloaderTaskPriority;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.token.aa;
import com.tencent.token.ac;
import com.tencent.token.ad;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ah;
import com.tencent.token.am;
import com.tencent.token.o;
import com.tencent.token.u;
import com.tencent.token.y;
import com.tencent.token.z;
import java.io.File;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class h
  implements com.tencent.halley.downloader.b, ac, u, Comparable, Runnable
{
  public int A = -1;
  public long B = 0L;
  public boolean C = true;
  public String D;
  public int E = 0;
  public volatile HashMap F = new LinkedHashMap();
  private com.tencent.halley.downloader.c.d.b G;
  private boolean H = true;
  private boolean I = true;
  private volatile DownloaderTaskPriority J = DownloaderTaskPriority.NORMAL;
  private volatile long K = 0L;
  private String L = "";
  private boolean M = false;
  private long N = -1L;
  private g O;
  private z P;
  private File Q;
  private RandomAccessFile R;
  private File S;
  private RandomAccessFile T;
  private volatile boolean U = false;
  private volatile boolean V = false;
  private volatile int W = 0;
  private b X = new b(this);
  private boolean Y = false;
  private a Z;
  public int a = -1;
  private int aa = 0;
  private volatile boolean ab = false;
  private AtomicInteger ac = new AtomicInteger(0);
  private Object ad = new Object();
  private volatile boolean ae = false;
  private boolean af = false;
  private j ag = new j(this, (byte)0);
  private ag ah;
  private am ai;
  private long aj = 0L;
  private String ak = "";
  private boolean al = false;
  public String b = "";
  public String c = "";
  public String d = "";
  public Map e = new HashMap();
  public long f = -1L;
  public volatile long g = -1L;
  public String h = "";
  public String i = "";
  public volatile long j = 0L;
  public volatile boolean k = true;
  public String l = "";
  public String m = "";
  public String n = null;
  public AtomicLong o = new AtomicLong(0L);
  public AtomicLong p = new AtomicLong(0L);
  public volatile int q = 0;
  public volatile int r = 0;
  public String s = "";
  public long t = -1L;
  public long u = -1L;
  public long v = -1L;
  public volatile int w = 0;
  public boolean x = false;
  public String y = "";
  public String z;
  
  public h(int paramInt, String paramString1, com.tencent.halley.downloader.c.d.b paramb, String paramString2, String paramString3, com.tencent.halley.downloader.c paramc, boolean paramBoolean, long paramLong)
  {
    com.tencent.halley.common.c.a("TaskImpl", "new BDTaskImpl()");
    this.a = paramInt;
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    this.b = str;
    this.G = paramb;
    this.h = paramString2;
    this.i = paramString3;
    this.X.a(paramc);
    this.U = paramBoolean;
    if (paramLong > 0L) {}
    for (;;)
    {
      this.f = paramLong;
      paramString1 = new StringBuilder("");
      paramString1.append(com.tencent.halley.common.j.c());
      paramString1.append(com.tencent.halley.common.j.d());
      paramString1.append(System.currentTimeMillis());
      paramString1.append(this.G.a.a);
      paramString1.append(com.tencent.halley.common.j.b());
      this.n = d.a(paramString1.toString());
      return;
      paramLong = -1L;
    }
  }
  
  private boolean O()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(s());
      if (localFile.exists()) {
        bool = localFile.delete();
      }
      com.tencent.halley.common.c.b("TaskImpl", "deleteFile:" + localFile + ",result:" + bool);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean P()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(h(), com.tencent.token.h.b(this.L));
      if (localFile.exists()) {
        bool = localFile.delete();
      }
      com.tencent.halley.common.c.b("TaskImpl", "deleteFile:" + localFile + ",result:" + bool);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean Q()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(this.h, com.tencent.token.h.a(this.L));
      if (localFile.exists()) {
        bool = localFile.delete();
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private boolean R()
  {
    try
    {
      this.T = new i(this.S, "rw");
      com.tencent.halley.common.c.b("TaskImpl", "initFileOnStart...create _cfgAccessFile");
      this.r = -12;
    }
    catch (Exception localException1)
    {
      try
      {
        this.R = new i(this.Q, "rw");
        return true;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.r = -49;
        this.s = ("initFileOnStart...create RandomAccessFile of path:" + this.Q.getAbsolutePath() + " fail.|" + localException2);
        if (!com.tencent.halley.common.g.a(localException2)) {
          break label281;
        }
      }
      localException1 = localException1;
      localException1.printStackTrace();
      com.tencent.halley.common.c.a("TaskImpl", "initFileOnStart...create RandomAccessFile for cfgFile failed.", localException1);
      this.r = -49;
      this.s = ("initFileOnStart...create RandomAccessFile of path:" + this.S.getAbsolutePath() + " fail.|" + localException1);
      if (com.tencent.halley.common.g.a(localException1)) {
        this.r = -12;
      }
      for (;;)
      {
        com.tencent.halley.common.c.c("TaskImpl", "initFileOnStart...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
        X();
        return false;
        if (com.tencent.halley.common.g.b(localException1)) {
          this.r = -13;
        }
      }
    }
    for (;;)
    {
      com.tencent.halley.common.c.c("TaskImpl", "initFileOnStart...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
      X();
      return false;
      label281:
      if (com.tencent.halley.common.g.b(localException2)) {
        this.r = -13;
      }
    }
  }
  
  private boolean S()
  {
    com.tencent.halley.common.c.b("TaskImpl", "initFileOnStart...begin");
    try
    {
      new File(this.h).mkdirs();
      this.Q = null;
      this.S = null;
      if (this.O != null)
      {
        if ((this.O.d() <= 0L) || (TextUtils.isEmpty(this.L))) {
          break label682;
        }
        if (this.I)
        {
          this.Q = new File(this.h, com.tencent.token.h.b(this.L));
          this.S = new File(this.h, com.tencent.token.h.a(this.L));
          i1 = 1;
          int i3 = 0;
          i2 = i1;
          i1 = i3;
          if (((i2 == 0) && (i1 == 0)) || (!this.Q.exists())) {
            break label663;
          }
          if (R()) {
            break label270;
          }
          return false;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        this.Q = new File(this.h, this.L);
        continue;
        if (com.tencent.token.h.c(this.i))
        {
          if (this.I) {}
          for (this.Q = new File(this.h, com.tencent.token.h.b(this.i));; this.Q = new File(this.h, this.i))
          {
            this.S = new File(this.h, com.tencent.token.h.a(this.i));
            i1 = 1;
            i2 = 0;
            break;
          }
          label270:
          Object localObject = Y();
          com.tencent.halley.common.c.b("TaskImpl", "initFileOnStart...readCfg:" + (String)localObject);
          this.O = new g((String)localObject);
          long l1;
          boolean bool;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.O.e))
          {
            l1 = this.Q.lastModified();
            if ((i1 != 0) && (l1 >= this.O.b) && (this.O.a > 0L) && (this.O.d() <= this.O.a)) {
              bool = true;
            }
          }
          for (;;)
          {
            if (bool)
            {
              if (TextUtils.isEmpty(this.L)) {
                this.L = this.i;
              }
              this.j = this.O.c;
              this.o.set(this.O.d);
              if ((i1 == 0) || (this.O.a <= 0L)) {
                break label633;
              }
              this.x = true;
            }
            for (;;)
            {
              if (!bool)
              {
                X();
                this.g = -1L;
                this.L = "";
                this.j = 0L;
                this.o.set(0L);
                this.k = true;
                this.l = "";
                this.m = "";
                this.q = 0;
                this.M = false;
                this.r = 0;
                this.s = "";
                this.O = new g("");
                this.x = false;
              }
              this.af = bool;
              return true;
              if ((i2 == 0) || (l1 < this.O.b)) {
                break label669;
              }
              bool = true;
              break;
              localObject = new StringBuilder("resume failed. cfg:").append((String)localObject).append(",flm:").append(l1).append(",from:");
              if (i1 != 0) {}
              for (i1 = 0;; i1 = 1)
              {
                this.y = i1;
                label633:
                break;
              }
              this.y = ("resume failed. cfg:" + (String)localObject);
              label663:
              bool = false;
            }
            label669:
            bool = false;
          }
        }
        int i1 = 0;
        int i2 = 0;
        continue;
        label682:
        i1 = 0;
      }
    }
  }
  
  private void T()
  {
    try
    {
      synchronized (this.ad)
      {
        this.ad.notifyAll();
        this.ae = false;
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean U()
  {
    if ((this.V) || (x()) || (w()) || (v()) || (y()))
    {
      if (this.P != null) {
        this.P.c();
      }
      X();
      return false;
    }
    long l2 = SystemClock.elapsedRealtime();
    int i2 = 0;
    boolean bool;
    if ((this.V) || (x()) || (w()) || (v()) || (y()))
    {
      if (this.P != null) {
        this.P.c();
      }
      bool = false;
    }
    for (;;)
    {
      label114:
      if (!bool) {
        T();
      }
      long l1 = SystemClock.elapsedRealtime();
      if (this.Z != null) {
        this.Z.a(i2, (int)(l1 - l2));
      }
      if (i2 > 0) {
        W();
      }
      if ((this.V) || (x()) || (w()) || (v()) || (y())) {
        X();
      }
      for (;;)
      {
        for (;;)
        {
          return bool;
          if (SystemClock.elapsedRealtime() - l2 > com.tencent.token.h.f)
          {
            bool = true;
            this.ac.getAndIncrement();
            break label114;
          }
          aa localaa = this.P.b();
          if (localaa == null) {
            break label758;
          }
          ad localad = this.O.a(localaa.a);
          if (localad == null)
          {
            a(false, -42, "inner error: getRange null for sectionId:" + localaa.a, DownloaderTaskStatus.FAILED);
            return false;
          }
          if (localad.e != localaa.b)
          {
            a(false, -42, "inner error: check offset fail for section:" + localad + ",buffer offset:" + localaa.b + ",sectionId:" + localaa.a, DownloaderTaskStatus.FAILED);
            return false;
          }
          try
          {
            if (this.R.getFilePointer() != localaa.b) {
              this.R.seek(localaa.b);
            }
            this.R.write(localaa.c, 0, (int)localaa.d);
            localad.e = (localaa.b + localaa.d);
            i1 = (int)(i2 + localaa.d);
            localaa.c = null;
            i2 = i1;
            if (!this.ae) {
              break;
            }
            i2 = i1;
            if (!y.a().h()) {
              break;
            }
            T();
            i2 = i1;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if ((localException instanceof NullPointerException)) {
              break label758;
            }
          }
        }
        com.tencent.halley.common.c.b("TaskImpl", "saveData fail.", localException);
        int i1 = -50;
        if (!this.Q.exists()) {
          i1 = -14;
        }
        for (;;)
        {
          a(false, i1, "saveData fail.|" + localException, DownloaderTaskStatus.FAILED);
          bool = false;
          break;
          if (com.tencent.halley.common.g.a(localException)) {
            i1 = -12;
          } else if (com.tencent.halley.common.g.b(localException)) {
            i1 = -17;
          }
        }
        if (this.g > 0L)
        {
          l2 = this.O.d();
          if (((l1 - this.aj <= com.tencent.token.h.h()) && (l2 != this.g)) || ((i2 > 0) && (!this.C))) {}
          try
          {
            this.R.getFD().sync();
            label636:
            this.K = l2;
            this.X.a(DownloaderTaskStatus.DOWNLOADING);
            this.aj = l1;
            if (l2 == this.g)
            {
              this.Z.c();
              this.v = l1;
              V();
            }
            else if (l2 > this.g)
            {
              com.tencent.halley.common.c.d("TaskImpl", "receivedLength > detectLength");
              a(false, -42, "inner error: receivedLength > detectLength:" + l2 + " > " + this.g, DownloaderTaskStatus.FAILED);
              Q();
            }
          }
          catch (Throwable localThrowable)
          {
            break label636;
          }
        }
      }
      label758:
      bool = false;
    }
  }
  
  private void V()
  {
    for (;;)
    {
      synchronized (this.X)
      {
        if (this.X.a() != DownloaderTaskStatus.PAUSED)
        {
          if (!this.I) {
            break label126;
          }
          File localFile1 = new File(this.h, com.tencent.token.h.b(this.L));
          File localFile2 = new File(this.h, this.L);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          bool = localFile1.renameTo(localFile2);
          Q();
          if (bool) {
            this.X.a(DownloaderTaskStatus.COMPLETE);
          }
        }
        else
        {
          return;
        }
        a(false, -72, "", DownloaderTaskStatus.FAILED);
      }
      label126:
      boolean bool = true;
    }
  }
  
  private void W()
  {
    try
    {
      if ((this.O != null) && (this.Q != null) && (this.S != null))
      {
        this.O.b = this.Q.lastModified();
        this.O.c = this.j;
        this.O.d = this.o.get();
        if (!a(this.O.b())) {
          com.tencent.halley.common.c.c("TaskImpl", "saveRange...writeCfg false.");
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void X()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 360	com/tencent/halley/downloader/c/h:R	Ljava/io/RandomAccessFile;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 360	com/tencent/halley/downloader/c/h:R	Ljava/io/RandomAccessFile;
    //   15: invokevirtual 593	java/io/RandomAccessFile:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 360	com/tencent/halley/downloader/c/h:R	Ljava/io/RandomAccessFile;
    //   23: aload_0
    //   24: getfield 354	com/tencent/halley/downloader/c/h:T	Ljava/io/RandomAccessFile;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: getfield 354	com/tencent/halley/downloader/c/h:T	Ljava/io/RandomAccessFile;
    //   36: invokevirtual 593	java/io/RandomAccessFile:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 354	com/tencent/halley/downloader/c/h:T	Ljava/io/RandomAccessFile;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 594	java/io/IOException:printStackTrace	()V
    //   52: goto -34 -> 18
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 594	java/io/IOException:printStackTrace	()V
    //   65: goto -26 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	h
    //   6	23	1	localRandomAccessFile	RandomAccessFile
    //   47	2	1	localIOException1	java.io.IOException
    //   55	4	1	localObject	Object
    //   60	2	1	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   11	18	47	java/io/IOException
    //   2	7	55	finally
    //   11	18	55	finally
    //   18	23	55	finally
    //   23	28	55	finally
    //   32	39	55	finally
    //   39	44	55	finally
    //   48	52	55	finally
    //   61	65	55	finally
    //   32	39	60	java/io/IOException
  }
  
  private String Y()
  {
    for (;;)
    {
      try
      {
        if ((this.ak != null) && (this.ak.length() != 0)) {
          str1 = this.ak;
        }
      }
      catch (Exception localException1)
      {
        String str2;
        String str1 = "";
      }
      try
      {
        Log.e("TAG", "currentCfg = " + this.ak);
        str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          str2 = "";
        }
        return str2;
      }
      catch (Exception localException2)
      {
        break label86;
      }
      this.T.seek(0L);
      str1 = this.T.readUTF();
      continue;
      label86:
      localException1.printStackTrace();
      com.tencent.halley.common.c.a("TaskImpl", "readCfg fail.", localException1);
    }
  }
  
  private boolean a(long paramLong)
  {
    long l1;
    for (;;)
    {
      synchronized (getClass())
      {
        com.tencent.halley.common.c.b("TaskImpl", "initFileOnDetected...begin");
        this.F.put("point0", Long.valueOf(0L));
        l1 = System.currentTimeMillis();
        new File(this.h).mkdirs();
        if (!com.tencent.token.h.c(this.i))
        {
          this.L = com.tencent.halley.common.g.a(this.G.a.a, this.l, this.m, "");
          Object localObject1 = new File(this.h, com.tencent.token.h.b(this.L));
          Object localObject3 = new File(this.h, this.L);
          if ((((File)localObject1).exists()) || (((File)localObject3).exists()))
          {
            i1 = this.L.lastIndexOf(".");
            localObject1 = "";
            String str;
            if ((i1 > 0) && (this.L.length() > i1 + 1))
            {
              localObject3 = this.L.substring(0, i1);
              localObject1 = this.L.substring(i1);
              break;
              str = (String)localObject3 + "(" + i1 + ")" + (String)localObject1;
              File localFile1 = new File(this.h, com.tencent.token.h.b(str));
              File localFile2 = new File(this.h, str);
              if (localFile1.exists()) {
                break label1285;
              }
              if (localFile2.exists()) {
                break label1285;
              }
            }
            else
            {
              localObject3 = this.L;
              break;
            }
            this.L = str;
          }
          this.F.put("point1", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          l1 = System.currentTimeMillis();
          if (!this.I) {
            break label564;
          }
          this.Q = new File(this.h, com.tencent.token.h.b(this.L));
          this.S = new File(this.h, com.tencent.token.h.a(this.L));
        }
      }
      try
      {
        this.T = new i(this.S, "rw");
        this.F.put("point2", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        l1 = System.currentTimeMillis();
      }
      catch (Exception localException1)
      {
        boolean bool;
        com.tencent.halley.common.c.a("TaskImpl", "initFileOnDetected...create RandomAccessFile for cfgFile failed.", localException1);
        this.r = -49;
        this.s = ("initFileOnDetected...create RandomAccessFile of path:" + this.S.getAbsolutePath() + " fail.|" + localException1);
        if (com.tencent.halley.common.g.a(localException1)) {
          this.r = -12;
        }
        for (;;)
        {
          com.tencent.halley.common.c.c("TaskImpl", "initFileOnDetected...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
          X();
          return false;
          if (com.tencent.halley.common.g.b(localException1)) {
            this.r = -13;
          }
        }
      }
      try
      {
        this.R = new i(this.Q, "rw");
        this.F.put("point3", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        l1 = System.currentTimeMillis();
        bool = this.H;
        if (!bool) {}
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.r = -49;
        this.s = ("initFileOnDetected...create RandomAccessFile of path:" + this.Q.getAbsolutePath() + " fail.|" + localException2);
        if (com.tencent.halley.common.g.a(localException2)) {
          this.r = -12;
        }
        for (;;)
        {
          com.tencent.halley.common.c.c("TaskImpl", "initFileOnDetected...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
          X();
          return false;
          if (com.tencent.halley.common.g.b(localException2)) {
            this.r = -13;
          }
        }
      }
      try
      {
        this.R.setLength(paramLong);
        this.F.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        System.currentTimeMillis();
        com.tencent.halley.common.c.b("TaskImpl", "initFileOnDetected...end");
        return true;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        if (!this.h.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath())) {
          break label1292;
        }
      }
      this.L = this.i;
      continue;
      localObject2 = finally;
      throw localObject2;
      label564:
      this.Q = new File(this.h, this.L);
      continue;
      i1 = 1;
      label874:
      if (i1 != 0)
      {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
          break label1297;
        }
        i1 = 1;
        label892:
        if (i1 != 0)
        {
          l1 = com.tencent.halley.common.g.a();
          if (l1 <= 3L * paramLong / 2L)
          {
            this.r = -12;
            this.s = ("SDCard free space:" + l1 + ", need space:" + paramLong);
          }
        }
        for (;;)
        {
          this.s = (this.s + "|" + localException3);
          com.tencent.halley.common.c.c("TaskImpl", "initFileOnDetected...setLength Exception, _ret:" + this.r + ",_failInfo:" + this.s);
          return false;
          if (com.tencent.halley.common.g.a(localException3)) {
            return true;
          }
          this.r = -45;
          this.s = ("on SDCard, setting file length faill. length:" + paramLong + ",Exception Info:" + localException3);
          continue;
          this.r = -46;
          this.s = "SDCard is not ready.";
        }
      }
      label954:
      if (!this.h.startsWith(com.tencent.halley.common.h.a().getFilesDir().toString())) {
        break label1302;
      }
    }
    label1285:
    label1292:
    label1297:
    label1302:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        l1 = com.tencent.halley.common.g.b();
        if ((l1 <= 3L * paramLong / 2L) || (com.tencent.halley.common.g.a(localException3)))
        {
          this.r = -40;
          this.s = ("Phone data free space:" + l1 + ", need space:" + paramLong);
          break label954;
        }
        if (com.tencent.halley.common.g.a(localException3)) {
          return true;
        }
        this.r = -45;
        this.s = ("on Phone data, setting file length faill. length:" + paramLong + ",Exception Info:" + localException3);
        break label954;
      }
      this.r = -47;
      this.s = ("save dir not exists, dir:" + this.h);
      break label954;
      i1 = 2;
      break;
      i1 += 1;
      break;
      i1 = 0;
      break label874;
      i1 = 0;
      break label892;
    }
  }
  
  private boolean a(String paramString)
  {
    try
    {
      this.ak = paramString;
      this.T.seek(0L);
      this.T.writeUTF(paramString);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.tencent.halley.common.c.a("TaskImpl", "writeCfg fail. cfg:" + paramString, localException);
    }
    return false;
  }
  
  public final int A()
  {
    return this.X.e();
  }
  
  public final int B()
  {
    return this.aa;
  }
  
  public final boolean C()
  {
    return this.ab;
  }
  
  public final long D()
  {
    if (this.Z != null) {
      return this.Z.d();
    }
    return -1L;
  }
  
  public final int E()
  {
    if (this.Z != null) {
      return this.Z.e();
    }
    return -1;
  }
  
  public final long F()
  {
    if (this.P != null) {
      return this.P.a();
    }
    return 0L;
  }
  
  public final long G()
  {
    return this.f;
  }
  
  public final long H()
  {
    if (this.O != null) {
      return this.O.g();
    }
    return 0L;
  }
  
  public final String I()
  {
    if (this.ah != null) {
      return this.ah.a();
    }
    return "";
  }
  
  public final String J()
  {
    if (this.G != null) {
      return this.G.b();
    }
    return "";
  }
  
  public final String K()
  {
    if (this.ag != null)
    {
      j localj = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localj.a != null) {
        localStringBuilder.append(localj.a.g());
      }
      if (localj.b != null) {
        localStringBuilder.append(localj.b.g());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String L()
  {
    if (this.ag != null)
    {
      j localj = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localj.a != null) {
        localStringBuilder.append(localj.a.h());
      }
      if (localj.b != null) {
        localStringBuilder.append(localj.b.h());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String M()
  {
    if (this.ag != null)
    {
      j localj = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localj.a != null) {
        localStringBuilder.append(localj.a.i());
      }
      if (localj.b != null) {
        localStringBuilder.append(localj.b.i());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final void N()
  {
    if (!this.al) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.h, this.L);
    } while (!localFile.exists());
    try
    {
      this.D = d.a(localFile);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.aa < paramInt) {
      this.aa = paramInt;
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    if ((t()) && (this.ah != null))
    {
      long l1 = System.currentTimeMillis();
      this.ah.a(new ah(l1 - this.t, paramInt, paramString));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (w()) {
      return;
    }
    if ((!t()) && (paramBoolean))
    {
      Q();
      O();
      if (this.I) {
        P();
      }
    }
    if (paramBoolean) {
      this.Y = paramBoolean;
    }
    a(true, 0, "", DownloaderTaskStatus.DELETED);
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString, DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    com.tencent.halley.common.c.b("TaskImpl", "cancel task...key:" + this.n + ",isFromUser:" + paramBoolean + ",retCode:" + paramInt + ",failInfo:" + paramString + ",newStatus:" + paramDownloaderTaskStatus.name());
    this.V = true;
    this.M = paramBoolean;
    if (!this.M)
    {
      this.r = paramInt;
      this.s = paramString;
    }
    this.X.a(paramDownloaderTaskStatus);
    paramString = this.ag;
    try
    {
      if (paramString.a != null) {
        paramString.a.e();
      }
      if (paramString.b != null) {
        paramString.b.e();
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final boolean a()
  {
    return this.V;
  }
  
  public final long a_()
  {
    if (this.f > 0L) {
      return this.f;
    }
    if (this.g > 0L) {
      return this.g;
    }
    try
    {
      long l1 = this.O.a;
      return l1;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public final String b()
  {
    return this.n;
  }
  
  public final String c()
  {
    return this.G.a.a;
  }
  
  public final DownloaderTaskStatus d()
  {
    return this.X.a();
  }
  
  public final boolean e()
  {
    if (t()) {
      return U();
    }
    return false;
  }
  
  public final long f()
  {
    return this.K;
  }
  
  public final int g()
  {
    long l2 = a_();
    long l1 = l2;
    if (l2 == -1L)
    {
      l1 = l2;
      if (this.O != null) {
        l1 = this.O.a;
      }
    }
    if (l1 <= 0L) {
      return 0;
    }
    return (int)(this.K * 100L / l1);
  }
  
  public final String h()
  {
    return this.h;
  }
  
  public final String i()
  {
    return this.i;
  }
  
  public final String j()
  {
    return this.L;
  }
  
  public final void k()
  {
    DownloaderTaskStatus localDownloaderTaskStatus = this.X.a();
    com.tencent.halley.common.c.b("TaskImpl", "trying pause...key:" + this.n + ",url:" + c() + ", now status:" + localDownloaderTaskStatus);
    if ((localDownloaderTaskStatus == DownloaderTaskStatus.PENDING) || (localDownloaderTaskStatus == DownloaderTaskStatus.STARTED) || (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING))
    {
      a(true, 0, "", DownloaderTaskStatus.PAUSED);
      com.tencent.halley.common.c.c("TaskImpl", "cancel task:" + this.n);
    }
    try
    {
      if (this.ai != null) {
        this.ai.a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final boolean l()
  {
    synchronized (this.X)
    {
      DownloaderTaskStatus localDownloaderTaskStatus = this.X.a();
      com.tencent.halley.common.c.b("TaskImpl", "trying resume...key:" + this.n + ",url:" + c() + ", now status:" + localDownloaderTaskStatus);
      if ((localDownloaderTaskStatus == DownloaderTaskStatus.STARTED) || (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING) || (localDownloaderTaskStatus == DownloaderTaskStatus.COMPLETE) || (localDownloaderTaskStatus == DownloaderTaskStatus.PENDING)) {
        return true;
      }
      if ((localDownloaderTaskStatus == DownloaderTaskStatus.DELETED) || (this.X.d())) {
        return false;
      }
      this.M = false;
      this.V = false;
      this.k = true;
      this.q = 0;
      p();
      return true;
    }
  }
  
  public final int m()
  {
    return this.r;
  }
  
  public final String n()
  {
    try
    {
      String str = this.s;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean o()
  {
    return this.k;
  }
  
  /* Error */
  public final void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 281	java/lang/System:currentTimeMillis	()J
    //   4: putfield 169	com/tencent/halley/downloader/c/h:N	J
    //   7: ldc 241
    //   9: new 261	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 856
    //   16: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 150	com/tencent/halley/downloader/c/h:n	Ljava/lang/String;
    //   23: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 858
    //   29: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 248	com/tencent/halley/common/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 190	com/tencent/halley/downloader/c/h:X	Lcom/tencent/halley/downloader/c/b;
    //   42: getstatic 837	com/tencent/halley/downloader/DownloaderTaskStatus:PENDING	Lcom/tencent/halley/downloader/DownloaderTaskStatus;
    //   45: invokevirtual 553	com/tencent/halley/downloader/c/b:a	(Lcom/tencent/halley/downloader/DownloaderTaskStatus;)V
    //   48: aload_0
    //   49: invokevirtual 860	com/tencent/halley/downloader/c/h:z	()Z
    //   52: ifeq +48 -> 100
    //   55: aload_0
    //   56: invokestatic 865	com/tencent/token/ao:a	()Lcom/tencent/token/an;
    //   59: aload_0
    //   60: invokeinterface 870 2 0
    //   65: putfield 844	com/tencent/halley/downloader/c/h:ai	Lcom/tencent/token/am;
    //   68: ldc 241
    //   70: new 261	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 872
    //   77: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_0
    //   81: getfield 150	com/tencent/halley/downloader/c/h:n	Ljava/lang/String;
    //   84: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 874
    //   90: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 248	com/tencent/halley/common/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: return
    //   100: aload_0
    //   101: invokestatic 865	com/tencent/token/ao:a	()Lcom/tencent/token/an;
    //   104: aload_0
    //   105: invokeinterface 876 2 0
    //   110: putfield 844	com/tencent/halley/downloader/c/h:ai	Lcom/tencent/token/am;
    //   113: goto -45 -> 68
    //   116: astore_1
    //   117: new 878	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException
    //   120: dup
    //   121: new 261	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 651	java/lang/StringBuilder:<init>	()V
    //   128: aload_1
    //   129: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 879	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException:<init>	(Ljava/lang/String;)V
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	h
    //   116	13	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   7	68	116	java/lang/Exception
    //   68	99	116	java/lang/Exception
    //   100	113	116	java/lang/Exception
  }
  
  public final long q()
  {
    return this.g;
  }
  
  public final boolean r()
  {
    return com.tencent.token.h.c(this.i);
  }
  
  public final void run()
  {
    this.r = 0;
    this.s = "";
    this.t = System.currentTimeMillis();
    this.u = SystemClock.elapsedRealtime();
    this.aj = 0L;
    synchronized (this.ag)
    {
      this.g = -1L;
      this.x = false;
      this.A = -1;
      this.w = 0;
      this.W = 0;
      this.p.set(0L);
      com.tencent.halley.common.c.b("TaskImpl", "task " + this.n + " start run... url:" + c() + ",Thread:" + Thread.currentThread().getName());
      if (this.V)
      {
        com.tencent.halley.common.c.b("TaskImpl", "task stopped at the beginning. url:" + c() + ",Thread:" + Thread.currentThread().getName());
        return;
      }
    }
    this.X.b();
    this.P = new z();
    this.Z = new a(this);
    this.Z.a();
    boolean bool = S();
    this.X.a(DownloaderTaskStatus.STARTED);
    this.ah = new ag();
    a(o.e(), o.a);
    if (!bool)
    {
      a(false, this.r, this.s, DownloaderTaskStatus.FAILED);
      this.X.c();
      if (this.P != null) {
        this.P.c();
      }
      X();
      if (!this.Y) {
        break label415;
      }
      Q();
      O();
      if (this.I) {
        P();
      }
    }
    for (;;)
    {
      this.p.set(0L);
      this.ah = null;
      ??? = this.ag;
      ((j)???).a = null;
      ((j)???).b = null;
      return;
      if (this.O.e())
      {
        com.tencent.halley.common.c.b("TaskImpl", "checkAlreadyCompleted");
        V();
        break;
      }
      ??? = this.ag.b();
      if (((com.tencent.halley.common.g)???).a == 0) {
        break;
      }
      a(false, ((com.tencent.halley.common.g)???).a, ((com.tencent.halley.common.g)???).b, DownloaderTaskStatus.FAILED);
      break;
      label415:
      if (v()) {
        Q();
      }
    }
  }
  
  public final String s()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = new File(this.h, this.L).getAbsolutePath();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label24:
      break label24;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.h + "/" + this.L;
    }
    return localObject2;
  }
  
  public final boolean t()
  {
    return (this.X.a() == DownloaderTaskStatus.STARTED) || (this.X.a() == DownloaderTaskStatus.DOWNLOADING);
  }
  
  public final boolean u()
  {
    return this.X.a() == DownloaderTaskStatus.PENDING;
  }
  
  public final boolean v()
  {
    return this.X.a() == DownloaderTaskStatus.COMPLETE;
  }
  
  public final boolean w()
  {
    return this.X.a() == DownloaderTaskStatus.DELETED;
  }
  
  public final boolean x()
  {
    return this.X.a() == DownloaderTaskStatus.PAUSED;
  }
  
  public final boolean y()
  {
    return this.X.a() == DownloaderTaskStatus.FAILED;
  }
  
  public final boolean z()
  {
    return this.U;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.h
 * JD-Core Version:    0.7.0.1
 */