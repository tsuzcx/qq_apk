import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.a;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.b;
import java.util.Iterator;
import java.util.List;

public class alyc
  implements Animator.AnimatorListener
{
  public alyc(ProviderContainerView paramProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.mDivider.setVisibility(8);
    paramAnimator = ProviderContainerView.a(this.b);
    if (paramAnimator != null) {
      paramAnimator.dKp();
    }
    if (ProviderContainerView.a(this.b) != null)
    {
      paramAnimator = ProviderContainerView.a(this.b).iterator();
      while (paramAnimator.hasNext()) {
        ((ProviderContainerView.a)paramAnimator.next()).dKp();
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ProviderContainerView.a(this.b) != null) {
      ProviderContainerView.a(this.b).dLr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyc
 * JD-Core Version:    0.7.0.1
 */