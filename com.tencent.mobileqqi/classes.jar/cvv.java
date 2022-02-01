import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.MayKnowManActivity;

public class cvv
  implements DialogInterface.OnCancelListener
{
  public cvv(MayKnowManActivity paramMayKnowManActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvv
 * JD-Core Version:    0.7.0.1
 */