import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qzone.TranslucentActivity;

public class igv
  implements DialogInterface.OnDismissListener
{
  public igv(TranslucentActivity paramTranslucentActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     igv
 * JD-Core Version:    0.7.0.1
 */