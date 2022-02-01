import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class aylh
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, aylh.a parama)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parama, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, aylh.a parama, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new ayli(parama));
    paramValueAnimator.addListener(new aylj(parama, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
  
  public static abstract interface a
  {
    public abstract void a(ValueAnimator paramValueAnimator);
    
    public abstract void b(ValueAnimator paramValueAnimator);
    
    public abstract void c(ValueAnimator paramValueAnimator);
    
    public abstract void onAnimationUpdate(ValueAnimator paramValueAnimator);
  }
  
  public static class b
    implements aylh.a
  {
    public void a(ValueAnimator paramValueAnimator) {}
    
    public void b(ValueAnimator paramValueAnimator) {}
    
    public void c(ValueAnimator paramValueAnimator) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylh
 * JD-Core Version:    0.7.0.1
 */