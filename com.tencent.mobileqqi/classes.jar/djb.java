import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class djb
  implements CompoundButton.OnCheckedChangeListener
{
  public djb(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.b.d(1);
      paramCompoundButton = this.a.b;
      if (!paramBoolean) {
        break label68;
      }
    }
    for (;;)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_grpshake", 0, i, "", "", "", "");
      return;
      this.a.b.d(0);
      break;
      label68:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     djb
 * JD-Core Version:    0.7.0.1
 */