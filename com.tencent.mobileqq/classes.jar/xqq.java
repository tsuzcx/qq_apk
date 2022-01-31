import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class xqq
  implements Animation.AnimationListener
{
  xqq(xqo paramxqo, Context paramContext) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
        this.jdField_a_of_type_Xqo.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Xqo.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqq
 * JD-Core Version:    0.7.0.1
 */