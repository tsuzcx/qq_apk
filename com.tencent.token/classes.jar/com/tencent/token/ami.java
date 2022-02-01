package com.tencent.token;

import android.graphics.Matrix;
import android.graphics.PointF;

public final class ami
{
  final alz<Integer> a;
  private final Matrix b = new Matrix();
  private final alz<PointF> c;
  private final alv<?, PointF> d;
  private final alz<ann> e;
  private final alz<Float> f;
  private final alv<?, Float> g;
  private final alv<?, Float> h;
  
  public ami(amu paramamu)
  {
    this.c = paramamu.a.a();
    this.d = paramamu.b.c();
    this.e = paramamu.c.a();
    this.f = paramamu.d.a();
    this.a = paramamu.e.a();
    if (paramamu.f != null) {
      this.g = paramamu.f.a();
    } else {
      this.g = null;
    }
    if (paramamu.g != null)
    {
      this.h = paramamu.g.a();
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
    localObject = (ann)this.e.a();
    if ((((ann)localObject).a != 1.0F) || (((ann)localObject).b != 1.0F)) {
      this.b.preScale(((ann)localObject).a, ((ann)localObject).b);
    }
    localObject = (PointF)this.c.a();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.b.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.b;
  }
  
  public final void a(alv.a parama)
  {
    this.c.a(parama);
    this.d.a(parama);
    this.e.a(parama);
    this.f.a(parama);
    this.a.a(parama);
    alv localalv = this.g;
    if (localalv != null) {
      localalv.a(parama);
    }
    localalv = this.h;
    if (localalv != null) {
      localalv.a(parama);
    }
  }
  
  public final void a(ane paramane)
  {
    paramane.a(this.c);
    paramane.a(this.d);
    paramane.a(this.e);
    paramane.a(this.f);
    paramane.a(this.a);
    alv localalv = this.g;
    if (localalv != null) {
      paramane.a(localalv);
    }
    localalv = this.h;
    if (localalv != null) {
      paramane.a(localalv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ami
 * JD-Core Version:    0.7.0.1
 */