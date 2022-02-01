package com.tencent.halley.downloader.c;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.halley.common.f;
import com.tencent.halley.common.h;
import com.tencent.halley.downloader.DownloaderTaskPriority;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.d.a.a;
import com.tencent.token.aa;
import com.tencent.token.ab;
import com.tencent.token.ac;
import com.tencent.token.ad;
import com.tencent.token.ae;
import com.tencent.token.ae.a;
import com.tencent.token.ah;
import com.tencent.token.k;
import com.tencent.token.p;
import com.tencent.token.t;
import com.tencent.token.x;
import com.tencent.token.y;
import com.tencent.token.y.a;
import java.io.File;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class e
  implements com.tencent.halley.downloader.b, aa, t, Comparable, Runnable
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
  private d O;
  private y P;
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
  private b ag = new b((byte)0);
  private ae ah;
  private ah ai;
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
  
  public e(int paramInt, String paramString1, com.tencent.halley.downloader.c.d.b paramb, String paramString2, String paramString3, com.tencent.halley.downloader.c paramc, boolean paramBoolean, long paramLong)
  {
    com.tencent.halley.common.b.a("TaskImpl", "new BDTaskImpl()");
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
      paramString1.append(h.c());
      paramString1.append(h.d());
      paramString1.append(System.currentTimeMillis());
      paramString1.append(this.G.a.a);
      paramString1.append(h.b());
      this.n = com.tencent.halley.common.c.a(paramString1.toString());
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
      com.tencent.halley.common.b.b("TaskImpl", "deleteFile:" + localFile + ",result:" + bool);
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
      File localFile = new File(h(), k.b(this.L));
      if (localFile.exists()) {
        bool = localFile.delete();
      }
      com.tencent.halley.common.b.b("TaskImpl", "deleteFile:" + localFile + ",result:" + bool);
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
      File localFile = new File(this.h, k.a(this.L));
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
      this.T = new a(this.S, "rw");
      com.tencent.halley.common.b.b("TaskImpl", "initFileOnStart...create _cfgAccessFile");
      this.r = -12;
    }
    catch (Exception localException1)
    {
      try
      {
        this.R = new a(this.Q, "rw");
        return true;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.r = -49;
        this.s = ("initFileOnStart...create RandomAccessFile of path:" + this.Q.getAbsolutePath() + " fail.|" + localException2);
        if (!com.tencent.halley.common.e.a(localException2)) {
          break label281;
        }
      }
      localException1 = localException1;
      localException1.printStackTrace();
      com.tencent.halley.common.b.a("TaskImpl", "initFileOnStart...create RandomAccessFile for cfgFile failed.", localException1);
      this.r = -49;
      this.s = ("initFileOnStart...create RandomAccessFile of path:" + this.S.getAbsolutePath() + " fail.|" + localException1);
      if (com.tencent.halley.common.e.a(localException1)) {
        this.r = -12;
      }
      for (;;)
      {
        com.tencent.halley.common.b.c("TaskImpl", "initFileOnStart...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
        X();
        return false;
        if (com.tencent.halley.common.e.b(localException1)) {
          this.r = -13;
        }
      }
    }
    for (;;)
    {
      com.tencent.halley.common.b.c("TaskImpl", "initFileOnStart...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
      X();
      return false;
      label281:
      if (com.tencent.halley.common.e.b(localException2)) {
        this.r = -13;
      }
    }
  }
  
  private boolean S()
  {
    com.tencent.halley.common.b.b("TaskImpl", "initFileOnStart...begin");
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
          this.Q = new File(this.h, k.b(this.L));
          this.S = new File(this.h, k.a(this.L));
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
        if (k.c(this.i))
        {
          if (this.I) {}
          for (this.Q = new File(this.h, k.b(this.i));; this.Q = new File(this.h, this.i))
          {
            this.S = new File(this.h, k.a(this.i));
            i1 = 1;
            i2 = 0;
            break;
          }
          label270:
          Object localObject = Y();
          com.tencent.halley.common.b.b("TaskImpl", "initFileOnStart...readCfg:" + (String)localObject);
          this.O = new d((String)localObject);
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
                this.O = new d("");
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
          if (SystemClock.elapsedRealtime() - l2 > k.f)
          {
            bool = true;
            this.ac.getAndIncrement();
            break label114;
          }
          y.a locala = this.P.b();
          if (locala == null) {
            break label758;
          }
          ab localab = this.O.a(locala.a);
          if (localab == null)
          {
            a(false, -42, "inner error: getRange null for sectionId:" + locala.a, DownloaderTaskStatus.FAILED);
            return false;
          }
          if (localab.e != locala.b)
          {
            a(false, -42, "inner error: check offset fail for section:" + localab + ",buffer offset:" + locala.b + ",sectionId:" + locala.a, DownloaderTaskStatus.FAILED);
            return false;
          }
          try
          {
            if (this.R.getFilePointer() != locala.b) {
              this.R.seek(locala.b);
            }
            this.R.write(locala.c, 0, (int)locala.d);
            localab.e = (locala.b + locala.d);
            i1 = (int)(i2 + locala.d);
            locala.c = null;
            i2 = i1;
            if (!this.ae) {
              break;
            }
            i2 = i1;
            if (!x.a().h()) {
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
        com.tencent.halley.common.b.b("TaskImpl", "saveData fail.", localException);
        int i1 = -50;
        if (!this.Q.exists()) {
          i1 = -14;
        }
        for (;;)
        {
          a(false, i1, "saveData fail.|" + localException, DownloaderTaskStatus.FAILED);
          bool = false;
          break;
          if (com.tencent.halley.common.e.a(localException)) {
            i1 = -12;
          } else if (com.tencent.halley.common.e.b(localException)) {
            i1 = -17;
          }
        }
        if (this.g > 0L)
        {
          l2 = this.O.d();
          if (((l1 - this.aj <= k.h()) && (l2 != this.g)) || ((i2 > 0) && (!this.C))) {}
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
              com.tencent.halley.common.b.d("TaskImpl", "receivedLength > detectLength");
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
          File localFile1 = new File(this.h, k.b(this.L));
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
          com.tencent.halley.common.b.c("TaskImpl", "saveRange...writeCfg false.");
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
    //   3: getfield 360	com/tencent/halley/downloader/c/e:R	Ljava/io/RandomAccessFile;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 360	com/tencent/halley/downloader/c/e:R	Ljava/io/RandomAccessFile;
    //   15: invokevirtual 593	java/io/RandomAccessFile:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 360	com/tencent/halley/downloader/c/e:R	Ljava/io/RandomAccessFile;
    //   23: aload_0
    //   24: getfield 354	com/tencent/halley/downloader/c/e:T	Ljava/io/RandomAccessFile;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: getfield 354	com/tencent/halley/downloader/c/e:T	Ljava/io/RandomAccessFile;
    //   36: invokevirtual 593	java/io/RandomAccessFile:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 354	com/tencent/halley/downloader/c/e:T	Ljava/io/RandomAccessFile;
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
    //   0	68	0	this	e
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
      com.tencent.halley.common.b.a("TaskImpl", "readCfg fail.", localException1);
    }
  }
  
  private boolean a(long paramLong)
  {
    long l1;
    for (;;)
    {
      synchronized (getClass())
      {
        com.tencent.halley.common.b.b("TaskImpl", "initFileOnDetected...begin");
        this.F.put("point0", Long.valueOf(0L));
        l1 = System.currentTimeMillis();
        new File(this.h).mkdirs();
        if (!k.c(this.i))
        {
          this.L = com.tencent.halley.common.e.a(this.G.a.a, this.l, this.m, "");
          Object localObject1 = new File(this.h, k.b(this.L));
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
              File localFile1 = new File(this.h, k.b(str));
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
          this.Q = new File(this.h, k.b(this.L));
          this.S = new File(this.h, k.a(this.L));
        }
      }
      try
      {
        this.T = new a(this.S, "rw");
        this.F.put("point2", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        l1 = System.currentTimeMillis();
      }
      catch (Exception localException1)
      {
        boolean bool;
        com.tencent.halley.common.b.a("TaskImpl", "initFileOnDetected...create RandomAccessFile for cfgFile failed.", localException1);
        this.r = -49;
        this.s = ("initFileOnDetected...create RandomAccessFile of path:" + this.S.getAbsolutePath() + " fail.|" + localException1);
        if (com.tencent.halley.common.e.a(localException1)) {
          this.r = -12;
        }
        for (;;)
        {
          com.tencent.halley.common.b.c("TaskImpl", "initFileOnDetected...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
          X();
          return false;
          if (com.tencent.halley.common.e.b(localException1)) {
            this.r = -13;
          }
        }
      }
      try
      {
        this.R = new a(this.Q, "rw");
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
        if (com.tencent.halley.common.e.a(localException2)) {
          this.r = -12;
        }
        for (;;)
        {
          com.tencent.halley.common.b.c("TaskImpl", "initFileOnDetected...Exception, _ret:" + this.r + ",_failInfo:" + this.s);
          X();
          return false;
          if (com.tencent.halley.common.e.b(localException2)) {
            this.r = -13;
          }
        }
      }
      try
      {
        this.R.setLength(paramLong);
        this.F.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        System.currentTimeMillis();
        com.tencent.halley.common.b.b("TaskImpl", "initFileOnDetected...end");
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
          l1 = com.tencent.halley.common.e.a();
          if (l1 <= 3L * paramLong / 2L)
          {
            this.r = -12;
            this.s = ("SDCard free space:" + l1 + ", need space:" + paramLong);
          }
        }
        for (;;)
        {
          this.s = (this.s + "|" + localException3);
          com.tencent.halley.common.b.c("TaskImpl", "initFileOnDetected...setLength Exception, _ret:" + this.r + ",_failInfo:" + this.s);
          return false;
          if (com.tencent.halley.common.e.a(localException3)) {
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
      if (!this.h.startsWith(f.a().getFilesDir().toString())) {
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
        l1 = com.tencent.halley.common.e.b();
        if ((l1 <= 3L * paramLong / 2L) || (com.tencent.halley.common.e.a(localException3)))
        {
          this.r = -40;
          this.s = ("Phone data free space:" + l1 + ", need space:" + paramLong);
          break label954;
        }
        if (com.tencent.halley.common.e.a(localException3)) {
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
      com.tencent.halley.common.b.a("TaskImpl", "writeCfg fail. cfg:" + paramString, localException);
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
      b localb = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localb.a != null) {
        localStringBuilder.append(localb.a.g());
      }
      if (localb.b != null) {
        localStringBuilder.append(localb.b.g());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String L()
  {
    if (this.ag != null)
    {
      b localb = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localb.a != null) {
        localStringBuilder.append(localb.a.h());
      }
      if (localb.b != null) {
        localStringBuilder.append(localb.b.h());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String M()
  {
    if (this.ag != null)
    {
      b localb = this.ag;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localb.a != null) {
        localStringBuilder.append(localb.a.i());
      }
      if (localb.b != null) {
        localStringBuilder.append(localb.b.i());
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
      this.D = com.tencent.halley.common.c.a(localFile);
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
      this.ah.a(new ae.a(l1 - this.t, paramInt, paramString));
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
    com.tencent.halley.common.b.b("TaskImpl", "cancel task...key:" + this.n + ",isFromUser:" + paramBoolean + ",retCode:" + paramInt + ",failInfo:" + paramString + ",newStatus:" + paramDownloaderTaskStatus.name());
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
    com.tencent.halley.common.b.b("TaskImpl", "trying pause...key:" + this.n + ",url:" + c() + ", now status:" + localDownloaderTaskStatus);
    if ((localDownloaderTaskStatus == DownloaderTaskStatus.PENDING) || (localDownloaderTaskStatus == DownloaderTaskStatus.STARTED) || (localDownloaderTaskStatus == DownloaderTaskStatus.DOWNLOADING))
    {
      a(true, 0, "", DownloaderTaskStatus.PAUSED);
      com.tencent.halley.common.b.c("TaskImpl", "cancel task:" + this.n);
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
      com.tencent.halley.common.b.b("TaskImpl", "trying resume...key:" + this.n + ",url:" + c() + ", now status:" + localDownloaderTaskStatus);
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
    //   1: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   4: putfield 173	com/tencent/halley/downloader/c/e:N	J
    //   7: ldc 243
    //   9: new 263	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 856
    //   16: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 154	com/tencent/halley/downloader/c/e:n	Ljava/lang/String;
    //   23: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 858
    //   29: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 250	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 194	com/tencent/halley/downloader/c/e:X	Lcom/tencent/halley/downloader/c/b;
    //   42: getstatic 837	com/tencent/halley/downloader/DownloaderTaskStatus:PENDING	Lcom/tencent/halley/downloader/DownloaderTaskStatus;
    //   45: invokevirtual 553	com/tencent/halley/downloader/c/b:a	(Lcom/tencent/halley/downloader/DownloaderTaskStatus;)V
    //   48: aload_0
    //   49: invokevirtual 860	com/tencent/halley/downloader/c/e:z	()Z
    //   52: ifeq +48 -> 100
    //   55: aload_0
    //   56: invokestatic 865	com/tencent/token/aj:a	()Lcom/tencent/token/ai;
    //   59: aload_0
    //   60: invokeinterface 870 2 0
    //   65: putfield 844	com/tencent/halley/downloader/c/e:ai	Lcom/tencent/token/ah;
    //   68: ldc 243
    //   70: new 263	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 872
    //   77: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_0
    //   81: getfield 154	com/tencent/halley/downloader/c/e:n	Ljava/lang/String;
    //   84: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 874
    //   90: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 250	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: return
    //   100: aload_0
    //   101: invokestatic 865	com/tencent/token/aj:a	()Lcom/tencent/token/ai;
    //   104: aload_0
    //   105: invokeinterface 876 2 0
    //   110: putfield 844	com/tencent/halley/downloader/c/e:ai	Lcom/tencent/token/ah;
    //   113: goto -45 -> 68
    //   116: astore_1
    //   117: new 878	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException
    //   120: dup
    //   121: new 263	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 651	java/lang/StringBuilder:<init>	()V
    //   128: aload_1
    //   129: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 879	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException:<init>	(Ljava/lang/String;)V
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	e
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
    return k.c(this.i);
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
      com.tencent.halley.common.b.b("TaskImpl", "task " + this.n + " start run... url:" + c() + ",Thread:" + Thread.currentThread().getName());
      if (this.V)
      {
        com.tencent.halley.common.b.b("TaskImpl", "task stopped at the beginning. url:" + c() + ",Thread:" + Thread.currentThread().getName());
        return;
      }
    }
    this.X.b();
    this.P = new y();
    this.Z = new a(this);
    this.Z.a();
    boolean bool = S();
    this.X.a(DownloaderTaskStatus.STARTED);
    this.ah = new ae();
    a(p.e(), p.a);
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
      ((b)???).a = null;
      ((b)???).b = null;
      return;
      if (this.O.e())
      {
        com.tencent.halley.common.b.b("TaskImpl", "checkAlreadyCompleted");
        V();
        break;
      }
      ??? = this.ag.b();
      if (((com.tencent.halley.common.e)???).a == 0) {
        break;
      }
      a(false, ((com.tencent.halley.common.e)???).a, ((com.tencent.halley.common.e)???).b, DownloaderTaskStatus.FAILED);
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
  
  static final class a
    extends RandomAccessFile
  {
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
    
    protected final void finalize()
    {
      try
      {
        super.finalize();
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  final class b
    implements ac
  {
    ad a;
    ad b;
    
    private b() {}
    
    private boolean a(String paramString)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      if (e.a(e.this).a())
      {
        String str = e.b(e.this).c();
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString))
          {
            bool1 = bool2;
            if (!str.equals(paramString)) {
              bool1 = true;
            }
          }
        }
        Log.d("DownloadTest", "savedLM:" + str + ",newLM:" + paramString + ",fail:" + bool1);
      }
      return bool1;
    }
    
    public final com.tencent.halley.common.e a(ad paramad, com.tencent.halley.downloader.c.d.a parama, String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      if (paramad != null) {}
      for (;;)
      {
        int i;
        label55:
        com.tencent.halley.common.e locale;
        try
        {
          if (paramad != this.a)
          {
            if (paramad == this.b)
            {
              break label829;
              if ((i == 0) || (paramad.a()) || (paramLong <= 0L))
              {
                paramad = new com.tencent.halley.common.e(4, "");
                return paramad;
              }
            }
            else
            {
              i = 0;
              continue;
            }
            locale = new com.tencent.halley.common.e(0, "");
            if (e.b(e.this) != null)
            {
              d locald = e.b(e.this);
              if (paramad.a.i == locald)
              {
                i = 1;
                break label835;
              }
            }
            else
            {
              locale.a = 2;
              locale.b = "not the same divider";
              com.tencent.halley.common.b.c("TaskImpl", "onValidResponse... fail...not self section:" + paramad.a);
              paramad = locale;
              continue;
            }
            i = 0;
          }
        }
        finally {}
        label649:
        label796:
        label829:
        label835:
        while (i != 0)
        {
          if (e.this.g == -1L) {
            if ((e.this.f != -1L) && (paramLong != e.this.f))
            {
              locale.a = -10;
              locale.b = ("knownSize:" + e.this.f + ",rspLength:" + paramLong);
              if (locale.a == 0)
              {
                if ((!e.c(e.this)) && (!e.a(e.this, paramLong))) {
                  e.this.a(false, e.this.r, e.this.s, DownloaderTaskStatus.FAILED);
                }
                e.d(e.this).a(b.a.c);
              }
            }
          }
          for (;;)
          {
            paramad = locale;
            if (locale.a != 0) {
              break;
            }
            paramad = locale;
            if (TextUtils.isEmpty(paramString1)) {
              break;
            }
            if ((parama.b != a.a.b) && (parama.b != a.a.a)) {
              break label796;
            }
            e.a(e.this).a(p.a, paramString1);
            paramad = locale;
            break;
            e.this.g = paramLong;
            e.this.k = paramBoolean;
            e.this.l = paramString4;
            e.this.m = paramString5;
            if (paramad.b != null) {
              e.this.A = paramad.b.c;
            }
            if (!e.this.k)
            {
              e.a(e.this, new d(""));
              paramad.a = e.b(e.this).a();
            }
            for (;;)
            {
              e.b(e.this).a = paramLong;
              e.b(e.this).a(paramString2);
              e.b(e.this).b(paramString3);
              if ((paramad.a.c != -1) || (paramad.a.b != -1)) {
                break;
              }
              e.b(e.this).a(paramad.a);
              break;
              if (e.b(e.this).a > 0L)
              {
                i = 0;
                if (e.b(e.this).a != e.this.g) {
                  i = 1;
                }
                for (;;)
                {
                  if (i == 0) {
                    break label649;
                  }
                  e.a(e.this, new d(""));
                  locale.a = 3;
                  locale.b = "can not resume from cfg, start over now";
                  break;
                  if (a(paramString3)) {
                    i = 1;
                  }
                }
              }
            }
            if (paramLong != e.this.g)
            {
              locale.a = -43;
              locale.b = ("detectLength:" + e.this.g + ",rspLength:" + paramLong);
            }
            else if (!e.this.k)
            {
              locale.a = 1;
              locale.b = "not support range";
            }
            else if (a(paramString3))
            {
              locale.a = -68;
              locale.b = ("detected VerifyProperty:" + e.b(e.this).c() + ",rsp VerifyProperty:" + paramString3);
            }
          }
          paramad = locale;
          if (parama.b != a.a.g) {
            break label55;
          }
          e.a(e.this).b(p.a, paramString1);
          paramad = locale;
          break label55;
          i = 1;
          break;
        }
      }
    }
    
    public final ab a(ad paramad)
    {
      int i;
      if ((paramad != null) && ((paramad == this.a) || (paramad == this.b)))
      {
        i = 1;
        if (i != 0) {
          break label33;
        }
      }
      label33:
      while (!e.this.k)
      {
        return null;
        i = 0;
        break;
      }
      return e.b(e.this).a();
    }
    
    public final boolean a()
    {
      return e.this.g != -1L;
    }
    
    /* Error */
    public final boolean a(ad arg1, long paramLong, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 8
      //   3: aload_1
      //   4: ifnull +29 -> 33
      //   7: aload_1
      //   8: aload_0
      //   9: getfield 85	com/tencent/halley/downloader/c/e$b:a	Lcom/tencent/token/ad;
      //   12: if_acmpeq +11 -> 23
      //   15: aload_1
      //   16: aload_0
      //   17: getfield 87	com/tencent/halley/downloader/c/e$b:b	Lcom/tencent/token/ad;
      //   20: if_acmpne +13 -> 33
      //   23: iconst_1
      //   24: istore 7
      //   26: iload 7
      //   28: ifne +11 -> 39
      //   31: iconst_0
      //   32: ireturn
      //   33: iconst_0
      //   34: istore 7
      //   36: goto -10 -> 26
      //   39: iload 5
      //   41: ifle +31 -> 72
      //   44: aload_0
      //   45: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   48: getfield 255	com/tencent/halley/downloader/c/e:o	Ljava/util/concurrent/atomic/AtomicLong;
      //   51: iload 5
      //   53: i2l
      //   54: invokevirtual 261	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   57: pop2
      //   58: aload_0
      //   59: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   62: getfield 264	com/tencent/halley/downloader/c/e:p	Ljava/util/concurrent/atomic/AtomicLong;
      //   65: iload 5
      //   67: i2l
      //   68: invokevirtual 261	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   71: pop2
      //   72: aload_0
      //   73: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   76: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   79: ifnull +32 -> 111
      //   82: aload_0
      //   83: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   86: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   89: astore 9
      //   91: aload_1
      //   92: getfield 100	com/tencent/token/ad:a	Lcom/tencent/token/ab;
      //   95: getfield 106	com/tencent/token/ab:i	Lcom/tencent/halley/downloader/c/d;
      //   98: aload 9
      //   100: if_acmpne +13 -> 113
      //   103: iconst_1
      //   104: istore 7
      //   106: iload 7
      //   108: ifne +11 -> 119
      //   111: iconst_0
      //   112: ireturn
      //   113: iconst_0
      //   114: istore 7
      //   116: goto -10 -> 106
      //   119: iload 6
      //   121: ifeq +148 -> 269
      //   124: aload_0
      //   125: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   128: iconst_0
      //   129: putfield 267	com/tencent/halley/downloader/c/e:w	I
      //   132: ldc 55
      //   134: new 57	java/lang/StringBuilder
      //   137: dup
      //   138: ldc_w 269
      //   141: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   144: aload_1
      //   145: invokevirtual 271	com/tencent/token/ad:b	()Z
      //   148: invokevirtual 73	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   151: ldc_w 273
      //   154: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   157: aload_1
      //   158: getfield 100	com/tencent/token/ad:a	Lcom/tencent/token/ab;
      //   161: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   164: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   167: invokestatic 274	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   170: aload_1
      //   171: getfield 100	com/tencent/token/ad:a	Lcom/tencent/token/ab;
      //   174: getfield 226	com/tencent/token/ab:b	I
      //   177: iconst_m1
      //   178: if_icmpne +91 -> 269
      //   181: aload_0
      //   182: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   185: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   188: aload_1
      //   189: getfield 100	com/tencent/token/ad:a	Lcom/tencent/token/ab;
      //   192: invokevirtual 229	com/tencent/halley/downloader/c/d:a	(Lcom/tencent/token/ab;)Z
      //   195: istore 6
      //   197: ldc 55
      //   199: new 57	java/lang/StringBuilder
      //   202: dup
      //   203: ldc_w 269
      //   206: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   209: aload_1
      //   210: invokevirtual 271	com/tencent/token/ad:b	()Z
      //   213: invokevirtual 73	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   216: ldc_w 276
      //   219: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   222: aload_1
      //   223: getfield 100	com/tencent/token/ad:a	Lcom/tencent/token/ab;
      //   226: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   229: ldc_w 278
      //   232: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   235: iload 6
      //   237: invokevirtual 73	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   240: ldc_w 280
      //   243: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   246: aload_0
      //   247: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   250: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   253: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   256: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   259: invokestatic 126	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   262: iload 6
      //   264: ifne +5 -> 269
      //   267: iconst_0
      //   268: ireturn
      //   269: iload 5
      //   271: ifle +205 -> 476
      //   274: aload_0
      //   275: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   278: invokevirtual 283	com/tencent/halley/downloader/c/e:x	()Z
      //   281: ifne +195 -> 476
      //   284: aload_0
      //   285: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   288: invokestatic 287	com/tencent/halley/downloader/c/e:e	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/token/y;
      //   291: aload_1
      //   292: getfield 100	com/tencent/token/ad:a	Lcom/tencent/token/ab;
      //   295: getfield 226	com/tencent/token/ab:b	I
      //   298: lload_2
      //   299: aload 4
      //   301: iload 5
      //   303: i2l
      //   304: invokevirtual 292	com/tencent/token/y:a	(IJ[BJ)V
      //   307: aload_1
      //   308: getfield 100	com/tencent/token/ad:a	Lcom/tencent/token/ab;
      //   311: astore_1
      //   312: aload_1
      //   313: aload_1
      //   314: getfield 293	com/tencent/token/ab:f	J
      //   317: iload 5
      //   319: i2l
      //   320: ladd
      //   321: putfield 293	com/tencent/token/ab:f	J
      //   324: aload_0
      //   325: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   328: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   331: astore_1
      //   332: aload_1
      //   333: invokevirtual 296	com/tencent/halley/downloader/c/d:f	()J
      //   336: lstore_2
      //   337: iload 8
      //   339: istore 5
      //   341: lload_2
      //   342: lconst_0
      //   343: lcmp
      //   344: ifle +19 -> 363
      //   347: iload 8
      //   349: istore 5
      //   351: lload_2
      //   352: aload_1
      //   353: getfield 219	com/tencent/halley/downloader/c/d:a	J
      //   356: lcmp
      //   357: ifne +6 -> 363
      //   360: iconst_1
      //   361: istore 5
      //   363: iload 5
      //   365: ifeq +19 -> 384
      //   368: aload_0
      //   369: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   372: invokestatic 299	com/tencent/halley/downloader/c/e:f	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/a;
      //   375: invokevirtual 303	com/tencent/halley/downloader/c/a:b	()V
      //   378: invokestatic 308	com/tencent/token/x:a	()Lcom/tencent/token/x;
      //   381: invokevirtual 309	com/tencent/token/x:b	()V
      //   384: invokestatic 308	com/tencent/token/x:a	()Lcom/tencent/token/x;
      //   387: invokevirtual 311	com/tencent/token/x:g	()Z
      //   390: ifeq +86 -> 476
      //   393: aload_0
      //   394: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   397: iconst_1
      //   398: invokestatic 314	com/tencent/halley/downloader/c/e:a	(Lcom/tencent/halley/downloader/c/e;Z)Z
      //   401: pop
      //   402: invokestatic 308	com/tencent/token/x:a	()Lcom/tencent/token/x;
      //   405: invokevirtual 309	com/tencent/token/x:b	()V
      //   408: ldc 116
      //   410: new 57	java/lang/StringBuilder
      //   413: dup
      //   414: ldc_w 316
      //   417: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   420: aload_0
      //   421: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   424: getfield 319	com/tencent/halley/downloader/c/e:n	Ljava/lang/String;
      //   427: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   430: ldc_w 321
      //   433: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   436: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   439: invokestatic 126	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   442: aload_0
      //   443: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   446: iconst_1
      //   447: invokestatic 323	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;Z)Z
      //   450: pop
      //   451: aload_0
      //   452: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   455: invokestatic 326	com/tencent/halley/downloader/c/e:g	(Lcom/tencent/halley/downloader/c/e;)Ljava/lang/Object;
      //   458: astore_1
      //   459: aload_1
      //   460: monitorenter
      //   461: aload_0
      //   462: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   465: invokestatic 326	com/tencent/halley/downloader/c/e:g	(Lcom/tencent/halley/downloader/c/e;)Ljava/lang/Object;
      //   468: ldc2_w 327
      //   471: invokevirtual 332	java/lang/Object:wait	(J)V
      //   474: aload_1
      //   475: monitorexit
      //   476: iconst_1
      //   477: ireturn
      //   478: astore_1
      //   479: aload_1
      //   480: invokevirtual 335	java/lang/OutOfMemoryError:printStackTrace	()V
      //   483: aload_0
      //   484: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   487: iconst_0
      //   488: bipush 237
      //   490: new 57	java/lang/StringBuilder
      //   493: dup
      //   494: ldc_w 337
      //   497: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   500: iload 5
      //   502: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   505: ldc_w 342
      //   508: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   511: invokestatic 308	com/tencent/token/x:a	()Lcom/tencent/token/x;
      //   514: invokevirtual 343	com/tencent/token/x:f	()J
      //   517: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   520: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   523: getstatic 160	com/tencent/halley/downloader/DownloaderTaskStatus:FAILED	Lcom/tencent/halley/downloader/DownloaderTaskStatus;
      //   526: invokevirtual 163	com/tencent/halley/downloader/c/e:a	(ZILjava/lang/String;Lcom/tencent/halley/downloader/DownloaderTaskStatus;)V
      //   529: iconst_0
      //   530: ireturn
      //   531: astore 4
      //   533: aload_1
      //   534: monitorexit
      //   535: aload 4
      //   537: athrow
      //   538: astore_1
      //   539: goto -63 -> 476
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	542	0	this	b
      //   0	542	2	paramLong	long
      //   0	542	4	paramArrayOfByte	byte[]
      //   0	542	5	paramInt	int
      //   0	542	6	paramBoolean	boolean
      //   24	91	7	i	int
      //   1	347	8	j	int
      //   89	10	9	locald	d
      // Exception table:
      //   from	to	target	type
      //   284	307	478	java/lang/OutOfMemoryError
      //   461	476	531	finally
      //   442	461	538	java/lang/Exception
      //   533	538	538	java/lang/Exception
    }
    
    /* Error */
    public final com.tencent.halley.common.e b()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new 92	com/tencent/halley/common/e
      //   5: dup
      //   6: iconst_0
      //   7: ldc 94
      //   9: invokespecial 97	com/tencent/halley/common/e:<init>	(ILjava/lang/String;)V
      //   12: astore_1
      //   13: aload_0
      //   14: new 89	com/tencent/token/ad
      //   17: dup
      //   18: aload_0
      //   19: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   22: invokestatic 28	com/tencent/halley/downloader/c/e:a	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d/b;
      //   25: iconst_1
      //   26: aload_0
      //   27: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   30: getfield 135	com/tencent/halley/downloader/c/e:f	J
      //   33: aload_0
      //   34: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   37: aload_0
      //   38: aload_0
      //   39: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   42: getfield 347	com/tencent/halley/downloader/c/e:e	Ljava/util/Map;
      //   45: aload_0
      //   46: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   49: getfield 350	com/tencent/halley/downloader/c/e:C	Z
      //   52: invokespecial 353	com/tencent/token/ad:<init>	(Lcom/tencent/halley/downloader/c/d/b;ZJLcom/tencent/token/t;Lcom/tencent/token/ac;Ljava/util/Map;Z)V
      //   55: putfield 85	com/tencent/halley/downloader/c/e$b:a	Lcom/tencent/token/ad;
      //   58: invokestatic 358	com/tencent/token/aj:a	()Lcom/tencent/token/ai;
      //   61: aload_0
      //   62: getfield 85	com/tencent/halley/downloader/c/e$b:a	Lcom/tencent/token/ad;
      //   65: invokeinterface 363 2 0
      //   70: pop
      //   71: aload_1
      //   72: getfield 109	com/tencent/halley/common/e:a	I
      //   75: ifne +71 -> 146
      //   78: aload_0
      //   79: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   82: invokevirtual 366	com/tencent/halley/downloader/c/e:z	()Z
      //   85: ifne +61 -> 146
      //   88: aload_0
      //   89: new 89	com/tencent/token/ad
      //   92: dup
      //   93: aload_0
      //   94: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   97: invokestatic 28	com/tencent/halley/downloader/c/e:a	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d/b;
      //   100: iconst_0
      //   101: aload_0
      //   102: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   105: getfield 135	com/tencent/halley/downloader/c/e:f	J
      //   108: aload_0
      //   109: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   112: aload_0
      //   113: aload_0
      //   114: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   117: getfield 347	com/tencent/halley/downloader/c/e:e	Ljava/util/Map;
      //   120: aload_0
      //   121: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   124: getfield 350	com/tencent/halley/downloader/c/e:C	Z
      //   127: invokespecial 353	com/tencent/token/ad:<init>	(Lcom/tencent/halley/downloader/c/d/b;ZJLcom/tencent/token/t;Lcom/tencent/token/ac;Ljava/util/Map;Z)V
      //   130: putfield 87	com/tencent/halley/downloader/c/e$b:b	Lcom/tencent/token/ad;
      //   133: invokestatic 358	com/tencent/token/aj:a	()Lcom/tencent/token/ai;
      //   136: aload_0
      //   137: getfield 87	com/tencent/halley/downloader/c/e$b:b	Lcom/tencent/token/ad;
      //   140: invokeinterface 368 2 0
      //   145: pop
      //   146: aload_0
      //   147: monitorexit
      //   148: aload_1
      //   149: areturn
      //   150: astore_2
      //   151: aload_0
      //   152: aconst_null
      //   153: putfield 85	com/tencent/halley/downloader/c/e$b:a	Lcom/tencent/token/ad;
      //   156: aload_1
      //   157: bipush 189
      //   159: putfield 109	com/tencent/halley/common/e:a	I
      //   162: aload_2
      //   163: invokevirtual 369	java/lang/Exception:printStackTrace	()V
      //   166: goto -95 -> 71
      //   169: astore_1
      //   170: aload_0
      //   171: monitorexit
      //   172: aload_1
      //   173: athrow
      //   174: astore_2
      //   175: aload_0
      //   176: aconst_null
      //   177: putfield 87	com/tencent/halley/downloader/c/e$b:b	Lcom/tencent/token/ad;
      //   180: goto -34 -> 146
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	183	0	this	b
      //   12	145	1	locale	com.tencent.halley.common.e
      //   169	4	1	localObject	Object
      //   150	13	2	localException1	Exception
      //   174	1	2	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   58	71	150	java/lang/Exception
      //   2	58	169	finally
      //   58	71	169	finally
      //   71	133	169	finally
      //   133	146	169	finally
      //   151	166	169	finally
      //   175	180	169	finally
      //   133	146	174	java/lang/Exception
    }
    
    public final void b(ad paramad)
    {
      int i;
      if ((paramad != null) && ((paramad == this.a) || (paramad == this.b)))
      {
        i = 1;
        if (i != 0) {
          break label32;
        }
      }
      label32:
      while (paramad.a == null)
      {
        return;
        i = 0;
        break;
      }
      e.b(e.this);
      paramad.a.h = false;
    }
    
    public final void c(ad paramad)
    {
      int j = 1;
      if ((paramad != null) && ((paramad == this.a) || (paramad == this.b))) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      for (;;)
      {
        synchronized (e.h(e.this))
        {
          if ((this.a != null) && (!this.a.f()))
          {
            i = 0;
            if (i == 0) {
              break;
            }
            com.tencent.halley.common.b.c("TaskImpl", "All Transports Finished, task:" + e.this.b());
            if (e.i(e.this)) {
              break;
            }
            ??? = e.b(e.this);
            long l = ((d)???).f();
            if ((l <= 0L) || (l != ((d)???).a)) {
              break label280;
            }
            i = j;
            if (i != 0) {
              break;
            }
            e.this.r = paramad.c();
            e.this.s = paramad.d();
            if (e.this.r == 0)
            {
              e.this.r = -69;
              e.this.s = ("readLen:" + e.b(e.this).f());
            }
            e.d(e.this).a(DownloaderTaskStatus.FAILED);
            return;
          }
          if ((!e.this.C) || (this.b == null)) {
            break label285;
          }
          boolean bool = this.b.f();
          if (bool) {
            break label285;
          }
          i = 0;
        }
        label280:
        i = 0;
        continue;
        label285:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.e
 * JD-Core Version:    0.7.0.1
 */