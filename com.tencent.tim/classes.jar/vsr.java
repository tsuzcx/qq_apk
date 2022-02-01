import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.RiskHintDlgFragment;

public class vsr
  implements DialogInterface.OnDismissListener
{
  public vsr(RiskHintDlgFragment paramRiskHintDlgFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().finish();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsr
 * JD-Core Version:    0.7.0.1
 */