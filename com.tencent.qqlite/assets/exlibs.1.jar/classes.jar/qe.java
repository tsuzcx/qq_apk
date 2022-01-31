import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRJumpActivity;

public class qe
  implements DialogInterface.OnCancelListener
{
  public qe(QRJumpActivity paramQRJumpActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     qe
 * JD-Core Version:    0.7.0.1
 */