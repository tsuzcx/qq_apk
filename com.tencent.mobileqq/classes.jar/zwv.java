import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class zwv
  implements DialogInterface.OnDismissListener
{
  public zwv(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.h = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwv
 * JD-Core Version:    0.7.0.1
 */