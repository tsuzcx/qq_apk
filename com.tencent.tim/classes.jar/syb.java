import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class syb
  implements Animation.AnimationListener
{
  syb(sya paramsya) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.textView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.this$0.c.isAnimating()) {
      this.this$0.textView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     syb
 * JD-Core Version:    0.7.0.1
 */