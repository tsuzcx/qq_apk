import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.eqq.EnterpriseDetailActivity;

public class box
  implements DialogInterface.OnDismissListener
{
  public box(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    EnterpriseDetailActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     box
 * JD-Core Version:    0.7.0.1
 */