import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.phone.BaseActivityView;

public class zpr
  implements DialogInterface.OnDismissListener
{
  public zpr(BaseActivityView paramBaseActivityView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.progressDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpr
 * JD-Core Version:    0.7.0.1
 */