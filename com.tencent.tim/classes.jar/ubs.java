import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.TMG.utils.QLog;

class ubs
  implements DialogInterface.OnCancelListener
{
  ubs(ubp paramubp, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.c == null)
    {
      QLog.e("SdkAuthDialog", 1, "cancelListener is null");
      return;
    }
    this.c.onCancel(paramDialogInterface);
    anot.a(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubs
 * JD-Core Version:    0.7.0.1
 */