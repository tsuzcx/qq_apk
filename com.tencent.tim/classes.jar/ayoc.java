import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;

class ayoc
  implements ValueAnimator.AnimatorUpdateListener
{
  ayoc(ayob paramayob) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    this.b.Gv = paramValueAnimator;
    this.b.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayoc
 * JD-Core Version:    0.7.0.1
 */