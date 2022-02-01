import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class lrz
  implements Animator.AnimatorListener
{
  lrz(lry paramlry) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    lry.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    lry.a(this.a).setSelected(this.a.isSelected());
    lry.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    lry.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrz
 * JD-Core Version:    0.7.0.1
 */