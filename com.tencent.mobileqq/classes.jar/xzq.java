import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;

public class xzq
  implements DialogInterface.OnCancelListener
{
  public xzq(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xzq
 * JD-Core Version:    0.7.0.1
 */