import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class cij
  implements View.OnClickListener
{
  public cij(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cij
 * JD-Core Version:    0.7.0.1
 */