import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;

public class vqm
  implements DialogInterface.OnDismissListener
{
  public vqm(QQTranslucentBrowserActivity paramQQTranslucentBrowserActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqm
 * JD-Core Version:    0.7.0.1
 */