import android.graphics.PointF;
import android.view.animation.Interpolator;

public class rlp
  implements Interpolator
{
  private final PointF S = new PointF();
  private final PointF T = new PointF();
  private int btg;
  
  public rlp(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.S.x = paramFloat1;
    this.S.y = paramFloat2;
    this.T.x = paramFloat3;
    this.T.y = paramFloat4;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    double d1 = 1.0D - paramDouble1;
    double d2 = paramDouble1 * paramDouble1;
    double d3 = d1 * d1;
    return d1 * 3.0D * d2 * paramDouble4 + (d3 * 3.0D * paramDouble1 * paramDouble3 + d3 * d1 * paramDouble2) + d2 * paramDouble1 * paramDouble5;
  }
  
  public float getInterpolation(float paramFloat)
  {
    double d1 = 1.0D;
    int i = this.btg;
    float f = paramFloat;
    double d2;
    if (i < 4096)
    {
      f = 1.0F * i / 4096.0F;
      if (a(f, 0.0D, this.S.x, this.T.x, 1.0D) >= paramFloat) {
        this.btg = i;
      }
    }
    else
    {
      d2 = a(f, 0.0D, this.S.y, this.T.y, 1.0D);
      if (d2 <= 0.999D) {
        break label117;
      }
      this.btg = 0;
    }
    for (;;)
    {
      return (float)d1;
      i += 1;
      break;
      label117:
      d1 = d2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlp
 * JD-Core Version:    0.7.0.1
 */