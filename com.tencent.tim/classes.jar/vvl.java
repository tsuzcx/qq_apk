import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vvl
  implements CompoundButton.OnCheckedChangeListener
{
  public vvl(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      this.a.app.Jz(1);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label78;
      }
    }
    for (;;)
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_notice_gupsound", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.a.app.Jz(0);
      break;
      label78:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vvl
 * JD-Core Version:    0.7.0.1
 */