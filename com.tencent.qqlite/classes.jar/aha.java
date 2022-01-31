import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.Conversation;

public class aha
  implements DialogInterface.OnDismissListener
{
  public aha(Conversation paramConversation, View paramView, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     aha
 * JD-Core Version:    0.7.0.1
 */