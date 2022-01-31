import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class wfn
  implements DialogInterface.OnDismissListener
{
  public wfn(QRCardActivity paramQRCardActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wfn
 * JD-Core Version:    0.7.0.1
 */