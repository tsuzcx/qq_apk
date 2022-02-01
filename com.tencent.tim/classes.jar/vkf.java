import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class vkf
  implements Handler.Callback
{
  public vkf(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          bool = false;
          return bool;
        }
      }
      finally {}
      boolean bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.g(this.this$0).setChecked(bool);
      break label163;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.a(this.this$0, paramMessage);
      break label163;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.b(this.this$0, paramMessage);
      break label163;
      bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.h(this.this$0).setChecked(bool);
      break label163;
      NotifyPushSettingActivity.i(this.this$0).setChecked(((Boolean)paramMessage.obj).booleanValue());
      label163:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkf
 * JD-Core Version:    0.7.0.1
 */