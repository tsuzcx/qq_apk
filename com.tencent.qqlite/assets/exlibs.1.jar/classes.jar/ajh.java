import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class ajh
  implements DialogInterface.OnDismissListener
{
  public ajh(DiscussionMemberActivity paramDiscussionMemberActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager, FriendListObserver paramFriendListObserver) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.getHandler().postDelayed(new aji(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ajh
 * JD-Core Version:    0.7.0.1
 */