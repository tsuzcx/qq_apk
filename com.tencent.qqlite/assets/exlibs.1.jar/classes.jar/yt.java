import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AuthDevActivity;

public class yt
  implements DialogInterface.OnDismissListener
{
  public yt(AuthDevActivity paramAuthDevActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == AuthDevActivity.a(this.a)) {
      AuthDevActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     yt
 * JD-Core Version:    0.7.0.1
 */