import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginActivity;

public class bmq
  implements DialogInterface.OnCancelListener
{
  public bmq(QRLoginActivity paramQRLoginActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmq
 * JD-Core Version:    0.7.0.1
 */