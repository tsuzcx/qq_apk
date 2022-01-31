import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.MyAppApi;
import mqq.os.MqqHandler;

public class ukr
  implements DialogInterface.OnClickListener
{
  public ukr(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 3, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, 1, 3, 200));
    if (!MyAppApi.a().b()) {
      ToastUtil.a().a("应用宝未安装，请重新安装应用宝");
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new uks(this), 500L);
      return;
      NewUpgradeDialog.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukr
 * JD-Core Version:    0.7.0.1
 */