package taiji;

import android.graphics.Matrix;
import android.graphics.PointF;

public class aa
{
  private final Matrix a = new Matrix();
  private final s b;
  private final n c;
  private final s d;
  private final s e;
  private final s f;
  private final n g;
  private final n h;
  
  public aa(as paramas)
  {
    this.b = paramas.a().a();
    this.c = paramas.b().c();
    this.d = paramas.c().a();
    this.e = paramas.d().a();
    this.f = paramas.e().a();
    if (paramas.f() != null) {}
    for (this.g = paramas.f().a(); paramas.g() != null; this.g = null)
    {
      this.h = paramas.g().a();
      return;
    }
    this.h = null;
  }
  
  public n a()
  {
    return this.f;
  }
  
  public void a(bd parambd)
  {
    parambd.a(this.b);
    parambd.a(this.c);
    parambd.a(this.d);
    parambd.a(this.e);
    parambd.a(this.f);
    if (this.g != null) {
      parambd.a(this.g);
    }
    if (this.h != null) {
      parambd.a(this.h);
    }
  }
  
  public void a(o paramo)
  {
    this.b.a(paramo);
    this.c.a(paramo);
    this.d.a(paramo);
    this.e.a(paramo);
    this.f.a(paramo);
    if (this.g != null) {
      this.g.a(paramo);
    }
    if (this.h != null) {
      this.h.a(paramo);
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
    localObject = (bs)this.d.b();
    if ((((bs)localObject).a() != 1.0F) || (((bs)localObject).b() != 1.0F)) {
      this.a.preScale(((bs)localObject).a(), ((bs)localObject).b());
    }
    localObject = (PointF)this.b.b();
    if ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F)) {
      this.a.preTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.aa
 * JD-Core Version:    0.7.0.1
 */