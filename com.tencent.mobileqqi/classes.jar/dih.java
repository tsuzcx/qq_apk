import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.ShortcutGuideDialogActivity;
import com.tencent.mobileqq.utils.QQUtils;

public class dih
  implements DialogInterface.OnClickListener
{
  public dih(ShortcutGuideDialogActivity paramShortcutGuideDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQUtils.a(this.a.b, ShortcutGuideDialogActivity.a(this.a), ShortcutGuideDialogActivity.b(this.a), this.a.d(), new Handler(), 500, "1");
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dih
 * JD-Core Version:    0.7.0.1
 */