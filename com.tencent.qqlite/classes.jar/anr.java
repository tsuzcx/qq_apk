import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

public class anr
  implements DialogInterface.OnClickListener
{
  public anr(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if ((this.a.b) && (this.a.f == 11)) {
        ForwardRecentActivity.a(this.a).a("-1010", -1, "", this.a.getString(2131362373));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.app, this.a.app.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
    }
    while (paramInt != 0) {
      return;
    }
    this.a.setResult(0);
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.app, this.a.app.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anr
 * JD-Core Version:    0.7.0.1
 */