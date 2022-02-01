import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ude
  implements CompoundButton.OnCheckedChangeListener
{
  public ude(AccountManageActivity paramAccountManageActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.this$0, this.this$0.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", paramBoolean);
    ((anxr)this.this$0.app.getManager(61)).eg(this.this$0.app);
    QQAppInterface localQQAppInterface = this.this$0.app;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800AC3A", "0X800AC3A", 0, 0, i + "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ude
 * JD-Core Version:    0.7.0.1
 */