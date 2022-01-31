import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class tng
  implements ActionSheet.OnButtonClickListener
{
  public tng(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.app, "CliOper", "", "", "Setting_tab", "Clean_chat_log", 0, 0, "0", "0", "", "");
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.showDialog(1);
    }
    paramView = new tnh(this);
    ThreadManager.getSubThreadHandler().post(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tng
 * JD-Core Version:    0.7.0.1
 */