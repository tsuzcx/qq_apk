import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;

public class zxd
  implements DialogInterface.OnCancelListener
{
  public zxd(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxd
 * JD-Core Version:    0.7.0.1
 */