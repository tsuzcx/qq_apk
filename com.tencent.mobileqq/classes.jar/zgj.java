import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class zgj
  implements Animation.AnimationListener
{
  zgj(zgh paramzgh, Context paramContext) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
        this.jdField_a_of_type_Zgh.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Zgh.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgj
 * JD-Core Version:    0.7.0.1
 */