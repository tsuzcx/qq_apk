import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

class ggw
  implements Runnable
{
  ggw(ggv paramggv, ImageView paramImageView, TextView paramTextView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new ggx(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ggw
 * JD-Core Version:    0.7.0.1
 */