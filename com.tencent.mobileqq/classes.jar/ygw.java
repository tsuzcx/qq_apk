import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.support.annotation.NonNull;

public abstract class ygw
{
  public ValueAnimator a;
  public PointF a;
  public boolean b = true;
  public boolean c;
  public boolean d;
  public int e;
  public boolean e;
  public boolean f;
  public float j = 1.0F;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p = 1.0F;
  
  public ygw(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.a = new PointF(paramPointF.x, paramPointF.y);
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.l = paramFloat3;
    this.m = paramFloat4;
    this.n = paramFloat5;
    this.o = paramFloat6;
    this.b = paramBoolean;
  }
  
  public ygw(ygw paramygw, float paramFloat)
  {
    this.a = new PointF(paramygw.a.x * paramFloat, paramygw.a.y * paramFloat);
    paramygw.j *= paramFloat;
    this.k = paramygw.k;
    paramygw.l *= paramFloat;
    paramygw.m *= paramFloat;
    this.n = paramygw.n;
    this.o = paramygw.o;
    this.b = paramygw.b;
  }
  
  public void a(Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ygw
 * JD-Core Version:    0.7.0.1
 */