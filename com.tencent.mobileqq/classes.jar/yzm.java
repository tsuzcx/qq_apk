import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class yzm
  implements Animation.AnimationListener
{
  yzm(yzj paramyzj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (yzj.a(this.a) != null) {
      yzj.a(this.a).setVisibility(4);
    }
    if (yzj.a(this.a) != null) {
      yzj.a(this.a).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzm
 * JD-Core Version:    0.7.0.1
 */