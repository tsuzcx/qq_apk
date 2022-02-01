import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class cbi
  implements View.OnClickListener
{
  public cbi(ChatHistory paramChatHistory) {}
  
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
    this.a.b(this.a.getString(2131561800));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbi
 * JD-Core Version:    0.7.0.1
 */