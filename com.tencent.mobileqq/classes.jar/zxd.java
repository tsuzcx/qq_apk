import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class zxd
  implements Animation.AnimationListener
{
  zxd(zxb paramzxb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (zxb.a(this.a) != null)
    {
      zxb.a(this.a).clearAnimation();
      zxb.a(this.a).startAnimation(zxb.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxd
 * JD-Core Version:    0.7.0.1
 */