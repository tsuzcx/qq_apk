import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;

public class vtw
  implements DialogInterface.OnCancelListener
{
  public vtw(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vtw
 * JD-Core Version:    0.7.0.1
 */