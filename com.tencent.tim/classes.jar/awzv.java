import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class awzv
  implements Animation.AnimationListener
{
  public awzv(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.e.setAlpha(1.0F);
    this.e.setVisibility(8);
    if (AEProviderContainerView.a(this.e) != null) {
      AEProviderContainerView.a(this.e).by(false, 150);
    }
    if (AEProviderContainerView.a(this.e) != null) {
      AEProviderContainerView.a(this.e).p(131075, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzv
 * JD-Core Version:    0.7.0.1
 */