package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.tencentmap.mapsdk.map.v.b;>;
import java.util.List;

final class g
  extends w
{
  private List<v.c> C = null;
  private List<v.c> D = null;
  private List<v.a> E = null;
  private List<v.a> F = null;
  private a G = new a()
  {
    public final void a()
    {
      if (g.this.f == null) {
        return;
      }
      g.this.f.a.b(false);
    }
  };
  byte[] a = new byte[0];
  boolean b = false;
  PaintFlagsDrawFilter c = null;
  int d = 0;
  boolean e = false;
  
  private void a(List<v.b> paramList, List<v.a> paramList1, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList1 == null)) {
      break label8;
    }
    for (;;)
    {
      label8:
      return;
      if ((this.l) && (paramInt <= this.i) && (paramInt >= this.j))
      {
        int i = paramList.size();
        if (i <= 0) {
          break;
        }
        paramInt = 0;
        while (paramInt < i)
        {
          v.b localb = (v.b)paramList.get(paramInt);
          if (localb != null)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localb.a);
            ((StringBuilder)localObject).append("-");
            ((StringBuilder)localObject).append(localb.b);
            ((StringBuilder)localObject).append("-");
            ((StringBuilder)localObject).append(localb.c);
            localObject = this.u.a(((StringBuilder)localObject).toString());
            v.c localc = new v.c(localb.a, localb.b, localb.c);
            if (localObject != null) {
              localc.g = ((e.a)localObject).a;
            }
            localc.e = localb.e;
            localc.f = localb.f;
            this.D.add(localc);
            if ((!paramBoolean) && (localc.g == null)) {
              paramList1.add(0, new v.a(localb.a, localb.b, localb.c));
            }
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private boolean b(v.a parama)
  {
    synchronized (this.a)
    {
      if (this.E == null) {
        return false;
      }
      boolean bool = this.E.remove(parama);
      return bool;
    }
  }
  
  private void c(List<v.a> paramList)
  {
    if (paramList == null) {
      return;
    }
    synchronized (this.a)
    {
      if (this.F == null) {
        return;
      }
    }
    this.F.clear();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        v.a locala = (v.a)paramList.get(i);
        if ((locala != null) && (!a(this.E, locala))) {
          this.F.add(locala);
        }
      }
      else
      {
        i();
        return;
      }
      i += 1;
    }
  }
  
  private v.a h()
  {
    synchronized (this.a)
    {
      if (this.F == null) {
        return null;
      }
      if (this.F.size() <= 0) {
        return null;
      }
    }
    v.a locala = (v.a)this.F.remove(0);
    if ((this.E != null) && (this.E.contains(locala) != true)) {
      this.E.add(locala);
    }
    int i = this.F.size();
    if (i > 0) {
      i();
    }
    return locala;
  }
  
  private void i()
  {
    if (this.f != null) {
      this.f.e();
    }
  }
  
  protected final void a()
  {
    super.a();
    synchronized (this.a)
    {
      this.E.clear();
      this.F.clear();
      return;
    }
  }
  
  protected final void a(Canvas paramCanvas)
  {
    if (this.c == null) {
      this.c = new PaintFlagsDrawFilter(0, 2);
    }
    paramCanvas.setDrawFilter(this.c);
    super.a(paramCanvas);
    paramCanvas.setDrawFilter(null);
  }
  
  protected final void a(ArrayList<v.b> arg1, boolean paramBoolean)
  {
    if (??? == null) {
      return;
    }
    Object localObject3 = ???;
    if (???.size() == 0) {
      localObject3 = this.f.c.a(this.f.a.g(), this.f.a.e(), this.f.a.f(), this.f.a.b());
    }
    b(this.w);
    b(this.D);
    int m;
    float f5;
    Object localObject4;
    int i2;
    int k;
    int j;
    float f2;
    float f1;
    int i1;
    int n;
    v.c localc;
    int i;
    float f4;
    float f3;
    int i5;
    int i4;
    label283:
    Object localObject2;
    for (;;)
    {
      synchronized (this.A)
      {
        this.z.clear();
        this.d = 0;
        if (this.C == null) {
          break label941;
        }
        m = this.C.size();
        if (m <= 0) {
          break label941;
        }
        f5 = this.f.a.b();
        localObject4 = this.f.c.c();
        i2 = -1;
        ??? = null;
        k = -1;
        j = -1;
        f2 = 0.0F;
        f1 = 0.0F;
        i1 = 0;
        n = 0;
        if (n >= m) {
          break label941;
        }
        localc = (v.c)this.C.get(n);
        i = i1;
        f4 = f1;
        f3 = f2;
        i5 = j;
        i4 = k;
        ArrayList<v.b> localArrayList = ???;
        i3 = i2;
        if (localc == null) {
          break label900;
        }
        if (localc.c == this.f.c.e)
        {
          localc.g = null;
          this.C.remove(n);
          i3 = n - 1;
          i = m - 1;
          n = i1;
          m = i3;
          m += 1;
          i1 = n;
          n = m;
          m = i;
        }
      }
      if (localObject2 == null)
      {
        localc.g = null;
        this.C.remove(n);
        n -= 1;
        i = m - 1;
        m = n;
        n = i1;
      }
      else
      {
        localc.g = ((e.a)localObject2).a;
        i = i1;
        i1 = i2;
        if (i2 != localc.c)
        {
          ??? = this.f.c.a(this.f.c.d(), localc.c);
          k = (int)Math.floor(???.x / 256.0F);
          j = (int)Math.floor(???.y / 256.0F);
          f2 = ((Point)localObject4).x - ???.x % 256.0F;
          f1 = ((Point)localObject4).y - (256.0F - ???.y % 256.0F);
          i1 = localc.c;
          i = (int)Math.pow(2.0D, localc.c + 1);
        }
        localObject2 = this.f.c;
        if ((localc != null) && (??? != null)) {
          if (k != 0) {
            break label1486;
          }
        }
      }
    }
    label900:
    label941:
    label1459:
    label1465:
    label1471:
    label1486:
    for (int i3 = i;; i3 = k)
    {
      if (j == 0) {}
      for (i2 = i;; i2 = j)
      {
        i3 = localc.a - i3;
        if (i3 < 0)
        {
          i4 = i3 + i;
          if (i4 < Math.abs(i3)) {
            i3 = i4;
          }
        }
        for (;;)
        {
          i2 = localc.b - i2;
          if (i2 < 0)
          {
            i4 = i2 + i;
            if (i4 < Math.abs(i2)) {
              i2 = i4;
            }
          }
          for (;;)
          {
            localc.e = (i3 * 256 + f2);
            localc.f = (f1 - i2 * 256);
            i2 = localc.c;
            f3 = (float)Math.pow(2.0D, this.f.c.e - i2);
            f4 = localc.e;
            float f6 = localc.f;
            f4 = (f4 - ((Point)localObject4).x) * (f5 * f3) + ((Point)localObject4).x;
            f6 = (f6 - ((Point)localObject4).y) * (f5 * f3) + ((Point)localObject4).y;
            float f7 = 256.0F * f5 * f3;
            if ((f4 > this.f.a.e()) || (f4 < -f7)) {
              bool = false;
            }
            for (;;)
            {
              localc.h = f3;
              localc.i = bool;
              if (localc.i) {
                break label868;
              }
              localc.g = null;
              i3 = m;
              m = n;
              n = i;
              i2 = i1;
              i = i3;
              break;
              if ((f6 > this.f.a.f()) || (f6 < -f7)) {
                bool = false;
              } else {
                bool = true;
              }
            }
            label868:
            this.d += 1;
            i3 = i1;
            localObject2 = ???;
            i4 = k;
            i5 = j;
            f3 = f2;
            f4 = f1;
            i1 = m;
            m = n;
            n = i;
            f1 = f4;
            f2 = f3;
            j = i5;
            k = i4;
            ??? = (ArrayList<v.b>)localObject2;
            i2 = i3;
            i = i1;
            break label283;
            boolean bool = this.f.a.c;
            i = this.f.a.g();
            this.b = false;
            this.e = true;
            if (localObject3 == null)
            {
              ??? = null;
              if (bool == true)
              {
                j = this.f.a.g() - 2;
                i = j;
                if (j < this.f.a.d()) {
                  i = this.f.a.d();
                }
                if (i != this.f.a.g())
                {
                  localObject2 = this.f.c;
                  j = this.f.a.e();
                  k = this.f.a.f();
                  this.f.a.b();
                  a(((p)localObject2).a(i, j, k), ???, i, paramBoolean);
                }
              }
              if ((??? != null) && (???.size() > 0))
              {
                if (this.m != true) {
                  break label1465;
                }
                a(null);
                c(???);
              }
            }
            for (;;)
            {
              if (??? == null) {
                break label1471;
              }
              ???.clear();
              return;
              if (!this.l)
              {
                ??? = null;
                break;
              }
              if ((i > this.i) || (i < this.j))
              {
                ??? = null;
                break;
              }
              k = ((ArrayList)localObject3).size();
              if (k <= 0)
              {
                ??? = null;
                break;
              }
              localObject2 = new ArrayList();
              i = 0;
              ??? = (ArrayList<v.b>)localObject2;
              if (i >= k) {
                break;
              }
              ??? = (v.b)((ArrayList)localObject3).get(i);
              if (??? != null)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(???.a);
                ((StringBuilder)localObject4).append("-");
                ((StringBuilder)localObject4).append(???.b);
                ((StringBuilder)localObject4).append("-");
                ((StringBuilder)localObject4).append(???.c);
                localObject4 = this.u.a(((StringBuilder)localObject4).toString());
                localc = new v.c(???.a, ???.b, ???.c);
                localc.e = ???.e;
                localc.f = ???.f;
                if (localObject4 == null) {
                  break label1443;
                }
                localc.g = ((e.a)localObject4).a;
                label1365:
                this.w.add(localc);
                if (localc.g != null) {
                  break label1459;
                }
              }
              for (j = 1;; j = 0)
              {
                if (j == 1) {
                  this.b = true;
                }
                if ((!paramBoolean) && (j == 1)) {
                  ((ArrayList)localObject2).add(new v.a(???.a, ???.b, ???.c));
                }
                i += 1;
                break;
                if (this.e != true) {
                  break label1365;
                }
                this.e = false;
                break label1365;
              }
              a(???);
            }
            break;
          }
        }
      }
    }
  }
  
  protected final void b()
  {
    super.b();
    this.v.a(null);
    synchronized (this.a)
    {
      this.E.clear();
      this.E = null;
      this.F.clear();
      this.F = null;
      return;
    }
  }
  
  protected final void b(Canvas paramCanvas)
  {
    if (this.e == true) {}
    int j;
    Object localObject3;
    do
    {
      do
      {
        return;
        if (this.C != null)
        {
          j = this.C.size();
          if (j > 0)
          {
            localObject1 = this.f.c.c();
            i = 0;
            while (i < j)
            {
              localObject2 = (v.c)this.C.get(i);
              if ((localObject2 != null) && (((v.c)localObject2).i))
              {
                localObject3 = ((v.c)localObject2).g;
                if (localObject3 != null)
                {
                  f = ((v.c)localObject2).h;
                  Matrix localMatrix = new Matrix();
                  localMatrix.setScale(f, f, ((Point)localObject1).x, ((Point)localObject1).y);
                  paramCanvas.save();
                  paramCanvas.concat(localMatrix);
                  paramCanvas.drawBitmap((Bitmap)localObject3, ((v.c)localObject2).e, ((v.c)localObject2).f, null);
                  paramCanvas.restore();
                }
              }
              i += 1;
            }
          }
        }
      } while (!this.b);
      j = this.D.size();
    } while (j <= 0);
    Object localObject1 = new Matrix();
    int i = ((v.c)this.D.get(0)).c;
    float f = (float)Math.pow(2.0D, this.f.c.e - i);
    Object localObject2 = this.f.c.c();
    ((Matrix)localObject1).setScale(f, f, ((Point)localObject2).x, ((Point)localObject2).y);
    paramCanvas.save();
    paramCanvas.concat((Matrix)localObject1);
    i = 0;
    while (i < j)
    {
      localObject3 = (v.c)this.D.get(i);
      if (localObject3 != null)
      {
        localObject2 = ((v.c)localObject3).g;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          a((v.c)localObject3);
          localObject1 = ((v.c)localObject3).g;
        }
        if (localObject1 != null) {
          paramCanvas.drawBitmap((Bitmap)localObject1, ((v.c)localObject3).e, ((v.c)localObject3).f, null);
        }
      }
      i += 1;
    }
    paramCanvas.restore();
  }
  
  protected final void c()
  {
    if (this.g == true) {}
    v.a locala;
    do
    {
      return;
      locala = h();
    } while (locala == null);
    boolean bool;
    if (locala == null) {
      bool = false;
    }
    while (bool == true)
    {
      a(locala);
      return;
      bool = this.v.a(locala, this.G);
      b(locala);
    }
    a(locala, null);
  }
  
  protected final void d()
  {
    this.w = new ArrayList();
    this.D = new ArrayList();
    this.C = new ArrayList();
    this.E = new ArrayList();
    this.x = new ArrayList();
    this.F = new ArrayList();
    this.y = new ArrayList();
    this.z = new ArrayList();
    this.a = new byte[0];
  }
  
  protected final int e()
  {
    return 16;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    return this.h.equals(paramObject.h);
  }
  
  protected final void f()
  {
    if (this.C == null) {
      return;
    }
    int j = this.D.size();
    int i;
    v.c localc;
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        localc = (v.c)this.D.get(i);
        if ((localc != null) && (localc.g != null) && (!this.C.contains(localc))) {
          this.C.add(localc);
        }
        i += 1;
      }
    }
    j = this.w.size();
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        localc = (v.c)this.w.get(i);
        if ((localc != null) && (localc.g != null) && (!this.C.contains(localc))) {
          this.C.add(localc);
        }
        i += 1;
      }
    }
    b(this.w);
    b(this.D);
  }
  
  public final int hashCode()
  {
    return this.p;
  }
  
  public final String toString()
  {
    return this.h;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.g
 * JD-Core Version:    0.7.0.1
 */