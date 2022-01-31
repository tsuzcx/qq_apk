import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class fht
  implements DialogInterface.OnDismissListener
{
  private WeakReference a;
  
  public fht(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.a = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.a.get();
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Q.dating", 2, "CustomDismissListener, lis is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fht
 * JD-Core Version:    0.7.0.1
 */