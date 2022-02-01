import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class jac
  implements DialogInterface.OnCancelListener
{
  public jac(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.this$0.a(this.kQ, "onClickCancel", true, null, -1);
    this.this$0.kd("onClickCancel");
    aqji.c.SF(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jac
 * JD-Core Version:    0.7.0.1
 */