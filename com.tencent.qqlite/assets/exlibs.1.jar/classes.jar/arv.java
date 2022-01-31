import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class arv
  implements View.OnClickListener
{
  public arv(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if ((LbsBaseActivity.b(this.a) != null) && (LbsBaseActivity.b(this.a).isShowing())) {
      LbsBaseActivity.b(this.a).dismiss();
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     arv
 * JD-Core Version:    0.7.0.1
 */