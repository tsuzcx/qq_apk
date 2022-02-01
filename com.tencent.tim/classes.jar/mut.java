import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class mut
  extends AnimatorListenerAdapter
{
  mut(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$view.setAlpha(1.0F);
    this.val$view.setLayerType(0, null);
    this.val$view.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mut
 * JD-Core Version:    0.7.0.1
 */