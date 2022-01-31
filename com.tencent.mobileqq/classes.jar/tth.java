import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.activity.SpaceLowNoticeActiviy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class tth
  implements DialogInterface.OnClickListener
{
  public tth(SpaceLowNoticeActiviy paramSpaceLowNoticeActiviy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQSettingCleanActivity.a(this.a);
    ReportController.b(this.a.app, "dc00898", "", "", "0X8007546", "0X8007546", 0, 0, this.a.app.getCurrentAccountUin(), "", "", "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tth
 * JD-Core Version:    0.7.0.1
 */