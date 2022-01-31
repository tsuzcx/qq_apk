import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class vtw
  implements Animation.AnimationListener
{
  public vtw(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.R = false;
    this.a.jdField_o_of_type_Int = 0;
    this.a.S = false;
    this.a.ab = false;
    this.a.aa = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(this.a.jdField_o_of_type_AndroidViewView, PublicAccountChatPie.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtw
 * JD-Core Version:    0.7.0.1
 */