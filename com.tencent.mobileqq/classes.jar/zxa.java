import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRJumpActivity;

public class zxa
  implements DialogInterface.OnCancelListener
{
  public zxa(QRJumpActivity paramQRJumpActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxa
 * JD-Core Version:    0.7.0.1
 */