import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ShortcutGuideDialogActivity;

public class dif
  implements DialogInterface.OnClickListener
{
  public dif(ShortcutGuideDialogActivity paramShortcutGuideDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dif
 * JD-Core Version:    0.7.0.1
 */