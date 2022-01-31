import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class crj
  implements View.OnClickListener
{
  public crj(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10);
    this.a.b();
    if ((LbsBaseActivity.b(this.a) != null) && (LbsBaseActivity.b(this.a).isShowing())) {
      LbsBaseActivity.b(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crj
 * JD-Core Version:    0.7.0.1
 */