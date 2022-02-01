import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;

public class tsm
  implements Animator.AnimatorListener
{
  public tsm(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorBandVideoEntranceButton.b(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tsm
 * JD-Core Version:    0.7.0.1
 */