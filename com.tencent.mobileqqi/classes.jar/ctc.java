import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

class ctc
  implements Runnable
{
  ctc(ctb paramctb, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Ctb.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Ctb.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
      this.jdField_a_of_type_Ctb.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_Ctb.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      return;
    }
    this.jdField_a_of_type_Ctb.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ctc
 * JD-Core Version:    0.7.0.1
 */