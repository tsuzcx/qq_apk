import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

public class xus
  implements DialogInterface.OnCancelListener
{
  public xus(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.f) {
      return;
    }
    this.a.h = -1;
    this.a.f = true;
    QRDisplayActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xus
 * JD-Core Version:    0.7.0.1
 */