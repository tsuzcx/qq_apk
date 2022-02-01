import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;

public class nsc
  implements ValueAnimator.AnimatorUpdateListener
{
  public nsc(TabLayoutCompat paramTabLayoutCompat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.c.scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsc
 * JD-Core Version:    0.7.0.1
 */