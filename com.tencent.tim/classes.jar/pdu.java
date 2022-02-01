import android.view.animation.Interpolator;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class pdu
  implements Interpolator
{
  public pdu(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdu
 * JD-Core Version:    0.7.0.1
 */