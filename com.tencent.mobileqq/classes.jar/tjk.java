import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.qphone.base.util.QLog;

public class tjk
  implements DialogInterface.OnDismissListener
{
  public tjk(PayBridgeActivity paramPayBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qwallet.payPayBridgeActivity", 4, "finish dialog dismiss...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjk
 * JD-Core Version:    0.7.0.1
 */