import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class dck
  implements DialogInterface.OnDismissListener
{
  public dck(QQMapActivity paramQQMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.i) && (!this.a.j) && (!this.a.h)) {
      this.a.finish();
    }
    this.a.j = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dck
 * JD-Core Version:    0.7.0.1
 */