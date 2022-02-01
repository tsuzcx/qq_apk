import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class ajhp
  extends AnimatorListenerAdapter
{
  public ajhp(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiAIOFragment.e(this.this$0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiAIOFragment.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhp
 * JD-Core Version:    0.7.0.1
 */