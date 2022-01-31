import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.richstatus.EditActivity;

public class ebs
  implements DialogInterface.OnDismissListener
{
  public ebs(EditActivity paramEditActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.c != 0) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebs
 * JD-Core Version:    0.7.0.1
 */