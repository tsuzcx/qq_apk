import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

public class run
  implements DialogInterface.OnCancelListener
{
  public run(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.this$0.ach) {
      return;
    }
    this.this$0.atU = -1;
    this.this$0.ach = true;
    QRDisplayActivity.a(this.this$0).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     run
 * JD-Core Version:    0.7.0.1
 */