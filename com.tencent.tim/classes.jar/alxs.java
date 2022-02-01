import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class alxs
  implements Animation.AnimationListener
{
  public alxs(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$container.setVisibility(8);
    if (this.val$position == CaptureVideoFilterViewPager.a(this.this$0)) {
      CaptureVideoFilterViewPager.a(this.this$0, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxs
 * JD-Core Version:    0.7.0.1
 */