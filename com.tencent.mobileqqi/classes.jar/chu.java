import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;

public class chu
  implements Animation.AnimationListener
{
  public chu(DiscussionMemberActivity paramDiscussionMemberActivity, TranslateAnimation paramTranslateAnimation, Dialog paramDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chu
 * JD-Core Version:    0.7.0.1
 */