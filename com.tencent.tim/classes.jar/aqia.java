import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;

class aqia
  implements DialogInterface.OnDismissListener
{
  aqia(aqhv paramaqhv) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.this$0.context instanceof LoginActivity)) {
      ((LoginActivity)this.this$0.context).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqia
 * JD-Core Version:    0.7.0.1
 */