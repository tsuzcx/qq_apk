import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HornListActivity;
import com.tencent.mobileqq.activity.HornPublishActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;

public class cwk
  implements View.OnClickListener
{
  public cwk(HornListActivity paramHornListActivity) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    if (this.a.a != null)
    {
      localQQAppInterface = this.a.b;
      if (!VipUtils.a(this.a.b)) {
        break label81;
      }
    }
    label81:
    for (paramView = "1";; paramView = "0")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_enterHornCreate", 0, 0, "isSvip", paramView, "", "");
      paramView = new Intent(this.a, HornPublishActivity.class);
      this.a.startActivityForResult(paramView, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwk
 * JD-Core Version:    0.7.0.1
 */