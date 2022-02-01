import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ugd
  implements CompoundButton.OnCheckedChangeListener
{
  public ugd(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    label43:
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      i = 1;
      awit.acy(i);
      awit.bP(paramBoolean);
      awit.Xg(true);
      if (!paramBoolean) {
        break label108;
      }
      QQToast.a(this.this$0.getBaseContext(), 2, 2131718533, 2000).show();
      localQQAppInterface = this.this$0.app;
      if (!paramBoolean) {
        break label131;
      }
      str1 = "0X8008236";
      label60:
      if (!paramBoolean) {
        break label138;
      }
    }
    label131:
    label138:
    for (String str2 = "0X8008236";; str2 = "0X8008235")
    {
      kbp.a(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "", "", "", "", false);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label108:
      QQToast.a(this.this$0.getBaseContext(), 2, 2131718531, 2000).show();
      break label43;
      str1 = "0X8008235";
      break label60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugd
 * JD-Core Version:    0.7.0.1
 */