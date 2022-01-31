import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.NightModeLogic;

public class bll
  implements View.OnClickListener
{
  public bll(ThemeSwitchDlgActivity paramThemeSwitchDlgActivity) {}
  
  public void onClick(View paramView)
  {
    ThemeSwitchDlgActivity.a(this.a, true);
    ThemeSwitchDlgActivity.a(this.a, new NightModeLogic(this.a.getAppRuntime(), this.a));
    ThemeSwitchDlgActivity.a(this.a).registerModeCallback(new blm(this));
    if ((ThemeSwitchDlgActivity.a(this.a) != null) && (ThemeSwitchDlgActivity.a(this.a).isShowing()))
    {
      ThemeSwitchDlgActivity.a(this.a).dismiss();
      ThemeSwitchDlgActivity.a(this.a, null);
    }
    ThemeSwitchDlgActivity.a(this.a).setupNightTheme();
    ReportController.b(ThemeSwitchDlgActivity.a(this.a), "CliOper", "", "", "Setting_tab", "Night_mode_us", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bll
 * JD-Core Version:    0.7.0.1
 */