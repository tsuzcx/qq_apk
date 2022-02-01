import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class uct
  extends aluw
{
  public uct(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((paramDialogInterface != null) && ((paramDialogInterface instanceof Dialog))) {
      ((Dialog)paramDialogInterface).setOnDismissListener(null);
    }
    if (paramDialogInterface == this.this$0.y) {
      this.this$0.y = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uct
 * JD-Core Version:    0.7.0.1
 */