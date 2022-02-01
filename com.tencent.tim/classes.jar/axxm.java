import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class axxm
  implements Animation.AnimationListener
{
  public axxm(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QIMProviderContainerView.a(this.this$0) != null)
    {
      QIMProviderContainerView.a(this.this$0).setAlpha(1.0F);
      QIMProviderContainerView.a(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxm
 * JD-Core Version:    0.7.0.1
 */