import android.graphics.PointF;
import android.view.animation.Interpolator;

public class aimd
  implements Interpolator
{
  protected PointF a = new PointF();
  protected PointF b = new PointF();
  protected PointF c = new PointF();
  protected PointF end;
  protected PointF start;
  
  public aimd(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this((float)paramDouble1, (float)paramDouble2, (float)paramDouble3, (float)paramDouble4);
  }
  
  public aimd(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new PointF(paramFloat3, paramFloat4));
  }
  
  public aimd(PointF paramPointF1, PointF paramPointF2)
    throws IllegalArgumentException
  {
    if ((paramPointF1.x < 0.0F) || (paramPointF1.x > 1.0F)) {
      throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }
    if ((paramPointF2.x < 0.0F) || (paramPointF2.x > 1.0F)) {
      throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    }
    this.start = paramPointF1;
    this.end = paramPointF2;
  }
  
  private float E(float paramFloat)
  {
    return this.c.x + (2.0F * this.b.x + 3.0F * this.a.x * paramFloat) * paramFloat;
  }
  
  private float F(float paramFloat)
  {
    this.c.x = (this.start.x * 3.0F);
    this.b.x = ((this.end.x - this.start.x) * 3.0F - this.c.x);
    this.a.x = (1.0F - this.c.x - this.b.x);
    return (this.c.x + (this.b.x + this.a.x * paramFloat) * paramFloat) * paramFloat;
  }
  
  protected float C(float paramFloat)
  {
    this.c.y = (this.start.y * 3.0F);
    this.b.y = ((this.end.y - this.start.y) * 3.0F - this.c.y);
    this.a.y = (1.0F - this.c.y - this.b.y);
    return (this.c.y + (this.b.y + this.a.y * paramFloat) * paramFloat) * paramFloat;
  }
  
  protected float D(float paramFloat)
  {
    int i = 1;
    float f1 = paramFloat;
    for (;;)
    {
      float f2;
      if (i < 14)
      {
        f2 = F(f1) - paramFloat;
        if (Math.abs(f2) >= 0.001D) {}
      }
      else
      {
        return f1;
      }
      f1 -= f2 / E(f1);
      i += 1;
    }
  }
  
  public float getInterpolation(float paramFloat)
  {
    return C(D(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimd
 * JD-Core Version:    0.7.0.1
 */