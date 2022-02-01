import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class zwi
  implements DialogInterface.OnDismissListener
{
  public zwi(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.h = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwi
 * JD-Core Version:    0.7.0.1
 */