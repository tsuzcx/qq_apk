import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class vgn
  implements Animation.AnimationListener
{
  vgn(vgl paramvgl) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    vgl.a(this.a, true);
    vgl.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgn
 * JD-Core Version:    0.7.0.1
 */