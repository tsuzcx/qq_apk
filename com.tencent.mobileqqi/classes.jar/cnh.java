import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.DialogActivity;

public class cnh
  implements DialogInterface.OnCancelListener
{
  public cnh(DialogActivity paramDialogActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnh
 * JD-Core Version:    0.7.0.1
 */