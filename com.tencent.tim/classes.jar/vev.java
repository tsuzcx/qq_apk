import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vev
  implements View.OnClickListener
{
  public vev(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ajrb.D(this.a.getAppInterface().getAccount(), true);
    if ((LbsBaseActivity.a(this.a) != null) && (LbsBaseActivity.a(this.a).isShowing())) {
      this.a.c(LbsBaseActivity.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vev
 * JD-Core Version:    0.7.0.1
 */