package taiji;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.tencent.token.gn;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Ltaiji.br;>;
import uilib.doraemon.e;
import uilib.doraemon.g;

abstract class bq
  implements bt, l.a
{
  protected final e a;
  final Paint b = new Paint(1);
  private final PathMeasure c = new PathMeasure();
  private final Path d = new Path();
  private final Path e = new Path();
  private final RectF f = new RectF();
  private final List<a> g = new ArrayList();
  private final float[] h;
  private final l<?, Float> i;
  private final l<?, Integer> j;
  private final List<l<?, Float>> k;
  private final l<?, Float> l;
  
  bq(e parame, ar paramar, Paint.Cap paramCap, Paint.Join paramJoin, ad paramad, ac paramac1, List<ac> paramList, ac paramac2)
  {
    this.a = parame;
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeCap(paramCap);
    this.b.setStrokeJoin(paramJoin);
    this.j = paramad.a();
    this.i = paramac1.a();
    if (paramac2 == null) {
      parame = null;
    } else {
      parame = paramac2.a();
    }
    this.l = parame;
    this.k = new ArrayList(paramList.size());
    this.h = new float[paramList.size()];
    int n = 0;
    int m = 0;
    while (m < paramList.size())
    {
      this.k.add(((ac)paramList.get(m)).a());
      m += 1;
    }
    paramar.a(this.j);
    paramar.a(this.i);
    m = 0;
    while (m < this.k.size())
    {
      paramar.a((l)this.k.get(m));
      m += 1;
    }
    parame = this.l;
    if (parame != null) {
      paramar.a(parame);
    }
    this.j.a(this);
    this.i.a(this);
    m = n;
    while (m < paramList.size())
    {
      ((l)this.k.get(m)).a(this);
      m += 1;
    }
    parame = this.l;
    if (parame != null) {
      parame.a(this);
    }
  }
  
  private void a(Canvas paramCanvas, a parama, Matrix paramMatrix)
  {
    g.a("StrokeContent#applyTrimPath");
    if (a.b(parama) == null) {}
    for (;;)
    {
      g.b("StrokeContent#applyTrimPath");
      return;
      this.d.reset();
      int m = a.a(parama).size() - 1;
      while (m >= 0)
      {
        this.d.addPath(((h)a.a(parama).get(m)).a(), paramMatrix);
        m -= 1;
      }
      this.c.setPath(this.d, false);
      for (float f3 = this.c.getLength(); this.c.nextContour(); f3 += this.c.getLength()) {}
      float f1 = ((Float)a.b(parama).f().b()).floatValue() * f3 / 360.0F;
      float f5 = ((Float)a.b(parama).d().b()).floatValue() * f3 / 100.0F + f1;
      float f6 = ((Float)a.b(parama).e().b()).floatValue() * f3 / 100.0F + f1;
      m = a.a(parama).size() - 1;
      float f4 = 0.0F;
      while (m >= 0)
      {
        this.e.set(((h)a.a(parama).get(m)).a());
        this.e.transform(paramMatrix);
        this.c.setPath(this.e, false);
        float f7 = this.c.getLength();
        float f2 = 1.0F;
        float f8;
        if (f6 > f3)
        {
          f8 = f6 - f3;
          if ((f8 < f4 + f7) && (f4 < f8))
          {
            if (f5 > f3) {
              f1 = (f5 - f3) / f7;
            } else {
              f1 = 0.0F;
            }
            f2 = Math.min(f8 / f7, 1.0F);
          }
        }
        for (;;)
        {
          gn.a(this.e, f1, f2, 0.0F);
          break label409;
          f8 = f4 + f7;
          if ((f8 < f5) || (f4 > f6)) {
            break;
          }
          if ((f8 <= f6) && (f5 < f4))
          {
            label409:
            paramCanvas.drawPath(this.e, this.b);
            break;
          }
          if (f5 < f4) {
            f1 = 0.0F;
          } else {
            f1 = (f5 - f4) / f7;
          }
          if (f6 <= f8) {
            f2 = (f6 - f4) / f7;
          }
        }
        f4 += f7;
        m -= 1;
      }
    }
  }
  
  private void a(Matrix paramMatrix)
  {
    g.a("StrokeContent#applyDashPattern");
    if (this.k.isEmpty()) {}
    for (;;)
    {
      g.b("StrokeContent#applyDashPattern");
      return;
      float f1 = gn.a(paramMatrix);
      int m = 0;
      while (m < this.k.size())
      {
        this.h[m] = ((Float)((l)this.k.get(m)).b()).floatValue();
        if (m % 2 == 0)
        {
          paramMatrix = this.h;
          if (paramMatrix[m] < 1.0F) {
            paramMatrix[m] = 1.0F;
          }
        }
        else
        {
          paramMatrix = this.h;
          if (paramMatrix[m] < 0.1F) {
            paramMatrix[m] = 0.1F;
          }
        }
        paramMatrix = this.h;
        paramMatrix[m] *= f1;
        m += 1;
      }
      paramMatrix = this.l;
      if (paramMatrix == null) {
        f1 = 0.0F;
      } else {
        f1 = ((Float)paramMatrix.b()).floatValue();
      }
      this.b.setPathEffect(new DashPathEffect(this.h, f1));
    }
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    g.a("StrokeContent#draw");
    paramInt = (int)(paramInt / 255.0F * ((Integer)this.j.b()).intValue() / 100.0F * 255.0F);
    this.b.setAlpha(paramInt);
    this.b.setStrokeWidth(((Float)this.i.b()).floatValue() * gn.a(paramMatrix));
    if (this.b.getStrokeWidth() <= 0.0F) {}
    for (;;)
    {
      g.b("StrokeContent#draw");
      return;
      a(paramMatrix);
      paramInt = 0;
      while (paramInt < this.g.size())
      {
        a locala = (a)this.g.get(paramInt);
        if (a.b(locala) != null)
        {
          a(paramCanvas, locala, paramMatrix);
        }
        else
        {
          g.a("StrokeContent#buildPath");
          this.d.reset();
          int m = a.a(locala).size() - 1;
          while (m >= 0)
          {
            this.d.addPath(((h)a.a(locala).get(m)).a(), paramMatrix);
            m -= 1;
          }
          g.b("StrokeContent#buildPath");
          g.a("StrokeContent#drawPath");
          paramCanvas.drawPath(this.d, this.b);
          g.b("StrokeContent#drawPath");
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    g.a("StrokeContent#getBounds");
    this.d.reset();
    int m = 0;
    while (m < this.g.size())
    {
      a locala = (a)this.g.get(m);
      int n = 0;
      while (n < a.a(locala).size())
      {
        this.d.addPath(((h)a.a(locala).get(n)).a(), paramMatrix);
        n += 1;
      }
      m += 1;
    }
    this.d.computeBounds(this.f, false);
    float f2 = ((Float)this.i.b()).floatValue();
    paramMatrix = this.f;
    float f1 = paramMatrix.left;
    f2 /= 2.0F;
    paramMatrix.set(f1 - f2, this.f.top - f2, this.f.right + f2, this.f.bottom + f2);
    paramRectF.set(this.f);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    g.b("StrokeContent#getBounds");
  }
  
  public void a(List<br> paramList1, List<br> paramList2)
  {
    int m = paramList1.size() - 1;
    Object localObject3;
    Object localObject1;
    for (Object localObject2 = null; m >= 0; localObject2 = localObject1)
    {
      localObject3 = (br)paramList1.get(m);
      localObject1 = localObject2;
      if ((localObject3 instanceof k))
      {
        localObject3 = (k)localObject3;
        localObject1 = localObject2;
        if (((k)localObject3).a() == cn.b.b) {
          localObject1 = localObject3;
        }
      }
      m -= 1;
    }
    if (localObject2 != null) {
      localObject2.a(this);
    }
    m = paramList2.size() - 1;
    for (paramList1 = null; m >= 0; paramList1 = (List<br>)localObject1)
    {
      localObject3 = (br)paramList2.get(m);
      if ((localObject3 instanceof k))
      {
        k localk = (k)localObject3;
        if (localk.a() == cn.b.b)
        {
          if (paramList1 != null) {
            this.g.add(paramList1);
          }
          localObject1 = new a(localk, null);
          localk.a(this);
          break label223;
        }
      }
      localObject1 = paramList1;
      if ((localObject3 instanceof h))
      {
        localObject1 = paramList1;
        if (paramList1 == null) {
          localObject1 = new a(localObject2, null);
        }
        a.a((a)localObject1).add((h)localObject3);
      }
      label223:
      m -= 1;
    }
    if (paramList1 != null) {
      this.g.add(paramList1);
    }
  }
  
  public void c()
  {
    this.a.invalidateSelf();
  }
  
  private static final class a
  {
    private final List<h> a = new ArrayList();
    private final k b;
    
    private a(k paramk)
    {
      this.b = paramk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bq
 * JD-Core Version:    0.7.0.1
 */