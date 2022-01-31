import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;

public class adr
  implements Animation.AnimationListener
{
  public adr(ChatHistory paramChatHistory, View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.show();
    this.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.b.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adr
 * JD-Core Version:    0.7.0.1
 */