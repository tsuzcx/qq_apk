import android.view.animation.Interpolator;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class vtn
  implements Interpolator
{
  public vtn(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtn
 * JD-Core Version:    0.7.0.1
 */