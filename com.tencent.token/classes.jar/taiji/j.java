package taiji;

import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.token.iu;
import java.util.List;
import uilib.doraemon.e;

public class j
  implements i, o
{
  private final Path a = new Path();
  private final String b;
  private final e c;
  private final ce.b d;
  private final n e;
  private final n f;
  private final n g;
  private final n h;
  private final n i;
  private final n j;
  private final n k;
  private m l;
  private boolean m;
  
  public j(e parame, bd parambd, ce paramce)
  {
    this.c = parame;
    this.b = paramce.a();
    this.d = paramce.b();
    this.e = paramce.c().a();
    this.f = paramce.d().c();
    this.g = paramce.e().a();
    this.i = paramce.g().a();
    this.k = paramce.i().a();
    if (this.d == ce.b.a) {
      this.h = paramce.f().a();
    }
    for (this.j = paramce.h().a();; this.j = null)
    {
      parambd.a(this.e);
      parambd.a(this.f);
      parambd.a(this.g);
      parambd.a(this.i);
      parambd.a(this.k);
      if (this.d == ce.b.a)
      {
        parambd.a(this.h);
        parambd.a(this.j);
      }
      this.e.a(this);
      this.f.a(this);
      this.g.a(this);
      this.i.a(this);
      this.k.a(this);
      if (this.d == ce.b.a)
      {
        this.i.a(this);
        this.k.a(this);
      }
      return;
      this.h = null;
    }
  }
  
  private void d()
  {
    this.m = false;
    this.c.invalidateSelf();
  }
  
  private void e()
  {
    float f8 = ((Float)this.e.b()).floatValue();
    double d1;
    float f17;
    float f14;
    float f18;
    if (this.g == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f17 = (float)(6.283185307179586D / f8);
      f14 = f17 / 2.0F;
      f18 = f8 - (int)f8;
      if (f18 == 0.0F) {
        break label840;
      }
      d1 += (1.0F - f18) * f14;
    }
    label265:
    label551:
    label560:
    label569:
    label578:
    label709:
    label840:
    for (;;)
    {
      float f3 = ((Float)this.i.b()).floatValue();
      float f4 = ((Float)this.h.b()).floatValue();
      if (this.j != null) {}
      for (float f1 = ((Float)this.j.b()).floatValue() / 100.0F;; f1 = 0.0F)
      {
        float f2 = 0.0F;
        if (this.k != null) {
          f2 = ((Float)this.k.b()).floatValue() / 100.0F;
        }
        float f5;
        float f6;
        float f7;
        label223:
        double d2;
        int i1;
        int n;
        float f10;
        float f9;
        if (f18 != 0.0F)
        {
          f5 = (f3 - f4) * f18 + f4;
          f6 = (float)(f5 * Math.cos(d1));
          f7 = (float)(f5 * Math.sin(d1));
          this.a.moveTo(f6, f7);
          d1 += f17 * f18 / 2.0F;
          d2 = Math.ceil(f8) * 2.0D;
          i1 = 0;
          n = 0;
          f10 = f6;
          f9 = f7;
          label248:
          if (i1 >= d2) {
            break label771;
          }
          if (n == 0) {
            break label467;
          }
          f6 = f3;
          if ((f5 == 0.0F) || (i1 != d2 - 2.0D)) {
            break label827;
          }
        }
        for (float f11 = f17 * f18 / 2.0F;; f11 = f14)
        {
          f7 = f6;
          if (f5 != 0.0F)
          {
            f7 = f6;
            if (i1 == d2 - 1.0D) {
              f7 = f5;
            }
          }
          float f15 = (float)(f7 * Math.cos(d1));
          float f16 = (float)(f7 * Math.sin(d1));
          if ((f1 == 0.0F) && (f2 == 0.0F))
          {
            this.a.lineTo(f15, f16);
            double d3 = f11;
            if (n != 0) {
              break label765;
            }
            n = 1;
            label382:
            i1 += 1;
            f9 = f16;
            f10 = f15;
            d1 += d3;
            break label248;
            d1 = ((Float)this.g.b()).floatValue();
            break;
            f6 = (float)(f3 * Math.cos(d1));
            f7 = (float)(f3 * Math.sin(d1));
            this.a.moveTo(f6, f7);
            d1 += f14;
            f5 = 0.0F;
            break label223;
            label467:
            f6 = f4;
            break label265;
          }
          f6 = (float)(Math.atan2(f9, f10) - 1.570796326794897D);
          f8 = (float)Math.cos(f6);
          float f21 = (float)Math.sin(f6);
          f6 = (float)(Math.atan2(f16, f15) - 1.570796326794897D);
          float f19 = (float)Math.cos(f6);
          float f20 = (float)Math.sin(f6);
          float f12;
          float f13;
          if (n != 0)
          {
            f6 = f1;
            if (n == 0) {
              break label709;
            }
            f7 = f2;
            if (n == 0) {
              break label716;
            }
            f12 = f4;
            if (n == 0) {
              break label723;
            }
            f13 = f3;
            f8 *= f12 * f6 * 0.47829F;
            f12 = f12 * f6 * 0.47829F * f21;
            f6 = f13 * f7 * 0.47829F * f19;
            f7 = f13 * f7 * 0.47829F * f20;
            if (f18 == 0.0F) {
              break label808;
            }
            if (i1 != 0) {
              break label730;
            }
            f12 *= f18;
            f13 = f8 * f18;
            f8 = f7;
            f7 = f6;
            f6 = f13;
          }
          for (;;)
          {
            this.a.cubicTo(f10 - f6, f9 - f12, f7 + f15, f8 + f16, f15, f16);
            break;
            f6 = f2;
            break label551;
            f7 = f1;
            break label560;
            label716:
            f12 = f3;
            break label569;
            label723:
            f13 = f4;
            break label578;
            label730:
            if (i1 == d2 - 1.0D)
            {
              f13 = f7 * f18;
              f7 = f6 * f18;
              f6 = f8;
              f8 = f13;
              continue;
              label765:
              n = 0;
              break label382;
              PointF localPointF = (PointF)this.f.b();
              this.a.offset(localPointF.x, localPointF.y);
              this.a.close();
              return;
            }
            f13 = f7;
            f7 = f6;
            f6 = f8;
            f8 = f13;
          }
        }
      }
    }
  }
  
  private void f()
  {
    int n = (int)Math.floor(((Float)this.e.b()).floatValue());
    double d1;
    float f5;
    float f1;
    float f2;
    double d3;
    label134:
    float f4;
    float f3;
    if (this.g == null)
    {
      d1 = 0.0D;
      d1 = Math.toRadians(d1 - 90.0D);
      f5 = (float)(6.283185307179586D / n);
      float f6 = ((Float)this.k.b()).floatValue() / 100.0F;
      float f7 = ((Float)this.i.b()).floatValue();
      f1 = (float)(f7 * Math.cos(d1));
      f2 = (float)(f7 * Math.sin(d1));
      this.a.moveTo(f1, f2);
      d3 = f5;
      double d2 = Math.ceil(n);
      n = 0;
      d1 += d3;
      if (n >= d2) {
        break label365;
      }
      f4 = (float)(f7 * Math.cos(d1));
      f3 = (float)(f7 * Math.sin(d1));
      if (f6 == 0.0F) {
        break label351;
      }
      float f9 = (float)(Math.atan2(f2, f1) - 1.570796326794897D);
      float f8 = (float)Math.cos(f9);
      f9 = (float)Math.sin(f9);
      float f11 = (float)(Math.atan2(f3, f4) - 1.570796326794897D);
      float f10 = (float)Math.cos(f11);
      f11 = (float)Math.sin(f11);
      this.a.cubicTo(f1 - f8 * (f7 * f6 * 0.25F), f2 - f7 * f6 * 0.25F * f9, f4 + f10 * (f7 * f6 * 0.25F), f11 * (f7 * f6 * 0.25F) + f3, f4, f3);
    }
    for (;;)
    {
      d3 = f5;
      n += 1;
      f1 = f4;
      d1 += d3;
      f2 = f3;
      break label134;
      d1 = ((Float)this.g.b()).floatValue();
      break;
      label351:
      this.a.lineTo(f4, f3);
    }
    label365:
    PointF localPointF = (PointF)this.f.b();
    this.a.offset(localPointF.x, localPointF.y);
    this.a.close();
  }
  
  public Path a()
  {
    if (this.m) {
      return this.a;
    }
    this.a.reset();
    switch (k.a[this.d.ordinal()])
    {
    }
    for (;;)
    {
      this.a.close();
      iu.a(this.a, this.l);
      this.m = true;
      return this.a;
      e();
      continue;
      f();
    }
  }
  
  public void a(List paramList1, List paramList2)
  {
    int n = 0;
    while (n < paramList1.size())
    {
      paramList2 = (cx)paramList1.get(n);
      if (((paramList2 instanceof m)) && (((m)paramList2).a() == cn.b.a))
      {
        this.l = ((m)paramList2);
        this.l.a(this);
      }
      n += 1;
    }
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.j
 * JD-Core Version:    0.7.0.1
 */