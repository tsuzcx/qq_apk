import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

class xlu
  implements Animation.AnimationListener
{
  xlu(xls paramxls, URLImageView paramURLImageView, URLDrawable paramURLDrawable, ScaleAnimation paramScaleAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xlu
 * JD-Core Version:    0.7.0.1
 */