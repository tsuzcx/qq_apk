import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardOperations;

public class amx
  implements DialogInterface.OnDismissListener
{
  public amx(ForwardOperations paramForwardOperations) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof DirectForwardActivity)) {
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     amx
 * JD-Core Version:    0.7.0.1
 */