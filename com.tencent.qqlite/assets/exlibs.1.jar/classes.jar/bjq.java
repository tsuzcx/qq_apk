import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class bjq
  implements DialogInterface.OnClickListener
{
  public bjq(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjq
 * JD-Core Version:    0.7.0.1
 */