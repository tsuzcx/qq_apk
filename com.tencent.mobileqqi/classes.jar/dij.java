import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class dij
  implements DialogInterface.OnDismissListener
{
  public dij(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dij
 * JD-Core Version:    0.7.0.1
 */