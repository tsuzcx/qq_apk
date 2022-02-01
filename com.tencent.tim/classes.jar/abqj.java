import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class abqj
  implements Animation.AnimationListener
{
  abqj(abqi paramabqi, View paramView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqj
 * JD-Core Version:    0.7.0.1
 */