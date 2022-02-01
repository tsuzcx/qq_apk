package c.t.m.g;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public final class d
  extends w
{
  private volatile Handler c = null;
  private volatile a d = new a((byte)0);
  private StringBuilder e = new StringBuilder();
  private AtomicInteger f = new AtomicInteger(0);
  
  public final int a()
  {
    ai.a(e(), 1001, 5000L);
    this.c = new Handler(ah.a("th_loc_task_t_consume").getLooper());
    this.e.setLength(0);
    this.f.set(0);
    return 0;
  }
  
  public final void a(Location paramLocation)
  {
    synchronized (this.b)
    {
      if (this.e.length() > 5120)
      {
        this.e.setLength(0);
        this.f.set(0);
      }
      if (this.e.length() > 0) {
        this.e.append('\n');
      }
      if (ai.c(h.j.a))
      {
        str = "null";
        paramLocation = String.format(Locale.ENGLISH, "%s,%d,%d,%.6f,%.6f,%.3f,%.3f,%.3f,%.3f,%d,%d,%d,%d,%d,%d,%d,%s,%s,%s", new Object[] { an.d(), Integer.valueOf(12), Integer.valueOf(0), Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getAltitude()), Float.valueOf(paramLocation.getAccuracy()), Float.valueOf(paramLocation.getBearing()), Float.valueOf(paramLocation.getSpeed()), Long.valueOf(paramLocation.getTime() / 1000L), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0), "null", str, "null" });
        this.e.append(paramLocation);
        this.f.getAndAdd(1);
        return;
      }
      String str = "loc_" + h.j.a;
    }
  }
  
  public final void a(Message arg1)
    throws Exception
  {
    switch (???.what)
    {
    }
    for (;;)
    {
      return;
      ??? = e();
      if (??? != null) {
        ???.removeMessages(1001);
      }
      ai.a(e(), 1001, 5000L);
      int i = this.f.get();
      synchronized (this.b)
      {
        String str = this.e.toString();
        this.e.setLength(0);
        this.f.set(0);
        if ((str.length() <= 0) || (this.c == null)) {
          continue;
        }
        this.d.a(str, i);
        ai.a(this.c, this.d);
        return;
      }
    }
  }
  
  public final void b()
  {
    this.e.setLength(0);
    this.f.set(0);
    this.d.a("", 0);
    this.c = null;
    ah.b("th_loc_task_t_consume");
  }
  
  public final String c()
  {
    return "GpsNaviPro";
  }
  
  static final class a
    implements aj.b, Runnable
  {
    private volatile String a;
    private volatile int b = 0;
    
    public final void a(String paramString)
    {
      ai.b("FC", "NaviGps," + this.b);
      if (ai.a()) {
        ai.a(3, "GpsNaviPro", "upload success:".concat(String.valueOf(paramString)), null);
      }
    }
    
    public final void a(String paramString, int paramInt)
    {
      if (ai.c(paramString)) {}
      for (this.a = "";; this.a = paramString)
      {
        this.b = paramInt;
        return;
      }
    }
    
    public final void b(String paramString)
    {
      if (ai.a()) {
        ai.a(3, "GpsNaviPro", "upload fail:".concat(String.valueOf(paramString)), null);
      }
    }
    
    public final void run()
    {
      try
      {
        if (ai.c(this.a)) {
          return;
        }
        byte[] arrayOfByte1 = this.a.getBytes("UTF-8");
        this.a = "";
        byte[] arrayOfByte2 = ai.a(arrayOfByte1);
        int n = arrayOfByte2.length;
        int i = (byte)(n >>> 24);
        int j = (byte)(n >>> 16);
        int k = (byte)(n >>> 8);
        int m = (byte)n;
        byte[] arrayOfByte3 = new byte[arrayOfByte2.length + 5];
        arrayOfByte3[0] = 1;
        System.arraycopy(new byte[] { i, j, k, m }, 0, arrayOfByte3, 1, 4);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 5, arrayOfByte2.length);
        arrayOfByte2 = af.a(arrayOfByte3, af.a("fc_gps_for_navi"));
        if (ai.a()) {
          ai.a(3, "GpsNaviPro", "start upload:strBytes=" + arrayOfByte1.length + ",encBytes=" + arrayOfByte2.length, null);
        }
        t.a.a("https://rttgpsreport.map.qq.com/report?type=sdk&key=5e1fe70424035ee83066ac22b24f31dc", arrayOfByte2, this);
        return;
      }
      catch (Throwable localThrowable)
      {
        if (ai.a()) {
          ai.a("GpsNaviPro", "upload error.", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.d
 * JD-Core Version:    0.7.0.1
 */