import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class dec
  implements DialogInterface.OnClickListener
{
  public dec(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.b, "P_CliOper", "", "", "mp_msg_sys_16", "lixian_redelete", 0, 0, "", "", "", "");
    if (!this.a.isFinishing())
    {
      paramDialogInterface.cancel();
      this.a.showDialog(1);
    }
    if (Build.VERSION.SDK_INT > 15) {}
    try
    {
      paramDialogInterface = new WebView(this.a);
      paramDialogInterface.clearCache(true);
      paramDialogInterface.clearFormData();
      paramDialogInterface.clearSslPreferences();
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramDialogInterface.removeJavascriptInterface("searchBoxJavaBridge_");
        paramDialogInterface.removeJavascriptInterface("accessibility");
        paramDialogInterface.removeJavascriptInterface("accessibilityTraversal");
      }
      paramDialogInterface.clearHistory();
      paramDialogInterface.clearMatches();
      paramDialogInterface.destroy();
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssitantSettingActivity", 2, "clear webview cache got exception:" + paramDialogInterface.getMessage());
        }
      }
    }
    ThreadManager.b(new ded(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dec
 * JD-Core Version:    0.7.0.1
 */