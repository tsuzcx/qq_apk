package com.tencent.token;

import android.graphics.Matrix;
import android.graphics.PointF;

public final class apd
{
  final aou<Integer> a;
  private final Matrix b = new Matrix();
  private final aou<PointF> c;
  private final aoq<?, PointF> d;
  private final aou<aqi> e;
  private final aou<Float> f;
  private final aoq<?, Float> g;
  private final aoq<?, Float> h;
  
  public apd(app paramapp)
  {
    this.c = paramapp.a.a();
    this.d = paramapp.b.c();
    this.e = paramapp.c.a();
    this.f = paramapp.d.a();
    this.a = paramapp.e.a();
    if (paramapp.f != null) {
      this.g = paramapp.f.a();
    } else {
      this.g = null;
    }
    if (paramapp.g != null)
    {
      this.h = paramapp.g.a();
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
    localObject = (aqi)this.e.a();
    if ((((aqi)localObject).a != 1.0F) || (((aqi)localObject).b != 1.0F)) {
      this.b.preScale(((aqi)localObject).a, ((aqi)localObject).b);
    }
    localObject = (PointF)this.c.a();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.b.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.b;
  }
  
  public final void a(aoq.a parama)
  {
    this.c.a(parama);
    this.d.a(parama);
    this.e.a(parama);
    this.f.a(parama);
    this.a.a(parama);
    aoq localaoq = this.g;
    if (localaoq != null) {
      localaoq.a(parama);
    }
    localaoq = this.h;
    if (localaoq != null) {
      localaoq.a(parama);
    }
  }
  
  public final void a(apz paramapz)
  {
    paramapz.a(this.c);
    paramapz.a(this.d);
    paramapz.a(this.e);
    paramapz.a(this.f);
    paramapz.a(this.a);
    aoq localaoq = this.g;
    if (localaoq != null) {
      paramapz.a(localaoq);
    }
    localaoq = this.h;
    if (localaoq != null) {
      paramapz.a(localaoq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apd
 * JD-Core Version:    0.7.0.1
 */