import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DirectForwardActivity;

class ahkv
  implements DialogInterface.OnDismissListener
{
  ahkv(ahkr paramahkr) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.this$0.mActivity instanceof DirectForwardActivity)) {
      this.this$0.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkv
 * JD-Core Version:    0.7.0.1
 */