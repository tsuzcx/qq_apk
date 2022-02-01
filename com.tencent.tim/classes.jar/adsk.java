import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adsk
  implements View.OnClickListener
{
  public adsk(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    ArkIDESettingFragment.a(this.b, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsk
 * JD-Core Version:    0.7.0.1
 */