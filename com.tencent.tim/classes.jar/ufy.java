import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ufy
  implements CompoundButton.OnCheckedChangeListener
{
  public ufy(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!aqiw.isNetSupport(this.this$0))
    {
      AssistantSettingActivity.a(this.this$0, 2131696346, 1);
      localObject = this.this$0;
      if (!paramBoolean) {
        bool = true;
      }
      AssistantSettingActivity.b((AssistantSettingActivity)localObject, bool);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, (String)localObject, "", "", "");
      this.this$0.a.Bo(paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufy
 * JD-Core Version:    0.7.0.1
 */