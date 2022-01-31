import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class bsm
  implements DialogInterface.OnDismissListener
{
  public bsm(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bsm
 * JD-Core Version:    0.7.0.1
 */