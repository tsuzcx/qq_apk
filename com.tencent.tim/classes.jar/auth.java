import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.DynamicGridView;

public class auth
  implements ValueAnimator.AnimatorUpdateListener
{
  public auth(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auth
 * JD-Core Version:    0.7.0.1
 */