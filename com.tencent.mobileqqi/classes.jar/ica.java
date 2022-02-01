import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qzone.TranslucentActivity;

public class ica
  implements DialogInterface.OnDismissListener
{
  public ica(TranslucentActivity paramTranslucentActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ica
 * JD-Core Version:    0.7.0.1
 */