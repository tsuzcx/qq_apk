import android.animation.TypeEvaluator;
import android.graphics.PointF;
import com.tencent.mobileqq.profile.view.ProfileTagView;

public class alhc
  implements TypeEvaluator<PointF>
{
  public alhc(ProfileTagView paramProfileTagView) {}
  
  public PointF evaluate(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    return new PointF(f1 + (paramPointF2.x - f1) * paramFloat, f2 + (paramPointF2.y - f2) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhc
 * JD-Core Version:    0.7.0.1
 */