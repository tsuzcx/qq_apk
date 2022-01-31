import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCarePersonActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class cye
  implements View.OnClickListener
{
  public cye(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QvipSpecialCarePersonActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(this.a.b, "CliOper", "", "", "Special_remind", "Clk_special_remind", 80, 0, "", "", "", "");
    PreferenceManager.getDefaultSharedPreferences(this.a).edit().putBoolean("spcial_care_qq_setting", false).commit();
    NotifyPushSettingActivity.a(this.a).setRightIcon(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cye
 * JD-Core Version:    0.7.0.1
 */