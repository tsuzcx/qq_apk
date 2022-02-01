import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class axcx
  implements Animation.AnimationListener
{
  axcx(axcv paramaxcv, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$callback != null) {
      this.val$callback.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    axcv.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcx
 * JD-Core Version:    0.7.0.1
 */