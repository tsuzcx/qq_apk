import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;

public class dtr
  implements DialogInterface.OnDismissListener
{
  public dtr(ThemeSwitchDlgActivity paramThemeSwitchDlgActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ThemeSwitchDlgActivity.a(this.a)) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dtr
 * JD-Core Version:    0.7.0.1
 */