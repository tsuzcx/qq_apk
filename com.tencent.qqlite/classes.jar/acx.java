import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class acx
  implements View.OnClickListener
{
  public acx(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = this.a.a(this.a.b, this.a.a, localStringBuilder);
    Object localObject = null;
    paramView = localObject;
    if (localStringBuilder != null)
    {
      paramView = localObject;
      if (localStringBuilder.length() > 0) {
        paramView = localStringBuilder.toString();
      }
    }
    if (i > 0)
    {
      this.a.a(paramView);
      return;
    }
    this.a.b(this.a.getString(2131363397));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     acx
 * JD-Core Version:    0.7.0.1
 */