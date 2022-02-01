import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class zxe
  implements Animation.AnimationListener
{
  zxe(zxb paramzxb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (zxb.a(this.a) != null) {
      zxb.a(this.a).setVisibility(4);
    }
    if (zxb.a(this.a) != null) {
      zxb.a(this.a).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxe
 * JD-Core Version:    0.7.0.1
 */