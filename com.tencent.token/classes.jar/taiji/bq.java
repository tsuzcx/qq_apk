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
import com.tencent.token.go;
import java.util.ArrayList;
import java.util.List;
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
    if (paramac2 == null) {}
    for (this.l = null;; this.l = paramac2.a())
    {
      this.k = new ArrayList(paramList.size());
      this.h = new float[paramList.size()];
      m = 0;
      while (m < paramList.size())
      {
        this.k.add(((ac)paramList.get(m)).a());
        m += 1;
      }
    }
    paramar.a(this.j);
    paramar.a(this.i);
    int m = 0;
    while (m < this.k.size())
    {
      paramar.a((l)this.k.get(m));
      m += 1;
    }
    if (this.l != null) {
      paramar.a(this.l);
    }
    this.j.a(this);
    this.i.a(this);
    m = n;
    while (m < paramList.size())
    {
      ((l)this.k.get(m)).a(this);
      m += 1;
    }
    if (this.l != null) {
      this.l.a(this);
    }
  }
  
  private void a(Canvas paramCanvas, a parama, Matrix paramMatrix)
  {
    g.a("StrokeContent#applyTrimPath");
    if (a.b(parama) == null)
    {
      g.b("StrokeContent#applyTrimPath");
      return;
    }
    this.d.reset();
    int m = a.a(parama).size() - 1;
    while (m >= 0)
    {
      this.d.addPath(((h)a.a(parama).get(m)).a(), paramMatrix);
      m -= 1;
    }
    this.c.setPath(this.d, false);
    for (float f1 = this.c.getLength(); this.c.nextContour(); f1 = this.c.getLength() + f1) {}
    float f2 = ((Float)a.b(parama).f().b()).floatValue() * f1 / 360.0F;
    float f5 = ((Float)a.b(parama).d().b()).floatValue() * f1 / 100.0F + f2;
    float f6 = ((Float)a.b(parama).e().b()).floatValue() * f1 / 100.0F + f2;
    m = a.a(parama).size() - 1;
    f2 = 0.0F;
    if (m >= 0)
    {
      this.e.set(((h)a.a(parama).get(m)).a());
      this.e.transform(paramMatrix);
      this.c.setPath(this.e, false);
      float f7 = this.c.getLength();
      float f3;
      if ((f6 > f1) && (f6 - f1 < f2 + f7) && (f2 < f6 - f1)) {
        if (f5 > f1)
        {
          f3 = (f5 - f1) / f7;
          label331:
          f4 = Math.min((f6 - f1) / f7, 1.0F);
          go.a(this.e, f3, f4, 0.0F);
          paramCanvas.drawPath(this.e, this.b);
        }
      }
      for (;;)
      {
        m -= 1;
        f2 += f7;
        break;
        f3 = 0.0F;
        break label331;
        if ((f2 + f7 >= f5) && (f2 <= f6))
        {
          if ((f2 + f7 > f6) || (f5 >= f2)) {
            break label444;
          }
          paramCanvas.drawPath(this.e, this.b);
        }
      }
      label444:
      if (f5 < f2)
      {
        f3 = 0.0F;
        label455:
        if (f6 <= f2 + f7) {
          break label509;
        }
      }
      label509:
      for (float f4 = 1.0F;; f4 = (f6 - f2) / f7)
      {
        go.a(this.e, f3, f4, 0.0F);
        paramCanvas.drawPath(this.e, this.b);
        break;
        f3 = (f5 - f2) / f7;
        break label455;
      }
    }
    g.b("StrokeContent#applyTrimPath");
  }
  
  private void a(Matrix paramMatrix)
  {
    g.a("StrokeContent#applyDashPattern");
    if (this.k.isEmpty())
    {
      g.b("StrokeContent#applyDashPattern");
      return;
    }
    float f1 = go.a(paramMatrix);
    int m = 0;
    if (m < this.k.size())
    {
      this.h[m] = ((Float)((l)this.k.get(m)).b()).floatValue();
      if (m % 2 == 0) {
        if (this.h[m] < 1.0F) {
          this.h[m] = 1.0F;
        }
      }
      for (;;)
      {
        paramMatrix = this.h;
        paramMatrix[m] *= f1;
        m += 1;
        break;
        if (this.h[m] < 0.1F) {
          this.h[m] = 0.1F;
        }
      }
    }
    if (this.l == null) {}
    for (f1 = 0.0F;; f1 = ((Float)this.l.b()).floatValue())
    {
      this.b.setPathEffect(new DashPathEffect(this.h, f1));
      g.b("StrokeContent#applyDashPattern");
      return;
    }
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    g.a("StrokeContent#draw");
    float f1 = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.j.b()).intValue() * f1 / 100.0F * 255.0F);
    this.b.setAlpha(paramInt);
    this.b.setStrokeWidth(((Float)this.i.b()).floatValue() * go.a(paramMatrix));
    if (this.b.getStrokeWidth() <= 0.0F)
    {
      g.b("StrokeContent#draw");
      return;
    }
    a(paramMatrix);
    paramInt = 0;
    if (paramInt < this.g.size())
    {
      a locala = (a)this.g.get(paramInt);
      if (a.b(locala) != null) {
        a(paramCanvas, locala, paramMatrix);
      }
      for (;;)
      {
        paramInt += 1;
        break;
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
    }
    g.b("StrokeContent#draw");
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
    float f1 = ((Float)this.i.b()).floatValue();
    paramMatrix = this.f;
    float f2 = this.f.left;
    float f3 = f1 / 2.0F;
    float f4 = this.f.top;
    float f5 = f1 / 2.0F;
    float f6 = this.f.right;
    float f7 = f1 / 2.0F;
    float f8 = this.f.bottom;
    paramMatrix.set(f2 - f3, f4 - f5, f6 + f7, f1 / 2.0F + f8);
    paramRectF.set(this.f);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    g.b("StrokeContent#getBounds");
  }
  
  public void a(List<br> paramList1, List<br> paramList2)
  {
    int m = paramList1.size() - 1;
    k localk = null;
    br localbr;
    if (m >= 0)
    {
      localbr = (br)paramList1.get(m);
      if ((!(localbr instanceof k)) || (((k)localbr).a() != cn.b.b)) {
        break label232;
      }
      localk = (k)localbr;
    }
    label232:
    for (;;)
    {
      m -= 1;
      break;
      if (localk != null) {
        localk.a(this);
      }
      m = paramList2.size() - 1;
      paramList1 = null;
      if (m >= 0)
      {
        localbr = (br)paramList2.get(m);
        if (((localbr instanceof k)) && (((k)localbr).a() == cn.b.b))
        {
          if (paramList1 != null) {
            this.g.add(paramList1);
          }
          paramList1 = new a((k)localbr, null);
          ((k)localbr).a(this);
        }
      }
      for (;;)
      {
        m -= 1;
        break;
        if ((localbr instanceof h))
        {
          if (paramList1 == null) {
            paramList1 = new a(localk, null);
          }
          for (;;)
          {
            a.a(paramList1).add((h)localbr);
            break;
            if (paramList1 != null) {
              this.g.add(paramList1);
            }
            return;
          }
        }
      }
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