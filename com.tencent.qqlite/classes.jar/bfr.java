import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQSettingMe;

public class bfr
  implements DialogInterface.OnDismissListener
{
  public bfr(QQSettingMe paramQQSettingMe) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QQSettingMe.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfr
 * JD-Core Version:    0.7.0.1
 */