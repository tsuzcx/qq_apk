package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

public final class ax
{
  private static ax a = new ax();
  private int b = a.a;
  private LinkedList<bk> c = new LinkedList();
  
  public static ax a()
  {
    return a;
  }
  
  public final int a(bk parambk)
  {
    if (parambk != null)
    {
      try
      {
        while (this.c.size() > 9) {
          this.c.remove(0);
        }
        if (this.c.size() <= 0) {
          break label136;
        }
      }
      finally {}
      for (;;)
      {
        localbk = (bk)this.c.getFirst();
        long l1 = parambk.b;
        long l2 = localbk.b;
        double d = cf.a(localbk.a.getLatitude(), localbk.a.getLongitude(), parambk.a.getLatitude(), parambk.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      bk localbk = new bk(parambk);
      this.c.add(localbk);
      parambk.a.getSpeed();
    }
    int i = this.c.size();
    return i;
  }
  
  public final long b()
  {
    for (;;)
    {
      double d1;
      double d2;
      long l1;
      try
      {
        int j;
        int i;
        bk localbk2;
        if (this.c.size() < 2)
        {
          d1 = 0.0D;
          if (this.c.size() < 2) {
            continue;
          }
          j = this.c.size();
          i = 1;
          d2 = 0.0D;
          l1 = 0L;
          if (i < j)
          {
            localbk1 = (bk)this.c.get(i);
            localbk2 = (bk)this.c.get(i - 1);
            double d3 = cf.a(localbk2.a.getLatitude(), localbk2.a.getLongitude(), localbk1.a.getLatitude(), localbk1.a.getLongitude());
            long l2 = localbk1.b;
            long l3 = localbk2.b;
            i += 1;
            d2 += d3;
            l1 += l2 - l3;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localbk1 = (bk)this.c.get(i);
          localbk2 = (bk)this.c.get(i - 1);
          if (localbk1.b == localbk2.b) {
            break label523;
          }
          l1 = localbk1.b - localbk2.b;
          d1 = cf.a(localbk2.a.getLatitude(), localbk2.a.getLongitude(), localbk1.a.getLatitude(), localbk1.a.getLongitude()) / l1 * 1000.0D;
          continue;
        }
        if (l1 > 0L)
        {
          d2 = 1000.0D * (d2 / l1);
          if ((ba.b() != null) && (this.c.size() > 0)) {
            ba.b().a(2, d2, d1, ((bk)this.c.getLast()).b);
          }
          if (this.c.size() < 2)
          {
            l1 = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = a.a;
            i = this.b;
            j = a.c;
            if (i != j) {
              break label515;
            }
            l1 = 90000L;
            return l1;
          }
        }
        else
        {
          d2 = 0.0D;
          continue;
        }
        bk localbk1 = (bk)this.c.getFirst();
        l1 = ((bk)this.c.getLast()).b - localbk1.b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = a.c;
          continue;
        }
        if (l1 <= 60000L) {
          break label505;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = a.c;
      }
      else
      {
        label505:
        this.b = a.b;
        continue;
        label515:
        l1 = 30000L;
        continue;
        label523:
        l1 = 500L;
      }
    }
  }
  
  static enum a
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ax
 * JD-Core Version:    0.7.0.1
 */