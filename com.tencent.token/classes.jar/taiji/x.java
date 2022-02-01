package taiji;

import android.graphics.Matrix;
import android.graphics.PointF;

public class x
{
  private final Matrix a = new Matrix();
  private final p<PointF> b;
  private final l<?, PointF> c;
  private final p<az> d;
  private final p<Float> e;
  private final p<Integer> f;
  private final l<?, Float> g;
  private final l<?, Float> h;
  
  public x(aj paramaj)
  {
    this.b = paramaj.a().a();
    this.c = paramaj.b().c();
    this.d = paramaj.c().a();
    this.e = paramaj.d().a();
    this.f = paramaj.e().a();
    if (paramaj.f() != null) {}
    for (this.g = paramaj.f().a(); paramaj.g() != null; this.g = null)
    {
      this.h = paramaj.g().a();
      return;
    }
    this.h = null;
  }
  
  public l<?, Integer> a()
  {
    return this.f;
  }
  
  public void a(ar paramar)
  {
    paramar.a(this.b);
    paramar.a(this.c);
    paramar.a(this.d);
    paramar.a(this.e);
    paramar.a(this.f);
    if (this.g != null) {
      paramar.a(this.g);
    }
    if (this.h != null) {
      paramar.a(this.h);
    }
  }
  
  public void a(l.a parama)
  {
    this.b.a(parama);
    this.c.a(parama);
    this.d.a(parama);
    this.e.a(parama);
    this.f.a(parama);
    if (this.g != null) {
      this.g.a(parama);
    }
    if (this.h != null) {
      this.h.a(parama);
    }
  }
  
  public Matrix b()
  {
    this.a.reset();
    Object localObject = (PointF)this.c.b();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.a.preTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    }
    float f1 = ((Float)this.e.b()).floatValue();
    if (f1 != 0.0F) {
      this.a.preRotate(f1);
    }
    localObject = (az)this.d.b();
    if ((((az)localObject).a() != 1.0F) || (((az)localObject).b() != 1.0F)) {
      this.a.preScale(((az)localObject).a(), ((az)localObject).b());
    }
    localObject = (PointF)this.b.b();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.a.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.x
 * JD-Core Version:    0.7.0.1
 */