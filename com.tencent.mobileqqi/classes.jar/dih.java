import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ShortcutGuideDialogActivity;

public class dih
  implements DialogInterface.OnDismissListener
{
  public dih(ShortcutGuideDialogActivity paramShortcutGuideDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dih
 * JD-Core Version:    0.7.0.1
 */