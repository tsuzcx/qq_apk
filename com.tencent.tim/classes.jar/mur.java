import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class mur
  extends AnimatorListenerAdapter
{
  mur(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$view.setLayerType(0, null);
    this.val$view.setVisibility(8);
    this.val$view.setTranslationY(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mur
 * JD-Core Version:    0.7.0.1
 */