import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRJumpActivity;

public class bsr
  implements DialogInterface.OnCancelListener
{
  public bsr(QRJumpActivity paramQRJumpActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bsr
 * JD-Core Version:    0.7.0.1
 */