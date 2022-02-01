import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView;

public class alyd
  implements Animation.AnimationListener
{
  public alyd(ProviderContainerView paramProviderContainerView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ProviderContainerView.a(this.b) != null)
    {
      ProviderContainerView.a(this.b).setAlpha(1.0F);
      ProviderContainerView.a(this.b).setVisibility(8);
    }
    if ((!this.cBj) && (ProviderContainerView.a(this.b) != null)) {
      ProviderContainerView.a(this.b).by(false, 150);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyd
 * JD-Core Version:    0.7.0.1
 */