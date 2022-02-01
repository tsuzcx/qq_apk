import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.PublicAccountListActivity;

public class vnf
  implements DialogInterface.OnDismissListener
{
  public vnf(PublicAccountListActivity paramPublicAccountListActivity, int paramInt, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.this$0.rS.setTag("");
    this.this$0.aaC = false;
    this.this$0.mRootView.offsetTopAndBottom(-this.dS);
    this.this$0.mTitleBar.setVisibility(0);
    this.this$0.mRootView.startAnimation(this.c);
    this.b.hideSoftInputFromWindow(this.this$0.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnf
 * JD-Core Version:    0.7.0.1
 */