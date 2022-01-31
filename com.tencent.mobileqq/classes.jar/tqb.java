import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class tqb
  implements CompoundButton.OnCheckedChangeListener
{
  public tqb(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.b.setVisibility(0);
      SoundAndVibrateActivity.d(this.a).setBackgroundResource(2130838631);
      if (this.a.app.b() == 0)
      {
        this.a.b.setChecked(false);
        this.a.app.f(1);
        label64:
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label153;
        }
      }
    }
    for (;;)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      return;
      this.a.b.setChecked(true);
      break;
      this.a.b.setVisibility(8);
      SoundAndVibrateActivity.d(this.a).setBackgroundResource(2130838619);
      this.a.app.f(0);
      break label64;
      label153:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqb
 * JD-Core Version:    0.7.0.1
 */