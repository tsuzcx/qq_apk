import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

public class djn
  implements DialogInterface.OnClickListener
{
  public djn(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clk_clean_msg", 0, 0, "", "", "", "");
    if (!this.a.isFinishing())
    {
      paramDialogInterface.dismiss();
      this.a.showDialog(1);
    }
    ThreadManager.b(new djo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     djn
 * JD-Core Version:    0.7.0.1
 */