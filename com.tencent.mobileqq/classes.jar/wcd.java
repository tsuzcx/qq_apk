import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class wcd
  implements Animation.AnimationListener
{
  public wcd(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.R = false;
    this.a.aa = false;
    this.a.c(this.a.jdField_o_of_type_AndroidViewView);
    this.a.jdField_o_of_type_Int = 1;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcd
 * JD-Core Version:    0.7.0.1
 */