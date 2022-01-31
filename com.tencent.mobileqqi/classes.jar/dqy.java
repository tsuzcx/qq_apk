import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class dqy
  implements DialogInterface.OnDismissListener
{
  public dqy(TroopMemberListActivity paramTroopMemberListActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.findViewById(2131234622).getHandler().postDelayed(new dqz(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqy
 * JD-Core Version:    0.7.0.1
 */