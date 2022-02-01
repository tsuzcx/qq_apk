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

public abstract class apb
  implements ans.a, aqe
{
  final Matrix a;
  final auv b;
  final ape c;
  apb d;
  apb e;
  final aof f;
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
  private anx r;
  private List<apb> s;
  private final List<ans<?, ?>> t;
  private boolean u;
  
  apb(final auv paramauv, ape paramape)
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
    this.b = paramauv;
    this.c = paramape;
    paramauv = new StringBuilder();
    paramauv.append(paramape.c);
    paramauv.append("#draw");
    this.q = paramauv.toString();
    this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    Paint localPaint;
    if (paramape.u == ape.c.c)
    {
      localPaint = this.k;
      paramauv = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
    else
    {
      localPaint = this.k;
      paramauv = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
    localPaint.setXfermode(paramauv);
    this.f = paramape.i.a();
    this.f.a(this);
    this.f.a(this);
    if ((paramape.h != null) && (!paramape.h.isEmpty()))
    {
      this.r = new anx(paramape.h);
      paramauv = this.r.a.iterator();
      while (paramauv.hasNext())
      {
        paramape = (ans)paramauv.next();
        a(paramape);
        paramape.a(this);
      }
      paramauv = this.r.b.iterator();
      while (paramauv.hasNext())
      {
        paramape = (anw)paramauv.next();
        a(paramape);
        paramape.a(this);
      }
    }
    if (!this.c.t.isEmpty())
    {
      paramauv = new anu(this.c.t);
      paramauv.b = true;
      paramauv.a(new ans.a()
      {
        public final void b()
        {
          apb localapb = apb.this;
          boolean bool;
          if (((Float)paramauv.a()).floatValue() == 1.0F) {
            bool = true;
          } else {
            bool = false;
          }
          localapb.a(bool);
        }
      });
      if (((Float)paramauv.a()).floatValue() != 1.0F) {
        bool = false;
      }
      a(bool);
      a(paramauv);
      return;
    }
    a(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    aux.a("Layer#clearLayer");
    paramCanvas.drawRect(this.m.left - 1.0F, this.m.top - 1.0F, this.m.right + 1.0F, this.m.bottom + 1.0F, this.l);
    aux.b("Layer#clearLayer");
  }
  
  @SuppressLint({"WrongConstant"})
  private void a(Canvas paramCanvas, Matrix paramMatrix)
  {
    aux.a("Layer#drawMask");
    aux.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.m, this.j, 19);
    aux.b("Layer#saveLayer");
    a(paramCanvas);
    int i2 = this.r.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject1 = (aox)this.r.c.get(i1);
      Object localObject2 = (Path)((ans)this.r.a.get(i1)).a();
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
      localObject1 = (anw)this.r.b.get(i1);
      int i3 = this.i.getAlpha();
      this.i.setAlpha((int)(((Integer)((anw)localObject1).a()).intValue() * 2.55F));
      paramCanvas.drawPath(this.g, this.i);
      this.i.setAlpha(i3);
      i1 += 1;
    }
    aux.a("Layer#restoreLayer");
    paramCanvas.restore();
    aux.b("Layer#restoreLayer");
    aux.b("Layer#drawMask");
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
      Object localObject = (aox)this.r.c.get(i1);
      Path localPath = (Path)((ans)this.r.a.get(i1)).a();
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
    anx localanx = this.r;
    return (localanx != null) && (!localanx.a.isEmpty());
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
    apb localapb = this.d;
    if (localapb != null) {
      localapb.a(f1);
    }
    int i1 = 0;
    while (i1 < this.t.size())
    {
      ((ans)this.t.get(i1)).a(f1);
      i1 += 1;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    aux.a(this.q);
    if (!this.u)
    {
      aux.b(this.q);
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
        for (localObject = this.e; localObject != null; localObject = ((apb)localObject).e) {
          this.s.add(localObject);
        }
      }
    }
    aux.a("Layer#parentMatrix");
    this.h.reset();
    this.h.set(paramMatrix);
    int i1 = this.s.size() - 1;
    while (i1 >= 0)
    {
      this.h.preConcat(((apb)this.s.get(i1)).f.a());
      i1 -= 1;
    }
    aux.b("Layer#parentMatrix");
    paramInt = (int)(paramInt / 255.0F * ((Integer)this.f.a.a()).intValue() / 100.0F * 255.0F);
    if ((!c()) && (!d()))
    {
      this.h.preConcat(this.f.a());
      aux.a("Layer#drawLayer");
      b(paramCanvas, this.h, paramInt);
      aux.b("Layer#drawLayer");
      b(aux.b(this.q));
      return;
    }
    aux.a("Layer#computeBounds");
    this.m.set(0.0F, 0.0F, 0.0F, 0.0F);
    a(this.m, this.h);
    Object localObject = this.m;
    Matrix localMatrix = this.h;
    if ((c()) && (this.c.u != ape.c.c))
    {
      this.d.a(this.o, localMatrix);
      ((RectF)localObject).set(Math.max(((RectF)localObject).left, this.o.left), Math.max(((RectF)localObject).top, this.o.top), Math.min(((RectF)localObject).right, this.o.right), Math.min(((RectF)localObject).bottom, this.o.bottom));
    }
    this.h.preConcat(this.f.a());
    b(this.m, this.h);
    this.m.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    aux.b("Layer#computeBounds");
    aux.a("Layer#saveLayer");
    paramCanvas.saveLayer(this.m, this.i, 31);
    aux.b("Layer#saveLayer");
    a(paramCanvas);
    aux.a("Layer#drawLayer");
    b(paramCanvas, this.h, paramInt);
    aux.b("Layer#drawLayer");
    if (d()) {
      a(paramCanvas, this.h);
    }
    if (c())
    {
      aux.a("Layer#drawMatte");
      aux.a("Layer#saveLayer");
      paramCanvas.saveLayer(this.m, this.k, 19);
      aux.b("Layer#saveLayer");
      a(paramCanvas);
      this.d.a(paramCanvas, paramMatrix, paramInt);
      aux.a("Layer#restoreLayer");
      paramCanvas.restore();
      aux.b("Layer#restoreLayer");
      aux.b("Layer#drawMatte");
    }
    aux.a("Layer#restoreLayer");
    paramCanvas.restore();
    aux.b("Layer#restoreLayer");
    b(aux.b(this.q));
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    this.a.preConcat(this.f.a());
  }
  
  public final void a(ans<?, ?> paramans)
  {
    if (!(paramans instanceof aod)) {
      this.t.add(paramans);
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter) {}
  
  public final void a(List<aqc> paramList) {}
  
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
 * Qualified Name:     com.tencent.token.apb
 * JD-Core Version:    0.7.0.1
 */