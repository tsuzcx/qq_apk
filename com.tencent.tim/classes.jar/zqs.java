import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;

public class zqs
  implements DialogInterface.OnDismissListener
{
  public zqs(DialogBaseActivity paramDialogBaseActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.progressDialog != null) {
      this.a.progressDialog.setOnDismissListener(null);
    }
    this.a.progressDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqs
 * JD-Core Version:    0.7.0.1
 */