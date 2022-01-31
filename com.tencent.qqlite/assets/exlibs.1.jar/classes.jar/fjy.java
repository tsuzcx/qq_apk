import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.plugin.IPluginManager;

public final class fjy
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    IPluginManager.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjy
 * JD-Core Version:    0.7.0.1
 */