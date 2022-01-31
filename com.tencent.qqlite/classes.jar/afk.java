import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class afk
  implements Runnable
{
  public afk(ChatSettingForTroop paramChatSettingForTroop, View paramView) {}
  
  public void run()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297090);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.ao, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(800L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new afl(this, localLinearLayout));
    localLinearLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afk
 * JD-Core Version:    0.7.0.1
 */