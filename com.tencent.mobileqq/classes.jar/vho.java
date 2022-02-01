import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class vho
  implements Animation.AnimationListener
{
  vho(vhl paramvhl) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.a != null) {
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vho
 * JD-Core Version:    0.7.0.1
 */