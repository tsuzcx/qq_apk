import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class xfy
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, xgb paramxgb)
  {
    float f = (paramFloat2 - paramFloat1) / 5.0F;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2, paramFloat2 - 3.0F * f, paramFloat2, paramFloat2 - f, paramFloat2 });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new xfz(paramxgb));
    localValueAnimator.addListener(new xga(paramxgb, localValueAnimator));
    localValueAnimator.setDuration(paramLong);
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfy
 * JD-Core Version:    0.7.0.1
 */