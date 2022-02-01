import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopTransferActivity;

public class weu
  implements DialogInterface.OnDismissListener
{
  public weu(TroopTransferActivity paramTroopTransferActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    try
    {
      this.this$0.mRootView.offsetTopAndBottom(-this.dS);
      this.this$0.mTitleBar.setVisibility(0);
      this.this$0.mRootView.startAnimation(this.c);
      paramDialogInterface = (InputMethodManager)this.this$0.getSystemService("input_method");
      if (paramDialogInterface != null) {
        paramDialogInterface.hideSoftInputFromWindow(this.this$0.getWindow().peekDecorView().getWindowToken(), 0);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     weu
 * JD-Core Version:    0.7.0.1
 */