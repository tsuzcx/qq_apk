import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class mup
  extends AnimatorListenerAdapter
{
  mup(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.val$view.setTag(2131362727, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mup
 * JD-Core Version:    0.7.0.1
 */