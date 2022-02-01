import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zfe
  implements DialogInterface.OnDismissListener
{
  public zfe(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (zli)paramDialogInterface;
    paramDialogInterface.Vv();
    int i = paramDialogInterface.getRecordCount();
    paramDialogInterface = (achs)this.this$0.mApp.getManager(92);
    if (QLog.isColorLevel()) {
      QLog.i("Q.history.C2CAllFragment", 2, "onDismiss, recordCount : " + i + ",showRoamFlag" + paramDialogInterface.aaT());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfe
 * JD-Core Version:    0.7.0.1
 */