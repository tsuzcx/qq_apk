import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class arjr
  implements Animation.AnimationListener
{
  arjr(View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new arik(this.JI);
    paramAnimation.setDuration(arjq.access$000());
    paramAnimation.setFillAfter(true);
    this.JI.startAnimation(paramAnimation);
    this.JI.setVisibility(0);
    this.JJ.clearAnimation();
    this.JJ.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.JI.clearAnimation();
    this.JI.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjr
 * JD-Core Version:    0.7.0.1
 */