import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

public class ddw
  implements DialogInterface.OnClickListener
{
  public ddw(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_clean_msg", 0, 0, "", "", "", "");
    if (!this.a.isFinishing())
    {
      paramDialogInterface.dismiss();
      this.a.showDialog(1);
    }
    ThreadManager.b(new ddx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddw
 * JD-Core Version:    0.7.0.1
 */