import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShortcutUtils.4;

public class aswx
  implements DialogInterface.OnClickListener
{
  public aswx(ShortcutUtils.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("Shortcut", 2, "confirm");
    aswu.openPermissionActivity(this.a.val$activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswx
 * JD-Core Version:    0.7.0.1
 */