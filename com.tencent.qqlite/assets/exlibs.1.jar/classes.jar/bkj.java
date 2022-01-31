import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class bkj
  implements CompoundButton.OnCheckedChangeListener
{
  public bkj(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      SoundAndVibrateActivity.c(this.a).setVisibility(0);
      this.a.b.setVisibility(0);
      if (this.a.app.c() == 0)
      {
        this.a.b.setChecked(false);
        this.a.app.f(1);
        label63:
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label152;
        }
      }
    }
    for (;;)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      return;
      this.a.b.setChecked(true);
      break;
      SoundAndVibrateActivity.c(this.a).setVisibility(8);
      this.a.b.setVisibility(8);
      this.a.app.f(0);
      break label63;
      label152:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bkj
 * JD-Core Version:    0.7.0.1
 */