import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class yxd
  implements Animation.AnimationListener
{
  yxd(yxc paramyxc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new yxe(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxd
 * JD-Core Version:    0.7.0.1
 */