package taiji;

import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.token.gq;
import java.util.List;
import uilib.doraemon.e;

public class i
  implements h, l.a
{
  private final Path a = new Path();
  private final String b;
  private final e c;
  private final ce.b d;
  private final l<?, Float> e;
  private final l<?, PointF> f;
  private final l<?, Float> g;
  private final l<?, Float> h;
  private final l<?, Float> i;
  private final l<?, Float> j;
  private final l<?, Float> k;
  private k l;
  private boolean m;
  
  public i(e parame, ar paramar, ce paramce)
  {
    this.c = parame;
    this.b = paramce.a();
    this.d = paramce.b();
    this.e = paramce.c().a();
    this.f = paramce.d().c();
    this.g = paramce.e().a();
    this.i = paramce.g().a();
    this.k = paramce.i().a();
    if (this.d == ce.b.a)
    {
      this.h = paramce.f().a();
      parame = paramce.h().a();
    }
    else
    {
      parame = null;
      this.h = null;
    }
    this.j = parame;
    paramar.a(this.e);
    paramar.a(this.f);
    paramar.a(this.g);
    paramar.a(this.i);
    paramar.a(this.k);
    if (this.d == ce.b.a)
    {
      paramar.a(this.h);
      paramar.a(this.j);
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
  }
  
  private void d()
  {
    this.m = false;
    this.c.invalidateSelf();
  }
  
  private void e()
  {
    float f1 = ((Float)this.e.b()).floatValue();
    Object localObject = this.g;
    if (localObject == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)((l)localObject).b()).floatValue();
    }
    double d2 = Math.toRadians(d1 - 90.0D);
    double d3 = f1;
    Double.isNaN(d3);
    float f10 = (float)(6.283185307179586D / d3);
    float f8 = f10 / 2.0F;
    float f22 = f1 - (int)f1;
    double d1 = d2;
    if (f22 != 0.0F)
    {
      d1 = (1.0F - f22) * f8;
      Double.isNaN(d1);
      d1 = d2 + d1;
    }
    float f7 = ((Float)this.i.b()).floatValue();
    f1 = ((Float)this.h.b()).floatValue();
    localObject = this.j;
    float f4;
    if (localObject != null) {
      f4 = ((Float)((l)localObject).b()).floatValue() / 100.0F;
    } else {
      f4 = 0.0F;
    }
    localObject = this.k;
    float f6;
    if (localObject != null) {
      f6 = ((Float)((l)localObject).b()).floatValue() / 100.0F;
    } else {
      f6 = 0.0F;
    }
    float f3;
    double d4;
    if (f22 != 0.0F)
    {
      f3 = (f7 - f1) * f22 + f1;
      d2 = f3;
      d4 = Math.cos(d1);
      Double.isNaN(d2);
      f2 = (float)(d2 * d4);
      d4 = Math.sin(d1);
      Double.isNaN(d2);
      f5 = (float)(d2 * d4);
      this.a.moveTo(f2, f5);
      d2 = f10 * f22 / 2.0F;
      Double.isNaN(d2);
      d1 += d2;
    }
    else
    {
      d2 = f7;
      d4 = Math.cos(d1);
      Double.isNaN(d2);
      f2 = (float)(d2 * d4);
      d4 = Math.sin(d1);
      Double.isNaN(d2);
      f5 = (float)(d2 * d4);
      this.a.moveTo(f2, f5);
      d2 = f8;
      Double.isNaN(d2);
      d1 += d2;
      f3 = 0.0F;
    }
    d2 = Math.ceil(d3) * 2.0D;
    int n = 0;
    int i1 = 0;
    float f12 = f5;
    float f11 = f2;
    float f5 = f8;
    float f2 = f7;
    for (;;)
    {
      d3 = n;
      if (d3 >= d2) {
        break;
      }
      if (i1 != 0) {
        f7 = f2;
      } else {
        f7 = f1;
      }
      float f14;
      if ((f3 != 0.0F) && (d3 == d2 - 2.0D)) {
        f14 = f10 * f22 / 2.0F;
      } else {
        f14 = f5;
      }
      if ((f3 != 0.0F) && (d3 == d2 - 1.0D)) {
        f7 = f3;
      }
      d4 = f7;
      double d5 = Math.cos(d1);
      Double.isNaN(d4);
      float f16 = (float)(d4 * d5);
      d5 = Math.sin(d1);
      Double.isNaN(d4);
      float f13 = (float)(d4 * d5);
      if ((f4 == 0.0F) && (f6 == 0.0F))
      {
        this.a.lineTo(f16, f13);
      }
      else
      {
        d4 = f12;
        f7 = f1;
        f8 = f4;
        d4 = (float)(Math.atan2(d4, f11) - 1.570796326794897D);
        float f18 = (float)Math.cos(d4);
        float f19 = (float)Math.sin(d4);
        float f9 = f6;
        d4 = f13;
        float f17 = f13;
        d4 = (float)(Math.atan2(d4, f16) - 1.570796326794897D);
        float f20 = (float)Math.cos(d4);
        float f21 = (float)Math.sin(d4);
        if (i1 != 0) {
          f15 = f8;
        } else {
          f15 = f9;
        }
        if (i1 != 0) {
          f8 = f9;
        }
        if (i1 != 0) {
          f9 = f7;
        } else {
          f9 = f2;
        }
        if (i1 != 0) {
          f7 = f2;
        }
        f9 = f9 * f15 * 0.47829F;
        f18 *= f9;
        f19 = f9 * f19;
        f7 = f7 * f8 * 0.47829F;
        f20 *= f7;
        f21 = f7 * f21;
        f7 = f18;
        f8 = f20;
        f9 = f19;
        float f15 = f21;
        if (f22 != 0.0F) {
          if (n == 0)
          {
            f7 = f18 * f22;
            f9 = f19 * f22;
            f8 = f20;
            f15 = f21;
          }
          else
          {
            f7 = f18;
            f8 = f20;
            f9 = f19;
            f15 = f21;
            if (d3 == d2 - 1.0D)
            {
              f8 = f20 * f22;
              f15 = f21 * f22;
              f9 = f19;
              f7 = f18;
            }
          }
        }
        this.a.cubicTo(f11 - f7, f12 - f9, f16 + f8, f17 + f15, f16, f17);
      }
      d3 = f14;
      Double.isNaN(d3);
      d1 += d3;
      i1 ^= 0x1;
      n += 1;
      f11 = f16;
      f12 = f13;
    }
    localObject = (PointF)this.f.b();
    this.a.offset(((PointF)localObject).x, ((PointF)localObject).y);
    this.a.close();
  }
  
  private void f()
  {
    int n = (int)Math.floor(((Float)this.e.b()).floatValue());
    Object localObject = this.g;
    if (localObject == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)((l)localObject).b()).floatValue();
    }
    double d4 = Math.toRadians(d1 - 90.0D);
    double d3 = n;
    Double.isNaN(d3);
    float f3 = (float)(6.283185307179586D / d3);
    float f5 = ((Float)this.k.b()).floatValue() / 100.0F;
    float f6 = ((Float)this.i.b()).floatValue();
    double d2 = f6;
    double d1 = Math.cos(d4);
    Double.isNaN(d2);
    float f1 = (float)(d1 * d2);
    d1 = Math.sin(d4);
    Double.isNaN(d2);
    float f2 = (float)(d1 * d2);
    this.a.moveTo(f1, f2);
    d1 = f3;
    Double.isNaN(d1);
    d4 += d1;
    d3 = Math.ceil(d3);
    n = 0;
    while (n < d3)
    {
      double d5 = Math.cos(d4);
      Double.isNaN(d2);
      f3 = (float)(d5 * d2);
      d5 = Math.sin(d4);
      Double.isNaN(d2);
      float f4 = (float)(d2 * d5);
      if (f5 != 0.0F)
      {
        d5 = (float)(Math.atan2(f2, f1) - 1.570796326794897D);
        float f7 = (float)Math.cos(d5);
        float f8 = (float)Math.sin(d5);
        d5 = (float)(Math.atan2(f4, f3) - 1.570796326794897D);
        float f9 = (float)Math.cos(d5);
        float f10 = (float)Math.sin(d5);
        float f11 = f6 * f5 * 0.25F;
        this.a.cubicTo(f1 - f7 * f11, f2 - f8 * f11, f3 + f9 * f11, f4 + f11 * f10, f3, f4);
      }
      else
      {
        this.a.lineTo(f3, f4);
      }
      Double.isNaN(d1);
      d4 += d1;
      n += 1;
      f2 = f4;
      f1 = f3;
    }
    localObject = (PointF)this.f.b();
    this.a.offset(((PointF)localObject).x, ((PointF)localObject).y);
    this.a.close();
  }
  
  public Path a()
  {
    if (this.m) {
      return this.a;
    }
    this.a.reset();
    switch (1.a[this.d.ordinal()])
    {
    default: 
      break;
    case 2: 
      f();
      break;
    case 1: 
      e();
    }
    this.a.close();
    gq.a(this.a, this.l);
    this.m = true;
    return this.a;
  }
  
  public void a(List<br> paramList1, List<br> paramList2)
  {
    int n = 0;
    while (n < paramList1.size())
    {
      paramList2 = (br)paramList1.get(n);
      if ((paramList2 instanceof k))
      {
        paramList2 = (k)paramList2;
        if (paramList2.a() == cn.b.a)
        {
          this.l = paramList2;
          this.l.a(this);
        }
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
 * Qualified Name:     taiji.i
 * JD-Core Version:    0.7.0.1
 */