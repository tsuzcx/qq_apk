import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQSettingMe;

public class bfu
  implements DialogInterface.OnDismissListener
{
  public bfu(QQSettingMe paramQQSettingMe) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QQSettingMe.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfu
 * JD-Core Version:    0.7.0.1
 */