import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class syc
  implements Animation.AnimationListener
{
  syc(sya paramsya) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.textView.clearAnimation();
    this.this$0.textView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     syc
 * JD-Core Version:    0.7.0.1
 */