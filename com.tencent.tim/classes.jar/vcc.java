import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

public class vcc
  implements CompoundButton.OnCheckedChangeListener
{
  public vcc(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = this.this$0.a.a().isChecked();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(this.this$0.app, false, null);
    int j = anlm.Kd();
    int i;
    if ((bool1) && (bool2))
    {
      i = anlm.dJU;
      if (!paramBoolean) {
        break label142;
      }
      String str = anlj.gS[i];
      if (!aogc.a(this.this$0, str, new vcd(this, paramCompoundButton, bool1, i))) {
        GeneralSettingActivity.a(this.this$0, paramCompoundButton, true, bool1, i);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = j;
      if (!bool1) {
        break;
      }
      i = j;
      if (!ThemeUtil.isNowThemeIsNight(this.this$0.app, false, anlj.gS[j])) {
        break;
      }
      i = anlm.Ke();
      break;
      label142:
      GeneralSettingActivity.a(this.this$0, paramCompoundButton, false, bool1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcc
 * JD-Core Version:    0.7.0.1
 */