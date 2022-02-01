import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsc
  implements CompoundButton.OnCheckedChangeListener
{
  public adsc(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AboutActivity.zF(5);
      if (!this.b.sU().equals("close")) {
        this.b.cUg();
      }
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is opened and IDE debug is also open ,state=%s", new Object[] { AboutActivity.oJ() }));
      ArkAppCenter.GH(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      AboutActivity.zF(0);
      this.b.cUh();
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is closed and IDE debug is also closed,state=%s", new Object[] { AboutActivity.oJ() }));
      ArkAppCenter.GH(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsc
 * JD-Core Version:    0.7.0.1
 */