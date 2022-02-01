import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;

public class zxl
  implements DialogInterface.OnClickListener
{
  public zxl(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QRLoginMgrActivity.a(this.a, true, 0L);
    bdll.b(null, "dc00898", "", "", "0X800A478", "0X800A478", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxl
 * JD-Core Version:    0.7.0.1
 */