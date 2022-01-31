import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qzone.TranslucentActivity;

public class icb
  implements DialogInterface.OnDismissListener
{
  public icb(TranslucentActivity paramTranslucentActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icb
 * JD-Core Version:    0.7.0.1
 */