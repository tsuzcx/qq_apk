import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class zsf
  implements Animation.AnimationListener
{
  zsf(zsd paramzsd, Context paramContext) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
        this.jdField_a_of_type_Zsd.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Zsd.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsf
 * JD-Core Version:    0.7.0.1
 */