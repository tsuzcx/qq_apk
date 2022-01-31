import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class ckm
  implements DialogInterface.OnCancelListener
{
  public ckm(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ckm
 * JD-Core Version:    0.7.0.1
 */