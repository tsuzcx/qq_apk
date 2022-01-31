import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.DialogActivity;

public class aim
  implements DialogInterface.OnCancelListener
{
  public aim(DialogActivity paramDialogActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aim
 * JD-Core Version:    0.7.0.1
 */