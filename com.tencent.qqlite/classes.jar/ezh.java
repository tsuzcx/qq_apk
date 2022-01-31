import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ezh
  implements Animation.AnimationListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Ezg.a.getBackground();
  
  ezh(ezg paramezg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ezg.a.clearAnimation();
    this.jdField_a_of_type_Ezg.a.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Ezg.a.setBackgroundResource(17170443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ezh
 * JD-Core Version:    0.7.0.1
 */