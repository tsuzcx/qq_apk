import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatActivity;

class bzf
  implements Runnable
{
  bzf(bze parambze) {}
  
  public void run()
  {
    if ((ChatActivity.b(this.a.a.a) != null) && (ChatActivity.b(this.a.a.a).getParent() != null)) {
      ((ViewGroup)ChatActivity.b(this.a.a.a).getParent()).removeView(ChatActivity.b(this.a.a.a));
    }
    ChatActivity.b(this.a.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzf
 * JD-Core Version:    0.7.0.1
 */