import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

public class kjb
  implements CompoundButton.OnCheckedChangeListener
{
  public kjb(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity localReadInJoySettingActivity = this.this$0;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      ReadInJoySettingActivity.a(localReadInJoySettingActivity, bool);
      if ((!ReadInJoySettingActivity.a(this.this$0).isPressed()) || (this.this$0.afI)) {
        break label87;
      }
      if (paramBoolean) {
        break label74;
      }
      ReadInJoySettingActivity.b(this.this$0, ReadInJoySettingActivity.a(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      label74:
      ReadInJoySettingActivity.a(this.this$0).show();
      continue;
      label87:
      this.this$0.afI = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjb
 * JD-Core Version:    0.7.0.1
 */