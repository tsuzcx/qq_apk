import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class tpn
  implements DialogInterface.OnClickListener
{
  public tpn(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpn
 * JD-Core Version:    0.7.0.1
 */