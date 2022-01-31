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
import uilib.doraemon.m;

public abstract class bd
  implements cz, o
{
  final Matrix a = new Matrix();
  final e b;
  final cs c;
  final aa d;
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
  private t p;
  private bd q;
  private bd r;
  private List s;
  private final List t = new ArrayList();
  private boolean u = true;
  
  bd(e parame, cs paramcs)
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
      this.p = new t(paramcs.j());
      parame = this.p.b().iterator();
      while (parame.hasNext())
      {
        paramcs = (n)parame.next();
        a(paramcs);
        paramcs.a(this);
      }
      this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    parame = this.p.c().iterator();
    while (parame.hasNext())
    {
      paramcs = (s)parame.next();
      a(paramcs);
      paramcs.a(this);
    }
    label416:
    f();
  }
  
  static bd a(cs paramcs, e parame, a parama)
  {
    switch (bf.a[paramcs.k().ordinal()])
    {
    default: 
      Log.w("Doraemon", "Unknown layer type " + paramcs.k());
      return null;
    case 1: 
      return new bm(parame, paramcs);
    case 2: 
      return new bg(parame, paramcs, parama.a(paramcs.g()), parama);
    case 3: 
      return new bn(parame, paramcs);
    case 4: 
      return new bi(parame, paramcs, parama.j());
    case 5: 
      return new bl(parame, paramcs);
    }
    return new bo(parame, paramcs);
  }
  
  private void a(Canvas paramCanvas)
  {
    m.a("Layer#clearLayer");
    paramCanvas.drawRect(this.k.left - 1.0F, this.k.top - 1.0F, this.k.right + 1.0F, 1.0F + this.k.bottom, this.j);
    m.b("Layer#clearLayer");
  }
  
  @SuppressLint({"WrongConstant"})
  private void a(Canvas paramCanvas, Matrix paramMatrix)
  {
    m.a("Layer#drawMask");
    m.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.k, this.h, 19);
    m.b("Layer#saveLayer");
    a(paramCanvas);
    int i2 = this.p.a().size();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = (cc)this.p.a().get(i1);
      Path localPath = (Path)((n)this.p.b().get(i1)).b();
      this.e.set(localPath);
      this.e.transform(paramMatrix);
      switch (bf.b[localObject.a().ordinal()])
      {
      default: 
        this.e.setFillType(Path.FillType.WINDING);
      }
      for (;;)
      {
        localObject = (s)this.p.c().get(i1);
        int i3 = this.g.getAlpha();
        this.g.setAlpha((int)(((Integer)((s)localObject).b()).intValue() * 2.55F));
        paramCanvas.drawPath(this.e, this.g);
        this.g.setAlpha(i3);
        i1 += 1;
        break;
        this.e.setFillType(Path.FillType.INVERSE_WINDING);
      }
    }
    m.a("Layer#restoreLayer");
    paramCanvas.restore();
    m.b("Layer#restoreLayer");
    m.b("Layer#drawMask");
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
      Path localPath = (Path)((n)this.p.b().get(i1)).b();
      this.e.set(localPath);
      this.e.transform(paramMatrix);
      switch (bf.b[localcc.a().ordinal()])
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
      q localq = new q(this.c.d());
      localq.a();
      localq.a(new be(this, localq));
      if (((Float)localq.b()).floatValue() == 1.0F) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        a(localq);
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
      for (bd localbd = this.r; localbd != null; localbd = localbd.r) {
        this.s.add(localbd);
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
      ((n)this.t.get(i1)).a(f1);
      i1 += 1;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    m.a(this.o);
    if (!this.u)
    {
      m.b(this.o);
      return;
    }
    h();
    m.a("Layer#parentMatrix");
    this.f.reset();
    this.f.set(paramMatrix);
    int i1 = this.s.size() - 1;
    while (i1 >= 0)
    {
      this.f.preConcat(((bd)this.s.get(i1)).d.b());
      i1 -= 1;
    }
    m.b("Layer#parentMatrix");
    float f1 = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.d.a().b()).intValue() * f1 / 100.0F * 255.0F);
    if ((!d()) && (!e()))
    {
      this.f.preConcat(this.d.b());
      m.a("Layer#drawLayer");
      b(paramCanvas, this.f, paramInt);
      m.b("Layer#drawLayer");
      b(m.b(this.o));
      return;
    }
    m.a("Layer#computeBounds");
    this.k.set(0.0F, 0.0F, 0.0F, 0.0F);
    a(this.k, this.f);
    c(this.k, this.f);
    this.f.preConcat(this.d.b());
    b(this.k, this.f);
    this.k.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    m.b("Layer#computeBounds");
    m.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.k, this.g, 31);
    m.b("Layer#saveLayer");
    a(paramCanvas);
    m.a("Layer#drawLayer");
    b(paramCanvas, this.f, paramInt);
    m.b("Layer#drawLayer");
    if (e()) {
      a(paramCanvas, this.f);
    }
    if (d())
    {
      m.a("Layer#drawMatte");
      m.a("Layer#saveLayer");
      paramCanvas.saveLayer(this.k, this.i, 19);
      m.b("Layer#saveLayer");
      a(paramCanvas);
      this.q.a(paramCanvas, paramMatrix, paramInt);
      m.a("Layer#restoreLayer");
      paramCanvas.restore();
      m.b("Layer#restoreLayer");
      m.b("Layer#drawMatte");
    }
    m.a("Layer#restoreLayer");
    paramCanvas.restore();
    m.b("Layer#restoreLayer");
    b(m.b(this.o));
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    this.a.preConcat(this.d.b());
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public void a(List paramList1, List paramList2) {}
  
  void a(bd parambd)
  {
    this.q = parambd;
  }
  
  public void a(n paramn)
  {
    if (!(paramn instanceof y)) {
      this.t.add(paramn);
    }
  }
  
  public String b()
  {
    return this.c.f();
  }
  
  abstract void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  void b(bd parambd)
  {
    this.r = parambd;
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
 * Qualified Name:     taiji.bd
 * JD-Core Version:    0.7.0.1
 */