import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginActivity;

public class qh
  implements DialogInterface.OnCancelListener
{
  public qh(QRLoginActivity paramQRLoginActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     qh
 * JD-Core Version:    0.7.0.1
 */