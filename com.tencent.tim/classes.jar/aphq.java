import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aphq
  implements CompoundButton.OnCheckedChangeListener
{
  public aphq(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("口算开关状态改变 ");
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (String str = "on";; str = "off")
    {
      QLog.d("PublishHomeWorkFragment", 2, str);
      this.this$0.cQB = paramBoolean;
      if (this.this$0.cQB) {
        this.this$0.bu.setChecked(true);
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphq
 * JD-Core Version:    0.7.0.1
 */