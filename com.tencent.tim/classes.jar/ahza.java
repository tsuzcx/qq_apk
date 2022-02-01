import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;

public class ahza
  implements Animator.AnimatorListener
{
  public ahza(HotPicMainPanel paramHotPicMainPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.b.k != null) && (this.b.k.isShowing())) {
      this.b.k.dismiss();
    }
    this.b.DC.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahza
 * JD-Core Version:    0.7.0.1
 */