import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.qphone.base.util.QLog;

public class agy
  implements Animation.AnimationListener
{
  public agy(Conversation paramConversation, View paramView, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation).show();
    this.jdField_a_of_type_AndroidViewView.setAnimation(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, "conversationTab search up anim time: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agy
 * JD-Core Version:    0.7.0.1
 */