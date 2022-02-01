import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class jti
  implements Animation.AnimationListener
{
  jti(jtg paramjtg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.a.iO.setVisibility(0);
    this.this$0.a.iO.startAnimation(this.this$0.s);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jti
 * JD-Core Version:    0.7.0.1
 */