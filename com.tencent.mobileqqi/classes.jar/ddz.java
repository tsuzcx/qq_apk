import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

public class ddz
  implements DialogInterface.OnClickListener
{
  public ddz(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.b, "CliOper", "", "", "Setting_tab", "Clean_chat_log", 0, 0, "", "", "", "");
    if (!this.a.isFinishing()) {
      this.a.showDialog(1);
    }
    ThreadManager.b(new dea(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddz
 * JD-Core Version:    0.7.0.1
 */