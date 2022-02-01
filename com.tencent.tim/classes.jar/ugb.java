import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ugb
  implements CompoundButton.OnCheckedChangeListener
{
  public ugb(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    if (!paramCompoundButton.isPressed())
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = "open_storyset";
      label27:
      rar.a("dynamic_more", (String)localObject, 0, 0, new String[0]);
      localObject = new Integer[5];
      localObject[0] = Integer.valueOf(1);
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      localObject[3] = Integer.valueOf(i);
      this.this$0.app.a().a((Integer[])localObject);
      localObject = (pma)this.this$0.app.getBusinessHandler(98);
      i = j;
      if (paramBoolean) {
        i = 2;
      }
      ((pma)localObject).vG(i);
      break;
      localObject = "close_storyset";
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugb
 * JD-Core Version:    0.7.0.1
 */