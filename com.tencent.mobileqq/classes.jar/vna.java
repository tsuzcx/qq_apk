import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class vna
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, vnd paramvnd)
  {
    float f = (paramFloat2 - paramFloat1) / 5.0F;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2, paramFloat2 - 3.0F * f, paramFloat2, paramFloat2 - f, paramFloat2 });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new vnb(paramvnd));
    localValueAnimator.addListener(new vnc(paramvnd, localValueAnimator));
    localValueAnimator.setDuration(paramLong);
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vna
 * JD-Core Version:    0.7.0.1
 */