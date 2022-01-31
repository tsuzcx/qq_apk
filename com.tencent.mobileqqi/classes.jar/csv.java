import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

public class csv
  implements DialogInterface.OnClickListener
{
  public csv(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if ((this.a.a) && (this.a.f == 11)) {
        ForwardRecentActivity.a(this.a).a("-1010", -1, "", this.a.getString(2131560461));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.b, this.a.b.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
    }
    while (paramInt != 0) {
      return;
    }
    this.a.setResult(0);
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.b, this.a.b.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     csv
 * JD-Core Version:    0.7.0.1
 */