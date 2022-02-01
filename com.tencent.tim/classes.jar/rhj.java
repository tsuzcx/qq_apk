import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class rhj
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, rhj.a parama)
  {
    float f = (paramFloat2 - paramFloat1) / 5.0F;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2, paramFloat2 - 3.0F * f, paramFloat2, paramFloat2 - f, paramFloat2 });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new rhk(parama));
    localValueAnimator.addListener(new rhl(parama, localValueAnimator));
    localValueAnimator.setDuration(paramLong);
    return localValueAnimator;
  }
  
  public static abstract interface a
  {
    public abstract void a(ValueAnimator paramValueAnimator);
    
    public abstract void b(ValueAnimator paramValueAnimator);
    
    public abstract void c(ValueAnimator paramValueAnimator);
    
    public abstract void onAnimationUpdate(ValueAnimator paramValueAnimator);
  }
  
  public static class b
    implements rhj.a
  {
    public void a(ValueAnimator paramValueAnimator) {}
    
    public void b(ValueAnimator paramValueAnimator) {}
    
    public void c(ValueAnimator paramValueAnimator) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhj
 * JD-Core Version:    0.7.0.1
 */