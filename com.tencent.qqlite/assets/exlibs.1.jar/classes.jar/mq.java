import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.eqq.EnterpriseDetailActivity;

public class mq
  implements DialogInterface.OnDismissListener
{
  public mq(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    EnterpriseDetailActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mq
 * JD-Core Version:    0.7.0.1
 */