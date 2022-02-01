import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class aogf
  implements DialogInterface.OnClickListener
{
  aogf(aogc.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aogc.report("0X800A5CB");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showThemeDarkModeTips");
    }
    aogc.QM(false);
    if (this.a != null) {
      this.a.onConfirm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogf
 * JD-Core Version:    0.7.0.1
 */