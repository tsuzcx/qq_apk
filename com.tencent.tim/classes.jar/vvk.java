import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vvk
  implements CompoundButton.OnCheckedChangeListener
{
  public vvk(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    label61:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      SoundAndVibrateActivity.b(this.a, 0);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839701);
      if (this.a.app.AH() == 0)
      {
        this.a.aG.setChecked(false);
        this.a.app.JC(1);
        localQQAppInterface = this.a.app;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    for (;;)
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.a.aG.setChecked(true);
      break;
      SoundAndVibrateActivity.b(this.a, 8);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839682);
      this.a.app.JC(0);
      break label61;
      label157:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */