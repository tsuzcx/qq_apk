import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class adu
  implements View.OnClickListener
{
  public adu(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.a > this.a.b)
    {
      this.a.a = l;
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adu
 * JD-Core Version:    0.7.0.1
 */