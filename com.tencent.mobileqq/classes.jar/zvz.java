import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class zvz
  implements DialogInterface.OnDismissListener
{
  public zvz(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((paramDialogInterface != null) && ((paramDialogInterface instanceof Dialog))) {
      ((Dialog)paramDialogInterface).setOnDismissListener(null);
    }
    if (paramDialogInterface == this.a.c) {
      this.a.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zvz
 * JD-Core Version:    0.7.0.1
 */