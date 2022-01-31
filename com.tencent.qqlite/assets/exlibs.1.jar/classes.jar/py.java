import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class py
  implements DialogInterface.OnDismissListener
{
  public py(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     py
 * JD-Core Version:    0.7.0.1
 */