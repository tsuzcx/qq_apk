import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class mzo
  implements Animation.AnimationListener
{
  mzo(mzn parammzn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    mzn.a(this.this$0).startAnimation(mzn.a(this.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzo
 * JD-Core Version:    0.7.0.1
 */