import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;

public class xqr
  implements ValueAnimator.AnimatorUpdateListener
{
  public xqr(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    RecentOptPopBar.a(this.a).getLayoutParams().height = i;
    RecentOptPopBar.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqr
 * JD-Core Version:    0.7.0.1
 */