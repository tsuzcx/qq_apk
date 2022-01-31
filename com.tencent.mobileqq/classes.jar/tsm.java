import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class tsm
  implements DialogInterface.OnDismissListener
{
  public tsm(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsm
 * JD-Core Version:    0.7.0.1
 */