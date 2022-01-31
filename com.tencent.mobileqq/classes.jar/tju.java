import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import mqq.os.MqqHandler;

public class tju
  implements ActionSheet.OnButtonClickListener
{
  public tju(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.isFinishing())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.showDialog(1);
    }
    try
    {
      QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.app.getLongAccountUin());
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actCleanCacheData", true, 0L, 0L, null, null);
      if (WebProcessManager.c())
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity, WebProcessReceiver.class);
        paramView.setAction("action_clear_cache");
        this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMsgHistoryActivity.sendBroadcast(paramView, "com.tencent.msg.permission.pushnotify");
        paramView = new tjv(this);
        ThreadManager.getSubThreadHandler().post(paramView);
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.w("IphoneTitleBarActivity", 1, "onQQClearLocalCache error.", paramView);
        continue;
        WebAccelerateHelper.getSonicEngine().cleanCache();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tju
 * JD-Core Version:    0.7.0.1
 */