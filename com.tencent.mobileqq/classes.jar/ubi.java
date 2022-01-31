import android.view.animation.Interpolator;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class ubi
  implements Interpolator
{
  private double jdField_a_of_type_Double;
  
  public ubi(QCircleSlidBottomView paramQCircleSlidBottomView, double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(2.0D, -24.0D * paramFloat) * Math.sin((paramFloat - this.jdField_a_of_type_Double / 10.0D) * 6.283185307179586D / this.jdField_a_of_type_Double) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubi
 * JD-Core Version:    0.7.0.1
 */