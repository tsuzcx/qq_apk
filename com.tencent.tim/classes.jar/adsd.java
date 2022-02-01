import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsd
  implements CompoundButton.OnCheckedChangeListener
{
  public adsd(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.cUg();
      this.b.GQ("");
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("IDEDebug is open", new Object[0]));
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.b.cUh();
      this.b.GQ("close");
      ArkAppCenter.r("ArkApp.DebugOnlineActivity", String.format("IDEDebug is close", new Object[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsd
 * JD-Core Version:    0.7.0.1
 */