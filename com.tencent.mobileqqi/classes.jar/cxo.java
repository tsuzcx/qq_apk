import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class cxo
  implements View.OnClickListener
{
  public cxo(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if ((LbsBaseActivity.b(this.a) != null) && (LbsBaseActivity.b(this.a).isShowing())) {
      LbsBaseActivity.b(this.a).dismiss();
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxo
 * JD-Core Version:    0.7.0.1
 */