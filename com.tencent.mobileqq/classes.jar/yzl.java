import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class yzl
  implements Animation.AnimationListener
{
  yzl(yzj paramyzj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (yzj.a(this.a) != null)
    {
      yzj.a(this.a).clearAnimation();
      yzj.a(this.a).startAnimation(yzj.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzl
 * JD-Core Version:    0.7.0.1
 */