import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.MayKnowManActivity;

public class avf
  implements DialogInterface.OnCancelListener
{
  public avf(MayKnowManActivity paramMayKnowManActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avf
 * JD-Core Version:    0.7.0.1
 */