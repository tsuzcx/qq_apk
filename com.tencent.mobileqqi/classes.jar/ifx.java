import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class ifx
  implements DialogInterface.OnClickListener
{
  public ifx(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QlinkStandardDialogActivity.a(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ifx
 * JD-Core Version:    0.7.0.1
 */