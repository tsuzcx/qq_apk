import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class vwi
  implements DialogInterface.OnDismissListener
{
  public vwi(SubLoginActivity paramSubLoginActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.ach = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwi
 * JD-Core Version:    0.7.0.1
 */