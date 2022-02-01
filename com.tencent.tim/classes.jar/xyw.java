import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

class xyw
  implements Animation.AnimationListener
{
  xyw(xyv paramxyv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.this$0.xn != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.this$0.mContext, 2130772298);
      paramAnimation.setAnimationListener(this);
      this.a.this$0.xn.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyw
 * JD-Core Version:    0.7.0.1
 */