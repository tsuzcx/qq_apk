import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class yzl
  implements Animation.AnimationListener
{
  yzl(yzk paramyzk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new yzm(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzl
 * JD-Core Version:    0.7.0.1
 */