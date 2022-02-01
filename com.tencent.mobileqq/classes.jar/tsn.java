import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;

public class tsn
  implements Animator.AnimatorListener
{
  public tsn(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ColorBandVideoEntranceButton.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorBandVideoEntranceButton.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    ColorBandVideoEntranceButton.a(this.a).setVisibility(8);
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tsn
 * JD-Core Version:    0.7.0.1
 */