import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.b;

public class alya
  implements Animator.AnimatorListener
{
  public alya(ProviderContainerView paramProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.mDivider.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ProviderContainerView.a(this.b) != null) {
      ProviderContainerView.a(this.b).dLq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alya
 * JD-Core Version:    0.7.0.1
 */