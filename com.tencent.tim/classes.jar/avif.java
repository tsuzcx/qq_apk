import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import cooperation.qlink.QlinkStandardDialogActivity;

public class avif
  implements DialogInterface.OnClickListener
{
  public avif(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.dnd) {
      if (this.dne) {
        ahav.a(this.a, null, 777, false, 0);
      }
    }
    for (;;)
    {
      this.a.finish();
      return;
      ahav.a(this.a, null, 888, false, 0);
      continue;
      paramDialogInterface = new Intent(this.a, ScannerActivity.class);
      paramDialogInterface.putExtra("from", "qlink");
      this.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avif
 * JD-Core Version:    0.7.0.1
 */