import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.QIMProviderContainerView.b;

public class axxo
  implements Animation.AnimationListener
{
  public axxo(QIMProviderContainerView paramQIMProviderContainerView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMProviderContainerView.a(this.this$0) != null)
    {
      QIMProviderContainerView.a(this.this$0).setAlpha(1.0F);
      QIMProviderContainerView.a(this.this$0).setVisibility(8);
    }
    if ((!this.dxk) && (QIMProviderContainerView.a(this.this$0) != null)) {
      QIMProviderContainerView.a(this.this$0).by(false, 150);
    }
    if (QIMProviderContainerView.a(this.this$0) != null) {
      QIMProviderContainerView.a(this.this$0).eFt();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxo
 * JD-Core Version:    0.7.0.1
 */