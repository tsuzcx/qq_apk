import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

public class bfw
  implements DialogInterface.OnClickListener
{
  public bfw(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_clean_msg", 0, 0, "", "", "", "");
    if (!this.a.isFinishing()) {
      this.a.showDialog(1);
    }
    ThreadManager.b(new bfx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bfw
 * JD-Core Version:    0.7.0.1
 */