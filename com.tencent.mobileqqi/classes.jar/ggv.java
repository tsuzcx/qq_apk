import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

class ggv
  implements Runnable
{
  ggv(ggu paramggu, ImageView paramImageView, TextView paramTextView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new ggw(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ggv
 * JD-Core Version:    0.7.0.1
 */