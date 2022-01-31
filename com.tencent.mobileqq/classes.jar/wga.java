import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class wga
  implements DialogInterface.OnCancelListener
{
  public wga(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.f) {
      return;
    }
    this.a.h = -1;
    this.a.f = true;
    QRDisplayActivity.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */