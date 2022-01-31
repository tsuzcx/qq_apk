import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class adq
  implements View.OnClickListener
{
  public adq(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adq
 * JD-Core Version:    0.7.0.1
 */