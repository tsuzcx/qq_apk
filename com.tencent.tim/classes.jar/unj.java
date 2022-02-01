import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class unj
  implements View.OnClickListener
{
  public unj(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.this$0.iu > 1000L)
    {
      this.this$0.iu = l;
      this.this$0.gX();
      anot.a(this.this$0.app, "CliOper", "", "", "0X800568D", "0X800568D", this.this$0.bFk, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unj
 * JD-Core Version:    0.7.0.1
 */