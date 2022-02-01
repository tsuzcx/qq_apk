import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.h.b;
import com.tencent.widget.RoundRectImageView;

public class xux
  implements Animation.AnimationListener
{
  public xux(PhotoListPanel.h.b paramb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.a.a.getWidth() / 2, this.a.a.getHeight() / 2);
    paramAnimation.addAnimation(this.a.jdField_t_of_type_AndroidViewAnimationAlphaAnimation);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.a.a.startAnimation(paramAnimation);
    paramAnimation.setAnimationListener(this.a.jdField_t_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xux
 * JD-Core Version:    0.7.0.1
 */