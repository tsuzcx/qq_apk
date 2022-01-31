import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class wxg
  implements Animation.AnimationListener
{
  wxg(wxe paramwxe) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (wxe.a(this.a) != null)
    {
      wxe.a(this.a).clearAnimation();
      wxe.a(this.a).startAnimation(wxe.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxg
 * JD-Core Version:    0.7.0.1
 */