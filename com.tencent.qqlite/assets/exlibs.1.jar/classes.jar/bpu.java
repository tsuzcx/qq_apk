import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class bpu
  implements View.OnClickListener
{
  public bpu(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext())) {}
    try
    {
      paramView = this.a.app.a();
      ProfileCardUtil.a(this.a, "", TroopRequestActivity.d(this.a), paramView, false);
      for (;;)
      {
        label38:
        ReportController.b(this.a.app, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "report", 0, 0, this.a.p, TroopRequestActivity.e(this.a), "", "");
        return;
        QQToast.a(this.a, 2131363515, 0).b(this.a.getTitleBarHeight());
      }
    }
    catch (Exception paramView)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bpu
 * JD-Core Version:    0.7.0.1
 */