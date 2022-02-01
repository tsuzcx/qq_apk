import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ura
  implements View.OnClickListener
{
  public ura(ChatTextSizeSettingActivity paramChatTextSizeSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131379548: 
    default: 
      this.a.bFT = 0;
    }
    for (;;)
    {
      this.a.Ay(this.a.bFT);
      anot.a(this.a.app, "CliOper", "", "", "Trends_tab", "Font_size", 0, 0, Integer.toString(this.a.bFT), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.bFT = 1;
      continue;
      this.a.bFT = 2;
      continue;
      this.a.bFT = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ura
 * JD-Core Version:    0.7.0.1
 */