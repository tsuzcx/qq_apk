import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class crm
  implements View.OnClickListener
{
  public crm(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b.d(true);
    if ((LbsBaseActivity.c(this.a) != null) && (LbsBaseActivity.c(this.a).isShowing())) {
      LbsBaseActivity.c(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crm
 * JD-Core Version:    0.7.0.1
 */