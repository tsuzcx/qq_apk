import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class zjz
  implements DialogInterface.OnDismissListener
{
  public zjz(QRCardActivity paramQRCardActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjz
 * JD-Core Version:    0.7.0.1
 */