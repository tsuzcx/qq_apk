package c.t.m.g;

import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  extends w
{
  private final StringBuilder c = new StringBuilder();
  private final File d;
  private volatile long e = 0L;
  private volatile long f = 0L;
  private final long[] g = new long[2];
  private final int[] h = new int[2];
  private ArrayList<Float> i = new ArrayList();
  private ArrayList<Float> j = new ArrayList();
  private HashSet<Integer> k = new HashSet();
  private volatile long l;
  private volatile int m;
  private volatile int n;
  private volatile int o;
  private volatile float p;
  private volatile float q;
  private AtomicBoolean r = new AtomicBoolean(false);
  
  public e(File paramFile)
  {
    this.d = paramFile;
  }
  
  private void a(String paramString)
  {
    if (ai.c(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject = paramString.getBytes("UTF-8");
          paramString = j.a((byte[])localObject, 3);
          if (ai.a()) {
            ai.a(3, "UserTrackPro", "srcBytes.len=" + localObject.length + ",encBytes.len=" + paramString.length, null);
          }
          localObject = "utr_" + ai.c(c.class.getName(), "SHA-256").substring(0, 8) + "_" + ae.b("yyyyMMdd");
          localObject = new File(this.d, (String)localObject);
          ai.a((File)localObject, paramString, true);
          if (((File)localObject).length() > 51200L)
          {
            ((File)localObject).renameTo(new File(((File)localObject).getParent(), ((File)localObject).getName() + "_" + ae.b("HHmmss")));
            return;
          }
        }
        catch (Throwable paramString) {}
      }
    } while (!ai.a());
    ai.a("UserTrackPro", "writeStrToFile error.", paramString);
  }
  
  private void g()
  {
    this.f = System.currentTimeMillis();
    this.c.setLength(0);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.g, 0L);
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.e < 60000L) {
      if (ai.a()) {
        ai.a(3, "UserTrackPro", "last upload time: < 1min", null);
      }
    }
    for (;;)
    {
      return;
      this.e = l1;
      ad.a();
      ak.a locala = ak.a();
      boolean bool;
      if (locala == ak.a.a) {
        bool = false;
      }
      label193:
      while (bool)
      {
        ah.a("th_loc_task_t_consume", new e.1(this));
        return;
        if (locala == ak.a.b)
        {
          bool = h.f;
          if ((h.f) || (!h.g)) {
            break label193;
          }
          long l2 = ((Long)am.b("LocationSDK", "log_utr_up_in_m", Long.valueOf(l1))).longValue();
          if (l1 - l2 <= 86400000L) {
            break label193;
          }
          am.a("LocationSDK", "log_utr_up_in_m", Long.valueOf(l1));
          if (ai.a()) {
            ai.a(3, "UserTrackPro", "upload in mobile once today. lastUpT=" + l2 + ",curT=" + l1, null);
          }
        }
        bool = true;
      }
    }
  }
  
  public final int a()
  {
    this.l = 0L;
    this.o = -1;
    this.n = -1;
    a(1001, 0L);
    return 0;
  }
  
  public final void a(Location paramLocation)
  {
    long l1;
    synchronized (this.b)
    {
      if (!f()) {
        return;
      }
      l1 = System.currentTimeMillis();
      if (l1 - this.g[0] < 900L) {
        return;
      }
    }
    this.g[0] = l1;
    Object localObject = this.h;
    localObject[0] += 1;
    if (paramLocation != null) {}
    for (;;)
    {
      try
      {
        boolean bool = "gps".equals(paramLocation.getProvider());
        if (!bool) {
          return;
        }
        bool = h.h;
        if (Build.VERSION.SDK_INT >= 18)
        {
          bool = paramLocation.isFromMockProvider();
          if (bool) {
            return;
          }
        }
        if (l1 - this.l <= 2000L) {
          continue;
        }
        paramLocation = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,-1,-1,0,-1,0", new Object[] { Long.valueOf(l1), Long.valueOf(paramLocation.getTime()), Integer.valueOf(0), Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getAltitude()), Float.valueOf(paramLocation.getAccuracy()), Float.valueOf(paramLocation.getSpeed()), Float.valueOf(paramLocation.getBearing()) });
        localHandler = e();
        if (localHandler != null)
        {
          if (localHandler != null) {
            continue;
          }
          localObject = new Message();
          ((Message)localObject).what = 1003;
          ((Message)localObject).arg1 = 0;
          ((Message)localObject).arg2 = 0;
          ((Message)localObject).obj = paramLocation;
          ai.a(localHandler, (Message)localObject, 0L);
        }
      }
      catch (Throwable paramLocation)
      {
        Handler localHandler;
        if (!ai.a()) {
          continue;
        }
        ai.a("UserTrackPro", "set gps loc error.", paramLocation);
        continue;
      }
      return;
      paramLocation = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%d,%d,%.2f,%d,%.2f", new Object[] { Long.valueOf(l1), Long.valueOf(paramLocation.getTime()), Integer.valueOf(0), Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getAltitude()), Float.valueOf(paramLocation.getAccuracy()), Float.valueOf(paramLocation.getSpeed()), Float.valueOf(paramLocation.getBearing()), Integer.valueOf(this.m), Integer.valueOf(this.n), Float.valueOf(this.p), Integer.valueOf(this.o), Float.valueOf(this.q) });
      continue;
      localObject = localHandler.obtainMessage(1003);
    }
  }
  
  public final void a(Message paramMessage)
    throws Exception
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1003: 
      String str1 = (String)paramMessage.obj;
      long l1 = System.currentTimeMillis();
      StringBuilder localStringBuilder1;
      String str2;
      String str3;
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder3;
      if (this.c.length() == 0)
      {
        localStringBuilder1 = this.c;
        str2 = an.i().replaceAll("[| _,]", "") + "_" + an.h() + "_" + an.j();
        str3 = ((String)ai.a(Build.MANUFACTURER, "")).replaceAll("[| _,]", "") + "_" + ((String)ai.a(an.g(), "")).replaceAll("[| _,]", "");
        localStringBuilder2 = new StringBuilder();
        localStringBuilder3 = localStringBuilder2.append("SYSTEM,").append(System.currentTimeMillis()).append(',').append(an.d()).append(',');
        if (h.i != null) {
          break label438;
        }
      }
      for (paramMessage = "";; paramMessage = aj.a(h.i.c))
      {
        localStringBuilder3.append(paramMessage).append(',').append(str2).append(',').append(str3).append(',').append(Build.VERSION.SDK_INT).append(',').append(k.a()).append(',').append(k.c()).append(',').append(k.d().replaceAll(":", "").toLowerCase()).append(',').append(k.b());
        localStringBuilder1.append(localStringBuilder2.toString());
        this.f = l1;
        this.c.append('$').append(str1);
        if ((this.c.length() < 15360L) && ((this.f == 0L) || (l1 - this.f < 600000L))) {
          break;
        }
        if (this.h[0] + this.h[1] >= 3) {
          a(this.c.toString());
        }
        this.c.setLength(0);
        Arrays.fill(this.h, 0);
        return;
      }
    case 1002: 
      paramMessage = e();
      if (paramMessage != null) {
        paramMessage.removeCallbacksAndMessages(null);
      }
      if (this.h[0] + this.h[1] >= 3) {
        a(this.c.toString());
      }
      g();
      h();
      return;
    case 1001: 
      label438:
      g();
      this.e = (System.currentTimeMillis() - 40000L);
      a(1004, 300000L);
      return;
    }
    a(1004, 1800000L);
    h();
  }
  
  public final void b()
  {
    a(1002, 0L);
    this.i.clear();
    this.j.clear();
    this.k.clear();
  }
  
  public final String c()
  {
    return "UserTrackPro";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.e
 * JD-Core Version:    0.7.0.1
 */