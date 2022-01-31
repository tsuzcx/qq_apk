import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import java.lang.ref.WeakReference;

public class tzg
  implements Runnable
{
  private WeakReference a;
  
  public tzg(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.a = new WeakReference(paramTroopMemberListActivity);
  }
  
  public void run()
  {
    TroopMemberListActivity localTroopMemberListActivity = (TroopMemberListActivity)this.a.get();
    if (localTroopMemberListActivity != null)
    {
      localTroopMemberListActivity.h = false;
      int i = localTroopMemberListActivity.a.getHeight();
      localTroopMemberListActivity.b.offsetTopAndBottom(-i);
      localTroopMemberListActivity.a.setVisibility(0);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTroopMemberListActivity.b.startAnimation(localTranslateAnimation);
      ((InputMethodManager)localTroopMemberListActivity.getSystemService("input_method")).hideSoftInputFromWindow(localTroopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tzg
 * JD-Core Version:    0.7.0.1
 */