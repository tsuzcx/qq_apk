import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.TMG.utils.QLog;

class ubt
  implements DialogInterface.OnKeyListener
{
  ubt(ubp paramubp, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      if (this.c == null)
      {
        QLog.e("SdkAuthDialog", 1, "keyListener is null");
        return true;
      }
      this.c.onCancel(paramDialogInterface);
      this.b.bFi();
      anot.a(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubt
 * JD-Core Version:    0.7.0.1
 */