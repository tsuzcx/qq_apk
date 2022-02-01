import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class aamx
  implements DialogInterface.OnDismissListener
{
  public aamx(LoginView paramLoginView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginView.g(this.this$0, false);
    LoginView.h(this.this$0, false);
    anot.a(this.this$0.mAppInterface, "new_reg_805", "log_page", "can_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamx
 * JD-Core Version:    0.7.0.1
 */