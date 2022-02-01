import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class lsa
  implements Animator.AnimatorListener
{
  lsa(lry paramlry) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    lry.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    lry.a(this.a, false);
    lry.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsa
 * JD-Core Version:    0.7.0.1
 */