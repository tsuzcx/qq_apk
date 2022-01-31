import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class wgd
  implements DialogInterface.OnCancelListener
{
  public wgd(QRDisplayActivity paramQRDisplayActivity) {}
  
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
 * Qualified Name:     wgd
 * JD-Core Version:    0.7.0.1
 */