import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.TMG.utils.QLog;

class zuz
  implements DialogInterface.OnKeyListener
{
  zuz(zuv paramzuv, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null)
      {
        QLog.e("SdkAuthDialog", 1, "keyListener is null");
        return true;
      }
      this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener.onCancel(paramDialogInterface);
      this.jdField_a_of_type_Zuv.a();
      awqx.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zuz
 * JD-Core Version:    0.7.0.1
 */