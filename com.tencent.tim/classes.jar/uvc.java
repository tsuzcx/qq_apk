import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.activity.DiscussionMemberActivity.3.1;

public class uvc
  implements DialogInterface.OnDismissListener
{
  public uvc(DiscussionMemberActivity paramDiscussionMemberActivity, int paramInt, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager, acfd paramacfd) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.mRootView.getHandler().postDelayed(new DiscussionMemberActivity.3.1(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvc
 * JD-Core Version:    0.7.0.1
 */