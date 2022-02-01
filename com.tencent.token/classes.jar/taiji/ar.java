package taiji;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import uilib.doraemon.a;
import uilib.doraemon.e;
import uilib.doraemon.g;
import uilib.doraemon.h;

public abstract class ar
  implements bt, l.a
{
  final Matrix a = new Matrix();
  final e b;
  final cs c;
  final x d;
  private final Path e = new Path();
  private final Matrix f = new Matrix();
  private final Paint g = new Paint(1);
  private final Paint h = new Paint(1);
  private final Paint i = new Paint(1);
  private final Paint j = new Paint();
  private final RectF k = new RectF();
  private final RectF l = new RectF();
  private final RectF m = new RectF();
  private final RectF n = new RectF();
  private final String o;
  private q p;
  private ar q;
  private ar r;
  private List<ar> s;
  private final List<l<?, ?>> t = new ArrayList();
  private boolean u = true;
  
  ar(e parame, cs paramcs)
  {
    this.b = parame;
    this.c = paramcs;
    this.o = (paramcs.f() + "#draw");
    this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (paramcs.l() == cs.c.c) {
      this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
    for (;;)
    {
      this.d = paramcs.o().h();
      this.d.a(this);
      this.d.a(this);
      if ((paramcs.j() == null) || (paramcs.j().isEmpty())) {
        break label416;
      }
      this.p = new q(paramcs.j());
      parame = this.p.b().iterator();
      while (parame.hasNext())
      {
        paramcs = (l)parame.next();
        a(paramcs);
        paramcs.a(this);
      }
      this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    parame = this.p.c().iterator();
    while (parame.hasNext())
    {
      paramcs = (p)parame.next();
      a(paramcs);
      paramcs.a(this);
    }
    label416:
    f();
  }
  
  static ar a(cs paramcs, e parame, a parama)
  {
    switch (2.a[paramcs.k().ordinal()])
    {
    default: 
      Log.w("Doraemon", "Unknown layer type " + paramcs.k());
      return null;
    case 1: 
      return new av(parame, paramcs);
    case 2: 
      return new as(parame, paramcs, parama.a(paramcs.g()), parama);
    case 3: 
      return new aw(parame, paramcs);
    case 4: 
      return new at(parame, paramcs, parama.j());
    case 5: 
      return new au(parame, paramcs);
    }
    return new ax(parame, paramcs);
  }
  
  private void a(Canvas paramCanvas)
  {
    g.a("Layer#clearLayer");
    paramCanvas.drawRect(this.k.left - 1.0F, this.k.top - 1.0F, this.k.right + 1.0F, 1.0F + this.k.bottom, this.j);
    g.b("Layer#clearLayer");
  }
  
  @SuppressLint({"WrongConstant"})
  private void a(Canvas paramCanvas, Matrix paramMatrix)
  {
    g.a("Layer#drawMask");
    g.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.k, this.h, 19);
    g.b("Layer#saveLayer");
    a(paramCanvas);
    int i2 = this.p.a().size();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = (cc)this.p.a().get(i1);
      Path localPath = (Path)((l)this.p.b().get(i1)).b();
      this.e.set(localPath);
      this.e.transform(paramMatrix);
      switch (2.b[localObject.a().ordinal()])
      {
      default: 
        this.e.setFillType(Path.FillType.WINDING);
      }
      for (;;)
      {
        localObject = (p)this.p.c().get(i1);
        int i3 = this.g.getAlpha();
        this.g.setAlpha((int)(((Integer)((p)localObject).b()).intValue() * 2.55F));
        paramCanvas.drawPath(this.e, this.g);
        this.g.setAlpha(i3);
        i1 += 1;
        break;
        this.e.setFillType(Path.FillType.INVERSE_WINDING);
      }
    }
    g.a("Layer#restoreLayer");
    paramCanvas.restore();
    g.b("Layer#restoreLayer");
    g.b("Layer#drawMask");
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean != this.u)
    {
      this.u = paramBoolean;
      g();
    }
  }
  
  private void b(float paramFloat)
  {
    this.b.m().a().a(this.c.f(), paramFloat);
  }
  
  private void b(RectF paramRectF, Matrix paramMatrix)
  {
    this.l.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!e()) {
      return;
    }
    int i2 = this.p.a().size();
    int i1 = 0;
    if (i1 < i2)
    {
      cc localcc = (cc)this.p.a().get(i1);
      Path localPath = (Path)((l)this.p.b().get(i1)).b();
      this.e.set(localPath);
      this.e.transform(paramMatrix);
      switch (2.b[localcc.a().ordinal()])
      {
      }
      this.e.computeBounds(this.n, false);
      if (i1 == 0) {
        this.l.set(this.n);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.l.set(Math.min(this.l.left, this.n.left), Math.min(this.l.top, this.n.top), Math.max(this.l.right, this.n.right), Math.max(this.l.bottom, this.n.bottom));
      }
    }
    paramRectF.set(Math.max(paramRectF.left, this.l.left), Math.max(paramRectF.top, this.l.top), Math.min(paramRectF.right, this.l.right), Math.min(paramRectF.bottom, this.l.bottom));
  }
  
  private void c(RectF paramRectF, Matrix paramMatrix)
  {
    if (!d()) {}
    while (this.c.l() == cs.c.c) {
      return;
    }
    this.q.a(this.m, paramMatrix);
    paramRectF.set(Math.max(paramRectF.left, this.m.left), Math.max(paramRectF.top, this.m.top), Math.min(paramRectF.right, this.m.right), Math.min(paramRectF.bottom, this.m.bottom));
  }
  
  private void f()
  {
    if (!this.c.d().isEmpty())
    {
      final n localn = new n(this.c.d());
      localn.a();
      localn.a(new l.a()
      {
        public void c()
        {
          ar localar = ar.this;
          if (((Float)localn.b()).floatValue() == 1.0F) {}
          for (boolean bool = true;; bool = false)
          {
            ar.a(localar, bool);
            return;
          }
        }
      });
      if (((Float)localn.b()).floatValue() == 1.0F) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        a(localn);
        return;
      }
    }
    a(true);
  }
  
  private void g()
  {
    this.b.invalidateSelf();
  }
  
  private void h()
  {
    if (this.s != null) {}
    for (;;)
    {
      return;
      if (this.r == null)
      {
        this.s = Collections.emptyList();
        return;
      }
      this.s = new ArrayList();
      for (ar localar = this.r; localar != null; localar = localar.r) {
        this.s.add(localar);
      }
    }
  }
  
  cs a()
  {
    return this.c;
  }
  
  void a(float paramFloat)
  {
    float f1 = paramFloat;
    if (this.c.b() != 0.0F) {
      f1 = paramFloat / this.c.b();
    }
    if (this.q != null) {
      this.q.a(f1);
    }
    int i1 = 0;
    while (i1 < this.t.size())
    {
      ((l)this.t.get(i1)).a(f1);
      i1 += 1;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    g.a(this.o);
    if (!this.u)
    {
      g.b(this.o);
      return;
    }
    h();
    g.a("Layer#parentMatrix");
    this.f.reset();
    this.f.set(paramMatrix);
    int i1 = this.s.size() - 1;
    while (i1 >= 0)
    {
      this.f.preConcat(((ar)this.s.get(i1)).d.b());
      i1 -= 1;
    }
    g.b("Layer#parentMatrix");
    float f1 = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.d.a().b()).intValue() * f1 / 100.0F * 255.0F);
    if ((!d()) && (!e()))
    {
      this.f.preConcat(this.d.b());
      g.a("Layer#drawLayer");
      b(paramCanvas, this.f, paramInt);
      g.b("Layer#drawLayer");
      b(g.b(this.o));
      return;
    }
    g.a("Layer#computeBounds");
    this.k.set(0.0F, 0.0F, 0.0F, 0.0F);
    a(this.k, this.f);
    c(this.k, this.f);
    this.f.preConcat(this.d.b());
    b(this.k, this.f);
    this.k.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    g.b("Layer#computeBounds");
    g.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.k, this.g, 31);
    g.b("Layer#saveLayer");
    a(paramCanvas);
    g.a("Layer#drawLayer");
    b(paramCanvas, this.f, paramInt);
    g.b("Layer#drawLayer");
    if (e()) {
      a(paramCanvas, this.f);
    }
    if (d())
    {
      g.a("Layer#drawMatte");
      g.a("Layer#saveLayer");
      paramCanvas.saveLayer(this.k, this.i, 19);
      g.b("Layer#saveLayer");
      a(paramCanvas);
      this.q.a(paramCanvas, paramMatrix, paramInt);
      g.a("Layer#restoreLayer");
      paramCanvas.restore();
      g.b("Layer#restoreLayer");
      g.b("Layer#drawMatte");
    }
    g.a("Layer#restoreLayer");
    paramCanvas.restore();
    g.b("Layer#restoreLayer");
    b(g.b(this.o));
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    this.a.preConcat(this.d.b());
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public void a(List<br> paramList1, List<br> paramList2) {}
  
  void a(ar paramar)
  {
    this.q = paramar;
  }
  
  public void a(l<?, ?> paraml)
  {
    if (!(paraml instanceof v)) {
      this.t.add(paraml);
    }
  }
  
  public String b()
  {
    return this.c.f();
  }
  
  abstract void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  void b(ar paramar)
  {
    this.r = paramar;
  }
  
  public void c()
  {
    g();
  }
  
  boolean d()
  {
    return this.q != null;
  }
  
  boolean e()
  {
    return (this.p != null) && (!this.p.b().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ar
 * JD-Core Version:    0.7.0.1
 */