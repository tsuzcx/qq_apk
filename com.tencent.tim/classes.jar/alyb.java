import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView;

public class alyb
  implements Animation.AnimationListener
{
  public alyb(ProviderContainerView paramProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (ProviderContainerView.a(this.b) != null)
    {
      ProviderContainerView.a(this.b).setAlpha(1.0F);
      ProviderContainerView.a(this.b).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyb
 * JD-Core Version:    0.7.0.1
 */