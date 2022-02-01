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
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import com.tencent.token.ab;
import com.tencent.token.ac;
import com.tencent.token.ad;
import com.tencent.token.ae;
import com.tencent.token.af;
import com.tencent.token.af.a;
import com.tencent.token.ai;
import com.tencent.token.aj;
import com.tencent.token.ak;
import com.tencent.token.l;
import com.tencent.token.q;
import com.tencent.token.u;
import com.tencent.token.y;
import com.tencent.token.z;
import com.tencent.token.z.a;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class e
  implements com.tencent.halley.downloader.b, ab, u, Comparable, Runnable
{
  public int A;
  public long B;
  public boolean C;
  public String D;
  public int E;
  public volatile HashMap F;
  private com.tencent.halley.downloader.c.d.b G;
  private boolean H = true;
  private boolean I = true;
  private volatile DownloaderTaskPriority J = DownloaderTaskPriority.NORMAL;
  private volatile long K;
  private String L;
  private boolean M;
  private long N;
  private d O;
  private z P;
  private File Q;
  private RandomAccessFile R;
  private File S;
  private RandomAccessFile T;
  private volatile boolean U;
  private volatile boolean V;
  private volatile int W;
  private b X;
  private boolean Y;
  private a Z;
  public int a = -1;
  private int aa;
  private volatile boolean ab;
  private AtomicInteger ac;
  private Object ad;
  private volatile boolean ae;
  private boolean af;
  private b ag;
  private af ah;
  private ai ai;
  private long aj;
  private String ak;
  private boolean al;
  public String b = "";
  public String c = "";
  public String d = "";
  public Map e = new HashMap();
  public long f;
  public volatile long g;
  public String h;
  public String i;
  public volatile long j;
  public volatile boolean k;
  public String l;
  public String m;
  public String n;
  public AtomicLong o;
  public AtomicLong p;
  public volatile int q;
  public volatile int r;
  public String s;
  public long t;
  public long u;
  public long v;
  public volatile int w;
  public boolean x;
  public String y;
  public String z;
  
  public e(int paramInt, String paramString1, com.tencent.halley.downloader.c.d.b paramb, String paramString2, String paramString3, com.tencent.halley.downloader.c paramc, boolean paramBoolean, long paramLong)
  {
    long l1 = -1L;
    this.f = -1L;
    this.g = -1L;
    this.K = 0L;
    this.h = "";
    this.i = "";
    this.L = "";
    this.j = 0L;
    this.k = true;
    this.l = "";
    this.m = "";
    this.n = null;
    this.o = new AtomicLong(0L);
    this.p = new AtomicLong(0L);
    this.q = 0;
    this.M = false;
    this.r = 0;
    this.s = "";
    this.N = -1L;
    this.t = -1L;
    this.u = -1L;
    this.v = -1L;
    this.U = false;
    this.V = false;
    this.w = 0;
    this.W = 0;
    this.X = new b(this);
    this.Y = false;
    this.aa = 0;
    this.ab = false;
    this.ac = new AtomicInteger(0);
    this.ad = new Object();
    this.ae = false;
    this.x = false;
    this.y = "";
    this.af = false;
    this.ag = new b((byte)0);
    this.A = -1;
    this.B = 0L;
    this.aj = 0L;
    this.C = true;
    this.ak = "";
    this.al = false;
    this.E = 0;
    this.F = new LinkedHashMap();
    com.tencent.halley.common.b.a("TaskImpl", "new BDTaskImpl()");
    this.a = paramInt;
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    this.b = paramString1;
    this.G = paramb;
    this.h = paramString2;
    this.i = paramString3;
    this.X.a(paramc);
    this.U = paramBoolean;
    if (paramLong > 0L) {
      l1 = paramLong;
    }
    this.f = l1;
    paramString1 = new StringBuilder("");
    paramString1.append(h.c());
    paramString1.append(h.d());
    paramString1.append(System.currentTimeMillis());
    paramString1.append(this.G.a.a);
    paramString1.append(h.b());
    this.n = com.tencent.halley.common.c.a(paramString1.toString());
  }
  
  private boolean O()
  {
    try
    {
      localFile = new File(s());
      if (!localFile.exists()) {
        break label75;
      }
      bool = localFile.delete();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        File localFile;
        StringBuilder localStringBuilder;
        continue;
        label75:
        boolean bool = true;
      }
    }
    localStringBuilder = new StringBuilder("deleteFile:");
    localStringBuilder.append(localFile);
    localStringBuilder.append(",result:");
    localStringBuilder.append(bool);
    com.tencent.halley.common.b.b("TaskImpl", localStringBuilder.toString());
    return bool;
    return false;
  }
  
  private boolean P()
  {
    try
    {
      localFile = new File(h(), l.b(this.L));
      if (!localFile.exists()) {
        break label82;
      }
      bool = localFile.delete();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        File localFile;
        StringBuilder localStringBuilder;
        continue;
        label82:
        boolean bool = true;
      }
    }
    localStringBuilder = new StringBuilder("deleteFile:");
    localStringBuilder.append(localFile);
    localStringBuilder.append(",result:");
    localStringBuilder.append(bool);
    com.tencent.halley.common.b.b("TaskImpl", localStringBuilder.toString());
    return bool;
    return false;
  }
  
  private boolean Q()
  {
    try
    {
      File localFile = new File(this.h, l.a(this.L));
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        return bool;
      }
      return true;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    return false;
  }
  
  private boolean R()
  {
    try
    {
      this.T = new a(this.S, "rw");
      com.tencent.halley.common.b.b("TaskImpl", "initFileOnStart...create _cfgAccessFile");
      try
      {
        this.R = new a(this.Q, "rw");
        return true;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.r = -49;
        localStringBuilder3 = new StringBuilder("initFileOnStart...create RandomAccessFile of path:");
        localStringBuilder3.append(this.Q.getAbsolutePath());
        localStringBuilder3.append(" fail.|");
        localStringBuilder3.append(localException1);
        this.s = localStringBuilder3.toString();
        if (com.tencent.halley.common.e.a(localException1)) {
          this.r = -12;
        } else if (com.tencent.halley.common.e.b(localException1)) {
          this.r = -13;
        }
        localStringBuilder1 = new StringBuilder("initFileOnStart...Exception, _ret:");
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        StringBuilder localStringBuilder1;
        localException2.printStackTrace();
        com.tencent.halley.common.b.a("TaskImpl", "initFileOnStart...create RandomAccessFile for cfgFile failed.", localException2);
        this.r = -49;
        StringBuilder localStringBuilder3 = new StringBuilder("initFileOnStart...create RandomAccessFile of path:");
        localStringBuilder3.append(this.S.getAbsolutePath());
        localStringBuilder3.append(" fail.|");
        localStringBuilder3.append(localException2);
        this.s = localStringBuilder3.toString();
        if (com.tencent.halley.common.e.a(localException2)) {
          this.r = -12;
        } else if (com.tencent.halley.common.e.b(localException2)) {
          this.r = -13;
        }
        StringBuilder localStringBuilder2 = new StringBuilder("initFileOnStart...Exception, _ret:");
      }
    }
    localStringBuilder1.append(this.r);
    localStringBuilder1.append(",_failInfo:");
    localStringBuilder1.append(this.s);
    com.tencent.halley.common.b.c("TaskImpl", localStringBuilder1.toString());
    X();
    return false;
  }
  
  private boolean S()
  {
    com.tencent.halley.common.b.b("TaskImpl", "initFileOnStart...begin");
    try
    {
      new File(this.h).mkdirs();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.Q = null;
    this.S = null;
    Object localObject = this.O;
    if (localObject != null)
    {
      if ((((d)localObject).d() > 0L) && (!TextUtils.isEmpty(this.L)))
      {
        if (this.I) {
          localObject = new File(this.h, l.b(this.L));
        } else {
          localObject = new File(this.h, this.L);
        }
        this.Q = ((File)localObject);
        this.S = new File(this.h, l.a(this.L));
        i1 = 1;
        break label248;
      }
    }
    else if (l.c(this.i))
    {
      if (this.I) {
        localObject = new File(this.h, l.b(this.i));
      } else {
        localObject = new File(this.h, this.i);
      }
      this.Q = ((File)localObject);
      this.S = new File(this.h, l.a(this.i));
      i1 = 0;
      i2 = 1;
      break label250;
    }
    int i1 = 0;
    label248:
    int i2 = 0;
    label250:
    boolean bool2;
    if (((i1 != 0) || (i2 != 0)) && (this.Q.exists()))
    {
      if (!R()) {
        return false;
      }
      localObject = Y();
      StringBuilder localStringBuilder = new StringBuilder("initFileOnStart...readCfg:");
      localStringBuilder.append((String)localObject);
      com.tencent.halley.common.b.b("TaskImpl", localStringBuilder.toString());
      this.O = new d((String)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.O.e))
      {
        long l1 = this.Q.lastModified();
        boolean bool1;
        if (((i2 != 0) && (l1 >= this.O.b) && (this.O.a > 0L) && (this.O.d() <= this.O.a)) || ((i1 != 0) && (l1 >= this.O.b))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1)
        {
          if (TextUtils.isEmpty(this.L)) {
            this.L = this.i;
          }
          this.j = this.O.c;
          this.o.set(this.O.d);
          bool2 = bool1;
          if (i2 != 0)
          {
            bool2 = bool1;
            if (this.O.a > 0L)
            {
              this.x = true;
              bool2 = bool1;
            }
          }
        }
        else
        {
          localStringBuilder = new StringBuilder("resume failed. cfg:");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",flm:");
          localStringBuilder.append(l1);
          localStringBuilder.append(",from:");
          localStringBuilder.append(i2 ^ 0x1);
          this.y = localStringBuilder.toString();
          bool2 = bool1;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder("resume failed. cfg:");
        localStringBuilder.append((String)localObject);
        this.y = localStringBuilder.toString();
      }
    }
    else
    {
      bool2 = false;
    }
    if (!bool2)
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
    this.af = bool2;
    return true;
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
    long l2;
    boolean bool;
    label464:
    Object localObject1;
    label480:
    label483:
    long l1;
    if ((!this.V) && (!x()) && (!w()) && (!v()) && (!y()))
    {
      l2 = SystemClock.elapsedRealtime();
      int i2 = 0;
      for (;;)
      {
        if ((this.V) || (x()) || (w()) || (v()) || (y())) {
          break label464;
        }
        if (SystemClock.elapsedRealtime() - l2 > l.f)
        {
          bool = true;
          this.ac.getAndIncrement();
          break label483;
        }
        localObject2 = this.P.b();
        if (localObject2 == null) {
          break label480;
        }
        ac localac = this.O.a(((z.a)localObject2).a);
        StringBuilder localStringBuilder;
        if (localac == null) {
          localStringBuilder = new StringBuilder("inner error: getRange null for sectionId:");
        }
        for (;;)
        {
          localStringBuilder.append(((z.a)localObject2).a);
          a(false, -42, localStringBuilder.toString(), DownloaderTaskStatus.FAILED);
          return false;
          if (localac.e == ((z.a)localObject2).b) {
            break;
          }
          localStringBuilder = new StringBuilder("inner error: check offset fail for section:");
          localStringBuilder.append(localac);
          localStringBuilder.append(",buffer offset:");
          localStringBuilder.append(((z.a)localObject2).b);
          localStringBuilder.append(",sectionId:");
        }
        try
        {
          if (this.R.getFilePointer() != ((z.a)localObject2).b) {
            this.R.seek(((z.a)localObject2).b);
          }
          this.R.write(((z.a)localObject2).c, 0, (int)((z.a)localObject2).d);
          localac.e = (((z.a)localObject2).b + ((z.a)localObject2).d);
          i1 = (int)(i2 + ((z.a)localObject2).d);
          ((z.a)localObject2).c = null;
          i2 = i1;
          if (this.ae)
          {
            i2 = i1;
            if (y.a().h())
            {
              T();
              i2 = i1;
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if ((localException instanceof NullPointerException)) {
            break label480;
          }
        }
      }
      com.tencent.halley.common.b.b("TaskImpl", "saveData fail.", localException);
      int i1 = -50;
      if (!this.Q.exists()) {
        i1 = -14;
      } else if (com.tencent.halley.common.e.a(localException)) {
        i1 = -12;
      } else if (com.tencent.halley.common.e.b(localException)) {
        i1 = -17;
      }
      Object localObject2 = new StringBuilder("saveData fail.|");
      ((StringBuilder)localObject2).append(localException);
      a(false, i1, ((StringBuilder)localObject2).toString(), DownloaderTaskStatus.FAILED);
      break label480;
      localObject1 = this.P;
      if (localObject1 != null) {
        ((z)localObject1).c();
      }
      bool = false;
      if (!bool) {
        T();
      }
      l1 = SystemClock.elapsedRealtime();
      localObject1 = this.Z;
      if (localObject1 != null) {
        ((a)localObject1).a(i2, (int)(l1 - l2));
      }
      if (i2 > 0) {
        W();
      }
      if ((!this.V) && (!x()) && (!w()) && (!v()) && (!y()))
      {
        if (this.g <= 0L) {
          break label761;
        }
        l2 = this.O.d();
        if (((l1 - this.aj > l.h()) || (l2 == this.g)) && ((i2 <= 0) || (this.C))) {}
      }
    }
    try
    {
      this.R.getFD().sync();
      label627:
      this.K = l2;
      this.X.a(DownloaderTaskStatus.DOWNLOADING);
      this.aj = l1;
      if (l2 == this.g)
      {
        this.Z.c();
        this.v = l1;
        V();
        return bool;
      }
      if (l2 > this.g)
      {
        com.tencent.halley.common.b.d("TaskImpl", "receivedLength > detectLength");
        localObject1 = new StringBuilder("inner error: receivedLength > detectLength:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(" > ");
        ((StringBuilder)localObject1).append(this.g);
        a(false, -42, ((StringBuilder)localObject1).toString(), DownloaderTaskStatus.FAILED);
        Q();
        return bool;
        X();
      }
      label761:
      return bool;
      localObject1 = this.P;
      if (localObject1 != null) {
        ((z)localObject1).c();
      }
      X();
      return false;
    }
    catch (Throwable localThrowable)
    {
      break label627;
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
            break label129;
          }
          File localFile1 = new File(this.h, l.b(this.L));
          File localFile2 = new File(this.h, this.L);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          bool = localFile1.renameTo(localFile2);
          Q();
          if (bool) {
            this.X.a(DownloaderTaskStatus.COMPLETE);
          } else {
            a(false, -72, "", DownloaderTaskStatus.FAILED);
          }
        }
        return;
      }
      label129:
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
  
  private void X()
  {
    try
    {
      RandomAccessFile localRandomAccessFile1 = this.R;
      if (localRandomAccessFile1 != null)
      {
        try
        {
          this.R.close();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
        this.R = null;
      }
      RandomAccessFile localRandomAccessFile2 = this.T;
      if (localRandomAccessFile2 != null)
      {
        try
        {
          this.T.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        this.T = null;
      }
      return;
    }
    finally {}
  }
  
  private String Y()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      if (this.ak != null)
      {
        str1 = str2;
        if (this.ak.length() != 0)
        {
          str1 = str2;
          str2 = this.ak;
          str1 = str2;
          StringBuilder localStringBuilder = new StringBuilder("currentCfg = ");
          str1 = str2;
          localStringBuilder.append(this.ak);
          str1 = str2;
          Log.e("TAG", localStringBuilder.toString());
          str1 = str2;
          break label112;
        }
      }
      str1 = str2;
      this.T.seek(0L);
      str1 = str2;
      str2 = this.T.readUTF();
      str1 = str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.tencent.halley.common.b.a("TaskImpl", "readCfg fail.", localException);
    }
    label112:
    Object localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject = "";
    }
    return localObject;
  }
  
  private boolean a(long paramLong)
  {
    for (;;)
    {
      synchronized (getClass())
      {
        com.tencent.halley.common.b.b("TaskImpl", "initFileOnDetected...begin");
        this.F.put("point0", Long.valueOf(0L));
        long l1 = System.currentTimeMillis();
        new File(this.h).mkdirs();
        Object localObject1;
        if (!l.c(this.i))
        {
          this.L = com.tencent.halley.common.e.a(this.G.a.a, this.l, this.m, "");
          localObject1 = new File(this.h, l.b(this.L));
          Object localObject3 = new File(this.h, this.L);
          if ((((File)localObject1).exists()) || (((File)localObject3).exists()))
          {
            i1 = this.L.lastIndexOf(".");
            localObject3 = "";
            if ((i1 > 0) && (this.L.length() > i1 + 1))
            {
              localObject1 = this.L.substring(0, i1);
              localObject3 = this.L.substring(i1);
              break label1426;
            }
            localObject1 = this.L;
            break label1426;
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject1);
            ((StringBuilder)localObject4).append("(");
            ((StringBuilder)localObject4).append(i1);
            ((StringBuilder)localObject4).append(")");
            ((StringBuilder)localObject4).append((String)localObject3);
            localObject4 = ((StringBuilder)localObject4).toString();
            File localFile1 = new File(this.h, l.b((String)localObject4));
            File localFile2 = new File(this.h, (String)localObject4);
            if ((localFile1.exists()) || (localFile2.exists())) {
              break label1431;
            }
            this.L = ((String)localObject4);
          }
        }
        else
        {
          this.L = this.i;
        }
        this.F.put("point1", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        l1 = System.currentTimeMillis();
        if (this.I)
        {
          localObject1 = new File(this.h, l.b(this.L));
          this.Q = ((File)localObject1);
        }
        else
        {
          localObject1 = new File(this.h, this.L);
          continue;
        }
        this.S = new File(this.h, l.a(this.L));
        try
        {
          this.T = new a(this.S, "rw");
          this.F.put("point2", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          l1 = System.currentTimeMillis();
          StringBuilder localStringBuilder3;
          try
          {
            this.R = new a(this.Q, "rw");
            this.F.put("point3", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
            l1 = System.currentTimeMillis();
            boolean bool = this.H;
            if (bool) {
              try
              {
                this.R.setLength(paramLong);
              }
              catch (Exception localException3)
              {
                localException3.printStackTrace();
                if (this.h.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath()))
                {
                  if ("mounted".equals(Environment.getExternalStorageState()))
                  {
                    l1 = com.tencent.halley.common.e.a();
                    if (l1 <= 3L * paramLong / 2L)
                    {
                      this.r = -12;
                      localObject1 = new StringBuilder("SDCard free space:");
                      ((StringBuilder)localObject1).append(l1);
                      ((StringBuilder)localObject1).append(", need space:");
                      ((StringBuilder)localObject1).append(paramLong);
                      localObject1 = ((StringBuilder)localObject1).toString();
                      this.s = ((String)localObject1);
                    }
                    else
                    {
                      if (com.tencent.halley.common.e.a(localException3)) {
                        return true;
                      }
                      this.r = -45;
                      localObject1 = new StringBuilder("on SDCard, setting file length faill. length:");
                      ((StringBuilder)localObject1).append(paramLong);
                      ((StringBuilder)localObject1).append(",Exception Info:");
                      ((StringBuilder)localObject1).append(localException3);
                      localObject1 = ((StringBuilder)localObject1).toString();
                      continue;
                    }
                  }
                  else
                  {
                    this.r = -46;
                    localObject1 = "SDCard is not ready.";
                    continue;
                  }
                }
                else
                {
                  if (this.h.startsWith(f.a().getFilesDir().toString()))
                  {
                    l1 = com.tencent.halley.common.e.b();
                    if ((l1 > 3L * paramLong / 2L) && (!com.tencent.halley.common.e.a(localException3)))
                    {
                      if (com.tencent.halley.common.e.a(localException3)) {
                        return true;
                      }
                      this.r = -45;
                      localObject1 = new StringBuilder("on Phone data, setting file length faill. length:");
                      ((StringBuilder)localObject1).append(paramLong);
                      ((StringBuilder)localObject1).append(",Exception Info:");
                      ((StringBuilder)localObject1).append(localException3);
                      localObject1 = ((StringBuilder)localObject1).toString();
                      continue;
                    }
                    this.r = -40;
                    localObject1 = new StringBuilder("Phone data free space:");
                    ((StringBuilder)localObject1).append(l1);
                    ((StringBuilder)localObject1).append(", need space:");
                    ((StringBuilder)localObject1).append(paramLong);
                    localObject1 = ((StringBuilder)localObject1).toString();
                    continue;
                  }
                  this.r = -47;
                  localObject1 = new StringBuilder("save dir not exists, dir:");
                  ((StringBuilder)localObject1).append(this.h);
                  localObject1 = ((StringBuilder)localObject1).toString();
                  continue;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(this.s);
                ((StringBuilder)localObject1).append("|");
                ((StringBuilder)localObject1).append(localException3);
                this.s = ((StringBuilder)localObject1).toString();
                localObject1 = new StringBuilder("initFileOnDetected...setLength Exception, _ret:");
                ((StringBuilder)localObject1).append(this.r);
                ((StringBuilder)localObject1).append(",_failInfo:");
                ((StringBuilder)localObject1).append(this.s);
                com.tencent.halley.common.b.c("TaskImpl", ((StringBuilder)localObject1).toString());
                return false;
              }
            }
            this.F.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
            System.currentTimeMillis();
            com.tencent.halley.common.b.b("TaskImpl", "initFileOnDetected...end");
            return true;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            this.r = -49;
            localStringBuilder3 = new StringBuilder("initFileOnDetected...create RandomAccessFile of path:");
            localStringBuilder3.append(this.Q.getAbsolutePath());
            localStringBuilder3.append(" fail.|");
            localStringBuilder3.append(localException1);
            this.s = localStringBuilder3.toString();
            if (com.tencent.halley.common.e.a(localException1)) {
              this.r = -12;
            } else if (com.tencent.halley.common.e.b(localException1)) {
              this.r = -13;
            }
            StringBuilder localStringBuilder1 = new StringBuilder("initFileOnDetected...Exception, _ret:");
            localStringBuilder1.append(this.r);
            localStringBuilder1.append(",_failInfo:");
            localStringBuilder1.append(this.s);
            com.tencent.halley.common.b.c("TaskImpl", localStringBuilder1.toString());
            X();
            return false;
          }
          StringBuilder localStringBuilder2;
          localObject2 = finally;
        }
        catch (Exception localException2)
        {
          com.tencent.halley.common.b.a("TaskImpl", "initFileOnDetected...create RandomAccessFile for cfgFile failed.", localException2);
          this.r = -49;
          localStringBuilder3 = new StringBuilder("initFileOnDetected...create RandomAccessFile of path:");
          localStringBuilder3.append(this.S.getAbsolutePath());
          localStringBuilder3.append(" fail.|");
          localStringBuilder3.append(localException2);
          this.s = localStringBuilder3.toString();
          if (com.tencent.halley.common.e.a(localException2)) {
            this.r = -12;
          } else if (com.tencent.halley.common.e.b(localException2)) {
            this.r = -13;
          }
          localStringBuilder2 = new StringBuilder("initFileOnDetected...Exception, _ret:");
          localStringBuilder2.append(this.r);
          localStringBuilder2.append(",_failInfo:");
          localStringBuilder2.append(this.s);
          com.tencent.halley.common.b.c("TaskImpl", localStringBuilder2.toString());
          X();
          return false;
        }
      }
      label1426:
      int i1 = 2;
      continue;
      label1431:
      i1 += 1;
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
      StringBuilder localStringBuilder = new StringBuilder("writeCfg fail. cfg:");
      localStringBuilder.append(paramString);
      com.tencent.halley.common.b.a("TaskImpl", localStringBuilder.toString(), localException);
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
    a locala = this.Z;
    if (locala != null) {
      return locala.d();
    }
    return -1L;
  }
  
  public final int E()
  {
    a locala = this.Z;
    if (locala != null) {
      return locala.e();
    }
    return -1;
  }
  
  public final long F()
  {
    z localz = this.P;
    if (localz != null) {
      return localz.a();
    }
    return 0L;
  }
  
  public final long G()
  {
    return this.f;
  }
  
  public final long H()
  {
    d locald = this.O;
    if (locald != null) {
      return locald.g();
    }
    return 0L;
  }
  
  public final String I()
  {
    af localaf = this.ah;
    if (localaf != null) {
      return localaf.a();
    }
    return "";
  }
  
  public final String J()
  {
    com.tencent.halley.downloader.c.d.b localb = this.G;
    if (localb != null) {
      return localb.b();
    }
    return "";
  }
  
  public final String K()
  {
    b localb = this.ag;
    if (localb != null)
    {
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
    b localb = this.ag;
    if (localb != null)
    {
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
    b localb = this.ag;
    if (localb != null)
    {
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
    if (!this.al) {
      return;
    }
    File localFile = new File(this.h, this.L);
    if (!localFile.exists()) {
      return;
    }
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
      this.ah.a(new af.a(l1 - this.t, paramInt, paramString));
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
    StringBuilder localStringBuilder = new StringBuilder("cancel task...key:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",isFromUser:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",retCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",failInfo:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",newStatus:");
    localStringBuilder.append(paramDownloaderTaskStatus.name());
    com.tencent.halley.common.b.b("TaskImpl", localStringBuilder.toString());
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
    long l1 = this.f;
    if (l1 > 0L) {
      return l1;
    }
    if (this.g > 0L) {
      return this.g;
    }
    try
    {
      l1 = this.O.a;
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
      d locald = this.O;
      l1 = l2;
      if (locald != null) {
        l1 = locald.a;
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
    Object localObject = this.X.a();
    StringBuilder localStringBuilder = new StringBuilder("trying pause...key:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",url:");
    localStringBuilder.append(c());
    localStringBuilder.append(", now status:");
    localStringBuilder.append(localObject);
    com.tencent.halley.common.b.b("TaskImpl", localStringBuilder.toString());
    if ((localObject == DownloaderTaskStatus.PENDING) || (localObject == DownloaderTaskStatus.STARTED) || (localObject == DownloaderTaskStatus.DOWNLOADING))
    {
      a(true, 0, "", DownloaderTaskStatus.PAUSED);
      localObject = new StringBuilder("cancel task:");
      ((StringBuilder)localObject).append(this.n);
      com.tencent.halley.common.b.c("TaskImpl", ((StringBuilder)localObject).toString());
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
  }
  
  public final boolean l()
  {
    synchronized (this.X)
    {
      DownloaderTaskStatus localDownloaderTaskStatus = this.X.a();
      StringBuilder localStringBuilder = new StringBuilder("trying resume...key:");
      localStringBuilder.append(this.n);
      localStringBuilder.append(",url:");
      localStringBuilder.append(c());
      localStringBuilder.append(", now status:");
      localStringBuilder.append(localDownloaderTaskStatus);
      com.tencent.halley.common.b.b("TaskImpl", localStringBuilder.toString());
      if ((localDownloaderTaskStatus != DownloaderTaskStatus.STARTED) && (localDownloaderTaskStatus != DownloaderTaskStatus.DOWNLOADING) && (localDownloaderTaskStatus != DownloaderTaskStatus.COMPLETE) && (localDownloaderTaskStatus != DownloaderTaskStatus.PENDING))
      {
        if ((localDownloaderTaskStatus != DownloaderTaskStatus.DELETED) && (!this.X.d()))
        {
          this.M = false;
          this.V = false;
          this.k = true;
          this.q = 0;
          p();
          return true;
        }
        return false;
      }
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
  
  public final void p()
  {
    this.N = System.currentTimeMillis();
    try
    {
      Object localObject = new StringBuilder("try add task ");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(" to pool...");
      com.tencent.halley.common.b.a("TaskImpl", ((StringBuilder)localObject).toString());
      this.X.a(DownloaderTaskStatus.PENDING);
      if (z()) {}
      for (localObject = ak.a().b(this);; localObject = ak.a().a(this))
      {
        this.ai = ((ai)localObject);
        break;
      }
      localObject = new StringBuilder("task ");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(" added to pool.");
      com.tencent.halley.common.b.a("TaskImpl", ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException);
      throw new DownloaderAddTaskException(localStringBuilder.toString());
    }
  }
  
  public final long q()
  {
    return this.g;
  }
  
  public final boolean r()
  {
    return l.c(this.i);
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
      ??? = new StringBuilder("task ");
      ((StringBuilder)???).append(this.n);
      ((StringBuilder)???).append(" start run... url:");
      ((StringBuilder)???).append(c());
      ((StringBuilder)???).append(",Thread:");
      ((StringBuilder)???).append(Thread.currentThread().getName());
      com.tencent.halley.common.b.b("TaskImpl", ((StringBuilder)???).toString());
      if (this.V)
      {
        ??? = new StringBuilder("task stopped at the beginning. url:");
        ((StringBuilder)???).append(c());
        ((StringBuilder)???).append(",Thread:");
        ((StringBuilder)???).append(Thread.currentThread().getName());
        com.tencent.halley.common.b.b("TaskImpl", ((StringBuilder)???).toString());
        return;
      }
      this.X.b();
      this.P = new z();
      this.Z = new a(this);
      this.Z.a();
      boolean bool = S();
      this.X.a(DownloaderTaskStatus.STARTED);
      this.ah = new af();
      a(q.e(), q.a);
      if (!bool)
      {
        a(false, this.r, this.s, DownloaderTaskStatus.FAILED);
      }
      else if (this.O.e())
      {
        com.tencent.halley.common.b.b("TaskImpl", "checkAlreadyCompleted");
        V();
      }
      else
      {
        ??? = this.ag.b();
        if (((com.tencent.halley.common.e)???).a != 0) {
          a(false, ((com.tencent.halley.common.e)???).a, ((com.tencent.halley.common.e)???).b, DownloaderTaskStatus.FAILED);
        }
      }
      this.X.c();
      ??? = this.P;
      if (??? != null) {
        ((z)???).c();
      }
      X();
      if (this.Y)
      {
        Q();
        O();
        if (this.I) {
          P();
        }
      }
      else if (v())
      {
        Q();
      }
      this.p.set(0L);
      this.ah = null;
      ??? = this.ag;
      ((b)???).a = null;
      ((b)???).b = null;
      return;
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
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.h);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(this.L);
      localObject2 = ((StringBuilder)localObject1).toString();
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
    implements ad
  {
    ae a;
    ae b;
    
    private b() {}
    
    private boolean a(String paramString)
    {
      boolean bool3 = e.a(e.this).a();
      boolean bool1 = false;
      boolean bool2 = false;
      if (bool3)
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
        StringBuilder localStringBuilder = new StringBuilder("savedLM:");
        localStringBuilder.append(str);
        localStringBuilder.append(",newLM:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",fail:");
        localStringBuilder.append(bool1);
        Log.d("DownloadTest", localStringBuilder.toString());
      }
      return bool1;
    }
    
    public final com.tencent.halley.common.e a(ae paramae, com.tencent.halley.downloader.c.d.a parama, String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      int j = 1;
      int i;
      if (paramae != null)
      {
        try
        {
          if (paramae == this.a) {
            break label838;
          }
          if (paramae != this.b) {
            break label848;
          }
        }
        finally
        {
          com.tencent.halley.common.e locale;
          d locald;
          label99:
          break label834;
        }
        if ((i != 0) && (!paramae.a()) && (paramLong > 0L))
        {
          locale = new com.tencent.halley.common.e(0, "");
          if (e.b(e.this) != null)
          {
            locald = e.b(e.this);
            if (paramae.a.i != locald) {
              break label854;
            }
            i = 1;
            break label857;
            if (e.this.g == -1L) {
              if ((e.this.f != -1L) && (paramLong != e.this.f))
              {
                locale.a = -10;
                paramae = new StringBuilder("knownSize:");
                paramae.append(e.this.f);
                paramae.append(",rspLength:");
                paramae.append(paramLong);
                locale.b = paramae.toString();
              }
              else
              {
                e.this.g = paramLong;
                e.this.k = paramBoolean;
                e.this.l = paramString4;
                e.this.m = paramString5;
                if (paramae.b != null) {
                  e.this.A = paramae.b.c;
                }
                if (!e.this.k)
                {
                  e.a(e.this, new d(""));
                  paramae.a = e.b(e.this).a();
                }
                else if (e.b(e.this).a > 0L)
                {
                  if (e.b(e.this).a != e.this.g)
                  {
                    i = j;
                  }
                  else
                  {
                    if (!a(paramString3)) {
                      break label865;
                    }
                    i = j;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          e.a(e.this, new d(""));
          locale.a = 3;
          locale.b = "can not resume from cfg, start over now";
        }
        e.b(e.this).a = paramLong;
        e.b(e.this).a(paramString2);
        e.b(e.this).b(paramString3);
        if ((paramae.a.c == -1) && (paramae.a.b == -1)) {
          e.b(e.this).a(paramae.a);
        }
        if (locale.a == 0)
        {
          if ((!e.c(e.this)) && (!e.a(e.this, paramLong))) {
            e.this.a(false, e.this.r, e.this.s, DownloaderTaskStatus.FAILED);
          }
          e.d(e.this).a(b.a.c);
          break label689;
          if (paramLong != e.this.g)
          {
            locale.a = -43;
            paramae = new StringBuilder("detectLength:");
            paramae.append(e.this.g);
            paramae.append(",rspLength:");
            paramae.append(paramLong);
            paramae = paramae.toString();
          }
          for (;;)
          {
            locale.b = paramae;
            break;
            if (!e.this.k)
            {
              locale.a = 1;
              paramae = "not support range";
            }
            else
            {
              if (!a(paramString3)) {
                break;
              }
              locale.a = -68;
              paramae = new StringBuilder("detected VerifyProperty:");
              paramae.append(e.b(e.this).c());
              paramae.append(",rsp VerifyProperty:");
              paramae.append(paramString3);
              paramae = paramae.toString();
            }
          }
        }
        label689:
        if ((locale.a == 0) && (!TextUtils.isEmpty(paramString1))) {
          if ((parama.b != a.a.b) && (parama.b != a.a.a))
          {
            if (parama.b == a.a.g) {
              e.a(e.this).b(q.a, paramString1);
            }
          }
          else {
            e.a(e.this).a(q.a, paramString1);
          }
        }
        return locale;
        for (;;)
        {
          locale.a = 2;
          locale.b = "not the same divider";
          parama = new StringBuilder("onValidResponse... fail...not self section:");
          parama.append(paramae.a);
          com.tencent.halley.common.b.c("TaskImpl", parama.toString());
          return locale;
          paramae = new com.tencent.halley.common.e(4, "");
          return paramae;
          label834:
          throw paramae;
          label838:
          i = 1;
          break;
          label848:
          i = 0;
          break;
          label854:
          i = 0;
          label857:
          if (i != 0) {
            break label99;
          }
        }
        label865:
        i = 0;
      }
    }
    
    public final ac a(ae paramae)
    {
      int i;
      if ((paramae != null) && ((paramae == this.a) || (paramae == this.b))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return null;
      }
      if (!e.this.k) {
        return null;
      }
      return e.b(e.this).a();
    }
    
    public final boolean a()
    {
      return e.this.g != -1L;
    }
    
    /* Error */
    public final boolean a(ae arg1, long paramLong, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 8
      //   3: aload_1
      //   4: ifnull +25 -> 29
      //   7: aload_1
      //   8: aload_0
      //   9: getfield 85	com/tencent/halley/downloader/c/e$b:a	Lcom/tencent/token/ae;
      //   12: if_acmpeq +11 -> 23
      //   15: aload_1
      //   16: aload_0
      //   17: getfield 87	com/tencent/halley/downloader/c/e$b:b	Lcom/tencent/token/ae;
      //   20: if_acmpne +9 -> 29
      //   23: iconst_1
      //   24: istore 7
      //   26: goto +6 -> 32
      //   29: iconst_0
      //   30: istore 7
      //   32: iload 7
      //   34: ifne +5 -> 39
      //   37: iconst_0
      //   38: ireturn
      //   39: iload 5
      //   41: ifle +38 -> 79
      //   44: aload_0
      //   45: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   48: getfield 255	com/tencent/halley/downloader/c/e:o	Ljava/util/concurrent/atomic/AtomicLong;
      //   51: astore 11
      //   53: iload 5
      //   55: i2l
      //   56: lstore 9
      //   58: aload 11
      //   60: lload 9
      //   62: invokevirtual 261	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   65: pop2
      //   66: aload_0
      //   67: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   70: getfield 264	com/tencent/halley/downloader/c/e:p	Ljava/util/concurrent/atomic/AtomicLong;
      //   73: lload 9
      //   75: invokevirtual 261	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   78: pop2
      //   79: aload_0
      //   80: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   83: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   86: ifnull +531 -> 617
      //   89: aload_0
      //   90: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   93: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   96: astore 11
      //   98: aload_1
      //   99: getfield 100	com/tencent/token/ae:a	Lcom/tencent/token/ac;
      //   102: getfield 106	com/tencent/token/ac:i	Lcom/tencent/halley/downloader/c/d;
      //   105: aload 11
      //   107: if_acmpne +9 -> 116
      //   110: iconst_1
      //   111: istore 7
      //   113: goto +6 -> 119
      //   116: iconst_0
      //   117: istore 7
      //   119: iload 7
      //   121: ifne +5 -> 126
      //   124: iconst_0
      //   125: ireturn
      //   126: iload 6
      //   128: ifeq +186 -> 314
      //   131: aload_0
      //   132: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   135: iconst_0
      //   136: putfield 267	com/tencent/halley/downloader/c/e:w	I
      //   139: new 55	java/lang/StringBuilder
      //   142: dup
      //   143: ldc_w 269
      //   146: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   149: astore 11
      //   151: aload 11
      //   153: aload_1
      //   154: invokevirtual 271	com/tencent/token/ae:b	()Z
      //   157: invokevirtual 71	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   160: pop
      //   161: aload 11
      //   163: ldc_w 273
      //   166: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: pop
      //   170: aload 11
      //   172: aload_1
      //   173: getfield 100	com/tencent/token/ae:a	Lcom/tencent/token/ac;
      //   176: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   179: pop
      //   180: ldc 73
      //   182: aload 11
      //   184: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   187: invokestatic 274	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   190: aload_1
      //   191: getfield 100	com/tencent/token/ae:a	Lcom/tencent/token/ac;
      //   194: getfield 168	com/tencent/token/ac:b	I
      //   197: iconst_m1
      //   198: if_icmpne +116 -> 314
      //   201: aload_0
      //   202: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   205: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   208: aload_1
      //   209: getfield 100	com/tencent/token/ae:a	Lcom/tencent/token/ac;
      //   212: invokevirtual 171	com/tencent/halley/downloader/c/d:a	(Lcom/tencent/token/ac;)Z
      //   215: istore 6
      //   217: new 55	java/lang/StringBuilder
      //   220: dup
      //   221: ldc_w 269
      //   224: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   227: astore 11
      //   229: aload 11
      //   231: aload_1
      //   232: invokevirtual 271	com/tencent/token/ae:b	()Z
      //   235: invokevirtual 71	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   238: pop
      //   239: aload 11
      //   241: ldc_w 276
      //   244: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   247: pop
      //   248: aload 11
      //   250: aload_1
      //   251: getfield 100	com/tencent/token/ae:a	Lcom/tencent/token/ac;
      //   254: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   257: pop
      //   258: aload 11
      //   260: ldc_w 278
      //   263: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   266: pop
      //   267: aload 11
      //   269: iload 6
      //   271: invokevirtual 71	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   274: pop
      //   275: aload 11
      //   277: ldc_w 280
      //   280: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   283: pop
      //   284: aload 11
      //   286: aload_0
      //   287: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   290: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   293: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   296: pop
      //   297: ldc 73
      //   299: aload 11
      //   301: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   304: invokestatic 245	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   307: iload 6
      //   309: ifne +5 -> 314
      //   312: iconst_0
      //   313: ireturn
      //   314: iload 5
      //   316: ifle +299 -> 615
      //   319: aload_0
      //   320: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   323: invokevirtual 283	com/tencent/halley/downloader/c/e:x	()Z
      //   326: ifne +289 -> 615
      //   329: aload_0
      //   330: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   333: invokestatic 287	com/tencent/halley/downloader/c/e:e	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/token/z;
      //   336: astore 11
      //   338: aload_1
      //   339: getfield 100	com/tencent/token/ae:a	Lcom/tencent/token/ac;
      //   342: getfield 168	com/tencent/token/ac:b	I
      //   345: istore 7
      //   347: iload 5
      //   349: i2l
      //   350: lstore 9
      //   352: aload 11
      //   354: iload 7
      //   356: lload_2
      //   357: aload 4
      //   359: lload 9
      //   361: invokevirtual 292	com/tencent/token/z:a	(IJ[BJ)V
      //   364: aload_1
      //   365: getfield 100	com/tencent/token/ae:a	Lcom/tencent/token/ac;
      //   368: astore_1
      //   369: aload_1
      //   370: aload_1
      //   371: getfield 293	com/tencent/token/ac:f	J
      //   374: lload 9
      //   376: ladd
      //   377: putfield 293	com/tencent/token/ac:f	J
      //   380: aload_0
      //   381: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   384: invokestatic 36	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/d;
      //   387: astore_1
      //   388: aload_1
      //   389: invokevirtual 296	com/tencent/halley/downloader/c/d:f	()J
      //   392: lstore_2
      //   393: iload 8
      //   395: istore 5
      //   397: lload_2
      //   398: lconst_0
      //   399: lcmp
      //   400: ifle +19 -> 419
      //   403: iload 8
      //   405: istore 5
      //   407: lload_2
      //   408: aload_1
      //   409: getfield 157	com/tencent/halley/downloader/c/d:a	J
      //   412: lcmp
      //   413: ifne +6 -> 419
      //   416: iconst_1
      //   417: istore 5
      //   419: iload 5
      //   421: ifeq +19 -> 440
      //   424: aload_0
      //   425: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   428: invokestatic 299	com/tencent/halley/downloader/c/e:f	(Lcom/tencent/halley/downloader/c/e;)Lcom/tencent/halley/downloader/c/a;
      //   431: invokevirtual 303	com/tencent/halley/downloader/c/a:b	()V
      //   434: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
      //   437: invokevirtual 309	com/tencent/token/y:b	()V
      //   440: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
      //   443: invokevirtual 311	com/tencent/token/y:g	()Z
      //   446: ifeq +169 -> 615
      //   449: aload_0
      //   450: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   453: iconst_1
      //   454: invokestatic 314	com/tencent/halley/downloader/c/e:a	(Lcom/tencent/halley/downloader/c/e;Z)Z
      //   457: pop
      //   458: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
      //   461: invokevirtual 309	com/tencent/token/y:b	()V
      //   464: new 55	java/lang/StringBuilder
      //   467: dup
      //   468: ldc_w 316
      //   471: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   474: astore_1
      //   475: aload_1
      //   476: aload_0
      //   477: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   480: getfield 319	com/tencent/halley/downloader/c/e:n	Ljava/lang/String;
      //   483: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   486: pop
      //   487: aload_1
      //   488: ldc_w 321
      //   491: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   494: pop
      //   495: ldc 241
      //   497: aload_1
      //   498: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   501: invokestatic 245	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   504: aload_0
      //   505: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   508: iconst_1
      //   509: invokestatic 323	com/tencent/halley/downloader/c/e:b	(Lcom/tencent/halley/downloader/c/e;Z)Z
      //   512: pop
      //   513: aload_0
      //   514: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   517: invokestatic 326	com/tencent/halley/downloader/c/e:g	(Lcom/tencent/halley/downloader/c/e;)Ljava/lang/Object;
      //   520: astore_1
      //   521: aload_1
      //   522: monitorenter
      //   523: aload_0
      //   524: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   527: invokestatic 326	com/tencent/halley/downloader/c/e:g	(Lcom/tencent/halley/downloader/c/e;)Ljava/lang/Object;
      //   530: ldc2_w 327
      //   533: invokevirtual 332	java/lang/Object:wait	(J)V
      //   536: aload_1
      //   537: monitorexit
      //   538: iconst_1
      //   539: ireturn
      //   540: astore 4
      //   542: aload_1
      //   543: monitorexit
      //   544: aload 4
      //   546: athrow
      //   547: astore_1
      //   548: aload_1
      //   549: invokevirtual 335	java/lang/OutOfMemoryError:printStackTrace	()V
      //   552: aload_0
      //   553: getfield 17	com/tencent/halley/downloader/c/e$b:c	Lcom/tencent/halley/downloader/c/e;
      //   556: astore_1
      //   557: new 55	java/lang/StringBuilder
      //   560: dup
      //   561: ldc_w 337
      //   564: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   567: astore 4
      //   569: aload 4
      //   571: iload 5
      //   573: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   576: pop
      //   577: aload 4
      //   579: ldc_w 342
      //   582: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   585: pop
      //   586: aload 4
      //   588: invokestatic 308	com/tencent/token/y:a	()Lcom/tencent/token/y;
      //   591: invokevirtual 343	com/tencent/token/y:f	()J
      //   594: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   597: pop
      //   598: aload_1
      //   599: iconst_0
      //   600: bipush 237
      //   602: aload 4
      //   604: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   607: getstatic 189	com/tencent/halley/downloader/DownloaderTaskStatus:FAILED	Lcom/tencent/halley/downloader/DownloaderTaskStatus;
      //   610: invokevirtual 192	com/tencent/halley/downloader/c/e:a	(ZILjava/lang/String;Lcom/tencent/halley/downloader/DownloaderTaskStatus;)V
      //   613: iconst_0
      //   614: ireturn
      //   615: iconst_1
      //   616: ireturn
      //   617: iconst_0
      //   618: ireturn
      //   619: astore_1
      //   620: iconst_1
      //   621: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	622	0	this	b
      //   0	622	2	paramLong	long
      //   0	622	4	paramArrayOfByte	byte[]
      //   0	622	5	paramInt	int
      //   0	622	6	paramBoolean	boolean
      //   24	331	7	i	int
      //   1	403	8	j	int
      //   56	319	9	l	long
      //   51	302	11	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   523	538	540	finally
      //   329	347	547	java/lang/OutOfMemoryError
      //   352	364	547	java/lang/OutOfMemoryError
      //   504	523	619	java/lang/Exception
      //   542	547	619	java/lang/Exception
    }
    
    public final com.tencent.halley.common.e b()
    {
      com.tencent.halley.common.e locale;
      label168:
      try
      {
        locale = new com.tencent.halley.common.e(0, "");
        this.a = new ae(e.a(e.this), true, e.this.f, e.this, this, e.this.e, e.this.C);
        try
        {
          ak.a().c(this.a);
        }
        catch (Exception localException1)
        {
          this.a = null;
          locale.a = -67;
          localException1.printStackTrace();
        }
        if ((locale.a == 0) && (!e.this.z())) {
          this.b = new ae(e.a(e.this), false, e.this.f, e.this, this, e.this.e, e.this.C);
        }
      }
      finally {}
      try
      {
        ak.a().d(this.b);
      }
      catch (Exception localException2)
      {
        break label168;
      }
      this.b = null;
      return locale;
    }
    
    public final void b(ae paramae)
    {
      int i;
      if ((paramae != null) && ((paramae == this.a) || (paramae == this.b))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return;
      }
      if (paramae.a == null) {
        return;
      }
      e.b(e.this);
      paramae.a.h = false;
    }
    
    public final void c(ae paramae)
    {
      int j = 1;
      int i;
      if ((paramae != null) && ((paramae == this.a) || (paramae == this.b))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return;
      }
      for (;;)
      {
        synchronized (e.h(e.this))
        {
          if ((this.a == null) || (this.a.f()))
          {
            if ((!e.this.C) || (this.b == null) || (this.b.f())) {
              break label299;
            }
            break label294;
            if (i != 0)
            {
              ??? = new StringBuilder("All Transports Finished, task:");
              ((StringBuilder)???).append(e.this.b());
              com.tencent.halley.common.b.c("TaskImpl", ((StringBuilder)???).toString());
              if (!e.i(e.this))
              {
                ??? = e.b(e.this);
                long l = ((d)???).f();
                if ((l > 0L) && (l == ((d)???).a)) {
                  i = j;
                } else {
                  i = 0;
                }
                if (i != 0) {
                  return;
                }
                e.this.r = paramae.c();
                e.this.s = paramae.d();
                if (e.this.r == 0)
                {
                  paramae = e.this;
                  paramae.r = -69;
                  ??? = new StringBuilder("readLen:");
                  ((StringBuilder)???).append(e.b(e.this).f());
                  paramae.s = ((StringBuilder)???).toString();
                }
                e.d(e.this).a(DownloaderTaskStatus.FAILED);
              }
            }
            return;
          }
        }
        label294:
        i = 0;
        continue;
        label299:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.e
 * JD-Core Version:    0.7.0.1
 */