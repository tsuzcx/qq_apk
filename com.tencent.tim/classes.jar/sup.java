import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

class sup
  implements Animation.AnimationListener
{
  sup(sun paramsun, URLImageView paramURLImageView, URLDrawable paramURLDrawable, ScaleAnimation paramScaleAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.ac.setImageDrawable(this.r);
    this.ac.startAnimation(this.i);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sup
 * JD-Core Version:    0.7.0.1
 */