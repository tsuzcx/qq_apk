import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class blk
  implements View.OnClickListener
{
  public blk(ThemeSwitchDlgActivity paramThemeSwitchDlgActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ThemeSwitchDlgActivity.a(this.a) != null) && (ThemeSwitchDlgActivity.a(this.a).isShowing()))
    {
      ThemeSwitchDlgActivity.a(this.a).dismiss();
      ThemeSwitchDlgActivity.a(this.a, null);
    }
    ReportController.b(ThemeSwitchDlgActivity.a(this.a), "CliOper", "", "", "Setting_tab", "Night_mode_us", 0, 0, "0", "", "", "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     blk
 * JD-Core Version:    0.7.0.1
 */