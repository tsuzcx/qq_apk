import android.graphics.PointF;
import android.view.animation.Interpolator;

public class vgp
  implements Interpolator
{
  private int jdField_a_of_type_Int;
  private final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private final PointF b = new PointF();
  
  public vgp(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramFloat1;
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramFloat2;
    this.b.x = paramFloat3;
    this.b.y = paramFloat4;
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
    int i = this.jdField_a_of_type_Int;
    float f = paramFloat;
    double d2;
    if (i < 4096)
    {
      f = 1.0F * i / 4096.0F;
      if (a(f, 0.0D, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.b.x, 1.0D) >= paramFloat) {
        this.jdField_a_of_type_Int = i;
      }
    }
    else
    {
      d2 = a(f, 0.0D, this.jdField_a_of_type_AndroidGraphicsPointF.y, this.b.y, 1.0D);
      if (d2 <= 0.999D) {
        break label117;
      }
      this.jdField_a_of_type_Int = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgp
 * JD-Core Version:    0.7.0.1
 */