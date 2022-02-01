import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.SlidingTabStrip;

public class nse
  extends AnimatorListenerAdapter
{
  public nse(TabLayoutCompat.SlidingTabStrip paramSlidingTabStrip, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.mSelectedPosition = this.val$position;
    this.b.le = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nse
 * JD-Core Version:    0.7.0.1
 */