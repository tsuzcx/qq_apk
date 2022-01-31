import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

class vuz
  implements Animation.AnimationListener
{
  vuz(vuy paramvuy) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.a.jdField_a_of_type_AndroidWidgetImageView.getWidth() / 2, this.a.jdField_a_of_type_AndroidWidgetImageView.getHeight() / 2);
    paramAnimation.addAnimation(this.a.b);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(paramAnimation);
    paramAnimation.setAnimationListener(this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuz
 * JD-Core Version:    0.7.0.1
 */