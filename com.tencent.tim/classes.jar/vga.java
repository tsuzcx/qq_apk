import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vga
  implements CompoundButton.OnCheckedChangeListener
{
  public vga(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.this$0.D.a())
    {
      ((ajqy)this.this$0.app.getBusinessHandler(66)).Mh(paramBoolean);
      this.this$0.app.reportClickEvent("CliOper", "0X8006729");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramCompoundButton == this.this$0.S.a())
      {
        this.this$0.app.bD(true, paramBoolean);
      }
      else
      {
        QQAppInterface localQQAppInterface;
        String str;
        if (paramCompoundButton == this.this$0.R.a())
        {
          localQQAppInterface = this.this$0.app;
          if (paramBoolean) {}
          for (str = "1";; str = "0")
          {
            anot.a(localQQAppInterface, "dc00898", "", "", "0X8007614", "0X8007614", 0, 0, str, "", "", "");
            this.this$0.c.Ex(paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == this.this$0.T.a())
        {
          localQQAppInterface = this.this$0.app;
          if (paramBoolean) {}
          for (str = "1";; str = "2")
          {
            anot.a(localQQAppInterface, "dc00898", "", "", "0X800791B", "0X800791B", 0, 0, str, "", "", "");
            this.this$0.c.Ev(paramBoolean);
            if (paramBoolean) {
              break label249;
            }
            this.this$0.R.setVisibility(8);
            break;
          }
          label249:
          this.this$0.R.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vga
 * JD-Core Version:    0.7.0.1
 */