import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class bpu
  implements DialogInterface.OnClickListener
{
  public bpu(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(BaseApplication.getContext())) {
      TroopRequestActivity.a(this.a);
    }
    for (;;)
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "black", 0, 0, this.a.p, TroopRequestActivity.e(this.a), "", "");
      return;
      QQToast.a(this.a, 2131363516, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bpu
 * JD-Core Version:    0.7.0.1
 */