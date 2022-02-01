import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class igu
  implements DialogInterface.OnClickListener
{
  igu(igs paramigs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (igs.a(this.a) != null) {
      igs.a(this.a).onCancel();
    }
    if (QLog.isColorLevel()) {
      QLog.i("RealNameVideoProcessHelper", 2, "showRealNameDialog click cancel.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igu
 * JD-Core Version:    0.7.0.1
 */