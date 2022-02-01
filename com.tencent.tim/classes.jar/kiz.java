import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kiz
  implements CompoundButton.OnCheckedChangeListener
{
  public kiz(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.this$0, paramBoolean);
    int i;
    label51:
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      QQToast.a(this.this$0.getBaseContext(), 2, 2131718533, 2000).show();
      ReadInJoySettingActivity.a(this.this$0).setText(2131718532);
      if (!paramBoolean) {
        break label159;
      }
      i = 1;
      awit.acy(i);
      awit.bP(paramBoolean);
      awit.Xg(true);
      localQQAppInterface = this.this$0.app;
      if (!paramBoolean) {
        break label164;
      }
      str1 = "0X8008236";
      label81:
      if (!paramBoolean) {
        break label171;
      }
    }
    label159:
    label164:
    label171:
    for (String str2 = "0X8008236";; str2 = "0X8008235")
    {
      kbp.a(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "", "", "", "", false);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      QQToast.a(this.this$0.getBaseContext(), 2, 2131718531, 2000).show();
      ReadInJoySettingActivity.a(this.this$0).setText(2131718535);
      break;
      i = 0;
      break label51;
      str1 = "0X8008235";
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kiz
 * JD-Core Version:    0.7.0.1
 */