import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class afaw
  implements DialogInterface.OnClickListener
{
  afaw(afat paramafat) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    QLog.d(afat.access$100(), 1, "showConfirmDialog, cancel click");
    anot.a(this.this$0.mApp, "CliOper", "", this.this$0.mUin, afat.bCB, afat.bCB, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afaw
 * JD-Core Version:    0.7.0.1
 */