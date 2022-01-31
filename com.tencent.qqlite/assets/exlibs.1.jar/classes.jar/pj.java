import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class pj
  implements DialogInterface.OnDismissListener
{
  public pj(QRCardActivity paramQRCardActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pj
 * JD-Core Version:    0.7.0.1
 */