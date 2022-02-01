package com.tencent.token;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class anf
  implements alw.a, aoi
{
  final Matrix a;
  final asw b;
  final ani c;
  anf d;
  anf e;
  final amj f;
  private final Path g = new Path();
  private final Matrix h = new Matrix();
  private final Paint i;
  private final Paint j;
  private final Paint k;
  private final Paint l;
  private final RectF m;
  private final RectF n;
  private final RectF o;
  private final RectF p;
  private final String q;
  private amb r;
  private List<anf> s;
  private final List<alw<?, ?>> t;
  private boolean u;
  
  anf(final asw paramasw, ani paramani)
  {
    boolean bool = true;
    this.i = new Paint(1);
    this.j = new Paint(1);
    this.k = new Paint(1);
    this.l = new Paint();
    this.m = new RectF();
    this.n = new RectF();
    this.o = new RectF();
    this.p = new RectF();
    this.a = new Matrix();
    this.t = new ArrayList();
    this.u = true;
    this.b = paramasw;
    this.c = paramani;
    paramasw = new StringBuilder();
    paramasw.append(paramani.c);
    paramasw.append("#draw");
    this.q = paramasw.toString();
    this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    Paint localPaint;
    if (paramani.u == ani.c.c)
    {
      localPaint = this.k;
      paramasw = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
    else
    {
      localPaint = this.k;
      paramasw = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
    localPaint.setXfermode(paramasw);
    this.f = paramani.i.a();
    this.f.a(this);
    this.f.a(this);
    if ((paramani.h != null) && (!paramani.h.isEmpty()))
    {
      this.r = new amb(paramani.h);
      paramasw = this.r.a.iterator();
      while (paramasw.hasNext())
      {
        paramani = (alw)paramasw.next();
        a(paramani);
        paramani.a(this);
      }
      paramasw = this.r.b.iterator();
      while (paramasw.hasNext())
      {
        paramani = (ama)paramasw.next();
        a(paramani);
        paramani.a(this);
      }
    }
    if (!this.c.t.isEmpty())
    {
      paramasw = new aly(this.c.t);
      paramasw.b = true;
      paramasw.a(new alw.a()
      {
        public final void b()
        {
          anf localanf = anf.this;
          boolean bool;
          if (((Float)paramasw.a()).floatValue() == 1.0F) {
            bool = true;
          } else {
            bool = false;
          }
          localanf.a(bool);
        }
      });
      if (((Float)paramasw.a()).floatValue() != 1.0F) {
        bool = false;
      }
      a(bool);
      a(paramasw);
      return;
    }
    a(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    asy.a("Layer#clearLayer");
    paramCanvas.drawRect(this.m.left - 1.0F, this.m.top - 1.0F, this.m.right + 1.0F, this.m.bottom + 1.0F, this.l);
    asy.b("Layer#clearLayer");
  }
  
  @SuppressLint({"WrongConstant"})
  private void a(Canvas paramCanvas, Matrix paramMatrix)
  {
    asy.a("Layer#drawMask");
    asy.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.m, this.j, 19);
    asy.b("Layer#saveLayer");
    a(paramCanvas);
    int i2 = this.r.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject1 = (anb)this.r.c.get(i1);
      Object localObject2 = (Path)((alw)this.r.a.get(i1)).a();
      this.g.set((Path)localObject2);
      this.g.transform(paramMatrix);
      if (2.b[(localObject1.a - 1)] != 1) {
        localObject1 = this.g;
      }
      for (localObject2 = Path.FillType.WINDING;; localObject2 = Path.FillType.INVERSE_WINDING)
      {
        ((Path)localObject1).setFillType((Path.FillType)localObject2);
        break;
        localObject1 = this.g;
      }
      localObject1 = (ama)this.r.b.get(i1);
      int i3 = this.i.getAlpha();
      this.i.setAlpha((int)(((Integer)((ama)localObject1).a()).intValue() * 2.55F));
      paramCanvas.drawPath(this.g, this.i);
      this.i.setAlpha(i3);
      i1 += 1;
    }
    asy.a("Layer#restoreLayer");
    paramCanvas.restore();
    asy.b("Layer#restoreLayer");
    asy.b("Layer#drawMask");
  }
  
  private void b(float paramFloat)
  {
    this.b.a.f.a(this.c.c, paramFloat);
  }
  
  private void b(RectF paramRectF, Matrix paramMatrix)
  {
    this.n.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!d()) {
      return;
    }
    int i2 = this.r.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (anb)this.r.c.get(i1);
      Path localPath = (Path)((alw)this.r.a.get(i1)).a();
      this.g.set(localPath);
      this.g.transform(paramMatrix);
      if (2.b[(localObject.a - 1)] != 1)
      {
        this.g.computeBounds(this.p, false);
        if (i1 == 0)
        {
          this.n.set(this.p);
        }
        else
        {
          localObject = this.n;
          ((RectF)localObject).set(Math.min(((RectF)localObject).left, this.p.left), Math.min(this.n.top, this.p.top), Math.max(this.n.right, this.p.right), Math.max(this.n.bottom, this.p.bottom));
        }
        i1 += 1;
      }
      else
      {
        return;
      }
    }
    paramRectF.set(Math.max(paramRectF.left, this.n.left), Math.max(paramRectF.top, this.n.top), Math.min(paramRectF.right, this.n.right), Math.min(paramRectF.bottom, this.n.bottom));
  }
  
  private boolean c()
  {
    return this.d != null;
  }
  
  private boolean d()
  {
    amb localamb = this.r;
    return (localamb != null) && (!localamb.a.isEmpty());
  }
  
  public final String a()
  {
    return this.c.c;
  }
  
  void a(float paramFloat)
  {
    float f1 = paramFloat;
    if (this.c.m != 0.0F) {
      f1 = paramFloat / this.c.m;
    }
    anf localanf = this.d;
    if (localanf != null) {
      localanf.a(f1);
    }
    int i1 = 0;
    while (i1 < this.t.size())
    {
      ((alw)this.t.get(i1)).a(f1);
      i1 += 1;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    asy.a(this.q);
    if (!this.u)
    {
      asy.b(this.q);
      return;
    }
    if (this.s == null) {
      if (this.e == null)
      {
        this.s = Collections.emptyList();
      }
      else
      {
        this.s = new ArrayList();
        for (localObject = this.e; localObject != null; localObject = ((anf)localObject).e) {
          this.s.add(localObject);
        }
      }
    }
    asy.a("Layer#parentMatrix");
    this.h.reset();
    this.h.set(paramMatrix);
    int i1 = this.s.size() - 1;
    while (i1 >= 0)
    {
      this.h.preConcat(((anf)this.s.get(i1)).f.a());
      i1 -= 1;
    }
    asy.b("Layer#parentMatrix");
    paramInt = (int)(paramInt / 255.0F * ((Integer)this.f.a.a()).intValue() / 100.0F * 255.0F);
    if ((!c()) && (!d()))
    {
      this.h.preConcat(this.f.a());
      asy.a("Layer#drawLayer");
      b(paramCanvas, this.h, paramInt);
      asy.b("Layer#drawLayer");
      b(asy.b(this.q));
      return;
    }
    asy.a("Layer#computeBounds");
    this.m.set(0.0F, 0.0F, 0.0F, 0.0F);
    a(this.m, this.h);
    Object localObject = this.m;
    Matrix localMatrix = this.h;
    if ((c()) && (this.c.u != ani.c.c))
    {
      this.d.a(this.o, localMatrix);
      ((RectF)localObject).set(Math.max(((RectF)localObject).left, this.o.left), Math.max(((RectF)localObject).top, this.o.top), Math.min(((RectF)localObject).right, this.o.right), Math.min(((RectF)localObject).bottom, this.o.bottom));
    }
    this.h.preConcat(this.f.a());
    b(this.m, this.h);
    this.m.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    asy.b("Layer#computeBounds");
    asy.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.m, this.i, 31);
    asy.b("Layer#saveLayer");
    a(paramCanvas);
    asy.a("Layer#drawLayer");
    b(paramCanvas, this.h, paramInt);
    asy.b("Layer#drawLayer");
    if (d()) {
      a(paramCanvas, this.h);
    }
    if (c())
    {
      asy.a("Layer#drawMatte");
      asy.a("Layer#saveLayer");
      paramCanvas.saveLayer(this.m, this.k, 19);
      asy.b("Layer#saveLayer");
      a(paramCanvas);
      this.d.a(paramCanvas, paramMatrix, paramInt);
      asy.a("Layer#restoreLayer");
      paramCanvas.restore();
      asy.b("Layer#restoreLayer");
      asy.b("Layer#drawMatte");
    }
    asy.a("Layer#restoreLayer");
    paramCanvas.restore();
    asy.b("Layer#restoreLayer");
    b(asy.b(this.q));
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    this.a.preConcat(this.f.a());
  }
  
  public final void a(alw<?, ?> paramalw)
  {
    if (!(paramalw instanceof amh)) {
      this.t.add(paramalw);
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public final void a(List<aog> paramList) {}
  
  final void a(boolean paramBoolean)
  {
    if (paramBoolean != this.u)
    {
      this.u = paramBoolean;
      this.b.invalidateSelf();
    }
  }
  
  public final void b()
  {
    this.b.invalidateSelf();
  }
  
  abstract void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anf
 * JD-Core Version:    0.7.0.1
 */