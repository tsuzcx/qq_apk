import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ufv
  implements CompoundButton.OnCheckedChangeListener
{
  public ufv(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!aqiw.isNetSupport(this.this$0.getActivity()))
    {
      AssistantSettingActivity.a(this.this$0, 2131696348, 1);
      AssistantSettingActivity localAssistantSettingActivity = this.this$0;
      if (!paramBoolean) {
        AssistantSettingActivity.a(localAssistantSettingActivity, bool, this);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((CardHandler)this.this$0.app.getBusinessHandler(2)).EF(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufv
 * JD-Core Version:    0.7.0.1
 */