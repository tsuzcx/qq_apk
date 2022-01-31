import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class brw
  implements DialogInterface.OnDismissListener
{
  public brw(QRCardActivity paramQRCardActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     brw
 * JD-Core Version:    0.7.0.1
 */