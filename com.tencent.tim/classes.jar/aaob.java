import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;

public class aaob
  implements DialogInterface.OnDismissListener
{
  public aaob(TimLoginQQView paramTimLoginQQView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    TimLoginQQView.e(this.this$0, false);
    TimLoginQQView.f(this.this$0, false);
    anot.a(this.this$0.mAppInterface, "new_reg_805", "log_page", "can_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaob
 * JD-Core Version:    0.7.0.1
 */