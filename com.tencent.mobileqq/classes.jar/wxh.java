import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class wxh
  implements Animation.AnimationListener
{
  wxh(wxe paramwxe) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (wxe.a(this.a) != null) {
      wxe.a(this.a).setVisibility(4);
    }
    if (wxe.a(this.a) != null) {
      wxe.a(this.a).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxh
 * JD-Core Version:    0.7.0.1
 */