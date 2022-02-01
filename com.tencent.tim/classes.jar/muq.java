import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class muq
  extends AnimatorListenerAdapter
{
  muq(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$view.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     muq
 * JD-Core Version:    0.7.0.1
 */