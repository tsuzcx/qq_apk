import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class unf
  implements View.OnClickListener
{
  public unf(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.this$0.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unf
 * JD-Core Version:    0.7.0.1
 */