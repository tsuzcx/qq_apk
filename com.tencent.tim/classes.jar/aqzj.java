import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class aqzj
  implements Animation.AnimationListener
{
  aqzj(aqzi paramaqzi, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)this.val$v.getLayoutParams();
    paramAnimation.leftMargin = this.a.left;
    paramAnimation.topMargin = this.a.top;
    this.val$v.setLayoutParams(paramAnimation);
    this.val$v.clearAnimation();
    this.val$v.setVisibility(0);
    this.a.isDrag = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzj
 * JD-Core Version:    0.7.0.1
 */