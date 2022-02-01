import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ump
  implements View.OnClickListener
{
  public ump(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bJK();
    anot.a(this.this$0.app, "CliOper", "", "", "0X800568E", "0X800568E", this.this$0.bFk, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ump
 * JD-Core Version:    0.7.0.1
 */