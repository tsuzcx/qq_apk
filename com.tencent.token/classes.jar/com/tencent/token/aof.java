package com.tencent.token;

import android.graphics.Matrix;
import android.graphics.PointF;

public final class aof
{
  final anw<Integer> a;
  private final Matrix b = new Matrix();
  private final anw<PointF> c;
  private final ans<?, PointF> d;
  private final anw<apk> e;
  private final anw<Float> f;
  private final ans<?, Float> g;
  private final ans<?, Float> h;
  
  public aof(aor paramaor)
  {
    this.c = paramaor.a.a();
    this.d = paramaor.b.c();
    this.e = paramaor.c.a();
    this.f = paramaor.d.a();
    this.a = paramaor.e.a();
    if (paramaor.f != null) {
      this.g = paramaor.f.a();
    } else {
      this.g = null;
    }
    if (paramaor.g != null)
    {
      this.h = paramaor.g.a();
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
    localObject = (apk)this.e.a();
    if ((((apk)localObject).a != 1.0F) || (((apk)localObject).b != 1.0F)) {
      this.b.preScale(((apk)localObject).a, ((apk)localObject).b);
    }
    localObject = (PointF)this.c.a();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.b.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.b;
  }
  
  public final void a(ans.a parama)
  {
    this.c.a(parama);
    this.d.a(parama);
    this.e.a(parama);
    this.f.a(parama);
    this.a.a(parama);
    ans localans = this.g;
    if (localans != null) {
      localans.a(parama);
    }
    localans = this.h;
    if (localans != null) {
      localans.a(parama);
    }
  }
  
  public final void a(apb paramapb)
  {
    paramapb.a(this.c);
    paramapb.a(this.d);
    paramapb.a(this.e);
    paramapb.a(this.f);
    paramapb.a(this.a);
    ans localans = this.g;
    if (localans != null) {
      paramapb.a(localans);
    }
    localans = this.h;
    if (localans != null) {
      paramapb.a(localans);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aof
 * JD-Core Version:    0.7.0.1
 */