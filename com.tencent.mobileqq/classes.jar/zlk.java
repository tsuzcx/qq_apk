import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;

public class zlk
  implements DialogInterface.OnCancelListener
{
  public zlk(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlk
 * JD-Core Version:    0.7.0.1
 */