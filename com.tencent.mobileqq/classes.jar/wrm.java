import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class wrm
  implements Animation.AnimationListener
{
  wrm(wrj paramwrj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    wrj.a(this.a).setVisibility(8);
    wrj.a(this.a).setAlpha(1.0F);
    wrj.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrm
 * JD-Core Version:    0.7.0.1
 */