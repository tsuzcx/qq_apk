import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.support.annotation.NonNull;

public abstract class vcw
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
  
  public vcw(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
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
  
  public vcw(vcw paramvcw, float paramFloat)
  {
    this.a = new PointF(paramvcw.a.x * paramFloat, paramvcw.a.y * paramFloat);
    paramvcw.j *= paramFloat;
    this.k = paramvcw.k;
    paramvcw.l *= paramFloat;
    paramvcw.m *= paramFloat;
    this.n = paramvcw.n;
    this.o = paramvcw.o;
    this.b = paramvcw.b;
  }
  
  public void a(Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     vcw
 * JD-Core Version:    0.7.0.1
 */