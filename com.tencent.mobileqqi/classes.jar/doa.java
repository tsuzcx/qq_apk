import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;

public class doa
  implements DialogInterface.OnDismissListener
{
  public doa(ThemeSwitchDlgActivity paramThemeSwitchDlgActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ThemeSwitchDlgActivity.a(this.a)) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     doa
 * JD-Core Version:    0.7.0.1
 */