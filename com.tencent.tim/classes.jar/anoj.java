import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.LocalCrashCollector;
import com.tencent.mobileqq.statistics.LocalCrashCollector.3;
import com.tencent.widget.XEditTextEx;

public class anoj
  implements DialogInterface.OnClickListener
{
  public anoj(LocalCrashCollector.3 param3, SessionInfo paramSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0) > 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ != 1) {
          break label106;
        }
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).app.a().aV("/data/data/com.tencent.tim/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl);
      }
      for (;;)
      {
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).a.setText("");
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).delete(0, LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).length());
        paramDialogInterface.dismiss();
        return;
        label106:
        LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).app.a().a("/data/data/com.tencent.tim/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.aTl, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.cZ, true);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anoj
 * JD-Core Version:    0.7.0.1
 */