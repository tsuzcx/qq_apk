import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;

class vzd
  implements Animation.AnimationListener
{
  vzd(vzc paramvzc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.a.c = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzd
 * JD-Core Version:    0.7.0.1
 */