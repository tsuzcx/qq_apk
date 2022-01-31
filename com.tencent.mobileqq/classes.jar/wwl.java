import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class wwl
  implements Animation.AnimationListener
{
  wwl(wwk paramwwk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (wwk.a(this.a) != null)
    {
      wwk.a(this.a).clearAnimation();
      wwk.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wwl
 * JD-Core Version:    0.7.0.1
 */