import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class cxs
  implements View.OnClickListener
{
  public cxs(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if ((LbsBaseActivity.c(this.a) != null) && (LbsBaseActivity.c(this.a).isShowing())) {
      LbsBaseActivity.c(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxs
 * JD-Core Version:    0.7.0.1
 */