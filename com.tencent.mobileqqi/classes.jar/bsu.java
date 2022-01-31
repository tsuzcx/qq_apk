import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginActivity;

public class bsu
  implements DialogInterface.OnCancelListener
{
  public bsu(QRLoginActivity paramQRLoginActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bsu
 * JD-Core Version:    0.7.0.1
 */