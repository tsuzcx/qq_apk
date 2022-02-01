import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class vpc
  implements DialogInterface.OnDismissListener
{
  public vpc(QQMapActivity paramQQMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.aZE) && (!this.a.aZF) && (!this.a.aZD)) {
      this.a.finish();
    }
    this.a.aZF = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpc
 * JD-Core Version:    0.7.0.1
 */