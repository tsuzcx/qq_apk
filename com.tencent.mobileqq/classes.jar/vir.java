import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class vir
  implements Animation.AnimationListener
{
  vir(vip paramvip) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    vip.a(this.a, true);
    vip.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vir
 * JD-Core Version:    0.7.0.1
 */