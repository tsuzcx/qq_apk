import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vct
  implements CompoundButton.OnCheckedChangeListener
{
  public vct(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    Object localObject = this.a;
    String str = this.a.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      i = 2;
      GesturePWDUtils.setGesturePWDState((Context)localObject, str, i);
      this.a.xs(paramBoolean);
      localObject = this.a.app;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = j;; i = 0)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Setting_Gesture_password", 0, i, "", "", "", "");
      this.a.bPG();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vct
 * JD-Core Version:    0.7.0.1
 */