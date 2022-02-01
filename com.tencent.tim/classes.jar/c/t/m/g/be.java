package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

public final class be
{
  private int a = 10;
  private int b = 4;
  private LinkedList<a> c = new LinkedList();
  private cd d = new cd();
  
  private boolean a(a parama, ap paramap)
  {
    if (paramap != null) {}
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        if (this.c != null)
        {
          i = this.c.size();
          if (i != 0) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        if (parama.d == 3)
        {
          bool = true;
          continue;
        }
        if ((parama.d == 1) && (!cg.a(paramap)) && (!cg.b(paramap)))
        {
          bool = true;
          continue;
        }
        if (parama.c - ((a)this.c.getLast()).c > 120000L)
        {
          this.c.clear();
          bool = true;
          continue;
        }
        if (this.c.size() < this.b) {
          break label314;
        }
        i = 1;
        if (i != 0)
        {
          i = 0;
          int j = 0;
          double d2 = 0.0D;
          double d1 = 0.0D;
          paramap = this.c.listIterator(this.c.size());
          if (paramap.hasPrevious())
          {
            a locala = (a)paramap.previous();
            d1 = cf.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D);
            d2 += d1;
            if (d1 <= 50.0D) {
              break label299;
            }
            i += 1;
            j += 1;
            if (j <= this.b) {
              break label296;
            }
            break label302;
            ba.b().a(1, d2 / j, d1, parama.c);
          }
        }
        else
        {
          bool = true;
          continue;
        }
      }
      finally {}
      label296:
      continue;
      label299:
      continue;
      label302:
      if (i > 1)
      {
        bool = false;
        continue;
        label314:
        i = 0;
      }
    }
  }
  
  public final void a()
  {
    try
    {
      this.c.clear();
      this.d.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(by paramby)
  {
    label1206:
    for (;;)
    {
      cd localcd;
      double d2;
      double d3;
      double d1;
      long l3;
      try
      {
        if (paramby.getProvider().equalsIgnoreCase("gps"))
        {
          boolean bool = n.a().d("gps_kalman");
          if (!bool) {
            return;
          }
        }
        if ((this.c == null) || ((this.c != null) && (this.c.size() == 0))) {
          continue;
        }
        localcd = this.d;
        d2 = paramby.getLatitude();
        d3 = paramby.getLongitude();
        d1 = paramby.getAccuracy();
        l3 = paramby.getTime();
        if (d1 >= 1.0D) {
          break label1206;
        }
        d1 = 1.0D;
        new StringBuilder("lat_me:").append(d2).append(",lng_me:").append(d3).append(",accuracy:").append(d1).append(",time:").append(l3).append(",lat:").append(localcd.d).append(",lng:").append(localcd.e);
        if (l3 - localcd.c >= 20000L)
        {
          localcd.a();
          new StringBuilder("Time:").append(l3).append(",last_time:").append(localcd.c);
        }
        localcd.a = ((float)(Math.abs(d2 - localcd.d) * 1000000.0D));
        localcd.b = ((float)(Math.abs(d3 - localcd.e) * 1000000.0D));
        new StringBuilder("Q:").append(localcd.a).append(",QLng:").append(localcd.b);
        if (localcd.f < 0.0D)
        {
          localcd.c = l3;
          localcd.d = d2;
          localcd.e = d3;
          localcd.f = (d1 * d1);
          d1 = this.d.d;
          d2 = this.d.e;
          paramby.b.a = (Math.round(d1 * 1000000.0D) / 1000000.0D);
          paramby.b.b = (Math.round(d2 * 1000000.0D) / 1000000.0D);
          continue;
        }
        l2 = l3 - localcd.c;
      }
      finally {}
      long l2;
      long l1 = l2;
      if (l2 < 1000L) {
        l1 = 1000L;
      }
      if (l1 > 0L)
      {
        localcd.f += l1;
        localcd.g += l1;
      }
      double d4 = localcd.f / (localcd.f + d1 * d1 + localcd.a * 5.0F);
      double d5 = localcd.g / (localcd.g + d1 * d1 + localcd.b * 5.0F);
      new StringBuilder("K:").append(d4).append(",KLng:").append(d5);
      if ((d4 >= 0.4D) && (d5 >= 0.4D))
      {
        double d6 = localcd.d;
        if (((localcd.h > 0.0D) && (d2 - localcd.d > 0.0D)) || ((localcd.h < 0.0D) && (d2 - localcd.d < 0.0D))) {
          localcd.d += localcd.h * (l1 / 1000L);
        }
        localcd.d += (d2 - localcd.d) * d4;
        new StringBuilder("lat:").append(localcd.d).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localcd.h = ((localcd.d - d6) / (l1 / 1000L));
        d6 = localcd.e;
        if (((localcd.i > 0.0D) && (d3 - localcd.e > 0.0D)) || ((localcd.i < 0.0D) && (d3 - localcd.e < 0.0D))) {
          localcd.e += localcd.i * (l1 / 1000L);
        }
        localcd.e += (d3 - localcd.e) * d5;
        new StringBuilder("lng:").append(localcd.e).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localcd.i = ((localcd.e - d6) / (l1 / 1000L));
        localcd.f = ((1.0D - d4) * localcd.f);
        localcd.g = ((1.0D - d5) * localcd.g);
        localcd.c = l3;
        new StringBuilder("last_metres_per_second:").append(localcd.h).append(",last_metres_per_second_lng:").append(localcd.i);
      }
      for (;;)
      {
        new StringBuilder("variance:").append(localcd.f).append(",vaLng:").append(localcd.g);
        if ((d1 != 30.0D) || (d4 < 0.5D) || (d5 < 0.5D)) {
          break;
        }
        localcd.d = d2;
        localcd.e = d3;
        localcd.c = l3;
        localcd.h = 0.0D;
        localcd.i = 0.0D;
        localcd.f = (d1 * d1);
        break;
        if (((localcd.h > 0.0D) && (d2 - localcd.d > 0.0D)) || ((localcd.h < 0.0D) && (d2 - localcd.d < 0.0D))) {
          localcd.d += localcd.h * (l1 / 1000L);
        }
        if (((localcd.i > 0.0D) && (d3 - localcd.e > 0.0D)) || ((localcd.i < 0.0D) && (d3 - localcd.e < 0.0D))) {
          localcd.e += localcd.i * (l1 / 1000L);
        }
        localcd.f -= l1;
        localcd.g -= l1;
      }
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(a.a(paramTencentLocation));
      if (this.c.size() > this.a) {
        this.c.removeFirst();
      }
      return;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  public final boolean a(TencentLocation paramTencentLocation, ap paramap)
  {
    try
    {
      boolean bool = a(a.a(paramTencentLocation), paramap);
      return bool;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  static final class a
  {
    double a;
    double b;
    long c;
    int d;
    private double e;
    
    static a a(TencentLocation paramTencentLocation)
    {
      int i = 2;
      a locala = new a();
      locala.a = paramTencentLocation.getLatitude();
      locala.b = paramTencentLocation.getLongitude();
      locala.c = paramTencentLocation.getTime();
      locala.e = paramTencentLocation.getSpeed();
      if (TencentLocationUtils.isFromGps(paramTencentLocation))
      {
        if (paramTencentLocation.getAccuracy() < 100.0F) {
          i = 3;
        }
        locala.d = i;
        return locala;
      }
      if (paramTencentLocation.getAccuracy() < 500.0F) {}
      for (;;)
      {
        locala.d = i;
        return locala;
        i = 1;
      }
    }
    
    public final String toString()
    {
      return "[" + this.a + "," + this.b + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.be
 * JD-Core Version:    0.7.0.1
 */