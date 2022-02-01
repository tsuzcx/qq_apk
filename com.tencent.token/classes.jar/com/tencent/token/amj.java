package com.tencent.token;

import android.graphics.Matrix;
import android.graphics.PointF;

public final class amj
{
  final ama<Integer> a;
  private final Matrix b = new Matrix();
  private final ama<PointF> c;
  private final alw<?, PointF> d;
  private final ama<ano> e;
  private final ama<Float> f;
  private final alw<?, Float> g;
  private final alw<?, Float> h;
  
  public amj(amv paramamv)
  {
    this.c = paramamv.a.a();
    this.d = paramamv.b.c();
    this.e = paramamv.c.a();
    this.f = paramamv.d.a();
    this.a = paramamv.e.a();
    if (paramamv.f != null) {
      this.g = paramamv.f.a();
    } else {
      this.g = null;
    }
    if (paramamv.g != null)
    {
      this.h = paramamv.g.a();
      return;
    }
    this.h = null;
  }
  
  public final Matrix a()
  {
    this.b.reset();
    Object localObject = (PointF)this.d.a();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.b.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    }
    float f1 = ((Float)this.f.a()).floatValue();
    if (f1 != 0.0F) {
      this.b.preRotate(f1);
    }
    localObject = (ano)this.e.a();
    if ((((ano)localObject).a != 1.0F) || (((ano)localObject).b != 1.0F)) {
      this.b.preScale(((ano)localObject).a, ((ano)localObject).b);
    }
    localObject = (PointF)this.c.a();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.b.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.b;
  }
  
  public final void a(alw.a parama)
  {
    this.c.a(parama);
    this.d.a(parama);
    this.e.a(parama);
    this.f.a(parama);
    this.a.a(parama);
    alw localalw = this.g;
    if (localalw != null) {
      localalw.a(parama);
    }
    localalw = this.h;
    if (localalw != null) {
      localalw.a(parama);
    }
  }
  
  public final void a(anf paramanf)
  {
    paramanf.a(this.c);
    paramanf.a(this.d);
    paramanf.a(this.e);
    paramanf.a(this.f);
    paramanf.a(this.a);
    alw localalw = this.g;
    if (localalw != null) {
      paramanf.a(localalw);
    }
    localalw = this.h;
    if (localalw != null) {
      paramanf.a(localalw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amj
 * JD-Core Version:    0.7.0.1
 */