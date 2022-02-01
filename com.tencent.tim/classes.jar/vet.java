import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class vet
  implements DialogInterface.OnDismissListener
{
  public vet(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LbsBaseActivity.a(this.a))
    {
      this.a.bQr();
      return;
    }
    LbsBaseActivity.a(this.a, this.dS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vet
 * JD-Core Version:    0.7.0.1
 */