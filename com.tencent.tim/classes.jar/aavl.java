import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;

public class aavl
  implements ValueAnimator.AnimatorUpdateListener
{
  public aavl(RotationSeekBar paramRotationSeekBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotationSeekBar.b(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavl
 * JD-Core Version:    0.7.0.1
 */