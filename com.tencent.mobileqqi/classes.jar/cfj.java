import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;

public class cfj
  implements Animation.AnimationListener
{
  public cfj(Conversation paramConversation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((Conversation.a(this.a)) && (paramAnimation == this.a.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[this.a.Z]))
    {
      paramAnimation = this.a;
      paramAnimation.Z += 1;
      if ((this.a.Z >= 0) && (this.a.Z < this.a.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation.length))
      {
        this.a.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[this.a.Z].reset();
        Conversation.a(this.a).startAnimation(this.a.jdField_a_of_type_ArrayOfAndroidViewAnimationTranslateAnimation[this.a.Z]);
      }
    }
    else
    {
      return;
    }
    paramAnimation = this.a;
    paramAnimation.Y += 1;
    if (this.a.Y % 2 == 0)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1029, 800L);
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1029, 160L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfj
 * JD-Core Version:    0.7.0.1
 */