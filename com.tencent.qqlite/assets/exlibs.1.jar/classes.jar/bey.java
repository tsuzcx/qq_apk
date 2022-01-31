import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bey
  implements View.OnClickListener
{
  public bey(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a(), QQSettingSettingActivity.class);
    this.a.a(paramView);
    ReportController.b(this.a.a, "CliOper", "", "", "Setting_tab", "My_settab", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bey
 * JD-Core Version:    0.7.0.1
 */