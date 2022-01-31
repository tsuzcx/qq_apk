import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardOperations;

class amq
  implements DialogInterface.OnDismissListener
{
  amq(amn paramamn) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a.a instanceof DirectForwardActivity)) {
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     amq
 * JD-Core Version:    0.7.0.1
 */