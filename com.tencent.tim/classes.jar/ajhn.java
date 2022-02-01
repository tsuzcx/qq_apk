import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class ajhn
  extends AnimatorListenerAdapter
{
  public ajhn(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiAIOFragment.a(this.this$0, this.Be);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiAIOFragment.a(this.this$0, this.Be);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhn
 * JD-Core Version:    0.7.0.1
 */