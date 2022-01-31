import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class cil
  implements View.OnClickListener
{
  public cil(ChatHistory paramChatHistory) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cil
 * JD-Core Version:    0.7.0.1
 */