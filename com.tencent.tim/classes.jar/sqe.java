import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class sqe
  implements Animation.AnimationListener
{
  sqe(sqc paramsqc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (sqc.a(this.b) != null)
    {
      sqc.a(this.b).clearAnimation();
      sqc.a(this.b).startAnimation(sqc.a(this.b));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqe
 * JD-Core Version:    0.7.0.1
 */