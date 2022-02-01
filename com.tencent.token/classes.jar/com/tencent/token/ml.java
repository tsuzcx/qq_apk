package com.tencent.token;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.downloader.DownloaderTaskPriority;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.b;
import com.tencent.halley.downloader.c.b.a;
import com.tencent.halley.downloader.c.d.a;
import com.tencent.halley.downloader.c.d.a.a;
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ml
  implements lh, lt, mc, Comparable, Runnable
{
  public volatile boolean A = false;
  public volatile int B = 0;
  public b C = new b(this);
  public boolean D = false;
  public int E = 0;
  public volatile boolean F = false;
  public boolean G = false;
  public String H = "";
  public String I;
  public int J = -1;
  public long K = 0L;
  public boolean L = true;
  public boolean M = false;
  public String N;
  public int O = 0;
  public volatile HashMap P = new LinkedHashMap();
  private mk Q;
  private boolean R = true;
  private volatile DownloaderTaskPriority S = DownloaderTaskPriority.NORMAL;
  private boolean T = false;
  private long U = -1L;
  private mj V;
  private File W;
  private RandomAccessFile X;
  private File Y;
  private RandomAccessFile Z;
  public int a = -1;
  private volatile boolean aa = false;
  private volatile int ab = 0;
  private lz ac;
  private AtomicInteger ad = new AtomicInteger(0);
  private Object ae = new Object();
  private volatile boolean af = false;
  private boolean ag = false;
  private b ah = new b((byte)0);
  private mh ai;
  private ms aj;
  private long ak = 0L;
  private String al = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public boolean e = true;
  public Map f = new HashMap();
  public long g = -1L;
  public volatile long h = -1L;
  public volatile long i = 0L;
  public String j = "";
  public String k = "";
  public String l = "";
  public volatile long m = 0L;
  public volatile boolean n = true;
  public String o = "";
  public String p = "";
  public String q = null;
  public AtomicLong r = new AtomicLong(0L);
  public AtomicLong s = new AtomicLong(0L);
  public volatile int t = 0;
  public volatile int u = 0;
  public String v = "";
  public long w = -1L;
  public long x = -1L;
  public long y = -1L;
  public ma z;
  
  public ml(String paramString1, mk arg2, String paramString2, String paramString3, lu paramlu)
  {
    li.a("TaskImpl", "new BDTaskImpl()");
    this.a = 1;
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    this.b = str;
    this.Q = ???;
    this.j = paramString2;
    this.k = paramString3;
    paramString1 = this.C;
    if (paramlu != null) {}
    try
    {
      synchronized (paramString1.c)
      {
        if (!paramString1.c.contains(paramlu)) {
          paramString1.c.add(paramlu);
        }
        synchronized (paramString1.d)
        {
          if (!paramString1.d.contains(paramlu)) {
            paramString1.d.add(paramlu);
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      label476:
      break label476;
    }
    this.A = false;
    this.g = -1L;
    paramString1 = new StringBuilder("");
    paramString1.append(lr.c());
    paramString1.append(lr.d());
    paramString1.append(System.currentTimeMillis());
    paramString1.append(this.Q.b.a);
    paramString1.append(lr.b());
    this.q = lm.a(paramString1.toString());
  }
  
  private boolean E()
  {
    try
    {
      this.Z = new a(this.Y, "rw");
      li.b("TaskImpl", "initFileOnStart...create _cfgAccessFile");
      try
      {
        this.X = new a(this.W, "rw");
        return true;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.u = -49;
        localStringBuilder3 = new StringBuilder("initFileOnStart...create RandomAccessFile of path:");
        localStringBuilder3.append(this.W.getAbsolutePath());
        localStringBuilder3.append(" fail.|");
        localStringBuilder3.append(localException1);
        this.v = localStringBuilder3.toString();
        if (lo.a(localException1)) {
          this.u = -12;
        } else if (lo.b(localException1)) {
          this.u = -13;
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
        li.a("TaskImpl", "initFileOnStart...create RandomAccessFile for cfgFile failed.", localException2);
        this.u = -49;
        StringBuilder localStringBuilder3 = new StringBuilder("initFileOnStart...create RandomAccessFile of path:");
        localStringBuilder3.append(this.Y.getAbsolutePath());
        localStringBuilder3.append(" fail.|");
        localStringBuilder3.append(localException2);
        this.v = localStringBuilder3.toString();
        if (lo.a(localException2)) {
          this.u = -12;
        } else if (lo.b(localException2)) {
          this.u = -13;
        }
        StringBuilder localStringBuilder2 = new StringBuilder("initFileOnStart...Exception, _ret:");
      }
    }
    localStringBuilder1.append(this.u);
    localStringBuilder1.append(",_failInfo:");
    localStringBuilder1.append(this.v);
    li.c("TaskImpl", localStringBuilder1.toString());
    K();
    return false;
  }
  
  private boolean F()
  {
    li.b("TaskImpl", "initFileOnStart...begin");
    try
    {
      new File(this.j).mkdirs();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.W = null;
    this.Y = null;
    Object localObject = this.V;
    if (localObject != null)
    {
      if ((((mj)localObject).c() > 0L) && (!TextUtils.isEmpty(this.l)))
      {
        if (this.e) {
          localObject = new File(this.j, ky.b(this.l));
        } else {
          localObject = new File(this.j, this.l);
        }
        this.W = ((File)localObject);
        this.Y = new File(this.j, ky.a(this.l));
        i1 = 1;
        break label248;
      }
    }
    else if (ky.c(this.k))
    {
      if (this.e) {
        localObject = new File(this.j, ky.b(this.k));
      } else {
        localObject = new File(this.j, this.k);
      }
      this.W = ((File)localObject);
      this.Y = new File(this.j, ky.a(this.k));
      i1 = 0;
      i2 = 1;
      break label250;
    }
    int i1 = 0;
    label248:
    int i2 = 0;
    label250:
    boolean bool2;
    if (((i1 != 0) || (i2 != 0)) && (this.W.exists()))
    {
      if (!E()) {
        return false;
      }
      localObject = N();
      li.b("TaskImpl", "initFileOnStart...readCfg:".concat(String.valueOf(localObject)));
      this.V = new mj((String)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.V.f))
      {
        long l1 = this.W.lastModified();
        boolean bool1;
        if (((i2 != 0) && (l1 >= this.V.b) && (this.V.a > 0L) && (this.V.c() <= this.V.a)) || ((i1 != 0) && (l1 >= this.V.b))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1)
        {
          if (TextUtils.isEmpty(this.l)) {
            this.l = this.k;
          }
          this.m = this.V.c;
          this.r.set(this.V.d);
          bool2 = bool1;
          if (i2 != 0)
          {
            bool2 = bool1;
            if (this.V.a > 0L)
            {
              this.G = true;
              bool2 = bool1;
            }
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder("resume failed. cfg:");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",flm:");
          localStringBuilder.append(l1);
          localStringBuilder.append(",from:");
          localStringBuilder.append(i2 ^ 0x1);
          this.H = localStringBuilder.toString();
          bool2 = bool1;
        }
      }
      else
      {
        this.H = "resume failed. cfg:".concat(String.valueOf(localObject));
      }
    }
    else
    {
      bool2 = false;
    }
    if (!bool2)
    {
      K();
      this.h = -1L;
      this.l = "";
      this.m = 0L;
      this.r.set(0L);
      this.n = true;
      this.o = "";
      this.p = "";
      this.t = 0;
      this.T = false;
      this.u = 0;
      this.v = "";
      this.V = new mj("");
      this.G = false;
    }
    this.ag = bool2;
    return true;
  }
  
  private void G()
  {
    try
    {
      synchronized (this.ae)
      {
        this.ae.notifyAll();
        this.af = false;
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean H()
  {
    long l2;
    boolean bool1;
    label469:
    Object localObject;
    label485:
    label488:
    long l1;
    if ((!this.aa) && (!v()) && (!u()) && (!L()) && (!M()))
    {
      l2 = SystemClock.elapsedRealtime();
      int i2 = 0;
      for (;;)
      {
        boolean bool2 = this.aa;
        bool1 = true;
        i1 = 1;
        if ((bool2) || (v()) || (u()) || (L()) || (M())) {
          break label469;
        }
        if (SystemClock.elapsedRealtime() - l2 > ky.f)
        {
          this.ad.getAndIncrement();
          break label488;
        }
        ma.a locala = this.z.a();
        if (locala == null) {
          break label485;
        }
        md localmd = this.V.a(locala.a);
        StringBuilder localStringBuilder;
        if (localmd == null) {
          localStringBuilder = new StringBuilder("inner error: getRange null for sectionId:");
        }
        for (;;)
        {
          localStringBuilder.append(locala.a);
          a(false, -42, localStringBuilder.toString(), DownloaderTaskStatus.FAILED);
          return false;
          if (localmd.f == locala.b) {
            break;
          }
          localStringBuilder = new StringBuilder("inner error: check offset fail for section:");
          localStringBuilder.append(localmd);
          localStringBuilder.append(",buffer offset:");
          localStringBuilder.append(locala.b);
          localStringBuilder.append(",sectionId:");
        }
        try
        {
          if (this.X.getFilePointer() != locala.b) {
            this.X.seek(locala.b);
          }
          this.X.write(locala.c, 0, (int)locala.d);
          localmd.f = (locala.b + locala.d);
          int i3 = (int)(i2 + locala.d);
          locala.c = null;
          i2 = i3;
          if (this.af)
          {
            if (ly.b().g() >= 2097152L) {
              i1 = 0;
            }
            i2 = i3;
            if (i1 != 0)
            {
              G();
              i2 = i3;
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if ((localException instanceof NullPointerException)) {
            break label485;
          }
        }
      }
      li.b("TaskImpl", "saveData fail.", localException);
      int i1 = -50;
      if (!this.W.exists()) {
        i1 = -14;
      } else if (lo.a(localException)) {
        i1 = -12;
      } else if (lo.b(localException)) {
        i1 = -17;
      }
      a(false, i1, "saveData fail.|".concat(String.valueOf(localException)), DownloaderTaskStatus.FAILED);
      break label485;
      localObject = this.z;
      if (localObject != null) {
        ((ma)localObject).b();
      }
      bool1 = false;
      if (!bool1) {
        G();
      }
      l1 = SystemClock.elapsedRealtime();
      localObject = this.ac;
      if (localObject != null) {
        ((lz)localObject).a(i2, (int)(l1 - l2));
      }
      if (i2 > 0) {
        J();
      }
      if ((!this.aa) && (!v()) && (!u()) && (!L()) && (!M()))
      {
        if (this.h <= 0L) {
          break label774;
        }
        l2 = this.V.c();
        if (((l1 - this.ak > ky.h()) || (l2 == this.h)) && ((i2 <= 0) || (this.L))) {}
      }
    }
    try
    {
      this.X.getFD().sync();
      label635:
      this.i = l2;
      this.C.a(DownloaderTaskStatus.DOWNLOADING);
      this.ak = l1;
      if (l2 == this.h)
      {
        this.ac.c = System.currentTimeMillis();
        this.y = l1;
        I();
        return bool1;
      }
      if (l2 > this.h)
      {
        li.d("TaskImpl", "receivedLength > detectLength");
        localObject = new StringBuilder("inner error: receivedLength > detectLength:");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(" > ");
        ((StringBuilder)localObject).append(this.h);
        a(false, -42, ((StringBuilder)localObject).toString(), DownloaderTaskStatus.FAILED);
        q();
        return bool1;
        K();
      }
      label774:
      return bool1;
      localObject = this.z;
      if (localObject != null) {
        ((ma)localObject).b();
      }
      K();
      return false;
    }
    catch (Throwable localThrowable)
    {
      break label635;
    }
  }
  
  private void I()
  {
    for (;;)
    {
      synchronized (this.C)
      {
        if (this.C.b != DownloaderTaskStatus.PAUSED)
        {
          if (!this.e) {
            break label129;
          }
          File localFile1 = new File(this.j, ky.b(this.l));
          File localFile2 = new File(this.j, this.l);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          bool = localFile1.renameTo(localFile2);
          q();
          if (bool) {
            this.C.a(DownloaderTaskStatus.COMPLETE);
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
  
  private void J()
  {
    try
    {
      if ((this.V != null) && (this.W != null) && (this.Y != null))
      {
        this.V.b = this.W.lastModified();
        this.V.c = this.m;
        this.V.d = this.r.get();
        if (!a(this.V.b())) {
          li.c("TaskImpl", "saveRange...writeCfg false.");
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
  
  private void K()
  {
    try
    {
      RandomAccessFile localRandomAccessFile1 = this.X;
      if (localRandomAccessFile1 != null)
      {
        try
        {
          this.X.close();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
        this.X = null;
      }
      RandomAccessFile localRandomAccessFile2 = this.Z;
      if (localRandomAccessFile2 != null)
      {
        try
        {
          this.Z.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        this.Z = null;
      }
      return;
    }
    finally {}
  }
  
  private boolean L()
  {
    return this.C.b == DownloaderTaskStatus.COMPLETE;
  }
  
  private boolean M()
  {
    return this.C.b == DownloaderTaskStatus.FAILED;
  }
  
  private String N()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      if (this.al != null)
      {
        str1 = str2;
        if (this.al.length() != 0)
        {
          str1 = str2;
          str2 = this.al;
          str1 = str2;
          new StringBuilder("currentCfg = ").append(this.al);
          str1 = str2;
          break label95;
        }
      }
      str1 = str2;
      this.Z.seek(0L);
      str1 = str2;
      str2 = this.Z.readUTF();
      str1 = str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      li.a("TaskImpl", "readCfg fail.", localException);
    }
    label95:
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
        li.b("TaskImpl", "initFileOnDetected...begin");
        this.P.put("point0", Long.valueOf(0L));
        long l1 = System.currentTimeMillis();
        new File(this.j).mkdirs();
        Object localObject1;
        if (!ky.c(this.k))
        {
          Object localObject5 = this.Q.b.a;
          Object localObject4 = this.o;
          Object localObject3 = lo.a(this.p, "");
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject3 = lo.b((String)localObject5, "");
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject3 = "downloadfile".concat(String.valueOf(""));
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label1625;
              }
              localObject1 = localObject3;
              if (!((String)localObject4).equalsIgnoreCase("application/vnd.android.package-archive")) {
                break label1625;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject3);
              ((StringBuilder)localObject1).append(".apk");
              localObject1 = ((StringBuilder)localObject1).toString();
              break label1625;
            }
          }
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject3 = ((String)localObject1).replace("?", "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "");
          }
          this.l = ((String)localObject3);
          localObject1 = new File(this.j, ky.b(this.l));
          localObject3 = new File(this.j, this.l);
          if ((((File)localObject1).exists()) || (((File)localObject3).exists()))
          {
            i1 = this.l.lastIndexOf(".");
            localObject3 = "";
            if ((i1 > 0) && (this.l.length() > i1 + 1))
            {
              localObject1 = this.l.substring(0, i1);
              localObject3 = this.l.substring(i1);
              break label1628;
            }
            localObject1 = this.l;
            break label1628;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject1);
            ((StringBuilder)localObject4).append("(");
            ((StringBuilder)localObject4).append(i1);
            ((StringBuilder)localObject4).append(")");
            ((StringBuilder)localObject4).append((String)localObject3);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new File(this.j, ky.b((String)localObject4));
            File localFile = new File(this.j, (String)localObject4);
            if ((((File)localObject5).exists()) || (localFile.exists())) {
              break label1633;
            }
            this.l = ((String)localObject4);
          }
        }
        else
        {
          this.l = this.k;
        }
        this.P.put("point1", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
        l1 = System.currentTimeMillis();
        if (this.e)
        {
          localObject1 = new File(this.j, ky.b(this.l));
          this.W = ((File)localObject1);
        }
        else
        {
          localObject1 = new File(this.j, this.l);
          continue;
        }
        this.Y = new File(this.j, ky.a(this.l));
        try
        {
          this.Z = new a(this.Y, "rw");
          this.P.put("point2", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
          l1 = System.currentTimeMillis();
          StringBuilder localStringBuilder3;
          try
          {
            this.X = new a(this.W, "rw");
            this.P.put("point3", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
            l1 = System.currentTimeMillis();
            boolean bool = this.R;
            if (bool) {
              try
              {
                this.X.setLength(paramLong);
              }
              catch (Exception localException3)
              {
                localException3.printStackTrace();
                if (this.j.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath()))
                {
                  if ("mounted".equals(Environment.getExternalStorageState()))
                  {
                    l1 = lo.a();
                    if (l1 <= 3L * paramLong / 2L)
                    {
                      this.u = -12;
                      localObject1 = new StringBuilder("SDCard free space:");
                      ((StringBuilder)localObject1).append(l1);
                      ((StringBuilder)localObject1).append(", need space:");
                      ((StringBuilder)localObject1).append(paramLong);
                      localObject1 = ((StringBuilder)localObject1).toString();
                      this.v = ((String)localObject1);
                    }
                    else
                    {
                      if (lo.a(localException3)) {
                        return true;
                      }
                      this.u = -45;
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
                    this.u = -46;
                    localObject1 = "SDCard is not ready.";
                    continue;
                  }
                }
                else
                {
                  if (this.j.startsWith(lp.a().getFilesDir().toString()))
                  {
                    l1 = lo.b();
                    if ((l1 > 3L * paramLong / 2L) && (!lo.a(localException3)))
                    {
                      if (lo.a(localException3)) {
                        return true;
                      }
                      this.u = -45;
                      localObject1 = new StringBuilder("on Phone data, setting file length faill. length:");
                      ((StringBuilder)localObject1).append(paramLong);
                      ((StringBuilder)localObject1).append(",Exception Info:");
                      ((StringBuilder)localObject1).append(localException3);
                      localObject1 = ((StringBuilder)localObject1).toString();
                      continue;
                    }
                    this.u = -40;
                    localObject1 = new StringBuilder("Phone data free space:");
                    ((StringBuilder)localObject1).append(l1);
                    ((StringBuilder)localObject1).append(", need space:");
                    ((StringBuilder)localObject1).append(paramLong);
                    localObject1 = ((StringBuilder)localObject1).toString();
                    continue;
                  }
                  this.u = -47;
                  localObject1 = new StringBuilder("save dir not exists, dir:");
                  ((StringBuilder)localObject1).append(this.j);
                  localObject1 = ((StringBuilder)localObject1).toString();
                  continue;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(this.v);
                ((StringBuilder)localObject1).append("|");
                ((StringBuilder)localObject1).append(localException3);
                this.v = ((StringBuilder)localObject1).toString();
                localObject1 = new StringBuilder("initFileOnDetected...setLength Exception, _ret:");
                ((StringBuilder)localObject1).append(this.u);
                ((StringBuilder)localObject1).append(",_failInfo:");
                ((StringBuilder)localObject1).append(this.v);
                li.c("TaskImpl", ((StringBuilder)localObject1).toString());
                return false;
              }
            }
            this.P.put("point4", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l1).longValue()));
            System.currentTimeMillis();
            li.b("TaskImpl", "initFileOnDetected...end");
            return true;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            this.u = -49;
            localStringBuilder3 = new StringBuilder("initFileOnDetected...create RandomAccessFile of path:");
            localStringBuilder3.append(this.W.getAbsolutePath());
            localStringBuilder3.append(" fail.|");
            localStringBuilder3.append(localException1);
            this.v = localStringBuilder3.toString();
            if (lo.a(localException1)) {
              this.u = -12;
            } else if (lo.b(localException1)) {
              this.u = -13;
            }
            StringBuilder localStringBuilder1 = new StringBuilder("initFileOnDetected...Exception, _ret:");
            localStringBuilder1.append(this.u);
            localStringBuilder1.append(",_failInfo:");
            localStringBuilder1.append(this.v);
            li.c("TaskImpl", localStringBuilder1.toString());
            K();
            return false;
          }
          StringBuilder localStringBuilder2;
          localObject2 = finally;
        }
        catch (Exception localException2)
        {
          li.a("TaskImpl", "initFileOnDetected...create RandomAccessFile for cfgFile failed.", localException2);
          this.u = -49;
          localStringBuilder3 = new StringBuilder("initFileOnDetected...create RandomAccessFile of path:");
          localStringBuilder3.append(this.Y.getAbsolutePath());
          localStringBuilder3.append(" fail.|");
          localStringBuilder3.append(localException2);
          this.v = localStringBuilder3.toString();
          if (lo.a(localException2)) {
            this.u = -12;
          } else if (lo.b(localException2)) {
            this.u = -13;
          }
          localStringBuilder2 = new StringBuilder("initFileOnDetected...Exception, _ret:");
          localStringBuilder2.append(this.u);
          localStringBuilder2.append(",_failInfo:");
          localStringBuilder2.append(this.v);
          li.c("TaskImpl", localStringBuilder2.toString());
          K();
          return false;
        }
      }
      label1625:
      continue;
      label1628:
      int i1 = 2;
      continue;
      label1633:
      i1 += 1;
    }
  }
  
  private boolean a(String paramString)
  {
    try
    {
      this.al = paramString;
      this.Z.seek(0L);
      this.Z.writeUTF(paramString);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      li.a("TaskImpl", "writeCfg fail. cfg:".concat(String.valueOf(paramString)), localException);
    }
    return false;
  }
  
  public final String A()
  {
    mk localmk = this.Q;
    if (localmk != null) {
      return localmk.a();
    }
    return "";
  }
  
  public final String B()
  {
    b localb = this.ah;
    if (localb != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (localb.a != null) {
        localStringBuilder.append(localb.a.c());
      }
      if (localb.b != null) {
        localStringBuilder.append(localb.b.c());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String C()
  {
    b localb = this.ah;
    if (localb != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (localb.a != null) {
        localStringBuilder.append(localb.a.d());
      }
      if (localb.b != null) {
        localStringBuilder.append(localb.b.d());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String D()
  {
    b localb = this.ah;
    if (localb != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (localb.a != null) {
        localStringBuilder.append(localb.a.e());
      }
      if (localb.b != null) {
        localStringBuilder.append(localb.b.e());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final void a(int paramInt, String paramString)
  {
    if ((t()) && (this.ai != null))
    {
      long l1 = System.currentTimeMillis();
      this.ai.a(new mh.a(l1 - this.w, paramInt, paramString));
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString, DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    StringBuilder localStringBuilder = new StringBuilder("cancel task...key:");
    localStringBuilder.append(this.q);
    localStringBuilder.append(",isFromUser:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",retCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",failInfo:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",newStatus:");
    localStringBuilder.append(paramDownloaderTaskStatus.name());
    li.b("TaskImpl", localStringBuilder.toString());
    this.aa = true;
    this.T = paramBoolean;
    if (!this.T)
    {
      this.u = paramInt;
      this.v = paramString;
    }
    this.C.a(paramDownloaderTaskStatus);
    paramString = this.ah;
    try
    {
      if (paramString.a != null) {
        paramString.a.b();
      }
      if (paramString.b != null) {
        paramString.b.b();
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
    return this.aa;
  }
  
  public final long a_()
  {
    return this.i;
  }
  
  public final String b()
  {
    return this.q;
  }
  
  public final String c()
  {
    return this.Q.b.a;
  }
  
  public final DownloaderTaskStatus d()
  {
    return this.C.b;
  }
  
  public final long e()
  {
    long l1 = this.g;
    if (l1 > 0L) {
      return l1;
    }
    if (this.h > 0L) {
      return this.h;
    }
    try
    {
      l1 = this.V.a;
      return l1;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public final boolean f()
  {
    if (t()) {
      return H();
    }
    return false;
  }
  
  public final int g()
  {
    long l2 = e();
    long l1 = l2;
    if (l2 == -1L)
    {
      mj localmj = this.V;
      l1 = l2;
      if (localmj != null) {
        l1 = localmj.a;
      }
    }
    if (l1 <= 0L) {
      return 0;
    }
    return (int)(this.i * 100L / l1);
  }
  
  public final String h()
  {
    return this.j;
  }
  
  public final String i()
  {
    return this.k;
  }
  
  public final String j()
  {
    return this.l;
  }
  
  public final void k()
  {
    Object localObject = this.C.b;
    StringBuilder localStringBuilder = new StringBuilder("trying pause...key:");
    localStringBuilder.append(this.q);
    localStringBuilder.append(",url:");
    localStringBuilder.append(c());
    localStringBuilder.append(", now status:");
    localStringBuilder.append(localObject);
    li.b("TaskImpl", localStringBuilder.toString());
    if ((localObject == DownloaderTaskStatus.PENDING) || (localObject == DownloaderTaskStatus.STARTED) || (localObject == DownloaderTaskStatus.DOWNLOADING))
    {
      a(true, 0, "", DownloaderTaskStatus.PAUSED);
      localObject = new StringBuilder("cancel task:");
      ((StringBuilder)localObject).append(this.q);
      li.c("TaskImpl", ((StringBuilder)localObject).toString());
      try
      {
        if (this.aj != null) {
          this.aj.a();
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
    synchronized (this.C)
    {
      DownloaderTaskStatus localDownloaderTaskStatus = this.C.b;
      StringBuilder localStringBuilder = new StringBuilder("trying resume...key:");
      localStringBuilder.append(this.q);
      localStringBuilder.append(",url:");
      localStringBuilder.append(c());
      localStringBuilder.append(", now status:");
      localStringBuilder.append(localDownloaderTaskStatus);
      li.b("TaskImpl", localStringBuilder.toString());
      if ((localDownloaderTaskStatus != DownloaderTaskStatus.STARTED) && (localDownloaderTaskStatus != DownloaderTaskStatus.DOWNLOADING) && (localDownloaderTaskStatus != DownloaderTaskStatus.COMPLETE) && (localDownloaderTaskStatus != DownloaderTaskStatus.PENDING))
      {
        if ((localDownloaderTaskStatus != DownloaderTaskStatus.DELETED) && (!this.C.f))
        {
          this.T = false;
          this.aa = false;
          this.n = true;
          this.t = 0;
          r();
          return true;
        }
        return false;
      }
      return true;
    }
  }
  
  public final int m()
  {
    return this.u;
  }
  
  public final String n()
  {
    try
    {
      String str = this.v;
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
    li.b("TaskImpl", localStringBuilder.toString());
    return bool;
    return false;
  }
  
  public final boolean p()
  {
    try
    {
      localFile = new File(this.j, ky.b(this.l));
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
    li.b("TaskImpl", localStringBuilder.toString());
    return bool;
    return false;
  }
  
  public final boolean q()
  {
    try
    {
      File localFile = new File(this.j, ky.a(this.l));
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
  
  public final void r()
  {
    this.U = System.currentTimeMillis();
    try
    {
      Object localObject = new StringBuilder("try add task ");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" to pool...");
      li.a("TaskImpl", ((StringBuilder)localObject).toString());
      this.C.a(DownloaderTaskStatus.PENDING);
      if (this.A) {}
      for (localObject = mu.a().b(this);; localObject = mu.a().a(this))
      {
        this.aj = ((ms)localObject);
        break;
      }
      localObject = new StringBuilder("task ");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" added to pool.");
      li.a("TaskImpl", ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      throw new DownloaderAddTaskException(String.valueOf(localException));
    }
  }
  
  public final void run()
  {
    this.u = 0;
    this.v = "";
    this.w = System.currentTimeMillis();
    this.x = SystemClock.elapsedRealtime();
    this.ak = 0L;
    synchronized (this.ah)
    {
      this.h = -1L;
      this.G = false;
      this.J = -1;
      this.B = 0;
      this.ab = 0;
      this.s.set(0L);
      ??? = new StringBuilder("task ");
      ((StringBuilder)???).append(this.q);
      ((StringBuilder)???).append(" start run... url:");
      ((StringBuilder)???).append(c());
      ((StringBuilder)???).append(",Thread:");
      ((StringBuilder)???).append(Thread.currentThread().getName());
      li.b("TaskImpl", ((StringBuilder)???).toString());
      if (this.aa)
      {
        ??? = new StringBuilder("task stopped at the beginning. url:");
        ((StringBuilder)???).append(c());
        ((StringBuilder)???).append(",Thread:");
        ((StringBuilder)???).append(Thread.currentThread().getName());
        li.b("TaskImpl", ((StringBuilder)???).toString());
        return;
      }
      this.C.a();
      this.z = new ma();
      this.ac = new lz(this);
      ??? = this.ac;
      ((lz)???).a = SystemClock.elapsedRealtime();
      ((lz)???).b = 0L;
      ((lz)???).c = 0L;
      boolean bool = F();
      this.C.a(DownloaderTaskStatus.STARTED);
      this.ai = new mh();
      a(ld.e(), ld.a);
      if (!bool)
      {
        a(false, this.u, this.v, DownloaderTaskStatus.FAILED);
      }
      else
      {
        ??? = this.V;
        int i1;
        if ((((mj)???).a > 0L) && (((mj)???).a == ((mj)???).c())) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          li.b("TaskImpl", "checkAlreadyCompleted");
          I();
        }
        else
        {
          ??? = this.ah.b();
          if (((lo)???).a != 0) {
            a(false, ((lo)???).a, ((lo)???).b, DownloaderTaskStatus.FAILED);
          }
        }
      }
      this.C.b();
      ??? = this.z;
      if (??? != null) {
        ((ma)???).b();
      }
      K();
      if (this.D)
      {
        q();
        o();
        if (this.e) {
          p();
        }
      }
      else if (L())
      {
        q();
      }
      this.s.set(0L);
      this.ai = null;
      ??? = this.ah;
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
      localObject2 = new File(this.j, this.l).getAbsolutePath();
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
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(this.l);
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    return localObject2;
  }
  
  public final boolean t()
  {
    return (this.C.b == DownloaderTaskStatus.STARTED) || (this.C.b == DownloaderTaskStatus.DOWNLOADING);
  }
  
  public final boolean u()
  {
    return this.C.b == DownloaderTaskStatus.DELETED;
  }
  
  public final boolean v()
  {
    return this.C.b == DownloaderTaskStatus.PAUSED;
  }
  
  public final long w()
  {
    lz locallz = this.ac;
    if (locallz != null) {
      return locallz.a();
    }
    return -1L;
  }
  
  public final int x()
  {
    lz locallz = this.ac;
    if (locallz != null) {
      return locallz.d;
    }
    return -1;
  }
  
  public final long y()
  {
    mj localmj = this.V;
    if (localmj != null) {
      return localmj.e();
    }
    return 0L;
  }
  
  public final String z()
  {
    mh localmh = this.ai;
    if (localmh != null) {
      return localmh.a();
    }
    return "";
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
    implements me
  {
    mf a;
    mf b;
    
    private b() {}
    
    private boolean a(String paramString)
    {
      boolean bool3 = ml.a(ml.this).a;
      boolean bool1 = false;
      boolean bool2 = false;
      if (bool3)
      {
        String str = ml.b(ml.this).e;
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
      }
      return bool1;
    }
    
    public final lo a(mf parammf, a parama, String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      Object localObject;
      int j;
      int i;
      label99:
      try
      {
        localObject = this.a;
        j = 1;
        if (parammf == localObject) {
          break label906;
        }
        if (parammf != this.b) {
          break label900;
        }
      }
      finally {}
      if ((i != 0) && (!parammf.a()) && (paramLong > 0L))
      {
        localObject = new lo(0, "");
        if (ml.b(ml.this) != null)
        {
          mj localmj = ml.b(ml.this);
          if (parammf.b.j != localmj) {
            break label912;
          }
          i = 1;
          break label915;
          if (ml.this.h == -1L) {
            if ((ml.this.g != -1L) && (paramLong != ml.this.g))
            {
              ((lo)localObject).a = -10;
              parammf = new StringBuilder("knownSize:");
              parammf.append(ml.this.g);
              parammf.append(",rspLength:");
              parammf.append(paramLong);
              ((lo)localObject).b = parammf.toString();
            }
            else
            {
              ml.this.h = paramLong;
              ml.this.n = paramBoolean;
              ml.this.o = paramString4;
              ml.this.p = paramString5;
              if (parammf.c != null) {
                ml.this.J = parammf.c.c;
              }
              if (!ml.this.n)
              {
                ml.a(ml.this, new mj(""));
                parammf.b = ml.b(ml.this).a();
              }
              else if (ml.b(ml.this).a > 0L)
              {
                if (ml.b(ml.this).a != ml.this.h)
                {
                  i = j;
                }
                else
                {
                  if (!a(paramString3)) {
                    break label923;
                  }
                  i = j;
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
          ml.a(ml.this, new mj(""));
          ((lo)localObject).a = 3;
          ((lo)localObject).b = "can not resume from cfg, start over now";
        }
        ml.b(ml.this).a = paramLong;
        ml.b(ml.this).a(paramString2);
        ml.b(ml.this).b(paramString3);
        if ((parammf.b.d == -1) && (parammf.b.c == -1)) {
          ml.b(ml.this).a(parammf.b);
        }
        if (((lo)localObject).a == 0)
        {
          if ((!ml.c(ml.this)) && (!ml.a(ml.this, paramLong))) {
            ml.this.a(false, ml.this.u, ml.this.v, DownloaderTaskStatus.FAILED);
          }
          ml.d(ml.this).a(b.a.c);
          break label690;
          if (paramLong != ml.this.h)
          {
            ((lo)localObject).a = -43;
            parammf = new StringBuilder("detectLength:");
            parammf.append(ml.this.h);
            parammf.append(",rspLength:");
            parammf.append(paramLong);
          }
          for (parammf = parammf.toString();; parammf = "not support range")
          {
            ((lo)localObject).b = parammf;
            break label690;
            if (ml.this.n) {
              break;
            }
            ((lo)localObject).a = 1;
          }
          if (a(paramString3))
          {
            ((lo)localObject).a = -68;
            parammf = new StringBuilder("detected VerifyProperty:");
            parammf.append(ml.b(ml.this).e);
            parammf.append(",rsp VerifyProperty:");
            parammf.append(paramString3);
            ((lo)localObject).b = parammf.toString();
          }
        }
        label690:
        if ((((lo)localObject).a == 0) && (!TextUtils.isEmpty(paramString1))) {
          if ((parama.b != a.a.b) && (parama.b != a.a.a))
          {
            if (parama.b == a.a.g)
            {
              parammf = ml.a(ml.this);
              parama = ld.a;
              if ((!TextUtils.isEmpty(parama)) && (!TextUtils.isEmpty(paramString1)))
              {
                parammf = parammf.a(parama);
                if (parammf != null) {
                  parammf.b(paramString1);
                }
              }
            }
          }
          else
          {
            parammf = ml.a(ml.this);
            parama = ld.a;
            if ((!TextUtils.isEmpty(parama)) && (!TextUtils.isEmpty(paramString1)))
            {
              parammf = parammf.a(parama);
              if (parammf != null) {
                parammf.a(paramString1);
              }
            }
          }
        }
        return localObject;
        for (;;)
        {
          ((lo)localObject).a = 2;
          ((lo)localObject).b = "not the same divider";
          parama = new StringBuilder("onValidResponse... fail...not self section:");
          parama.append(parammf.b);
          li.c("TaskImpl", parama.toString());
          return localObject;
          parammf = new lo(4, "");
          return parammf;
          label900:
          i = 0;
          break;
          label906:
          i = 1;
          break;
          label912:
          i = 0;
          label915:
          if (i != 0) {
            break label99;
          }
        }
        label923:
        i = 0;
      }
    }
    
    public final md a(mf parammf)
    {
      int i;
      if ((parammf != this.a) && (parammf != this.b)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return null;
      }
      if (!ml.this.n) {
        return null;
      }
      return ml.b(ml.this).a();
    }
    
    public final boolean a()
    {
      return ml.this.h != -1L;
    }
    
    /* Error */
    public final boolean a(mf arg1, long paramLong, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 75	com/tencent/token/ml$b:a	Lcom/tencent/token/mf;
      //   4: astore 11
      //   6: iconst_0
      //   7: istore 8
      //   9: aload_1
      //   10: aload 11
      //   12: if_acmpeq +20 -> 32
      //   15: aload_1
      //   16: aload_0
      //   17: getfield 77	com/tencent/token/ml$b:b	Lcom/tencent/token/mf;
      //   20: if_acmpne +6 -> 26
      //   23: goto +9 -> 32
      //   26: iconst_0
      //   27: istore 7
      //   29: goto +6 -> 35
      //   32: iconst_1
      //   33: istore 7
      //   35: iload 7
      //   37: ifne +5 -> 42
      //   40: iconst_0
      //   41: ireturn
      //   42: iload 5
      //   44: ifle +38 -> 82
      //   47: aload_0
      //   48: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   51: getfield 252	com/tencent/token/ml:r	Ljava/util/concurrent/atomic/AtomicLong;
      //   54: astore 11
      //   56: iload 5
      //   58: i2l
      //   59: lstore 9
      //   61: aload 11
      //   63: lload 9
      //   65: invokevirtual 258	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   68: pop2
      //   69: aload_0
      //   70: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   73: getfield 261	com/tencent/token/ml:s	Ljava/util/concurrent/atomic/AtomicLong;
      //   76: lload 9
      //   78: invokevirtual 258	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   81: pop2
      //   82: aload_0
      //   83: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   86: invokestatic 36	com/tencent/token/ml:b	(Lcom/tencent/token/ml;)Lcom/tencent/token/mj;
      //   89: ifnull +548 -> 637
      //   92: aload_0
      //   93: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   96: invokestatic 36	com/tencent/token/ml:b	(Lcom/tencent/token/ml;)Lcom/tencent/token/mj;
      //   99: astore 11
      //   101: aload_1
      //   102: getfield 92	com/tencent/token/mf:b	Lcom/tencent/token/md;
      //   105: getfield 98	com/tencent/token/md:j	Lcom/tencent/token/mj;
      //   108: aload 11
      //   110: if_acmpne +9 -> 119
      //   113: iconst_1
      //   114: istore 7
      //   116: goto +6 -> 122
      //   119: iconst_0
      //   120: istore 7
      //   122: iload 7
      //   124: ifne +5 -> 129
      //   127: iconst_0
      //   128: ireturn
      //   129: iload 6
      //   131: ifeq +188 -> 319
      //   134: aload_0
      //   135: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   138: iconst_0
      //   139: putfield 264	com/tencent/token/ml:B	I
      //   142: new 56	java/lang/StringBuilder
      //   145: dup
      //   146: ldc_w 266
      //   149: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   152: astore 11
      //   154: aload 11
      //   156: aload_1
      //   157: getfield 267	com/tencent/token/mf:a	Z
      //   160: invokevirtual 72	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   163: pop
      //   164: aload 11
      //   166: ldc_w 269
      //   169: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: pop
      //   173: aload 11
      //   175: aload_1
      //   176: getfield 92	com/tencent/token/mf:b	Lcom/tencent/token/md;
      //   179: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   182: pop
      //   183: ldc_w 271
      //   186: aload 11
      //   188: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   191: invokestatic 273	com/tencent/token/li:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   194: aload_1
      //   195: getfield 92	com/tencent/token/mf:b	Lcom/tencent/token/md;
      //   198: getfield 162	com/tencent/token/md:c	I
      //   201: iconst_m1
      //   202: if_icmpne +117 -> 319
      //   205: aload_0
      //   206: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   209: invokestatic 36	com/tencent/token/ml:b	(Lcom/tencent/token/ml;)Lcom/tencent/token/mj;
      //   212: aload_1
      //   213: getfield 92	com/tencent/token/mf:b	Lcom/tencent/token/md;
      //   216: invokevirtual 165	com/tencent/token/mj:a	(Lcom/tencent/token/md;)Z
      //   219: istore 6
      //   221: new 56	java/lang/StringBuilder
      //   224: dup
      //   225: ldc_w 266
      //   228: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   231: astore 11
      //   233: aload 11
      //   235: aload_1
      //   236: getfield 267	com/tencent/token/mf:a	Z
      //   239: invokevirtual 72	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   242: pop
      //   243: aload 11
      //   245: ldc_w 275
      //   248: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   251: pop
      //   252: aload 11
      //   254: aload_1
      //   255: getfield 92	com/tencent/token/mf:b	Lcom/tencent/token/md;
      //   258: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   261: pop
      //   262: aload 11
      //   264: ldc_w 277
      //   267: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: pop
      //   271: aload 11
      //   273: iload 6
      //   275: invokevirtual 72	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   278: pop
      //   279: aload 11
      //   281: ldc_w 279
      //   284: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   287: pop
      //   288: aload 11
      //   290: aload_0
      //   291: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   294: invokestatic 36	com/tencent/token/ml:b	(Lcom/tencent/token/ml;)Lcom/tencent/token/mj;
      //   297: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   300: pop
      //   301: ldc_w 271
      //   304: aload 11
      //   306: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   309: invokestatic 242	com/tencent/token/li:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   312: iload 6
      //   314: ifne +5 -> 319
      //   317: iconst_0
      //   318: ireturn
      //   319: iload 5
      //   321: ifle +314 -> 635
      //   324: aload_0
      //   325: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   328: invokevirtual 281	com/tencent/token/ml:v	()Z
      //   331: ifne +304 -> 635
      //   334: aload_0
      //   335: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   338: invokestatic 284	com/tencent/token/ml:e	(Lcom/tencent/token/ml;)Lcom/tencent/token/ma;
      //   341: astore 11
      //   343: aload_1
      //   344: getfield 92	com/tencent/token/mf:b	Lcom/tencent/token/md;
      //   347: getfield 162	com/tencent/token/md:c	I
      //   350: istore 7
      //   352: iload 5
      //   354: i2l
      //   355: lstore 9
      //   357: aload 11
      //   359: iload 7
      //   361: lload_2
      //   362: aload 4
      //   364: lload 9
      //   366: invokevirtual 289	com/tencent/token/ma:a	(IJ[BJ)V
      //   369: aload_1
      //   370: getfield 92	com/tencent/token/mf:b	Lcom/tencent/token/md;
      //   373: astore_1
      //   374: aload_1
      //   375: aload_1
      //   376: getfield 290	com/tencent/token/md:g	J
      //   379: lload 9
      //   381: ladd
      //   382: putfield 290	com/tencent/token/md:g	J
      //   385: aload_0
      //   386: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   389: invokestatic 36	com/tencent/token/ml:b	(Lcom/tencent/token/ml;)Lcom/tencent/token/mj;
      //   392: astore_1
      //   393: aload_1
      //   394: invokevirtual 293	com/tencent/token/mj:d	()J
      //   397: lstore_2
      //   398: lload_2
      //   399: lconst_0
      //   400: lcmp
      //   401: ifle +18 -> 419
      //   404: lload_2
      //   405: aload_1
      //   406: getfield 150	com/tencent/token/mj:a	J
      //   409: lcmp
      //   410: ifne +9 -> 419
      //   413: iconst_1
      //   414: istore 5
      //   416: goto +6 -> 422
      //   419: iconst_0
      //   420: istore 5
      //   422: iload 5
      //   424: ifeq +22 -> 446
      //   427: aload_0
      //   428: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   431: invokestatic 297	com/tencent/token/ml:f	(Lcom/tencent/token/ml;)Lcom/tencent/token/lz;
      //   434: invokestatic 302	java/lang/System:currentTimeMillis	()J
      //   437: putfield 306	com/tencent/token/lz:b	J
      //   440: invokestatic 311	com/tencent/token/ly:b	()Lcom/tencent/token/ly;
      //   443: invokevirtual 313	com/tencent/token/ly:c	()V
      //   446: iload 8
      //   448: istore 5
      //   450: invokestatic 311	com/tencent/token/ly:b	()Lcom/tencent/token/ly;
      //   453: invokevirtual 315	com/tencent/token/ly:g	()J
      //   456: ldc2_w 316
      //   459: lcmp
      //   460: ifle +6 -> 466
      //   463: iconst_1
      //   464: istore 5
      //   466: iload 5
      //   468: ifeq +167 -> 635
      //   471: aload_0
      //   472: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   475: invokestatic 319	com/tencent/token/ml:g	(Lcom/tencent/token/ml;)Z
      //   478: pop
      //   479: invokestatic 311	com/tencent/token/ly:b	()Lcom/tencent/token/ly;
      //   482: invokevirtual 313	com/tencent/token/ly:c	()V
      //   485: new 56	java/lang/StringBuilder
      //   488: dup
      //   489: ldc_w 321
      //   492: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   495: astore_1
      //   496: aload_1
      //   497: aload_0
      //   498: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   501: getfield 324	com/tencent/token/ml:q	Ljava/lang/String;
      //   504: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   507: pop
      //   508: aload_1
      //   509: ldc_w 326
      //   512: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   515: pop
      //   516: ldc 237
      //   518: aload_1
      //   519: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   522: invokestatic 242	com/tencent/token/li:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   525: aload_0
      //   526: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   529: invokestatic 328	com/tencent/token/ml:h	(Lcom/tencent/token/ml;)Z
      //   532: pop
      //   533: aload_0
      //   534: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   537: invokestatic 332	com/tencent/token/ml:i	(Lcom/tencent/token/ml;)Ljava/lang/Object;
      //   540: astore_1
      //   541: aload_1
      //   542: monitorenter
      //   543: aload_0
      //   544: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   547: invokestatic 332	com/tencent/token/ml:i	(Lcom/tencent/token/ml;)Ljava/lang/Object;
      //   550: ldc2_w 333
      //   553: invokevirtual 338	java/lang/Object:wait	(J)V
      //   556: aload_1
      //   557: monitorexit
      //   558: iconst_1
      //   559: ireturn
      //   560: astore 4
      //   562: aload_1
      //   563: monitorexit
      //   564: aload 4
      //   566: athrow
      //   567: astore_1
      //   568: aload_1
      //   569: invokevirtual 341	java/lang/OutOfMemoryError:printStackTrace	()V
      //   572: aload_0
      //   573: getfield 17	com/tencent/token/ml$b:c	Lcom/tencent/token/ml;
      //   576: astore_1
      //   577: new 56	java/lang/StringBuilder
      //   580: dup
      //   581: ldc_w 343
      //   584: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   587: astore 4
      //   589: aload 4
      //   591: iload 5
      //   593: invokevirtual 346	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   596: pop
      //   597: aload 4
      //   599: ldc_w 348
      //   602: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   605: pop
      //   606: aload 4
      //   608: invokestatic 311	com/tencent/token/ly:b	()Lcom/tencent/token/ly;
      //   611: invokevirtual 315	com/tencent/token/ly:g	()J
      //   614: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   617: pop
      //   618: aload_1
      //   619: iconst_0
      //   620: bipush 237
      //   622: aload 4
      //   624: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   627: getstatic 183	com/tencent/halley/downloader/DownloaderTaskStatus:FAILED	Lcom/tencent/halley/downloader/DownloaderTaskStatus;
      //   630: invokevirtual 186	com/tencent/token/ml:a	(ZILjava/lang/String;Lcom/tencent/halley/downloader/DownloaderTaskStatus;)V
      //   633: iconst_0
      //   634: ireturn
      //   635: iconst_1
      //   636: ireturn
      //   637: iconst_0
      //   638: ireturn
      //   639: astore_1
      //   640: iconst_1
      //   641: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	642	0	this	b
      //   0	642	2	paramLong	long
      //   0	642	4	paramArrayOfByte	byte[]
      //   0	642	5	paramInt	int
      //   0	642	6	paramBoolean	boolean
      //   27	333	7	i	int
      //   7	440	8	j	int
      //   59	321	9	l	long
      //   4	354	11	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   543	558	560	finally
      //   334	352	567	java/lang/OutOfMemoryError
      //   357	369	567	java/lang/OutOfMemoryError
      //   525	543	639	java/lang/Exception
      //   562	567	639	java/lang/Exception
    }
    
    public final lo b()
    {
      lo locallo;
      label168:
      try
      {
        locallo = new lo(0, "");
        this.a = new mf(ml.a(ml.this), true, ml.this.g, ml.this, this, ml.this.f, ml.this.L);
        try
        {
          mu.a().c(this.a);
        }
        catch (Exception localException1)
        {
          this.a = null;
          locallo.a = -67;
          localException1.printStackTrace();
        }
        if ((locallo.a == 0) && (!ml.this.A)) {
          this.b = new mf(ml.a(ml.this), false, ml.this.g, ml.this, this, ml.this.f, ml.this.L);
        }
      }
      finally {}
      try
      {
        mu.a().d(this.b);
      }
      catch (Exception localException2)
      {
        break label168;
      }
      this.b = null;
      return locallo;
    }
    
    public final void b(mf parammf)
    {
      int i;
      if ((parammf != this.a) && (parammf != this.b)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return;
      }
      if (parammf.b == null) {
        return;
      }
      ml.b(ml.this);
      parammf.b.i = false;
    }
    
    public final void c(mf parammf)
    {
      ??? = this.a;
      int j = 1;
      int i;
      if ((parammf != ???) && (parammf != this.b)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return;
      }
      for (;;)
      {
        synchronized (ml.j(ml.this))
        {
          if ((this.a != null) && (!this.a.f))
          {
            i = 0;
          }
          else
          {
            if ((!ml.this.L) || (this.b == null) || (this.b.f)) {
              break label301;
            }
            i = 0;
          }
          if (i != 0)
          {
            ??? = new StringBuilder("All Transports Finished, task:");
            ((StringBuilder)???).append(ml.this.q);
            li.c("TaskImpl", ((StringBuilder)???).toString());
            if (!ml.k(ml.this))
            {
              ??? = ml.b(ml.this);
              long l = ((mj)???).d();
              if ((l > 0L) && (l == ((mj)???).a)) {
                i = j;
              } else {
                i = 0;
              }
              if (i != 0) {
                return;
              }
              ml.this.u = parammf.d;
              ml.this.v = parammf.e;
              if (ml.this.u == 0)
              {
                parammf = ml.this;
                parammf.u = -69;
                ??? = new StringBuilder("readLen:");
                ((StringBuilder)???).append(ml.b(ml.this).d());
                parammf.v = ((StringBuilder)???).toString();
              }
              ml.d(ml.this).a(DownloaderTaskStatus.FAILED);
            }
          }
          return;
        }
        label301:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ml
 * JD-Core Version:    0.7.0.1
 */