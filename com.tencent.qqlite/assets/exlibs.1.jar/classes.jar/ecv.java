import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

class ecv
  implements Runnable
{
  ecv(ecu paramecu, ImageView paramImageView, TextView paramTextView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new ecw(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecv
 * JD-Core Version:    0.7.0.1
 */