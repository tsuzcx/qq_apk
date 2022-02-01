import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.nearby.widget.AutoScrollImageView;

public class akkf
  implements ValueAnimator.AnimatorUpdateListener
{
  public akkf(AutoScrollImageView paramAutoScrollImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AutoScrollImageView.a(this.b, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkf
 * JD-Core Version:    0.7.0.1
 */