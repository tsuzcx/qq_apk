import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class aogd
  implements DialogInterface.OnClickListener
{
  aogd(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aogc.report("0X800A5B5");
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "showDarkModeTips systemDarMode  = " + this.cLx);
    }
    aogc.QM(true);
    aogc.b(this.cLx, this.avT, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogd
 * JD-Core Version:    0.7.0.1
 */